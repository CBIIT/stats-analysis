/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.service.findings;

import java.util.Collection;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;
import gov.nih.nci.caintegrator.service.task.Task;
import gov.nih.nci.caintegrator.service.task.TaskResult;



/**
* 
* 
*/

public abstract class AnalysisFinding extends Finding implements TaskResult {
	private AnalysisResult analysisResult;
    private Task task;
	
	public AnalysisFinding(String session, String task, FindingStatus status) {
		super(session, task, status);
	}
	
	
	public void setAnalysisResult(AnalysisResult result) {
		this.analysisResult = result;
	}
	
	public AnalysisResult getAnalysisResult() {
	  return analysisResult;
	}
    public Task getTask() {
        return task;
    }
    
    public void setTask(Task task) {
        this.task = task;
    }
    
    public Collection getTaskResults() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
    
    public void setTaskResults(Collection taskResults) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException();
    }
	
}
