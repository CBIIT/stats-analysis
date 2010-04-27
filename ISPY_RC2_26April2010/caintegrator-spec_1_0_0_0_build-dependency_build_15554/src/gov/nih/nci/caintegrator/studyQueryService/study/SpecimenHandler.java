package gov.nih.nci.caintegrator.studyQueryService.study;


import gov.nih.nci.caintegrator.domain.study.bean.Specimen;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;


import java.util.HashMap;

import org.apache.log4j.Logger;

public class SpecimenHandler {
	
	private static Logger logger = Logger.getLogger(SpecimenHandler.class);
	
	 /**
     * Return the specific finding type
     */
    protected Class getFindingType()
    {
        return Specimen.class;
    }
    
	public static StringBuilder handleCriteria(SpecimenCriteria inCriteria,  HashMap inParams) {
		
		logger.debug("Entering specimen's handleCriteria");
		SpecimenCriteria theCriteria =  inCriteria;	
		StringBuilder theHQL = new StringBuilder();
		
		theHQL.append("from Specimen AS s ");
	    String theANDString = " WHERE ";
	        
        
        if (theCriteria != null)  {             
            
        	 if (theCriteria.getTimeCourseCollection() != null && theCriteria.getTimeCourseCollection().size() > 0) {
        		 theHQL.append(theANDString + " s.timePoint IN (:s_timePoint) ");
                 inParams.put("s_timePoint", theCriteria.getTimeCourseCollection());                 
                 theANDString = " AND ";
            }
        	 
        	 if (theCriteria.getPatientIdentifierCollection() != null && theCriteria.getPatientIdentifierCollection().size() > 0) {
        		 theHQL.append(theANDString + " s.patientDID IN (:s_patientDID) ");
                 inParams.put("s_patientDID", theCriteria.getPatientIdentifierCollection());
                 theANDString = " AND ";
            
            }
        	 
        	 if (theCriteria.getSpecimenIdentifierCollection() != null && theCriteria.getSpecimenIdentifierCollection().size() > 0) {
        		 theHQL.append(theANDString + " s.specimenIdentifier IN (:s_specimenIdentifier) ");
                 inParams.put("s_specimenIdentifier", theCriteria.getSpecimenIdentifierCollection());
            
            }
        	 
        	 
        }  
        
      
        return theHQL;
    }	

}
