/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.FTestResult;
import gov.nih.nci.caintegrator.analysis.messaging.FTestResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.SampleGroup;
import gov.nih.nci.caintegrator.dto.de.SampleIDDE;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;




/**
* 
* 
*/

public class FTestFinding extends AnalysisFinding implements ReporterBasedFinding {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FTestResult myResults;
	private Collection<SampleIDDE> samplesNotFound;
	private Map reporterAnnotationsMap;
	
    public FTestFinding() {
        super(null, null, FindingStatus.Running);
    }
    
	public FTestFinding(String session, String task, FindingStatus status, FTestResult result) {
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
	@SuppressWarnings("unchecked")
	public List<SampleGroup> getSampleGroups() {
		if(myResults != null){
			return myResults.getSampleGroups();
		}
		return (List<SampleGroup>)Collections.EMPTY_LIST;
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
	public List<FTestResultEntry> getResultEntries() {
		if(myResults != null){
			return myResults.getResultEntries();
		}
		return (List<FTestResultEntry>)Collections.EMPTY_LIST;
	}


	/**
	 * @param myResults The myResults to set.
	 */
	public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
		super.setAnalysisResult(results);
		this.myResults = (FTestResult)results;
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
	  
	  for (FTestResultEntry re : getResultEntries()) {
	    idList.add(re.getReporterId());
	  }
	  
	  return idList;
	}
	
	@SuppressWarnings("unchecked")
	public List<String> getGroupNames() {
		if(myResults != null){
		  List<String> groupNames = new ArrayList<String>();
		  for(SampleGroup sg : myResults.getSampleGroups())	{
			  groupNames.add(sg.getGroupName());
		  }
		  return groupNames;
		}
		return (List<String>)Collections.EMPTY_LIST;
	}

	
}
