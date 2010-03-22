

package gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * indication of mutation types such as Point, Deletion, Insertion, Complex
   */

public  enum MutationType 


{
 	
	   
       /**
   * A complex mutation 
   */

     complex
	   
       /**
   * one or more nucleotides are deleted into a sequence.
   */

     , deletion
	   
       /**
   * one or more nucleotides are inserted into a sequence.
   */

     , insertion
	   
       /**
   * A type of mutation that causes the replacement of a single base nucleotide with another nucleotide. 
   * 
   */

     , point;
}