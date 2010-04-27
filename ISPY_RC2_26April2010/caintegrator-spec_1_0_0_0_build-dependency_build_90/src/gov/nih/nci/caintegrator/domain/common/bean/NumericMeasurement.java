

package gov.nih.nci.caintegrator.domain.common.bean;
import gov.nih.nci.caintegrator.domain.common.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A standard of basic quantity or increment represented by numeric value  
   */

public  class NumericMeasurement 
    extends gov.nih.nci.caintegrator.domain.common.bean.Measurement


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The actual numerical  quantity  such as 10.0 .
   */

    private java.lang.Double absoluteValue;
    /**
   * The actual numerical  quantity  such as 10.0 .
   */

	public  java.lang.Double getAbsoluteValue(){
        return absoluteValue;
    }
    public void setAbsoluteValue( java.lang.Double absoluteValue){
        this.absoluteValue = absoluteValue;
    }
	
	   
    /**
   * The actual maximum numerical  quantity  such as 10.0 .
   */

    private java.lang.Double maxValue;
    /**
   * The actual maximum numerical  quantity  such as 10.0 .
   */

	public  java.lang.Double getMaxValue(){
        return maxValue;
    }
    public void setMaxValue( java.lang.Double maxValue){
        this.maxValue = maxValue;
    }
	
	   
    /**
   * The actual minimum numerical  quantity such as 10.0 .
   */

    private java.lang.Double minValue;
    /**
   * The actual minimum numerical  quantity such as 10.0 .
   */

	public  java.lang.Double getMinValue(){
        return minValue;
    }
    public void setMinValue( java.lang.Double minValue){
        this.minValue = minValue;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof NumericMeasurement) {
				NumericMeasurement c =(NumericMeasurement)obj; 			 
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