/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.delegator;

import gov.nih.nci.system.dao.*;
import gov.nih.nci.system.servicelocator.*;
import gov.nih.nci.system.proxy.InterfaceProxy;
import gov.nih.nci.common.net.*;
import org.apache.log4j.*;


 
 /**
  * BaseDelegate encapsulates the query for different datasources  
  * @author caBIO Team 
  * @version 1.0
  */
public class BaseDelegate implements InterfaceProxy
{

	private static Logger log = Logger.getLogger(BaseDelegate.class.getName());
	public ServiceLocator locator;

	/**
	 * Return the resultset of the query embedded in an object of gov.nih.nci.common.net.Response
	 * @param request - a gov.nih.nci.common.net.Request object passed from client 
	 * @return an object of gov.nih.nci.common.net.Response that contains the query resultset
	 * @throws DelegateException
	 */    
	 
	public Response query(gov.nih.nci.common.net.Request request) throws DelegateException, Exception
	{
		
		DAOFactory factory = null;

		String dataSource ;
		String domainObjectName = request.getDomainObjectName();
		locator = new ServiceLocator();
		Response response;
		try{
			request.setConfig(locator.getDataSourceCollection(domainObjectName));
			dataSource =locator.getDataSourceCollectionValue(locator.getDataSourceCollection(domainObjectName), "DataSource");
		
		}
		catch(ServiceLocatorException slEx)
		{
			log.error("No data source found");
			throw new DelegateException(" No data source was found " + slEx.getMessage());
		}
		catch(Exception exception)
		{
			log.error("Exception while getting datasource information "+ exception.getMessage());
			throw new Exception("Exception in Base Delegate while getting datasource information: " + exception);
		}

		if (dataSource == null)
		{
			log.error("No Data Source could be found for the specified domain object");
			throw new DelegateException("No Data Source could be found for the specified domain object");
		}
		try
		{
		
			if (dataSource.indexOf("ORM") != -1)
			{
				factory =DAOFactory.getFactory(gov.nih.nci.common.util.Constant.ORM_DAO);
			}
			else if (dataSource.equalsIgnoreCase("EVS"))
			{
				factory = DAOFactory.getFactory(gov.nih.nci.common.util.Constant.EVS_DAO);		
			}
			else {
				factory = DAOFactory.getFactory(gov.nih.nci.common.util.Constant.EXTERNAL_DAO);
				}
			
			response = factory.query(request);
		}
		catch(DAOException daoException)
		{
			log.error(daoException.getMessage());
			throw new Exception(daoException.getMessage());
		}
		catch(Exception exception)
		{
			log.error(exception.getMessage());
			throw new Exception("Exception in the Base Delegate:  "+exception.getMessage());
		}

		return response;
	}
}

// $Log: not supported by cvs2svn $
// Revision 1.1  2006/08/04 15:26:17  guruswas
// modified caCORE toolkit to support
// 1. Generation of Pojos
// 2. Support for Java15 Enums
// 3. Abstract classes
// 4. Support for marker/tagged interfaces
//
// Revision 1.11  2005/07/15 16:27:58  muhsins
// logging information added
//
// Revision 1.10  2005/07/15 15:22:36  muhsins
// logging information added
//
// Revision 1.9  2005/07/12 15:53:53  muhsins
// Loggin statements added
//
// Revision 1.8  2005/05/11 20:30:11  muhsins
// Added InterfaceProxy interface
//
// Revision 1.7  2005/05/06 21:35:28  shanbhak
// Added cvs log at the end
//