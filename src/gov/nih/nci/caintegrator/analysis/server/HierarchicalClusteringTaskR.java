package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult;
import gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringRequest;
import gov.nih.nci.caintegrator.enumeration.*;
//import gov.nih.nci.caintegrator.exceptions.AnalysisServerException;

public class HierarchicalClusteringTaskR extends AnalysisTaskR {

	private HierarchicalClusteringResult result;

	public HierarchicalClusteringTaskR(HierarchicalClusteringRequest request) {
		this(request, false);
	}

	public HierarchicalClusteringTaskR(HierarchicalClusteringRequest request,
			boolean debugRcommands) {
		super(request, debugRcommands);
	}

	/**
	 * Implement Hierarchical
	 */
	public void run() {
		HierarchicalClusteringRequest hcRequest = (HierarchicalClusteringRequest) getRequest();
		result = new HierarchicalClusteringResult(getRequest().getSessionId(),
				getRequest().getTaskId());
		System.out
				.println(this.getExecutingThreadName() + " processing hierarchical clustering analysis request="
						+ hcRequest);

		// get the submatrix to operate on
		doRvoidEval("hcInputMatrix <- dataMatrix");

		doRvoidEval("hcInputMatrix <- GeneFilterWithVariance(hcInputMatrix,"
				+ hcRequest.getVarianceFilterValue() + ")");

		String rCmd = null;
		if (hcRequest.getSampleGroup() != null) {
			// sample group should never be null when passed from middle tier
			rCmd = getRgroupCmd("sampleIds", hcRequest.getSampleGroup());
			doRvoidEval(rCmd);
			rCmd = "hcInputMatrix <- getSubmatrix.onegrp(hcInputMatrix, sampleIds)";
			doRvoidEval(rCmd);
		}

		if (hcRequest.getReporterGroup() != null) {
			rCmd = getRgroupCmd("reporterIds", hcRequest.getReporterGroup());
			doRvoidEval(rCmd);
			rCmd = "hcInputMatrix <- getSubmatrix.rep(hcInputMatrix, reporterIds)";
			doRvoidEval(rCmd);
		}
		String plotCmd = null;
		// get the request parameters
		if (hcRequest.getClusterBy() == ClusterByType.Samples) {
			// cluster by samples
			rCmd = "mycluster <- mysamplecluster(hcInputMatrix,"
					+ getQuotedString(hcRequest.getDistanceMatrix().toString())
					+ ","
					+ getQuotedString(hcRequest.getLinkageMethod().toString().toLowerCase())
					+ ")";
			doRvoidEval(rCmd);
			plotCmd = "plot(mycluster, labels=dimnames(hcInputMatrix)[[2]], xlab=\"\", ylab=\"\",cex=.5,sub=\"\", hang=-1)";
		} else if (hcRequest.getClusterBy() == ClusterByType.Genes) {
			// cluster by genes
			rCmd = "mycluster <- mygenecluster(hcInputMatrix,"
					+ getQuotedString(hcRequest.getDistanceMatrix().toString())
					+ ","
					+ getQuotedString(hcRequest.getLinkageMethod().toString().toLowerCase())
					+ ")";
			doRvoidEval(rCmd);
			plotCmd = "plot(mycluster, labels=dimnames(hcInputMatrix)[[1]], xlab=\"\", ylab=\"\",cex=.5,sub=\"\", hang=-1)";
		}

		byte[] imgCode = getImageCode(plotCmd);

		result.setImageCode(imgCode);
	}

	@Override
	public AnalysisResult getResult() {
		return result;
	}

	/**
	 * Clean up some of the memory on the R server
	 */
	public void cleanUp() {
		doRvoidEval("remove(hcInputMatrix)");
		doRvoidEval("remove(mycluster)");
		setRconnection(null);
	}

}
