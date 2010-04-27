package gov.nih.nci.caintegrator.domain.epidemiology.bean;

import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;

import java.util.Collection;

public class EpidemiologicalStudyParticipant extends StudyParticipant {

    private Lifestyle lifestyle;
    private BehavioralAssessment behavioralAssessment;
    private Collection dietaryConsumptionCollection;
    private Collection tobaccoConsumptionCollection;
    private Collection relativeCollection;
    private Collection environmentalFactorCollection;
    
    
    public Collection getDietaryConsumptionCollection() {
        return dietaryConsumptionCollection;
    }
    public void setDietaryConsumptionCollection(
            Collection dietaryConsumptionCollection) {
        this.dietaryConsumptionCollection = dietaryConsumptionCollection;
    }
    public Collection getEnvironmentalFactorCollection() {
        return environmentalFactorCollection;
    }
    public void setEnvironmentalFactorCollection(
            Collection environmentalFactorCollection) {
        this.environmentalFactorCollection = environmentalFactorCollection;
    }
    public Collection getRelativeCollection() {
        return relativeCollection;
    }
    public void setRelativeCollection(Collection relativeCollection) {
        this.relativeCollection = relativeCollection;
    }
    public Collection getTobaccoConsumptionCollection() {
        return tobaccoConsumptionCollection;
    }
    public void setTobaccoConsumptionCollection(
            Collection tobaccoConsumptionCollection) {
        this.tobaccoConsumptionCollection = tobaccoConsumptionCollection;
    }
    public BehavioralAssessment getBehavioralAssessment() {
        return behavioralAssessment;
    }
    public void setBehavioralAssessment(BehavioralAssessment behavioralAssessment) {
        this.behavioralAssessment = behavioralAssessment;
    }
    public Lifestyle getLifestyle() {
        return lifestyle;
    }
    public void setLifestyle(Lifestyle lifestyle) {
        this.lifestyle = lifestyle;
    }
    
}
