

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.common.bean.Reporter;

import java.util.Collection;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A Design Element that represents some biological material (clone, oligo, etc.) on an array which 
   * will report on some biosequence or biosequences; eg: Affymetrix probeset or cDNA clone (Note: may 
   * not be equivalent to a MAGE-OM Reporter in all cases.) 
   * 
   */

public  class GeneExprReporter extends Reporter


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;
	private Collection<GeneBiomarker> geneBiomarkerCollection;
			
			
      /**
   * Genomic Annotations associated with a  Design Element 
   */

    private Collection<GeneReporterAnnotation> geneReporterAnnotationCollection;
      /**
   * Genomic Annotations associated with a  Design Element 
   */

    public Collection<GeneReporterAnnotation> getGeneReporterAnnotationCollection(){
        return geneReporterAnnotationCollection;			
    }


    public void setGeneReporterAnnotationCollection(Collection<GeneReporterAnnotation> geneReporterAnnotation){
        this.geneReporterAnnotationCollection = geneReporterAnnotation;
    }
			
			
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public Collection<GeneBiomarker> getGeneBiomarkerCollection() {
        return geneBiomarkerCollection;
    }


    public void setGeneBiomarkerCollection(
            Collection<GeneBiomarker> geneBiomarkerCollection) {
        this.geneBiomarkerCollection = geneBiomarkerCollection;
    }
			
}