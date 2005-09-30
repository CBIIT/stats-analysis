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
    private long startProcessingTime = -1L;
    
	
	
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
	
	private void setStartProcessingTime(long time) {
	  this.startProcessingTime = time;
	}
	
	private long getElapsedProcessingTime(long processingEndTime) {
	  //return processingEndTime - processingStartTime;
		return 0L;
	}
	
	public abstract String toString();
}
