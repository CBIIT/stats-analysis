package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class PatientCharacteristicsCriterion {

	private Integer ageLowerLimit;
	private Integer ageUpperLimit;
	private Float heightInFeet;
	private Float waistCircumferenceInInches;
	private Float weightInPounds;
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

    public Float getHeightInFeet() {
        return heightInFeet;
    }

    public void setHeightInFeet(Float heightInFeet) {
        this.heightInFeet = heightInFeet;
    }

    public Float getWaistCircumferenceInInches() {
        return waistCircumferenceInInches;
    }

    public void setWaistCircumferenceInInches(Float waistCircumferenceInInches) {
        this.waistCircumferenceInInches = waistCircumferenceInInches;
    }

    public Float getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(Float weightInPounds) {
        this.weightInPounds = weightInPounds;
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