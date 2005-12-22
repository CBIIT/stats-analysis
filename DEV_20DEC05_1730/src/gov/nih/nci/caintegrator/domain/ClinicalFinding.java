package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * @version 1.0
 * @created 18-Nov-2005 01:56:38 PM
 */
public class ClinicalFinding extends Finding implements Clinical {

	/**
	 * The date Finding was recorded
	 */
	private Date date;

	public ClinicalFinding(){

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

}