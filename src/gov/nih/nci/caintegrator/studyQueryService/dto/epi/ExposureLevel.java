package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum ExposureLevel {
	HEAVY("Heavy"),
	LIGHT("Light"),
	MODERATE("Moderate");

    private String value;

    ExposureLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}