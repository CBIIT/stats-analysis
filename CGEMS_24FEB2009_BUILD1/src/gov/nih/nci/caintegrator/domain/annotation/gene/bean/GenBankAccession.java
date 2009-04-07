

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The accession number is the unique identifier assigned to the entire sequence record when the record 
   * is submitted to GenBank. 
   * 
   */

public  class GenBankAccession 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
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
   * unique identifier for the instance of GenBankAccession
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of GenBankAccession
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The GenBank accession number is a combination of letters and numbers that are usually in the format 
   * of one letter followed by five digits (e.g., M12345) or two letters followed by six digits (e.g., 
   * AC123456). 
   * 
   */

    private java.lang.String number;
    /**
   * The GenBank accession number is a combination of letters and numbers that are usually in the format 
   * of one letter followed by five digits (e.g., M12345) or two letters followed by six digits (e.g., 
   * AC123456). 
   * 
   */

	public  java.lang.String getNumber(){
        return number;
    }
    public void setNumber( java.lang.String number){
        this.number = number;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GenBankAccession) {
				GenBankAccession c =(GenBankAccession)obj; 			 
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

    private Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker> geneBiomarker = new HashSet<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker>();
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker> getGeneBiomarker(){
        return geneBiomarker;
    }

	      
	               
	   
    public void setGeneBiomarker(Set<gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker> geneBiomarker){
        this.geneBiomarker = geneBiomarker;
    }
	   
	   
	

			
}