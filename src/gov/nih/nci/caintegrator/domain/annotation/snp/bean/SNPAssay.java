

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

public  class SNPAssay 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * SNP alleles specified in the nucleotide sequence used to design the assay
   */

    private String designAlleles;
    /**
   * SNP alleles specified in the nucleotide sequence used to design the assay
   */

	public String getDesignAlleles(){
        return designAlleles;
    }
    public void setDesignAlleles(String designAlleles){
        this.designAlleles = designAlleles;
    }
	
	   
    /**
   * design score assigned by the vendor to indicate the probability of converting the design into a valid 
   * assay 
   * 
   */

    private Float designScore;
    /**
   * design score assigned by the vendor to indicate the probability of converting the design into a valid 
   * assay 
   * 
   */

	public Float getDesignScore(){
        return designScore;
    }
    public void setDesignScore(Float designScore){
        this.designScore = designScore;
    }
	
	   
    /**
   * nucleotide sequence used to design the assay
   */

    private String designSequence;
    /**
   * nucleotide sequence used to design the assay
   */

	public String getDesignSequence(){
        return designSequence;
    }
    public void setDesignSequence(String designSequence){
        this.designSequence = designSequence;
    }
	
	   
    /**
   * the orientation of the SNP design sequence to the NCBI reference sequence
   */

    private String designStrand;
    /**
   * the orientation of the SNP design sequence to the NCBI reference sequence
   */

	public String getDesignStrand(){
        return designStrand;
    }
    public void setDesignStrand(String designStrand){
        this.designStrand = designStrand;
    }
	
	   
    /**
   * Unique identifier  for the instance of SNPAssay.
   */

    private java.lang.Long id;
    /**
   * Unique identifier  for the instance of SNPAssay.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * a global quality flag for that assay that indicates the reliability and validity of genotypes derived 
   * from the assay 
   * 
   */

    private String status;
    /**
   * a global quality flag for that assay that indicates the reliability and validity of genotypes derived 
   * from the assay 
   * 
   */

	public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
	
	   
    /**
   * vendor specified idenfifier for the assay
   */

    private String vendorAssayId;
    /**
   * vendor specified idenfifier for the assay
   */

	public String getVendorAssayId(){
        return vendorAssayId;
    }
    public void setVendorAssayId(String vendorAssayId){
        this.vendorAssayId = vendorAssayId;
    }
	
	   
    /**
   * vendor assigned version identifier for the assay
   */

    private String version;
    /**
   * vendor assigned version identifier for the assay
   */

	public String getVersion(){
        return version;
    }
    public void setVersion(String version){
        this.version = version;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPAssay) {
				SNPAssay c =(SNPAssay)obj; 			 
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
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel snpPanel;
      /**
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel getSnpPanel(){
        return snpPanel;			
    }

	      
	               
	   

    public void setSnpPanel(gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel snpPanel){
        this.snpPanel = snpPanel;
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
	   
	   
	
	   
	   
	   
	      
      /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding> genotypeFindingCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding>();
      /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding> getGenotypeFindingCollection(){
        return genotypeFindingCollection;
    }

	      
	               
	   
    public void setGenotypeFindingCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding> genotypeFindingCollection){
        this.genotypeFindingCollection = genotypeFindingCollection;
    }
	   
	   
	

			
}