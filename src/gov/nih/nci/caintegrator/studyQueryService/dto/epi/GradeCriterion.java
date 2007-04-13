package gov.nih.nci.caintegrator.studyQueryService.dto.epi;


/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/
public enum GradeCriterion {
	FOUR(4, "Four"),
	ONE(1, "One"),
	THREE(3, "Three"),
	TWO(4, "Four");

    final private String name;
    final private int value;

    GradeCriterion(int value, String name ) {
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