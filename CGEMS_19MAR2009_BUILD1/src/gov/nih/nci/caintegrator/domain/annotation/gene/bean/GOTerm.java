

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
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

public  class GOTerm 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Gene Ontology Term Identifier
   */

    private java.lang.String id;
    /**
   * Gene Ontology Term Identifier
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * Gene Ontology Term Name
   */

    private java.lang.String name;
    /**
   * Gene Ontology Term Name
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GOTerm) {
				GOTerm c =(GOTerm)obj; 			 
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