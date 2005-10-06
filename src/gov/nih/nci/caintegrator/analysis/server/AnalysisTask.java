package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.*;
import org.rosuda.JRclient.Rconnection;

public abstract class AnalysisTask implements Runnable {

	private AnalysisRequest request;
	
	public AnalysisTask(AnalysisRequest request) {
	  this.request = request;
	}
	
	/**
	 * The run method is responsible for doing the work and
	 * for creating the appropriate AnalysisResult object
	 */
	public abstract void run();

	public abstract AnalysisResult getResult(); 
	
	public AnalysisRequest getRequest() { return request; }
}
