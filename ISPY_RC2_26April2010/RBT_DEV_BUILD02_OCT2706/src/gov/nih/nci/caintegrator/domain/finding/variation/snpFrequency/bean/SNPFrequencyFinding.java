

package gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */

public  class SNPFrequencyFinding 
    extends gov.nih.nci.caintegrator.domain.finding.bean.Finding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * statistical measure of probability of the observed genotype frequencies deviate from Hard-Wienberg 
   * proportions 
   * 
   */

    private Float hardyWeinbergPValue;
    /**
   * statistical measure of probability of the observed genotype frequencies deviate from Hard-Wienberg 
   * proportions 
   * 
   */

	public Float getHardyWeinbergPValue(){
        return hardyWeinbergPValue;
    }
    public void setHardyWeinbergPValue(Float hardyWeinbergPValue){
        this.hardyWeinbergPValue = hardyWeinbergPValue;
    }
	
	   
    /**
   * Count of the observed heterogyzote genotypes at a given locus and population
   */

    private Integer heterozygoteCount;
    /**
   * Count of the observed heterogyzote genotypes at a given locus and population
   */

	public Integer getHeterozygoteCount(){
        return heterozygoteCount;
    }
    public void setHeterozygoteCount(Integer heterozygoteCount){
        this.heterozygoteCount = heterozygoteCount;
    }
	
	   
    /**
   * Unique identifier  for the instance of SNPFrequencyFinding.
   */

    private java.lang.Long id;
    /**
   * Unique identifier  for the instance of SNPFrequencyFinding.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * Minor allele frequency or the frequency of the least frequent allele at a given SNP locus and population 
   * 
   */

    private Float minorAlleleFrequency;
    /**
   * Minor allele frequency or the frequency of the least frequent allele at a given SNP locus and population 
   * 
   */

	public Float getMinorAlleleFrequency(){
        return minorAlleleFrequency;
    }
    public void setMinorAlleleFrequency(Float minorAlleleFrequency){
        this.minorAlleleFrequency = minorAlleleFrequency;
    }
	
	   
    /**
   * Count of alleles that could not be determined for  a given locus and population
   */

    private Integer missingAlleleCount;
    /**
   * Count of alleles that could not be determined for  a given locus and population
   */

	public Integer getMissingAlleleCount(){
        return missingAlleleCount;
    }
    public void setMissingAlleleCount(Integer missingAlleleCount){
        this.missingAlleleCount = missingAlleleCount;
    }
	
	   
    /**
   * Count of genotypes that could not be determined for a given locus and population 
   * 
   */

    private Integer missingGenotypeCount;
    /**
   * Count of genotypes that could not be determined for a given locus and population 
   * 
   */

	public Integer getMissingGenotypeCount(){
        return missingGenotypeCount;
    }
    public void setMissingGenotypeCount(Integer missingGenotypeCount){
        this.missingGenotypeCount = missingGenotypeCount;
    }
	
	   
    /**
   * An arbitrary allele at the given locus that is considered the non-reference allele. 
   * 
   */

    private String otherAllele;
    /**
   * An arbitrary allele at the given locus that is considered the non-reference allele. 
   * 
   */

	public String getOtherAllele(){
        return otherAllele;
    }
    public void setOtherAllele(String otherAllele){
        this.otherAllele = otherAllele;
    }
	
	   
    /**
   * Count of the non-reference alleles observed at a given locus and population
   */

    private Integer otherAlleleCount;
    /**
   * Count of the non-reference alleles observed at a given locus and population
   */

	public Integer getOtherAlleleCount(){
        return otherAlleleCount;
    }
    public void setOtherAlleleCount(Integer otherAlleleCount){
        this.otherAlleleCount = otherAlleleCount;
    }
	
	   
    /**
   * Count of the genotypes homogygous for the non-reference allele at a given locus and population 
   * 
   */

    private java.lang.Integer otherHomozygoteCount;
    /**
   * Count of the genotypes homogygous for the non-reference allele at a given locus and population 
   * 
   */

	public  java.lang.Integer getOtherHomozygoteCount(){
        return otherHomozygoteCount;
    }
    public void setOtherHomozygoteCount( java.lang.Integer otherHomozygoteCount){
        this.otherHomozygoteCount = otherHomozygoteCount;
    }
	
	   
    /**
   * An arbitrary allele at the given locus that is considered the reference allele
   */

    private String referenceAllele;
    /**
   * An arbitrary allele at the given locus that is considered the reference allele
   */

	public String getReferenceAllele(){
        return referenceAllele;
    }
    public void setReferenceAllele(String referenceAllele){
        this.referenceAllele = referenceAllele;
    }
	
	   
    /**
   * Count of the reference alleles observed at a given locus and population
   */

    private Integer referenceAlleleCount;
    /**
   * Count of the reference alleles observed at a given locus and population
   */

	public Integer getReferenceAlleleCount(){
        return referenceAlleleCount;
    }
    public void setReferenceAlleleCount(Integer referenceAlleleCount){
        this.referenceAlleleCount = referenceAlleleCount;
    }

    public Double completionRate;

    public Double getCompletionRate() {
        return completionRate;
    }

    public void setCompletionRate(Double completionRate) {
        this.completionRate = completionRate;
    }

    /**
   * Count of the genotypes homogygous for the reference allele at a given locus and population 
   * 
   */

    private java.lang.Integer referenceHomozygoteCount;
    /**
   * Count of the genotypes homogygous for the reference allele at a given locus and population 
   * 
   */

	public  java.lang.Integer getReferenceHomozygoteCount(){
        return referenceHomozygoteCount;
    }
    public void setReferenceHomozygoteCount( java.lang.Integer referenceHomozygoteCount){
        this.referenceHomozygoteCount = referenceHomozygoteCount;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPFrequencyFinding) {
				SNPFrequencyFinding c =(SNPFrequencyFinding)obj; 			 
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
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Population population;
      /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Population getPopulation(){
        return population;			
    }

	      
	               
	   

    public void setPopulation(gov.nih.nci.caintegrator.domain.study.bean.Population population){
        this.population = population;
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
			
}