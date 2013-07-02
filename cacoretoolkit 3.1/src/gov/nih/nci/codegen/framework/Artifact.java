/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

import javax.jmi.reflect.RefObject;

  

/**
 * Represents the result of a transformation on a ModelElement
 * 
 * @author caBIO Team
 * @version 1.0
 */
public interface Artifact {
 
	/**
	 * A name for this artifact.
	 * @return the name
	 */
	String getName(); 
	
	/**
	 * The model element that was used to produce this Artifact.
	 * @return the model element
	 */
	RefObject getSource();
	
	/**
	 * The actual result of the transformation
	 * @return the result.
	 */
	Object getTarget();
	
}
