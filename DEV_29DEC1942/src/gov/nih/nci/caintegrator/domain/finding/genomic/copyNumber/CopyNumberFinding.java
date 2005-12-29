package gov.nih.nci.caintegrator.domain.finding.genomic.copyNumber;
import gov.nih.nci.caintegrator.domain.Reporter;





/**
 * estimated copy number data for one reporter in a hybridization
 * @version 1.0
 * @created 18-Nov-2005 01:56:41 PM
 */
public class CopyNumberFinding {

	private Long id;
	/**
	 * value obtained for each reporter (SNP reporter or BAC reporter) in a hybridization that estimates the DNA copy number
	 * for a genomic locus represented by the reporter
	 */
	private Float estimatedCopyNumber;
	/**
	 * confidence value for the copy number estimation
	 */
	private Float pValue;
	private Reporter reporter;

	public CopyNumberFinding(){

	}

	/**
	 * @return Returns the estimatedCopyNumber.
	 */
	public Float getEstimatedCopyNumber() {
		return estimatedCopyNumber;
	}

	/**
	 * @param estimatedCopyNumber The estimatedCopyNumber to set.
	 */
	public void setEstimatedCopyNumber(Float estimatedCopyNumber) {
		this.estimatedCopyNumber = estimatedCopyNumber;
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
	 * @return Returns the pValue.
	 */
	public Float getPValue() {
		return pValue;
	}

	/**
	 * @param value The pValue to set.
	 */
	public void setPValue(Float value) {
		pValue = value;
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

}