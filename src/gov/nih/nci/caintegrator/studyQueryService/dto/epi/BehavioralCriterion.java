package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class BehavioralCriterion {

	private Integer anxietyScore;
	private Integer depressionScore;

	public BehavioralCriterion(){

	}

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

}