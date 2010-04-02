

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * An elaboration of the sequence of chemical reactions leading from one compound to another taking 
   * place in living tissue._A statement or an account describing something._Value Domain for java 
   * language String datatype. 
   * 
   */

public  class Pathway 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * unique identifier for the instance of Pathway.
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of Pathway.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * Name of the Biochemical Pathway
   */

    private java.lang.String name;
    /**
   * Name of the Biochemical Pathway
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Pathway) {
				Pathway c =(Pathway)obj; 			 
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