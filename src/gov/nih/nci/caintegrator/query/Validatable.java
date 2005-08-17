package gov.nih.nci.caintegrator.query;

import gov.nih.nci.caintegrator.exceptions.ValidationException;
/**
 * This will be used anytime a class has some validation logic that
 * it wants to implement for itself.
 * 
 * @author BauerD
 *
 */
public interface Validatable {
	public boolean validate() throws ValidationException;
}
