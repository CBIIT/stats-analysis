

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */

public  class SNPPanel 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Count of SNPAssay objects that are present on this assay 
   */

    private java.lang.Integer assayCount;
    /**
   * Count of SNPAssay objects that are present on this assay 
   */

	public  java.lang.Integer getAssayCount(){
        return assayCount;
    }
    public void setAssayCount( java.lang.Integer assayCount){
        this.assayCount = assayCount;
    }
	
	   
    /**
   * desciption of the genotyping panel
   */

    private String description;
    /**
   * desciption of the genotyping panel
   */

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
	   
    /**
   * Unique identifier  for the instance of SNPPanel.
   */

    private java.lang.Long id;
    /**
   * Unique identifier  for the instance of SNPPanel.
   */

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
    /**
   * textual identifier for the panel
   */

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
    /**
   * technology platform that the assays on the panel are based upon. Values such as Infinium, GoldenGate, 
   * SNPlex, TaqMan, etc 
   * 
   */

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
    /**
   * Vendor that manufactured the panel
   */

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
    /**
   * vendor specified idenfifier for the panel
   */

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
    /**
   * vendor assigned version identifier for the panel
   */

	public String getVersion(){
        return version;
    }
    public void setVersion(String version){
        this.version = version;
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

	
	   
	   
	   
	      
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Study> studyCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Study>();
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Study> getStudyCollection(){
        return studyCollection;
    }

	      
	               
	   
    public void setStudyCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Study> studyCollection){
        this.studyCollection = studyCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay> snpAssayCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay>();
      /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay> getSnpAssayCollection(){
        return snpAssayCollection;
    }

	      
	               
	   
    public void setSnpAssayCollection(Set<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay> snpAssayCollection){
        this.snpAssayCollection = snpAssayCollection;
    }
	   
	   
	

			
}