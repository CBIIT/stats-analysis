package gov.nih.nci.caintegrator.analysis.messaging;
/**
 * 
 * @author Michael A. Harris
 *
 */
public abstract class AnalysisRequest implements java.io.Serializable {

	private int sessionId; 
	private int taskId;
	private long requestStartTime = 0L;
	private long requestCompleteTime = 0L;
	private int numDoubles = 1000000;
	
	public AnalysisRequest(int sessionId, int taskId) {
	  super();
	  this.sessionId = sessionId;
	  this.taskId = taskId;
	}
	
	public int getSessionId() {
		return sessionId;
	}

	public int getTaskId() {
	   return taskId;
	}
	
	public abstract String toString();

	public long getRequestStartTime() {
		return requestStartTime;
	}

	public void setRequestStartTime(long requestStartTime) {
		this.requestStartTime = requestStartTime;
	}

	public long getRequestCompleteTime() {
		return requestCompleteTime;
	}

	public void setRequestCompleteTime(long requestEndTime) {
		this.requestCompleteTime = requestEndTime;
	}
	
	public long getElapsedTime() { return requestCompleteTime - requestStartTime; }



	public int getNumDoubles() {
		return numDoubles;
	}



	public void setNumDoubles(int numDoubles) {
		this.numDoubles = numDoubles;
	}
}
