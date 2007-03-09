package gov.nih.nci.caintegrator.studyQueryService.ihc;

import gov.nih.nci.breastCancer.dto.BreastCancerClinicalFindingCriteria;
import gov.nih.nci.breastCancer.dto.StudyParticipantCriteria;
import gov.nih.nci.breastCancer.service.BreastCancerClinicalFindingHandler;
import gov.nih.nci.breastCancer.service.StudyParticipantHandler;
import gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean.LevelOfExpressionIHCFinding;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.enumeration.Operator;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.IHCFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.LevelOfExpressionIHCFindingCriteria;
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

public class LevelOfExpressionIHCFindingHandler extends IHCFindingHandler {
	
	 private static Logger logger = Logger.getLogger(LevelOfExpressionIHCFindingHandler.class);
	
	
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
    	 
     	 theHQL.append(" from LevelOfExpressionIHCFinding as levelIHC LEFT JOIN FETCH levelIHC.proteinBiomarker LEFT JOIN FETCH levelIHC.specimen ");  
    	  	    
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
         Session theSession = null;
         Set<LevelOfExpressionIHCFinding> theResults = new HashSet<LevelOfExpressionIHCFinding>();
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
