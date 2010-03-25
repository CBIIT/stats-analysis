

package gov.nih.nci.caintegrator.domain.finding.variation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * FunctionalProteinDomain deals with structurally and functionally defined protein region. In 
   * proteins with multiple domains, the combination of the domains determines the function of the protein. 
   * 
   */

public  class FunctionalProteinDomain 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * genetic code to generate protein
   */

    private java.lang.String code;
    /**
   * genetic code to generate protein
   */

	public  java.lang.String getCode(){
        return code;
    }
    public void setCode( java.lang.String code){
        this.code = code;
    }
	
	   
    /**
   * Unique indentifier for the instance of FunctionalProteinDomain
   */

    private java.lang.String id;
    /**
   * Unique indentifier for the instance of FunctionalProteinDomain
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * name of the Functional Protein Domain
   */

    private java.lang.String name;
    /**
   * name of the Functional Protein Domain
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof FunctionalProteinDomain) {
				FunctionalProteinDomain c =(FunctionalProteinDomain)obj; 			 
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