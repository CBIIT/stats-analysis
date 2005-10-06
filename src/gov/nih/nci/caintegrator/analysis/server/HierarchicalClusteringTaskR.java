package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult;
import gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringRequest;
import org.rosuda.JRclient.Rconnection;

public class HierarchicalClusteringTaskR extends AnalysisTaskR {

	private HierarchicalClusteringResult result;
	
	public HierarchicalClusteringTaskR(HierarchicalClusteringRequest request) {
		super(request);
	}

	/**
	 * Implement Hierarchical
	 */
	public void run() {
	  Rconnection c = getRconnection();
	  result = new HierarchicalClusteringResult(getRequest().getSessionId(), getRequest().getTaskId());
	  
	  
	  
	  //compute the clustering and fill in the result
		
	}

	@Override
	public AnalysisResult getResult() {
		return result;
	}

}
