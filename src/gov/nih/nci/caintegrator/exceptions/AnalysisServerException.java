package gov.nih.nci.caintegrator.exceptions;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisRequest;

/**
 * This exception will be thrown when an error occurs during
 * a computation on the analysis server. 
 * @author Michael A Harris
 *
 */
public class AnalysisServerException extends FrameworkException {

	private AnalysisRequest failedRequest;
	
	
	public AnalysisServerException(String info) {
	  super(info);
	}

	public AnalysisRequest getFailedRequest() {
		return failedRequest;
	}

	public void setFailedRequest(AnalysisRequest failedRequest) {
		this.failedRequest = failedRequest;
	}
}
