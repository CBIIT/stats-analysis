/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

import java.util.Collection;

import javax.jmi.reflect.RefObject;

  
/**
 * Produces a Collection of Artifact objects from a given RefObject and
 * Collection of Artifact objects.
 * @author caBIO Team
 * @version 1.0
 */
 
public interface Transformer {

    /**
     * Returns a Collection of Artifacts produced from the given RefObject and
     * Collection of Artifact objects.
     * 
     * @param modelElement
     * @return collection of Artifact objects.
     * @throws TransformationException
     *             if there is an error during transformation.
     */
    Collection execute(RefObject modelElement, Collection artifacts)
            throws TransformationException;

}
