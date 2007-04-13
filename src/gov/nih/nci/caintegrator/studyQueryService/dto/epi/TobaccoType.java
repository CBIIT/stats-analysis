package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum TobaccoType {
	CIGAR(1, "Cigar"),
	CIGARETTE(2, "Cigarette"),
	CIGARILLOS(3, "Cigarillos"),
	PIPE(4, "Pipe") ;

    final private int value;
    final private String name;

    TobaccoType(int value, String name) {
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