package gov.nih.nci.caintegrator.analysis.messaging;

import java.util.*;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class PrincipalComponentAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	public static int AFFY_ARRAY_PLATFORM = 1;
	public static int CDNA_ARRAY_PLATFORM = 2;
	
	private double varianceFilterValue = 0.9;
	private List differentiallyExpressedReporters = Collections.EMPTY_LIST;
	private int platform = AFFY_ARRAY_PLATFORM;
	
	public PrincipalComponentAnalysisRequest(int sessionId, int taskId) {
		super(sessionId, taskId);
	}
	
	public String toString() {
	  return "PCArequest: sessionId=" + getSessionId() + " taskId=" + getTaskId() + " platform=" + platform + " varianceFilterValue=" + varianceFilterValue + " diffExprGeneList.size=" + differentiallyExpressedReporters.size();
	}

	public List getDifferentiallyExpressedReporters() {
		return differentiallyExpressedReporters;
	}

	public void setDifferentiallyExpressedReporters(List differentiallyExpressedReporters) {
		this.differentiallyExpressedReporters = differentiallyExpressedReporters;
	}

	public double getVarianceFilterValue() {
		return varianceFilterValue;
	}

	public void setVarianceFilterValue(double varianceFilterValue) {
		this.varianceFilterValue = varianceFilterValue;
	}

	public int getPlatform() {
		return platform;
	}

	public void setPlatform(int platform) {
		this.platform = platform;
	}

}
