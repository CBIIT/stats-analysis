package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;

/**
 * 
 * @author Michael A. Harris
 *
 */

public abstract class AnalysisResult implements Serializable {

	private int sessionId;
	private int taskId;
	
	private String processorHost = "";
	
	
	public AnalysisResult(int sessionId, int taskId) {
	  this.sessionId = sessionId;
	  this.taskId = taskId;
	}
	
	public int getSessionId() {
		return sessionId;
	}

	public int getTaskId() {
		return taskId;
	}
	
	public String getProcessorHost() {
		return processorHost;
	}

	public void setProcessorHost(String processorHost) {
		this.processorHost = processorHost;
	}
	
	public abstract String toString();
}
