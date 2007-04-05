package gov.nih.nci.caintegrator.service.findings.strategies;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.service.task.TaskResult;


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
	private QueryDTO query;
    private TaskResult taskResult;
    
    public SessionBasedFindingStrategy(){
        
    }
	
	public SessionBasedFindingStrategy(String sessionId, String taskId) {
		this.sessionId = sessionId;
		this.taskId = taskId;
	}
       
    /**
     * @return Returns the taskResult.
     */
    public TaskResult getTaskResult() {
        return taskResult;
    }

    /**
     * @param taskResult The taskResult to set.
     */
    public void setTaskResult(TaskResult taskResult) {
        this.taskResult = taskResult;
    }

    public boolean canHandle(QueryDTO query) {
        return false;
    }
    
	public String getSessionId() {
		return sessionId;
	}


	public String getTaskId() {
		return taskId;
	}


    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }


    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }


    public QueryDTO getQuery() {
        return query;
    }


    public void setQuery(QueryDTO query) {
        this.query = query;
    }


    }
