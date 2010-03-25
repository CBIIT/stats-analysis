
package gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * SomaticMutationFinding deals with  mutations occurring in  somatic cells.
   */

public  class SomaticMutationFinding 
    extends gov.nih.nci.caintegrator.domain.finding.variation.bean.VariationFinding
	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;
	   
    /**
   * Base Number(s) affected by Mutation
   */

    private Integer baseNumber;
    /**
   * Base Number(s) affected by Mutation
   */

	public Integer getBaseNumber(){
        return baseNumber;
    }
    public void setBaseNumber(Integer baseNumber){
        this.baseNumber = baseNumber;
    }
	
	   
    /**
   * Functional change in Protein: Misssense, NoneSense, Frameset, InFrame, Splicing, Silent, Complex 
   * 
   */

    private java.lang.String functionalChange;
    /**
   * Functional change in Protein: Misssense, NoneSense, Frameset, InFrame, Splicing, Silent, Complex 
   * 
   */

	public  java.lang.String getFunctionalChange(){
        return functionalChange;
    }
    public void setFunctionalChange( java.lang.String functionalChange){
        this.functionalChange = functionalChange;
    }
	
	   
    /**
   * Location Of Mutation By codon
   */

    private java.lang.Integer locationByCodon;
    /**
   * Location Of Mutation By codon
   */

	public  java.lang.Integer getLocationByCodon(){
        return locationByCodon;
    }
    public void setLocationByCodon( java.lang.Integer locationByCodon){
        this.locationByCodon = locationByCodon;
    }
	
	   
    /**
   * Location Of Mutation By Exon (Exons 2 - 11)
   */

    private Integer locationByExon;
    /**
   * Location Of Mutation By Exon (Exons 2 - 11)
   */

	public Integer getLocationByExon(){
        return locationByExon;
    }
    public void setLocationByExon(Integer locationByExon){
        this.locationByExon = locationByExon;
    }
	
	   
    /**
   * Location Of Mutation By Intron (Introns 1 - 10)
   */

    private Integer locationByIntron;
    /**
   * Location Of Mutation By Intron (Introns 1 - 10)
   */

	public Integer getLocationByIntron(){
        return locationByIntron;
    }
    public void setLocationByIntron(Integer locationByIntron){
        this.locationByIntron = locationByIntron;
    }
	
	   
    /**
   * mutant Amino Acid
   */

    private java.lang.String mutantAminoAcid;
    /**
   * mutant Amino Acid
   */

	public  java.lang.String getMutantAminoAcid(){
        return mutantAminoAcid;
    }
    public void setMutantAminoAcid( java.lang.String mutantAminoAcid){
        this.mutantAminoAcid = mutantAminoAcid;
    }
	
	   
    /**
   * mutant Codon
   */

    private java.lang.String mutantCodon;
    /**
   * mutant Codon
   */

	public  java.lang.String getMutantCodon(){
        return mutantCodon;
    }
    public void setMutantCodon( java.lang.String mutantCodon){
        this.mutantCodon = mutantCodon;
    }
	
	   
    /**
   * Indication of mutation status such as WILDTYPE, MUTATION
   */

    private java.lang.String mutationStatus;
    /**
   * Indication of mutation status such as WILDTYPE, MUTATION
   */

	public  java.lang.String getMutationStatus(){
        return mutationStatus;
    }
    public void setMutationStatus( java.lang.String mutationStatus){
        this.mutationStatus = mutationStatus;
    }
	
	   
    /**
   * indication of mutation types such as Point, Deletion, Insertion, Complex
   */

    private java.lang.String mutationType;
    /**
   * indication of mutation types such as Point, Deletion, Insertion, Complex
   */

	public  java.lang.String getMutationType(){
        return mutationType;
    }
    public void setMutationType( java.lang.String mutationType){
        this.mutationType = mutationType;
    }
	
	   
    /**
   * number Of Codons Affected by mutation
   */

    private Long numberOfCodonsAffected;
    /**
   * number Of Codons Affected by mutation
   */

	public Long getNumberOfCodonsAffected(){
        return numberOfCodonsAffected;
    }
    public void setNumberOfCodonsAffected(Long numberOfCodonsAffected){
        this.numberOfCodonsAffected = numberOfCodonsAffected;
    }
	
	   
    /**
   * the size of mutation
   */

    private java.lang.String sizeOfMutation;
    /**
   * the size of mutation
   */

	public  java.lang.String getSizeOfMutation(){
        return sizeOfMutation;
    }
    public void setSizeOfMutation( java.lang.String sizeOfMutation){
        this.sizeOfMutation = sizeOfMutation;
    }
	
	   
    /**
   * non-mutant amino acid
   */

    private java.lang.String wildtypeAminoAcid;
    /**
   * non-mutant amino acid
   */

	public  java.lang.String getWildtypeAminoAcid(){
        return wildtypeAminoAcid;
    }
    public void setWildtypeAminoAcid( java.lang.String wildtypeAminoAcid){
        this.wildtypeAminoAcid = wildtypeAminoAcid;
    }
	
	   
    /**
   * non-mutant codon
   */

    private java.lang.String wildtypeCodon;
    /**
   * non-mutant codon
   */

	public  java.lang.String getWildtypeCodon(){
        return wildtypeCodon;
    }
    public void setWildtypeCodon( java.lang.String wildtypeCodon){
        this.wildtypeCodon = wildtypeCodon;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.Integer NCBI_build;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.Integer getNCBI_build(){
        return NCBI_build;
    }
    public void setNCBI_build( java.lang.Integer NCBI_build){
        this.NCBI_build = NCBI_build;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.Integer Chromosome;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.Integer getChromosome(){
        return Chromosome;
    }
    public void setChromosome( java.lang.Integer Chromosome){
        this.Chromosome = Chromosome;
    }	

		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SomaticMutationFinding) {
				SomaticMutationFinding c =(SomaticMutationFinding)obj; 			 
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

   */

    private gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.SomaticMutationAnnotation somaticMutationAnnotation;
      /**

   */

    public gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.SomaticMutationAnnotation getSomaticMutationAnnotation(){
        return somaticMutationAnnotation;			
    }

	      
	               
	   

    public void setSomatinMutationAnnotation(gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.SomaticMutationAnnotation somaticMutationAnnotation){
        this.somaticMutationAnnotation = somaticMutationAnnotation;
    }	
	   
	
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker somaticmutGene;
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker getSomaticmutGene(){
        return somaticmutGene;			
    }

    public void setSomaticmutGene(gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker somaticmutGene){
        this.somaticmutGene = somaticmutGene;
    }	
		
}