package gov.nih.nci.caintegrator.domain;





/**
 * A form of treatment or intervention activity experienced by a subject on a study as specified by the protocol.
 * Surgeries, Biopsies and Radiation Therapy represent types of Procedures.
 * @created 18-Nov-2005 01:56:57 PM
 */
public class Procedure extends Activity {

	/**
	 * Name of site(s) within the body targeted for procedures or interventions; multiple contiguous sites within the same
	 * organ system may be referenced. 
	 */
	private String targetSiteCode;

	public Procedure(){

	}

	/**
	 * @return Returns the targetSiteCode.
	 */
	public String getTargetSiteCode() {
		return targetSiteCode;
	}

	/**
	 * @param targetSiteCode The targetSiteCode to set.
	 */
	public void setTargetSiteCode(String targetSiteCode) {
		this.targetSiteCode = targetSiteCode;
	}

}