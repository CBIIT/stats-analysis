

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

public  class GeneBiomarker 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The numeric or letter designation of a chromosome. Autosomes are usually indicated by numbers and 
   * sex chromosomes by letters. 
   * 
   */

    private java.lang.String chromosome;
    /**
   * The numeric or letter designation of a chromosome. Autosomes are usually indicated by numbers and 
   * sex chromosomes by letters. 
   * 
   */

	public  java.lang.String getChromosome(){
        return chromosome;
    }
    public void setChromosome( java.lang.String chromosome){
        this.chromosome = chromosome;
    }
	
	   
    /**
   * Chromosome Band Identifier 
   */

    private java.lang.String cytoband;
    /**
   * Chromosome Band Identifier 
   */

	public  java.lang.String getCytoband(){
        return cytoband;
    }
    public void setCytoband( java.lang.String cytoband){
        this.cytoband = cytoband;
    }
	
	   
    /**
   * Gene Entrez Gene Genomic Identifier
   */

    private java.lang.String entrezGeneID;
    /**
   * Gene Entrez Gene Genomic Identifier
   */

	public  java.lang.String getEntrezGeneID(){
        return entrezGeneID;
    }
    public void setEntrezGeneID( java.lang.String entrezGeneID){
        this.entrezGeneID = entrezGeneID;
    }
	
	   
    /**
   * A unique gene name approved by the Human Genome Organization's Nomenclature Committee. 
   * 
   */

    private java.lang.String hugoGeneSymbol;
    /**
   * A unique gene name approved by the Human Genome Organization's Nomenclature Committee. 
   * 
   */

	public  java.lang.String getHugoGeneSymbol(){
        return hugoGeneSymbol;
    }
    public void setHugoGeneSymbol( java.lang.String hugoGeneSymbol){
        this.hugoGeneSymbol = hugoGeneSymbol;
    }
	
	   
    /**
   * unique identifier for the instance of GeneBiomarker.
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of GeneBiomarker.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The specific ending physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

    private java.lang.Long endPhysicalLocation;
    /**
   * The specific ending physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

	public  java.lang.Long getEndPhysicalLocation(){
        return endPhysicalLocation;
    }
    public void setEndPhysicalLocation( java.lang.Long endPhysicalLocation){
        this.endPhysicalLocation = endPhysicalLocation;
    }
	
	   
    /**
   * The specific starting physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

    private java.lang.Long startPhyscialLocation;
    /**
   * The specific starting physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

	public  java.lang.Long getStartPhyscialLocation(){
        return startPhyscialLocation;
    }
    public void setStartPhyscialLocation( java.lang.Long startPhyscialLocation){
        this.startPhyscialLocation = startPhyscialLocation;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GeneBiomarker) {
				GeneBiomarker c =(GeneBiomarker)obj; 			 
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
   * Places in the genomic sequence where one fraction of the human population has one nucleotide or allele, 
   * while another fraction has another. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation> snpAnnotationCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation>();
      /**
   * Places in the genomic sequence where one fraction of the human population has one nucleotide or allele, 
   * while another fraction has another. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation> getSnpAnnotationCollection(){
        return snpAnnotationCollection;
    }

	      
	               
	   
    public void setSnpAnnotationCollection(Set<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation> snpAnnotationCollection){
        this.snpAnnotationCollection = snpAnnotationCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * The Gene Ontology (GO) project is a collaborative effort to address the need for consistent descriptions 
   * of gene products in different databases. The goal of the Gene Ontology project is to produce a controlled 
   * vocabulary that can be applied to all organisms even as knowledge of gene and protein roles in cells 
   * is accumulating and changing. GO provides three structured networks of defined terms, molecular 
   * function, biological process, and cellular component, to describe gene product attributes. (from 
   * http://www.geneontology.org/):A word or expression used for some particular thing._The words 
   * or language units by which a thing is known._Value Domain for java language String datatype. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GOTerm> goTermCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GOTerm>();
      /**
   * The Gene Ontology (GO) project is a collaborative effort to address the need for consistent descriptions 
   * of gene products in different databases. The goal of the Gene Ontology project is to produce a controlled 
   * vocabulary that can be applied to all organisms even as knowledge of gene and protein roles in cells 
   * is accumulating and changing. GO provides three structured networks of defined terms, molecular 
   * function, biological process, and cellular component, to describe gene product attributes. (from 
   * http://www.geneontology.org/):A word or expression used for some particular thing._The words 
   * or language units by which a thing is known._Value Domain for java language String datatype. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GOTerm> getGoTermCollection(){
        return goTermCollection;
    }

	      
	               
	   
    public void setGoTermCollection(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GOTerm> goTermCollection){
        this.goTermCollection = goTermCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A Design Element that represents some biological material (clone, oligo, etc.) on an array which 
   * will report on some biosequence or biosequences; eg: Affymetrix probeset or cDNA clone (Note: may 
   * not be equivalent to a MAGE-OM Reporter in all cases.) 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter> geneExprReporterCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter>();
      /**
   * A Design Element that represents some biological material (clone, oligo, etc.) on an array which 
   * will report on some biosequence or biosequences; eg: Affymetrix probeset or cDNA clone (Note: may 
   * not be equivalent to a MAGE-OM Reporter in all cases.) 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter> getGeneExprReporterCollection(){
        return geneExprReporterCollection;
    }

	      
	               
	   
    public void setGeneExprReporterCollection(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter> geneExprReporterCollection){
        this.geneExprReporterCollection = geneExprReporterCollection;
    }
	   
	   
	
	   
	   
	   
	      
	   
	
	   
	   
	   
	      
      /**
   * The accession number is the unique identifier assigned to the entire sequence record when the record 
   * is submitted to GenBank. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GenBankAccession> genBankAccessionCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GenBankAccession>();
      /**
   * The accession number is the unique identifier assigned to the entire sequence record when the record 
   * is submitted to GenBank. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GenBankAccession> getGenBankAccessionCollection(){
        return genBankAccessionCollection;
    }

	      
	               
	   
    public void setGenBankAccessionCollection(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GenBankAccession> genBankAccessionCollection){
        this.genBankAccessionCollection = genBankAccessionCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * An elaboration of the sequence of chemical reactions leading from one compound to another taking 
   * place in living tissue._A statement or an account describing something._Value Domain for java 
   * language String datatype. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.Pathway> pathwayCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.Pathway>();
      /**
   * An elaboration of the sequence of chemical reactions leading from one compound to another taking 
   * place in living tissue._A statement or an account describing something._Value Domain for java 
   * language String datatype. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.Pathway> getPathwayCollection(){
        return pathwayCollection;
    }

	      
	               
	   
    public void setPathwayCollection(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.Pathway> pathwayCollection){
        this.pathwayCollection = pathwayCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A ProteinBiomarker is a protein or antibody based biological parameter that is indicative of a physiological 
   * or pathological state. For example, HER2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker> proteinBiomarkerCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker>();
      /**
   * A ProteinBiomarker is a protein or antibody based biological parameter that is indicative of a physiological 
   * or pathological state. For example, HER2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker> getProteinBiomarkerCollection(){
        return proteinBiomarkerCollection;
    }

	      
	               
	   
    public void setProteinBiomarkerCollection(Set<gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker> proteinBiomarkerCollection){
        this.proteinBiomarkerCollection = proteinBiomarkerCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * Alternative gene symbol to the official HUGO gene symbol
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneAlias> geneAliasCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneAlias>();
      /**
   * Alternative gene symbol to the official HUGO gene symbol
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneAlias> getGeneAliasCollection(){
        return geneAliasCollection;
    }

	      
	               
	   
    public void setGeneAliasCollection(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneAlias> geneAliasCollection){
        this.geneAliasCollection = geneAliasCollection;
    }


}