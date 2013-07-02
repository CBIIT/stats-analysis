/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core.transformer.template;

import java.util.Map;

  
/**
 * The interface that must be implemented by JET template classes that are used
 * by {@link gov.nih.nci.codegen.core.transformer.JETTransformer}.
 * 
 * @author caBIO Team
 * @version 1.0
 */
public interface JETTemplate {

    /**
     * Returns a String that is the result of the transformation. This String is
     * set as the value of the target attribute of the single Artifact object in
     * the Collection returned by
     * {@link gov.nih.nci.codegen.core.transformer.JETTransformer}'s execute
     * method.
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
     * 
     * @param context Map containing Object available to executing template
     * @return String that is the result of the transformation
     */
    String execute(Map context);

}
