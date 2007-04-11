package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum MaritalStatus {
	DIVORCED("Divorced"),
	MARRIED("Married"),
	SINGLE("Single"),
	WIDOWED("Widowed") ;

    private String value;

    MaritalStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}