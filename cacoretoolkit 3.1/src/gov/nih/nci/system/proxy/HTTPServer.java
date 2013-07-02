/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.proxy;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import gov.nih.nci.system.delegator.*;
import org.apache.log4j.*;




 /**
  * HTTP Tunneling Servlet
  * @author caBIO Team
  * @version 1.0
  */
public class HTTPServer extends HttpServlet
{
	private static Logger log = Logger.getLogger(HTTPServer.class.getName());
	/**
	 * Called by the server (via the service method) to allow a servlet to handle a GET request.
	 * @param request - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param response - an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws java.io.IOException - if an input or output error is detected when the servlet handles the GET request
	 *         ServletException - if the request for the GET could not be handled
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException
    {
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD><TITLE>Welcome</TITLE></HEAD><BODY>");
        out.println("<H1>Welcome to the HTTP Proxy. The Server has been deployed. call doPost to send request!</H1>");
        out.println("</body></html>");
    }

	/**
	 * Called by the server (via the service method) to allow a servlet to handle a POST request.
	 * @param request - an HttpServletRequest object that contains the request the client has made of the servlet
	 * @param response - an HttpServletResponse object that contains the response the servlet sends to the client
	 * @throws java.io.IOException - if an input or output error is detected when the servlet handles the POST request
	 *         ServletException - if the request for the POST could not be handled
	 */
    public void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        //Read Client Request
        gov.nih.nci.common.net.Request clientRequest = null;
        try
        {
            java.io.InputStream is = request.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);
            clientRequest = (gov.nih.nci.common.net.Request)ois.readObject();
        }
        catch( OptionalDataException ex)
        {
        	log.error(ex.getMessage());
        }
        catch(ClassNotFoundException ex)
        {
        	log.error(ex.getMessage());
        }
        catch(IOException ex)
        {
        	log.error(ex.getMessage());
        }
        catch(Exception ex)
        {
        	log.error("Exception in HTTPServer reading the response \n" + ex.getMessage());
			throw new ServletException("Exception in HTTPServer reading the response "+ex);
        }

	    //Set content type of the Stream as we are sending Objects
        response.setContentType("binary/x-java-serialized");
        java.io.OutputStream os = response.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);

	   //Write it back to the stream
        try
        {
 		    oos.writeObject(query(clientRequest));
        }
        catch( InvalidClassException ex)
        {
        	log.error(ex.getMessage());
        }
        catch(NotSerializableException  ex)
        {
        	log.error(ex.getMessage());
        }
        catch(IOException ex)
        {
        	log.error(ex.getMessage());
        }
        catch(Exception ex)
        {
        	log.error(ex.getMessage());
        }
        finally
		{
        	oos.flush();
        	oos.close();
		}
    }

    /**
     * Return the resultset of the query embedded in an object of gov.nih.nci.common.net.Response
     * @param clientRequest - a gov.nih.nci.common.net.Request object passed from client
     * @return an object of gov.nih.nci.common.net.Response that contains the query resultset
     */

    public gov.nih.nci.common.net.Response query(gov.nih.nci.common.net.Request clientRequest)
    {
    	//Response
    	gov.nih.nci.common.net.Response clientResponse = new gov.nih.nci.common.net.Response();;
        //Delegate
     	BaseDelegate delegate = null;

        try
        {
        	delegate = new BaseDelegate();
        	clientResponse = delegate.query(clientRequest);
        }

        catch(DelegateException de)
        {
	       	de.printStackTrace();
  			clientResponse.setResponse(de);
  			log.error(de.getMessage());
        }
        catch(Exception ex)
        {
  			ex.printStackTrace();
  			clientResponse.setResponse(ex);
  			log.error(ex.getMessage());
        }
        return clientResponse;
    }

    /**
     * Return Servlet Information
     * @return servlet name
     */
    public String getServletInfo()
    {
        return "HTTPServlet";
    }
}
