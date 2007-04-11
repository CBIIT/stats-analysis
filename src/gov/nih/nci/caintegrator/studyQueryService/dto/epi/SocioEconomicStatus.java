package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum SocioEconomicStatus {
	TBD1("TBD1"),
	TBD2("TBD2"),
	TBD3("TBD3")  ;

    private String value;

    SocioEconomicStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}