package gov.nih.nci.caintegrator.studyQueryService.dto.fish;

import java.util.Collection;

import gov.nih.nci.caintegrator.studyQueryService.dto.finding.SpecimenBasedMolecularFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.fish.FISHFindingHandler;


public class FISHFindingCriteria extends SpecimenBasedMolecularFindingCriteria {
	/*public SpecimenBasedMolecularFindingHandler getHandler() {		
		return new LevelOfExpressionIHCFindingHandler();
	}*/
	
	public FISHFindingHandler getHandler() {		
		return new FISHFindingHandler();
	}
	
	/**
	 * fishfinding can be searched based on geneBioMarker collection(s)
	 */
	private Collection <String> bioMarkerCollection;
	
	/**
	 * fishfinding can also be searched based on abnomalityStatus collection(s)
	
	 */
	private Collection <String> abnomalityStatusCollection;
	

	public Collection<String> getAbnomalityStatusCollection() {
		return abnomalityStatusCollection;
	}

	public void setAbnomalityStatusCollection(
			Collection<String> abnomalityStatusCollection) {
		this.abnomalityStatusCollection = abnomalityStatusCollection;
	}

	public Collection<String> getBioMarkerCollection() {
		return bioMarkerCollection;
	}

	public void setBioMarkerCollection(Collection<String> bioMarkerCollection) {
		this.bioMarkerCollection = bioMarkerCollection;
	}
	

}
