package gov.nih.nci.caintegrator.domain;





/**
 * Results of an anlysis
 * @version 1.0
 * @created 18-Nov-2005 01:56:44 PM
 */
public abstract class Finding {

	private Long id;
	/**
	 * Identifier for the Finding, eg: tumorhistopatholoty, Lansky score, class comparision finding
	 */
	private String name;
	/**
	 * detailed information about the finding
	 */
	private String description;

	public Finding(){

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

}