package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResult;
import gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.GeneralizedLinearModelResult;
import gov.nih.nci.caintegrator.analysis.messaging.GeneralizedLinearModelResultEntry;
import gov.nih.nci.caintegrator.analysis.messaging.SampleGroup;
import gov.nih.nci.caintegrator.dto.de.SampleIDDE;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class GeneralizedLinearModelFinding extends AnalysisFinding implements
		ReporterBasedFinding {
	private static final long serialVersionUID = 1L;
	
	private GeneralizedLinearModelResult myResults;
	private Collection<SampleIDDE> samplesNotFound;
	private Map reporterAnnotationsMap;
	
	public GeneralizedLinearModelFinding() {
	        super(null, null, FindingStatus.Running);
	    }
	
	public GeneralizedLinearModelFinding(String session, String task, FindingStatus status, GeneralizedLinearModelResult result) {
		super(session, task, status);
		setAnalysisResult(result);
	}
	

	public int getNumResultEntries() {
		if(myResults != null){
			return myResults.getNumResultEntries();
		}
		return 0;
	}
	
	public List<GeneralizedLinearModelResultEntry> getResultEntries() {
		if(myResults != null){
			return myResults.getGlmResultEntries();
		}
		return (List<GeneralizedLinearModelResultEntry>) Collections.EMPTY_LIST;
	}
	
	
	/**
	 * @param myResults The myResults to set.
	 */
	public void setAnalysisResult(AnalysisResult results) throws ClassCastException{
		super.setAnalysisResult(results);
		this.myResults = (GeneralizedLinearModelResult)results;	
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

	public List<String> getReporterIds() {
         List<String> idList = new ArrayList<String>();
		
		     for (GeneralizedLinearModelResultEntry entry : getResultEntries()) {
		         idList.add(entry.getReporterId());
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
	
	public Map getReporterAnnotationsMap() {
		return reporterAnnotationsMap;
	}

	public void setReporterAnnotationsMap(Map reporterResultsetMap) {
		this.reporterAnnotationsMap = reporterResultsetMap;

	}

}
