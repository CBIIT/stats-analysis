/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.view;

import java.io.Serializable;

import gov.nih.nci.caintegrator.dto.de.DomainElementClass;

/**
 * @author BhattarR
 */


/**
* 
* 
*/

public class GeneExprSampleView extends View implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2715072678508825657L;
	private GroupType groupType = GroupType.DISEASE_TYPE_GROUP; //always defalut to disease
    /**
	 * @return Returns the groupType.
	 */
	public GroupType getGroupType() {
		return groupType;
	}
	/**
	 * @param groupType The groupType to set.
	 */
	public void setGroupType(GroupType groupType) {
		this.groupType = groupType;
	}
	public GeneExprSampleView() {		
	}
}
