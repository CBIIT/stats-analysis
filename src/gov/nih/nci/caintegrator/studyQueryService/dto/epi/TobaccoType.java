package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum TobaccoType {
	CIGAR("Cigar"),
	CIGARETTE("Cigarette"),
	CIGARILLOS("Cigarillos"),
	PIPE("Pipe") ;

    private String value;

    TobaccoType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}