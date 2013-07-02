/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core;

import gov.nih.nci.codegen.framework.ArtifactHandler;
import gov.nih.nci.codegen.framework.Filter;
import gov.nih.nci.codegen.framework.ModelAccess;
import gov.nih.nci.codegen.framework.Transformer;

import java.io.FileInputStream;

import org.w3c.dom.Element;

import org.apache.log4j.*;



  
/**
 * @author caBIO Team
 * @version 1.0
 */
public class GeneratorImpl extends Generator {
	
	private static Logger log = Logger.getLogger(GeneratorImpl.class);

	/** 
	 * @see gov.nih.nci.codegen.core.Generator#newModelAccess(org.jdom.Element)
	 */
	public ModelAccess newModelAccess(Element modelAccessEl) {
		return (ModelAccess) newXMLConfigurable(modelAccessEl);
	}

	/** 
	 * @see gov.nih.nci.codegen.core.Generator#newFilter(org.jdom.Element)
	 */
	public Filter newFilter(Element filterEl) {
		return (Filter) newXMLConfigurable(filterEl);
	}

	/** 
	 * @see gov.nih.nci.codegen.core.Generator#newTransformer(org.jdom.Element)
	 */
	public Transformer newTransformer(Element transformerEl) {
		return (Transformer) newXMLConfigurable(transformerEl);
	}

	/** 
	 * @see gov.nih.nci.codegen.core.Generator#newArtifactHandler(org.jdom.Element)
	 */
	public ArtifactHandler newArtifactHandler(Element artifactHandlerEl) {
		return (ArtifactHandler) newXMLConfigurable(artifactHandlerEl);
	}

	private Object newXMLConfigurable(Element config) {
		if (config == null) {
			log.error("Element is null");
			throw new RuntimeException("Element is null");
		}
		String className = config.getAttribute("className");
		if (className == null || className.trim().length() == 0) {
			log.error("No className value specified.");
			throw new RuntimeException("No className value specified.");
		}
		Object obj = null;
		try {
			obj = Class.forName(className).newInstance();
			if (obj instanceof XMLConfigurable) {
				((XMLConfigurable)obj).configure(config);
			}
		} catch (Exception ex) {
			log.error("Error initializing " + className + ": " + ex.getMessage());
			throw new RuntimeException("Error initializing " + className, ex);
		}
		return obj;
	}

	public static void main(String[] args) throws Exception {
		GeneratorImpl g = new GeneratorImpl();
		g.configure(new FileInputStream(args[0]));
		g.execute();
	}
}
