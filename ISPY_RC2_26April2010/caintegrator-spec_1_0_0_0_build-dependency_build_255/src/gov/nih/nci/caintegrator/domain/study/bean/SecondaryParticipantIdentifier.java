

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The secondary unique identifier assigned to identify a patient on a study.
   */

public  class SecondaryParticipantIdentifier 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier for the instance of SecondaryParticipantIdentifier
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of SecondaryParticipantIdentifier
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * Name of the organization or an institution invovled in the trial. (DCP)
   */

    private java.lang.String organizationName;
    /**
   * Name of the organization or an institution invovled in the trial. (DCP)
   */

	public  java.lang.String getOrganizationName(){
        return organizationName;
    }
    public void setOrganizationName( java.lang.String organizationName){
        this.organizationName = organizationName;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SecondaryParticipantIdentifier) {
				SecondaryParticipantIdentifier c =(SecondaryParticipantIdentifier)obj; 			 
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
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant studyParticipant;
      /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant getStudyParticipant(){
        return studyParticipant;			
    }

	      
	               
	   

    public void setStudyParticipant(gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant studyParticipant){
        this.studyParticipant = studyParticipant;
    }	
	   
	   
	

			
}