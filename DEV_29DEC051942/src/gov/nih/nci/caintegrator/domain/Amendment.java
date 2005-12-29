package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * A written description of a change(s) to or formal clarification of a protocol.
 * @created 18-Nov-2005 01:56:31 PM
 */
public class Amendment {

	private Long id;
	/**
	 * Identifier to uniquely represent an amendment (version) of a protocol.
	 */
	private String identifier;
	/**
	 * Date of protocol amendment approval by IRB.  Amendments are versions of the original protocol document, each version
	 * with an eligibility checklist, informed consent, and complete revised protocol. 
	 */
	private Date date;

	public Amendment(){

	}

	/**
	 * @return Returns the date.
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date The date to set.
	 */
	public void setDate(Date date) {
		this.date = date;
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
	 * @return Returns the identifier.
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier The identifier to set.
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

}