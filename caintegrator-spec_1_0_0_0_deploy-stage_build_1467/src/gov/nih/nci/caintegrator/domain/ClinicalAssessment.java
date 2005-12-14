package gov.nih.nci.caintegrator.domain;





/**
 * Clinical evaluation of a patient recorded during the study. This includes neurological assessments such as CNS Findings,
 * Steroid Dose status, Anti-Convulsant Status, Seisure history, Cushingoid Features and Deep Vein Thrombosis.
 * @version 1.0
 * @created 18-Nov-2005 01:56:37 PM
 */
public class ClinicalAssessment extends ClinicalFinding {

	/**
	 * Indicates the recorded rating of the clinical assessment for a patient on the study. Values include: Normal, Abnormal
	 * due to Cance, Abnormal due to therapy, Abnormal unrelated to cancer or cancer therapy, None, Increase, Decrease, Stable,
	 * Yes, Mild, Moderate, Severe, Present at Baseline
	 * 
	 */
	private String status;

	public ClinicalAssessment(){

	}

	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}