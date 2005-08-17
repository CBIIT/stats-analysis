package gov.nih.nci.caintegrator.query;

import gov.nih.nci.caintegrator.ui.dtos.QueryDTO;
import gov.nih.nci.caintegrator.ui.dtos.QueryParametersDTO;

public interface QueryBuilder {
	public QueryDTO  createQueryDTO(QueryParametersDTO parameters);
}
