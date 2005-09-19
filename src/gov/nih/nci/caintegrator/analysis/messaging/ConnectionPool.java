package gov.nih.nci.caintegrator.analysis.messaging;

import java.util.*;
/**
 * This class gives a basic connection pooling capability. The number of
 * available connections is fixed at the time the class is instantiated. 
 * 
 * @author Michael A. Harris
 *
 */
public abstract class ConnectionPool {

	private List inUse = new LinkedList();
	private List available = new LinkedList();
	private int numConnections;
	
	public ConnectionPool(int numConnections) {
	  this.numConnections = numConnections;  
	}
	
	public int getNumConnections() {
	  return numConnections;
	}
	
	public synchronized int getNumAvailable() {
	  return available.size();
	}
	
	public synchronized int getNumInUse() {
	  return inUse.size();
	}
	
	public synchronized Object checkOut(){
	  if (!available.isEmpty()) {
		 Object obj = available.remove(0);
	     inUse.add(obj);
	     return obj;
	  }
	  return null;
	}
	
	public synchronized void checkIn( Object o ){
		inUse.remove(o);
		if (!available.contains(o)) {
		  //if checkIn is called twice on the same object this should 
		  //prevent problems
		  available.add(o);
		}
	}
	
	
	public abstract void closeConnections();

}
