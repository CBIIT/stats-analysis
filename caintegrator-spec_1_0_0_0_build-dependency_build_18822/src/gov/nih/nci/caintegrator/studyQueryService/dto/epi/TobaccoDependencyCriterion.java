package gov.nih.nci.caintegrator.studyQueryService.dto.epi;
/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class TobaccoDependencyCriterion {

	private Integer fagerstromScore;

	public TobaccoDependencyCriterion(){

	}

    public Integer getFagerstromScore() {
        return fagerstromScore;
    }

    public void setFagerstromScore(Integer fagerstromScore) {
        this.fagerstromScore = fagerstromScore;
    }
}