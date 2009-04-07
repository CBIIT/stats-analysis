

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * the area of the gene containing or adjacent to the SNP, if any. Value include: 5' UTR, 3' UTR, CDS, RNA, 
   * GENE, PSEUDO (see NCBI assembly for more information) 
   * 
   */

public  enum GeneLocation 


{
 	
	   
       /**
   * 3' Untranslated Region
   */

     _3UTR
	   
       /**
   * 5' Untranslated Region
   */

     , _5UTR
	   
       /**
   * Protein coding
   */

     , cds
	   
       /**
   * A hereditary unit consisting of a sequence of DNA that occupies a specific location on a chromosome 
   * and determines a particular characteristic in an organism. 
   * 
   */

     , gene
	   
       /**
   * These are disabled copies of functional genes that have been retained in the genome by gene duplication 
   * or retrotransposition events. Pseudogenes are important resources in understanding the evolutionary 
   * history of genes and genomes. 
   * 
   */

     , pseudo
	   
       /**
   * Ribonucleic acid (RNA)) is a nucleic acid polymer consisting of nucleotide monomers. RNA nucleotides 
   * contain ribose rings and uracil unlike deoxyribonucleic acid (DNA), which contains deoxyribose 
   * and thymine. It is transcribed from DNA by enzymes called RNA polymerases and further processed 
   * by other enzymes. RNA serves as the template for translation of genes into proteins, transferring 
   * amino acids to the ribosome to form proteins, and also translating the transcript into proteins. 
   * 
   */

     , rna;
}