package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;

import java.util.List;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   6:07:50 PM
**/

public class EPIQueryDTO implements QueryDTO {
    private String queryName;

    public String getQueryName() {
        return queryName;
    }

    public void setQueryName(String queryName) {
        this.queryName = queryName;
    }

    public BehavioralCriterion behavioralCriterion;
    public EnvironmentalTobaccoSmokeCriterion environmentalTobaccoSmokeCriterion;
    public FamilyHistoryCriterion familyHistoryCriterion;
    public java.util.List dietaryConsumptionCriterionCollection;
    public PatientCharacteristicsCriterion patientCharacteristicsCriterion;
    public TobaccoConsumptionCriterion tobaccoConsumptionCriterion;

    public EPIQueryDTO(){

    }

    public BehavioralCriterion getBehavioralCriterion() {
        return behavioralCriterion;
    }

    public void setBehavioralCriterion(BehavioralCriterion behavioralCriterion) {
        this.behavioralCriterion = behavioralCriterion;
    }

    public EnvironmentalTobaccoSmokeCriterion getEnvironmentalTobaccoSmokeCriterion() {
        return environmentalTobaccoSmokeCriterion;
    }

    public void setEnvironmentalTobaccoSmokeCriterion(EnvironmentalTobaccoSmokeCriterion environmentalTobaccoSmokeCriterion) {
        this.environmentalTobaccoSmokeCriterion = environmentalTobaccoSmokeCriterion;
    }

    public FamilyHistoryCriterion getFamilyHistoryCriterion() {
        return familyHistoryCriterion;
    }

    public void setFamilyHistoryCriterion(FamilyHistoryCriterion familyHistoryCriterion) {
        this.familyHistoryCriterion = familyHistoryCriterion;
    }

    public List getDietaryConsumptionCriterionCollection() {
        return dietaryConsumptionCriterionCollection;
    }

    public void setDietaryConsumptionCriterionCollection(List dietaryConsumptionCriterionCollection) {
        this.dietaryConsumptionCriterionCollection = dietaryConsumptionCriterionCollection;
    }

    public PatientCharacteristicsCriterion getPatientCharacteristicsCriterion() {
        return patientCharacteristicsCriterion;
    }

    public void setPatientCharacteristicsCriterion(PatientCharacteristicsCriterion patientCharacteristicsCriterion) {
        this.patientCharacteristicsCriterion = patientCharacteristicsCriterion;
    }

    public TobaccoConsumptionCriterion getTobaccoConsumptionCriterion() {
        return tobaccoConsumptionCriterion;
    }

    public void setTobaccoConsumptionCriterion(TobaccoConsumptionCriterion tobaccoConsumptionCriterion) {
        this.tobaccoConsumptionCriterion = tobaccoConsumptionCriterion;
    }
}