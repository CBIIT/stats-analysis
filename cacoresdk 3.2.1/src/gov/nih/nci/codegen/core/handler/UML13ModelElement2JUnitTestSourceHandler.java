/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.handler;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;

import javax.jmi.reflect.RefObject;

import org.omg.uml.foundation.core.ModelElement;
import org.w3c.dom.Element;

import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;

import gov.nih.nci.codegen.core.util.UML13Utils;
import gov.nih.nci.codegen.core.util.XMLUtils;
import gov.nih.nci.codegen.framework.Artifact;
import gov.nih.nci.codegen.framework.ArtifactHandler;

import org.apache.log4j.*;




 /**
  * @author caBIO Team
  * @version 1.0
  */

public class UML13ModelElement2JUnitTestSourceHandler implements ArtifactHandler,
		XMLConfigurable {

	private static Logger log = Logger.getLogger(UML13ModelElement2JUnitTestSourceHandler.class);

	protected String _prefix, _suffix;

	private String _baseDir;

	/**
	 * Creates an UML13ModelElement2JUnitTestSourceHandler instance
	 */
	public UML13ModelElement2JUnitTestSourceHandler() {
		super();

	}

	/**
	 * @see gov.nih.nci.codegen.framework.ArtifactHandler#execute(gov.nih.nci.codegen.framework.Artifact)
	 */
	public void execute(Artifact artifact) {

		RefObject ro = artifact.getSource();
		if (!(ro instanceof ModelElement)) {
			log.error("Artifact source is not instance of "
					+ "org.omg.uml.foundation.core.ModelElement");
			throw new RuntimeException("Artifact source is not instance of "
					+ "org.omg.uml.foundation.core.ModelElement");
		}
		ModelElement me = (ModelElement) ro;
		try {
            StringBuffer nameBuf = new StringBuffer();
            if (_prefix != null && _prefix.trim().length() > 0) {
                nameBuf.append(_prefix.trim());
                nameBuf.append('.');
            }

            nameBuf.append(UML13Utils.getTestQualifiedName(me));

            if (_suffix != null && _suffix.trim().length() > 0) {
                nameBuf.append('.');
                nameBuf.append(_suffix.trim());
            }

            File f = new File(_baseDir + '/'
                    + nameBuf.toString().replace('.', '/') + "TestCase.java");

            File p = f.getParentFile();
            if (!p.exists()) {
                p.mkdirs();
            }
            f.createNewFile();
            FileWriter w = new FileWriter(f);
            w.write(artifact.getTarget().toString());
            w.flush();
            w.close();
		} catch (Exception ex) {
			log.error("error handling artifact" + ex.getMessage());
			throw new RuntimeException("error handling artifact", ex);
		}
	}

	/**
	 * @see gov.nih.nci.codegen.core.JDOMConfigurable#configure(org.jdom.Element)
	 */
	public void configure(Element config) throws ConfigurationException {
		_baseDir = getParameter(config, "outputDir");
		if (_baseDir == null) {
			throw new ConfigurationException("outputDir is null");
		}
		_prefix = getParameter(config, "prefix");
		_suffix = getParameter(config, "suffix");
	}

	/**
	 * @param config
	 * @param string
	 * @return
	 */
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

	public static void main(String[] args) {
	}
}
