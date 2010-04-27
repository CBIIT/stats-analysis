package gov.nih.nci.caintegrator.domain.finding.geneExpression.pca;

import java.util.List;





/**
 * Representation of a principal component
 * @version 1.0
 * @created 18-Nov-2005 01:56:55 PM
 */
public class PrincipleComponent {

	private Long id;
	/**
	 * Index of principal component, starting from the one that has the highest proportion of variance. 
	 */
	private Integer index;
	private List<PrincipleComponent> principleComponent;

	public PrincipleComponent(){

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
	 * @return Returns the index.
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * @param index The index to set.
	 */
	public void setIndex(Integer index) {
		this.index = index;
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

}