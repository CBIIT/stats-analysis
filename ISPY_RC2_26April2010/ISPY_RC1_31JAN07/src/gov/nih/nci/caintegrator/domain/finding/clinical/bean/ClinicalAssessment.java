

package gov.nih.nci.caintegrator.domain.finding.clinical.bean;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Assessment or an observation by a clinician
   */

public  class ClinicalAssessment 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier for the instance of ClinicalAssessment.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of ClinicalAssessment.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The value for the clinical assessment.
   */

    private java.lang.String value;
    /**
   * The value for the clinical assessment.
   */

	public  java.lang.String getValue(){
        return value;
    }
    public void setValue( java.lang.String value){
        this.value = value;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof ClinicalAssessment) {
				ClinicalAssessment c =(ClinicalAssessment)obj; 			 
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

			
}