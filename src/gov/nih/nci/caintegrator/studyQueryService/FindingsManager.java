package gov.nih.nci.caintegrator.studyQueryService;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.exceptions.FindingsQueryException;
import gov.nih.nci.caintegrator.service.task.Task;
import gov.nih.nci.caintegrator.service.task.TaskResult;

import java.util.Collection;

/**
* FindingsManager provides all methods
* necessary to control submission, retrieval 
* and status of queries and results. 
* 
*  -caIntegrator team
* */

public interface FindingsManager {

    
    /**
     * @param queryDTO
     * @return Task
     * @throws FindingsQueryException
     */
    public Task submitQuery(QueryDTO queryDTO) throws FindingsQueryException;
    
    /**
     * @param task
     * @return Task
     */
    public Task checkStatus(Task task);
    
    /**
     * @param queryDTO
     * @return Collection <Finding>
     */
    public Collection<Finding> getFindings(QueryDTO queryDTO);
    
    /**
     * @param task
     * @return Collection<Finding>
     */
    public Collection<Finding> getFindings(Task task);
    
    /**
     * @param task
     * @return TaskResult
     */
    public TaskResult getTaskResult(Task task);
}
