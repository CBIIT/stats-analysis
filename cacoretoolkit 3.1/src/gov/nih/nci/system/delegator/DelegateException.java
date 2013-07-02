/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.delegator;


 /** 
  * An exception class for Delegate related function.
  * @author caBIO Team 
  * @version 1.0
 */

public class DelegateException extends Exception {
	/**
	 * DelegateException constructor with exception message
	 * @param message
	 */
	public DelegateException(String message)
	{
		super(message);
	}
	/**
	 * DelegateException consturtor with exception message and Throwable object
	 * @param message - exception message
	 * @param t - Throwable object
	 */
	public DelegateException(String message, Throwable  t)
	{
		super(message, t);
	}
	
	/**
	 * DelegateException consturtor with Throwable object
	 * @param t - throwable object
	 */	
	public DelegateException(Throwable  t)
	{
		super(t);
	}

}
