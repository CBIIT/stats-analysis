package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum SocioEconomicStatus {
    MEASURE1(1, "measure-1"),
    MEASURE2(2, "measure-2");

    private final int value;
    private final String name;

    SocioEconomicStatus(int key, String name) {
            this.value = key;
            this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}