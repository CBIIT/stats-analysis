

package gov.nih.nci.caintegrator.domain.finding.variation.germline;

import gov.nih.nci.caintegrator.domain.annotation.snp.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.SNPAssay;
import gov.nih.nci.caintegrator.domain.finding.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.VariationFinding;
import gov.nih.nci.caintegrator.domain.study.Study;


/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */

public  class GenotypeFinding extends VariationFinding implements java.io.Serializable, Finding {
    public final static String STATUS = "status";
    public final static String QUALITY_SCORE = "qualityScore";
    public final static String SPECIMEN_ID = "GenotypeFinding.specimen.id";


    private static final long serialVersionUID = 1234567890L;

    private java.lang.Integer id;
	public  java.lang.Integer getId(){
        return id;
    }
    public void setId( java.lang.Integer id){
        this.id = id;
    }
    /**
   * one of the nucleotide bases detected by the assay
   */
    private String allele1;
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
	public String getStatus(){
        return status;
    }
    public void setStatus(String status){
        this.status = status;
    }

   /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */
    private SNPAssay snpAssay;
    public SNPAssay getSnpAssay(){
        return snpAssay;			
    }
    public void setSnpAssay(SNPAssay snpAssay){
        this.snpAssay = snpAssay;
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
	   
   /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */
    private Study study;
    public Study getStudy(){
        return study;			
    }
    public void setStudy(Study study){
        this.study = study;
    }	
	   
    public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GenotypeFinding) {
				GenotypeFinding c =(GenotypeFinding)obj; 			 
				Integer thisId = getId();
				
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