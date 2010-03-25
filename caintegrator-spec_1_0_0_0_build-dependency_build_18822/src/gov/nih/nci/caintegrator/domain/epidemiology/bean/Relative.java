package gov.nih.nci.caintegrator.domain.epidemiology.bean;

import java.util.Collection;

public class Relative {

    private Long id;
    private String relationshipType;
    private String smokingStatus;
    private EpidemiologicalFinding epidemiologicalFinding;
    
    public EpidemiologicalFinding getEpidemiologicalFinding() {
        return epidemiologicalFinding;
    }
    public void setEpidemiologicalFinding(
            EpidemiologicalFinding epidemiologicalFinding) {
        this.epidemiologicalFinding = epidemiologicalFinding;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getSmokingStatus() {
        return smokingStatus;
    }
    public void setSmokingStatus(String smokingStatus) {
        this.smokingStatus = smokingStatus;
    }
    public String getRelationshipType() {
        return relationshipType;
    }
    public void setRelationshipType(String relationshipType) {
        this.relationshipType = relationshipType;
    }
}
