package gov.nih.nci.caintegrator.service.task;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;

import java.util.Collection;

public class TaskResultImpl implements TaskResult{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;    
    private Task task;
    private long startTime;
    private long endTime;
    private long elapsedTime;
    private Collection taskResults;

    public TaskResultImpl(){
        
    }
    
    public TaskResultImpl(Task task){       
        this.task = task;
    }


    /**
     * @return Returns the taskResults.
     */
    public Collection getTaskResults() {
        return taskResults;
    }


    /**
     * @param taskResults The taskResults to set.
     */
    public void setTaskResults(
            Collection taskResults) {
        this.taskResults = taskResults;
    }


    /**
     * @return Returns the elapsedTime.
     */
    public long getElapsedTime() {
        return elapsedTime;
    }


    /**
     * @param elapsedTime The elapsedTime to set.
     */
    public void setElapsedTime(long elapsedTime) {
        this.elapsedTime = elapsedTime;
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
     * @return Returns the task.
     */
    public Task getTask() {
        return task;
    }


    /**
     * @param task The task to set.
     */
    public void setTask(Task task) {
        this.task = task;
    }
    
    

}
