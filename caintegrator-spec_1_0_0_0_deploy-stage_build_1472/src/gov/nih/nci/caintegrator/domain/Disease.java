package gov.nih.nci.caintegrator.domain;





/**
 * An impairment of the normal state of a living animal or an organ or its parts that interrupts or modifies the
 * performance of the vital functions of a subject and is a response to environmental factors, specific infective agents
 * or inherent defects of the organism or a combination of these factors.
 * @created 18-Nov-2005 01:56:42 PM
 */
public class Disease {

	private Long id;
	/**
	 * The unique number assigned to a disease based on Clinical Data Update System (CDUS) Disease Coding.
	 * NOTE: Also maps to Body System Type 2002895
	 */
	private String code;
	/**
	 * Name of site(s) within the body targeted for procedures or interventions; multiple contiguous sites within the same
	 * organ system may be referenced.
	 */
	private String bodySiteName;

	public Disease(){

	}

	/**
	 * @return Returns the bodySiteName.
	 */
	public String getBodySiteName() {
		return bodySiteName;
	}

	/**
	 * @param bodySiteName The bodySiteName to set.
	 */
	public void setBodySiteName(String bodySiteName) {
		this.bodySiteName = bodySiteName;
	}

	/**
	 * @return Returns the code.
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code The code to set.
	 */
	public void setCode(String code) {
		this.code = code;
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

}