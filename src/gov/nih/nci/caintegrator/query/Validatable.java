package gov.nih.nci.caintegrator.query;

import gov.nih.nci.caintegrator.exceptions.QueryDTOValidateException;

public interface Validatable {
	public boolean validate() throws QueryDTOValidateException;

}
