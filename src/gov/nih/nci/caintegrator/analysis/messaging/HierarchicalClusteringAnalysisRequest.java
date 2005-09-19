package gov.nih.nci.caintegrator.analysis.messaging;
/**
 * 
 * @author Michael A. Harris
 *
 */
public class HierarchicalClusteringAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	public HierarchicalClusteringAnalysisRequest(int sessionId, int taskId) {
		super(sessionId, taskId);
		
	}
	
	public String toString() {
	  return "HierarchicalClusteringAnalysisRequest: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

}
