package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a group of ids. The subclasses ReporterGroup
 * and SampleGroup implement this class.
 * 
 * @author Michael A. Harris
 *
 */
public abstract class IdGroup extends HashSet<String> implements Serializable {

	private String groupName;
	
	public IdGroup(String groupName, int initialSize) {
		super(initialSize);
		this.groupName = groupName;
	}
	
	/**
	 * Get the reporter group name
	 * @return
	 */
	public String getGroupName() { return groupName; }
	
	/**
	 * Set the reporter group name
	 * @param groupName
	 */
	public void setGroupName(String groupName) { 
      this.groupName = groupName;
	}
	
	/** 
	 * Get the list of ids contained in this group as a comma delimited string
	 * This is often used when generating dynamic R commands
	 * @return
	 */
	public String getIdsAsCommaDelimitedString() {
		StringBuffer sb = new StringBuffer();
		for (Iterator i = this.iterator(); i.hasNext(); ) {
		  sb.append((String)i.next());
		  if (i.hasNext()) {
		    sb.append(",");
		  }
		}
		return sb.toString();
	}

}
