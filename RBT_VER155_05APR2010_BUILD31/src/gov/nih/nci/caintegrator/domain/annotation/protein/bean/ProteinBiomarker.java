

package gov.nih.nci.caintegrator.domain.annotation.protein.bean;
import gov.nih.nci.caintegrator.domain.annotation.protein.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A ProteinBiomarker is a protein or antibody based biological parameter that is indicative of a physiological 
   * or pathological state. For example, HER2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

public  class ProteinBiomarker 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * unique identifier for the instance of ProteinBiomarker.
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of ProteinBiomarker.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * antibody protein name
   */

    private java.lang.String name;
    /**
   * antibody protein name
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof ProteinBiomarker) {
				ProteinBiomarker c =(ProteinBiomarker)obj; 			 
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
   * Protein Alternative Name Identifier
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinAlias> proteinAliasCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinAlias>();
      /**
   * Protein Alternative Name Identifier
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinAlias> getProteinAliasCollection(){
        return proteinAliasCollection;
    }

	      
	               
	   
    public void setProteinAliasCollection(Set<gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinAlias> proteinAliasCollection){
        this.proteinAliasCollection = proteinAliasCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * The unique genomic identifier for a protein sequence assigned by the Universal Protein Resource 
   * Knowledge Base. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.protein.bean.UniprotAccession> uniprotAccessionCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.protein.bean.UniprotAccession>();
      /**
   * The unique genomic identifier for a protein sequence assigned by the Universal Protein Resource 
   * Knowledge Base. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.protein.bean.UniprotAccession> getUniprotAccessionCollection(){
        return uniprotAccessionCollection;
    }

	      
	               
	   
    public void setUniprotAccessionCollection(Set<gov.nih.nci.caintegrator.domain.annotation.protein.bean.UniprotAccession> uniprotAccessionCollection){
        this.uniprotAccessionCollection = uniprotAccessionCollection;
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