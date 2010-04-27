package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class LivingCompanionExposure {

	private Integer hoursPerDayExposed;
	private Float yearsExposued;
	public Companion companion;
	public TobaccoType tobaccoType;

	public LivingCompanionExposure(){

	}

	public void finalize() throws Throwable {

	}

    public Integer getHoursPerDayExposed() {
        return hoursPerDayExposed;
    }

    public void setHoursPerDayExposed(Integer hoursPerDayExposed) {
        this.hoursPerDayExposed = hoursPerDayExposed;
    }

    public Float getYearsExposued() {
        return yearsExposued;
    }

    public void setYearsExposued(Float yearsExposued) {
        this.yearsExposued = yearsExposued;
    }

    public Companion getCompanion() {
        return companion;
    }

    public void setCompanion(Companion companion) {
        this.companion = companion;
    }

    public TobaccoType getTobaccoType() {
        return tobaccoType;
    }

    public void setTobaccoType(TobaccoType tobaccoType) {
        this.tobaccoType = tobaccoType;
    }

}