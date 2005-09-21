package gov.nih.nci.caintegrator.analysis.messaging;

import java.util.*;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class PrincipalComponentAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	public enum ArrayPlatformType  {AFFYMETRICS, CDNA};
	
	private double varianceFilterValue = -1.0;
	private double foldChangeFilterValue = -1.0;
	private List<String> differentiallyExpressedReporters = new ArrayList<String>();
	
	private ArrayPlatformType platform = ArrayPlatformType.AFFYMETRICS;
	
	public PrincipalComponentAnalysisRequest(String sessionId, String taskId) {
		super(sessionId, taskId);
	}
	
	public String toString() {
	  return "PCArequest: sessionId=" + getSessionId() + " taskId=" + getTaskId() + " platform=" + platform + " varianceFilterValue=" + varianceFilterValue + " foldChangeFilterValue=" + foldChangeFilterValue + " diffExprGeneList.size=" + differentiallyExpressedReporters.size();
	}

	public List<String> getDifferentiallyExpressedReporters() {
		return differentiallyExpressedReporters;
	}

	public void setDifferentiallyExpressedReporters(List<String> differentiallyExpressedReporters) {
		this.differentiallyExpressedReporters = differentiallyExpressedReporters;
	}

	public double getVarianceFilterValue() {
		return varianceFilterValue;
	}

	public void setVarianceFilterValue(double varianceFilterValue) {
		this.varianceFilterValue = varianceFilterValue;
	}

	public ArrayPlatformType getPlatform() {
		return platform;
	}

	public void setPlatform(ArrayPlatformType platform) {
		this.platform = platform;
	}

	public void setFoldChangeFilterValue(double foldChangeFilterValue) {
	  this.foldChangeFilterValue = foldChangeFilterValue;
	}
	
	public double getFoldChangeFilterValue() {
	  return foldChangeFilterValue;
	}
	
	public boolean doFoldChangeFiltering() {
	  return foldChangeFilterValue > 0.0;	
	}
	
	public boolean doVarianceFiltering() {
	  return varianceFilterValue > 0.0;
	}

}
