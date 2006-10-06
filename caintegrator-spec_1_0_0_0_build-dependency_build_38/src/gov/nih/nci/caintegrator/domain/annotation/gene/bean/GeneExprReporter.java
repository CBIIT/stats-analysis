

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A Design Element that represents some biological material (clone, oligo, etc.) on an array which 
   * will report on some biosequence or biosequences; eg: Affymetrix probeset or cDNA clone (Note: may 
   * not be equivalent to a MAGE-OM Reporter in all cases.) 
   * 
   */

public  class GeneExprReporter 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * unique identifier
   */

    private java.lang.String id;
    /**
   * unique identifier
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * Identifier for the reporter: eg: Affymetrix probeset ID, Image clone ID
   */

    private java.lang.String name;
    /**
   * Identifier for the reporter: eg: Affymetrix probeset ID, Image clone ID
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	
	   
    /**
   * An enumeration of Design Element types that represents some biological material (clone, oligo, 
   * etc.) on an array which will report on some biosequence or biosequences; eg: Affymetrix probeset 
   * or cDNA clone 
   * 
   */

    private java.lang.String type;
    /**
   * An enumeration of Design Element types that represents some biological material (clone, oligo, 
   * etc.) on an array which will report on some biosequence or biosequences; eg: Affymetrix probeset 
   * or cDNA clone 
   * 
   */

	public  java.lang.String getType(){
        return type;
    }
    public void setType( java.lang.String type){
        this.type = type;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GeneExprReporter) {
				GeneExprReporter c =(GeneExprReporter)obj; 			 
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
   * Genomic Annotations associated with a  Design Element 
   */

    private gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneReporterAnnotation geneReporterAnnotation;
      /**
   * Genomic Annotations associated with a  Design Element 
   */

    public gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneReporterAnnotation getGeneReporterAnnotation(){
        return geneReporterAnnotation;			
    }

	      
	               
	   

    public void setGeneReporterAnnotation(gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneReporterAnnotation geneReporterAnnotation){
        this.geneReporterAnnotation = geneReporterAnnotation;
    }	
	   
	   
	
	   
	   
	   
	      
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker geneBioMarker;
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker getGeneBioMarker(){
        return geneBioMarker;			
    }

	      
	               
	   

    public void setGeneBioMarker(gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker geneBioMarker){
        this.geneBioMarker = geneBioMarker;
    }	
	   
	   
	
	   
	   
	   
	      
	   
	
	   
	   
	   
	      
	   
	

			
}