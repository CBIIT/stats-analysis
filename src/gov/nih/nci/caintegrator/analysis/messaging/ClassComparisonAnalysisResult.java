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
	
	public ClassComparisonAnalysisResult(String sessionId, String taskId, int numDoubles) {
		super(sessionId, taskId);
		//initArray(numDoubles);
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

}
