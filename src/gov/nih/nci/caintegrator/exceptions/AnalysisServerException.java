package gov.nih.nci.caintegrator.exceptions;

/**
 * This exception will be thrown when an error occurs during
 * a computation on the analysis server. 
 * @author Michael A Harris
 *
 */
public class AnalysisServerException extends Throwable {

	public AnalysisServerException() {
	  super();
	}
	
	public AnalysisServerException(String info) {
	  super(info);
	}
	

}
