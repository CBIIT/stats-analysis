package gov.nih.nci.caintegrator.service.findings.strategies;

import gov.nih.nci.caintegrator.service.findings.strategies.FindingStrategy;


/**
 * Abstract finding strategy for strategies that need to keep track 
 * of session and task information.
 * 
 * @author harrismic
 *
 */
public abstract class SessionBasedFindingStrategy implements FindingStrategy {

	private String sessionId;
	private String taskId;
	
	
	public SessionBasedFindingStrategy(String sessionId, String taskId) {
		this.sessionId = sessionId;
		this.taskId = taskId;
	}


	public String getSessionId() {
		return sessionId;
	}


	public String getTaskId() {
		return taskId;
	}

}
