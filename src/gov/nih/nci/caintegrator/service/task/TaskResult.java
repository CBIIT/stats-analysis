
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
    /**
     * @return Returns the elapsedTime.
     */
    public long getElapsedTime();

    /**
     * @return Returns the endTime.
     */
    public long getEndTime();
    /**
     * @param endTime The endTime to set.
     */
    public void setEndTime(long endTime);
   
    /**
     * @return Returns the startTime.
     */
    public long getStartTime();
    /**
     * @param startTime The startTime to set.
     */
    public void setStartTime(long startTime);
   
    /**
     * @return Returns the domainFindings.
     */
    public Collection<? extends gov.nih.nci.caintegrator.domain.finding.bean.Finding> getDomainFindings();

    /**
     * @param domainFindings The domainFindings to set.
     */
    public void setDomainFindings(
            Collection<? extends gov.nih.nci.caintegrator.domain.finding.bean.Finding> domainFindings);
 
}
