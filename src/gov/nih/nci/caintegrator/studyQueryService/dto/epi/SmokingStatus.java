package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 13, 2007
  * Time:   3:08:50 PM
**/

public enum SmokingStatus {
	CURRENT("Current Smoker"),
	FORMER("Former Smoker"),
	NEVERSMOKER("Never Smoker"),
	OCCASIONAL("Occasional")  ;

    private String value;

    SmokingStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}