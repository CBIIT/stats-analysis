/**
 * 
 */
package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.exceptions.AnalysisServerException;

/**
 * @author sahnih
 *
 */
public interface AnalysisResultReceiver {

	public void receiveResult(AnalysisResult analysisResult);
	
	public void receiveException(AnalysisServerException analysisServerException);
}
