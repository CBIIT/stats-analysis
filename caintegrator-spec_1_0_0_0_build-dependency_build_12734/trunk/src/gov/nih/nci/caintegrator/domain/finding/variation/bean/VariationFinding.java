

package gov.nih.nci.caintegrator.domain.finding.variation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The change (variation) alteration, deletion, or rearrangement - in the DNA sequence that may lead 
   * to the synthesis of an altered inactive protein the loss of the ability to produce the protein. If 
   * a mutation occurs in a germ cell, then it is a heritable change in that it can be transmitted from genera-tion 
   * to generation. Mutations may also be in somatic cells and are not heritable in the traditional sense 
   * of the word, but are transmitted to all daughter cells. 
   * 
   */

public  abstract class VariationFinding 
    extends gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


	
	   
	   
	   
	      
      /**
   * FunctionalProteinDomain deals with structurally and functionally defined protein region. In 
   * proteins with multiple domains, the combination of the domains determines the function of the protein. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalProteinDomain> functionalProteinDomainCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalProteinDomain>();
      /**
   * FunctionalProteinDomain deals with structurally and functionally defined protein region. In 
   * proteins with multiple domains, the combination of the domains determines the function of the protein. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalProteinDomain> getFunctionalProteinDomainCollection(){
        return functionalProteinDomainCollection;
    }

	      
	               
	   
    public void setFunctionalProteinDomainCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalProteinDomain> functionalProteinDomainCollection){
        this.functionalProteinDomainCollection = functionalProteinDomainCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * FunctionalDNADomain deals with structurally and functionally defined protein region. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalDNADomain> funtionalDNADomainCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalDNADomain>();
      /**
   * FunctionalDNADomain deals with structurally and functionally defined protein region. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalDNADomain> getFuntionalDNADomainCollection(){
        return funtionalDNADomainCollection;
    }

	      
	               
	   
    public void setFuntionalDNADomainCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.bean.FunctionalDNADomain> funtionalDNADomainCollection){
        this.funtionalDNADomainCollection = funtionalDNADomainCollection;
    }
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * Variation reporter is a design element which is used to report change (variation) - alteration, 
   * deletion, or rearrangement - in the DNA sequence . 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter variationReporter;
      /**
   * Variation reporter is a design element which is used to report change (variation) - alteration, 
   * deletion, or rearrangement - in the DNA sequence . 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter getVariationReporter(){
        return variationReporter;			
    }

	      
	               
	   

    public void setVariationReporter(gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter variationReporter){
        this.variationReporter = variationReporter;
    }	
	   
	   
	

			
}