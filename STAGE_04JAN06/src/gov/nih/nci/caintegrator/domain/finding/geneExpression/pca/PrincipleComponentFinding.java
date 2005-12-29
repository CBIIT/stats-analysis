package gov.nih.nci.caintegrator.domain.finding.geneExpression.pca;
import java.util.List;
import java.util.Map;

import gov.nih.nci.caintegrator.domain.GeneExpressionFinding;





/**
 * Top level results from principal component analysis
 * @version 1.0
 * @created 18-Nov-2005 01:56:55 PM
 */
public class PrincipleComponentFinding extends GeneExpressionFinding {

	/**
	 * A series of float values each of which represents proportion of variance for each principal component. 
	 */
	private Map proportionOfVarianceCollection;
	private List<PrincipleComponentScoreSet> principleComponentScoreSet;
	private List<PrincipleComponent> principleComponent;

	public PrincipleComponentFinding(){

	}

	/**
	 * @return Returns the principleComponent.
	 */
	public List<PrincipleComponent> getPrincipleComponent() {
		return principleComponent;
	}

	/**
	 * @param principleComponent The principleComponent to set.
	 */
	public void setPrincipleComponent(List<PrincipleComponent> principleComponent) {
		this.principleComponent = principleComponent;
	}

	/**
	 * @return Returns the principleComponentScoreSet.
	 */
	public List<PrincipleComponentScoreSet> getPrincipleComponentScoreSet() {
		return principleComponentScoreSet;
	}

	/**
	 * @param principleComponentScoreSet The principleComponentScoreSet to set.
	 */
	public void setPrincipleComponentScoreSet(
			List<PrincipleComponentScoreSet> principleComponentScoreSet) {
		this.principleComponentScoreSet = principleComponentScoreSet;
	}

	/**
	 * @return Returns the proportionOfVarianceCollection.
	 */
	public Map getProportionOfVarianceCollection() {
		return proportionOfVarianceCollection;
	}

	/**
	 * @param proportionOfVarianceCollection The proportionOfVarianceCollection to set.
	 */
	public void setProportionOfVarianceCollection(Map proportionOfVarianceCollection) {
		this.proportionOfVarianceCollection = proportionOfVarianceCollection;
	}

}