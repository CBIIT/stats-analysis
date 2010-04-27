package gov.nih.nci.caintegrator.studyQueryService.dto.study;

import gov.nih.nci.breastCancer.service.StudyParticipantHandler;
import gov.nih.nci.caintegrator.studyQueryService.study.SpecimenHandler;

import java.util.Set;

public class SpecimenCriteria {
	private HistologyCriteria histologyCriteria;
	private Set<String> timeCourseCollection;
	private String collectionMethod;
	private String materialType ;
	private String specimenIdentifier;
	
	 public SpecimenHandler getHandler()
	    {
	        return new SpecimenHandler();
	    }

	
	
	
	public String getCollectionMethod() {
		return collectionMethod;
	}
	public void setCollectionMethod(String collectionMethod) {
		this.collectionMethod = collectionMethod;
	}
	public HistologyCriteria getHistologyCriteria() {
		return histologyCriteria;
	}
	public void setHistologyCriteria(HistologyCriteria histologyCriteria) {
		this.histologyCriteria = histologyCriteria;
	}
	public String getMaterialType() {
		return materialType;
	}
	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}
	public String getSpecimenIdentifier() {
		return specimenIdentifier;
	}
	public void setSpecimenIdentifier(String specimenIdentifier) {
		this.specimenIdentifier = specimenIdentifier;
	}
	public Set<String> getTimeCourseCollection() {
		return timeCourseCollection;
	}
	public void setTimeCourseCollection(Set<String> timeCourseCollection) {
		this.timeCourseCollection = timeCourseCollection;
	}
	
	
	
	

}
