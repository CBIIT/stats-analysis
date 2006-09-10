

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Places in the genomic sequence where one fraction of the human population has one nucleotide or allele, 
   * while another fraction has another. 
   * 
   */

public  class SNPAnnotation 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * offset in number of bases of the mapped location of the SNP relative to the reference nucleotide sequence 
   * of the chromosome 
   * 
   */

    private java.lang.Long chromosomeLocation;
    /**
   * offset in number of bases of the mapped location of the SNP relative to the reference nucleotide sequence 
   * of the chromosome 
   * 
   */

	public  java.lang.Long getChromosomeLocation(){
        return chromosomeLocation;
    }
    public void setChromosomeLocation( java.lang.Long chromosomeLocation){
        this.chromosomeLocation = chromosomeLocation;
    }
	
	   
    /**
   * name of the chromosome where the SNP has been mapped
   */

    private String chromosomeName;
    /**
   * name of the chromosome where the SNP has been mapped
   */

	public String getChromosomeName(){
        return chromosomeName;
    }
    public void setChromosomeName(String chromosomeName){
        this.chromosomeName = chromosomeName;
    }
	
	   
    /**
   * version of the NCBI dbSNP database that was used to obtain information about the SNP 
   * 
   */

    private String dbsnpBuild;
    /**
   * version of the NCBI dbSNP database that was used to obtain information about the SNP 
   * 
   */

	public String getDbsnpBuild(){
        return dbsnpBuild;
    }
    public void setDbsnpBuild(String dbsnpBuild){
        this.dbsnpBuild = dbsnpBuild;
    }
	
	   
    /**
   * identifier for the SNP in the NCBI dbSNP database
   */

    private String dbsnpId;
    /**
   * identifier for the SNP in the NCBI dbSNP database
   */

	public String getDbsnpId(){
        return dbsnpId;
    }
    public void setDbsnpId(String dbsnpId){
        this.dbsnpId = dbsnpId;
    }
	
	   
    /**
   * the area of the gene containing or adjacent to the SNP, if any. Value include: 5' UTR, 3' UTR, CDS, RNA, 
   * GENE, PSEUDO (see NCBI assembly for more information) 
   * 
   */

    private String geneLocation;
    /**
   * the area of the gene containing or adjacent to the SNP, if any. Value include: 5' UTR, 3' UTR, CDS, RNA, 
   * GENE, PSEUDO (see NCBI assembly for more information) 
   * 
   */

	public String getGeneLocation(){
        return geneLocation;
    }
    public void setGeneLocation(String geneLocation){
        this.geneLocation = geneLocation;
    }
	
	   
    /**
   * NCBI genome build used to determine the map location (chromosome and chromosomeLocation) of the 
   * SNP 
   * 
   */

    private String genomeBuild;
    /**
   * NCBI genome build used to determine the map location (chromosome and chromosomeLocation) of the 
   * SNP 
   * 
   */

	public String getGenomeBuild(){
        return genomeBuild;
    }
    public void setGenomeBuild(String genomeBuild){
        this.genomeBuild = genomeBuild;
    }
	
	   
    /**
   * Unique identifier  for the instance of SNPAnnotation.
   */

    private java.lang.String id;
    /**
   * Unique identifier  for the instance of SNPAnnotation.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * reference nucleotide sequence used to descibe the SNP
   */

    private String referenceSequence;
    /**
   * reference nucleotide sequence used to descibe the SNP
   */

	public String getReferenceSequence(){
        return referenceSequence;
    }
    public void setReferenceSequence(String referenceSequence){
        this.referenceSequence = referenceSequence;
    }
	
	   
    /**
   * the orientation of the SNP reference sequence to the NCBI reference sequence
   */

    private String referenceStrand;
    /**
   * the orientation of the SNP reference sequence to the NCBI reference sequence
   */

	public String getReferenceStrand(){
        return referenceStrand;
    }
    public void setReferenceStrand(String referenceStrand){
        this.referenceStrand = referenceStrand;
    }
	
	   
    /**
   * Unique string identifier assigned to each SNP for internal use by the CGEMS project 
   * 
   */

    private String secondaryIdentifier;
    /**
   * Unique string identifier assigned to each SNP for internal use by the CGEMS project 
   * 
   */

	public String getSecondaryIdentifier(){
        return secondaryIdentifier;
    }
    public void setSecondaryIdentifier(String secondaryIdentifier){
        this.secondaryIdentifier = secondaryIdentifier;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPAnnotation) {
				SNPAnnotation c =(SNPAnnotation)obj; 			 
				String thisId = getId();		
				
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
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding> snpFrequencyCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding>();
      /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding> getSnpFrequencyCollection(){
        return snpFrequencyCollection;
    }

	      
	               
	   
    public void setSnpFrequencyCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding> snpFrequencyCollection){
        this.snpFrequencyCollection = snpFrequencyCollection;
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
	   
	   
	
	   
	   
	   
	      
      /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay> snpAssayCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay>();
      /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay> getSnpAssayCollection(){
        return snpAssayCollection;
    }

	      
	               
	   
    public void setSnpAssayCollection(Set<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay> snpAssayCollection){
        this.snpAssayCollection = snpAssayCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker> geneBiomarkerCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker>();
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker> getGeneBiomarkerCollection(){
        return geneBiomarkerCollection;
    }

	      
	               
	   
    public void setGeneBiomarkerCollection(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker> geneBiomarkerCollection){
        this.geneBiomarkerCollection = geneBiomarkerCollection;
    }
	   
	   
	

			
}