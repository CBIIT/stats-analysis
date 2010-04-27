package gov.nih.nci.caintegrator.domain.finding.geneExpression.classComparison;
import gov.nih.nci.caintegrator.domain.Reporter;





/**
 * Average of expression value of a ComparisonGroup for a particular reporter .
 * @version 1.0
 * @created 18-Nov-2005 01:56:48 PM
 */
public class GroupAverage {

	private Float value;
	private Reporter reporter;

	public GroupAverage(){

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

	/**
	 * @return Returns the value.
	 */
	public Float getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(Float value) {
		this.value = value;
	}

}