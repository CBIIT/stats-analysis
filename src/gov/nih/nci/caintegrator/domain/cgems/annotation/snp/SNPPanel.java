package gov.nih.nci.caintegrator.domain.cgems.annotation.snp;

import gov.nih.nci.caintegrator.domain.cgems.study.Study;

import java.util.HashSet;
import java.util.Set;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */
public  class SNPPanel implements java.io.Serializable {
      // Define Queriable Fields as constants
      public final static String NAME = "name";
      public final static String VERSION = "version";
	

      private static final long serialVersionUID = 1234567890L;

      private Integer assayCount;
      public Integer getAssayCount() {
          return assayCount;
      }
      public void setAssayCount(Integer assayCount) {
          this.assayCount = assayCount;
      }

      /**
   * desciption of the genotyping panel
   */
    private String description;
	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
    /**
   * Unique identifier
   */
    private java.lang.Long id;
	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }

    /**
   * textual identifier for the panel
   */
    private String name;
	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    /**
   * technology platform that the assays on the panel are based upon. Values such as Infinium, GoldenGate, 
   * SNPlex, TaqMan, etc 
   * 
   */
    private String technology;
	public String getTechnology(){
        return technology;
    }
    public void setTechnology(String technology){
        this.technology = technology;
    }

    /**
   * Vendor that manufactured the panel
   */
    private String vendor;
	public String getVendor(){
        return vendor;
    }
    public void setVendor(String vendor){
        this.vendor = vendor;
    }

    /**
   * vendor specified idenfifier for the panel
   */
    private String vendorPanelId;
	public String getVendorPanelId(){
        return vendorPanelId;
    }
    public void setVendorPanelId(String vendorPanelId){
        this.vendorPanelId = vendorPanelId;
    }
	
    /**
   * vendor assigned version identifier for the panel
   */
    private String version;
	public String getVersion(){
        return version;
    }
    public void setVersion(String version){
        this.version = version;
    }
	
   /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */
    private Set<Study> studyCollection = new HashSet<Study>();
    public Set <Study> getStudyCollection(){
        return studyCollection;
    }
    public void setStudyCollection(Set<Study> studyCollection){
        this.studyCollection = studyCollection;
    }
	   
    /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */
    private Set <SNPAssay> snpAssayCollection = new HashSet<SNPAssay>();
    public Set <SNPAssay> getSnpAssayCollection(){
        return snpAssayCollection;
    }
    public void setSnpAssayCollection(Set<SNPAssay> snpAssayCollection){
        this.snpAssayCollection = snpAssayCollection;
    }
	   
	public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPPanel) {
				SNPPanel c =(SNPPanel)obj; 			 
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