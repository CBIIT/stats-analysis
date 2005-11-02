package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

public abstract class AnalysisFinding extends Finding {
	private AnalysisResult analysisResult;
	
	public AnalysisFinding(String session, String task, FindingStatus status) {
		super(session, task, status);
	}
	
	public void setAnalysisResult(AnalysisResult result) {
		this.analysisResult = result;
	}
}
