package gov.nih.nci.caintegrator.domain.finding.geneExpression.classComparison;
import java.util.Collection;

import gov.nih.nci.caintegrator.domain.Reporter;





/**
 * The outcome of a ClassComparisonAnalysis for a particular reporter.
 * @version 1.0
 * @created 18-Nov-2005 01:56:35 PM
 */
public class ClassComparisonFinding {

	/**
	 * The statistical significance of the difference. 
	 */
	private Float pValue;
	/**
	 * A measure of the magnitude of the difference in expression. 
	 */
	private Float foldChange;
	/**
	 * The statistical significance with consideration of multiple testing. 
	 */
	private Float adjustedPValue;
	private Collection<GroupAverage> groupAverage;
	private Reporter reporter;

	public ClassComparisonFinding(){

	}

	/**
	 * @return Returns the adjustedPValue.
	 */
	public Float getAdjustedPValue() {
		return adjustedPValue;
	}

	/**
	 * @param adjustedPValue The adjustedPValue to set.
	 */
	public void setAdjustedPValue(Float adjustedPValue) {
		this.adjustedPValue = adjustedPValue;
	}

	/**
	 * @return Returns the foldChange.
	 */
	public Float getFoldChange() {
		return foldChange;
	}

	/**
	 * @param foldChange The foldChange to set.
	 */
	public void setFoldChange(Float foldChange) {
		this.foldChange = foldChange;
	}

	/**
	 * @return Returns the groupAverage.
	 */
	public Collection<GroupAverage> getGroupAverage() {
		return groupAverage;
	}

	/**
	 * @param groupAverage The groupAverage to set.
	 */
	public void setGroupAverage(Collection<GroupAverage> groupAverage) {
		this.groupAverage = groupAverage;
	}

	/**
	 * @return Returns the pValue.
	 */
	public Float getPValue() {
		return pValue;
	}

	/**
	 * @param value The pValue to set.
	 */
	public void setPValue(Float value) {
		pValue = value;
	}

	/**
	 * @return Returns the reporter.
	 */
	public Reporter getReporter() {
		return reporter;
	}

	/**
	 * @param reporter The reporter to set.
	 */
	public void setReporter(Reporter reporter) {
		this.reporter = reporter;
	}

}