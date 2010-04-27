

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * structural form of DNA comprising the sample. Possible values include GENOMIC, WGA (whole-genome 
   * amplified), MT (mitocondrial) 
   * 
   */

public  enum DNAMaterialType 


{
 	
	   
       /**
   * The study of the global properties of genomes of related organisms is usually referred to as genomics, 
   * which distinguishes it from genetics which generally studies the properties of single genes or 
   * groups of genes. 
   * 
   */

     genomic
	   
       /**
   * In cell biology, a mitochondrion (plural mitochondria) (from Greek mitos thread + khondrion granule) 
   * is an organelle, variants of which are found in most eukaryotic cells.[1] Mitochondria are sometimes 
   * described as "cellular power plants," because they convert organic materials into energy in the 
   * form of ATP via the process of oxidative phosphorylation. 
   * 
   */

     , mt
	   
       /**
   * WGA (whole-genome amplified)
   */

     , wga;
}