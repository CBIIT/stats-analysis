package gov.nih.nci.caintegrator.domain;





/**
 * A primary or secondary outcome that can be measured objectively to determine whether or not an intervention under study
 * is beneficial. The endpoints of a clinical trial are usually included in the study objectives. Some examples of
 * endpoints are survival, improvements in quality of life, relief of symptoms, and disappearance of the tumor.
 * 
 * BRIDG: An outcome variable of interest in the study. An outcome is a change in subject status established by comparing
 * two or more observations on that status as a result of a study-defined intervention (paraphrase of Peter Shaughnessy).
 * The values that are assessed to meet or not meet endpoints are data gathered as a result of study events.
 * @created 18-Nov-2005 01:56:43 PM
 */
public class Endpoint {

	private Long id;
	/**
	 * The concept is described by the attribute name.
	 */
	private String description;
	/**
	 * An alphanumeric string that identifies a specific endpoint or category of endpoints. For example, Common Terminology
	 * Codes (CTCs) for adverse events in cancer.
	 */
	private String code;
	private EndPointType endPointType;
	public enum EndPointType {primary, secondary};
	/**
	 * The value of the endpoint variable that determines efficacy. For example, where endpoint is response to chemotherapy,
	 * the threshold could be a 20% decrease in tumor size.
	 */
	private String threshold;

	public Endpoint(){

	}

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return Returns the endPointType.
	 */
	public EndPointType getEndPointType() {
		return endPointType;
	}

	/**
	 * @param endPointType The endPointType to set.
	 */
	public void setEndPointType(EndPointType endPointType) {
		this.endPointType = endPointType;
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
	 * @return Returns the threshold.
	 */
	public String getThreshold() {
		return threshold;
	}

	/**
	 * @param threshold The threshold to set.
	 */
	public void setThreshold(String threshold) {
		this.threshold = threshold;
	}

}