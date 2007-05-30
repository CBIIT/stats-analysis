package gov.nih.nci.caintegrator.domain.epidemiology.bean;

public class BehavioralAssessment {

    private Long id;
    private Integer depressionScore;
    private Integer anxietyScore;
    private Integer fagerstromScore;
    private EpidemiologicalFinding epidemiologicalFinding;
    
    public EpidemiologicalFinding getEpidemiologicalFinding() {
        return epidemiologicalFinding;
    }
    public void setEpidemiologicalFinding(
            EpidemiologicalFinding epidemiologicalFinding) {
        this.epidemiologicalFinding = epidemiologicalFinding;
    }
    public Integer getAnxietyScore() {
        return anxietyScore;
    }
    public void setAnxietyScore(Integer anxietyScore) {
        this.anxietyScore = anxietyScore;
    }
    public Integer getDepressionScore() {
        return depressionScore;
    }
    public void setDepressionScore(Integer depressionScore) {
        this.depressionScore = depressionScore;
    }
    public Integer getFagerstromScore() {
        return fagerstromScore;
    }
    public void setFagerstromScore(Integer fagerstromScore) {
        this.fagerstromScore = fagerstromScore;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
