package gov.nih.nci.caintegrator.analysis.server;

import org.rosuda.JRclient.Rconnection;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisRequest;

public abstract class AnalysisTaskR extends AnalysisTask {

	private Rconnection rConnection;
	
	public AnalysisTaskR(AnalysisRequest request) {
		super(request);
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
		
}
