package gov.nih.nci.caintegrator.studyQueryService.protein;




import java.util.HashMap;


import gov.nih.nci.breastCancer.dto.BreastCancerClinicalFindingCriteria;
import gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker;
import gov.nih.nci.caintegrator.studyQueryService.dto.protein.ProteinBiomarkerCriteia;

import org.apache.log4j.Logger;
import org.hibernate.Session;

public class ProteinBiomarkerHandler {
	
	private static Logger logger = Logger.getLogger(ProteinBiomarkerHandler.class);
	
	 /**
     * Return the specific finding type
     */
    protected Class getFindingType()
    {
        return ProteinBiomarker.class;
    }
    
    /**
     * Return the string builder which has the constructed HQL
     */
    public StringBuilder handleCriteria(ProteinBiomarkerCriteia inCriteria,
                                           HashMap<String, Object> inParams)
    {
    	
    	logger.debug("Entering proteinbiomarker's handleCriteria");
    	ProteinBiomarkerCriteia theCriteria = (ProteinBiomarkerCriteia) inCriteria;
    	StringBuilder theHQL = new StringBuilder();
    	  // Start of the where clause
        theHQL.append("from ProteinBiomarker AS p  ");
        String theANDString = " WHERE ";
        
        
        /////////////////////////////////////////////////////
        // Handle protein biomarker collection
        /////////////////////////////////////////////////////
        
        if (theCriteria.getProteinNameCollection() != null && theCriteria.getProteinNameCollection().size() > 0)
        {
            System.out.println("protein names: " + theCriteria.getProteinNameCollection());
            theHQL.append(theANDString + " p.name IN (:p_name) ");
            inParams.put("p_name", theCriteria.getProteinNameCollection());
            
        }
        
        
        logger.info("HQL: " + theHQL.toString());
        logger.debug("Exiting handleCriteria in protein biomarker handler");

        return theHQL;

    
    }


}
