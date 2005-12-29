package gov.nih.nci.caintegrator.domain.finding.genomic.loh;
import gov.nih.nci.caintegrator.domain.Reporter;





/**
 * Loss of Heterozygosity (LOH) data for one reporter in a hybridization
 * @version 1.0
 * @created 18-Nov-2005 01:56:50 PM
 */
public class LOHFinding {

	private Long id;
	/**
	 * confidence value for the LOH score
	 */
	private Float pValue;
	/**
	 * Probability of LOH at a particular genomic locus
	 */
	private Float lossOfHeterozygosityScore;
	/**
	 * Normal alleles at a genomic locus; eg: AA, AB, BB
	 */
	private String referenceAllele;
	/**
	 * Alleles in the tumor sample. eg: AA, AB, BB
	 */
	private String sampleAllele;
	private Reporter reporter;

	public LOHFinding(){

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
	 * @return Returns the lossOfHeterozygosityScore.
	 */
	public Float getLossOfHeterozygosityScore() {
		return lossOfHeterozygosityScore;
	}

	/**
	 * @param lossOfHeterozygosityScore The lossOfHeterozygosityScore to set.
	 */
	public void setLossOfHeterozygosityScore(Float lossOfHeterozygosityScore) {
		this.lossOfHeterozygosityScore = lossOfHeterozygosityScore;
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
	 * @return Returns the referenceAllele.
	 */
	public String getReferenceAllele() {
		return referenceAllele;
	}

	/**
	 * @param referenceAllele The referenceAllele to set.
	 */
	public void setReferenceAllele(String referenceAllele) {
		this.referenceAllele = referenceAllele;
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
	 * @return Returns the sampleAllele.
	 */
	public String getSampleAllele() {
		return sampleAllele;
	}

	/**
	 * @param sampleAllele The sampleAllele to set.
	 */
	public void setSampleAllele(String sampleAllele) {
		this.sampleAllele = sampleAllele;
	}

}