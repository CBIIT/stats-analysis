

package gov.nih.nci.caintegrator.domain.cgems.annotation.snp;

import gov.nih.nci.caintegrator.domain.cgems.finding.variation.germline.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.cgems.analysis.snp.SNPAssociationFinding;
import gov.nih.nci.caintegrator.domain.cgems.annotation.gene.GeneBiomarker;

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

public  class SNPAnnotation implements java.io.Serializable {
    public  static final String CHROMOSOME_NAME = "chromosomeName";
    public static final String CHROMOSOME_LOCATION = "chromosomeLocation";


	private static final long serialVersionUID = 1234567890L;

    /**  TODO: This is same as "id"/SNPANNO_ID attribute (internally assigned):  So commented out.  RAM
   * Unique string identifier assigned to each SNP for internal use by the CGEMS project 
   * 

    private String secondaryIdentifier;
	public String getSecondaryIdentifier(){
        return secondaryIdentifier;
    }
    public void setSecondaryIdentifier(String secondaryIdentifier){
        this.secondaryIdentifier = secondaryIdentifier;
    }
    */
      
    /**
   * name of the chromosome where the SNP has been mapped
   */
    private String chromosomeName;
	public String getChromosomeName(){
        return chromosomeName;
    }
    public void setChromosomeName(String chromosomeName){
        this.chromosomeName = chromosomeName;
    }

    /**
   * offset in number of bases of the mapped location of the SNP relative to the reference nucleotide sequence 
   * of the chromosome 
   * 
   */
    private java.lang.Long chromosomeLocation;
	public  java.lang.Long getChromosomeLocation(){
        return chromosomeLocation;
    }
    public void setChromosomeLocation( java.lang.Long chromosomeLocation){
        this.chromosomeLocation = chromosomeLocation;
    }

    /**
   * version of the NCBI dbSNP database that was used to obtain information about the SNP 
   * 
   */
    private String dbsnpBuild;
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
	public String getDbsnpId(){
        return dbsnpId;
    }
    public void setDbsnpId(String dbsnpId){
        this.dbsnpId = dbsnpId;
    }

   /**    TODO: This is has been deleted per customer/Alex:  RAM
   * the area of the gene containing or adjacent to the SNP, if any. Value include: 5' UTR, 3' UTR, CDS, RNA, 
   * GENE, PSEUDO (see NCBI assembly for more information) 
   * 

    private String geneLocation;
	public String getGeneLocation(){
        return geneLocation;
    }
    public void setGeneLocation(String geneLocation){
        this.geneLocation = geneLocation;
    }

 */
    /**
   * NCBI genome build used to determine the map location (chromosome and chromosomeLocation) of the 
   * SNP 
   * 
   */
    private String genomeBuild;
	public String getGenomeBuild(){
        return genomeBuild;
    }
    public void setGenomeBuild(String genomeBuild){
        this.genomeBuild = genomeBuild;
    }

    /**
   * the HUGO gene symbol of a gene containing or adjacent to the SNP, if any
   */
/*
    private String hugoGeneSymbol;
	public String getHugoGeneSymbol(){
        return hugoGeneSymbol;
    }
    public void setHugoGeneSymbol(String hugoGeneSymbol){
        this.hugoGeneSymbol = hugoGeneSymbol;
    }

*/
     private Set<GeneBiomarker> geneBiomarkerCollection = new HashSet<GeneBiomarker>();

      public Set<GeneBiomarker> getGeneBiomarkerCollection() {
          return geneBiomarkerCollection;
      }

      public void setGeneBiomarkerCollection(Set<GeneBiomarker> geneBiomarkerCollection) {
          this.geneBiomarkerCollection = geneBiomarkerCollection;
      }

      /**
   * Unique identifier
   */
    private String id;
	public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
    /**
   * reference nucleotide sequence used to descibe the SNP
   */
    private String referenceSequence;
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
	public String getReferenceStrand(){
        return referenceStrand;
    }
    public void setReferenceStrand(String referenceStrand){
        this.referenceStrand = referenceStrand;
    }
	
   /**
   * Statistical results of evidence for or against genetic association between the phenotypes analyzed 
   * at a particular SNP. 
   * 
   */
    private Set <SNPAssociationFinding> snpAssociationFindingCollection = new HashSet<SNPAssociationFinding>();
    public Set <SNPAssociationFinding> getSnpAssociationFindingCollection(){
        return snpAssociationFindingCollection;
    }
    public void setSnpAssociationFindingCollection(Set<SNPAssociationFinding> snpAssociationFindingCollection){
        this.snpAssociationFindingCollection = snpAssociationFindingCollection;
    }

   /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */
  private Set <gov.nih.nci.caintegrator.domain.cgems.finding.variation.snpFrequency.SNPFrequencyFinding> snpFrequencyCollection = new HashSet<gov.nih.nci.caintegrator.domain.cgems.finding.variation.snpFrequency.SNPFrequencyFinding>();
  public Set <gov.nih.nci.caintegrator.domain.cgems.finding.variation.snpFrequency.SNPFrequencyFinding> getSnpFrequencyCollection(){
        return snpFrequencyCollection;
  }
   public void setSnpFrequencyCollection(Set<gov.nih.nci.caintegrator.domain.cgems.finding.variation.snpFrequency.SNPFrequencyFinding> snpFrequencyCollection){
        this.snpFrequencyCollection = snpFrequencyCollection;
    }
	   
   /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */
   private Set <GenotypeFinding> genotypeFindingCollection = new HashSet<GenotypeFinding>();
   public Set <GenotypeFinding> getGenotypeFindingCollection(){
        return genotypeFindingCollection;
   }
    public void setGenotypeFindingCollection(Set<GenotypeFinding> genotypeFindingCollection){
        this.genotypeFindingCollection = genotypeFindingCollection;
    }

   /**
   * Information on the design characteristics of a molecular test for the presence of one or both alleles 
   * at a SNP locus. 
   * 
   */
    private Set <SNPAssay> snpAssayCollection = new HashSet<SNPAssay>();
    public Set <SNPAssay> getSnpAssayCollection(){
        return snpAssayCollection;
    }
    public void setSnpAssayCollection(Set<SNPAssay> snpAssayCollection){
        this.snpAssayCollection = snpAssayCollection;
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


      public String toString() {
          return "SNPAnnotation{" +
                  "chromosomeName='" + chromosomeName + '\'' +
                  ", chromosomeLocation=" + chromosomeLocation +
                  ", dbsnpBuild='" + dbsnpBuild + '\'' +
                  ", dbsnpId='" + dbsnpId + '\'' +
                  ", genomeBuild='" + genomeBuild + '\'' +
                  ", id='" + id + '\'' +
                  ", referenceSequence='" + referenceSequence + '\'' +
                  ", referenceStrand='" + referenceStrand + '\'' +
                  ", snpAssociationFindingCollection=" + snpAssociationFindingCollection +
                  ", snpFrequencyCollection=" + snpFrequencyCollection +
                  ", genotypeFindingCollection=" + genotypeFindingCollection +
                  ", snpAssayCollection=" + snpAssayCollection +
                  '}';
      }
  }