/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.dao;


/**
  * An exception class for DAO related functions
  * @author caBIO Team 
  * @version 1.0 
 */

public class DAOException extends Exception {

/**
 * DAOException consturtor with exception message
 * @param message - exception message
 */	
	public DAOException(String message)
	{
		super(message);
	}
/**
 * DAOException consturtor with exception message and Throwable object
 * @param message - exception message
 * @param t - Throwable object
 */
	public DAOException(String message, Throwable  t)
	{
		super(message, t);
	}

/**
 * DAOException consturtor with Throwable object
 * @param t - throwable object
 */	
	public DAOException(Throwable  t)
	{
		super(t);
	}

}
