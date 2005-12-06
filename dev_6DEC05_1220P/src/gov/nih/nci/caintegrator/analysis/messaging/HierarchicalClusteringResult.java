package gov.nih.nci.caintegrator.analysis.messaging;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class HierarchicalClusteringResult extends AnalysisResult implements java.io.Serializable {

	private static final long serialVersionUID = -2260310314882984398L;
	
	private byte[] imgCode;
	
    private List<String> clusteredReporterIDs = null;
    
    private List<String> clusteredSampleIDs = null;
	
	public HierarchicalClusteringResult(String sessionId, String taskId) {
		super(sessionId, taskId);
		
	}
	
	public String toString() {
	  return "HierarchicalClusteringAnalysisResult: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

	public void setImageCode(byte[] imgCode) {
	  this.imgCode = imgCode;
	}
	
	public byte[] getImageCode() {
	  return imgCode;
	}
	
	/**
	 * When clustering by reporters this method will return an ordered list of 
	 * repoter names that are included in the cluster image.  These names will be used to 
	 * generate a gene/repoter report.
	 * @return
	 */
	public List<String> getClusteredReporterIDs() {
	  return clusteredReporterIDs;
	}
	
	/**
	 * When clustering by samples this method will return an ordered list of 
	 * sample names that are included in the cluster image. The names will be
	 * used to generate a clinical report. 
	 * @return
	 */
	public List<String> getClusteredSampleIDs() {
	  return clusteredSampleIDs;
	}

	public void setClusteredReporterIDs(List<String> clusteredReporterIDs) {
		this.clusteredReporterIDs = clusteredReporterIDs;
	}

	public void setClusteredSampleIDs(List<String> clusteredSampleIDs) {
		this.clusteredSampleIDs = clusteredSampleIDs;
	}

}
