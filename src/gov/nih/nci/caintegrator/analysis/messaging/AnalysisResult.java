package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;

/**
 * 
 * @author Michael A. Harris
 *
 */

public abstract class AnalysisResult implements Serializable {

	private String sessionId;
	private String taskId;
	
	private String processorHost = "";
	
	
	public AnalysisResult(String sessionId, String taskId) {
	  this.sessionId = sessionId;
	  this.taskId = taskId;
	}
	
	public String getSessionId() {
		return sessionId;
	}

	public String getTaskId() {
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
