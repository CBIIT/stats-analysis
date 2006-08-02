

package gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency;

import gov.nih.nci.caintegrator.domain.annotation.snp.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.finding.Finding;
import gov.nih.nci.caintegrator.domain.study.Population;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */
public  class SNPFrequencyFinding implements java.io.Serializable, Finding {

	private static final long serialVersionUID = 1234567890L;

    /**
   * statistical measure of probability of the observed genotype frequencies deviate from Hard-Wienberg 
   * proportions 
   * 
   */
    private Float hardyWeinbergPValue;
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
	public Integer getHeterozygoteCount(){
        return heterozygoteCount;
    }
    public void setHeterozygoteCount(Integer heterozygoteCount){
        this.heterozygoteCount = heterozygoteCount;
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
   * Minor allele frequency or the frequency of the least frequent allele at a given SNP locus and population 
   * 
   */
   //  TODO RAM:  private Float minorAlleleFrequency;
    /**
   * Minor allele frequency or the frequency of the least frequent allele at a given SNP locus and population 
   * 
   */
	/*public Float getMinorAlleleFrequency(){
        return minorAlleleFrequency;
    }
    public void setMinorAlleleFrequency(Float minorAlleleFrequency){
        this.minorAlleleFrequency = minorAlleleFrequency;
    }*/

    /**
   * Count of alleles that could not be determined for  a given locus and population
   */
    private Integer missingAlleleCount;

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
    private Integer otherHomogygoteCount;
	public Integer getOtherHomogygoteCount(){
        return otherHomogygoteCount;
    }
    public void setOtherHomogygoteCount(Integer otherHomogygoteCount){
        this.otherHomogygoteCount = otherHomogygoteCount;
    }

    /**
   * An arbitrary allele at the given locus that is considered the reference allele
   */
    private String referenceAllele;
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
	public Integer getReferenceAlleleCount(){
        return referenceAlleleCount;
    }
    public void setReferenceAlleleCount(Integer referenceAlleleCount){
        this.referenceAlleleCount = referenceAlleleCount;
    }

    /**
   * Count of the genotypes homogygous for the reference allele at a given locus and population 
   * 
   */
    private Integer referenceHomogyzoteCount;
	public Integer getReferenceHomogyzoteCount(){
        return referenceHomogyzoteCount;
    }
    public void setReferenceHomogyzoteCount(Integer referenceHomogyzoteCount){
        this.referenceHomogyzoteCount = referenceHomogyzoteCount;
    }

   /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */
    private Population population;
    public Population getPopulation(){
        return population;			
    }
    public void setPopulation(Population population){
        this.population = population;
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


      public String toString() {
          return "SNPFrequencyFinding{" +
                  "hardyWeinbergPValue=" + hardyWeinbergPValue +
                  ", heterozygoteCount=" + heterozygoteCount +
                  ", id=" + id +
                  ", missingAlleleCount=" + missingAlleleCount +
                  ", missingGenotypeCount=" + missingGenotypeCount +
                  ", otherAllele='" + otherAllele + '\'' +
                  ", otherAlleleCount=" + otherAlleleCount +
                  ", otherHomogygoteCount=" + otherHomogygoteCount +
                  ", referenceAllele='" + referenceAllele + '\'' +
                  ", referenceAlleleCount=" + referenceAlleleCount +
                  ", referenceHomogyzoteCount=" + referenceHomogyzoteCount +
                  "}";
      }
  }