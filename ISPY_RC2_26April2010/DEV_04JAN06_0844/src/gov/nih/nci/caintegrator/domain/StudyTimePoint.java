package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * An ordered list of times at which events and activities are planned to occur during a clinical trial.
 * @created 18-Nov-2005 01:57:04 PM
 */
public class StudyTimePoint {

	private Long id;
	/**
	 * Proposed purpose for a visit to a healthcare setting. Values include: Routine Exam, Breast Lump, Nipple Discharge,
	 * Abnormal Mammogram, Breast Pain, Followup Previous Condition, Other, Genetic Counseling. 
	 */
	private String visitName;
	/**
	 * Description of a reason of 'Other' for the purpose of a visit to a healthcare facility.
	 * NOTE: Maps to Medical History Description 2003874 when epochName = Prior.
	 * 
	 */
	private String visitDescription;
	/**
	 * Number of the course (cycle) of treatment the patient received.
	 */
	private Long courseNumber;
	/**
	 * The begin date for a course (cycle) of a protocol.
	 */
	private Date courseStartDate;
	/**
	 * The date that a course (cycle) as defined by a protocol is completed.
	 */
	private Date courseStopDate;
	/**
	 * A particular day in a course (cycle) of study-directed activity.
	 */
	private Long courseDayNumber;
	/**
	 * Status of a course (cycle) of treatment.  A "completed" course (cycle) is one which has been conducted in accordance
	 * with the protocol with respect to length (two day variance allowed). A course (cycle) is regarded as "discontinued" if
	 * it was shorter than specified in the protocol.
	 */
	private String courseDisposition;

	public StudyTimePoint(){

	}

	/**
	 * @return Returns the courseDayNumber.
	 */
	public Long getCourseDayNumber() {
		return courseDayNumber;
	}

	/**
	 * @param courseDayNumber The courseDayNumber to set.
	 */
	public void setCourseDayNumber(Long courseDayNumber) {
		this.courseDayNumber = courseDayNumber;
	}

	/**
	 * @return Returns the courseDisposition.
	 */
	public String getCourseDisposition() {
		return courseDisposition;
	}

	/**
	 * @param courseDisposition The courseDisposition to set.
	 */
	public void setCourseDisposition(String courseDisposition) {
		this.courseDisposition = courseDisposition;
	}

	/**
	 * @return Returns the courseNumber.
	 */
	public Long getCourseNumber() {
		return courseNumber;
	}

	/**
	 * @param courseNumber The courseNumber to set.
	 */
	public void setCourseNumber(Long courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * @return Returns the courseStartDate.
	 */
	public Date getCourseStartDate() {
		return courseStartDate;
	}

	/**
	 * @param courseStartDate The courseStartDate to set.
	 */
	public void setCourseStartDate(Date courseStartDate) {
		this.courseStartDate = courseStartDate;
	}

	/**
	 * @return Returns the courseStopDate.
	 */
	public Date getCourseStopDate() {
		return courseStopDate;
	}

	/**
	 * @param courseStopDate The courseStopDate to set.
	 */
	public void setCourseStopDate(Date courseStopDate) {
		this.courseStopDate = courseStopDate;
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
	 * @return Returns the visitDescription.
	 */
	public String getVisitDescription() {
		return visitDescription;
	}

	/**
	 * @param visitDescription The visitDescription to set.
	 */
	public void setVisitDescription(String visitDescription) {
		this.visitDescription = visitDescription;
	}

	/**
	 * @return Returns the visitName.
	 */
	public String getVisitName() {
		return visitName;
	}

	/**
	 * @param visitName The visitName to set.
	 */
	public void setVisitName(String visitName) {
		this.visitName = visitName;
	}

}