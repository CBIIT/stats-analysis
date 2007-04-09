package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class TobaccoConsumptionCriterion {

	private Integer ageAtInitiation;
	private Integer duration;
	private Integer intensity;
	private Integer yearsSinceQuitting;
	public TobaccoType tobaccoType;
	public SmokingStatus smokingStatus;

	public TobaccoConsumptionCriterion(){

	}


    public Integer getAgeAtInitiation() {
        return ageAtInitiation;
    }

    public void setAgeAtInitiation(Integer ageAtInitiation) {
        this.ageAtInitiation = ageAtInitiation;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getIntensity() {
        return intensity;
    }

    public void setIntensity(Integer intensity) {
        this.intensity = intensity;
    }

    public Integer getYearsSinceQuitting() {
        return yearsSinceQuitting;
    }

    public void setYearsSinceQuitting(Integer yearsSinceQuitting) {
        this.yearsSinceQuitting = yearsSinceQuitting;
    }

    public TobaccoType getTobaccoType() {
        return tobaccoType;
    }

    public void setTobaccoType(TobaccoType tobaccoType) {
        this.tobaccoType = tobaccoType;
    }

    public SmokingStatus getSmokingStatus() {
        return smokingStatus;
    }

    public void setSmokingStatus(SmokingStatus smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
}