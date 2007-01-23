

package gov.nih.nci.caintegrator.domain.finding.clinical.bean;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Results of a clinical analysis
   */

public  abstract class ClinicalFinding 
    extends gov.nih.nci.caintegrator.domain.finding.bean.Finding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Unique identifier for the instance of ClinicalFinding.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of ClinicalFinding.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof ClinicalFinding) {
				ClinicalFinding c =(ClinicalFinding)obj; 			 
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
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * An ordered list of times at which events and activities are planned to occur during a clinical trial. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.TimeCourse timeCourse;
      /**
   * An ordered list of times at which events and activities are planned to occur during a clinical trial. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.TimeCourse getTimeCourse(){
        return timeCourse;			
    }

	      
	               
	   

    public void setTimeCourse(gov.nih.nci.caintegrator.domain.study.bean.TimeCourse timeCourse){
        this.timeCourse = timeCourse;
    }	
	   
	   
	

			
}