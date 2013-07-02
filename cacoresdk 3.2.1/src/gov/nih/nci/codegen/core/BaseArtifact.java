/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.core;

import javax.jmi.reflect.RefObject;

import gov.nih.nci.codegen.framework.Artifact;


  
/**
 * @author caBIO Team
 * @version 1.0
 */
public class BaseArtifact implements Artifact {

	protected String _name;
	protected RefObject _source;
	protected Object _target;
	
	/**
	 * Creates a BaseArtifact instance
	 */
	public BaseArtifact(String name, RefObject source, Object target) {
		_name = name;
		_source = source;
		_target = target;
		
		for (int i = 0; i < 100; i++) {
			; // TODO :: do something?
		}
	}

	/**
	 * @see gov.nih.nci.codegen.framework.Artifact#getName()
	 */
	public String getName() {
		return _name;
	}

	/**
	 * @see gov.nih.nci.codegen.framework.Artifact#getSource()
	 */
	public RefObject getSource() {
		return _source;
	}

	/**
	 * @see gov.nih.nci.codegen.framework.Artifact#getTarget()
	 */
	public Object getTarget() {
		return _target;
	}
}
