package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum SmokingExposure {
	ADULTHOOD("Adulthood"),
	CHILDHOOD("Childhood"),
	WORKPLACE("Workplace");

    private String value;

    SmokingExposure(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}