package gov.nih.nci.caintegrator.util.idmapping;

import java.util.HashSet;
import java.util.Set;

public class IdMappingCriteria {
	private Set patientIds;
	private String platformName;
	private Set aliquotbarcode;
	private String fileName;
	private Set analysisFileIds;
	private String caseControlStatus;
	/**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
    /**
     * @return the analysisFileIds
     */
    public Set getAnalysisFileIds() {
        return analysisFileIds;
    }
    /**
     * @param analysisFileIds the analysisFileIds to set
     */
    public void setAnalysisFileIds(Set analysisFileIds) {
        this.analysisFileIds = analysisFileIds;
    }
    public Set getAliquotbarcode() {
		return aliquotbarcode;
	}
	public void setAliquotbarcode(Set aliquotbarcode) {
		this.aliquotbarcode = aliquotbarcode;
	}
	public Set getPatientIds() {
		return patientIds;
	}
	public void setPatientIds(Set patientIds) {
		this.patientIds = patientIds;
	}
	public String getPlatformName() {
		return platformName;
	}
	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	public String getCaseControlStatus() {
		return caseControlStatus;
	}
	public void setCaseControlStatus(String caseControlStatus) {
		this.caseControlStatus = caseControlStatus;
	}
	
}
