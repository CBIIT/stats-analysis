package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * The treatment arm and other specifics regarding the participation of the Subject to a particular Study.
 * @created 18-Nov-2005 01:57:05 PM
 */
public class SubjectAssignment {

	private Long id;
	/**
	 * The unique number assigned to identify a patient on a study.
	 */
	private String studySubjectIdentifier;
	/**
	 * Protocol-specific arm assignment identified in a formal communication.
	 * NOTE:  When Activity.epochName is "Prior" or "Baseline" -- we will default the arm value
	 */
	private String arm;
	/**
	 * The date the patient acknowledged participation on the protocol by signing the informed consent docume
	 */
	private Date informedConsentFormSignedDate;
	/**
	 * The date when the patient is removed from the protocol, i.e., is not being followed and will not be retreated
	 */
	private Date offStudyDate;
	/**
	 * A unique code for identification of uniform groups of patients for separate analysis or treatment is defined in the
	 * Clinical Data Update System (CDUS) Version 2.0. Use the codes submitted to CTEP on the Protocol Submission Checklist.
	 * NOTE: Also maps to Patient Subgroup Assignment	2003305.
	 */
	private String subgroupCode;
	/**
	 * The reason that a subject is given a sponsor-approved waiver for meeting protocol-defined eligibility requirements.  
	 */
	private String eligibilityWaiverReason;
	/**
	 * The date of approval of eligibility criteria by NCI.
	 */
	private Date eligibilityCriteriaApprovalDate;
	/**
	 * Age at the time of study enrollment, expressed in number of years completed at the last birthday. Value is collected to
	 * two decimal points of precision to meet Clinical Trials Monitoring Service (CTMS) reporting requirements.
	 */
	private Integer ageAtEnrollment;
	/**
	 * the yes/no indicator whether the informed consent form was signed. 
	 */
	private String informedConsentSignedInd;
	/**
	 * Work in Progress: DSAM- a time interval in the planned conduct of a study. Values include: Baseline, Screening, Run-in,
	 * Treatment, Follow-Up, etc.
	 */
	private String epochName;
	/**
	 * The classification of the sex or gender role of the patient. Values include: Female, Male, Unknown.
	 */
	private String administrativeGenderCode;
	/**
	 * The patient's self declared racial origination, independent of ethnic origination, using OMB approved categories.
	 * Values include: Not Reported, American Indian or Alaska Native, Native Hawaiian or other Pacific Islander, Unknown,
	 * Asian, White, Black or African American.
	 */
	private String raceCode;
	/**
	 * The patient's self declared ethnic origination, independent of racial origination, based on OMB approved categories.
	 * Values include: Hispanic Or Latino, Unknown, Not reported, Not Hispanic Or Latino.
	 */
	private String ethnicGroupCode;
	/**
	 * The date when the Patient who was participating in the study died.
	 */
	private Date dateOfDeath;
	/**
	 * The age at which the Patient who was participating in the study was diagnosed
	 */
	private Integer ageAtDiagnosis;

	public SubjectAssignment(){

	}

	/**
	 * @return Returns the administrativeGenderCode.
	 */
	public String getAdministrativeGenderCode() {
		return administrativeGenderCode;
	}

	/**
	 * @param administrativeGenderCode The administrativeGenderCode to set.
	 */
	public void setAdministrativeGenderCode(String administrativeGenderCode) {
		this.administrativeGenderCode = administrativeGenderCode;
	}

	/**
	 * @return Returns the ageAtDiagnosis.
	 */
	public Integer getAgeAtDiagnosis() {
		return ageAtDiagnosis;
	}

	/**
	 * @param ageAtDiagnosis The ageAtDiagnosis to set.
	 */
	public void setAgeAtDiagnosis(Integer ageAtDiagnosis) {
		this.ageAtDiagnosis = ageAtDiagnosis;
	}

	/**
	 * @return Returns the ageAtEnrollment.
	 */
	public Integer getAgeAtEnrollment() {
		return ageAtEnrollment;
	}

	/**
	 * @param ageAtEnrollment The ageAtEnrollment to set.
	 */
	public void setAgeAtEnrollment(Integer ageAtEnrollment) {
		this.ageAtEnrollment = ageAtEnrollment;
	}

	/**
	 * @return Returns the arm.
	 */
	public String getArm() {
		return arm;
	}

	/**
	 * @param arm The arm to set.
	 */
	public void setArm(String arm) {
		this.arm = arm;
	}

	/**
	 * @return Returns the dateOfDeath.
	 */
	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	/**
	 * @param dateOfDeath The dateOfDeath to set.
	 */
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	/**
	 * @return Returns the eligibilityCriteriaApprovalDate.
	 */
	public Date getEligibilityCriteriaApprovalDate() {
		return eligibilityCriteriaApprovalDate;
	}

	/**
	 * @param eligibilityCriteriaApprovalDate The eligibilityCriteriaApprovalDate to set.
	 */
	public void setEligibilityCriteriaApprovalDate(
			Date eligibilityCriteriaApprovalDate) {
		this.eligibilityCriteriaApprovalDate = eligibilityCriteriaApprovalDate;
	}

	/**
	 * @return Returns the eligibilityWaiverReason.
	 */
	public String getEligibilityWaiverReason() {
		return eligibilityWaiverReason;
	}

	/**
	 * @param eligibilityWaiverReason The eligibilityWaiverReason to set.
	 */
	public void setEligibilityWaiverReason(String eligibilityWaiverReason) {
		this.eligibilityWaiverReason = eligibilityWaiverReason;
	}

	/**
	 * @return Returns the epochName.
	 */
	public String getEpochName() {
		return epochName;
	}

	/**
	 * @param epochName The epochName to set.
	 */
	public void setEpochName(String epochName) {
		this.epochName = epochName;
	}

	/**
	 * @return Returns the ethnicGroupCode.
	 */
	public String getEthnicGroupCode() {
		return ethnicGroupCode;
	}

	/**
	 * @param ethnicGroupCode The ethnicGroupCode to set.
	 */
	public void setEthnicGroupCode(String ethnicGroupCode) {
		this.ethnicGroupCode = ethnicGroupCode;
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
	 * @return Returns the informedConsentFormSignedDate.
	 */
	public Date getInformedConsentFormSignedDate() {
		return informedConsentFormSignedDate;
	}

	/**
	 * @param informedConsentFormSignedDate The informedConsentFormSignedDate to set.
	 */
	public void setInformedConsentFormSignedDate(Date informedConsentFormSignedDate) {
		this.informedConsentFormSignedDate = informedConsentFormSignedDate;
	}

	/**
	 * @return Returns the informedConsentSignedInd.
	 */
	public String getInformedConsentSignedInd() {
		return informedConsentSignedInd;
	}

	/**
	 * @param informedConsentSignedInd The informedConsentSignedInd to set.
	 */
	public void setInformedConsentSignedInd(String informedConsentSignedInd) {
		this.informedConsentSignedInd = informedConsentSignedInd;
	}

	/**
	 * @return Returns the offStudyDate.
	 */
	public Date getOffStudyDate() {
		return offStudyDate;
	}

	/**
	 * @param offStudyDate The offStudyDate to set.
	 */
	public void setOffStudyDate(Date offStudyDate) {
		this.offStudyDate = offStudyDate;
	}

	/**
	 * @return Returns the raceCode.
	 */
	public String getRaceCode() {
		return raceCode;
	}

	/**
	 * @param raceCode The raceCode to set.
	 */
	public void setRaceCode(String raceCode) {
		this.raceCode = raceCode;
	}

	/**
	 * @return Returns the studySubjectIdentifier.
	 */
	public String getStudySubjectIdentifier() {
		return studySubjectIdentifier;
	}

	/**
	 * @param studySubjectIdentifier The studySubjectIdentifier to set.
	 */
	public void setStudySubjectIdentifier(String studySubjectIdentifier) {
		this.studySubjectIdentifier = studySubjectIdentifier;
	}

	/**
	 * @return Returns the subgroupCode.
	 */
	public String getSubgroupCode() {
		return subgroupCode;
	}

	/**
	 * @param subgroupCode The subgroupCode to set.
	 */
	public void setSubgroupCode(String subgroupCode) {
		this.subgroupCode = subgroupCode;
	}

}