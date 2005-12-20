package gov.nih.nci.caintegrator.domain;





/**
 * A single cell of the quantitation, bioAssay, designElement matrix
 * @version 1.0
 * @created 18-Nov-2005 01:56:33 PM
 */
public class ArrayBioAssayDatum {

	private Long id;
	/**
	 * readout from each cell
	 */
	private Float value;
	/**
	 * Type of readout for each cell
	 */
	private String quantitationType;
	private Reporter reporter;

	public ArrayBioAssayDatum(){

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
	 * @return Returns the quantitationType.
	 */
	public String getQuantitationType() {
		return quantitationType;
	}

	/**
	 * @param quantitationType The quantitationType to set.
	 */
	public void setQuantitationType(String quantitationType) {
		this.quantitationType = quantitationType;
	}

	/**
	 * @return Returns the reporter.
	 */
	public Reporter getReporter() {
		return reporter;
	}

	/**
	 * @param reporter The reporter to set.
	 */
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
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