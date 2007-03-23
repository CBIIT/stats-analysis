

package gov.nih.nci.caintegrator.domain.annotation.snp.bean;
import gov.nih.nci.caintegrator.domain.common.bean.Reporter;

import java.util.Collection;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Variation reporter is a design element which is used to report change (variation) - alteration, 
   * deletion, or rearrangement - in the DNA sequence . 
   * 
   */

public  class VariationReporter  extends Reporter


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;

	private SNPAnnotation snpAnnotation;
    private Collection copyNumberFindingCollection;

    public Collection getCopyNumberFindingCollection() {
        return copyNumberFindingCollection;
    }

    public void setCopyNumberFindingCollection(
            Collection copyNumberFindingCollection) {
        this.copyNumberFindingCollection = copyNumberFindingCollection;
    }

    public SNPAnnotation getSnpAnnotation() {
        return snpAnnotation;
    }

    public void setSnpAnnotation(SNPAnnotation snpAnnotation) {
        this.snpAnnotation = snpAnnotation;
    }
    
    
}