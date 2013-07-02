/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.util;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



/**
 * @author caBIO Team
 * @version 1.0
 */

public class XMLUtils {

	/**
	 * Creates a XMLUtils instance
	 */
	public XMLUtils() {
		super();
	}

	public static Element getChild(Element parentEl, String name) {
		Element child = null;
		List children = getChildren(parentEl, name);
		if (children.size() > 0) {
			child = (Element) children.iterator().next();
		}
		return child;
	}

	public static List getChildren(Element parentEl, String name) {
		List children = new ArrayList();
		NodeList l = parentEl.getChildNodes();
		for (int i = 0; i < l.getLength(); i++) {
			Node n = l.item(i);
			if (Node.ELEMENT_NODE == n.getNodeType()
					&& name.equals(n.getNodeName())) {
				children.add((Element) n);
			}
		}
		return children;
	}
}
