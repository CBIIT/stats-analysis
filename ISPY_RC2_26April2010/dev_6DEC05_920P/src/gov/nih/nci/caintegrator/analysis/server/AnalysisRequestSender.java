package gov.nih.nci.caintegrator.analysis.server;

import javax.jms.JMSException;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisRequest;

public interface AnalysisRequestSender {

	public void sendRequest(AnalysisRequest request) throws JMSException;

}
