

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.common.bean.Reporter;

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

			
			
      /**
   * Genomic Annotations associated with a  Design Element 
   */

    private gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneReporterAnnotation geneReporterAnnotation;
      /**
   * Genomic Annotations associated with a  Design Element 
   */

    public gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneReporterAnnotation getGeneReporterAnnotation(){
        return geneReporterAnnotation;			
    }


    public void setGeneReporterAnnotation(gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneReporterAnnotation geneReporterAnnotation){
        this.geneReporterAnnotation = geneReporterAnnotation;
    }
			
			
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker geneBioMarker;
      /**
   * A GeneBiomarker is a gene based biological parameter that is indicative of a physiological or pathological 
   * state. For example, EBBR2 is a biomarker used to identify risk of breast cancer. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker getGeneBioMarker(){
        return geneBioMarker;			
    }

	      
	               
	   

    public void setGeneBioMarker(gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker geneBioMarker){
        this.geneBioMarker = geneBioMarker;
    }
			
}