

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A form of treatment or intervention activity experienced by a subject on a study as specified by the 
   * protocol. Surgeries, Biopsies and Radiation Therapy represent types of Procedures. 
   * 
   */

public  class Procedure 
    extends gov.nih.nci.caintegrator.domain.study.bean.Activity


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Name of site(s) within the body targeted for procedures or interventions; multiple contiguous 
   * sites within the same organ system may be referenced. 
   * 
   */

    private String targetSiteCode;
    /**
   * Name of site(s) within the body targeted for procedures or interventions; multiple contiguous 
   * sites within the same organ system may be referenced. 
   * 
   */

	public String getTargetSiteCode(){
        return targetSiteCode;
    }
    public void setTargetSiteCode(String targetSiteCode){
        this.targetSiteCode = targetSiteCode;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String procedureType;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getProcedureType(){
        return procedureType;
    }
    public void setProcedureType( java.lang.String procedureType){
        this.procedureType = procedureType;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String procedureName;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getProcedureName(){
        return procedureName;
    }
    public void setProcedureName( java.lang.String procedureName){
        this.procedureName = procedureName;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Procedure) {
				Procedure c =(Procedure)obj; 			 
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