package gov.nih.nci.caintegrator.domain;





/**
 * Specifies the routine of gathering and/or locating the sites for body samples, such as, urine, blood, biopsies, etc. to
 * be used in the conduct of a clinical trial
 * 
 * NOTE: consider renaming to Accession -- caBIG Tissue Bank.
 * @created 18-Nov-2005 01:57:01 PM
 */
public class SpecimenCollection extends Procedure {

	/**
	 * The type of the site where specimen/sample has been collected. Values include Normal or Abnormal.
	 * NOTE: Also maps to Tissue Class 2003905.
	 */
	private String siteCondition;
	/**
	 * The type of procedure or method used to collect the specimen. Values include: Abdominal/ ascites effusion; Biopsy;
	 * Bronchial alveolar lavage (BAL); Bronchial brushing; Bronchial secretions; Bronchial washing; Bucal brushing; Fine
	 * needle aspiration, specify site; Frozen Biopsy; Mediastinoscopy; Other, specify; Pericardial effusion; Pleural effusion;
	 * Pleural lavage; Sputum, induced; Sputum, spontaneous.
	 * NOTE: Also maps to Specimen Collection Method Other 2006730 and Specimen Collection Method Type 2008060.
	 */
	private String method;

	public SpecimenCollection(){

	}

	/**
	 * @return Returns the method.
	 */
	public String getMethod() {
		return method;
	}

	/**
	 * @param method The method to set.
	 */
	public void setMethod(String method) {
		this.method = method;
	}

	/**
	 * @return Returns the siteCondition.
	 */
	public String getSiteCondition() {
		return siteCondition;
	}

	/**
	 * @param siteCondition The siteCondition to set.
	 */
	public void setSiteCondition(String siteCondition) {
		this.siteCondition = siteCondition;
	}

}