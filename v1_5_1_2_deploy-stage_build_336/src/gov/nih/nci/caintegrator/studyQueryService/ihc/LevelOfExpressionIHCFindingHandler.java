package gov.nih.nci.caintegrator.studyQueryService.ihc;

import gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean.LevelOfExpressionIHCFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.LevelOfExpressionIHCFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.protein.ProteinBiomarkerCriteia;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.protein.ProteinBiomarkerHandler;
import gov.nih.nci.caintegrator.studyQueryService.study.SpecimenHandler;
import gov.nih.nci.caintegrator.util.HQLHelper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class LevelOfExpressionIHCFindingHandler extends IHCFindingHandler {
	
	 private static Logger logger = Logger.getLogger(LevelOfExpressionIHCFindingHandler.class);
    // This is the Hibernate Session factory that is injected by Spring
     
     	
	 protected Class getFindingType() {
	   return LevelOfExpressionIHCFinding.class;
      }
	
     protected StringBuilder handleCriteria(SpecimenBasedMolecularFindingCriteria inCriteria,
             HashMap<String, Object> inParams,
             Session inSession) {
    	
    	 logger.debug("Entering handler for  LevelOfExpressionIHCFindingHandler");
    	 LevelOfExpressionIHCFindingCriteria theCriteria = (LevelOfExpressionIHCFindingCriteria) inCriteria;
    	 
    	 
    	 StringBuilder theHQL = new StringBuilder();
    	 
    	  // Start of the where clause
    	 
     	 theHQL.append("select levelIHC.specimen.patientDID||levelIHC.proteinBiomarker.id from LevelOfExpressionIHCFinding as levelIHC LEFT JOIN levelIHC.proteinBiomarker LEFT JOIN levelIHC.specimen ");  
    	 
        
         
         String theANDString = " WHERE ";        
       
         
         /////////////////////////////////////////////////////
         // Handle percent positive absolute number
         /////////////////////////////////////////////////////
        if (theCriteria.getPercentPositive() != null )
         {
             System.out.println("ihc percent positive absolute #: " + theCriteria.getPercentPositive());
             theHQL.append(theANDString + " levelIHC.percentPositive IN (:levelIHC_percentPositive) ");
             inParams.put("levelIHC_percentPositive", theCriteria.getPercentPositive());
             theANDString = " AND ";
         }

        /////////////////////////////////////////////////////
        // Handle percent positive min number
        /////////////////////////////////////////////////////
        if (theCriteria.getPercentPositiveRangeMin() != null)
        {
        
          System.out.println("ihc percent positive min #: " + theCriteria.getPercentPositiveRangeMin());
          //theHQL.append(theANDString + " levelIHC.percentPositiveRangeMin IN (:levelIHC_percentPositiveRangeMin) ");
             theHQL.append(theANDString + " levelIHC.percentPositiveRangeMin >="+ theCriteria.getPercentPositiveRangeMin().intValue());
          //   inParams.put("levelIHC_percentPositiveRangeMin", theCriteria.getPercentPositiveRangeMin());
             theANDString = " AND ";
        }
     
        
        
        /////////////////////////////////////////////////////
         // Handle percent positive max number
         /////////////////////////////////////////////////////
       if (theCriteria.getPercentPositiveRangeMax() != null)
         {
        	  System.out.println("ihc percent positive max #: " + theCriteria.getPercentPositiveRangeMax());
               //theHQL.append(theANDString + " levelIHC.percentPositiveRangeMax IN (:levelIHC_percentPositiveRangeMax) ");
        	   theHQL.append(theANDString + " levelIHC.percentPositiveRangeMax <="+theCriteria.getPercentPositiveRangeMax().intValue());
              //inParams.put("levelIHC_percentPositiveRangeMax", theCriteria.getPercentPositiveRangeMax());
              theANDString = " AND ";
         }
         
         
         
         /////////////////////////////////////////////////////
         // Handle intensity of stain
         /////////////////////////////////////////////////////
         if (theCriteria.getStainIntensityCollection() != null && theCriteria.getStainIntensityCollection().size() > 0)
         {
             theHQL.append(theANDString + " levelIHC.stainIntensity IN (:levelIHC_stainIntensity) ");
             inParams.put("levelIHC_stainIntensity", theCriteria.getStainIntensityCollection());
             theANDString = " AND ";
         }
         
         /////////////////////////////////////////////////////
         // Handle localization of stain
         /////////////////////////////////////////////////////
         if (theCriteria.getStainLocalizationCollection() != null && theCriteria.getStainLocalizationCollection().size() > 0)
         {
             theHQL.append(theANDString + " levelIHC.stainLocalization IN (:levelIHC_stainLocalization) ");
             inParams.put("levelIHC_stainLocalization", theCriteria.getStainLocalizationCollection());
             theANDString = " AND ";
         }
         
         /////////////////////////////////////////////////////
         // Handle distribution of stain
         /////////////////////////////////////////////////////
         if (theCriteria.getStainDistributionCollection() != null && theCriteria.getStainDistributionCollection().size() > 0)
         {
             theHQL.append(theANDString + " levelIHC.stainDistribution IN (:levelIHC_stainDistribution) ");
             inParams.put("levelIHC_stainDistribution", theCriteria.getStainDistributionCollection());
           
         }
         
         logger.info("HQL: " + theHQL.toString());
         logger.debug("Exiting handleCriteria");

         return theHQL;
	 }
     
     public Collection<LevelOfExpressionIHCFinding> getLevelExpFindings(LevelOfExpressionIHCFindingCriteria inCriteria)
     {
         logger.debug("Entering getFindings");
         Session theSession = sessionFactory.getCurrentSession();
         Set<LevelOfExpressionIHCFinding> theResults = new HashSet<LevelOfExpressionIHCFinding>();
          try
         {
             //theSession = HibernateUtil.getSession();
             //HibernateUtil.beginTransaction();

             HashMap<String, Object> theParams = new HashMap<String, Object>();

             StringBuilder theHQL = handleCriteria(inCriteria, theParams,null);
             
             ProteinBiomarkerCriteia theProteinCriteria = inCriteria.getProteinBiomarkerCrit();
             SpecimenCriteria theSpecimenCriteria = inCriteria.getSpecimenCriteria();
              
             
             if (theProteinCriteria != null)
             {
                 if(theHQL.toString().contains("WHERE")){
                 theHQL.append(" AND levelIHC.proteinBiomarker IN (");
                 }
                 else{
                 theHQL.append(" WHERE levelIHC.proteinBiomarker IN (");    
                 }
                 
                 ProteinBiomarkerHandler theProteinHandler = theProteinCriteria.getHandler();
                 StringBuilder theProteinHQL = theProteinHandler.handleCriteria(theProteinCriteria, theParams);
                 theHQL.append(theProteinHQL + ")");
                 
                 
             }
             
             if (theSpecimenCriteria != null)
             {
                 if(theHQL.toString().contains("WHERE")){
                     theHQL.append(" AND levelIHC.specimen IN (");
                 }
                 else{
                     theHQL.append(" WHERE levelIHC.specimen IN (");
                 }

                 SpecimenHandler theSpecimenHandler = theSpecimenCriteria.getHandler();
                 StringBuilder theSpecimenHQL = theSpecimenHandler.handleCriteria(theSpecimenCriteria, theParams);
                 theHQL.append(theSpecimenHQL + ")");
                 
             }

             logger.info("HQL7777777777: " + theHQL.toString());
             Query q = theSession.createQuery(theHQL.toString());
             
             long start = System.currentTimeMillis();
             
             HQLHelper.setParamsOnQuery(theParams, q);   
             
                         
             /*this returns my "initial query" to bring back objects that met my criteria.
             Next I would like to find out about the other timepoint data for the objects
             that were just found.*/
             
             List<String> theObjects = q.list();
             
             //check to see if objects exceed 1000, so that the statemnt can be segmented
             
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
                         Collection<LevelOfExpressionIHCFinding> objs = theFinalQuery.list();
                         theResults.addAll(objs);
                     }
               }
             
             //if the objects do not exceed 1000, procedd with a regular in clause
             else{
                 String theFinalHQL = "select levelIHC from LevelOfExpressionIHCFinding as levelIHC LEFT JOIN FETCH levelIHC.proteinBiomarker LEFT JOIN FETCH levelIHC.specimen " +
                 " WHERE levelIHC.specimen.patientDID||levelIHC.proteinBiomarker.id IN (:levelIHC_objects)";
                 
             
                 System.out.println(theFinalHQL);
                 Query theFinalQuery = null;
                 theFinalQuery = theSession.createQuery(theFinalHQL);
                 theFinalQuery.setParameterList("levelIHC_objects",theObjects);
                 Collection<LevelOfExpressionIHCFinding> objs = theFinalQuery.list();
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
