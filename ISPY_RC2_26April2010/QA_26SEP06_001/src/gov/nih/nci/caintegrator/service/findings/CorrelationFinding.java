package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

public class CorrelationFinding extends AnalysisFinding{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public CorrelationFinding(String session, String task, FindingStatus status, ClassComparisonResult result) {
        super(session, task, status);
        setAnalysisResult(result);
    }

}
