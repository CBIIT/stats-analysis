/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

import java.io.IOException;
import org.jaxen.JaxenException;
import org.jdom.JDOMException;





/**
 * Converts an XMI file produced by a UML modeling tool into a valid MDR file
 * @author caCORE SDK Team
 * @version 1.0
 */

public interface XMIPreprocessor {

	/**
	 * Modifies a copy of the XMI file named by xmiIn and writes this copy to the file named by xmiOut.
	 *
	 * @param xmiIn The full path and file name of an XMI file produced by a UML modeling tool
	 * @param xmiOut The full path and file name of the valid MDR XMI file to be written
	 * @throws JDOMException
	 * @throws JaxenException
	 * @throws IOException
	 */
	public void fix(String xmiIn, String xmiOut) throws JDOMException,
			JaxenException, IOException;



}
