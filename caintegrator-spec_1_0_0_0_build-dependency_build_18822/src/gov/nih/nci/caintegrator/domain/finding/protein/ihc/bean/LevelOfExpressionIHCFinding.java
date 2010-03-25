package gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean;

import gov.nih.nci.caintegrator.domain.finding.clinical.breastCancer.bean.BreastCancerClinicalFinding;

import java.io.Serializable;

public class LevelOfExpressionIHCFinding extends IHCFinding implements
		Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5521922293848635255L;	
	
    private java.lang.Long id;	 
	
	private String overallExpression; 		
	
	public String getOverallExpression() {
		return overallExpression;
	}

	 
	public void setOverallExpression(String overallExpression) {
		this.overallExpression = overallExpression;
	}
	
	
    private Integer percentPositive; 		
	
	public Integer getPercentPositive() {
		return percentPositive;
	}

	 
	public void setPercentPositive(Integer percentPositive) {
		this.percentPositive = percentPositive;
	}
	
	private Integer percentPositiveRangeMax; 		
		
	public Integer getPercentPositiveRangeMax() {
			return percentPositiveRangeMax;
		}
		 
	public void setPercentPositiveRangeMax(Integer percentPositiveRangeMax) {
			this.percentPositiveRangeMax = percentPositiveRangeMax;
		}
	
	private Integer percentPositiveRangeMin; 		
	
	public Integer getPercentPositiveRangeMin() {
			return percentPositiveRangeMin;
		}
		 
	public void setPercentPositiveRangeMin(Integer percentPositiveRangeMin) {
			this.percentPositiveRangeMin = percentPositiveRangeMin;
		}
	
	
   private String stainDistribution; 		
	
	public String getStainDistribution() {
		return stainDistribution;
	}

	 
	public void setStainDistribution(String stainDistribution) {
		this.stainDistribution = stainDistribution;
	}
	
	
   private String stainIntensity; 		
		
	public String getStainIntensity() {
			return stainIntensity;
		}

		 
   public void setStainIntensity(String stainIntensity) {
			this.stainIntensity = stainIntensity;
		}
   
   
   private String stainLocalization; 		
	
   public String getStainLocalization() {
			return stainLocalization;
		}

		 
  public void setStainLocalization(String stainLocalization) {
			this.stainLocalization = stainLocalization;
		}
  
  private String invasivePresentation; 		
	
  public String getInvasivePresentation() {
			return invasivePresentation;
		}

		 
 public void setInvasivePresentation(String invasivePresentation) {
			this.invasivePresentation = invasivePresentation;
		}
 
 public boolean equals(Object obj) {
		boolean eq = false;
		if (obj instanceof LevelOfExpressionIHCFinding) {
			LevelOfExpressionIHCFinding levelIHC = (LevelOfExpressionIHCFinding) obj;
			Long thisId = getId();

			if (thisId != null && thisId.equals(levelIHC.getId())) {
				eq = true;
			}

		}
		return eq;
	}

public int hashCode() {
		int h = 0;

		if (getId() != null) {
			h += getId().hashCode();
		}

		return h;
	}


public java.lang.Long getId() {
	return id;
}


public void setId(java.lang.Long id) {
	this.id = id;
}



}
