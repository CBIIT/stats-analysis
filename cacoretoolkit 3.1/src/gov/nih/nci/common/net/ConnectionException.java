/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.common.net;



/** 
 * Exception class for connection related functions <br><br>
 * @author caBIO Team
 * @version 1.0
 */

public class ConnectionException extends Exception {

    /**
	 * ConnectionException with exception message
	 * @param message
	 */
	public ConnectionException(String message)
	{
		super(message);
	}

	
	/**
	 * ConnectionException with exception message and throwable object
	 * @param message
	 * @param t
	 */
	public ConnectionException(String message, Throwable  t)
	{
		super(message, t);
	}

	public ConnectionException(Throwable  t)
	{
		super(t);
	}

}
