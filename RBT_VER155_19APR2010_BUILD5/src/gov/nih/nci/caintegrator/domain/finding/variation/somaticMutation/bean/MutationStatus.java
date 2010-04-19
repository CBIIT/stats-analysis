

package gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Indication of mutation status such as WILDTYPE, MUTATION
   */

public  enum MutationStatus 


{
 	
	   
       /**
   * Changes to the genetic material (usually DNA or RNA).
   */

     mutation
	   
       /**
   * a wild type is one of the major genotypes of a species that occur in nature by evolution, in contrast 
   * to induced mutations or artificial cross-breeding. Wild type is also used for single genes (wild 
   * type alleles) (as opposed to induced mutant alleles). 
   * 
   */

     , wildtype;
}