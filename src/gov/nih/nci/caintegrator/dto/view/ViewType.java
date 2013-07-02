/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.view;

import java.io.Serializable;

/**
 * @author BhattarR, BauerD
 */


/**
* 
* 
*/



public abstract class ViewType implements Serializable, Cloneable{

	/**
	 * IMPORTANT! This class requires a clone method! This requires that any new
	 * data field that is added to this class also be cloneable and be added to
	 * clone calls in the clone method.If you do not do this, you will not
	 * seperate the references of at least one data field when we generate a
	 * copy of this object.This means that if the data field ever changes in one
	 * copy or the other it will affect both instances... this will be hell to
	 * track down if you aren't ultra familiar with the code base, so add those
	 * methods now! (Not necesary for primitives.)
	 */

    abstract ViewType getViewType();
    public final static GeneSingleSampleView GENE_SINGLE_SAMPLE_VIEW = new GeneSingleSampleView();
    public final static GeneGroupSampleView GENE_GROUP_SAMPLE_VIEW = new GeneGroupSampleView();
    //public final static CopyNumberSampleView COPYNUMBER_GROUP_SAMPLE_VIEW = new CopyNumberSampleView();
    public final static CopyNumberIGV COPYNUMBER_IGV = new CopyNumberIGV();
    public final static CopyNumberSegmentView COPYNUMBER_SEGMENT_VIEW = new CopyNumberSegmentView();

    public final static CopyNumberGeneBasedSampleView COPYNUMBER_GENE_SAMPLE_VIEW = new CopyNumberGeneBasedSampleView();
    public final static ClinicalView CLINICAL_VIEW = new ClinicalView();

    public static class GeneSingleSampleView extends ViewType {
       public ViewType getViewType() {
           return GENE_SINGLE_SAMPLE_VIEW;
       }
    }
    public static class GeneGroupSampleView extends ViewType {
       public ViewType getViewType() {
           return GENE_GROUP_SAMPLE_VIEW;
       }
    }
    public static class ClinicalView extends ViewType {
       public ViewType getViewType() {
           return CLINICAL_VIEW ;
       }
    }
    //public static class CopyNumberSampleView extends ViewType {
    //    public ViewType getViewType() {
    //        return COPYNUMBER_GROUP_SAMPLE_VIEW;
    //    }
    //}
    public static class CopyNumberSegmentView extends ViewType {
        public ViewType getViewType() {
            return COPYNUMBER_SEGMENT_VIEW;
        }
    }
    public static class CopyNumberIGV extends ViewType {
        public ViewType getViewType() {
            return COPYNUMBER_IGV;
        }
    }
    public static class CopyNumberGeneBasedSampleView extends ViewType {
        public ViewType getViewType() {
            return COPYNUMBER_GENE_SAMPLE_VIEW;
        }
    }
    public Object clone() {
    	ViewType myClone = null;
		try {
			myClone = (ViewType)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return myClone;
    }
    
}
