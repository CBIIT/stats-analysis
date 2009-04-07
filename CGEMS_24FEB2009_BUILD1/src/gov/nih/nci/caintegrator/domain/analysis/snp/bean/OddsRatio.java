package gov.nih.nci.caintegrator.domain.analysis.snp.bean;
/**
 * The odds ratio is a measure of effect size particularly important in Bayesian statistics and logistic regression.
 * 
 * It is defined as the ratio of the odds of an event occurring in one group to the odds of it occurring in another group,
 * or to a sample-based estimate of that ratio. An odds ratio of 1 indicates that the condition or event under study is
 * equally likely in both groups. An odds ratio greater than 1 indicates that the condition or event is more likely in the
 * first group. And an odds ratio less than 1 indicates that the condition or event is less likely in the first group. The
 * odds ratio must be greater than or equal to zero. As the odds of the first group approaches zero, the odds ratio
 * approaches zero. As the odds of the second group approaches zero, the odds ratio approaches positive infinity.
 * 
 * 
 * 
 * @author sahnih
 * @version CVS $Revision: 1.3 $ $Date: 2007-10-24 11:30:35 $
 * 
 */
public class OddsRatio {

	/**
	 * lower 95% confidence bound for the heterozygote odds ratio. A confidence interval (CI) is a range around a measurement
	 * that conveys how precise the measurement is.
	 * 
	 */
	private Double heterozygoteLowerConfidenceBound;
	/**
	 * log-odds-ratios associated with heterozygous variant genotypes
	 * 
	 * 
	 */
	private Double heterozygoteOddsRatio;
	/**
	 * The standard error for the heterozygote odds ratio. Namely, it is the standard deviation of the difference between the
	 * measured or estimated odds ratio and the true values. Notice that the true value is, by definition, unknown and this
	 * implies that the standard error of an estimate is itself an estimated value.
	 * 
	 */
	private Double heterozygoteStandardError;
	/**
	 * upper 95% confidence bound for the heterozygote odds ratio.  A confidence interval (CI) is a range around a measurement
	 * that conveys how precise the measurement is.
	 * 
	 */
	private Double heterozygoteUpperConfidenceBound;
	/**
	 * lower 95% confidence bound for the homozygote odds ratio.  A confidence interval (CI) is a range around a measurement
	 * that conveys how precise the measurement is.
	 * 
	 */
	private Double homozygoteLowerConfidenceBound;
	/**
	 * log-odds-ratios associated with homozygous variant genotypes
	 * 
	 */
	private Double homozygoteOddsRatio;
	/**
	 * The standard error for the homozygote odds ratio. Namely, it is the standard deviation of the difference between the
	 * measured or estimated odds ratio and the true values. Notice that the true value is, by definition, unknown and this
	 * implies that the standard error of an estimate is itself an estimated value.
	 * 
	 */
	private Double homozygoteStandardError;
	/**
	 * upper 95% confidence bound for the homozygote odds ratio.  A confidence interval (CI) is a range around a measurement
	 * that conveys how precise the measurement is.
	 * 
	 */
	private Double homozygoteUpperConfidenceBound;
	/**
	 * Unique identifier
	 */
	private Long id;
	/**
	 * Name of the odds ratio object, usually describes the odds ratio groups
	 * 
	 */
	private String name;
	/**
	 * @return Returns the hetrozygoteOddsRatio.
	 */
	public Double getHeterozygoteOddsRatio() {
		return heterozygoteOddsRatio;
	}
	/**
	 * @param hetrozygoteOddsRatio The hetrozygoteOddsRatio to set.
	 */
	public void setHeterozygoteOddsRatio(Double heterozygoteOddsRatio) {
		this.heterozygoteOddsRatio = heterozygoteOddsRatio;
	}
	/**
	 * @return Returns the homozygoteOddsRatio.
	 */
	public Double getHomozygoteOddsRatio() {
		return homozygoteOddsRatio;
	}
	/**
	 * @param homozygoteOddsRatio The homozygoteOddsRatio to set.
	 */
	public void setHomozygoteOddsRatio(Double homozygoteOddsRatio) {
		this.homozygoteOddsRatio = homozygoteOddsRatio;
	}
	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the heterozygoteLowerConfidenceBound
	 */
	public Double getHeterozygoteLowerConfidenceBound() {
		return heterozygoteLowerConfidenceBound;
	}
	/**
	 * @param heterozygoteLowerConfidenceBound the heterozygoteLowerConfidenceBound to set
	 */
	public void setHeterozygoteLowerConfidenceBound(
			Double heterozygoteLowerConfidenceBound) {
		this.heterozygoteLowerConfidenceBound = heterozygoteLowerConfidenceBound;
	}
	/**
	 * @return the heterozygoteStandardError
	 */
	public Double getHeterozygoteStandardError() {
		return heterozygoteStandardError;
	}
	/**
	 * @param heterozygoteStandardError the heterozygoteStandardError to set
	 */
	public void setHeterozygoteStandardError(Double heterozygoteStandardError) {
		this.heterozygoteStandardError = heterozygoteStandardError;
	}
	/**
	 * @return the heterozygoteUpperConfidenceBound
	 */
	public Double getHeterozygoteUpperConfidenceBound() {
		return heterozygoteUpperConfidenceBound;
	}
	/**
	 * @param heterozygoteUpperConfidenceBound the heterozygoteUpperConfidenceBound to set
	 */
	public void setHeterozygoteUpperConfidenceBound(
			Double heterozygoteUpperConfidenceBound) {
		this.heterozygoteUpperConfidenceBound = heterozygoteUpperConfidenceBound;
	}
	/**
	 * @return the homozygoteLowerConfidenceBound
	 */
	public Double getHomozygoteLowerConfidenceBound() {
		return homozygoteLowerConfidenceBound;
	}
	/**
	 * @param homozygoteLowerConfidenceBound the homozygoteLowerConfidenceBound to set
	 */
	public void setHomozygoteLowerConfidenceBound(
			Double homozygoteLowerConfidenceBound) {
		this.homozygoteLowerConfidenceBound = homozygoteLowerConfidenceBound;
	}
	/**
	 * @return the homozygoteStandardError
	 */
	public Double getHomozygoteStandardError() {
		return homozygoteStandardError;
	}
	/**
	 * @param homozygoteStandardError the homozygoteStandardError to set
	 */
	public void setHomozygoteStandardError(Double homozygoteStandardError) {
		this.homozygoteStandardError = homozygoteStandardError;
	}
	/**
	 * @return the homozygoteUpperConfidenceBound
	 */
	public Double getHomozygoteUpperConfidenceBound() {
		return homozygoteUpperConfidenceBound;
	}
	/**
	 * @param homozygoteUpperConfidenceBound the homozygoteUpperConfidenceBound to set
	 */
	public void setHomozygoteUpperConfidenceBound(
			Double homozygoteUpperConfidenceBound) {
		this.homozygoteUpperConfidenceBound = homozygoteUpperConfidenceBound;
	}
}
