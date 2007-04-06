package gov.nih.nci.caintegrator.studyQueryService;


import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.dto.query.QueryDTO;

import java.util.List;

/**
 * This is the QueryHandler interface.  It allows you to pass
 * in a generic QueryDTO and retreive a list of Finding objects
 * depending upon which QueryHandler is used.
 * 
 *
 * @author caIntegrator Team
 */
public interface QueryHandler {


    public List getResults(QueryDTO dto, Integer page);

    public Integer getResultCount(QueryDTO query);

    public List getResults(QueryDTO query);
    
    public boolean canHandle(QueryDTO query);
}
