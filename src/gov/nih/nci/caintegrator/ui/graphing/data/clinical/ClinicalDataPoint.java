package gov.nih.nci.caintegrator.ui.graphing.data.clinical;

public class ClinicalDataPoint {
	
	public static enum ClinicalFactorType {AgeAtDx, Treatment, NeurologicalAssessment, Survival };
	public static enum PatientGenderType { Male, Female };
	
	private String patientId;
	private double ageAtDx;
	private String treatment;  
	private double neurologicalAssessment;
	private double survival;
	private PatientGenderType gender;
	
	public ClinicalDataPoint(String patientId) {
	  this.patientId = patientId;
	}

	public ClinicalDataPoint(String patientId,PatientGenderType gender,  double ageAtDx, String treatment, double neurologicalAssessment, double survival) {
	  this.patientId = patientId;
	  this.gender = gender;
	  this.ageAtDx = ageAtDx;
	  this.treatment = treatment;
	  this.neurologicalAssessment = neurologicalAssessment;
	  this.survival = survival;
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
	
}
