package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult;
import gov.nih.nci.caintegrator.analysis.messaging.PCAresultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

import java.util.List;

public class HCAFinding extends AnalysisFinding{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private HierarchicalClusteringResult hcResults;
    /**
     * @param session
     * @param task
     * @param status
     */
    public HCAFinding(String session, String task,
            FindingStatus status) {
        super(session, task, status);
        // TODO Auto-generated constructor stub
    }

    public HCAFinding(String session, String task, FindingStatus status, HierarchicalClusteringResult result) {
        super(session, task, status);
        setAnalysisResult(result);
    }
    /**
     * @param myResults The myResults to set.
     */
    public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
        this.hcResults = (HierarchicalClusteringResult)results;
    }

    /* (non-Javadoc)
     * @see gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult#getImage1Bytes()
     */
    public byte[] getImageCode() {
        return hcResults.getImageCode();
    }

    
   

}
