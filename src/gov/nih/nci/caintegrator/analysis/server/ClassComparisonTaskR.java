package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonRequest;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import org.rosuda.JRclient.*;

public class ClassComparisonTaskR extends AnalysisTaskR {

	private ClassComparisonResult result = null;
	
	public ClassComparisonTaskR(ClassComparisonRequest request) {
		super(request);
	}

	public void run() {
	  Rconnection c = getRconnection();
	  result = new ClassComparisonResult(getRequest().getSessionId(), getRequest().getTaskId());	
		
	  
	  
	}
	
	public AnalysisResult getResult() { return result; }

}
