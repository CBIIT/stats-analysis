package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum Gender {
	FEMALE("Female"),
	MALE("Male"),
	OTHERORUNKNOWN("Other Or Unknko");

    private String value;

    Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}