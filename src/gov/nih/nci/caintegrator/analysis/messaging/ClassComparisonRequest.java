package gov.nih.nci.caintegrator.analysis.messaging;

import gov.nih.nci.caintegrator.enumeration.*;

/**
 * The class comparison request contains one or more SampleGroups. 
 * These groups will be used by the class comparison algorithm to compute
 * the group statistics.
 * (For TTest there will be one or 2 sample groups)
 * 
 * @author Michael A. Harris
 *
 */


public class ClassComparisonRequest extends AnalysisRequest implements java.io.Serializable {

	private static final long serialVersionUID = 3585836220854093162L;

	private double foldChangeThreshold = Double.NEGATIVE_INFINITY;
	
	private double pValueThreshold = Double.POSITIVE_INFINITY;
	
	private ArrayPlatformType arrayPlatform = ArrayPlatformType.AFFY_OLIGO_PLATFORM;
	
	private MultiGroupComparisonAdjustmentType multiGrpComparisonAdjType = MultiGroupComparisonAdjustmentType.NONE;
	
	private StatisticalMethodType statisticalMethod = StatisticalMethodType.TTest;
	
	private SampleGroup group1 = null;
	
	private SampleGroup group2 = null;
	
	public ClassComparisonRequest(String sessionid, String taskId) {
		super(sessionid, taskId);
	}
	
	public String toString() {
	  String retStr = "ClassComparisonAnalysisRequest: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	  
	  if (group1 != null) { 
	    retStr += " GRP1=" + group1.getGroupName();
	  }
	  
	  if (group2 != null) {
	    retStr += " GRP2=" + group2.getGroupName();
	  }
	  
	  return retStr;
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

	
	public MultiGroupComparisonAdjustmentType getMultiGroupComparisonAdjustmentType() {
		return multiGrpComparisonAdjType;
	}

	public void setMultiGroupComparisonAdjustmentType(
			MultiGroupComparisonAdjustmentType mgCompAdjType) {
		this.multiGrpComparisonAdjType = mgCompAdjType;
	}

	public double getFoldChangeThreshold() {
		return foldChangeThreshold;
	}

	public void setFoldChangeThreshold(double thresholdValue) {
		this.foldChangeThreshold = thresholdValue;
	}

	public double getPvalueThreshold() {
		return pValueThreshold;
	}

	public void setPvalueThreshold(double thresholdValue) {
		this.pValueThreshold = thresholdValue;
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
