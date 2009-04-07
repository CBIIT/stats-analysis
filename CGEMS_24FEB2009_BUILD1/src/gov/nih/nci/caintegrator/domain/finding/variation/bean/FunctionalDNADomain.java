

package gov.nih.nci.caintegrator.domain.finding.variation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * FunctionalDNADomain deals with structurally and functionally defined protein region. 
   * 
   */

public  class FunctionalDNADomain 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * unique identifier for the instance of FunctionalDNADomain
   */

    private java.lang.String id;
    /**
   * unique identifier for the instance of FunctionalDNADomain
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * name of the particular 
   */

    private java.lang.String name;
    /**
   * name of the particular 
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof FunctionalDNADomain) {
				FunctionalDNADomain c =(FunctionalDNADomain)obj; 			 
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
   * The change (variation) alteration, deletion, or rearrangement - in the DNA sequence that may lead 
   * to the synthesis of an altered inactive protein the loss of the ability to produce the protein. If 
   * a mutation occurs in a germ cell, then it is a heritable change in that it can be transmitted from genera-tion 
   * to generation. Mutations may also be in somatic cells and are not heritable in the traditional sense 
   * of the word, but are transmitted to all daughter cells. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.bean.VariationFinding> variationFindingCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.bean.VariationFinding>();
      /**
   * The change (variation) alteration, deletion, or rearrangement - in the DNA sequence that may lead 
   * to the synthesis of an altered inactive protein the loss of the ability to produce the protein. If 
   * a mutation occurs in a germ cell, then it is a heritable change in that it can be transmitted from genera-tion 
   * to generation. Mutations may also be in somatic cells and are not heritable in the traditional sense 
   * of the word, but are transmitted to all daughter cells. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.bean.VariationFinding> getVariationFindingCollection(){
        return variationFindingCollection;
    }

	      
	               
	   
    public void setVariationFindingCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.bean.VariationFinding> variationFindingCollection){
        this.variationFindingCollection = variationFindingCollection;
    }
	   
	   
	

			
}