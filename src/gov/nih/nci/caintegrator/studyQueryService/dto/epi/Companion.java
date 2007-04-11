package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum Companion {
	BROTHER("Brother"),
	FATHER("Father"),
	FRIEND("Friend"),
	GRANDFATHER("GrandFather"),
	GRANDMOTHER("GrandMother"),
	MOTHER("Mother"),
	SISTER("Sister");

    private String value;

    Companion(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}