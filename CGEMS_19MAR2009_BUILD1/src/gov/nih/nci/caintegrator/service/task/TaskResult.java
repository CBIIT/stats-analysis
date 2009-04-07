
package gov.nih.nci.caintegrator.service.task;

import java.io.Serializable;
import java.util.Collection;

/**
 * TaskResult objects contain all information relating to a query and its
 * corresponding domain findings.
 * @author rossok
 *
 */
public interface TaskResult extends Serializable{
    
    public Task getTask();
    
    public void setTask(Task task);
    
    public Collection getTaskResults();

    /**
     * @param taskResults The taskResults to set.
     */
    public void setTaskResults(Collection taskResults);
 
}
