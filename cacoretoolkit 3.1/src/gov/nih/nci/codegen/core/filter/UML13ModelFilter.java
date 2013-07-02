/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.omg.uml.modelmanagement.Model;
import org.w3c.dom.Element;

import uml.UmlPackage;

import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;
import gov.nih.nci.codegen.core.util.XMLUtils;

import gov.nih.nci.codegen.framework.Filter;
import gov.nih.nci.codegen.framework.FilteringException;

  
/**
 * Locates a named Model within a UmlPackage.
 * @author caBIO Team
 * @version 1.0
 * @see gov.nih.nci.codegen.framework.Filter
 */

 

public class UML13ModelFilter implements Filter, XMLConfigurable {

    private static Logger log = Logger.getLogger(UML13ModelFilter.class);

    /** The name of the Model to be selected by this Filter. */
    private String _modelName;

    /**
     *  Creates an UML13ModelFilter instance
     */
    public UML13ModelFilter() {
        super();
    }

    /**
     * Navigates the given uml.UmlPackage object to find the
     * org.omg.uml.modelmanagement.Model with name stored in {@link #_modelName},
     * which is set during the call to {@link #configure(Element)}.
     * 
     * @param modelElements
     *            a Collection of size one where the sole item is an object of
     *            type uml.UmlPackage.
     * @return a Collection containing an object of type
     *         org.omg.uml.modelmanagement.Model, if found.
     * @throws FilteringException
     *             if there is an error during filtering or if the UmlPackage
     *             contains more than one Model.
     * @see gov.nih.nci.codegen.framework.Filter#execute(java.util.Collection)
     */
    public Collection execute(Collection modelElements)
            throws FilteringException {

        Model model = null;
        if (modelElements.size() != 1) {
        	log.error("modelElements size > 1");
            throw new FilteringException("modelElements size > 1");
        }
        Object obj = modelElements.iterator().next();
        if (!(obj instanceof UmlPackage)) {
        	log.error("modelElement not instance of UmlPackage");
            throw new FilteringException(
                    "modelElement not instance of UmlPackage");
        }
        log.debug("Looking for model: " + _modelName);
        UmlPackage umlExtent = (UmlPackage) obj;
        for (Iterator i = umlExtent.getModelManagement().getModel()
                .refAllOfClass().iterator(); i.hasNext();) {
            Model m = (Model) i.next();
            log.debug("Comparing with: " + m.getName());
            if (_modelName.equals(m.getName())) {
                model = m;
                break;
            }
        }

        ArrayList mes = new ArrayList();
        if (model != null) {
            mes.add(model);
        }
        return mes;
    }

    /**
     * Sets {@link #_modelName}to the name of the Model that will be selected
     * by this Filter. <P/>The content model of the filter Element is as
     * follows: <P/><code>
     * <pre>
     *   &lt;!ELEMENT filter (param)&gt;
     *   &lt;!ATTLIST filter
     *      name CDATA #REQUIRED&gt;
     *   &lt;!ELEMENT param EMPTY&gt;
     *   &lt;!ATTLIST param
     *      name CDATA #REQUIRED
     *      value CDATA #REQUIRED&gt;
     * </pre>
     * </code>
     * 
     * @param config
     *            the filter Element
     */
    public void configure(Element config) throws ConfigurationException {
        Element paramEl = XMLUtils.getChild(config, "param");
        if (paramEl == null) {
        	log.error( "A modelName param Element is required.");
            throw new ConfigurationException(
                    "A modelName param Element is required.");
        }
        if (!"modelName".equals(paramEl.getAttribute("name"))) {
        	log.error("A modelName param Element is required.");
            throw new ConfigurationException(
                    "A modelName param Element is required.");
        }
        _modelName = paramEl.getAttribute("value");
        if (_modelName == null) {
        	log.error("modelName value is null");
            throw new ConfigurationException("modelName value is null");
        }
    }

    public static void main(String[] args) {
    }
}
