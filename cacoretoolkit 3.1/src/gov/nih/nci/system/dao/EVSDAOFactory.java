/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.dao;



import org.apache.log4j.*;

/**
 * A specific DAOFactory for EVS Datasource
 * 
 * @author caBIO Team
 * @version 1.0
 */
public class EVSDAOFactory extends DAOFactory {

	private static Logger log = Logger.getLogger(EVSDAOFactory.class.getName());

	private gov.nih.nci.system.dao.impl.externalsystem.EVSDAOImpl evsImpl;

	private gov.nih.nci.common.net.Response response;

	public EVSDAOFactory() {
		super();
		evsImpl = new gov.nih.nci.system.dao.impl.externalsystem.EVSDAOImpl();
		// hard coded
	}

	/**
	 * Returns the resultset of the query embedded in an object of
	 * gov.nih.nci.common.net.Response
	 * 
	 * @param request -
	 *            a gov.nih.nci.common.net.Request object passed from client
	 * @return an object of gov.nih.nci.common.net.Response that contains the
	 *         query resultset
	 * @throws DAOException
	 */
	public gov.nih.nci.common.net.Response query(
			gov.nih.nci.common.net.Request r) throws DAOException {
		try {
			response = evsImpl.query(r);
		} catch (DAOException e) {
			log.error(e.getMessage());
			throw new DAOException(e.getMessage());
		}

		catch (Exception e) {
			log.error(e.getMessage());
			throw new DAOException("Exception in the EVSDAOFactory "
					+ e.getMessage());
		}

		return response;
	}

}
