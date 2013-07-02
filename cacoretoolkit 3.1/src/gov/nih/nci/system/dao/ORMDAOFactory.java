/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.dao;

import gov.nih.nci.system.dao.impl.orm.*;
import gov.nih.nci.common.net.*;
import org.apache.log4j.*;



/**
  * A specific DAOFactory for External Datasource
  * @author caBIO Team 
  * @version 1.0
 */
public class ORMDAOFactory extends DAOFactory {
	
		private static Logger log = Logger.getLogger(ORMDAOFactory.class);
		private gov.nih.nci.system.dao.impl.orm.ORMDAOImpl ormImpl;
		/**
		 * Default Constructor
		 *
		 */
		public ORMDAOFactory()
		{
			super();
			ormImpl = new ORMDAOImpl();
			//hard coded
		}
		
		/**
		 * Return the resultset of the query embedded in an object of gov.nih.nci.common.net.Response
		 * @param request - a gov.nih.nci.common.net.Request object passed from client 
		 * @return an object of gov.nih.nci.common.net.Response that contains the query resultset
		 * @throws DAOException
		 */    
	    public Response query(Request request) throws DAOException
		{
	    	Response response;
			try
			{
				response = ormImpl.query(request);
			}
			catch (DAOException e)
			{
				log.error(e.getMessage());
				throw new DAOException(e.getMessage());
			}

			catch (Exception e)
			{
				log.error(e.getMessage());
				throw new DAOException("Exception in the ORMDAOFactory "+e);
			}

		return response;
		}
}
