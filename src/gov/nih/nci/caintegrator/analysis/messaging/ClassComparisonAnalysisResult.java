package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;

/**
 * 
 * @author Michael A. Harris
 *
 */
public class ClassComparisonAnalysisResult extends AnalysisResult implements Serializable {

	private double[] resultArray;
	private double[][] arrayValues;
	private String[] columnNames;
	private String[] rowNames;
	
	public ClassComparisonAnalysisResult(String sessionId, String taskId, int numDoubles) {
		super(sessionId, taskId);
		//initArray(numDoubles);
	}
	
	public String toString() {
		  return "ClassComparisonAnalysisResult: sessionId=" + getSessionId() + " taskId=" + getTaskId();
    }
	
	public void setColumnNames(String[] columnNames) {
	  this.columnNames = columnNames;
	}
	
	public void setRowNames(String[] rowNames) {
	  this.rowNames = rowNames;
	}
	
	public void setArrayValues(double[][] arrayValues) {
	  this.arrayValues = arrayValues;
	}
	
	public String[] getRowNames() {
	  return rowNames;
	}
	
	public String[] getColumnNames() {
	  return columnNames;
	}
}
