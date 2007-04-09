package gov.nih.nci.caintegrator.domain.epidemiology.bean;

import java.util.Collection;

public class Relative {

    private Long id;
    private String relationshipType;
    private Boolean alive;
    private Boolean livingCompanion;
    private Collection tobaccoConsumptionCollection;
    private Collection medicalConditionCollection;
    
    public Collection getMedicalConditionCollection() {
        return medicalConditionCollection;
    }
    public void setMedicalConditionCollection(Collection medicalConditionCollection) {
        this.medicalConditionCollection = medicalConditionCollection;
    }
    public Collection getTobaccoConsumptionCollection() {
        return tobaccoConsumptionCollection;
    }
    public void setTobaccoConsumptionCollection(
            Collection tobaccoConsumptionCollection) {
        this.tobaccoConsumptionCollection = tobaccoConsumptionCollection;
    }
    public Boolean isAlive() {
        return alive;
    }
    public void setAlive(Boolean alive) {
        this.alive = alive;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Boolean isLivingCompanion() {
        return livingCompanion;
    }
    public void setLivingCompanion(Boolean livingCompanion) {
        this.livingCompanion = livingCompanion;
    }
    public String getRelationshipType() {
        return relationshipType;
    }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }
}
