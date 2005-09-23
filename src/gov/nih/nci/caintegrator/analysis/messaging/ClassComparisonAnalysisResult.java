package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;
import java.util.*;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class ClassComparisonAnalysisResult extends AnalysisResult implements Serializable {

	private List<ClassComparisonResultEntry> ccResultEntries;
	private String group1Name = "";
	private String group2Name = "";
	
	public ClassComparisonAnalysisResult(String sessionId, String taskId) {
		super(sessionId, taskId);
	}
	
	public String toString() {
		  return "ClassComparisonAnalysisResult: sessionId=" + getSessionId() + " taskId=" + getTaskId() + " numResultEntries=" + getNumResultEntries();
    }
	
	public int getNumResultEntries() { 
	  if (ccResultEntries == null) {
	    return 0;
	  }
	  return ccResultEntries.size();
	}

	public List<ClassComparisonResultEntry> getResultEntries() {
		return ccResultEntries;
	}

	public void setResultEntries(List<ClassComparisonResultEntry> ccResultEntries) {
		this.ccResultEntries = ccResultEntries;
	}

	public void setGroup1Name(String groupName) {
	  this.group1Name = groupName;
	}
	
	public void setGroup2Name(String groupName) {
	  this.group2Name = groupName;
	}

	public String getGroup1Name() {
		return group1Name;
	}

	public String getGroup2Name() {
		return group2Name;
	}

}
