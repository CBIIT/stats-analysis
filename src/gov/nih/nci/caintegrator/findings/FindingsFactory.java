package gov.nih.nci.caintegrator.findings;

import gov.nih.nci.caintegrator.ui.dto.QueryDTO;

/**
 * This interface will provide the method signatures of the
 * finding services available and pakaged in the caIntegrator
 * specification.
 * 
 * Whether this will use proxies will be determined by the 
 * finding strategies that it's impl uses.
 * 
 * @author BauerD
 *
 */
public interface FindingsFactory {
	/**
	 * Creates and returns a Kaplan-Meier Survival Plot finding result of
	 * the patients returned from the given query. 
	 * 
	 * @param query
	 * @return
	 */
	public KMFinding createKMFinding(QueryDTO query);
	/**
	 * Creates and returns a CopyNumberFinding for the query using
	 * the parameters for the given query.
	 * 
	 * @param query
	 * @return
	 */
	public CopyNumberFinding createCopyNumberFinding(QueryDTO query);
	
	/**
	 * Creates and returns a ClinicalFinding using the parameters
	 * of the given query described in the passed QueryDTO.
	 * @param query
	 * @return
	 */
	public ClinicalFinding createClinicalFinding(QueryDTO query);
	
	/**
	 * Creates and returns a ClassComparisonFinding using the parameters
	 * @param query
	 * @return
	 */
	public ClassComparisonFinding createClassComparisonFinding(QueryDTO query);
	/**
	 * Creates and returns a PCAFinding using the parameters of the given query 
	 * described in the passed QueryDTO.
	 * @param query
	 * @return
	 */
	public PCAFinding createPCAFinding(QueryDTO query);
	/**
	 * Creates and returns an HCAFinding from the given query described 
	 * in the passed QueryDTO.
	 * 
	 * @param query
	 * @return
	 */
	public HCAFinding createHCAFinding(QueryDTO query);
	/**
	 * Creates and returns a Gene Expression Intensity finding
	 * (GEIntensityFinding) from the given query described 
	 * in the passed QueryDTO.
	 * 
	 * @param query
	 * @return
	 */
	public GEIntensityFinding createGEIntensityFinding(QueryDTO query);
	
	
}
