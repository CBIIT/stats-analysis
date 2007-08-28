package gov.nih.nci.caintegrator.service.task;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.service.findings.Finding;

import java.util.Collection;

import org.apache.log4j.Logger;

public class TaskResultImpl implements TaskResult{
    /**
     * 
     */
    private static Logger logger = Logger.getLogger(TaskResultImpl.class);
    private static final long serialVersionUID = 1L;    
    private Task task;    
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
