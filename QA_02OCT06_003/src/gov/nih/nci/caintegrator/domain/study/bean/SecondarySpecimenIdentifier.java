

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The secondary unique identifier assigned to identify a specimen on a study. 
   */

public  class SecondarySpecimenIdentifier 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier for the instance of SecondarySpecimenIdentifier
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of SecondarySpecimenIdentifier
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * Name of the organization or an institution invovled in the trial. (DCP)
   */

    private java.lang.String organizationName;
    /**
   * Name of the organization or an institution invovled in the trial. (DCP)
   */

	public  java.lang.String getOrganizationName(){
        return organizationName;
    }
    public void setOrganizationName( java.lang.String organizationName){
        this.organizationName = organizationName;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SecondarySpecimenIdentifier) {
				SecondarySpecimenIdentifier c =(SecondarySpecimenIdentifier)obj; 			 
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
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Specimen> specimen = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Specimen>();
      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Specimen> getSpecimen(){
        return specimen;
    }

	      
	               
	   
    public void setSpecimen(Set<gov.nih.nci.caintegrator.domain.study.bean.Specimen> specimen){
        this.specimen = specimen;
    }
	   
	   
	

			
}