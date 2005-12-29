package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * A type of research activity that tests how well new medical treatments or other interventions work in subjects. Such
 * plans test new methods of screening, prevention, diagnosis or treatment of a disease. The specific plans are fully
 * defined in the protocol and may be carried out in a clinic or other medical facility.
 * 
 * @created 18-Nov-2005 01:57:02 PM
 */
public class Study {

	private Long id;
	/**
	 * The date when the study was initiated
	 */
	private Date startDate;
	/**
	 * The date when the study was completed
	 */
	private Date endDate;
	/**
	 * The unique identifier for the study assigned by the study sponsoring organization.
	 */
	private String sponsorStudyID;
	/**
	 * The free text field of the type of study being conducted. (CTEP)
	 */
	private String description;

	public Study(){

	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return Returns the endDate.
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate The endDate to set.
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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
	 * @return Returns the sponsorStudyID.
	 */
	public String getSponsorStudyID() {
		return sponsorStudyID;
	}

	/**
	 * @param sponsorStudyID The sponsorStudyID to set.
	 */
	public void setSponsorStudyID(String sponsorStudyID) {
		this.sponsorStudyID = sponsorStudyID;
	}

	/**
	 * @return Returns the startDate.
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate The startDate to set.
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

}