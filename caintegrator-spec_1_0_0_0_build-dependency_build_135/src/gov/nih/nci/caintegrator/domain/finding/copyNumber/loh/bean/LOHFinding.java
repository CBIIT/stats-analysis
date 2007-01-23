

package gov.nih.nci.caintegrator.domain.finding.copyNumber.loh.bean;
import gov.nih.nci.caintegrator.domain.finding.copyNumber.loh.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Loss of Heterozygosity (LOH) data for one reporter in a hybridization
   */

public  class LOHFinding 
    extends gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * array design identifier, given by the manufactures of the array: eg: U133plus2.0 by Affy manufactures, 
   * values include CDNAARRAY, HGU133P2, HM100KSNPArray. 
   * 
   */

    private java.lang.String arrayType;
    /**
   * array design identifier, given by the manufactures of the array: eg: U133plus2.0 by Affy manufactures, 
   * values include CDNAARRAY, HGU133P2, HM100KSNPArray. 
   * 
   */

	public  java.lang.String getArrayType(){
        return arrayType;
    }
    public void setArrayType( java.lang.String arrayType){
        this.arrayType = arrayType;
    }
	
	   
    /**
   * Probability of LOH at a particular genomic locus
   */

    private java.lang.Float lossOfHeterozygosityScore;
    /**
   * Probability of LOH at a particular genomic locus
   */

	public  java.lang.Float getLossOfHeterozygosityScore(){
        return lossOfHeterozygosityScore;
    }
    public void setLossOfHeterozygosityScore( java.lang.Float lossOfHeterozygosityScore){
        this.lossOfHeterozygosityScore = lossOfHeterozygosityScore;
    }
	
	   
    /**
   * confidence value for the LOH score
   */

    private java.lang.Float pValue;
    /**
   * confidence value for the LOH score
   */

	public  java.lang.Float getPValue(){
        return pValue;
    }
    public void setPValue( java.lang.Float pValue){
        this.pValue = pValue;
    }
	
	   
    /**
   * Normal alleles at a genomic locus; eg: AA, AB, BB
   */

    private java.lang.String referenceAllele;
    /**
   * Normal alleles at a genomic locus; eg: AA, AB, BB
   */

	public  java.lang.String getReferenceAllele(){
        return referenceAllele;
    }
    public void setReferenceAllele( java.lang.String referenceAllele){
        this.referenceAllele = referenceAllele;
    }
	
	   
    /**
   * Alleles in the tumor sample. eg: AA, AB, BB
   */

    private java.lang.String sampleAllele;
    /**
   * Alleles in the tumor sample. eg: AA, AB, BB
   */

	public  java.lang.String getSampleAllele(){
        return sampleAllele;
    }
    public void setSampleAllele( java.lang.String sampleAllele){
        this.sampleAllele = sampleAllele;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof LOHFinding) {
				LOHFinding c =(LOHFinding)obj; 			 
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

	
	   
	   
	   
	      
			
			
			
			
      /**
   * Variation reporter is a design element which is used to report change (variation) - alteration, 
   * deletion, or rearrangement - in the DNA sequence . 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.variation.bean.SNPProbeSetReporter variationReporter;
      /**
   * Variation reporter is a design element which is used to report change (variation) - alteration, 
   * deletion, or rearrangement - in the DNA sequence . 
   * 
   */

    public gov.nih.nci.caintegrator.domain.finding.variation.bean.SNPProbeSetReporter getVariationReporter(){
        return variationReporter;			
    }

	      
	               
	   

    public void setVariationReporter(gov.nih.nci.caintegrator.domain.finding.variation.bean.SNPProbeSetReporter variationReporter){
        this.variationReporter = variationReporter;
    }	
	   
	   
	

			
}