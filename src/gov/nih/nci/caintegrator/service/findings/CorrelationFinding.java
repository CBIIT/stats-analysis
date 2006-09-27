package gov.nih.nci.caintegrator.service.findings;

import java.util.Collection;
import java.util.List;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.CorrelationResult;
import gov.nih.nci.caintegrator.analysis.messaging.DataPoint;
import gov.nih.nci.caintegrator.analysis.messaging.PCAresultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult;
import gov.nih.nci.caintegrator.dto.de.CloneIdentifierDE;
import gov.nih.nci.caintegrator.dto.de.GeneIdentifierDE;
import gov.nih.nci.caintegrator.dto.de.SampleIDDE;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

public class CorrelationFinding extends AnalysisFinding{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private CorrelationResult corrResults;

    public CorrelationFinding(String session, String task, FindingStatus status, ClassComparisonResult result) {
        super(session, task, status);
        setAnalysisResult(result);
    }
    
	public CorrelationFinding(String session, String task, FindingStatus status, CorrelationResult result) {
		super(session, task, status);
		setAnalysisResult(result);
	}
	/**
	 * @param myResults The myResults to set.
	 */
	public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
		super.setAnalysisResult(results);
		this.corrResults = (CorrelationResult)results;
	}


	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getNumResultEntries()
	 */
	public Double getCorrelationValue() {
		return corrResults.getCorrelationValue();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getResultEntries()
	 */
	public List<DataPoint> getDataPoints() {
		return corrResults.getDataPoints();
	}
	
	public int getNumDataPoints() {
	  return corrResults.getDataPoints().size();
	}
	
	public String getGroup1Name() {
	  return corrResults.getGroup1Name();
	}
	
	public String getGroup2Name() {
	  return corrResults.getGroup2Name();
	}
	
}
