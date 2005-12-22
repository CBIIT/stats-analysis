package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * 
 * @created 18-Nov-2005 01:56:29 PM
 */
public class Activity {

	private Long id;
	/**
	 * Names assigned to health care procedures done for diagnostic, surveillance, treatment, palliation, or study-directed
	 * purposes. Values include: Bone Scan; Colonoscopy; CAT Scan; Biopsy; Flow Cytometry, Blood; Flow Cytometry, Bone Marrow;
	 * MRI; X-ray, Chest; Physical Examination, Positron Emission Tomography; MUGA Scan; Transrectal Ultrasound; Ultrasound;
	 * Flow cytometry.
	 * NOTE: Also maps to Test Name 2004448 and Procedure performed indicator	2006635.
	 * NOTE:  Should consider adding "Lab Draw" as a possible type of Procedure.
	 */
	private String name;
	/**
	 * Free format description of the protocol tracking activity worthy of documentation.
	 */
	private String description;
	/**
	 * The begin date of a measure or agent.
	 * NOTE: Also maps to Treatment Start Date  2003363, Blood Component Transfusion Date 2184925,  Dose modification start
	 * date 2006422, Off Study Date 2003605 when epochName=Off Study. Off Study Followup Date 2177930 when epochName = Off
	 * Study. Start Time 2004095.
	 * NOTE: Derived Dose Modification Interval 2006440 when stopDate - startDate.
	 * NOTE: Also maps to Lab Collection Time 2003580 and Specimen Collection Indicator 2006750.
	 */
	private Date startDate;
	/**
	 * The end date of a measure or agent.
	 * NOTE: Also maps to Treatment Phase End Date 2187546, Dose Modification End Date 2006438, Stop Time 2004139.
	 */
	private Date stopDate;
	/**
	 * Actual value that is paired with a unit of measure (hours, weeks, days) to express the length of time that an activity
	 * or event lasted.  
	 */
	private Long durationValue;
	/**
	 * Unit of Measure to express the length of time of an event or activity. Values include: MN - Minutes; HR - Hours; DY -
	 * Days; WK - Weeks;  CO - Course; MO - Month.
	 * NOTE: Also maps to Activity Duration in Hours and Minutes 2004163 with durationValue. Time Unit of Measure 2006693
	 */
	private String durationUnitOfMeasure;
	/**
	 * Text reason that a procedure is performed on an individual.
	 */
	private String reason;

	public Activity(){

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
	 * @return Returns the durationUnitOfMeasure.
	 */
	public String getDurationUnitOfMeasure() {
		return durationUnitOfMeasure;
	}

	/**
	 * @param durationUnitOfMeasure The durationUnitOfMeasure to set.
	 */
	public void setDurationUnitOfMeasure(String durationUnitOfMeasure) {
		this.durationUnitOfMeasure = durationUnitOfMeasure;
	}

	/**
	 * @return Returns the durationValue.
	 */
	public Long getDurationValue() {
		return durationValue;
	}

	/**
	 * @param durationValue The durationValue to set.
	 */
	public void setDurationValue(Long durationValue) {
		this.durationValue = durationValue;
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
	 * @return Returns the reason.
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason The reason to set.
	 */
	public void setReason(String reason) {
		this.reason = reason;
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

	/**
	 * @return Returns the stopDate.
	 */
	public Date getStopDate() {
		return stopDate;
	}

	/**
	 * @param stopDate The stopDate to set.
	 */
	public void setStopDate(Date stopDate) {
		this.stopDate = stopDate;
	}

}