package gov.nih.nci.caintegrator.ui.validation;

import gov.nih.nci.caintegrator.ui.dtos.QueryDTO;

public interface ValidatorsFactory {
	//This needs to be thought out a bit more
	public Object retrieveQueryDTOValidator(QueryDTO query);
}
