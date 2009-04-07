package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum Companion {
	BROTHER(1, "Brother"),
	FATHER(2, "Father"),
	FRIEND(3, "Friend"),
	GRANDFATHER(4, "GrandFather"),
	GRANDMOTHER(5, "GrandMother"),
	MOTHER(6, "Mother"),
	SISTER(7, "Sister");

    private final int value;
    private final String name;

    Companion(int value, String name) {
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