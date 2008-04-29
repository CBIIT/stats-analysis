package gov.nih.nci.caintegrator.domain.finding.clinical.brainCancer;

import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;

public class GBMClinicalFinding extends ClinicalFinding {
		
	private ClinicalAssessment PATIENT_ID;
	private ClinicalAssessment TUMOR_TISSUE_SITE;
	private ClinicalAssessment VITAL_STATUS;
	private ClinicalAssessment DOB;
	private ClinicalAssessment DOD;
	private ClinicalAssessment LAST_FOLLOW_UP;
	private ClinicalAssessment INFORMED_CONSENT_ACQUIRED;
	private ClinicalAssessment FIRST_PROCEDURE;
	private ClinicalAssessment FIRST_EXAM;
	private NumericMeasurement KARNOFSKY_SCORE;
	private ClinicalAssessment FIRST_RADIATION;
	private NumericMeasurement DOD_MINUS_DOP;
	private NumericMeasurement DODFU_MINUS_DOP;
	private ClinicalAssessment GENDER;
	private ClinicalAssessment PTID;
	
	public ClinicalAssessment getPATIENT_ID() {
		return PATIENT_ID;
	}
	public void setPATIENT_ID(ClinicalAssessment patient_id) {
		PATIENT_ID = patient_id;
	}
	public ClinicalAssessment getTUMOR_TISSUE_SITE() {
		return TUMOR_TISSUE_SITE;
	}
	public void setTUMOR_TISSUE_SITE(ClinicalAssessment tumor_tissue_site) {
		TUMOR_TISSUE_SITE = tumor_tissue_site;
	}
	public ClinicalAssessment getVITAL_STATUS() {
		return VITAL_STATUS;
	}
	public void setVITAL_STATUS(ClinicalAssessment vital_status) {
		VITAL_STATUS = vital_status;
	}
	public ClinicalAssessment getDOB() {
		return DOB;
	}
	public void setDOB(ClinicalAssessment dob) {
		DOB = dob;
	}
	public ClinicalAssessment getDOD() {
		return DOD;
	}
	public void setDOD(ClinicalAssessment dod) {
		DOD = dod;
	}
	public ClinicalAssessment getLAST_FOLLOW_UP() {
		return LAST_FOLLOW_UP;
	}
	public void setLAST_FOLLOW_UP(ClinicalAssessment last_follow_up) {
		LAST_FOLLOW_UP = last_follow_up;
	}
	public ClinicalAssessment getINFORMED_CONSENT_ACQUIRED() {
		return INFORMED_CONSENT_ACQUIRED;
	}
	public void setINFORMED_CONSENT_ACQUIRED(
			ClinicalAssessment informed_consent_acquired) {
		INFORMED_CONSENT_ACQUIRED = informed_consent_acquired;
	}
	public ClinicalAssessment getFIRST_PROCEDURE() {
		return FIRST_PROCEDURE;
	}
	public void setFIRST_PROCEDURE(ClinicalAssessment first_procedure) {
		FIRST_PROCEDURE = first_procedure;
	}
	public ClinicalAssessment getFIRST_EXAM() {
		return FIRST_EXAM;
	}
	public void setFIRST_EXAM(ClinicalAssessment first_exam) {
		FIRST_EXAM = first_exam;
	}
	public NumericMeasurement getKARNOFSKY_SCORE() {
		return KARNOFSKY_SCORE;
	}
	public void setKARNOFSKY_SCORE(NumericMeasurement karnofsky_score) {
		KARNOFSKY_SCORE = karnofsky_score;
	}
	public ClinicalAssessment getFIRST_RADIATION() {
		return FIRST_RADIATION;
	}
	public void setFIRST_RADIATION(ClinicalAssessment first_radiation) {
		FIRST_RADIATION = first_radiation;
	}
	public NumericMeasurement getDOD_MINUS_DOP() {
		return DOD_MINUS_DOP;
	}
	public void setDOD_MINUS_DOP(NumericMeasurement dod_minus_dop) {
		DOD_MINUS_DOP = dod_minus_dop;
	}
	public NumericMeasurement getDODFU_MINUS_DOP() {
		return DODFU_MINUS_DOP;
	}
	public void setDODFU_MINUS_DOP(NumericMeasurement dodfu_minus_dop) {
		DODFU_MINUS_DOP = dodfu_minus_dop;
	}
	public ClinicalAssessment getGENDER() {
		return GENDER;
	}
	public void setGENDER(ClinicalAssessment gender) {
		GENDER = gender;
	}
	public ClinicalAssessment getPTID() {
		return PTID;
	}
	public void setPTID(ClinicalAssessment ptid) {
		PTID = ptid;
	}
	
}
