package gov.nih.nci.caintegrator.domain.finding.geneExpression.pca;

import java.util.List;





/**
 * Each PrincipalComponentScoreSet is a set of PrincipalComponentScores that represent one BioAssayData and can be used as
 * coordinates for graphic display.
 * @version 1.0
 * @created 18-Nov-2005 01:56:56 PM
 */
public class PrincipleComponentScoreSet {

	private List<PrincipleComponentScoreSet> principleComponentScoreSet;
	private PrincipalComponentScore principalComponentScore;

	public PrincipleComponentScoreSet(){

	}

	/**
	 * @return Returns the principalComponentScore.
	 */
	public PrincipalComponentScore getPrincipalComponentScore() {
		return principalComponentScore;
	}

	/**
	 * @param principalComponentScore The principalComponentScore to set.
	 */
	public void setPrincipalComponentScore(
			PrincipalComponentScore principalComponentScore) {
		this.principalComponentScore = principalComponentScore;
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

}