package gov.nih.nci.caintegrator.domain;





/**
 * The various name(s) attributed to a chemical or biological substance used as part of a study for the treatment or
 * prevention of disease.
 * @created 18-Nov-2005 01:56:31 PM
 */
public class AgentSynonym {

	private Long id;
	/**
	 * The alternate name for the agent.
	 */
	private String name;

	public AgentSynonym(){

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