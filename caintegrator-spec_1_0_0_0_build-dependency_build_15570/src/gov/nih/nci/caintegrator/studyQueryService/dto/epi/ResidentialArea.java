package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum ResidentialArea {
    ITALY("Italy", "Italy"),
    USA("USA", "USA");

    private final String value;
    private final String name;

    ResidentialArea(String key, String name) {
            this.value = key;
            this.name = name;
    }

    public String getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

}
