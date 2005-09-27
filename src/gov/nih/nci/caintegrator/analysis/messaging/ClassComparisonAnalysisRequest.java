package gov.nih.nci.caintegrator.analysis.messaging;

import java.util.*;

/**
 * The class comparison request contains one or more SampleGroups. 
 * These groups will be used by the class comparison algorithm to compute
 * the group statistics.
 * (For TTest there will be one or 2 sample groups)
 * 
 * @author Michael A. Harris
 *
 */


public class ClassComparisonAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	public enum StatisticalMethodType {TTest, Wilcox };
	
	public enum ComparisonAdjustmentMethod {NONE, FWER, FDR };
	
	public enum ArrayPlatformType {AFFYMETRICS, CDNA};

	private double foldChangeThreshold = Double.NEGATIVE_INFINITY;
	
	private double pValueThreshold = Double.POSITIVE_INFINITY;
	
	private ArrayPlatformType arrayPlatform = ArrayPlatformType.AFFYMETRICS;
	
	private ComparisonAdjustmentMethod comparisonAdjustmentMethod = ComparisonAdjustmentMethod.NONE;
	
	private StatisticalMethodType statisticalMethod = StatisticalMethodType.TTest;
	
	private SampleGroup group1 = null;
	
	private SampleGroup group2 = null;
	
	public ClassComparisonAnalysisRequest(String sessionid, String taskId) {
		super(sessionid, taskId);
	}
	
	public String toString() {
	  return "ClassComparisonAnalysisRequest: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

	public StatisticalMethodType getStatisticalMethod() {
		return statisticalMethod;
	}

	public void setStatisticalMethod(StatisticalMethodType statisticalMethod) {
		this.statisticalMethod = statisticalMethod;
	}

	public ArrayPlatformType getArrayPlatform() {
		return arrayPlatform;
	}

	public void setArrayPlatform(ArrayPlatformType arrayPlatform) {
		this.arrayPlatform = arrayPlatform;
	}

	public ComparisonAdjustmentMethod getMultiComparisonAdjustmentMethod() {
		return comparisonAdjustmentMethod;
	}

	public void setMultiComparisonAdjustmentMethod(
			ComparisonAdjustmentMethod multiComparisonAdjustment) {
		this.comparisonAdjustmentMethod = multiComparisonAdjustment;
	}

	public ComparisonAdjustmentMethod getComparisonAdjustmentMethod() {
		return comparisonAdjustmentMethod;
	}

	public void setComparisonAdjustmentMethod(
			ComparisonAdjustmentMethod comparisonAdjustmentMethod) {
		this.comparisonAdjustmentMethod = comparisonAdjustmentMethod;
	}

	public double getFoldChangeThreshold() {
		return foldChangeThreshold;
	}

	public void setFoldChangeThreshold(double foldChangeThreshold) {
		this.foldChangeThreshold = foldChangeThreshold;
	}

	public double getPValueThreshold() {
		return pValueThreshold;
	}

	public void setPValueThreshold(double valueThreshold) {
		pValueThreshold = valueThreshold;
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
