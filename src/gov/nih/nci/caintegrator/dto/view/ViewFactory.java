/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.view;


/**
 * @author BhattarR
 */


/**
* 
* 
*/

public class ViewFactory {
    public static View newView(ViewType viewType) {
        if (viewType instanceof ViewType.GeneSingleSampleView) {
            return new GeneExprSampleView();
        }
        else if (viewType instanceof ViewType.GeneGroupSampleView) {
            return new GeneExprDiseaseView();
        }
        else if (viewType instanceof ViewType.ClinicalView) {
            return new ClinicalSampleView();
        }
//        else if (viewType instanceof ViewType.CopyNumberSampleView) {
//            return new CopyNumberSampleView();
//        } 
        else if (viewType instanceof ViewType.CopyNumberSegmentView) {
            return new CopyNumberSegmentView();
        }
        else if (viewType instanceof ViewType.CopyNumberGeneBasedSampleView) {
            return new CopyNumberGeneBasedSampleView();
        }
        return null;
    }
}
