

package gov.nih.nci.caintegrator.domain.finding.bean;
import gov.nih.nci.caintegrator.domain.finding.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**

   */

public  abstract class EpidimeologicalFinding 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String id;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof EpidimeologicalFinding) {
				EpidimeologicalFinding c =(EpidimeologicalFinding)obj; 			 
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