package gov.nih.nci.caintegrator.domain;





/**
 * The participating institute on the study. It can be either a recruiting institution or a data generating institution
 * @version 1.0
 * @created 18-Nov-2005 01:56:49 PM
 */
public class Institution extends Organization {

	/**
	 * A researcher in a clinical trial or clinical study who oversees all aspects of the trial, such as concept development,
	 * protocol writing, protocol submission for IRB approval, participant recruitment, informed consent, data collection,
	 * analysis, interpretation and presentation.
	 */
	private String principalInvestigator;
	/**
	 * A unique alpha-numeric code assigned by NCI to institution where the patient/participant was originally registered on
	 * study (institution where the patient signed the informed consent form). The code is assigned to protocol/records to
	 * identify the institution(s) participating in NCI-sponsored clinical trials and investigator records to identify address
	 * location.
	 */
	private String NCIInstituteCode;

	public Institution(){

	}

	/**
	 * @return Returns the nCIInstituteCode.
	 */
	public String getNCIInstituteCode() {
		return NCIInstituteCode;
	}

	/**
	 * @param instituteCode The nCIInstituteCode to set.
	 */
	public void setNCIInstituteCode(String instituteCode) {
		NCIInstituteCode = instituteCode;
	}

	/**
	 * @return Returns the principalInvestigator.
	 */
	public String getPrincipalInvestigator() {
		return principalInvestigator;
	}

	/**
	 * @param principalInvestigator The principalInvestigator to set.
	 */
	public void setPrincipalInvestigator(String principalInvestigator) {
		this.principalInvestigator = principalInvestigator;
	}

}