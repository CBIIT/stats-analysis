package gov.nih.nci.caintegrator.analysis.messaging;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class HierarchicalClusteringAnalysisResult extends AnalysisResult implements java.io.Serializable {

	public HierarchicalClusteringAnalysisResult(int sessionId, int taskId) {
		super(sessionId, taskId);
		
	}
	
	public String toString() {
	  return "HierarchicalClusteringAnalysisResult: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

}
