package gov.nih.nci.caintegrator.studyQueryService.fish;


import gov.nih.nci.caintegrator.domain.finding.copyNumber.fish.bean.FISHFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.fish.FISHFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.LevelOfExpressionIHCFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.finding.SpecimenBasedMolecularFindingHandler;
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

public class FISHFindingHandler extends SpecimenBasedMolecularFindingHandler {
	
	 private static Logger logger = Logger.getLogger(FISHFindingHandler.class);
	
	
	 protected Class getFindingType() {
	   return FISHFinding.class;
      }
	
     protected StringBuilder handleCriteria(SpecimenBasedMolecularFindingCriteria inCriteria,
             HashMap<String, Object> inParams,
             Session inSession) {
    	
    	
    	 logger.debug("Entering handler for  LevelOfExpressionIHCFindingHandler");
    	 FISHFindingCriteria theCriteria = (FISHFindingCriteria) inCriteria;
    	 
    	 
    	 StringBuilder theHQL = new StringBuilder();
    	 
   	     // Start of the where clause
   	 
    	 theHQL.append(" from FISHFinding as fish LEFT JOIN FETCH fish.specimen ");  
   	  	    
         String theANDString = " WHERE ";        
      
         /////////////////////////////////////////////////////
         // Handle gene biomarker collection
         /////////////////////////////////////////////////////
         if (theCriteria.getBioMarkerCollection() != null && theCriteria.getBioMarkerCollection().size() > 0)
         {
             theHQL.append(theANDString + " fish.gene IN (:fish_gene) ");
             inParams.put("fish_gene", theCriteria.getBioMarkerCollection());
             theANDString = " AND ";
         }
    	 
         /////////////////////////////////////////////////////
         // Handle abornomality status collection
         /////////////////////////////////////////////////////
         if (theCriteria.getAbnomalityStatusCollection() != null && theCriteria.getAbnomalityStatusCollection().size() > 0)
         {
             theHQL.append(theANDString + " fish.abnomalityStatus IN (:fish_abnomalityStatus) ");
             inParams.put("fish_abnomalityStatus", theCriteria.getAbnomalityStatusCollection());
            
         }
    	          
       
         logger.info("HQL: " + theHQL.toString());
         logger.debug("Exiting handleCriteria for FISHCriteria");

         return theHQL;
	 }
     
     public Collection<FISHFinding> getFISHFindings(FISHFindingCriteria inCriteria)
     {
         logger.debug("Entering getFindings");
         Session theSession = null;
         Set<FISHFinding> theResults = new HashSet<FISHFinding>();
         try
         {
             theSession = HibernateUtil.getSession();
             HibernateUtil.beginTransaction();

             HashMap<String, Object> theParams = new HashMap<String, Object>();

             StringBuilder theHQL = handleCriteria(inCriteria, theParams,null);
             
        	 SpecimenCriteria theSpecimenCriteria = inCriteria.getSpecimenCriteria();        	  
             
          
             
             if (theSpecimenCriteria != null)
             {
                 theHQL.append(" AND fish.specimen IN (");

                 SpecimenHandler theSpecimenHandler = theSpecimenCriteria.getHandler();
                 StringBuilder theSpecimenHQL = theSpecimenHandler.handleCriteria(theSpecimenCriteria, theParams);
                 theHQL.append(theSpecimenHQL + ")");
                 
             }

             logger.info("HQL7777777777: " + theHQL.toString());
             Query q = theSession.createQuery(theHQL.toString());
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

         logger.debug("Exiting getFISHFindings");

         return theResults;

         
     }


 
  
}
