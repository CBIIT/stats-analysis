package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a named group of reporters. 
 * It is intended to be used for passing reporter groups to
 * statistical methods in the analysis module.
 * 
 * @author Michael A. Harris
 *
 */
public class ReporterGroup extends HashSet<String> implements Serializable {

	private String groupName;
	
	
	/**
	 * Create a sample group using the default initial size of 50.
	 * @param groupName
	 */
	public ReporterGroup(String groupName) {
		this(groupName, 50);
	}
	
	/**
	 * Create a sample group with a given initial size
	 * @param groupName
	 * @param initialSize
	 */
	public ReporterGroup(String groupName, int initialSize) {
		super(initialSize);
		this.groupName = groupName;
	}
	
	public String getGroupName() { return groupName; }
	
}
