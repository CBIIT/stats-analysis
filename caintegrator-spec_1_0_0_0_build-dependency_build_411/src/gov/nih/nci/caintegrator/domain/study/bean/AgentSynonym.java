

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The various name(s) attributed to a chemical or biological substance used as part of a study for the 
   * treatment or prevention of disease. 
   * 
   */

public  class AgentSynonym 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier for the instance of AgentSynonym
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of AgentSynonym
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The alternate name for the agent.
   */

    private String name;
    /**
   * The alternate name for the agent.
   */

	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof AgentSynonym) {
				AgentSynonym c =(AgentSynonym)obj; 			 
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