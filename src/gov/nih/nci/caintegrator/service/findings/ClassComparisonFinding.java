/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.service.findings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.SampleGroup;
import gov.nih.nci.caintegrator.dto.de.SampleIDDE;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;




/**
* 
* 
*/

public class ClassComparisonFinding extends AnalysisFinding implements ReporterBasedFinding{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ClassComparisonResult myResults;
	private Collection<SampleIDDE> samplesNotFound;
	private Map reporterAnnotationsMap;
	
    public ClassComparisonFinding() {
        super(null, null, FindingStatus.Running);
    }
    
	public ClassComparisonFinding(String session, String task, FindingStatus status, ClassComparisonResult result) {
		super(session, task, status);
		setAnalysisResult(result);
	}
	
	
	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#arePvaluesAdjusted()
	 */
	public boolean arePvaluesAdjusted() {
		if(myResults != null){
			return myResults.arePvaluesAdjusted();
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getGroup1()
	 */
	public SampleGroup getGroup1() {
		if(myResults != null){
			return myResults.getGroup1();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getBaselineGroup()
	 */
	public SampleGroup getBaselineGroup() {
		if(myResults != null){
			return myResults.getBaselineGroup();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getNumResultEntries()
	 */
	public int getNumResultEntries() {
		if(myResults != null){
			return myResults.getNumResultEntries();
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult#getResultEntries()
	 */
	@SuppressWarnings("unchecked")
	public List<ClassComparisonResultEntry> getResultEntries() {
		if(myResults != null){
			return myResults.getResultEntries();
		}
		return (List<ClassComparisonResultEntry>) Collections.EMPTY_LIST;
	}

	/**
	 * @param myResults The myResults to set.
	 */
	public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
		super.setAnalysisResult(results);
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

	public List<String> getReporterIds() {
		List<String> idList = new ArrayList<String>();
		
		for (ClassComparisonResultEntry entry : getResultEntries()) {
		  idList.add(entry.getReporterId());
		}
		
		return idList;
	}

	
}
