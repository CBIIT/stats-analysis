package gov.nih.nci.caintegrator.studyQueryService.ihc;

import gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean.LossOfExpressionIHCFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.LossOfExpressionIHCFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.protein.ProteinBiomarkerCriteia;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.protein.ProteinBiomarkerHandler;
import gov.nih.nci.caintegrator.studyQueryService.study.SpecimenHandler;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
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
    	 
     	 theHQL.append(" from LossOfExpressionIHCFinding as lossIHC LEFT JOIN FETCH lossIHC.proteinBiomarker LEFT JOIN FETCH lossIHC.specimen ");  
    	  	    
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
         Session theSession = null;
         Set<LossOfExpressionIHCFinding> theResults = new HashSet<LossOfExpressionIHCFinding>();
         try
         {
             theSession = HibernateUtil.getSession();
             HibernateUtil.beginTransaction();

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
             //Query q = theSession.createQuery("from LevelOfExpressionIHCFinding f WHERE  f.stainDistribution IN ('HOMOGENOUS')");
             HQLHelper.setParamsOnQuery(theParams, q);
             Collection theObjects = q.list();
             theResults.addAll(theObjects);
         }
         
         catch (Exception e)
         {
             e.printStackTrace();
             logger.error("Error getting findings: ", e);
         }
         finally
         {
             // Close the session if necessart
             if (theSession != null)
             {
                 theSession.close();
             }
         }

         logger.debug("Exiting getFindings");

         return theResults;

         
     }


 
  
}
