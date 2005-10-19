package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisRequest;

public interface AnalysisRequestSender {

	public void sendRequest(AnalysisRequest request);

}
