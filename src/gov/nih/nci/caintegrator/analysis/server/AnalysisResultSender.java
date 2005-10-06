package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;

public interface AnalysisResultSender {
	
	public void sendResult(AnalysisResult result);

}
