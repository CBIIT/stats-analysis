package gov.nih.nci.caintegrator.domain.finding.geneExpression.pca;
import gov.nih.nci.caintegrator.domain.GeneExpressionAnalysis;





/**
 * @version 1.0
 * @created 18-Nov-2005 01:56:57 PM
 */
public class PrincipleConponentAnalysis extends GeneExpressionAnalysis {

	public enum ConstrainedType {Specimen, Reporter};
	private ConstrainedType constrainedBy;
	public PrincipleConponentAnalysis(){

	}
	/**
	 * @return Returns the constrainedBy.
	 */
	public ConstrainedType getConstrainedBy() {
		return constrainedBy;
	}
	/**
	 * @param constrainedBy The constrainedBy to set.
	 */
	public void setConstrainedBy(ConstrainedType constrainedBy) {
		this.constrainedBy = constrainedBy;
	}

}