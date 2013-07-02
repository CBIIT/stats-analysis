/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.transformer;

import gov.nih.nci.codegen.core.BaseArtifact;
import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;
import gov.nih.nci.codegen.core.filter.UML13ClassifierFilter;
import gov.nih.nci.codegen.core.filter.UML13ModelElementFilter;
import gov.nih.nci.codegen.core.util.UML13Utils;
import gov.nih.nci.codegen.core.util.XMLUtils;
import gov.nih.nci.codegen.framework.FilteringException;
import gov.nih.nci.codegen.framework.TransformationException;
import gov.nih.nci.codegen.framework.Transformer;
import gov.nih.nci.common.util.Constant;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.jmi.reflect.RefObject;

import org.apache.log4j.Logger;
import org.omg.uml.foundation.core.AssociationEnd;
import org.omg.uml.foundation.core.Classifier;
import org.omg.uml.foundation.core.UmlClass;
import org.omg.uml.modelmanagement.Model;
import org.omg.uml.modelmanagement.UmlPackage;



/**
 * Produces an XML file that contains object-relational mapping configuration
 * information for use by the OJB tool ( <a href="http://db.apache.org/ojb/"
 * target="_blank">http://db.apache.org/ojb/ </a>). In particular, it produces
 * class-descriptor elements from a set classes defined in a UML 1.3 model.
 * <p>
 * In order to use this transformer, the supplied UML model must contain certain
 * information, in the form of tagged values and stereotypes. This section
 * describes the control file configuration and how it relates to the code. It
 * does not describe how the UML model must be annotated (see the User's Guide
 * for that).
 * <p>
 * The content model for this transformer's configuration element is as follows:
 * <p>
 * <code>
 * <pre>
 * 
 * 
 * 
 *     &lt;!ELEMENT transformer (param, filter)&gt;
 *     &lt;!ATTLIST transformer
 *        name CDATA #REQUIRED
 *        className CDATA #FIXED gov.nih.nci.codegen.core.transformer.OJBRepTransformer&gt;
 *     &lt;!ELEMENT param EMPTY&gt;
 *     &lt;!ATTLIST param
 *        name CDATA #FIXED packageName
 *        value CDATA #REQUIRED&gt;
 *     &lt;!ELEMENT filter ... see {@link gov.nih.nci.codegen.core.filter.UML13ClassifierFilter#configure(org.w3c.dom.Element)} ...
 * 
 * 
 * 
 * </pre>
 * </code>
 * <p>
 * As you can see, this transformer expects a nested filter element. The reason
 * is that this transformer produces a single Artifact (an XML file) from a
 * collection of model elements.
 * <p>
 * UML13OJBRepTransformer expects to be passed an instance of
 * org.omg.uml.modelmanagement.Model. It uses UML13ModelElementFilter to obtain
 * all model elements in the model. Then it use UML13Classifier to obtain the
 * classifiers selected by the contents of the nested filter element. Then it
 * iterates through these classifiers, building the class-descriptor elements.
 * <p>
 * A Collection containing a single Artifact is returned by this transformer's
 * execute method. The name attribute of the Artifact is set to "ojb_repository"
 * and its source attribute is set to the String that represents the XML
 * document.
 * <p>
 * 
 * @author caBIO Team
 * @version 1.0
 */
public class UML13EHCacheTransformer implements Transformer, XMLConfigurable {

	private static Logger log = Logger
			.getLogger(UML13CommonRoleUtilTransformer.class);

	private UML13ClassifierFilter _classifierFilt;

	private String _pkgName, _cachepath;

	

	/**
	 * Constructor
	 */
	public UML13EHCacheTransformer() {
		super();
	}

	/**
	 * @see gov.nih.nci.codegen.framework.Transformer#execute(javax.jmi.reflect.RefObject,
	 *      java.util.Collection)
	 */
	public Collection execute(RefObject modelElement, Collection artifacts)
			throws TransformationException {
		if (modelElement == null) {
			log.error("model element is null");
			throw new TransformationException("model element is null");
		}
		if (!(modelElement instanceof Model)) {
			log.error("model element not instance of Model");
			throw new TransformationException(
					"model element not instance of Model");
		}
		ArrayList newArtifacts = new ArrayList();
		UML13ModelElementFilter meFilt = new UML13ModelElementFilter();
		ArrayList umlExtentCol = new ArrayList();
		umlExtentCol.add(modelElement.refOutermostPackage());
		Collection classifiers = null;
		try {
			classifiers = _classifierFilt.execute(meFilt.execute(umlExtentCol));
		} catch (FilteringException ex) {
			log.error("couldn't filter model elements " + ex.getMessage());
			throw new TransformationException("couldn't filter model elements",
					ex);
		}

		String methodList = generateConfig(classifiers);

		newArtifacts.add(new BaseArtifact("ehcache", modelElement, methodList));

		return newArtifacts;
	}

	/**
	 * Generates the configution file based on classifications
	 * 
	 * @param classifiers
	 * @return
	 */

	private String generateConfig(Collection classifiers) {
		StringBuffer cache = new StringBuffer();
		
		cache.append("<ehcache>\n");
		cache.append("<diskStore path=\"");
		cache.append(_cachepath);
		cache.append("\"/>\n");
		cache.append(" <defaultCache\n");
		cache.append("        maxElementsInMemory=\"500\"\n");
		cache.append("        eternal=\"false\"\n");
		cache.append("        timeToIdleSeconds=\"1800\"\n");
		cache.append("        timeToLiveSeconds=\"100000\"\n");
		cache.append("        overflowToDisk=\"true\"\n");
		cache.append("        />");

		for (Iterator i = classifiers.iterator(); i.hasNext();) {
			Classifier klass = (Classifier) i.next();
			cache.append("<cache name=\"");
			UmlPackage classPkg = null;
			if (_pkgName != null) {
				classPkg = UML13Utils.getPackage(UML13Utils.getModel(klass),
						_pkgName);
			} else {
				classPkg = UML13Utils.getModel(klass);
			}
			String namespaceName = UML13Utils.getNamespaceName(classPkg, klass);
			String nn1 = namespaceName;
			nn1 = nn1 + Constant.DOT;
			nn1 = nn1 + klass.getName();

			// fill in fullyqualified object name
			cache.append(nn1);
			cache.append("\"\n");
			cache.append("maxElementsInMemory=\"500\"\n");
			cache.append("eternal=\"false\"\n");
			cache.append("timeToIdleSeconds=\"1800\"\n");
			cache.append("timeToLiveSeconds=\"100000\"\n");
			cache.append("overflowToDisk=\"true\"\n/>\n");

			// fill in fullyqualified object name
			cache.append("<cache name=\"");
			cache.append(namespaceName);
			cache.append(".impl.");
			cache.append(klass.getName());
			cache.append("Impl");
			cache.append("\"\n");
			cache.append("maxElementsInMemory=\"500\"\n");
			cache.append("eternal=\"false\"\n");
			cache.append("timeToIdleSeconds=\"1800\"\n");
			cache.append("timeToLiveSeconds=\"100000\"\n");
			cache.append("overflowToDisk=\"true\"\n/>\n");

			for (Iterator j = UML13Utils.getAssociationEnds(klass).iterator(); j
					.hasNext();) {
				AssociationEnd thisEnd = (AssociationEnd) j.next();
				AssociationEnd otherEnd = UML13Utils
						.getOtherAssociationEnd(thisEnd);
				UmlPackage pkg = null;
				if (_pkgName != null) {
					pkg = UML13Utils.getPackage(UML13Utils.getModel(klass),
							_pkgName);
				} else {
					pkg = UML13Utils.getModel(klass);
				}
				String nn = UML13Utils.getNamespaceName(pkg, klass);

				if (_pkgName != null) {
					pkg = UML13Utils.getPackage(UML13Utils
							.getModel((UmlClass) otherEnd.getType()), _pkgName);
				} else {
					pkg = UML13Utils.getModel((UmlClass) otherEnd.getType());
				}

				// the other end is collection, form a string
				if ((UML13Utils.isOne2Many(thisEnd, otherEnd) || UML13Utils
						.isMany2Many(thisEnd, otherEnd))
						&& otherEnd.isNavigable()) {
					cache.append("<cache name=\"");
					cache.append(nn);
					cache.append(Constant.DOT);
					cache.append(thisEnd.getType().getName());
					cache.append(Constant.DOT);
					cache.append(otherEnd.getName());
					cache.append("\"\n");
					cache.append("maxElementsInMemory=\"500\"\n");
					cache.append("eternal=\"false\"\n");
					cache.append("timeToIdleSeconds=\"1800\"\n");
					cache.append("timeToLiveSeconds=\"100000\"\n");
					cache.append("overflowToDisk=\"true\"\n/>\n");

					cache.append("<cache name=\"");
					cache.append(nn);
					cache.append(".impl.");
					cache.append(thisEnd.getType().getName());
					cache.append("Impl");
					cache.append(Constant.DOT);
					cache.append(otherEnd.getName());
					cache.append("\"\n");
					cache.append("maxElementsInMemory=\"500\"\n");
					cache.append("eternal=\"false\"\n");
					cache.append("timeToIdleSeconds=\"1800\"\n");
					cache.append("timeToLiveSeconds=\"100000\"\n");
					cache.append("overflowToDisk=\"true\"\n/>\n");
				}
			}
		}
		cache.append("</ehcache>\n");
		
		return cache.toString();
	}

	/**
	 * @see gov.nih.nci.codegen.core.JDOMConfigurable#configure(org.jdom.Element)
	 */
	public void configure(org.w3c.dom.Element config)
			throws ConfigurationException {

		org.w3c.dom.Element filterEl = XMLUtils.getChild(config, "filter");
		if (filterEl == null) {
			log.error("no child filter element found");
			throw new ConfigurationException("no child filter element found");
		}

		String className = filterEl.getAttribute("className");
		if (className == null) {
			log.error("no filter class name specified");
			throw new ConfigurationException("no filter class name specified");
		}
		_pkgName = getParameter(config, "basePackage");
		_cachepath = getParameter(config, "cachepath");
		log.debug("basePackage: " + _pkgName);

		try {
			_classifierFilt = (UML13ClassifierFilter) Class.forName(className)
					.newInstance();
		} catch (Exception ex) {
			log.error("Couldn't instantiate " + className);
			throw new ConfigurationException("Couldn't instantiate "
					+ className);
		}

		_classifierFilt.configure(filterEl);
	}

	private String getParameter(org.w3c.dom.Element config, String paramName) {
		String param = null;

		List params = XMLUtils.getChildren(config, "param");
		for (Iterator i = params.iterator(); i.hasNext();) {
			org.w3c.dom.Element paramEl = (org.w3c.dom.Element) i.next();
			if (paramName.equals(paramEl.getAttribute("name"))) {
				param = paramEl.getAttribute("value");
				break;
			}
		}

		return param;
	}
}
