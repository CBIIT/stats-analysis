package gov.nih.nci.caintegrator.studyQueryService.dto.finding;


import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.finding.SpecimenBasedMolecularFindingHandler;



public abstract class SpecimenBasedMolecularFindingCriteria {
	 public abstract SpecimenBasedMolecularFindingHandler getHandler();
	 private SpecimenCriteria specimenCriteria;
	 
	 public SpecimenCriteria getSpecimenCriteria() {
		return specimenCriteria;
	 }
	 public void setSpecimenCriteria(SpecimenCriteria specimenCriteria) {
		this.specimenCriteria = specimenCriteria;
	 }
	 

}
