

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A chemical or biological substance with specific characteristics used in a study for treatment 
   * or prevention of cancer or another disease as specified by the protocol. 
   * 
   */

public  class Agent 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The text that describes the formulation of the agent used in the study (DCP).
   */

    private String description;
    /**
   * The text that describes the formulation of the agent used in the study (DCP).
   */

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
	   
    /**
   * The code that represents the formulation of the agent used in the study (DCP)
   */

    private String formCode;
    /**
   * The code that represents the formulation of the agent used in the study (DCP)
   */

	public String getFormCode(){
        return formCode;
    }
    public void setFormCode(String formCode){
        this.formCode = formCode;
    }
	
	   
    /**
   * Unique identifier for the instance of Agent
   */

    private java.lang.Long id;
    /**
   * Unique identifier for the instance of Agent
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * The name of the agent used in the treatment regimen following CTMS requirements for name formatting 
   * 
   */

    private String name;
    /**
   * The name of the agent used in the treatment regimen following CTMS requirements for name formatting 
   * 
   */

	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Agent) {
				Agent c =(Agent)obj; 			 
				Long thisId = getId();		
				
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
   * The various name(s) attributed to a chemical or biological substance used as part of a study for the 
   * treatment or prevention of disease. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.AgentSynonym> agentSynonymCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.AgentSynonym>();
      /**
   * The various name(s) attributed to a chemical or biological substance used as part of a study for the 
   * treatment or prevention of disease. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.AgentSynonym> getAgentSynonymCollection(){
        return agentSynonymCollection;
    }

	      
	               
	   
    public void setAgentSynonymCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.AgentSynonym> agentSynonymCollection){
        this.agentSynonymCollection = agentSynonymCollection;
    }
	   
	   
	

			
}