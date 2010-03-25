package gov.nih.nci.caintegrator.service.findings.strategies;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.service.task.Task;
import gov.nih.nci.caintegrator.service.task.TaskResult;


/**
 * Abstract finding strategy for strategies that need to keep track 
 * of session and task information.
 * 
 * @author harrismic
 *
 */
public abstract class SessionBasedFindingStrategy implements FindingStrategy {

	protected String sessionId;
	protected String taskId;
	protected QueryDTO query;
    protected TaskResult taskResult;
    
    public SessionBasedFindingStrategy(){
        
    }
	
	public SessionBasedFindingStrategy(String sessionId, String taskId) {
		this.sessionId = sessionId;
		this.taskId = taskId;
	}
       
    
    public TaskResult retrieveTaskResult(Task task){
        return null;
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
