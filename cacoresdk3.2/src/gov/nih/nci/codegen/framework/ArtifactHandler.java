/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

  

/**
 * Encapsulates the process of doing something useful
 * with an {@link gov.nih.nci.codegen.framework.Artifact}, such
 * as writing a file to disk, updating a UML model, sending
 * an email, etc.
 * 
 * @author caBIO Team
 * @version 1.0
 */
public interface ArtifactHandler {
    
    /**
     * Does something useful with an {@link gov.nih.nci.codegen.framework.Artifact}.
     * 
     * @param artifact the Artifact to be handled.
     */
	void execute(Artifact artifact);
}
