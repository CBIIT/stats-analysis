package gov.nih.nci.caintegrator.studyQueryService.dto.protein;

import java.util.Set;

import gov.nih.nci.breastCancer.service.BreastCancerClinicalFindingHandler;
import gov.nih.nci.breastCancer.service.StudyParticipantHandler;
import gov.nih.nci.caintegrator.studyQueryService.protein.ProteinBiomarkerHandler;

import org.apache.log4j.Logger;

public class ProteinBiomarkerCriteia {
	
	private static Logger logger = Logger.getLogger(ProteinBiomarkerCriteia.class);
	public ProteinBiomarkerHandler getHandler()
	    {
	        return new ProteinBiomarkerHandler();
	    }
	
	private Set<String> proteinNameCollection;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getProteinNameCollection() {
		return proteinNameCollection;
	}

	public void setProteinNameCollection(Set<String> proteinNameCollection) {
		this.proteinNameCollection = proteinNameCollection;
	}
	
	

}
