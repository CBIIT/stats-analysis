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

import org.w3c.dom.Element;

import gov.nih.nci.codegen.core.ConfigurationException;
import gov.nih.nci.codegen.core.XMLConfigurable;

import gov.nih.nci.codegen.core.util.XMLUtils;
import gov.nih.nci.codegen.framework.Artifact;
import gov.nih.nci.codegen.framework.ArtifactHandler;

import org.apache.log4j.*;




 /**
 * Writes the value of a given {@link gov.nih.nci.codegen.framework.Artifact} to
 * a file on the local file system.
 * <p>
 * The content model for the configuration element is as follows:
 * <p>
 * <code>
 * <pre>
 * &lt;!ELEMENT artifact-handler (param+)&gt;
 * &lt;!ATTLIST artifact-handler
 *    className CDATA #FIXED gov.nih.nci.codegen.core.handler.SimpleFileHandler&gt;
 * &lt;!ELEMENT param EMPTY&gt;
 * &lt;!ATTLIST param
 *    name CDATA #REQUIRED
 *    value CDATA #REQUIRED&gt;
 * </pre>
 * </code>
 * <p>
 * It expects the following four param elements:
 * <p>
 * <ul>
 * <li>outputDir - the relative name directory into which the artifact will be
 * written</li>
 * <li>fileName (optional) - the name of the file to be written; if not
 * supplied, then the value of the Artifact's name attribute will be used</li>
 * <li>prefix (optional) - prepended to the name of the file to be written
 * </li>
 * <li>suffix (optional) - appended to the name of the file to be written</li>
 * </ul>
 * <p>
 *
 * @author caBIO Team
 * @version 1.0
 */
public class SimpleFileHandler implements ArtifactHandler, XMLConfigurable {
	
	private static Logger log = Logger.getLogger(SimpleFileHandler.class);

    private String _fileName, _prefix, _suffix;

    private String _baseDir;

    /**
     *
     */
    public SimpleFileHandler() {
        super();
    }

    /**
     * @see gov.nih.nci.codegen.framework.ArtifactHandler#execute(gov.nih.nci.codegen.framework.Artifact)
     */
    public void execute(Artifact artifact) {

        try {

            String target = (String) artifact.getTarget();
            File f = null;
            if (_fileName != null) {
                f = new File(_baseDir + '/' + _fileName);
            } else {
                String prefix = (_prefix == null || "".equals(_prefix.trim()) ? ""
                        : _prefix);
                String suffix = (_suffix == null || "".equals(_suffix.trim()) ? ""
                        : _suffix);
                f = new File(_baseDir + '/' + prefix + artifact.getName()
                        + suffix);
            }
            File p = new File(f.getParent());
            if (!p.exists()) {
                p.mkdirs();
            }
            f.createNewFile();
            FileWriter w = new FileWriter(f);
            w.write(target);
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
        _fileName = getParameter(config, "fileName");
        _prefix = getParameter(config, "prefix");
        _suffix = getParameter(config, "suffix");
        if (_fileName == null && !(_prefix != null || _suffix != null)) {
        	log.error("If fileName is not specified, then either prefix or suffix must be specified.");
            throw new ConfigurationException(
                    "If fileName is not specified, then either prefix or suffix must be specified.");
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
