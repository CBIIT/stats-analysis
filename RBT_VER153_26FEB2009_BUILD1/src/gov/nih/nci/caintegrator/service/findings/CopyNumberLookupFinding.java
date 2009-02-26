package gov.nih.nci.caintegrator.service.findings;

import gov.nih.nci.caintegrator.analysis.messaging.CopyNumberLookupResult;
import gov.nih.nci.caintegrator.analysis.messaging.DataPointVector;
import gov.nih.nci.caintegrator.analysis.messaging.DataPointVectorMeanComparator;
import gov.nih.nci.caintegrator.analysis.messaging.ExpressionLookupResult;
import gov.nih.nci.caintegrator.enumeration.FindingStatus;
import gov.nih.nci.caintegrator.service.findings.AnalysisFinding;
import gov.nih.nci.caintegrator.service.findings.ReporterBasedFinding;
import gov.nih.nci.caintegrator.service.findings.Finding;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Collections;

public class CopyNumberLookupFinding extends AnalysisFinding  {
	 
	//private Map reporterAnnotationsMap;
	//private List<DataPointVector> dataPointVectors = new ArrayList<DataPointVector>(); 
    
    public CopyNumberLookupFinding() {
        super(null, null, FindingStatus.Running);
    }

	public CopyNumberLookupFinding(String session, String task,
			FindingStatus status) {
		super(session, task, status);
	}

//	public List<String> getReporterIds() {
//		return Collections.emptyList();
//	}

//	public Map getReporterAnnotationsMap() {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	public void setReporterAnnotationsMap(Map reporterResultsetMap) {
//		// TODO Auto-generated method stub
//		
//	}
	
//	public void addDataPointVector(DataPointVector vector) {
//	  dataPointVectors.add(vector);
//	}
	
	public List<DataPointVector> getDataVectors() {
	  CopyNumberLookupResult result = (CopyNumberLookupResult) getAnalysisResult();
	  List<DataPointVector> retList = new ArrayList<DataPointVector>(result.getDataVectors());
	  return retList;
	  
	}
	
	public List<DataPointVector> getDataVectors(DataPointVectorMeanComparator comparator) {
		List<DataPointVector> vectors = getDataVectors();
		
		//sort by the comparator
		Collections.sort(vectors, comparator);
		
		return vectors;
		
	}
	

}
