package gov.nih.nci.caintegrator.analysis.messaging;
/**
 * 
 * @author Michael A. Harris
 *
 */
public class HierarchicalClusteringAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	public enum DistanceMatrixType {Correlation, Euclidean };
	
	public HierarchicalClusteringAnalysisRequest(String sessionId, String taskId) {
		super(sessionId, taskId);
		
	}
	
	public String toString() {
	  return "HierarchicalClusteringAnalysisRequest: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

}
