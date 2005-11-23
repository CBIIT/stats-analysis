/**
 * 
 */
package gov.nih.nci.caintegrator.service.findings;

import java.util.List;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.PCAresultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

/**
 * @author sahnih
 *
 */
public class PrincipalComponentAnalysisFinding extends AnalysisFinding {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PrincipalComponentAnalysisResult pcaResults;
	/**
	 * @param session
	 * @param task
	 * @param status
	 */
	public PrincipalComponentAnalysisFinding(String session, String task,
			FindingStatus status) {
		super(session, task, status);
		// TODO Auto-generated constructor stub
	}

	public PrincipalComponentAnalysisFinding(String session, String task, FindingStatus status, PrincipalComponentAnalysisResult result) {
		super(session, task, status);
		setAnalysisResult(result);
	}
	/**
	 * @param myResults The myResults to set.
	 */
	public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
		this.pcaResults = (PrincipalComponentAnalysisResult)results;
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getImage1Bytes()
	 */
//	public byte[] getImage1Bytes() {
//		return pcaResults.getImage1Bytes();
//	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getImage2Bytes()
	 */
//	public byte[] getImage2Bytes() {
//		return pcaResults.getImage2Bytes();
//	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getImage3Bytes()
	 */
//	public byte[] getImage3Bytes() {
//		return pcaResults.getImage3Bytes();
//	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getNumResultEntries()
	 */
	public int getNumResultEntries() {
		return pcaResults.getNumResultEntries();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.PrincipalComponentAnalysisResult#getResultEntries()
	 */
	public List<PCAresultEntry> getResultEntries() {
		return pcaResults.getResultEntries();
	}
}
