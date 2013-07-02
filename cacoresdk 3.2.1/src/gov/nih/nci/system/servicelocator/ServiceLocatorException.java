/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.servicelocator;


/**
 * Exception class for ServiceLocator related functions
 * @author caBIO Team 
 * @version 1.0
 */
public class ServiceLocatorException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Creates a ServiceLocatedException instance
	 * @param message
	 */
	public ServiceLocatorException()
	{
		super();
	}
	
	/**
	 * Creates a ServiceLocatedException instance with exception message
	 * @param message
	 */
	public ServiceLocatorException (String message)
	{
		super(message);
	}

	/**
	 * Creates ServiceLocatedException instance with exception message and throwable object
	 * @param message Exception message
	 * @param t 	  Throwable object
	 */	
	public ServiceLocatorException (String message, Throwable  t)
	{
		super(message, t);
	}

	/**
	 * Create ServiceLocatedException instance with a throwable object
	 * @param t 	Throwable object
	 */
	
	public ServiceLocatorException (Throwable  t)
	{
		super(t);
	}
}
