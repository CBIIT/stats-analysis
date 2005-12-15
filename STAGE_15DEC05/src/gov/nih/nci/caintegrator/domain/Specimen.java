package gov.nih.nci.caintegrator.domain;





/**
 * A part of a thing, or of several things, removed to demonstrate or to determine the character of the whole, e.g. a
 * substance, or portion of material obtained for use in testing, examination, or study; particularly, a preparation of
 * tissue or bodily fluid taken for observation, examination or diagnosis.
 * 
 * NOTE: Can be a sample of a collection or biopsy. (arc relationship)
 * @created 18-Nov-2005 01:57:01 PM
 */
public class Specimen {

	private Long id;
	/**
	 * A unique sample, I.D. number  (Is this the unique specimen identifier - USI?)
	 */
	private String sourceSpecimenID;
	/**
	 * Type of specimen/body tissue being sampled, using an enumerated set of values. Values include: V  Saliva, A  Aphaeresis
	 * Cells, B Whole Blood, C  CSF, D  CD33 Myeloid Cells, L  CD3 Lymphoid Cells, M  PBMC Peripheral Blood Mononuclear Cells,
	 * O Bone Marrow,
	 * P  Plasma, S  Serum, T  Tumor Tissue, U  Urine, Y  CD14/CD15 Myeloid Cells.    
	 */
	public enum SamplingType {V  /* Saliva */, A  /* Aphaeresis Cells */, B /* Whole Blood */, C /* CSF */, D /* CD33 Myeloid Cells */, L /* CD3 Lymphoid Cells */, M /* PBMC Peripheral Blood Mononuclear Cells */,
		 O /* Bone Marrow */, P  /* Plasma */, S /* Serum */, T /* Tumor Tissue */, U /* Urine */, Y  /* CD14/CD15 Myeloid Cells */}
	private SamplingType samplingType; 
	private String specimanSource;

	public Specimen(){

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
	 * @return Returns the samplingType.
	 */
	public SamplingType getSamplingType() {
		return samplingType;
	}

	/**
	 * @param samplingType The samplingType to set.
	 */
	public void setSamplingType(SamplingType samplingType) {
		this.samplingType = samplingType;
	}

	/**
	 * @return Returns the sourceSpecimenID.
	 */
	public String getSourceSpecimenID() {
		return sourceSpecimenID;
	}

	/**
	 * @param sourceSpecimenID The sourceSpecimenID to set.
	 */
	public void setSourceSpecimenID(String sourceSpecimenID) {
		this.sourceSpecimenID = sourceSpecimenID;
	}

	/**
	 * @return Returns the specimanSource.
	 */
	public String getSpecimanSource() {
		return specimanSource;
	}

	/**
	 * @param specimanSource The specimanSource to set.
	 */
	public void setSpecimanSource(String specimanSource) {
		this.specimanSource = specimanSource;
	}

}