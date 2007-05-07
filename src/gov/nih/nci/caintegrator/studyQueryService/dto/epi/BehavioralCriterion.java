package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 30, 2007
  * Time:   2:52:50 PM
**/

public class BehavioralCriterion {

	private Integer anxietyScore;
	private Integer depressionScore;
	private Integer fagerstromScore;

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

    public Integer getFagerstromScore() {
        return fagerstromScore;
    }

    public void setFagerstromScore(Integer fagerstromScore) {
        this.fagerstromScore = fagerstromScore;
    }
}