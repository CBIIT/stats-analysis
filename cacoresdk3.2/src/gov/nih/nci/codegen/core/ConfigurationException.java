/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core;


  
/**
 * @author caBIO Team
 * @version 1.0
 */
public class ConfigurationException extends Exception {

	/**
	 * Creates a ConfigurationException instance
	 */
	public ConfigurationException() {
		super();
		
	}

	/**
	 * @param arg0
	 */
	public ConfigurationException(String arg0) {
		super(arg0);
		
	}

	/**
	 * @param arg0
	 */
	public ConfigurationException(Throwable arg0) {
		super(arg0);
		
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public ConfigurationException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}
}
