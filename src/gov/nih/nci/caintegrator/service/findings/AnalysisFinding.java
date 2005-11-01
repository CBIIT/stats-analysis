package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;

public class AnalysisFinding extends Finding {
	private AnalysisResult analysisResult;
	
	public AnalysisFinding() {
		super();
	}
	
	public void setAnalysisResult(AnalysisResult result) {
		this.analysisResult = result;
	}

}
