package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum ExposureLevel {
    HEAVY(1, "heavy"),
    MODERATE(2, "moderate"),
    LIGHT(3, "light");

    private final int value;
    private final String name;

    ExposureLevel(int key, String name) {
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
