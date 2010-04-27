package gov.nih.nci.caintegrator.domain.finding.geneExpression.classComparison;
import gov.nih.nci.caintegrator.domain.GeneExpressionAnalysis;





/**
 * A type of analysis that determine the significance and/or magnitude of the difference between groups of biological
 * specimen of which the gene expression is measured by BioAssays.
 * @version 1.0
 * @created 18-Nov-2005 01:56:34 PM
 */
public class ClassComparisonAnalysis extends GeneExpressionAnalysis {

	/**
	 * The experimental factor that distinguishes the ComparisonGroups. 
	 */
	private String groupingFactor;
	/**
	 * Type of statistical test used for measuring the significance. 
	 */
	private String statisticType;
	/**
	 * Type of procedure used for correction of p-value due to multiple testing. 
	 */
	private String multipleTestAgjustment;

	public ClassComparisonAnalysis(){

	}

	/**
	 * @return Returns the groupingFactor.
	 */
	public String getGroupingFactor() {
		return groupingFactor;
	}

	/**
	 * @param groupingFactor The groupingFactor to set.
	 */
	public void setGroupingFactor(String groupingFactor) {
		this.groupingFactor = groupingFactor;
	}

	/**
	 * @return Returns the multipleTestAgjustment.
	 */
	public String getMultipleTestAgjustment() {
		return multipleTestAgjustment;
	}

	/**
	 * @param multipleTestAgjustment The multipleTestAgjustment to set.
	 */
	public void setMultipleTestAgjustment(String multipleTestAgjustment) {
		this.multipleTestAgjustment = multipleTestAgjustment;
	}

	/**
	 * @return Returns the statisticType.
	 */
	public String getStatisticType() {
		return statisticType;
	}

	/**
	 * @param statisticType The statisticType to set.
	 */
	public void setStatisticType(String statisticType) {
		this.statisticType = statisticType;
	}

}