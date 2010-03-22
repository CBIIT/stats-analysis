package gov.nih.nci.caintegrator.studyQueryService.dto.ihc;

import java.util.Collection;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.studyQueryService.finding.SpecimenBasedMolecularFindingHandler;
import gov.nih.nci.caintegrator.studyQueryService.ihc.LevelOfExpressionIHCFindingHandler;

public class LevelOfExpressionIHCFindingCriteria extends IHCFindingCriteria implements QueryDTO {
	/*public SpecimenBasedMolecularFindingHandler getHandler() {		
		return new LevelOfExpressionIHCFindingHandler();
	}*/
	
	public LevelOfExpressionIHCFindingHandler getHandler() {		
		return new LevelOfExpressionIHCFindingHandler();
	}
	
	private Collection <String> stainIntensityCollection;
	private Collection <String> stainLocalizationCollection;
	private Collection <String> stainDistributionCollection;
	private Integer percentPositive;
	private Integer percentPositiveRangeMin;
	private Integer percentPositiveRangeMax;
    private String queryName;
	
	
	public Integer getPercentPositive() {
		return percentPositive;
	}
	public void setPercentPositive(Integer percentPositive) {
		this.percentPositive = percentPositive;
	}
	public Integer getPercentPositiveRangeMax() {
		return percentPositiveRangeMax;
	}
	public void setPercentPositiveRangeMax(Integer percentPositiveRangeMax) {
		this.percentPositiveRangeMax = percentPositiveRangeMax;
	}
	public Integer getPercentPositiveRangeMin() {
		return percentPositiveRangeMin;
	}
	public void setPercentPositiveRangeMin(Integer percentPositiveRangeMin) {
		this.percentPositiveRangeMin = percentPositiveRangeMin;
	}
	public Collection<String> getStainIntensityCollection() {
		return stainIntensityCollection;
	}
	public void setStainIntensityCollection(
			Collection<String> stainIntensityCollection) {
		this.stainIntensityCollection = stainIntensityCollection;
	}
	public Collection<String> getStainLocalizationCollection() {
		return stainLocalizationCollection;
	}
	public void setStainLocalizationCollection(
			Collection<String> stainLocalizationCollection) {
		this.stainLocalizationCollection = stainLocalizationCollection;
	}
	public Collection<String> getStainDistributionCollection() {
		return stainDistributionCollection;
	}
	public void setStainDistributionCollection(Collection<String> stainDistributionCollection) {
		this.stainDistributionCollection = stainDistributionCollection;
	}
    public void setQueryName(String name) {
        this.queryName = name;        
    }
    public String getQueryName() {
        return queryName;
    }
	
	
	

}
