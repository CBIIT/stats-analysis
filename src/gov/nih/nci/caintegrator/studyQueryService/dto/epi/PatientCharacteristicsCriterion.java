package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class PatientCharacteristicsCriterion {

	private Double ageLowerLimit;

    public void setAgeLowerLimit(Double ageLowerLimit) {
        this.ageLowerLimit = ageLowerLimit;
    }

    private Double ageUpperLimit;
	private Double heightLowerLimit;
    private Double heightUpperLimit;
    private Double waistLowerLimit;
    private Double waisUpperLimit;
    private Double weightLowerLimit;
    private Double weightUpperLimit;

    private ResidentialArea residentialArea;
    private Religion religion;

    public Gender selfReportedgender;
	public SocioEconomicStatus socioEconomicStatus;
	public MaritalStatus maritalStatus;
	public EducationLevel educationLevel;

	public PatientCharacteristicsCriterion(){

	}

    public ResidentialArea getResidentialArea() {
        return residentialArea;
    }

    public void setResidentialArea(ResidentialArea residentialArea) {
        this.residentialArea = residentialArea;
    }

    public Religion getReligion() {
        return religion;
    }

    public void setReligion(Religion religion) {
        this.religion = religion;
    }

    public Double getAgeLowerLimit() {
        return ageLowerLimit;
    }

    public Double getAgeUpperLimit() {
        return ageUpperLimit;
    }

    public void setAgeUpperLimit(Double ageUpperLimit) {
        this.ageUpperLimit = ageUpperLimit;
    }

    public Double getHeightLowerLimit() {
        return heightLowerLimit;
    }

    public void setHeightLowerLimit(Double heightLowerLimit) {
        this.heightLowerLimit = heightLowerLimit;
    }

    public Double getHeightUpperLimit() {
        return heightUpperLimit;
    }

    public void setHeightUpperLimit(Double heightUpperLimit) {
        this.heightUpperLimit = heightUpperLimit;
    }

    public Double getWaistLowerLimit() {
        return waistLowerLimit;
    }

    public void setWaistLowerLimit(Double waistLowerLimit) {
        this.waistLowerLimit = waistLowerLimit;
    }

    public Double getWaisUpperLimit() {
        return waisUpperLimit;
    }

    public void setWaisUpperLimit(Double waisUpperLimit) {
        this.waisUpperLimit = waisUpperLimit;
    }

    public Double getWeightLowerLimit() {
        return weightLowerLimit;
    }

    public void setWeightLowerLimit(Double weightLowerLimit) {
        this.weightLowerLimit = weightLowerLimit;
    }

    public Double getWeightUpperLimit() {
        return weightUpperLimit;
    }

    public void setWeightUpperLimit(Double weightUpperLimit) {
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