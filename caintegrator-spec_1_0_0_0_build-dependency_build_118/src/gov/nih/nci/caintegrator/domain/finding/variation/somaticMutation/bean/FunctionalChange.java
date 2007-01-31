

package gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean;
import gov.nih.nci.caintegrator.domain.finding.variation.somaticMutation.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Functional change in Protein: Misssense, NoneSense, Frameset, InFrame, Splicing, Silent, Complex 
   * 
   */

public  enum FunctionalChange 


{
 	
	   
       /**
   * A complex mutation 
   */

     complex
	   
       /**
   * Frameset pertains to, or causes a type of mutation consisting of the insertion or deletion of one 
   * or more nucleotides in the nucleic acid structure of a gene, when the number of base pairs inserted 
   * or deleted is not a multiple of three. 
   * 
   */

     , frameset
	   
       /**
   * A mutation that does not cause a shift in the triplet reading frame; such mutations can, however, 
   * lead to the synthesis of an abnormal protein product 
   * 
   */

     , inFrame
	   
       /**
   * A type of mutation that results in a single amino acid change in the translated gene product 
   * 
   */

     , missense
	   
       /**
   * A type of mutation in which an mRNA stop codon is produced or removed, resulting respectively in premature 
   * termination of translation or an elongated protein product. 
   * 
   */

     , nonSense
	   
       /**
   * Silent mutations are DNA mutations that do not result in a change to the amino acid sequence of a protein. 
   * 
   */

     , silent
	   
       /**
   * Splicing is a modification of genetic information after transcription, in which introns are removed 
   * and exons are joined. 
   * 
   */

     , splicing;
}