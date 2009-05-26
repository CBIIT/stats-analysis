package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * A set of univeriate genetic analysie to detect association between phenotypic
 * characteristics shared by groups of subjects and their genotypes at a series of
 * SNP loci.

 /**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
 */

public class SNPAssociationAnalysisCriteria {

	private String methods;
	private String name;
    private Long studyId;
    private String analysisCode;
    private Map<Long, List<String>> representCodeMap = new TreeMap<Long, List<String>>();
    public SNPAssociationAnalysisCriteria(Long studyId) {
        this.studyId = studyId;
    }

    public Long getStudyId() {
        return studyId;
    }

    public void setStudyId(Long studyId) {
        this.studyId = studyId;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	/**
	 * @return Returns the analysisCodes.
	 */
	public List<String> getAnalysisCodes() {
		return createAnalysisCodes();
	}

	public void addAnalysisMethodTypes(Long displayOrder, String representCode){
		if(displayOrder != null && representCode != null){
			List<String> representCodes = new ArrayList<String>();
			if(representCodeMap.containsKey(displayOrder)){
				representCodes = representCodeMap.get(displayOrder) ;
			}
			representCodes.add(representCode);
			representCodeMap.put(displayOrder,representCodes);
		}
	}
	private List<String> createAnalysisCodes(){
		List<String> analysisCodes = new ArrayList<String>();
		for(Long displayOrder:representCodeMap.keySet()){
			List<String> representCodes = representCodeMap.get(displayOrder);
				if(displayOrder == 1){
					//initial Entry so create new codes
					analysisCodes.addAll(representCodes);	
					
				}
				else{
					//not a new code so concatenade the codes to exsisting String
					List<String> newList = new ArrayList<String>();
					for (int i = 0; i < analysisCodes.size(); i++) {	
						String analysisCode = (String) analysisCodes.get(i);						
						for(String representCode: representCodes){
							String newCode =	analysisCode+representCode;
	//						//lists start at 0 so subtract 1
							newList.add(newCode);
						}
					}
					analysisCodes = newList;
				}
		}
		return analysisCodes;
	}

	/**
	 * @return Returns the analysisCode.
	 */
	public String getAnalysisCode() {
		return analysisCode;
	}

	/**
	 * @param analysisCode The analysisCode to set.
	 */
	public void setAnalysisCode(String analysisCode) {
		this.analysisCode = analysisCode;
	}

}                                   ;