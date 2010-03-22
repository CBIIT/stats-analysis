

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Indicates analysis tasks in the trial such as procdure or SubstanceAdministration. 
   * 
   */

public  class Activity 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Free format description of the protocol tracking activity worthy of documentation. 
   * 
   */

    private String description;
    /**
   * Free format description of the protocol tracking activity worthy of documentation. 
   * 
   */

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
	   
    /**
   * Unique identifier for the instance of Activity.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of Activity.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * Names assigned to health care procedures done for diagnostic, surveillance, treatment, palliation, 
   * or study-directed purposes. Values include: Bone Scan; Colonoscopy; CAT Scan; Biopsy; Flow Cytometry, 
   * Blood; Flow Cytometry, Bone Marrow; MRI; X-ray, Chest; Physical Examination, Positron Emission 
   * Tomography; MUGA Scan; Transrectal Ultrasound; Ultrasound; Flow cytometry. NOTE: Also maps to 
   * Test Name 2004448 and Procedure performed indicator 2006635. NOTE: Should consider adding "Lab 
   * Draw" as a possible type of Procedure. AnthraCyclline-1, AnthraCyclline-2, Taxane-1 
   * 
   */

    private String name;
    /**
   * Names assigned to health care procedures done for diagnostic, surveillance, treatment, palliation, 
   * or study-directed purposes. Values include: Bone Scan; Colonoscopy; CAT Scan; Biopsy; Flow Cytometry, 
   * Blood; Flow Cytometry, Bone Marrow; MRI; X-ray, Chest; Physical Examination, Positron Emission 
   * Tomography; MUGA Scan; Transrectal Ultrasound; Ultrasound; Flow cytometry. NOTE: Also maps to 
   * Test Name 2004448 and Procedure performed indicator 2006635. NOTE: Should consider adding "Lab 
   * Draw" as a possible type of Procedure. AnthraCyclline-1, AnthraCyclline-2, Taxane-1 
   * 
   */

	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	
	   
    /**
   * The begin date of a measure or agent. NOTE: Also maps to Treatment Start Date 2003363, Blood Component 
   * Transfusion Date 2184925, Dose modification start date 2006422, Off Study Date 2003605 when epochName=Off 
   * Study. Off Study Followup Date 2177930 when epochName = Off Study. Start Time 2004095. NOTE: Derived 
   * Dose Modification Interval 2006440 when stopDate - startDate. NOTE: Also maps to Lab Collection 
   * Time 2003580 and Specimen Collection Indicator 2006750. 
   * 
   */

    private Long startDayNumber;
    /**
   * The begin date of a measure or agent. NOTE: Also maps to Treatment Start Date 2003363, Blood Component 
   * Transfusion Date 2184925, Dose modification start date 2006422, Off Study Date 2003605 when epochName=Off 
   * Study. Off Study Followup Date 2177930 when epochName = Off Study. Start Time 2004095. NOTE: Derived 
   * Dose Modification Interval 2006440 when stopDate - startDate. NOTE: Also maps to Lab Collection 
   * Time 2003580 and Specimen Collection Indicator 2006750. 
   * 
   */

	public Long getStartDayNumber(){
        return startDayNumber;
    }
    public void setStartDayNumber(Long startDayNumber){
        this.startDayNumber = startDayNumber;
    }
	
	   
    /**
   * Status of the activity
   */

    private java.lang.String status;
    /**
   * Status of the activity
   */

	public  java.lang.String getStatus(){
        return status;
    }
    public void setStatus( java.lang.String status){
        this.status = status;
    }
	
	   
    /**
   * The end date of a measure or agent. NOTE: Also maps to Treatment Phase End Date 2187546, Dose Modification 
   * End Date 2006438, Stop Time 2004139. 
   * 
   */

    private Long stopDayNumber;
    /**
   * The end date of a measure or agent. NOTE: Also maps to Treatment Phase End Date 2187546, Dose Modification 
   * End Date 2006438, Stop Time 2004139. 
   * 
   */

	public Long getStopDayNumber(){
        return stopDayNumber;
    }
    public void setStopDayNumber(Long stopDayNumber){
        this.stopDayNumber = stopDayNumber;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Activity) {
				Activity c =(Activity)obj; 			 
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