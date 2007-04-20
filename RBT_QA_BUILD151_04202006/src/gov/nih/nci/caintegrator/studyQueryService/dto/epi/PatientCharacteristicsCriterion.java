package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class PatientCharacteristicsCriterion {

	private Integer ageLowerLimit;
	private Integer ageUpperLimit;
	private Float heightInCentiMeters;
	private Float waistCircumferenceCentiMeters;
	private Float weightInKilograms;
	public Gender selfReportedgender;
	public SocioEconomicStatus socioEconomicStatus;
	public MaritalStatus maritalStatus;
	public EducationLevel educationLevel;

	public PatientCharacteristicsCriterion(){

	}

    public Integer getAgeLowerLimit() {
        return ageLowerLimit;
    }

    public void setAgeLowerLimit(Integer ageLowerLimit) {
        this.ageLowerLimit = ageLowerLimit;
    }

    public Integer getAgeUpperLimit() {
        return ageUpperLimit;
    }

    public void setAgeUpperLimit(Integer ageUpperLimit) {
        this.ageUpperLimit = ageUpperLimit;
    }

    public Float getHeightInCentiMeters() {
        return heightInCentiMeters;
    }

    public void setHeightInCentiMeters(Float heightInCentiMeters) {
        this.heightInCentiMeters = heightInCentiMeters;
    }

    public Float getWaistCircumferenceCentiMeters() {
        return waistCircumferenceCentiMeters;
    }

    public void setWaistCircumferenceCentiMeters(Float waistCircumferenceCentiMeters) {
        this.waistCircumferenceCentiMeters = waistCircumferenceCentiMeters;
    }

    public Float getWeightInKilograms() {
        return weightInKilograms;
    }

    public void setWeightInKilograms(Float weightInKilograms) {
        this.weightInKilograms = weightInKilograms;
    }

    public Gender getSelfReportedgender() {
        return selfReportedgender;
    }

    public void setSelfReportedgender(Gender selfReportedgender) {
        this.selfReportedgender = selfReportedgender;
    }

    public SocioEconomicStatus getSocioEconomicStatus() {
        return socioEconomicStatus;
    }

    public void setSocioEconomicStatus(SocioEconomicStatus socioEconomicStatus) {
        this.socioEconomicStatus = socioEconomicStatus;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

}