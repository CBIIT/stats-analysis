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
public abstract class DAOFactory {

	/**
	 * Abstract method for querying
	 * 
	 * @param request -
	 *            Request object passed from Delegator
	 * @return
	 * @throws DAOException
	 */
	public abstract Response query(Request request) throws DAOException;

	/**
	 * Return a specific DAOFactory object based on the datasource
	 * 
	 * @param whichFactory
	 * @return a specific DAOFactory object
	 * @throws DAOException
	 */
	public static DAOFactory getFactory(int whichFactory) throws DAOException {
		switch (whichFactory) {
			case gov.nih.nci.common.util.Constant.ORM_DAO:
	
				return new ORMDAOFactory();
			case gov.nih.nci.common.util.Constant.EXTERNAL_DAO:
				return new ExternalDAOFactory();
			case gov.nih.nci.common.util.Constant.EVS_DAO:
				DAOFactory evsFactory = null;
				try {
					evsFactory = (DAOFactory) Class.forName(
							gov.nih.nci.common.util.Constant.EVS_DAO_NAME)
							.newInstance();
				} catch (Exception e) {
					new DAOException("Couldnot create EVS DAO");
				}
				return evsFactory;
	
			default: {
				throw new DAOException("NO EQUIVALENT DAO FACTORY FOUND");
			}
		}
	}
}
