package gov.nih.nci.caintegrator.util.idmapping;

public class IdMapping implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String pdid;
	private String sampleId;
	private String tissue;
	private String fileName;
	private String platform;
	private String analysisFileId;
    private String aliquotbarcode;
    
	public String getAliquotbarcode() {
		return aliquotbarcode;
	}
	public void setAliquotbarcode(String aliquotbarcode) {
		this.aliquotbarcode = aliquotbarcode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPdid() {
		return pdid;
	}
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	
	
	
	
	public String getSampleId() {
		return sampleId;
	}
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}
	public String getTissue() {
		return tissue;
	}
	public void setTissue(String tissue) {
		this.tissue = tissue;
	}
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
     * @return the analysisFileId
     */
    public String getAnalysisFileId() {
        return analysisFileId;
    }
    /**
     * @param analysisFileId the analysisFileId to set
     */
    public void setAnalysisFileId(String analysisFileId) {
        this.analysisFileId = analysisFileId;
    }

}
