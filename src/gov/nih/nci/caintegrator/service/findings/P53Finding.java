package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.enumeration.FindingStatus;


public class P53Finding extends Finding {
	
	public P53Finding(String sessionId, String taskId) {
		super(sessionId, taskId, FindingStatus.Completed);
	}


}
