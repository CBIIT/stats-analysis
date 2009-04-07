package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/
/**
 * A class containing information on the collection and processing of a DNA sample
 * from one of the CGEMS subjects.
 *
 */
public class DNASpecimenCriteria {

	/**
	 * The method (if any) of amplifying DNA extracted from a biological source before
	 * being assayed for genotypes
	 */
	private String dnaAmplificationMethod;
	/**
	 * Chemical process or commercial product used to extract DNA from the source
	 * biological material
	 */
	private String dnaExtractionMethod;
	/**
	 * structural form of DNA comprising the sample.  Possible values include GENOMIC,
	 * WGA (whole-genome amplified), MT (mitocondrial)
	 */
	private String dnaMaterialType;
	private String id;
	private String materialType;
	private String specimenIdentifier;

	public DNASpecimenCriteria(){

	}

}