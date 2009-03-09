package gov.nih.nci.caintegrator.studyQueryService.finding;


import gov.nih.nci.breastCancer.dto.ClinicalFindingCriteria;
import gov.nih.nci.breastCancer.dto.StudyParticipantCriteria;
import gov.nih.nci.breastCancer.service.StudyParticipantHandler;
import gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
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

public abstract class SpecimenBasedMolecularFindingHandler {
	 private static Logger logger = Logger.getLogger(SpecimenBasedMolecularFindingHandler.class);
	 
	  protected abstract StringBuilder handleCriteria(SpecimenBasedMolecularFindingCriteria inCriteria,
              HashMap<String, Object> inParams,
              Session inSession);
	  protected abstract Class getFindingType();
	  
	  
	  public Collection<? extends SpecimenBasedMolecularFinding> getFindings(SpecimenBasedMolecularFindingCriteria inCriteria)
	    {		
		  Set<? extends SpecimenBasedMolecularFinding> theResults = new HashSet<SpecimenBasedMolecularFinding>();
		  try {
		    logger.debug("Entering SpecimenBasedMolecularFinding");
		    SpecimenCriteria theSpecimenCriteria = inCriteria.getSpecimenCriteria();

		    
		    HashMap<String, Object> theParams = new HashMap<String, Object>();
		  
		     /////////////////////////////////////////////////////////////////////////////
             // prepare HQL required to for handling corresponding subtype type finding
               /////////////////////////////////////////////////////////////////////////////
            StringBuilder theHQL = handleCriteria(inCriteria, theParams, null);
            String theConnectorString = " WHERE ";
          
            if (theSpecimenCriteria != null) {
        	  
        	   theHQL.append(theConnectorString + " f.specimen IN (");

               SpecimenHandler theSpecimenHandler = theSpecimenCriteria.getHandler();
               StringBuilder theSpecimenHQL = theSpecimenHandler.handleCriteria(theSpecimenCriteria, theParams);
               theHQL.append(theSpecimenHQL + ")");             
        	  
             }
              
            Session theSession = HibernateUtil.getSession();
            theSession.beginTransaction();
            Query theQuery = theSession.createQuery(theHQL.toString());
            HQLHelper.setParamsOnQuery(theParams, theQuery);
            logger.info("HQL: " + theHQL.toString());
            
            long theStartTime = System.currentTimeMillis(); 
            Collection objs = theQuery.list();
            long theElapsedTime = System.currentTimeMillis() - theStartTime;
            logger.info("Elapsed time: " + theElapsedTime);
            
            theResults.addAll(objs);
            
		  }
		  
		  
	    
	  catch (Exception e)
      {
          logger.error("Error getting findings: ", e);
          e.printStackTrace();
      }
	  
	  logger.debug("Exiting getSpecimenBasedMolecularFindings");
	  return theResults;
    }

}
