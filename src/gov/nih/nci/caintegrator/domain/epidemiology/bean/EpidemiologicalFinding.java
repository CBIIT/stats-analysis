package gov.nih.nci.caintegrator.domain.epidemiology.bean;

import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;

import java.util.Collection;

public class EpidemiologicalFinding  {

    private Long id;
    private String relativeWithLungCancer;
    private StudyParticipant studyParticipant;
    private Lifestyle lifestyle;
    private BehavioralAssessment behavioralAssessment;
    private Collection<DietaryConsumption> dietaryConsumptionCollection;
    private Collection<TobaccoConsumption> tobaccoConsumptionCollection;
    private Collection<Relative> relativeCollection;
    private Collection<EnvironmentalFactor> environmentalFactorCollection;


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

    public Collection<Relative> getRelativeCollection() {
        return relativeCollection;
    }

    public void setRelativeCollection(Collection<Relative> lungCancerRelativeCollection) {
        this.relativeCollection = lungCancerRelativeCollection;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudyParticipant getStudyParticipant() {
        return studyParticipant;
    }

    public void setStudyParticipant(StudyParticipant studyParticipant) {
        this.studyParticipant = studyParticipant;
    }

    public String getRelativeWithLungCancer() {
        return relativeWithLungCancer;
    }

    public void setRelativeWithLungCancer(String relativeWithLungCancer) {
        this.relativeWithLungCancer = relativeWithLungCancer;
    }
    
}
