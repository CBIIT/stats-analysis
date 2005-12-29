package gov.nih.nci.caintegrator.domain;





/**
 * Analysis is the process that a Sample or Sample groups are put through.It could be an in-silico analysis on experiment
 * data or a clinical assessment on raw clinical data. Findings are results of Analysis. eg: Calss comparison analysis,
 * copy number analysis
 * @version 1.0
 * @created 18-Nov-2005 01:56:32 PM
 */
public abstract class Analysis {

	private Long id;
	/**
	 * A commonly known term for the procedure such as T-Test, F-Test
	 */
	private String algorithmName;
	/**
	 * A set of instructions that helps describes the analysis
	 */
	private String description;

	public Analysis(){

	}

	/**
	 * @return Returns the algorithmName.
	 */
	public String getAlgorithmName() {
		return algorithmName;
	}

	/**
	 * @param algorithmName The algorithmName to set.
	 */
	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
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

}