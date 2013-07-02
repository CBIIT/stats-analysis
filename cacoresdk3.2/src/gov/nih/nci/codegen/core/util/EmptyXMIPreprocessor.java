/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.util;

import gov.nih.nci.codegen.framework.XMIPreprocessor;

import java.lang.String;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.jaxen.JaxenException;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import org.apache.log4j.*;




/**
 * FixEAXMI provides methods to convert the XMI produced by <I>Enterprise Architect</I> to <I>NetBean MDR XMI Reader </I>compatible format
 * @author caBIO Team
 * @version 1.0
 */
public class EmptyXMIPreprocessor implements XMIPreprocessor {

	private static Logger log = Logger.getLogger(EmptyXMIPreprocessor.class);

	/**
	 * Empty implementation of the XMIProcessor interface.
	 *
	 * @see gov.nih.nci.codegen.framework.XMIPreprocessor#fix(String xmiIn, String xmiOut)
	 *
	 * @param xmiIn The path and filename of the XMI file produced by a UML modeling tool
	 * @param xmiOut The path and filename of the fixed XMI file ready for consumption by the SDK tools
	 * @throws JDOMException
	 * @throws JaxenException
	 * @throws IOException
	 */
	public void fix(String xmiIn, String xmiOut) throws JDOMException,
			JaxenException,IOException {


		Element root;
		Element model;
		Writer writer;
		XMLOutputter xmlout;

		try {
			root = (new SAXBuilder(false)).build(new File(xmiIn))
					.getRootElement();
			model = (Element) (new JDOMXPath(
					"*[local-name()='XMI.content']/*[local-name()='Model']"))
					.selectSingleNode(root);
		} catch (IOException ioex) {
			throw new IOException("Could not open XMI file for input");
		} catch (JDOMException jdomex) {
			throw new JDOMException("Could not extract nodes from XMI file");
		} catch (JaxenException ex) {
			throw new JaxenException("Could not perform XPath query on XMI file");
		}

		// Process XMI nodes here

		try {
			writer = new OutputStreamWriter(new FileOutputStream(new File(xmiOut)), "UTF-8");
			xmlout = new XMLOutputter();
			xmlout.setFormat(Format.getPrettyFormat());
			writer.write(xmlout.outputString(root));
			writer.flush();
			writer.close();
		} catch (IOException ioex) {
			throw new IOException("Could not open XMI file for output");
		}


	}
}
