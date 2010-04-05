package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 24, 2007
  * Time:   3:58:50 PM
**/
public enum Relative {
	MOTHER(1, "Mother"),
	FATHER(2, "Father"),
	SIBLING(3, "Sibling");


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