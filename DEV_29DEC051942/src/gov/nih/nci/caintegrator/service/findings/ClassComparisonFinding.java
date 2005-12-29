package gov.nih.nci.caintegrator.service.findings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.SampleGroup;
import gov.nih.nci.caintegrator.dto.de.SampleIDDE;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;


public class ClassComparisonFinding extends AnalysisFinding{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClassComparisonResult myResults;
	private Collection<SampleIDDE> samplesNotFound;
	private Map reporterAnnotationsMap;
	
	public ClassComparisonFinding(String session, String task, FindingStatus status, ClassComparisonResult result) {
		super(session, task, status);
		setAnalysisResult(result);
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
	public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
		this.myResults = (ClassComparisonResult)results;
	}

	/**
	 * @return Returns the samplesNotFound.
	 */
	public Collection<SampleIDDE> getSamplesNotFound() {
		return samplesNotFound;
	}

	/**
	 * @param samplesNotFound The samplesNotFound to set.
	 */
	public void setSamplesNotFound(Collection<SampleIDDE> samplesNotFound) {
		this.samplesNotFound = samplesNotFound;
	}

	public Map getReporterAnnotationsMap() {
		return reporterAnnotationsMap;
	}

	public void setReporterAnnotationsMap(Map reporterResultsetMap) {
		this.reporterAnnotationsMap = reporterResultsetMap;
	}
	
}
