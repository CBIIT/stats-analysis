package gov.nih.nci.caintegrator.domain;





/**
 * Biological Sample matter such as tissue, serum etc that might be extract for analysis from the Patient.
 * For clinical studies, Patient may act as the entire Sample itself.
 * @version 1.0
 * @created 18-Nov-2005 01:56:59 PM
 */
public class Sample {

	private String type;

	public Sample(){

	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

}