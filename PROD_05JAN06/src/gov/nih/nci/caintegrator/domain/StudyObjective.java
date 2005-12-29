package gov.nih.nci.caintegrator.domain;





/**
 * The high-level reason for executing a study including the scientific question to be answered and the treatment goals
 * such as 'relief of pain', 'prevention of disease', etc...
 * 
 * DSAM: The reason for executing a study in terms of a scientific question to be answered by the data collected during
 * the study. [modified CDISC]
 * @created 18-Nov-2005 01:57:02 PM
 */
public class StudyObjective {

	private Long id;
	/**
	 * A free text field that describes the study objectives
	 */
	private String description;
	/**
	 * A categorization of the purpose of the study, such as proof of efficacy, safety, dose finding, bioequivalence, etc.
	 * [modified CDISC]
	 */
	private String intentCode;
	/**
	 * The degree of importance of a particular objective in the context of a study.  The primary objective is the main
	 * question to be answered and usually drives any statistical planning for the study (e.g., calculation of the sample size
	 * to provide the appropriate power for statistical testing). NOTE: there can only be one primary objective.  Secondary
	 * objectives are deemed to be of fundamental importance to the study but are subsidiary to the primary objective.
	 * Ancillary objectives provide further information on the goals of the study.
	 */
	private String objectiveType;

	public StudyObjective(){

	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
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
	 * @return Returns the intentCode.
	 */
	public String getIntentCode() {
		return intentCode;
	}

	/**
	 * @param intentCode The intentCode to set.
	 */
	public void setIntentCode(String intentCode) {
		this.intentCode = intentCode;
	}

	/**
	 * @return Returns the objectiveType.
	 */
	public String getObjectiveType() {
		return objectiveType;
	}

	/**
	 * @param objectiveType The objectiveType to set.
	 */
	public void setObjectiveType(String objectiveType) {
		this.objectiveType = objectiveType;
	}

}