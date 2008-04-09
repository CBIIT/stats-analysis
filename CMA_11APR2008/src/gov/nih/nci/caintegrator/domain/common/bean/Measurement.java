

package gov.nih.nci.caintegrator.domain.common.bean;
import gov.nih.nci.caintegrator.domain.common.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A standard of basic quantity or increment represented by value and unit 
   */

public  abstract class Measurement 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier for the instance of Measurement.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of Measurement.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * A standard of basic quantity or increment by which something is divided, counted, or described, 
   * such as ml, kg, mm, m/s, °F, etc. 
   * 
   */

    private java.lang.String unitOfMeasure;
    /**
   * A standard of basic quantity or increment by which something is divided, counted, or described, 
   * such as ml, kg, mm, m/s, °F, etc. 
   * 
   */

	public  java.lang.String getUnitOfMeasure(){
        return unitOfMeasure;
    }
    public void setUnitOfMeasure( java.lang.String unitOfMeasure){
        this.unitOfMeasure = unitOfMeasure;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Measurement) {
				Measurement c =(Measurement)obj; 			 
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