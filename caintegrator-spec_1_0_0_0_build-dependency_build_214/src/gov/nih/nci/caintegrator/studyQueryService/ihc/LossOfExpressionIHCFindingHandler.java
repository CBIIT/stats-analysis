package gov.nih.nci.caintegrator.studyQueryService.ihc;

import gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean.LevelOfExpressionIHCFinding;
import gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean.LossOfExpressionIHCFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.LossOfExpressionIHCFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.protein.ProteinBiomarkerCriteia;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.protein.ProteinBiomarkerHandler;
import gov.nih.nci.caintegrator.studyQueryService.study.SpecimenHandler;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class LossOfExpressionIHCFindingHandler extends IHCFindingHandler {
	
	 private static Logger logger = Logger.getLogger(LossOfExpressionIHCFindingHandler.class);
	
	
	 protected Class getFindingType() {
	   return LossOfExpressionIHCFinding.class;
      }
	
     protected StringBuilder handleCriteria(SpecimenBasedMolecularFindingCriteria inCriteria,
             HashMap<String, Object> inParams,
             Session inSession) {
    	
    	 logger.debug("Entering handler for  LossOfExpressionIHCFindingHandler");
    	 LossOfExpressionIHCFindingCriteria theCriteria = (LossOfExpressionIHCFindingCriteria) inCriteria;
    	 
    	 
    	 StringBuilder theHQL = new StringBuilder();
    	 
    	  // Start of the where clause
    	 
     	 theHQL.append(" select lossIHC.specimen.patientDID||lossIHC.proteinBiomarker.id from LossOfExpressionIHCFinding as lossIHC LEFT JOIN lossIHC.proteinBiomarker LEFT JOIN lossIHC.specimen ");  
    	 
                         
         String theANDString = " WHERE ";        
       
         
         
        /////////////////////////////////////////////////////
         // Handle invasive sum number
         /////////////////////////////////////////////////////
         if (theCriteria.getInvasiveSum() != null)
         {
        	  System.out.println("ihc invasive range: " + theCriteria.getInvasiveSumOperator() + theCriteria.getInvasiveSum());
              theHQL.append(theANDString + " lossIHC.invasiveSum "+theCriteria.getInvasiveSumOperator()+ " " + theCriteria.getInvasiveSum());
              theANDString = " AND ";
         }  
         
         
         /////////////////////////////////////////////////////
         // Handle benign sum number
         /////////////////////////////////////////////////////
         if (theCriteria.getBenignSum() != null)
         {
              System.out.println("ihc benign range: " + theCriteria.getBenignSumOperator() + theCriteria.getBenignSum());
              theHQL.append(theANDString + " lossIHC.benignSum "+theCriteria.getBenignSumOperator()+ " " + theCriteria.getBenignSum());
              theANDString = " AND ";
         }
         
         /////////////////////////////////////////////////////
         // Handle result code
         /////////////////////////////////////////////////////
         if (theCriteria.getResultCodeCollection() != null && theCriteria.getResultCodeCollection().size() > 0)
         {
             theHQL.append(theANDString + " lossIHC.lossResult IN (:lossIHC_lossResult) ");
             inParams.put("lossIHC_lossResult", theCriteria.getResultCodeCollection());
             theANDString = " AND ";
         }         
         
         
         logger.info("HQL: " + theHQL.toString());
         logger.debug("Exiting handleCriteria");

         return theHQL;
	 }
     
     public Collection<LossOfExpressionIHCFinding> getLossExpFindings(LossOfExpressionIHCFindingCriteria inCriteria)
     {
         logger.debug("Entering getFindings");
         Session theSession = sessionFactory.getCurrentSession();
         Set<LossOfExpressionIHCFinding> theResults = new HashSet<LossOfExpressionIHCFinding>();
         try
         {
             
             HashMap<String, Object> theParams = new HashMap<String, Object>();

             StringBuilder theHQL = handleCriteria(inCriteria, theParams,null);
             
        	 ProteinBiomarkerCriteia theProteinCriteria = inCriteria.getProteinBiomarkerCrit();
        	 SpecimenCriteria theSpecimenCriteria = inCriteria.getSpecimenCriteria();
        	  
             
             if (theProteinCriteria != null)
             {
                 if(theHQL.toString().contains("WHERE")){
                 theHQL.append(" AND lossIHC.proteinBiomarker IN (");
                 }
                 else{
                 theHQL.append(" WHERE lossIHC.proteinBiomarker IN (");    
                 }
                 
                 ProteinBiomarkerHandler theProteinHandler = theProteinCriteria.getHandler();
                 StringBuilder theProteinHQL = theProteinHandler.handleCriteria(theProteinCriteria, theParams);
                 theHQL.append(theProteinHQL + ")");
                 
             }
             
             if (theSpecimenCriteria != null)
             {
                 if(theHQL.toString().contains("WHERE")){
                     theHQL.append(" AND lossIHC.specimen IN (");
                 }
                 else{
                     theHQL.append(" WHERE lossIHC.specimen IN (");
                 }

                 SpecimenHandler theSpecimenHandler = theSpecimenCriteria.getHandler();
                 StringBuilder theSpecimenHQL = theSpecimenHandler.handleCriteria(theSpecimenCriteria, theParams);
                 theHQL.append(theSpecimenHQL + ")");
                 
             }

             logger.info("HQL7777777777: " + theHQL.toString());
             Query q = theSession.createQuery(theHQL.toString());             
             HQLHelper.setParamsOnQuery(theParams, q);
             List<String> theObjects = q.list();
             
             if(theObjects.size()>1000){
                 List<List<String>> segmentedObjects = new ArrayList<List<String>>();
                 List<String> myObjects = new ArrayList<String>();
                 
                 for(int i=0;i<theObjects.size();i++){
                     if(i!=0 && i%1000==0){
                         List<String> tempObjects = new ArrayList<String>(myObjects);
                         segmentedObjects.add(tempObjects);
                         myObjects.clear();
                     }
                     else{
                         myObjects.add(theObjects.get(i));
                     }
                 }
                 if(!myObjects.isEmpty()){
                     segmentedObjects.add(myObjects);
                 }
                 /* now I should have segemented groups of 1000 (or less) to iterate over
                  and populate into my "in" clause for each group. When the queries complete,
                  I add the results into my results object. */
                 
                 for(List list: segmentedObjects){
                     String theFinalHQL = "select levelIHC from LevelOfExpressionIHCFinding as levelIHC LEFT JOIN FETCH levelIHC.proteinBiomarker LEFT JOIN FETCH levelIHC.specimen " +
                     " WHERE levelIHC.specimen.patientDID||levelIHC.proteinBiomarker.id IN (:levelIHC_objects)";
                     System.out.println(theFinalHQL);
                     Query theFinalQuery = null;
                     theFinalQuery = theSession.createQuery(theFinalHQL);
                     theFinalQuery.setParameterList("levelIHC_objects",list);
                     Collection<LossOfExpressionIHCFinding> objs = theFinalQuery.list();
                     theResults.addAll(objs);
                 }
           }
         
         //if the objects do not exceed 1000, procedd with a regular in clause
         else{
             String theFinalHQL = "select lossIHC from LossOfExpressionIHCFinding as lossIHC LEFT JOIN FETCH lossIHC.proteinBiomarker LEFT JOIN FETCH lossIHC.specimen " +
             " WHERE lossIHC.specimen.patientDID||lossIHC.proteinBiomarker.id IN (:lossIHC_objects)";
             System.out.println(theFinalHQL);
             Query theFinalQuery = null;
             theFinalQuery = theSession.createQuery(theFinalHQL);
             theFinalQuery.setParameterList("lossIHC_objects",theObjects);
             Collection<LossOfExpressionIHCFinding> objs = theFinalQuery.list();
             theResults.addAll(objs);
         }
         
     
     
         }
         
         catch (Exception e)
         {
             e.printStackTrace();
             logger.error("Error getting findings: ", e);
         }
         
         logger.debug("Exiting getFindings");

         return theResults;

         
     }


 
  
}
