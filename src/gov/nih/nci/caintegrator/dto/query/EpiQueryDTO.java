package gov.nih.nci.caintegrator.dto.query;

public class EpiQueryDTO implements QueryDTO {

    private String queryName;
    
    public String getQueryName() {
        
        return queryName;
    }

    public void setQueryName(String name) {
        this.queryName = name;
        
    }

}
