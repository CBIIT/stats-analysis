/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jmi.reflect.RefObject;

import org.w3c.dom.Element;

import gov.nih.nci.codegen.core.BaseArtifact;
import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;
import gov.nih.nci.codegen.core.transformer.template.JETTemplate;
import gov.nih.nci.codegen.core.util.XMLUtils;
import gov.nih.nci.codegen.framework.Artifact;
import gov.nih.nci.codegen.framework.TransformationException;
import gov.nih.nci.codegen.framework.Transformer;

import org.apache.log4j.*;



  
/**
 * Used to generate artifacts using Java Emitter Templates, which is a component
 * of the Eclipse Modeling Framework. Detailed information about JET and EMF are
 * available in the Eclipse help contents and at the following URLs:
 * <p>
 * <ul>
 * <li>JET: http://www-106.ibm.com/developerworks/opensource/library/os-ecemf2/
 * </li>
 * <li>EMF: http://www.eclipse.org/emf/</li>
 * </ul>
 * <p>
 * The configuration element of the JETTransformer has the following content
 * model:
 * <p>
 * <code>
 * <pre>
 * 
 *  
 *   &lt;!ELEMENT transformer (param+)&gt; 
 *   &lt;!ATTLIST transformer 
 *      name CDATA #REQUIRED
 *      className CDATA #FIXED gov.nih.nci.codegen.core.transformer.JETTransformer&gt;
 *   &lt;!ELEMENT param EMPTY&gt; 
 *   &lt;!ATTLIST param 
 *      name CDATA #REQUIRED 
 *      value CDATA #REQUIRED&gt;
 *   
 *  
 * </pre>
 * </code>
 * <p>
 * JETTransformer expects two param elements with name attribute values of
 * "templateClassName" and "helperClassName". The former is required and the
 * latter is optional.
 * 
 * The value of the value attribute of the templateClassName param element must
 * be the class name of the class that is the JET template that will be doing
 * the transformation.
 * 
 * The value of the value attribute of the helperClassName param element is the
 * class name of some object that will be made available to the executing JET
 * template.
 * 
 * The class named by the templateClassName param element must implement
 * {@link gov.nih.nci.codegen.core.transformer.template.JETTemplate}. That
 * interfaces defines one method:
 * <p>
 * &nbsp;&nbsp;java.lang.String execute(java.util.Map context)
 * <p>
 * This method returns a String that is the result of the transformation. This
 * String is set as the value of the target attribute of the single Artifact
 * object in the Collection returned by JETTransformer's execute method.
 * <p>
 * The context parameter is populated by JETTransformer with the following
 * key-value pairs:
 * <ul>
 * <li>artifacts - Collection of artifacts produced by the previous
 * transformation</li>
 * <li>modelElement - RefObject supplied to JETTransformer's execute method
 * </li>
 * <li>helper - Object named by helperClassName param element</li>
 * </ul>
 * <p>
 * Those familiar with JET will know that the when the JSP-like JET file is
 * translated to the Java class file (which is the actual template), all the
 * functionality is placed inside of a method named "generate", not "execute".
 * <p>
 * Therefore, JET files used by JETTransformer must reference a skeleton that
 * contains at least the following:
 * <p>
 * <code>
 * <pre>
 * public class CLASS implements JETTemplate {
 * 
 *     public String execute(Map context) {
 *         return generate(context);
 *     }
 * 
 *     public String generate(Map context) {
 *         return &quot;&quot;;
 *     }
 * }
 * </pre>
 * </code>
 * <p>
 * Of course, any additional code could be placed before the generate method.
 * 
 * Since JET files are translated into Java class files that (by default) have
 * no dependencies on the Eclipse platform, existing (pre-translated) JET
 * templates do not require Eclipse in order to be used by this AGT. However, to
 * create or modify JET files, one must have access to Eclipse and EMF. See the
 * User's Guide for information on the available JET translation options.
 * 
 * @author caBIO Team
 * @version 1.0
 */
public class JETTransformer implements Transformer, XMLConfigurable {
	
	private static Logger log = Logger.getLogger(JETTransformer.class);

    JETTemplate _template;

    Object _helper;

    Map _params = new HashMap();

    /**
     *  
     */
    public JETTransformer() {
        super();
    }

    /*
     * @see gov.nih.nci.codegen.framework.Transformer#execute(javax.jmi.reflect.RefObject,
     *      java.util.Collection)
     */
    public Collection execute(RefObject modelElement, Collection artifacts)
            throws TransformationException {
        Collection newArtifacts = new ArrayList();
        HashMap context = new HashMap();
        context.putAll(_params);
        context.put("artifacts", artifacts);
        context.put("modelElement", modelElement);
        context.put("helper", _helper);
        String javaSource = _template.execute(context);
        Artifact a = new BaseArtifact("javaSource", modelElement, javaSource);
        newArtifacts.add(a);
        return newArtifacts;
    }

    /** 
     * @see gov.nih.nci.codegen.core.XMLConfigurable#configure(org.w3c.dom.Element)
     */
    public void configure(Element config) throws ConfigurationException {

        String templClassName = getParameter(config, "templateClassName");
        try {
            _template = (JETTemplate) Class.forName(templClassName)
                    .newInstance();
        } catch (Exception ex) {
        	log.error("Error initializing "
                    + templClassName + " : " + ex.getMessage());
            throw new ConfigurationException("Error initializing "
                    + templClassName, ex);
        }
        String helperClassName = getParameter(config, "helperClassName");
        if (helperClassName != null) {
            try {
                _helper = Class.forName(helperClassName).newInstance();
            } catch (Exception ex) {
            	log.error("Error initializing "
                        + helperClassName + " : " + ex.getMessage() );
                throw new ConfigurationException("Error initializing "
                        + helperClassName, ex);
            }
        }
        for (Iterator i = XMLUtils.getChildren(config, "param").iterator(); i
                .hasNext();) {
            Element paramEl = (Element) i.next();
            String name = paramEl.getAttribute("name");
            if (!(name.equals("modelElement") && name.equals("artifacts") && name
                    .equals("helper"))) {
                _params.put(paramEl.getAttribute("name"), paramEl
                        .getAttribute("value"));
            }
        }

    }

    private String getParameter(org.w3c.dom.Element config, String paramName) {
        String param = null;

        List params = XMLUtils.getChildren(config, "param");
        for (Iterator i = params.iterator(); i.hasNext();) {
            Element paramEl = (Element) i.next();
            if (paramName.equals(paramEl.getAttribute("name"))) {
                param = paramEl.getAttribute("value");
                break;
            }
        }

        return param;
    }
}
