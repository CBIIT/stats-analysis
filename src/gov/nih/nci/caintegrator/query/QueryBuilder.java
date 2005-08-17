package gov.nih.nci.caintegrator.query;

import gov.nih.nci.caintegrator.ui.dto.QueryDTO;
import gov.nih.nci.caintegrator.ui.dto.QueryParametersDTO;

public interface QueryBuilder {
	public QueryDTO  createQueryDTO(QueryParametersDTO parameters);
}
