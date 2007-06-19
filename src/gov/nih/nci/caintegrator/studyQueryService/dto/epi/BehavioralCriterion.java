package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 30, 2007
  * Time:   2:52:50 PM
**/

public class BehavioralCriterion {

	private Integer anxietyScore;
	private Integer depressionScore;
	private Integer fagerstromScoreLower;
	private Integer fagerstromScoreUpper;

	public BehavioralCriterion(){ }

    public Integer getAnxietyScore() {
        return anxietyScore;
    }

    public void setAnxietyScore(Integer anxietyScore) {
        this.anxietyScore = anxietyScore;
    }

    public Integer getDepressionScore() {
        return depressionScore;
    }

    public void setDepressionScore(Integer depressionScore) {
        this.depressionScore = depressionScore;
    }

	public Integer getFagerstromScoreLower() {
		return fagerstromScoreLower;
	}

	public void setFagerstromScoreLower(Integer fagerstromScoreLower) {
		this.fagerstromScoreLower = fagerstromScoreLower;
	}

	public Integer getFagerstromScoreUpper() {
		return fagerstromScoreUpper;
	}

	public void setFagerstromScoreUpper(Integer fagerstromScoreUpper) {
		this.fagerstromScoreUpper = fagerstromScoreUpper;
	}

   
}