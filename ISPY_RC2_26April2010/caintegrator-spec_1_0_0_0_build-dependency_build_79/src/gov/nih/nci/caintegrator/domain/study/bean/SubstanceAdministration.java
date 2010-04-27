

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The schedule and route of applying, dispensing or giving agents or medications to subjects as prescribed 
   * within a clinical trial protocol. 
   * 
   */

public  class SubstanceAdministration 
    extends gov.nih.nci.caintegrator.domain.study.bean.Activity


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unit of measurement (UOM) used to express the amount of agent used in dosing. NOTE: Includes 110 Values. 
   * 
   */

    private String doseUnitOfMeasure;
    /**
   * Unit of measurement (UOM) used to express the amount of agent used in dosing. NOTE: Includes 110 Values. 
   * 
   */

	public String getDoseUnitOfMeasure(){
        return doseUnitOfMeasure;
    }
    public void setDoseUnitOfMeasure(String doseUnitOfMeasure){
        this.doseUnitOfMeasure = doseUnitOfMeasure;
    }
	
	   
    /**
   * Value that represents the total dose of an agent.  
   */

    private Long totalDoseQuantity;
    /**
   * Value that represents the total dose of an agent.  
   */

	public Long getTotalDoseQuantity(){
        return totalDoseQuantity;
    }
    public void setTotalDoseQuantity(Long totalDoseQuantity){
        this.totalDoseQuantity = totalDoseQuantity;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SubstanceAdministration) {
				SubstanceAdministration c =(SubstanceAdministration)obj; 			 
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
   * A chemical or biological substance with specific characteristics used in a study for treatment 
   * or prevention of cancer or another disease as specified by the protocol. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Agent agent;
      /**
   * A chemical or biological substance with specific characteristics used in a study for treatment 
   * or prevention of cancer or another disease as specified by the protocol. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Agent getAgent(){
        return agent;			
    }

	      
	               
	   

    public void setAgent(gov.nih.nci.caintegrator.domain.study.bean.Agent agent){
        this.agent = agent;
    }	
	   
	   
	

			
}