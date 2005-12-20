package gov.nih.nci.caintegrator.domain;





/**
 * A pharmaceutical product, vitamin, mineral, food supplement or a combination that are being used or tested as part of a
 * clinical trial.
 * @created 18-Nov-2005 01:57:02 PM
 */
public class StudyAgent {

	private Long id;
	/**
	 * A yes/no value indicating if the agent is an Investigational New Drug (IND)
	 */
	private Boolean investigationalInd;

	public StudyAgent(){

	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Returns the investigationalInd.
	 */
	public Boolean getInvestigationalInd() {
		return investigationalInd;
	}

	/**
	 * @param investigationalInd The investigationalInd to set.
	 */
	public void setInvestigationalInd(Boolean investigationalInd) {
		this.investigationalInd = investigationalInd;
	}

}