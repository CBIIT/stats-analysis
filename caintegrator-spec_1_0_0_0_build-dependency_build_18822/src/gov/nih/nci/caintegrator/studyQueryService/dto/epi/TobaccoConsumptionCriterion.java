package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class TobaccoConsumptionCriterion {

	private Integer ageAtInitiationLower;
    private Integer ageAtInitiationUpper;
    private Integer durationLower;
    private Integer durationUpper;
    private Double intensityLower;
    private Double intensityUpper;
	private Integer yearsSinceQuittingLower;
    private Integer yearsSinceQuittingUpper;
	public TobaccoType tobaccoType;
	public SmokingStatus smokingStatus;

	public TobaccoConsumptionCriterion(){

	}

    public Integer getAgeAtInitiationLower() {
        return ageAtInitiationLower;
    }

    public void setAgeAtInitiationLower(Integer ageAtInitiationLower) {
        this.ageAtInitiationLower = ageAtInitiationLower;
    }

    public Integer getAgeAtInitiationUpper() {
        return ageAtInitiationUpper;
    }

    public void setAgeAtInitiationUpper(Integer ageAtInitiationUpper) {
        this.ageAtInitiationUpper = ageAtInitiationUpper;
    }

    public Integer getDurationUpper() {
        return durationUpper;
    }

    public void setDurationUpper(Integer durationUpper) {
        this.durationUpper = durationUpper;
    }

    public Integer getDurationLower() {
        return durationLower;
    }

    public void setDurationLower(Integer durationLower) {
        this.durationLower = durationLower;
    }

    public Double getIntensityLower() {
        return intensityLower;
    }

    public void setIntensityLower(Double intensityLower) {
        this.intensityLower = intensityLower;
    }

    public Double getIntensityUpper() {
        return intensityUpper;
    }

    public void setIntensityUpper(Double intensityUpper) {
        this.intensityUpper = intensityUpper;
    }

    public Integer getYearsSinceQuittingLower() {
        return yearsSinceQuittingLower;
    }

    public void setYearsSinceQuittingLower(Integer yearsSinceQuittingLower) {
        this.yearsSinceQuittingLower = yearsSinceQuittingLower;
    }

    public Integer getYearsSinceQuittingUpper() {
        return yearsSinceQuittingUpper;
    }

    public void setYearsSinceQuittingUpper(Integer yearsSinceQuittingUpper) {
        this.yearsSinceQuittingUpper = yearsSinceQuittingUpper;
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