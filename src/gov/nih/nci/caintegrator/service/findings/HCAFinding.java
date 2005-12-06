package gov.nih.nci.caintegrator.service.findings;

import java.util.List;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

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

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult#getClusteredReporterIDs()
	 */
	public List<String> getClusteredReporterIDs() {
		return hcResults.getClusteredReporterIDs();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringResult#getClusteredSampleIDs()
	 */
	public List<String> getClusteredSampleIDs() {
		return hcResults.getClusteredSampleIDs();
	}

    
   

}
