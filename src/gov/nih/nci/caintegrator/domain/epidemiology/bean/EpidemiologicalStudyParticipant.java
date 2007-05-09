package gov.nih.nci.caintegrator.domain.epidemiology.bean;

import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;

import java.util.Collection;

public class EpidemiologicalStudyParticipant extends StudyParticipant {

    private Lifestyle lifestyle;
    private BehavioralAssessment behavioralAssessment;
    private Collection<DietaryConsumption> dietaryConsumptionCollection;
    private Collection<TobaccoConsumption> tobaccoConsumptionCollection;
    private Collection<Relative> lungCancerRelativeCollection;
    private Collection<Relative> smokingRelativeCollection;
    private Collection<EnvironmentalFactor> environmentalFactorCollection;

    public Collection<Relative> getSmokingRelativeCollection() {
        return smokingRelativeCollection;
    }

    public void setSmokingRelativeCollection(Collection<Relative> smokingRelativeCollection) {
        this.smokingRelativeCollection = smokingRelativeCollection;
    }

    public Collection<DietaryConsumption> getDietaryConsumptionCollection() {
        return dietaryConsumptionCollection;
    }

    public void setDietaryConsumptionCollection(Collection<DietaryConsumption> dietaryConsumptionCollection) {
        this.dietaryConsumptionCollection = dietaryConsumptionCollection;
    }

    public Collection<TobaccoConsumption> getTobaccoConsumptionCollection() {
        return tobaccoConsumptionCollection;
    }

    public void setTobaccoConsumptionCollection(Collection<TobaccoConsumption> tobaccoConsumptionCollection) {
        this.tobaccoConsumptionCollection = tobaccoConsumptionCollection;
    }

    public Collection<Relative> getLungCancerRelativeCollection() {
        return lungCancerRelativeCollection;
    }

    public void setLungCancerRelativeCollection(Collection<Relative> lungCancerRelativeCollection) {
        this.lungCancerRelativeCollection = lungCancerRelativeCollection;
    }

    public Collection<EnvironmentalFactor> getEnvironmentalFactorCollection() {
        return environmentalFactorCollection;
    }

    public void setEnvironmentalFactorCollection(Collection<EnvironmentalFactor> environmentalFactorCollection) {
        this.environmentalFactorCollection = environmentalFactorCollection;
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
