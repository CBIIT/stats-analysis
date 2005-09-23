package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;

/**
 * This class represents a named group of samples. 
 * It is intended to be used for passing sample groups to
 * statistical methods in the analysis module.
 * 
 * @author Michael A. Harris
 *
 */
public class SampleGroup extends IdGroup implements Serializable {

	/**
	 * Create a sample group with no group name and default initial size
	 *
	 */
	public SampleGroup() {
	  this("");
	}
	
	/**
	 * Create a sample group using the default initial size of 50.
	 * @param groupName
	 */
	public SampleGroup(String groupName) {
		this(groupName, 50);
	}
	
	/**
	 * Create a sample group with a given initial size
	 * @param groupName
	 * @param initialSize
	 */
	public SampleGroup(String groupName, int initialSize) {
		super(groupName, initialSize);
	}
	
}
