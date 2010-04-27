

package gov.nih.nci.caintegrator.domain.analysis.snp.bean;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */

public  class SNPAssociationAnalysis 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Description of the SNP association analysis
   */

    private String description;
    /**
   * Description of the SNP association analysis
   */

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
	   
    /**
   * Unique identifier  for the instance of SNPAssociationAnalysis.
   */

    private java.lang.Long id;
    /**
   * Unique identifier  for the instance of SNPAssociationAnalysis.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * Overview of the methods used to perform the SNP association analysis
   */

    private String methods;
    /**
   * Overview of the methods used to perform the SNP association analysis
   */

	public String getMethods(){
        return methods;
    }
    public void setMethods(String methods){
        this.methods = methods;
    }
	
	   
    /**
   * A textual identifier for the SNP association analysis
   */

    private String name;
    /**
   * A textual identifier for the SNP association analysis
   */

	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPAssociationAnalysis) {
				SNPAssociationAnalysis c =(SNPAssociationAnalysis)obj; 			 
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
   * Statistical results of evidence for or against genetic association between the phenotypes analyzed 
   * at a particular SNP. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding> snpAssociationFindingCollection = new HashSet<gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding>();
      /**
   * Statistical results of evidence for or against genetic association between the phenotypes analyzed 
   * at a particular SNP. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding> getSnpAssociationFindingCollection(){
        return snpAssociationFindingCollection;
    }

	      
	               
	   
    public void setSnpAssociationFindingCollection(Set<gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding> snpAssociationFindingCollection){
        this.snpAssociationFindingCollection = snpAssociationFindingCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * Representation of the analysis groups such as "CEPH Population" or "Non-Tumor Samples" 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup> analysisGroupCollection = new HashSet<gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup>();
      /**
   * Representation of the analysis groups such as "CEPH Population" or "Non-Tumor Samples" 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup> getAnalysisGroupCollection(){
        return analysisGroupCollection;
    }

	      
	               
	   
    public void setAnalysisGroupCollection(Set<gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup> analysisGroupCollection){
        this.analysisGroupCollection = analysisGroupCollection;
    }
	   
	   
	

			
}