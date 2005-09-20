package gov.nih.nci.caintegrator.analysis.messaging;

/**
 * PrincipalComponentAnalysisResults are both in tabular and image form
 * @author Michael A. Harris
 *
 */
public class PrincipalComponentAnalysisResult extends AnalysisResult implements java.io.Serializable {

	private PCAresultEntry[] pcaArray;
	
	private byte[] image1Bytes = null;
	private byte[] image2Bytes = null;
	private byte[] image3Bytes = null;
	
	public PrincipalComponentAnalysisResult(int sessionId, int taskId) {
		super(sessionId, taskId);
	}
	
	public String toString() {
	  return "PrincipalComponentAnalysisResult: sessionId=" + getSessionId() + " taskId=" + getTaskId();
	}

	public void setPCAarray(PCAresultEntry[] pcaArray) {
	  this.pcaArray = pcaArray;
	}
	
	public PCAresultEntry[] getPCAarray() { return pcaArray; }

	public PCAresultEntry getPCAentry(int i) {
	  if ((i >= pcaArray.length)||(i < 0)) return null; 
	  return pcaArray[i];
	}
	
	public int getNumPCAentries() { return  pcaArray.length; }

	public byte[] getImage1Bytes() {
		return image1Bytes;
	}

	
	public void setImage1Bytes(byte[] imageBytes) {
		this.image1Bytes = imageBytes;
	}

	public byte[] getImage2Bytes() {
		return image2Bytes;
	}

	public void setImage2Bytes(byte[] image2Bytes) {
		this.image2Bytes = image2Bytes;
	}

	public byte[] getImage3Bytes() {
		return image3Bytes;
	}

	public void setImage3Bytes(byte[] image3Bytes) {
		this.image3Bytes = image3Bytes;
	}
	
}
