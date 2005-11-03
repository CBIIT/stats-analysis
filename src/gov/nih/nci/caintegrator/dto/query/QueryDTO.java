package gov.nih.nci.caintegrator.dto.query;

import java.io.Serializable;

import gov.nih.nci.caintegrator.query.Validatable;

public interface QueryDTO extends Serializable, Cloneable {
	public void setQueryName(String name);
	public String getQueryName();
}
