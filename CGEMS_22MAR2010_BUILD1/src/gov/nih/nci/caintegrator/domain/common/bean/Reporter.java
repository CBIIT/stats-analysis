package gov.nih.nci.caintegrator.domain.common.bean;

import java.io.Serializable;

public abstract class Reporter implements Serializable {

    private Long id;
    private String name;
    private String type;
    private String platform;
    
    
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
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public boolean equals(Object obj){
        boolean eq = false;
        if(obj instanceof Reporter) {
            Reporter c =(Reporter)obj;             
            Long thisId = getId();        
            
                if(thisId != null && thisId.equals(c.getId())) {
                   eq = true;
                }       
            
        }
        return eq;
    }
    
    public int hashCode(){
        int h = 0;
        
        if(getId() != null) {
            h += getId().hashCode();
        }
        
        return h;
}
}
