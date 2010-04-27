

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * technology platform that the assays on the panel are based upon. Values such as Infinium, GoldenGate, 
   * SNPlex, TaqMan, etc 
   * 
   */

public  enum PlatformTechnology 


{
 	
	   
       /**
   * The GoldenGate assay is a technology that is based on primer extension coupled with oligoligation 
   * and hybridisation to beads on fibre optic arrays. 
   * 
   */

     goldenGate
	   
       /**
   * The Infinium assay is a novel protocol that enables infinite multiplexing and genome-wide SNP access. 
   * This assay utilizes a modified allele-specific primer extension method with enzymatic SNP scoring 
   * to uniformly amplify SNPs across the genome. 
   * 
   */

     , infinium
	   
       /**
   * The SNPlex™ Genotyping System enables the simultaneous genotyping of up to 48 SNPs (single nucleotide 
   * polymorphisms) against a single biological sample. 
   * 
   */

     , sNPlex
	   
       /**
   * Taqman SNP analysis utilizes the 5' exonuclease activity of DNA Taq polymerase and the quenching 
   * effects of specific florescent dyes to determine the relative frequency of each allele within an 
   * individual genome. Primers are designed against a conserved region of the genome flanking the locus 
   * of interest. Two probes are designed across the locus of interest, one for each allele. Each probe 
   * is labeled with a different reporter dye as well as a quencher molecule. Proximity to the quencher 
   * dye inhibits the florescence of the reporter molecule. During thermocycling, the probe anneals 
   * to the locus of interest in an allele specific manner. As the Taq DNA polymerase extends the primers, 
   * it also degrades the annealed probe, allowing the florescent dye to come out of the sphere of influence 
   * of the quencher and thus become detectable. 
   * 
   */

     , taqMan;
}