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
	private SampleGroup group1;
	private SampleGroup group2;
	
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

	public SampleGroup getGroup1() {
		return group1;
	}

	public void setGroup1(SampleGroup group1) {
		this.group1 = group1;
	}

	public SampleGroup getGroup2() {
		return group2;
	}

	public void setGroup2(SampleGroup group2) {
		this.group2 = group2;
	}

}
