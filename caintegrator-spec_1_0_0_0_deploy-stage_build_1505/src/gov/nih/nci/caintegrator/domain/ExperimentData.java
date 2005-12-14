package gov.nih.nci.caintegrator.domain;





/**
 * The lab dataset from processing a biospeciman.
 * @version 1.0
 * @created 18-Nov-2005 01:56:43 PM
 */
public abstract class ExperimentData {

	private Long id;

	public ExperimentData(){

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

}