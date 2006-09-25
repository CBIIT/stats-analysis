

package gov.nih.nci.caintegrator.domain.finding.bean;
import gov.nih.nci.caintegrator.domain.finding.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Results obtained from an analysis or discovery (finding) gathered through experimental assays 
   * or evaluations performed on a specimen. 
   * 
   */

public  class SpecimenBasedMolecularFinding 
    extends gov.nih.nci.caintegrator.domain.finding.bean.Finding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier  for the instance of SpecimenBasedMolecularFinding.
   */

    private java.lang.Long id;
    /**
   * Unique identifier  for the instance of SpecimenBasedMolecularFinding.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SpecimenBasedMolecularFinding) {
				SpecimenBasedMolecularFinding c =(SpecimenBasedMolecularFinding)obj; 			 
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
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Specimen specimen;
      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Specimen getSpecimen(){
        return specimen;			
    }

	      
	               
	   

    public void setSpecimen(gov.nih.nci.caintegrator.domain.study.bean.Specimen specimen){
        this.specimen = specimen;
    }	
	   
	   
	

			
}