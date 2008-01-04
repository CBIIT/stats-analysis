package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum SmokingExposure {
	ADULTHOOD(1, "Adulthood (at Home)"),
	CHILDHOOD(2, "Childhood"),
	WORKPLACE(3, "Workplace");

    final private String name;
    final private int value;

    SmokingExposure(int value, String name ) {
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