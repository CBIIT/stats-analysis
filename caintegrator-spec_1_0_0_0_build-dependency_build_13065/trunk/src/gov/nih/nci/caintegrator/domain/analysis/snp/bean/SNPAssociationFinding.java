

package gov.nih.nci.caintegrator.domain.analysis.snp.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Statistical results of evidence for or against genetic association between the phenotypes analyzed 
   * at a particular SNP. 
   * 
   */

public  class SNPAssociationFinding 
    extends gov.nih.nci.caintegrator.domain.finding.bean.Finding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier  for the instance of SNPAssociationFinding.
   */

    private java.lang.Long id;
    /**
   * Unique identifier  for the instance of SNPAssociationFinding.
   */

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
    /**
   * statistical significance of the SNP association finding
   */

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
    /**
   * rank of the statistical significance of the SNP association finding relative to the other findings, 
   * order by most to least significant 
   * 
   */

	public Integer getRank(){
        return rank;
    }
    public void setRank(Integer rank){
        this.rank = rank;
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

	
	   
	   
	   
	      
			
			
			
			
      /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis snpAssociationAnalysis;
      /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis getSnpAssociationAnalysis(){
        return snpAssociationAnalysis;			
    }

	      
	               
	   

    public void setSnpAssociationAnalysis(gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis snpAssociationAnalysis){
        this.snpAssociationAnalysis = snpAssociationAnalysis;
    }	
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * Places in the genomic sequence where one fraction of the human population has one nucleotide or allele, 
   * while another fraction has another. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation snpAnnotation;
      /**
   * Places in the genomic sequence where one fraction of the human population has one nucleotide or allele, 
   * while another fraction has another. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation getSnpAnnotation(){
        return snpAnnotation;			
    }

    public void setSnpAnnotation(gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation snpAnnotation){
        this.snpAnnotation = snpAnnotation;
    }	
	   
    private gov.nih.nci.caintegrator.domain.study.bean.Study study;
   /**
   * A type of research activity that tests how well new medical treatments or other interventions work
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease.
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical
   * facility.
   *
   */
    public gov.nih.nci.caintegrator.domain.study.bean.Study getStudy(){
        return study;
    }

    public void setStudy(gov.nih.nci.caintegrator.domain.study.bean.Study study){
        this.study = study;
    }

	   private Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.OddsRatio> oddsRatioCollection = new HashSet<gov.nih.nci.caintegrator.domain.analysis.snp.bean.OddsRatio>();
	/**
	 * @return Returns the oddsRatioCollection.
	 */
	public Set<gov.nih.nci.caintegrator.domain.analysis.snp.bean.OddsRatio> getOddsRatioCollection() {
		return oddsRatioCollection;
	}
	/**
	 * @param oddsRatioCollection The oddsRatioCollection to set.
	 */
	public void setOddsRatioCollection(
			Set<gov.nih.nci.caintegrator.domain.analysis.snp.bean.OddsRatio> oddsRatioCollection) {
		this.oddsRatioCollection = oddsRatioCollection;
	}

}