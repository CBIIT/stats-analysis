package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum EducationLevel {
	BACHELORS("Bachelors"),
	HIGHSCHOOL("High Schoole"),
	MASTERS("Masters"),
	PHD("PhD");

    private String value;

    EducationLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}