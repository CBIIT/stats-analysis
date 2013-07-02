/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core;

import org.w3c.dom.Element;



  
/**
 * @author caBIO Team
 * @version 1.0
 */
public interface XMLConfigurable {

	void configure(Element config) throws ConfigurationException;
	
}
