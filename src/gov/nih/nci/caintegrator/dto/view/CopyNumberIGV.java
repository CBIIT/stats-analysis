/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

/*
 *  @author: SahniH
 *  Created on Nov 1, 2004
 *  @version $ Revision: 1.0 $
 * 
 */
package gov.nih.nci.caintegrator.dto.view;

import java.io.Serializable;

import gov.nih.nci.caintegrator.dto.de.DomainElementClass;

/**
 * @author SahniH
 * Date: Nov 1, 2004
 * 
 */


/**
* 
* 
*/

public class CopyNumberIGV extends View implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6424377269693876305L;
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
	public CopyNumberIGV() {

    }



}
