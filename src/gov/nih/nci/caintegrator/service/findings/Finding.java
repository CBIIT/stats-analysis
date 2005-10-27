package gov.nih.nci.caintegrator.service.findings;

public abstract class Finding {
	private enum FindingStatus {EXCEPTION,EXECUTING,COMPLETED};
	/**
	 * This should be called something other than sessionId
	 * in my oppionion since it may not always be associates
	 * with a partiucalar session, rather it may be tied to 
	 * a heretofor undefined client
	 */
	private String sessionId;
	private String taskId;
	private FindingStatus status;
	
	abstract public String getSessionId();
	abstract public String getTaskId();
	abstract public FindingStatus getStatus();
	abstract public void setStatus(FindingStatus status);

}
