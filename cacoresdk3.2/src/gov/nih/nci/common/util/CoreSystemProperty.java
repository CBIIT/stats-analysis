/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.common.util;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * Assigns CORESystem.properties to constants that can be used throughout the application
 * @author caCORE SDK Team 
 * @version 1.0
 */
public class CoreSystemProperty {
	
	private static Logger log = Logger.getLogger(CoreSystemProperty.class.getName());
	
	private static Properties _properties = new Properties();
	static {
		// load properties
		try{
			
			_properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("CORESystem.properties"));

		}catch(IOException e)
		{
			log.error("IOException ", e);
		}
		catch(Exception ex){
			log.error("Exception ", ex);			
		}
	}
	
	public static boolean DEBUG_STACKTRACE = Boolean.valueOf((String)_properties.getProperty("DEBUG_STACKTRACE")).booleanValue();
	
}
