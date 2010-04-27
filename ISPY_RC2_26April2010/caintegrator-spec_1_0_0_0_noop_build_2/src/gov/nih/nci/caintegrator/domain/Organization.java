package gov.nih.nci.caintegrator.domain;





/**
 * A formalized group of persons or other organizations collected together for the purpose of the study
 * @created 18-Nov-2005 01:56:53 PM
 */
public class Organization {

	private Long id;
	/**
	 * Name of the organization or an institution invovled in the trial. (DCP)
	 */
	private String name;
	/**
	 * The type of organizational participation planned for this trial. (CTEP)
	 */
	private String description;
	private String statusCode;
	/**
	 * Short name for the organization. eg: NABTC for North American Brain Tumor Consortium
	 */
	private String acronym;

	public Organization(){

	}

	/**
	 * @return Returns the acronym.
	 */
	public String getAcronym() {
		return acronym;
	}

	/**
	 * @param acronym The acronym to set.
	 */
	public void setAcronym(String acronym) {
		this.acronym = acronym;
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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the statusCode.
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode The statusCode to set.
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}