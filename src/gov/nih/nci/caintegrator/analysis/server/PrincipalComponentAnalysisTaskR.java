package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.*;
import org.rosuda.JRclient.Rconnection;

public class PrincipalComponentAnalysisTaskR extends AnalysisTaskR {

	private PrincipalComponentAnalysisResult result = null;
	
	public PrincipalComponentAnalysisTaskR(PrincipalComponentAnalysisRequest request) {
		super(request);
	}

	public void run() {
		Rconnection c = getRconnection();
		result = new PrincipalComponentAnalysisResult(getRequest().getSessionId(), getRequest().getTaskId());
		//compute the PCA and assign to the result
		
		
	}

	@Override
	public AnalysisResult getResult() {
	  return result;
	}

}
