/**
 * 
 */
package gov.nih.nci.caintegrator.domain.analysis.snp.bean;

/**
 * @author sahnih
 *
 */
public class OddsRatio {
	private Long id;
	private Double heterozygoteOddsRatio;
	private Double homozygoteOddsRatio;
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
}
