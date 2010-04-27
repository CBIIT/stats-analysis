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
	private Double hetrozygoteOddsRatio;
	private Double homozygoteOddsRatio;
	private String name;
	/**
	 * @return Returns the hetrozygoteOddsRatio.
	 */
	public Double getHetrozygoteOddsRatio() {
		return hetrozygoteOddsRatio;
	}
	/**
	 * @param hetrozygoteOddsRatio The hetrozygoteOddsRatio to set.
	 */
	public void setHetrozygoteOddsRatio(Double hetrozygoteOddsRatio) {
		this.hetrozygoteOddsRatio = hetrozygoteOddsRatio;
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
