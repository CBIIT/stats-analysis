package gov.nih.nci.caintegrator.analysis.server;

import java.util.Iterator;

import org.rosuda.JRclient.REXP;
import org.rosuda.JRclient.RSrvException;
import org.rosuda.JRclient.Rconnection;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisRequest;
import gov.nih.nci.caintegrator.analysis.messaging.IdGroup;

public abstract class AnalysisTaskR extends AnalysisTask {

	private Rconnection rConnection;
	private boolean debugRcommands = false;
	
	public AnalysisTaskR(AnalysisRequest request) {
		super(request);
	}
	
	public AnalysisTaskR(AnalysisRequest request, boolean debugRcommands) {
	   super(request);
	   this.debugRcommands = debugRcommands;
	}

	/**
	 * The run method implemented in each of the subclasses will
	 * call getRconnection() to get a connection to the Rserve and 
	 * perform the computation.
	 */
	public abstract void run();
	
	public void setRconnection(Rconnection connection) {
		  this.rConnection = connection;
    }
		
    public Rconnection getRconnection() { return rConnection; }

	public boolean getDebugRcommands() {
		return debugRcommands;
	}

	public void setDebugRcommands(boolean debugRcommands) {
		this.debugRcommands = debugRcommands;
	}
	
	/**
   * Evaluate an R command with no return value
   * @param c
   * @param command
   */
   protected void doRvoidEval(String command) {
	  if (debugRcommands) {
	    System.out.println(command);
	  }
	  try {
		rConnection.voidEval(command);
	  } 
	  catch (RSrvException e) {
		e.printStackTrace(System.out);
	  }
   }
	  
  /**
   * Execute an R command with a return value
   * @param c
   * @param command
   * @return
   */
   protected REXP doREval(String command) {
	  REXP returnVal = null;
	  try {
			if (debugRcommands) {
			  System.out.println(command);
			}
			returnVal = rConnection.eval(command);
	  } 
	  catch (RSrvException e) {
	    e.printStackTrace(System.out);
	  }
      return returnVal;
   }	
   
   /**
   * This method will take a SampleGroup and generate the R command for 
   * to create the sampleId list. The returned lists can then be used as input 
   * parameters to the statistical methods (for example ttest).
   * @param group
   * @return
   */
	public static String getRgroupCmd(String rName, IdGroup group) {
		 StringBuffer sb = new StringBuffer();
		 sb.append(rName);
		 sb.append(" <- c(");
		 String id;
		 for (Iterator i=group.iterator(); i.hasNext(); ) {
		  id = (String) i.next();
		  sb.append("\"").append(id).append("\"");
		  if (i.hasNext()) {
		    sb.append(",");	    	 
		  }
		  else {
		    sb.append(")");
		  }
		}
		return sb.toString();
	}
}
