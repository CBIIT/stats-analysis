package gov.nih.nci.caintegrator.service.findings;

import java.util.List;

import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.SampleGroup;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

public class ClassComparisonFinding extends AnalysisFinding{
	private ClassComparisonResult myResults;
	
	public ClassComparisonFinding(String session, String task, FindingStatus status, ClassComparisonResult result) {
		super(session, task, status);
		setMyResults(result);
	}
	
	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#arePvaluesAdjusted()
	 */
	public boolean arePvaluesAdjusted() {
		return myResults.arePvaluesAdjusted();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getGroup1()
	 */
	public SampleGroup getGroup1() {
		return myResults.getGroup1();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getGroup2()
	 */
	public SampleGroup getGroup2() {
		return myResults.getGroup2();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getNumResultEntries()
	 */
	public int getNumResultEntries() {
		return myResults.getNumResultEntries();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getResultEntries()
	 */
	public List<ClassComparisonResultEntry> getResultEntries() {
		return myResults.getResultEntries();
	}

	/**
	 * @param myResults The myResults to set.
	 */
	public void setMyResults(ClassComparisonResult myResults) {
		this.myResults = myResults;
	}

	/**
	 * @return Returns the myResults.
	 */
	public ClassComparisonResult getMyResults() {
		return myResults;
	}

	
}
