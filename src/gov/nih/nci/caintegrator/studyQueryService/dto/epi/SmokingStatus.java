package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum SmokingStatus {
	CURRENT("Current"),
	FORMER("Former"),
	NONSMOKER("NonSmoker"),
	OCCASIONAL("Occasional")  ;

    private String value;

    SmokingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}