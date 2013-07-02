/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.ui.graphing.data;

import java.io.Serializable;



/**
* 
* 
*/

public interface CachableGraphData extends Serializable{
	public void setId(String id);
	public Object getDataset();
	public String getId();
}
