

package gov.nih.nci.caintegrator.domain.common.bean;
import gov.nih.nci.caintegrator.domain.common.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A standard of basic quantity or increment represented by textual value  
   */

public  class TextMeasurement 
    extends gov.nih.nci.caintegrator.domain.common.bean.Measurement


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The actual textual quantity such as  "Satisfactory".
   */

    private java.lang.String value;
    /**
   * The actual textual quantity such as  "Satisfactory".
   */

	public  java.lang.String getValue(){
        return value;
    }
    public void setValue( java.lang.String value){
        this.value = value;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof TextMeasurement) {
				TextMeasurement c =(TextMeasurement)obj; 			 
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