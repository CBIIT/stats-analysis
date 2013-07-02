/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.dao.impl.externalsystem;



import java.util.*;
import gov.nih.nci.system.dao.DAOException;

import gov.nih.nci.common.net.*;

import org.apache.log4j.*;

/**
 * Data Access Object Implementation for external datasource 
 * @author caBIO Team 
 * @version 1.0
 */
public class ExternalDAOImpl
{
	private static Logger log = Logger.getLogger(ExternalDAOImpl.class.getName());

    private String httpAddress;
    /**
     * Default Constructor
     *
     */
	public ExternalDAOImpl()
	{
	}


	/**
	 * Return the resultset of the query embedded in an object of gov.nih.nci.common.net.Response
	 * @param request - a gov.nih.nci.common.net.Request object passed from client 
	 * @return an object of gov.nih.nci.common.net.Response that contains the query resultset
	 * @throws DAOException
	 */    
	public Response query(gov.nih.nci.common.net.Request request) throws DAOException, Exception
	{
		gov.nih.nci.common.net.Response response;
	
	      try
            {
			
			Hashtable configs = request.getConfig();

			if (configs!=null)
			{
				this.httpAddress= (String)configs.get("server");
			}else
			{
				log.error("No server URL found");
				throw new Exception("NO SERVER URL FOUND");
			}


        	}
        	catch( Exception e1)
		{
        		log.error("Problem getting external server URL");
			throw new Exception("PROBLEM WHILE GETTING EXTERNAL SERVER URL");
		}

	    try
	    {
		gov.nih.nci.system.applicationservice.HTTPClient client = new gov.nih.nci.system.applicationservice.HTTPClient(httpAddress);
		response = (Response)client.query(request);
	    }
          catch(Exception ex)
	    {
          	log.error(ex.getMessage());
            throw new Exception("Exception: " + ex.getMessage());
          }
          return response;
	}
}
