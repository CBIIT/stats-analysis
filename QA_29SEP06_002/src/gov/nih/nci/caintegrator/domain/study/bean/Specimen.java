

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

public  class Specimen 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Specifies the routine of gathering and/or locating the sites for body samples, such as, urine, blood, 
   * biopsies, etc. to be used in the conduct of a clinical trial 
   * 
   */

    private java.lang.String collectionMethod;
    /**
   * Specifies the routine of gathering and/or locating the sites for body samples, such as, urine, blood, 
   * biopsies, etc. to be used in the conduct of a clinical trial 
   * 
   */

	public  java.lang.String getCollectionMethod(){
        return collectionMethod;
    }
    public void setCollectionMethod( java.lang.String collectionMethod){
        this.collectionMethod = collectionMethod;
    }
	
	   
    /**
   * Unique identifier for the instance of Specimen.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of Specimen.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * type of biological sample obtained from the subject.  
   */

    private java.lang.String materialType;
    /**
   * type of biological sample obtained from the subject.  
   */

	public  java.lang.String getMaterialType(){
        return materialType;
    }
    public void setMaterialType( java.lang.String materialType){
        this.materialType = materialType;
    }
	
	   
    /**
   * A unique sample, I.D. number  
   */

    private java.lang.String specimenIdentifier;
    /**
   * A unique sample, I.D. number  
   */

	public  java.lang.String getSpecimenIdentifier(){
        return specimenIdentifier;
    }
    public void setSpecimenIdentifier( java.lang.String specimenIdentifier){
        this.specimenIdentifier = specimenIdentifier;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Specimen) {
				Specimen c =(Specimen)obj; 			 
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
   * The secondary unique identifier assigned to identify a specimen on a study. 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.SecondarySpecimenIdentifier> secondarySpecimenIdentifier = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.SecondarySpecimenIdentifier>();
      /**
   * The secondary unique identifier assigned to identify a specimen on a study. 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.SecondarySpecimenIdentifier> getSecondarySpecimenIdentifier(){
        return secondarySpecimenIdentifier;
    }

	      
	               
	   
    public void setSecondarySpecimenIdentifier(Set<gov.nih.nci.caintegrator.domain.study.bean.SecondarySpecimenIdentifier> secondarySpecimenIdentifier){
        this.secondarySpecimenIdentifier = secondarySpecimenIdentifier;
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
   * The result of examination of tissues under the microscope to assist diagnosis of tumors. For example, 
   * after a biopsy is performed, a pathologist will perform a "histological" evaluation, which means 
   * the tissue collected will be analyzed for any abnormalities. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Histology histology;
      /**
   * The result of examination of tissues under the microscope to assist diagnosis of tumors. For example, 
   * after a biopsy is performed, a pathologist will perform a "histological" evaluation, which means 
   * the tissue collected will be analyzed for any abnormalities. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Histology getHistology(){
        return histology;			
    }

	      
	               
	   

    public void setHistology(gov.nih.nci.caintegrator.domain.study.bean.Histology histology){
        this.histology = histology;
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