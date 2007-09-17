

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A procedure to remove or repair a part of the body or to establish whether or not disease is present. 
   * NOTE: Deleted Biopsy as a type of Surgery. 2/2/05 
   * 
   */

public  class Surgery 
    extends gov.nih.nci.caintegrator.domain.study.bean.Procedure


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The code that represents that surgical outcome or procedure that was performed
   */

    private String outcomeCode;
    /**
   * The code that represents that surgical outcome or procedure that was performed
   */

	public String getOutcomeCode(){
        return outcomeCode;
    }
    public void setOutcomeCode(String outcomeCode){
        this.outcomeCode = outcomeCode;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Surgery) {
				Surgery c =(Surgery)obj; 			 
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

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Specimen> specimenCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Specimen>();
      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Specimen> getSpecimenCollection(){
        return specimenCollection;
    }

	      
	               
	   
    public void setSpecimenCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Specimen> specimenCollection){
        this.specimenCollection = specimenCollection;
    }
	   
	   
	

			
}