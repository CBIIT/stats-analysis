package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum ResidentialArea {
    AREA1(1, "area-1"),
    AREA2(2, "area-2");

    private final int value;
    private final String name;

    ResidentialArea(int key, String name) {
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
