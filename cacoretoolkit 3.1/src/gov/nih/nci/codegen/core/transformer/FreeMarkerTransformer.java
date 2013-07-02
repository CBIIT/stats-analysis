/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.transformer;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.jmi.reflect.RefObject;

import org.w3c.dom.Element;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import gov.nih.nci.codegen.core.BaseArtifact;
import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;
import gov.nih.nci.codegen.core.util.XMLUtils;

import gov.nih.nci.codegen.framework.Artifact;
import gov.nih.nci.codegen.framework.TransformationException;
import gov.nih.nci.codegen.framework.Transformer;

import org.apache.log4j.*;



  
/**
 * This transformer is used to generate artifacts using the <A
 * HREF="http://freemarker.sourceforge.net/">FreeMarker </A> template language.
 * <P/>
 * The {@link #execute(javax.jmi.reflect.RefObject,java.util.Collection)} method
 * returns a Collection of exactly one
 * {@link gov.nih.nci.codegen.core.BaseArtifact} object, whose name attribute is
 * set to "javaSource".
 * <P/>
 * See the {@link #configure(org.w3c.dom.Element)} method for configuration
 * info.
 * @author caBIO Team
 * @version 1.0
 */ 
 
public class FreeMarkerTransformer implements Transformer, XMLConfigurable {

	private static Logger log = Logger.getLogger(FreeMarkerTransformer.class);
	
    private String _templateName, _templateDir;

    private Map _ctxObjs = new HashMap();

    private String _modelElementRefName;

    /**
     * Creates a instance of FreeMarkerTransformer 
     */
    public FreeMarkerTransformer() {
        super();
    }

    /** @see gov.nih.nci.codegen.framework.Transformer#execute(javax.jmi.reflect.RefObject,
     *      java.util.Collection)
     */
    public Collection execute(RefObject modelElement, Collection artifacts)
            throws TransformationException {
        Collection newArtifacts = new ArrayList();
        String javaSource = null;
        try {
            Configuration cfg = Configuration.getDefaultConfiguration();
            cfg.setDirectoryForTemplateLoading(new File(_templateDir));
            cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
            Template t = cfg.getTemplate(_templateName);
            Map ctx = new HashMap();
            ctx.put(_modelElementRefName, modelElement);
            ctx.put("artifacts", artifacts);
            for (Iterator i = _ctxObjs.keySet().iterator(); i.hasNext();) {
                String refName = (String) i.next();
                Object obj = _ctxObjs.get(refName);
                ctx.put(refName, obj);
            }
            String input = null;
            if (artifacts.size() > 0) {
                Artifact inputArt = (Artifact) artifacts.iterator().next();
                input = (String) inputArt.getTarget();
                ctx.put("input", input);
            }
            StringWriter w = new StringWriter();
            t.process(ctx, w);
            javaSource = w.getBuffer().toString();
        } catch (Exception ex) {
        	log.error("Error transforming - " + ex.getMessage());
            throw new TransformationException("Error transforming", ex);
        }
        Artifact a = new BaseArtifact("javaSource", modelElement, javaSource);
        newArtifacts.add(a);
        return newArtifacts;
    }

    /**
     * The configuration Element for this transformer specifies a number of
     * parameters and objects that affect the behavior of template execution.
     * <P/>parameters: <P/>These are name value pairs that are put into the
     * template's context. The parameter elements are defined as follows: <P/>
     * <code>
     * <pre>
     * 
     *  &lt;!ELEMENT param EMPTY&gt;
     *  &lt;!ATTLIST param
     *     name CDATA #REQUIRED
     *     value CDATA #REQUIRED&gt;
     *  
     * </pre>
     * </code> <P/>The value of the param elements value attribute is put into
     * the context as a string accessible through a reference with a name that
     * is the value of the param elements name attribute. <P/>There are three
     * special parameters: <P/>
     * <UL>
     * <LI>modelElementRefName: the value of this parameter becomes reference
     * to the modelElement; it defaults to "modelElement".</LI>
     * <LI>templateDir: the relative name of the directory that will contain
     * template files.</LI>
     * <LI>templateName: the name of the template file within the templateDir.
     * </LI>
     * </UL>
     * <P/>objects: <P/>These are arbitrary Java objects that will put into
     * the template context. The object element is defined as follows: <P/>
     * <code>
     * <pre>
     * 
     *  &lt;!ELEMENT object EMPTY&gt;
     *  &lt;!ATTLIST object
     *     name CDATA #REQUIRED
     *     value CDATA #REQUIRED&gt;
     *  
     * </pre>
     * </code> 
     * <P/>The value of the object element's value attribute is the class
     * name of the object that should be put into the template context. The
     * value of the name attribute is the name of the reference to this object.
     * <P/>Two other references are automaticaly put into the template's
     * context: artifacts and input. The artifacts reference is the collection
     * of artifacts returned by the previous transformer. The input reference is
     * the java.lang.String retrieve by casting the java.lang.Object returned by
     * calling the getTarget method of the first Artifact in the list of
     * Artifact objects returned by the previous transformer.
     */
    public void configure(Element config) throws ConfigurationException {

        _modelElementRefName = getParameter(config, "modelElementRefName");
        if (_modelElementRefName == null) {
            _modelElementRefName = "modelElement";
        }
        _templateDir = getParameter(config, "templateDir");
        _templateName = getParameter(config, "templateName");
        File f = new File(_templateDir + "/" + _templateName);
        if (!f.exists()) {
        	log.error("Can't find " + _templateDir + "/"
                    + _templateName);
            throw new ConfigurationException("Can't find " + _templateDir + "/"
                    + _templateName);
        }

   

        for (Iterator i = XMLUtils.getChildren(config, "object").iterator(); i
                .hasNext();) {
            Element objEl = (Element) i.next();
            String refName = objEl.getAttribute("refName");
            String className = objEl.getAttribute("className");
            Object obj = null;
            try {
                obj = Class.forName(className).newInstance();
            } catch (Exception ex) {
            	log.error( "Error instantiating context object " + className + ": "+ex.getMessage() );
                throw new ConfigurationException(
                        "Error instantiating context object " + className, ex);
            }
            _ctxObjs.put(refName, obj);
        }

      
        for (Iterator i = XMLUtils.getChildren(config, "param").iterator(); i
                .hasNext();) {
            Element paramEl = (Element) i.next();
            String paramName = paramEl.getAttribute("name");
            String paramValue = paramEl.getAttribute("value");
            _ctxObjs.put(paramName, paramValue);
        }
    }

    private String getParameter(Element config, String paramName) {
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
