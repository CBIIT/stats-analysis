package gov.nih.nci.caintegrator.service.findings;

import java.io.Serializable;

import gov.nih.nci.caintegrator.enumeration.FindingStatus;
import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.dto.query.QueryDTO;
/***
 * This class is abstract so that it will not be instantiated directly.  It is
 * intended to be a SuperClass for the Findings objects of substance.
 * @author SahniH, BauerD
 *
 */
public abstract class Finding implements Serializable{
	private long startTime;
	private long endTime;
	private long elapsedTime;
	private QueryDTO queryDTO;
	private String sessionId;
	private String taskId;
	private FindingStatus status;
	private AnalysisResult analysisResult;
	/**
	 * @return Returns the elapsedTime.
	 */
	public long getElapsedTime() {
		return elapsedTime;
	}

	/**
	 * @return Returns the endTime.
	 */
	public long getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime The endTime to set.
	 */
	public void setEndTime(long endTime) {
		this.endTime = endTime;
		this.elapsedTime = this.startTime-this.endTime;
	}
	/**
	 * @return Returns the queryDTO.
	 */
	public QueryDTO getQueryDTO() {
		return queryDTO;
	}
	/**
	 * @param queryDTO The queryDTO to set.
	 */
	public void setQueryDTO(QueryDTO queryDTO) {
		this.queryDTO = queryDTO;
	}
	/**
	 * @return Returns the sessionId.
	 */
	public String getSessionId() {
		return sessionId;
	}
	/**
	 * @param sessionId The sessionId to set.
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	/**
	 * @return Returns the startTime.
	 */
	public long getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime The startTime to set.
	 */
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return Returns the status.
	 */
	public FindingStatus getStatus() {
		return status;
	}
	/**
	 * @param status The status to set.
	 */
	public void setStatus(FindingStatus status) {
		this.status = status;
	}
	/**
	 * @return Returns the taskId.
	 */
	public String getTaskId() {
		return taskId;
	}
	/**
	 * @param taskId The taskId to set.
	 */
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	
	
	
	
	
}
