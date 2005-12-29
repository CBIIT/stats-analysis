package gov.nih.nci.caintegrator.domain.finding.geneExpression.pca;
import gov.nih.nci.caintegrator.domain.Reporter;





/**
 * Co-efficients that represent contribution of original variables to a principal component.
 * @version 1.0
 * @created 18-Nov-2005 01:56:53 PM
 */
public class PrincicalComponentLoad {

	/**
	 * loading value co-efficient that represent contribution of original variables to a principal component. 
	 */
	private Double value;
	private Reporter reporter;

	public PrincicalComponentLoad(){

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
	public Double getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(Double value) {
		this.value = value;
	}

}