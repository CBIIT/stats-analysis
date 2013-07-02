/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.ui.graphing.data;



/**
* 
* 
*/

public class DataRange {

	private double minRange;
	private double maxRange;
	
	public DataRange(double minRange, double maxRange) {
	  this.minRange = minRange;
	  this.maxRange = maxRange;
	}

	public double getMaxRange() {
		return maxRange;
	}

	public double getMinRange() {
		return minRange;
	}
}
