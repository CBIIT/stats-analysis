/**
 * 
 */
package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import java.util.Collections;
import java.util.List;

import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;

/**
 * @author Himanso
 *
 */
public class FaroutOutlierBoxAndWhiskerCalculator {
    /**
     * Returns the minimum outlier including farout value for an item.
     * 
     * @param row  the row index (zero-based).
     * @param column  the column index (zero-based).
     * @param bawDataset the BoxAndWhiskerCategoryDataset
     * 
     * @return The minimum outlier.
     */

    @SuppressWarnings("unchecked")
	public static Number getMinFaroutOutlier(BoxAndWhiskerCategoryDataset bawDataset, int row, int column) {

        Number minOutlier = null;
        if(bawDataset != null){
	        List yOutliers = bawDataset.getOutliers(row, column);
	        if(yOutliers != null){
	        	minOutlier = bawDataset.getMinOutlier(row, column);
		        for (int i = 0; i < yOutliers.size(); i++) {
	                double outlier = ((Number) yOutliers.get(i)).doubleValue();
	                if (outlier < minOutlier.doubleValue()) {
	                	minOutlier = outlier;
	                }
		        }
	        }
        }
        return minOutlier;

    }
    /**
     * Returns the maximum outlier including farout values for an item.
     * 
     * @param row  the row index (zero-based).
     * @param column  the column index (zero-based).
     * @param bawDataset the BoxAndWhiskerCategoryDataset
     * 
     * @return The maximum outlier.
     */
	@SuppressWarnings("unchecked")
	public static Number getMaxFaroutOutlier(BoxAndWhiskerCategoryDataset bawDataset, int row, int column) {

		Number maxOutlier = null;
        if(bawDataset != null){
	        List yOutliers = bawDataset.getOutliers(row, column);
	        if(yOutliers != null){
	        	maxOutlier = bawDataset.getMaxOutlier(row, column);
		        for (int i = 0; i < yOutliers.size(); i++) {
	                double outlier = ((Number) yOutliers.get(i)).doubleValue();
	                if (outlier > maxOutlier.doubleValue()) {
	                	maxOutlier = outlier;
	                }
		        }
	        }
        }
        return maxOutlier;

    }
}
