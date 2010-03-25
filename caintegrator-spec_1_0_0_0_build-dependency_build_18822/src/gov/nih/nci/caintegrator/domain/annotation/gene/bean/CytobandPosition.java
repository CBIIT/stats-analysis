package gov.nih.nci.caintegrator.domain.annotation.gene.bean;

public class CytobandPosition {

    private Long id;
    private String chromosomeName;
    private String cytoband;
    private Long cytobandStartPosition;
    private Long cytobandEndPosition;
    private String organism;
    
    public String getChromosomeName() {
        return chromosomeName;
    }
    public void setChromosomeName(String chromosomeName) {
        this.chromosomeName = chromosomeName;
    }
    public String getCytoband() {
        return cytoband;
    }
    public void setCytoband(String cytoband) {
        this.cytoband = cytoband;
    }
    public Long getCytobandEndPosition() {
        return cytobandEndPosition;
    }
    public void setCytobandEndPosition(Long cytobandEndPosition) {
        this.cytobandEndPosition = cytobandEndPosition;
    }
    public Long getCytobandStartPosition() {
        return cytobandStartPosition;
    }
    public void setCytobandStartPosition(Long cytobandStartPosition) {
        this.cytobandStartPosition = cytobandStartPosition;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrganism() {
        return organism;
    }
    public void setOrganism(String organism) {
        this.organism = organism;
    }
    
}
