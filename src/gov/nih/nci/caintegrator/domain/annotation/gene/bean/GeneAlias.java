

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Alternative gene symbol to the official HUGO gene symbol
   */

public  class GeneAlias 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The gene alias name which is an alternative to the official HUGO gene symbol
   */

    private java.lang.String alias;
    /**
   * The gene alias name which is an alternative to the official HUGO gene symbol
   */

	public  java.lang.String getAlias(){
        return alias;
    }
    public void setAlias( java.lang.String alias){
        this.alias = alias;
    }
	
	   
    /**
   * A unique gene name approved by the Human Genome Organization's Nomenclature Committee. 
   * 
   */

    private java.lang.String hugoGeneSymbol;
    /**
   * A unique gene name approved by the Human Genome Organization's Nomenclature Committee. 
   * 
   */

	public  java.lang.String getHugoGeneSymbol(){
        return hugoGeneSymbol;
    }
    public void setHugoGeneSymbol( java.lang.String hugoGeneSymbol){
        this.hugoGeneSymbol = hugoGeneSymbol;
    }
	
	   
    /**
   * unique identifier for the instance of GeneAlias.
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of GeneAlias.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GeneAlias) {
				GeneAlias c =(GeneAlias)obj; 			 
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
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker geneBiomarker;
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker getGeneBiomarker(){
        return geneBiomarker;			
    }

	      
	               
	   

    public void setGeneBiomarker(gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker geneBiomarker){
        this.geneBiomarker = geneBiomarker;
    }	
	   
	   
	

			
}