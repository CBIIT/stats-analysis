

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * An enumeration of Design Element types that represents some biological material (clone, oligo, 
   * etc.) on an array which will report on some biosequence or biosequences; eg: Affymetrix probeset 
   * or cDNA clone 
   * 
   */

public  enum GeneExprReporterType 


{
 	
	   
       /**
   * cDNA clone based Design Element that represents some biological material (clone, oligo, etc.) 
   * on an array which will report on some biosequence or biosequences; 
   * 
   */

     cdna_clone_based_reporter
	   
       /**
   * A long oligo based Design Element that represents some biological material (clone, oligo, etc.) 
   * on an array which will report on some biosequence or biosequences; 
   * 
   */

     , long_oligo_based_reporter
	   
       /**
   * A probe set based Design Element that represents some biological material (clone, oligo, etc.) 
   * on an array which will report on some biosequence or biosequences; 
   * 
   */

     , probeset_based_reporter;
}