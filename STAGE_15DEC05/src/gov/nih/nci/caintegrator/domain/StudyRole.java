package gov.nih.nci.caintegrator.domain;





/**
 * The responsibility of the organization on the study
 * @version 1.0
 * @created 18-Nov-2005 01:57:03 PM
 */
public class StudyRole {

	private Long id;
	/**
	 * role name; eg: Recruiting Institution, Sample Processing Institution, Sponsoring Institution
	 */
	private String name;

	public StudyRole(){

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