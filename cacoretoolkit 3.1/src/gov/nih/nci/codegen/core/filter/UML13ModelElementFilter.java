/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.filter;

import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;
import gov.nih.nci.codegen.framework.Filter;
import gov.nih.nci.codegen.framework.FilteringException;

import java.util.Collection;

import uml.UmlPackage;
import org.w3c.dom.Element;
import org.apache.log4j.*;



  
/**
 * Selects all instances of org.omg.uml.foundation.core.ModelElement
 * from within an instance of uml.UmlPackage.
 * @author caBIO Team
 * @version 1.0
 */
 
 
public class UML13ModelElementFilter implements Filter, XMLConfigurable {
	
	private static Logger log = Logger.getLogger(UML13ModelElementFilter.class);

	/**
	 *  
	 */
	public UML13ModelElementFilter() {
		super();
	}

	/**
	 * Selects all instances of org.omg.uml.foundation.core.ModelElement
     * from within an instance of uml.UmlPackage.
	 * 
	 * @param modelElements       the uml.UmlPackage.
	 * @return                    the Collection of ModelElement objects.
	 * @throws FilteringException if the given Collection != 1 or
	 *                            the item in the Collection is no an instance
	 *                            of uml.UmlPackage. 
	 * @see gov.nih.nci.codegen.framework.Filter#execute(java.util.Collection)
	 */
	public Collection execute(Collection modelElements)
			throws FilteringException {
		if (modelElements.size() != 1) {
			log.error("modelElements size != 1");
			throw new FilteringException("modelElements size != 1");
		}
		Object obj = modelElements.iterator().next();
		if (!(obj instanceof UmlPackage)) {
			log.error("modelElement not instance of UmlPackage");
			throw new FilteringException(
					"modelElement not instance of UmlPackage");
		}
		UmlPackage umlExtent = (UmlPackage) obj;
		return umlExtent.getFoundation().getCore().getModelElement()
				.refAllOfType();
	}

	/**
	 * An empty implementation. All content is ignored.
	 * 
	 * @see gov.nih.nci.codegen.core.XMLConfigurable#configure(org.w3c.dom.Element)
	 */
	public void configure(Element config) throws ConfigurationException {
		
	}
}
