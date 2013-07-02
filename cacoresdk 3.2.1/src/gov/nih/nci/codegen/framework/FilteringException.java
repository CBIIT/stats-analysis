/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

  
/**
 * @author caBIO Team
 * @version 1.0
 */

public class FilteringException extends Exception {

	/**
	 * Creates an instance of FilteringException
	 */
	public FilteringException() {
		super();
		}

	/**
	 * @param arg0
	 */
	public FilteringException(String arg0) {
		super(arg0);	
	}

	/**
	 * @param arg0
	 */
	public FilteringException(Throwable arg0) {
		super(arg0);
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public FilteringException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}
}
