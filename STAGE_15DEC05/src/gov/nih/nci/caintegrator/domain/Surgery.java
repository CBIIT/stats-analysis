package gov.nih.nci.caintegrator.domain;





/**
 * A procedure to remove or repair a part of the body or to establish whether or not disease is present.
 * 
 * NOTE: Deleted Biopsy as a type of Surgery. 2/2/05
 * @created 18-Nov-2005 01:57:07 PM
 */
public class Surgery extends Procedure {

	/**
	 * The code that represents that surgical outcome or procedure that was performed
	 */
	private String outcomeCode;

	public Surgery(){

	}

	/**
	 * @return Returns the outcomeCode.
	 */
	public String getOutcomeCode() {
		return outcomeCode;
	}

	/**
	 * @param outcomeCode The outcomeCode to set.
	 */
	public void setOutcomeCode(String outcomeCode) {
		this.outcomeCode = outcomeCode;
	}

}