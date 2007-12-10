package gov.nih.nci.caintegrator.domain.epidemiology.bean;

public class Lifestyle {

    private Long id;
    private String educationLevel;
    private String socioEconomicStatus;
    private String residentialArea;
    private String maritalStatus;
    private String religion;
    private EpidemiologicalFinding epidemiologicalFinding;
    
    public EpidemiologicalFinding getEpidemiologicalFinding() {
        return epidemiologicalFinding;
    }
    public void setEpidemiologicalFinding(
            EpidemiologicalFinding epidemiologicalFinding) {
        this.epidemiologicalFinding = epidemiologicalFinding;
    }
    public String getEducationLevel() {
        return educationLevel;
    }
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getMaritalStatus() {
        return maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public String getReligion() {
        return religion;
    }
    public void setReligion(String religion) {
        this.religion = religion;
    }
    public String getResidentialArea() {
        return residentialArea;
    }
    public void setResidentialArea(String residentialArea) {
        this.residentialArea = residentialArea;
    }
    public String getSocioEconomicStatus() {
        return socioEconomicStatus;
    }
    public void setSocioEconomicStatus(String socioEconomicStatus) {
        this.socioEconomicStatus = socioEconomicStatus;
    }
}
