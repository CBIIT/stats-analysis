package gov.nih.nci.caintegrator.dto.query;

import java.io.Serializable;

import gov.nih.nci.caintegrator.query.Validatable;

public interface QueryDTO extends Validatable,Serializable, Cloneable {
	void setQueryName(String name);
	String getQueryName();

}
