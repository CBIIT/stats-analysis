package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

    public class LivingCompanionExposure {

        private Float hoursPerDayExposed;
        private Float yearsExposued;
        public TobaccoType tobaccoType;

	    public LivingCompanionExposure(){}

        public Float getHoursPerDayExposed() {
            return hoursPerDayExposed;
        }

        public void setHoursPerDayExposed(Float hoursPerDayExposed) {
            this.hoursPerDayExposed = hoursPerDayExposed;
        }

        public Float getYearsExposued() {
            return yearsExposued;
        }

        public void setYearsExposued(Float yearsExposued) {
            this.yearsExposued = yearsExposued;
        }

        public TobaccoType getTobaccoType() {
            return tobaccoType;
        }

        public void setTobaccoType(TobaccoType tobaccoType) {
            this.tobaccoType = tobaccoType;
        }
}