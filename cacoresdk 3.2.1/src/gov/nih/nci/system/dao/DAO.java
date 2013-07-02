/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.dao;

import gov.nih.nci.common.net.*;



/**
 * DAOFactory provides methods to identify a datasource
 * 
 * @author caBIO Team
 * @version 1.0
 */
public interface DAO {

	/**
	 * Abstract method for querying
	 * 
	 * @param request -
	 *            Request object passed from Delegator
	 * @return
	 * @throws DAOException
	 */
	public Response query(Request request) throws DAOException, Exception;

}
