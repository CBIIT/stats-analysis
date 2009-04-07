

package gov.nih.nci.caintegrator.domain.annotation.protein.bean;
import gov.nih.nci.caintegrator.domain.annotation.protein.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Protein Alternative Name Identifier
   */

public  class ProteinAlias 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Protein Alternative Name Identifier
   */

    private java.lang.String alias;
    /**
   * Protein Alternative Name Identifier
   */

	public  java.lang.String getAlias(){
        return alias;
    }
    public void setAlias( java.lang.String alias){
        this.alias = alias;
    }
	
	   
    /**
   * unique identifier for the instance of ProteinAlias.
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of ProteinAlias.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof ProteinAlias) {
				ProteinAlias c =(ProteinAlias)obj; 			 
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
   * A ProteinBiomarker is a protein or antibody based biological parameter that is indicative of a physiological 
   * or pathological state. For example, HER2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker proteinBiomarker;
      /**
   * A ProteinBiomarker is a protein or antibody based biological parameter that is indicative of a physiological 
   * or pathological state. For example, HER2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker getProteinBiomarker(){
        return proteinBiomarker;			
    }

	      
	               
	   

    public void setProteinBiomarker(gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker proteinBiomarker){
        this.proteinBiomarker = proteinBiomarker;
    }	
	   
	   
	

			
}