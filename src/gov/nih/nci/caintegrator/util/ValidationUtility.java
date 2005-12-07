package gov.nih.nci.caintegrator.util;

import gov.nih.nci.caintegrator.exceptions.ValidationException;

/**
 * @author sahnih
 * The ValidationUtility utility class provides various static validation methods 
 * such as check for Null, equalance to enums etc.
 * 
 */

public class ValidationUtility {
	/**
	 * if the passed object is Null and throws a ValidationException.
	 *
	 */
	public static void checkForNull(Object object) throws ValidationException{
		if(object == null)
			throw new ValidationException("Null Validation Exception");
	}

}
