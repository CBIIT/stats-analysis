package gov.nih.nci.cgems.dto;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/
/**
 * Information on the design characteristics of a molecular test for the presence
 * of one or both alleles at a SNP locus.
 */
public class SNPAssayCriteria {

	/**
	 * SNP alleles specified in the nucleotide sequence used to design the assay
	 */
	private String designAlleles;
	/**
	 * design score assigned by the vendor to indicate the probability of converting
	 * the design into a valid assay
	 */
	private Float designScore;
	/**
	 * nucleotide sequence used to design the assay
	 */
	private String designSequence;
	/**
	 * the orientation of the SNP design sequence to the NCBI reference sequence
	 */
	private String designStrand;
	/**
	 * Unique identifier
	 */
	private String id;
	/**
	 * a global quality flag for that assay that indicates the reliability and
	 * validity of genotypes derived from the assay
	 */
	private String status;
	/**
	 * vendor specified idenfifier for the assay
	 */
	private String vendorAssayId;
	/**
	 * vendor assigned version identifier for the assay
	 */
	private String version;

	public SNPAssayCriteria(){

	}

}