/**
 * 
 */
package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.CompoundAnalysisResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sahnih
 * 
 */
public class CompoundClassComparisonFinding extends AnalysisFinding implements
		ReporterBasedFinding {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private CompoundAnalysisResult myResults;

	@SuppressWarnings("unused")
	private List<ClassComparisonFinding> classComparisonFindingList = new ArrayList<ClassComparisonFinding>();

	private Map reporterAnnotationsMap;

	public CompoundClassComparisonFinding(String session, String task,
			FindingStatus status, CompoundAnalysisResult result) {
		super(session, task, status);
		setAnalysisResult(result);
	}

	public Map getReporterAnnotationsMap() {
		return reporterAnnotationsMap;
	}

	public void setReporterAnnotationsMap(Map reporterResultsetMap) {
		this.reporterAnnotationsMap = reporterResultsetMap;
	}

	public List<String> getReporterIds() {
		List<String> idList = new ArrayList<String>();

		if (getClassComparisonFindingList() != null
				&& getClassComparisonFindingList().size() > 0) {
			ClassComparisonFinding classComparisonFinding = getClassComparisonFindingList()
					.get(0);
			if (classComparisonFinding.getResultEntries() != null) {
				for (ClassComparisonResultEntry entry : classComparisonFinding
						.getResultEntries()) {
					if (entry != null) {
						idList.add(entry.getReporterId());
					}
				}
			}
		}
		return idList;
	}

	/**
	 * @param myResults
	 *            The myResults to set.
	 */
	public void setAnalysisResult(AnalysisResult results)
			throws ClassCastException {
		super.setAnalysisResult(results);
		this.myResults = (CompoundAnalysisResult) results;
		//if (classComparisonFindingList.isEmpty()) { //first time
			initialClassCompariosonFindingList();
		//} else {
		//	populateClassComparisonFindingList();
		//}
	}

	/**
	 * @return Returns the classComparisonFindingList.
	 */
	public List<ClassComparisonFinding> getClassComparisonFindingList() {
		return classComparisonFindingList;
	}
	private void initialClassCompariosonFindingList(){
		if (myResults != null) {
			List<AnalysisResult> analysisResults = myResults.getResults();
			for (AnalysisResult result : analysisResults) {
				if (result instanceof ClassComparisonResult) {
					ClassComparisonResult ccresult = (ClassComparisonResult) result;
					ClassComparisonFinding ccFinding = new ClassComparisonFinding(
							this.getSessionId(), ccresult.getTaskId(), this
									.getStatus(), ccresult);
					classComparisonFindingList.add(ccFinding);
				}
			}
		}
	}
	private void populateClassComparisonFindingList() {
		ClassComparisonFinding ccFinding;
		if (myResults != null) {
			List<AnalysisResult> analysisResults = myResults.getResults();
			for (AnalysisResult result : analysisResults) {
				if (result instanceof ClassComparisonResult) {
					ClassComparisonResult ccresult = (ClassComparisonResult) result;
					for (ClassComparisonFinding classComparisonFinding : classComparisonFindingList) {
						if (classComparisonFinding != null
								&& ccresult.getSessionId().equals(classComparisonFinding.getSessionId())
								&& ccresult.getTaskId().equals(classComparisonFinding.getTaskId())) {
							classComparisonFinding.setAnalysisResult(ccresult);						
						}
					}
				}
			}
		}
	}
}
