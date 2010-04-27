package gov.nih.nci.caintegrator.studyQueryService.dto.p53;

import java.util.Collection;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.SpecimenCriteria;
import gov.nih.nci.caintegrator.studyQueryService.finding.SpecimenBasedMolecularFindingHandler;

public class P53FindingCriteria extends SpecimenBasedMolecularFindingCriteria implements QueryDTO {
	
	 private String queryName;
	 private Collection <String> mutationStatusCollection;
	 private Collection <String> mutationTypeCollection;
     private SpecimenCriteria specimenCriteria;
	 
	 public SpecimenCriteria getSpecimenCriteria() {
		return specimenCriteria;
	 }
	 public void setSpecimenCriteria(SpecimenCriteria specimenCriteria) {
		this.specimenCriteria = specimenCriteria;
	 }
	 

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String name) {
		 this.queryName = name;   
	}

	public Collection<String> getMutationStatusCollection() {
		return mutationStatusCollection;
	}

	public void setMutationStatusCollection(
			Collection<String> mutationStatusCollection) {
		this.mutationStatusCollection = mutationStatusCollection;
	}

	public Collection<String> getMutationTypeCollection() {
		return mutationTypeCollection;
	}

	public void setMutationTypeCollection(Collection<String> mutationTypeCollection) {
		this.mutationTypeCollection = mutationTypeCollection;
	}
	@Override
	public SpecimenBasedMolecularFindingHandler getHandler() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
