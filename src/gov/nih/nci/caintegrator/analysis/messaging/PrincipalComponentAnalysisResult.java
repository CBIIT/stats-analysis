package gov.nih.nci.caintegrator.analysis.messaging;

/**
 * PrincipalComponentAnalysisResults are both in tabular and image form
 * @author Michael A. Harris
 *
 */
public class PrincipalComponentAnalysisResult extends AnalysisResult implements java.io.Serializable {

	private PCAresultEntry[] pcaArray;
	
	private byte[] imageBytes = null;
	
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

	public byte[] getImageBytes() {
		return imageBytes;
	}

	
	public void setImageBytes(byte[] imageBytes) {
		this.imageBytes = imageBytes;
	}
	
}
