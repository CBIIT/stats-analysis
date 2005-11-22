package gov.nih.nci.caintegrator.ui.graphing.data.clinical;

import gov.nih.nci.caintegrator.enumeration.ClinicalFactorType;

public class ClinicalDataPoint {
	
	
	public static enum PatientGenderType { Male, Female };
	
	private String patientId;
	private double ageAtDx;
	private String treatment;  
	private String diseaseName;
	private double neurologicalAssessment;
	private double survival;
	private PatientGenderType gender;
	private int diseaseGrade;
	
	public ClinicalDataPoint(String patientId) {
	  this.patientId = patientId;
	}

	public ClinicalDataPoint(String patientId,PatientGenderType gender, String diseaseName, int diseaseGrade, double ageAtDx, String treatment, double neurologicalAssessment, double survival) {
	  this.patientId = patientId;
	  this.gender = gender;
	  this.ageAtDx = ageAtDx;
	  this.treatment = treatment;
	  this.neurologicalAssessment = neurologicalAssessment;
	  this.survival = survival;
	  this.diseaseName = diseaseName;
	  this.diseaseGrade = diseaseGrade;
	}
	
	/**
	 * Return the value of the specified clinical factor. If an invalid component is
	 * specified, the function will return Double.NEGATIVE_INFINITY;
	 * @param component
	 * @return
	 */
	public double getFactorValue(ClinicalFactorType factor) {
	  switch(factor) {
	  case AgeAtDx: return getAgeAtDx();
	  case NeurologicalAssessment: return getNeurologicalAssessment();
	  case Survival: return getSurvival();
	  }
	  return Double.NEGATIVE_INFINITY;
	}

	public double getAgeAtDx() {
		return ageAtDx;
	}

	public void setAgeAtDx(double ageAtDx) {
		this.ageAtDx = ageAtDx;
	}

	public double getNeurologicalAssessment() {
		return neurologicalAssessment;
	}

	public void setNeurologicalAssessment(double neurologicalAssessment) {
		this.neurologicalAssessment = neurologicalAssessment;
	}

	public double getSurvival() {
		return survival;
	}

	public void setSurvival(double survival) {
		this.survival = survival;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getPatientId() {
		return patientId;
	}

	public PatientGenderType getGender() {
		return gender;
	}

	public void setGender(PatientGenderType gender) {
		this.gender = gender;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public int getDiseaseGrade() {
		return diseaseGrade;
	}

	public void setDiseaseGrade(int diseaseGrade) {
		this.diseaseGrade = diseaseGrade;
	}
}
