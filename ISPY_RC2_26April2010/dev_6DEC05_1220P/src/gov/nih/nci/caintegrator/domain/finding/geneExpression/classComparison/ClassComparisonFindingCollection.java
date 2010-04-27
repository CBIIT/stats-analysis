package gov.nih.nci.caintegrator.domain.finding.geneExpression.classComparison;
import gov.nih.nci.caintegrator.domain.GeneExpressionFinding;





/**
 * A series of ClassComparisonFinding objects with reporters that are usually from the same array design.
 * @version 1.0
 * @created 18-Nov-2005 01:56:35 PM
 */
public class ClassComparisonFindingCollection extends GeneExpressionFinding {

	private ClassComparisonFinding classComparisonFinding;

	public ClassComparisonFindingCollection(){

	}

	/**
	 * @return Returns the classComparisonFinding.
	 */
	public ClassComparisonFinding getClassComparisonFinding() {
		return classComparisonFinding;
	}

	/**
	 * @param classComparisonFinding The classComparisonFinding to set.
	 */
	public void setClassComparisonFinding(
			ClassComparisonFinding classComparisonFinding) {
		this.classComparisonFinding = classComparisonFinding;
	}

}