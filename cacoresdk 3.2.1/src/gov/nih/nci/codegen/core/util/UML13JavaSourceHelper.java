/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.util;

import gov.nih.nci.common.util.Constant;

import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;
import org.jaxen.JaxenException;
import org.jaxen.jdom.JDOMXPath;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.omg.uml.foundation.core.*;
import org.omg.uml.foundation.core.Classifier;
import org.omg.uml.foundation.core.Operation;
import org.omg.uml.foundation.core.Parameter;
import org.omg.uml.foundation.extensionmechanisms.TaggedValue;



/**
 * @author caBIO Team
 * @version 1.0
 */
public class UML13JavaSourceHelper {

	private static Logger log = Logger.getLogger(UML13JavaSourceHelper.class);

	/**
	 * Creates an UML13JavaSourceHelper instance
	 */
	public UML13JavaSourceHelper() {
		super();
	}

	private static String getDocumentation(Classifier klass)
	{
		TaggedValue doc = UML13Utils.getTaggedValue(klass, "documentation");
		String docStr;
		if (doc != null)
		{
			docStr = doc.getValue();
			
			for(int i=2;i<=8;i++)
			{
				TaggedValue docNext = UML13Utils.getTaggedValue(klass, "documentation"+i);
				if(docNext==null) break;
				docStr += docNext.getValue();
			}
		}
		else
		{
			doc = UML13Utils.getTaggedValue(klass, "description");
			if (doc == null) return " ";
			
			docStr = doc.getValue();
			
			for(int i=2;i<=8;i++)
			{
				TaggedValue docNext = UML13Utils.getTaggedValue(klass, "description"+i);
				if(docNext==null) break;
				docStr += docNext.getValue();
			}
		}
		
		return docStr;
	}

	private static String getDocumentation(Operation op)
	{
		TaggedValue doc = UML13Utils.getTaggedValue(op, "documentation");
		
		if (doc == null) return " ";
		String docStr = doc.getValue();
		
		for(int i=2;i<=8;i++)
		{
			TaggedValue docNext = UML13Utils.getTaggedValue(op, "documentation"+i);
			if(docNext==null) break;
			docStr += docNext.getValue();
		}
		
		return docStr;
	}	
	
	private static String getDocumentation(Parameter p)
	{
		TaggedValue doc = UML13Utils.getTaggedValue(p, "documentation");
		
		if (doc == null) return " ";
		String docStr = doc.getValue();
		
		for(int i=2;i<=8;i++)
		{
			TaggedValue docNext = UML13Utils.getTaggedValue(p, "documentation"+i);
			if(docNext==null) break;
			docStr += docNext.getValue();
		}
		
		return docStr;
	}	

	private static String getDocumentation(Attribute att)
	{
		TaggedValue doc = UML13Utils.getTaggedValue(att, "description");
		String docStr;
		if (doc != null) 
		{
			docStr = doc.getValue();
			
			for(int i=2;i<=8;i++)
			{
				TaggedValue docNext = UML13Utils.getTaggedValue(att, "description"+i);
				if(docNext==null) break;
				docStr += docNext.getValue();
			}
		}
		else
		{
			doc = UML13Utils.getTaggedValue(att, "documentation");
			if (doc == null ) return " ";
			docStr = doc.getValue();
			for(int i=2;i<=8;i++)
			{
				TaggedValue docNext = UML13Utils.getTaggedValue(att, "documentation"+i);
				if(docNext==null) break;
				docStr += docNext.getValue();
			}
		}
		return docStr;
	}
	
	
	public static String getClassJavadoc(Classifier klass) {
		StringBuffer javadocOut = new StringBuffer();
		
		TaggedValue specialdep = UML13Utils.getTaggedValue(klass,
				"deprecation1");
		
		String docStr = getDocumentation(klass);
		docStr = getLineFormattedJavadoc(docStr);
		javadocOut.append("  /**\n");
		javadocOut.append(docStr);
		javadocOut.append("\n");

		if (specialdep != null) {
			javadocOut.append("* @deprecated ");
			javadocOut.append(specialdep.getValue());
			javadocOut.append("\n");
		}
		javadocOut.append("   */\n");
		return javadocOut.toString();
	}

	/**
	 * Gets the java doc string for the specified class
	 * 
	 * @param klass
	 *            class to get java doscs
	 * @return String containing the java docs specs
	 */
	public static String getAllClassJavadoc(Classifier klass) {
		try {
			StringBuffer javadocOut = new StringBuffer();
			TaggedValue doc = UML13Utils.getTaggedValue(klass, "documentation");
			TaggedValue dep = UML13Utils.getTaggedValue(klass, "deprecation");
			TaggedValue see = UML13Utils.getTaggedValue(klass, "see");

			String docStr = getDocumentation(klass);
			docStr = getLineFormattedJavadoc(docStr);

			javadocOut.append("  /**\n");
			javadocOut.append(docStr);
			javadocOut.append("\n");
			if (dep != null) {
				javadocOut.append("* @deprecated ");
				javadocOut.append(dep.getValue());
				javadocOut.append("\n");
			}
			if (see != null) {
				javadocOut.append("* @see ");
				javadocOut.append(see.getValue());
				javadocOut.append("\n");
			}
			javadocOut.append("   */\n");

			return javadocOut.toString();
		} catch (Exception ex) {
			log.error("Exception: ", ex);
		}
		return "";
	}

	public static String getMethodJavadoc(Operation op) {
		StringBuffer javadocOut = new StringBuffer();
		TaggedValue dep = UML13Utils.getTaggedValue(op, "deprecated");
		Classifier ret = UML13Utils.getReturnType(op);

		String docStr = getDocumentation(op);
		docStr = getLineFormattedJavadoc(docStr);

		javadocOut.append("  /**\n");
		javadocOut.append(docStr);
		javadocOut.append("\n");
		if (dep != null) {
			javadocOut.append("* @deprecated ");
			javadocOut.append(dep.getValue());
			javadocOut.append("\n");
		}
		for (Iterator i = UML13Utils.getParameters(op).iterator(); i.hasNext();) {
			Parameter p = (Parameter) i.next();

			String pDocStr = getDocumentation(p);
			
			javadocOut.append("   * @param ");
			javadocOut.append(p.getName());
			javadocOut.append(Constant.SPACE);
			javadocOut.append(pDocStr);
			javadocOut.append("\n");
		}
		if (ret != null && !"void".equalsIgnoreCase(ret.getName())) {
			javadocOut.append("   * @return ");
			javadocOut.append(ret.getName());
			javadocOut.append("\n");
		}
		for (Iterator i = UML13Utils.getExceptions(op).iterator(); i.hasNext();) {
			Classifier ex = (Classifier) i.next();
			javadocOut.append("   * @throws ");
			javadocOut.append(UML13Utils.getQualifiedName(ex));
			javadocOut.append("\n");
		}
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}

	public static String getAssociationAttributeJavadoc(String associationType, boolean isCollection) {
		StringBuffer javadocOut = new StringBuffer();
		

		javadocOut.append("/**\n");
		javadocOut.append("An associated ");
		if(isCollection)
			javadocOut.append(" collection of ");
		javadocOut.append(associationType);
		javadocOut.append(" object");
		javadocOut.append("\n");
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}

	public static String getAssociationAttributeJavadocGetter(String associationName) {
		StringBuffer javadocOut = new StringBuffer();
		javadocOut.append("/**\n");
		javadocOut.append("Retreives the value of "+associationName+" attribue\n");
		javadocOut.append("   * @return ");
		javadocOut.append(associationName);
		javadocOut.append("\n");
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}
		
	public static String getAssociationAttributeJavadocSetter(String associationName) {
		StringBuffer javadocOut = new StringBuffer();

		javadocOut.append("/**\n");
		javadocOut.append("Sets the value of "+associationName+" attribue\n");
		javadocOut.append("@param ").append(associationName);
		javadocOut.append("\n");
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}	

	
	public static String getAttributeJavadoc(Attribute att) {
		StringBuffer javadocOut = new StringBuffer();
		TaggedValue dep = UML13Utils.getTaggedValue(att, "deprecated");

		String docStr = getDocumentation(att);
		docStr = getLineFormattedJavadoc(docStr);

		javadocOut.append("/**\n");
		javadocOut.append(docStr);
		javadocOut.append("\n");
		if (dep != null) {
			javadocOut.append("* @deprecated ");
			javadocOut.append(dep.getValue());
			javadocOut.append("\n");
		}
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}

	public static String getAttributeJavadocSetter(Attribute att) {
		StringBuffer javadocOut = new StringBuffer();

		String docStr = getDocumentation(att);

		javadocOut.append("/**\n");
		javadocOut.append("Sets the value of "+att.getName()+" attribue\n");
		javadocOut.append("@param ").append(att.getName());
		javadocOut.append(" ").append(docStr);
		javadocOut.append("\n");
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}	
	public static String getAttributeJavadocGetter(Attribute att) {
		StringBuffer javadocOut = new StringBuffer();

		String docStr = getDocumentation(att);

		javadocOut.append("/**\n");
		javadocOut.append("Retreives the value of "+att.getName()+" attribue\n");
		javadocOut.append("   * @return ");
		javadocOut.append(att.getName());
		javadocOut.append("\n");
		
		javadocOut.append("\n");
		javadocOut.append("   */\n");

		return javadocOut.toString();
	}
	

	/**
	 * Formats the javadoc text
	 * 
	 * @param val
	 * @return
	 */
	public static String getLineFormattedJavadoc(String val) {
		StringBuffer javadocOut = new StringBuffer();
		if (val == null) {
			//javadocOut.append("   * DOCUMENT ME!");
		} else {
			// replace newlines
			val.replace('\n', ' ');
			val.replaceAll("<", "&lt;");
			val.replaceAll(">", "&gt;");
			if (val.length() > 80) {
				javadocOut.append("   * ");
				StringBuffer line = new StringBuffer();
				int lineLength = 0;
				StringTokenizer st = new StringTokenizer(val);
				while (st.hasMoreTokens()) {
					String t = st.nextToken();
					lineLength += t.length();
					line.append(t);
					line.append(Constant.SPACE);
					if (lineLength > 80) {
						javadocOut.append(line.toString());
						javadocOut.append("\n   * ");
						line = new StringBuffer();
						lineLength = 0;
					}
				}
				if (line.length() > 0) {
					javadocOut.append(line.toString());
					javadocOut.append("\n   * ");
				}
			} else {
				javadocOut.append("   * ");
				javadocOut.append(val);
			}
		}
		return javadocOut.toString().replaceAll("@", "\n* @");
	}

	public Element selectElement(String exp, Element context) {
		Element result = null;
		try {
			JDOMXPath xpath = new JDOMXPath(exp);
			result = (Element) xpath.selectSingleNode(context);
		} catch (JaxenException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
		if (result == null) {
			log.debug("Couldn't find element for path " + exp);
			/*
			 * throw new RuntimeException("Couldn't find element for path " +
			 * exp);
			 */
		}
		return result;
	}

	public List selectElements(String exp, Element context) {

		List result = null;
		try {
			JDOMXPath xpath = new JDOMXPath(exp);
			result = xpath.selectNodes(context);

		} catch (JaxenException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return result;
	}

	public Element buildJDOMElement(String xml) {
		Element root = null;
		try {
			root = (new SAXBuilder(false)).build(new StringReader(xml))
					.getRootElement();
		} catch (Exception ex) {
			log.error("Couldn't build XML doc: ", ex);
			throw new RuntimeException("Couldn't build XML doc", ex);
		}
		return root;
	}

	public String outputString(Element e) {
		try {
			XMLOutputter p = new XMLOutputter();
			p.setFormat(Format.getPrettyFormat());
			return p.outputString(e);
		} catch (Exception ex) {
			log.error("Error outputting string: " + ex.getMessage());
			throw new RuntimeException("Error outputting string: "
					+ ex.getMessage(), ex);
		}
	}
}
