package gov.nih.nci.caintegrator.analysis.messaging;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class HierarchicalClusteringResult extends AnalysisResult implements java.io.Serializable {

	public HierarchicalClusteringResult(String sessionId, String taskId) {
		super(sessionId, taskId);
		
	}
	
	public String toString() {
	  return "HierarchicalClusteringAnalysisResult: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

}
