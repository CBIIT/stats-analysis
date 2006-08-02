

package gov.nih.nci.caintegrator.domain.analysis.snp;

import gov.nih.nci.caintegrator.domain.analysis.snp.SNPAnalysisGroup;

import java.util.Set;
import java.util.HashSet;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */

public  class SNPAssociationAnalysis implements java.io.Serializable {

	private static final long serialVersionUID = 1234567890L;

    /**
   * Description of the SNP association analysis
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
   * Overview of the methods used to perform the SNP association analysis
   */
    private String methods;
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
	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	
   /**
   * Statistical results of evidence for or against genetic association between the phenotypes analyzed 
   * at a particular SNP. 
   * 
   */
    private Set<SNPAssociationFinding> snpAssociationFindingCollection = new HashSet<SNPAssociationFinding>();
    public Set <SNPAssociationFinding> getSnpAssociationFindingCollection(){
        return snpAssociationFindingCollection;
    }
    public void setSnpAssociationFindingCollection(Set<SNPAssociationFinding> snpAssociationFindingCollection){
        this.snpAssociationFindingCollection = snpAssociationFindingCollection;
    }

    private Set <SNPAnalysisGroup> analysisGroupCollection = new HashSet<SNPAnalysisGroup>();
    public Set <SNPAnalysisGroup> getAnalysisGroupCollection(){
        return analysisGroupCollection;
    }
    public void setAnalysisGroupCollection(Set<SNPAnalysisGroup> analysisGroupCollection){
        this.analysisGroupCollection = analysisGroupCollection;
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


      public String toString() {
          return "SNPAssociationAnalysis: \n" +
                  "name='" + name + "\n" +
                  ", description='" + description + "\n" +
                  ", id=" + id + "\n" +
                  ", methods='" + methods + "\n" +
                  "}";
      }
  }