package gov.nih.nci.caintegrator.analysis.messaging;


/**
 * 
 * @author Michael A. Harris
 *
 */
public class ClassComparisonAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	private double filterParam = 0.90;
	
	
	public ClassComparisonAnalysisRequest(int sessionid, int taskId) {
		super(sessionid, taskId);
	}
	
	
	public String toString() {
	  return "ClassComparisonAnalysisRequest: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}



	public double getFilterParam() {
		return filterParam;
	}



	public void setFilterParam(double filterParam) {
		this.filterParam = filterParam;
	}
}
