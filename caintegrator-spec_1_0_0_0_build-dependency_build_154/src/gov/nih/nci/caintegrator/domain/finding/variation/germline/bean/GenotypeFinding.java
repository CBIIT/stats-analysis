

package gov.nih.nci.caintegrator.domain.finding.variation.germline.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */

public  class GenotypeFinding 
    extends gov.nih.nci.caintegrator.domain.finding.variation.bean.VariationFinding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * one of the nucleotide bases detected by the assay
   */

    private String allele1;
    /**
   * one of the nucleotide bases detected by the assay
   */

	public String getAllele1(){
        return allele1;
    }
    public void setAllele1(String allele1){
        this.allele1 = allele1;
    }
	
	   
    /**
   * one of the nucleotide bases detected by the assay
   */

    private String allele2;
    /**
   * one of the nucleotide bases detected by the assay
   */

	public String getAllele2(){
        return allele2;
    }
    public void setAllele2(String allele2){
        this.allele2 = allele2;
    }
	
	   
    /**
   * Intensity of one of the allele states that result from the genotyping assay after the raw intensity 
   * has been normalized by a six degree of freedom affine transformation 
   * 
   */

    private Float normalizedXIntensity;
    /**
   * Intensity of one of the allele states that result from the genotyping assay after the raw intensity 
   * has been normalized by a six degree of freedom affine transformation 
   * 
   */

	public Float getNormalizedXIntensity(){
        return normalizedXIntensity;
    }
    public void setNormalizedXIntensity(Float normalizedXIntensity){
        this.normalizedXIntensity = normalizedXIntensity;
    }
	
	   
    /**
   * Intensity of one of the allele states that result from the genotyping assay after the raw intensity 
   * has been normalized by a six degree of freedom affine transformation 
   * 
   */

    private Float normalizedYIntensity;
    /**
   * Intensity of one of the allele states that result from the genotyping assay after the raw intensity 
   * has been normalized by a six degree of freedom affine transformation 
   * 
   */

	public Float getNormalizedYIntensity(){
        return normalizedYIntensity;
    }
    public void setNormalizedYIntensity(Float normalizedYIntensity){
        this.normalizedYIntensity = normalizedYIntensity;
    }
	
	   
    /**
   * quality score computed by the genotype calling algorithm based on a function of the overall genotyping 
   * precision at the locus and of the specific performance of the sample 
   * 
   */

    private Float qualityScore;
    /**
   * quality score computed by the genotype calling algorithm based on a function of the overall genotyping 
   * precision at the locus and of the specific performance of the sample 
   * 
   */

	public Float getQualityScore(){
        return qualityScore;
    }
    public void setQualityScore(Float qualityScore){
        this.qualityScore = qualityScore;
    }
	
	   
    /**
   * Intensity of one of the allele states as detected by the genotyping assay
   */

    private Float rawXIntensity;
    /**
   * Intensity of one of the allele states as detected by the genotyping assay
   */

	public Float getRawXIntensity(){
        return rawXIntensity;
    }
    public void setRawXIntensity(Float rawXIntensity){
        this.rawXIntensity = rawXIntensity;
    }
	
	   
    /**
   * Intensity of one of the allele states as detected by the genotyping assay
   */

    private Float rawYIntensity;
    /**
   * Intensity of one of the allele states as detected by the genotyping assay
   */

	public Float getRawYIntensity(){
        return rawYIntensity;
    }
    public void setRawYIntensity(Float rawYIntensity){
        this.rawYIntensity = rawYIntensity;
    }
	
	   
    /**
   * a quality flag for the genotype from a particular assay
   */

    private String status;
    /**
   * a quality flag for the genotype from a particular assay
   */

	public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GenotypeFinding) {
				GenotypeFinding c =(GenotypeFinding)obj; 			 
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
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

  /*  private gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay snpAssay; */
  /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

/*
    public gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay getSnpAssay(){
        return snpAssay;			
    }


    public void setSnpAssay(gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay snpAssay){
        this.snpAssay = snpAssay;
    }
*/

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
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

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
	   
	   
	

			
}