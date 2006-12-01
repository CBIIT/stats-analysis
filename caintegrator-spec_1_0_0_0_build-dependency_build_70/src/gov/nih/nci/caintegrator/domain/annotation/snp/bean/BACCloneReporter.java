

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Bacterial Artificial Chromosome (BAC) Clone Reporter is a Design Element which is used to report 
   * on some biosequence or biosequences 
   * 
   */

public  class BACCloneReporter 
    extends gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * unique identifier for instance of the bacCloneReporter
   */

    private java.lang.String id;
    /**
   * unique identifier for instance of the bacCloneReporter
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * A clone is identified by its microtitre plate address (plate number, row, and column) and prefixed 
   * by a library abbreviation to produce a unique name. 
   * 
   */

    private java.lang.String name;
    /**
   * A clone is identified by its microtitre plate address (plate number, row, and column) and prefixed 
   * by a library abbreviation to produce a unique name. 
   * 
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof BACCloneReporter) {
				BACCloneReporter c =(BACCloneReporter)obj; 			 
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