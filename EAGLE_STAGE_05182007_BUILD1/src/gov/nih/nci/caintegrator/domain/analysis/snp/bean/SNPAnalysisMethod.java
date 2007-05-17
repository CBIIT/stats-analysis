/**
 * 
 */
package gov.nih.nci.caintegrator.domain.analysis.snp.bean;

/**
 * @author sahnih
 *
 */
public class SNPAnalysisMethod {
	private Long id;
	private String methodDescription;
	private String methodName;
	private String methodType;
	private String represensitiveCode;
	private String studyName;
	private Long displayOrder;
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
	 * @return Returns the methodDescription.
	 */
	public String getMethodDescription() {
		return methodDescription;
	}
	/**
	 * @param methodDescription The methodDescription to set.
	 */
	public void setMethodDescription(String methodDescription) {
		this.methodDescription = methodDescription;
	}
	/**
	 * @return Returns the methodName.
	 */
	public String getMethodName() {
		return methodName;
	}
	/**
	 * @param methodName The methodName to set.
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	/**
	 * @return Returns the methodType.
	 */
	public String getMethodType() {
		return methodType;
	}
	/**
	 * @param methodType The methodType to set.
	 */
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}
	/**
	 * @return Returns the represensitiveCode.
	 */
	public String getRepresensitiveCode() {
		return represensitiveCode;
	}
	/**
	 * @param represensitiveCode The represensitiveCode to set.
	 */
	public void setRepresensitiveCode(String represensitiveCode) {
		this.represensitiveCode = represensitiveCode;
	}
	/**
	 * @return Returns the studyName.
	 */
	public String getStudyName() {
		return studyName;
	}
	/**
	 * @param studyName The studyName to set.
	 */
	public void setStudyName(String studyName) {
		this.studyName = studyName;
	}
	/**
	 * @return Returns the displayOrder.
	 */
	public Long getDisplayOrder() {
		return displayOrder;
	}
	/**
	 * @param displayOrder The displayOrder to set.
	 */
	public void setDisplayOrder(Long displayOrder) {
		this.displayOrder = displayOrder;
	}
}
