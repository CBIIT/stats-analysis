/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

/*
 *  @author: SahniH
 *  Created on Oct 31, 2004
 *  @version $ Revision: 1.0 $
 * 
 */
package gov.nih.nci.caintegrator.dto.view;

import java.io.Serializable;

/**
 * @author Himanso
 *
 */


/**
* 
* 
*/

public interface Viewable extends Serializable,Cloneable{
	public Object clone();
}
