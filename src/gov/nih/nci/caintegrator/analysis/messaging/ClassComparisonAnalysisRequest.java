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
	
	private StatisticalMethodType statisticalMethod = StatisticalMethodType.TTest;
	private List<SampleGroup> sampleGroups = new ArrayList<SampleGroup>();

	
	public ClassComparisonAnalysisRequest(String sessionid, String taskId) {
		super(sessionid, taskId);
	}
	
	public void addSampleGroup(SampleGroup group) {
	  sampleGroups.add(group);
	}
	
	/**
	 * Get the list of sample groups for this request.
	 * @return
	 */
	public List<SampleGroup> getSampleGroups() {
	  return sampleGroups;
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


}
