package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 24, 2007
  * Time:   3:58:50 PM
**/
public enum Relative {
	BROTHER(1, "Brother"),
	FATHER(2, "Father"),
	GRANDFATHER(3, "Grand Father"),
	GRANDMOTHER(4, "Grand Mother"),
	MOTHER(5, "Mother"),
	SISTER(6, "Sister");

    final private String name;
    final private int value;

    Relative(int value, String name ) {
       this.name = name;
       this.value = value;
   }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }
}