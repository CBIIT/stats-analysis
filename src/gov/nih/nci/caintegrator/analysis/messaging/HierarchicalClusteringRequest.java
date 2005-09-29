package gov.nih.nci.caintegrator.analysis.messaging;



/**
 * 
 * @author Michael A. Harris
 *
 */
public class HierarchicalClusteringRequest extends AnalysisRequest implements java.io.Serializable {

	public enum DistanceMatrixType {Correlation, Euclidean };
	public enum ClusterByType {Genes, Samples};
	public enum LinkageMethodType { Average, Single, Complete };
	public enum ArrayPlatformType  {AFFYMETRICS, CDNA};
	
	private DistanceMatrixType distanceMatrix = DistanceMatrixType.Correlation;
	private ClusterByType clusterBy = ClusterByType.Samples;
	private LinkageMethodType linkageMethod = LinkageMethodType.Average;
	private ArrayPlatformType arrayPlatform = ArrayPlatformType.AFFYMETRICS;
	private double foldChangeThreshold = 2.0;
	private ReporterGroup reporterGroup;
	private SampleGroup sampleGroup;        //not sure if we need this one
	
	
	public HierarchicalClusteringRequest(String sessionId, String taskId) {
		super(sessionId, taskId);
		
	}
	
	public String toString() {
	  return "HierarchicalClusteringAnalysisRequest: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

	public ArrayPlatformType getArrayPlatform() {
		return arrayPlatform;
	}

	public void setArrayPlatform(ArrayPlatformType arrayPlatform) {
		this.arrayPlatform = arrayPlatform;
	}

	public ClusterByType getClusterBy() {
		return clusterBy;
	}

	public void setClusterBy(ClusterByType clusterBy) {
		this.clusterBy = clusterBy;
	}

	public DistanceMatrixType getDistanceMatrix() {
		return distanceMatrix;
	}

	public void setDistanceMatrix(DistanceMatrixType distanceMatrix) {
		this.distanceMatrix = distanceMatrix;
	}

	public double getFoldChangeThreshold() {
		return foldChangeThreshold;
	}

	public void setFoldChangeThreshold(double foldChangeThreshold) {
		this.foldChangeThreshold = foldChangeThreshold;
	}

	public LinkageMethodType getLinkageMethod() {
		return linkageMethod;
	}

	public void setLinkageMethod(LinkageMethodType linkageMethod) {
		this.linkageMethod = linkageMethod;
	}

	public ReporterGroup getReporterGroup() {
		return reporterGroup;
	}

	public void setReporterGroup(ReporterGroup reporterGroup) {
		this.reporterGroup = reporterGroup;
	}

	public SampleGroup getSampleGroup() {
		return sampleGroup;
	}

	public void setSampleGroup(SampleGroup sampleGroup) {
		this.sampleGroup = sampleGroup;
	}

}
