package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class PatientCharacteristicsCriterion {

	private Integer ageLowerLimit;
	private Integer ageUpperLimit;
	private Float heightLowerLimit;
    private Float heightUpperLimit;
    private Float waistLowerLimit;
    private Float waisUpperLimit;
    private Float weightLowerLimit;
    private Float weightUpperLimit;

    // TODO:
    private ResidentialArea areas;

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

    public Float getHeightLowerLimit() {
        return heightLowerLimit;
    }

    public void setHeightLowerLimit(Float heightLowerLimit) {
        this.heightLowerLimit = heightLowerLimit;
    }

    public Float getHeightUpperLimit() {
        return heightUpperLimit;
    }

    public void setHeightUpperLimit(Float heightUpperLimit) {
        this.heightUpperLimit = heightUpperLimit;
    }

    public Float getWaistLowerLimit() {
        return waistLowerLimit;
    }

    public void setWaistLowerLimit(Float waistLowerLimit) {
        this.waistLowerLimit = waistLowerLimit;
    }

    public Float getWaisUpperLimit() {
        return waisUpperLimit;
    }

    public void setWaisUpperLimit(Float waisUpperLimit) {
        this.waisUpperLimit = waisUpperLimit;
    }

    public Float getWeightLowerLimit() {
        return weightLowerLimit;
    }

    public void setWeightLowerLimit(Float weightLowerLimit) {
        this.weightLowerLimit = weightLowerLimit;
    }

    public Float getWeightUpperLimit() {
        return weightUpperLimit;
    }

    public void setWeightUpperLimit(Float weightUpperLimit) {
        this.weightUpperLimit = weightUpperLimit;
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