

package gov.nih.nci.caintegrator.domain.analysis.snp;

import gov.nih.nci.caintegrator.domain.analysis.snp.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.annotation.snp.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.finding.Finding;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Statistical results of evidence for or against genetic association between the phenotypes analyzed 
   * at a particular SNP. 
   * 
   */

public  class SNPAssociationFinding implements java.io.Serializable, Finding {

	private static final long serialVersionUID = 1234567890L;
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
   * statistical significance of the SNP association finding
   */
    private Float pvalue;
	public Float getPvalue(){
        return pvalue;
    }
    public void setPvalue(Float pvalue){
        this.pvalue = pvalue;
    }

    /**
   * rank of the statistical significance of the SNP association finding relative to the other findings, 
   * order by most to least significant 
   * 
   */
    private Integer rank;
	public Integer getRank(){
        return rank;
    }
    public void setRank(Integer rank){
        this.rank = rank;
    }
	
   /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */
    private SNPAssociationAnalysis snpAssociationAnalysis;
    public SNPAssociationAnalysis getSnpAssociationAnalysis(){
        return snpAssociationAnalysis;			
    }
    public void setSnpAssociationAnalysis(SNPAssociationAnalysis snpAssociationAnalysis){
        this.snpAssociationAnalysis = snpAssociationAnalysis;
    }	
	   
    /**
   * Places in the genomic sequence where one fraction of the human population has one nucleotide or allele, 
   * while another fraction has another. 
   * 
   */
    private SNPAnnotation snpAnnotation;
    public SNPAnnotation getSnpAnnotation(){
        return snpAnnotation;			
    }
    public void setSnpAnnotation(SNPAnnotation snpAnnotation){
        this.snpAnnotation = snpAnnotation;
    }	
	   
	public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPAssociationFinding) {
				SNPAssociationFinding c =(SNPAssociationFinding)obj; 			 
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
          return "SNPAssociationFinding{" +
                  "id=" + id + "\n" +
                  ", pvalue=" + pvalue + "\n" +
                  ", rank=" + rank + "\n" +
                  '}';
      }
  }