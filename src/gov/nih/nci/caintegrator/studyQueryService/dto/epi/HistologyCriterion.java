package gov.nih.nci.caintegrator.studyQueryService.dto.epi;
/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum HistologyCriterion {
	ONE(1, "one"),
	THREE(3, "three"),
	TWO(2, "two");

    private final int value;
    private final String name;

    HistologyCriterion(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}