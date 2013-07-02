/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.applicationservice;

import gov.nih.nci.common.net.Response;

import gov.nih.nci.system.proxy.*;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;
import org.apache.log4j.*;


/**
 * HTTPClient provides components to connect and query a HTTP server.
 * @author caBIO Team 
 * @version 1.0
 */
public class HTTPClient {
	
	private static Logger log= Logger.getLogger(HTTPClient.class.getName());
    private String httpAddress;
    private HttpURLConnection httpConnection;

/**
	* Creates a HTTPClient instance.
*/
    public HTTPClient(){
        httpAddress = null;
        httpConnection = null;
      }

/**
	* Creates a HTTPClient instance that establishes a connection to the specified HTTP server.
	* @param serverURL - Specifies the HTTP server address
	* @throws Exception
*/
   
    public HTTPClient(String httpAddress) throws Exception{
        init(httpAddress);
        }

/**
	* Sets the specified httpAddress for this HTTPClient
	* @param serverURL - Specifies the HTTP server address
*/    
    public void setHttpAddress(String httpAddress){
           this.httpAddress = httpAddress;
           }
/**
	* Returns the httpAddress for this HTTPClient
	* @return - Returns the HTTP server address
*/
    public String getHttpAddress(){
           return httpAddress;
           }

/**
	* Creates a http connection for the specified httpAddress
	* @param serverURL - Specifies the HTTP server address
	* @throws Exception
*/
    public void init(String httpAddress) throws Exception{
       try{
       		
			this.httpAddress 	= httpAddress;
            URL url 		= new URL(httpAddress);
            httpConnection 	= (HttpURLConnection) url.openConnection();
            httpConnection.setRequestMethod("POST");
            httpConnection.setAllowUserInteraction(false);
            httpConnection.setDoOutput(true);
            httpConnection.setRequestProperty("Content-type","binary/x-java-serialized");

        }
        catch( java.net.ConnectException ex){
        	log.error("ConnectionException - "+ ex.getMessage());
        	throw new Exception(ex.getMessage());}
        catch( java.io.IOException ex){
        	log.error("IOException - "+ ex.getMessage());
        	throw new Exception(ex.getMessage());}
        catch(Exception ex){
        	String msg = null;
        	if(ex.getMessage()==null)
        		msg = "Specified http server cannot be found";
        	else
        		msg = ex.getMessage();
        	log.error("Exception - "+ msg);
        	throw new Exception("Exception " + msg);
        	}
     }

    public HttpURLConnection getConnection(){
        return httpConnection;
        }


/**
   * Sends a request to the server and receives a response
   * @param request Specifies the query that needs to be executed in a request object. 
   * @return Returns the resultset of a query in a respone object
   * @throws Exception
*/
   public gov.nih.nci.common.net.Response query(gov.nih.nci.common.net.Request request) throws Exception{
 		
   	   String exMessage = null;
	   ObjectOutputStream oos = null;
	   gov.nih.nci.common.net.Response response = new Response();
	   
        try{
            OutputStream out = httpConnection.getOutputStream();
            oos = new ObjectOutputStream(out);
            oos.writeObject(request);
        }
        catch( java.net.ConnectException ex){
        	log.error("ConnectionException - " + ex.getMessage());
        	throw new Exception(ex.getMessage());}
        catch(java.io.InvalidClassException ex){ 
        	log.error("InvalidClassException - "+ex.getMessage());
        	throw new Exception(ex.getMessage());}
        catch(Exception ex){
        	log.error("Exception - "+ ex.getMessage());
        	throw new Exception(ex.getMessage());}
        finally
		{
        	oos.flush();
            oos.close();  
		}

		try{
		      InputStream in = httpConnection.getInputStream();
		      ObjectInputStream ois = new ObjectInputStream(in);

		      response = (gov.nih.nci.common.net.Response) ois.readObject();
		      if(response.getResponse() instanceof Exception){
		          Exception e = (Exception) response.getResponse();
		          log.error(e.getMessage());
		          throw new Exception(e.getMessage());
		          }
			}
		catch(ClassNotFoundException ex){ 
			log.error("ClassNotFoundException - "+ ex.getMessage());
			throw new Exception("ClassNotFoundException: - " + ex.getMessage());}
		catch(java.io.InvalidClassException ex){ 
			log.error("InvalidClassException - "+ ex.getMessage());
			throw new Exception("InvalidClassException - "+ ex.getMessage());}
		catch(java.io.StreamCorruptedException ex){ 
			log.error("StreamCorruptedException - "+ ex.getMessage());
			throw new Exception("StreamCorruptedException - " + ex.getMessage());}
		catch(java.io.OptionalDataException  ex){ 
			log.error("OptionalDataException - "+ ex.getMessage());
			throw new Exception("OptionalDataException - " +  ex.getMessage());}
		catch(java.io.IOException  ex){ 
			log.error("IOException - "+ ex.getMessage());
			throw new Exception("IOException - " + ex.getMessage());}
		catch(Exception ex){ 
			String msg = "query failed";
			if(ex.getMessage()!=null){
				msg = msg + " - "+ex.getMessage();
			}
			log.error("Exception - "+ msg);
			throw new Exception(msg);
			}

		return response;
        }

}
