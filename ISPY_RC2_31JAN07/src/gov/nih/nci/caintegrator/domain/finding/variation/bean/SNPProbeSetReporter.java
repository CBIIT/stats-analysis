

package gov.nih.nci.caintegrator.domain.finding.variation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Variation reporter is a design element which is used to report change (variation) - alteration, 
   * deletion, or rearrangement - in the DNA sequence . 
   * 
   */

public  abstract class SNPProbeSetReporter 
    extends gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;
	   
    /**
   * name of the variation reporter
   */

    private java.lang.String name;
    /**
   * name of the variation reporter
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPProbeSetReporter) {
				SNPProbeSetReporter c =(SNPProbeSetReporter)obj; 			 
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