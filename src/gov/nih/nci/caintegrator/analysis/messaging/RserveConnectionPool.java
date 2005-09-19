package gov.nih.nci.caintegrator.analysis.messaging;

import org.rosuda.JRclient.*;

/**
 * This class provides a pool of connections to an Rserve instance.
 * 
 * @author Michael A. Harris
 *
 */
public class RserveConnectionPool extends ConnectionPool {

	private String serverIp;
	private String dataFileName;
	
	public RserveConnectionPool(int numConnections, String serverIp, String dataFileName) {
		super(numConnections);
		this.serverIp = serverIp;
		this.dataFileName = dataFileName;
		initializeConnections();
	}
	
	/**
	 * 
	 *
	 */
	private void initializeConnections() {
	  Rconnection connection = null;
	  
	  try {
		  for (int i=0; i < getNumConnections(); i++) {
			connection = new Rconnection(serverIp);
			initializeConnection(connection);
			checkIn(connection);
		  }
		  System.out.println("RserveConnectionPool (initialization complete). numAvailableConnections=" + getNumAvailable());
	  }
	  catch (RSrvException ex) {
	    ex.printStackTrace(System.out);
	  }
	
	}
	
	 public void initializeConnection(Rconnection c) {
	    //load the test matrix and function definitions 
		 try {
			    String rCmd; 
				//System.out.println("Server vesion: "+c.getServerVersion());
				long start, elapsedtime;
				if (c.needLogin()) { // if server requires authentication, send one
					  System.out.println("authentication required.");
					  c.login("guest","guest");
				}
  				    
			    //System.out.println("\tInitializing the Rserver with data and functions");
			 
			    start = System.currentTimeMillis();
			    
			    rCmd = "source(\"" + dataFileName + "\")";
			    c.voidEval(rCmd);
			    elapsedtime = System.currentTimeMillis() - start;
			    System.out.println("\tDone initializing Rserver connection elapsedTime=" + elapsedtime);   
				} catch(RSrvException rse) {
				    System.out.println("Rserve exception: "+rse.getMessage());
				} catch(Exception e) {
				    System.out.println("Something went wrong, but it's not the Rserve: "+e.getMessage()); e.printStackTrace();
				}
	 }

	public void closeConnections() {
	  Rconnection connection = null;
	  while (connection != null) {
        connection = (Rconnection) checkOut();
        connection.close();
	  }
	}
	
	

}
