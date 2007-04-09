package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class Religion {

	private Enum TBD1;
	private Enum TBD2;
	private Enum TBD3;

	public Religion(){

	}

    public Enum getTBD1() {
        return TBD1;
    }

    public void setTBD1(Enum TBD1) {
        this.TBD1 = TBD1;
    }

    public Enum getTBD2() {
        return TBD2;
    }

    public void setTBD2(Enum TBD2) {
        this.TBD2 = TBD2;
    }

    public Enum getTBD3() {
        return TBD3;
    }

    public void setTBD3(Enum TBD3) {
        this.TBD3 = TBD3;
    }
}