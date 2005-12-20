package gov.nih.nci.caintegrator.domain.finding.geneExpression.pca;





/**
 * The score of a principal component for a particular subject (e.g. BioAssayData).
 * @version 1.0
 * @created 18-Nov-2005 01:56:54 PM
 */
public class PrincipalComponentScore {

	private Long id;
	/**
	 * The actual value of the score. 
	 */
	private Float value;

	public PrincipalComponentScore(){

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
	 * @return Returns the value.
	 */
	public Float getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(Float value) {
		this.value = value;
	}

}