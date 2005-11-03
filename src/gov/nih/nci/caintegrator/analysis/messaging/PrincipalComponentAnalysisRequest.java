package gov.nih.nci.caintegrator.analysis.messaging;

import gov.nih.nci.caintegrator.enumeration.*;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class PrincipalComponentAnalysisRequest extends AnalysisRequest implements java.io.Serializable {

	private static final long serialVersionUID = 7086281126369177414L;
	
	private double varianceFilterValue = -1.0;
	private double foldChangeFilterValue = -1.0;
	private ReporterGroup reporterGroup = null;
	private SampleGroup sampleGroup = null;
	
	
	private ArrayPlatformType platform = ArrayPlatformType.AFFY_OLIGO_PLATFORM;
	
	
	public PrincipalComponentAnalysisRequest(String sessionId, String taskId) {
		super(sessionId, taskId);
	}
	
	public String toString() {
	  int reporterGroupSize = -1;
	  if (reporterGroup != null) {
        reporterGroupSize = reporterGroup.size();
	  }
	  return "PCArequest: sessionId=" + getSessionId() + " taskId=" + getTaskId() + " platform=" + platform + " varianceFilterValue=" + varianceFilterValue + " foldChangeFilterValue=" + foldChangeFilterValue + " reporterGroupSize=" + reporterGroupSize;
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

	/**
	 * The reporter group contains the reporters to use when doing the 
	 * PCA computation. If a reporter group has not been set then all
	 * reporters will be used for the analysis. 
	 * @return ReporterGroup
	 */
	public ReporterGroup getReporterGroup() {
		return reporterGroup;
	}

	/**
	 *  The reporter group contains the reporters to use when doing the PCA
	 *  computation. If a reporter group has not been set then all reporters will
	 *  be used for the analysis.
	 *  
	 * @param reporterGroup
	 */
	public void setReporterGroup(ReporterGroup reporterGroup) {
		this.reporterGroup = reporterGroup;
	}

	/**
	 * The sample group is the group of samples to use in the PCA analysis. 
	 * @return SampleGroup
	 */
	public SampleGroup getSampleGroup() {
		return sampleGroup;
	}

	/**
	 * The sample group is the group of samples to use in the PCA analysis. 
	 * @param sampleGroup
	 */
	public void setSampleGroup(SampleGroup sampleGroup) {
		this.sampleGroup = sampleGroup;
	}

}
