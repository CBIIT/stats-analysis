package gov.nih.nci.caintegrator.domain.epidemiology.bean;

public class EnvironmentalFactor {

    private Long id;
    private String exposureType;
    private String exposureLevel;
    private String exposureArea;
    private String exposureAgeGroup;
    
    public String getExposureAgeGroup() {
        return exposureAgeGroup;
    }
    public void setExposureAgeGroup(String exposureAgeGroup) {
        this.exposureAgeGroup = exposureAgeGroup;
    }
    public String getExposureArea() {
        return exposureArea;
    }
    public void setExposureArea(String exposureArea) {
        this.exposureArea = exposureArea;
    }
    public String getExposureLevel() {
        return exposureLevel;
    }
    public void setExposureLevel(String exposureLevel) {
        this.exposureLevel = exposureLevel;
    }
    public String getExposureType() {
        return exposureType;
    }
    public void setExposureType(String exposureType) {
        this.exposureType = exposureType;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
