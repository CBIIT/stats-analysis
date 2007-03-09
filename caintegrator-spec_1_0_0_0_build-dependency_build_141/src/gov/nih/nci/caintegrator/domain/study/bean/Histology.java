

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The result of examination of tissues under the microscope to assist diagnosis of tumors. For example, 
   * after a biopsy is performed, a pathologist will perform a "histological" evaluation, which means 
   * the tissue collected will be analyzed for any abnormalities. 
   * 
   */

public  class Histology 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Comments made for the diagnosis such as tiny area, fragments.
   */

    private java.lang.String comment;
    /**
   * Comments made for the diagnosis such as tiny area, fragments.
   */

	public  java.lang.String getComment(){
        return comment;
    }
    public void setComment( java.lang.String comment){
        this.comment = comment;
    }
	
	   
    /**
   * The name of the specimen diagnosis.
   */

    private java.lang.String diagnosisName;
    /**
   * The name of the specimen diagnosis.
   */

	public  java.lang.String getDiagnosisName(){
        return diagnosisName;
    }
    public void setDiagnosisName( java.lang.String diagnosisName){
        this.diagnosisName = diagnosisName;
    }
	
	   
    /**
   * Tumor grade is a system used to classify cancer cells in terms of how abnormal they look under a microscope 
   * and how quickly the tumor is likely to grow and spread. Many factors are considered when determining 
   * tumor grade, including the structure and growth pattern of the cells. The specific factors used 
   * to determine tumor grade vary with each type of cancer. Histologic grade, also called differentiation, 
   * refers to how much the tumor cells resemble normal cells of the same tissue type. 
   * 
   */

    private java.lang.String grade;
    /**
   * Tumor grade is a system used to classify cancer cells in terms of how abnormal they look under a microscope 
   * and how quickly the tumor is likely to grow and spread. Many factors are considered when determining 
   * tumor grade, including the structure and growth pattern of the cells. The specific factors used 
   * to determine tumor grade vary with each type of cancer. Histologic grade, also called differentiation, 
   * refers to how much the tumor cells resemble normal cells of the same tissue type. 
   * 
   */

	public  java.lang.String getGrade(){
        return grade;
    }
    public void setGrade( java.lang.String grade){
        this.grade = grade;
    }
	
	   
    /**
   * Unique identifier for the instance of Histology.
   */

    private java.lang.Long id;
    /**
   * Unique identifier for the instance of Histology.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * indication of tumor type, values include benign, invasive, dcis, lcis, nme,nms.
   */

    private java.lang.String invasivePresentation;
    /**
   * indication of tumor type, values include benign, invasive, dcis, lcis, nme,nms.
   */

	public  java.lang.String getInvasivePresentation(){
        return invasivePresentation;
    }
    public void setInvasivePresentation( java.lang.String invasivePresentation){
        this.invasivePresentation = invasivePresentation;
    }
	
	   
    /**
   * Cancer stage refers to the extent or severity of the cancer, based on factors such as the location 
   * of the primary tumor, tumor size, number of tumors, and lymph node involvement (spread of cancer 
   * into lymph nodes). 
   * 
   */

    private java.lang.String stage;
    /**
   * Cancer stage refers to the extent or severity of the cancer, based on factors such as the location 
   * of the primary tumor, tumor size, number of tumors, and lymph node involvement (spread of cancer 
   * into lymph nodes). 
   * 
   */

	public  java.lang.String getStage(){
        return stage;
    }
    public void setStage( java.lang.String stage){
        this.stage = stage;
    }
	
	   
    /**
   * Sub Class of Disease such as Astcytoma or GBM
   */

    private java.lang.String type;
    /**
   * Sub Class of Disease such as Astcytoma or GBM
   */

	public  java.lang.String getType(){
        return type;
    }
    public void setType( java.lang.String type){
        this.type = type;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Histology) {
				Histology c =(Histology)obj; 			 
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

	
	   
	   
	   
	      
	   
	

			
}