package gov.nih.nci.caintegrator.domain.epidemiology.bean;

public class DietaryConsumption {

    private Long id;
    private String frequency;
    private String name;
    
    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
    
}
