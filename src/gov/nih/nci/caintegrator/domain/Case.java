package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * The case describes a particular patient's status in the study.
 * @version 1.0
 * @created 18-Nov-2005 01:56:33 PM
 */
public class Case {

	private String race;
	private String ethnicity;
	private Integer ageAtDiagnosis;
	private Date dateOfDeath;
	private Date dateOffStudy;
	private String karnofskyScore;
	private String lanskyScore;

	public Case(){

	}

	/**
	 * @return Returns the ageAtDiagnosis.
	 */
	public Integer getAgeAtDiagnosis() {
		return ageAtDiagnosis;
	}

	/**
	 * @param ageAtDiagnosis The ageAtDiagnosis to set.
	 */
	public void setAgeAtDiagnosis(Integer ageAtDiagnosis) {
		this.ageAtDiagnosis = ageAtDiagnosis;
	}

	/**
	 * @return Returns the dateOfDeath.
	 */
	public Date getDateOfDeath() {
		return dateOfDeath;
	}

	/**
	 * @param dateOfDeath The dateOfDeath to set.
	 */
	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	/**
	 * @return Returns the dateOffStudy.
	 */
	public Date getDateOffStudy() {
		return dateOffStudy;
	}

	/**
	 * @param dateOffStudy The dateOffStudy to set.
	 */
	public void setDateOffStudy(Date dateOffStudy) {
		this.dateOffStudy = dateOffStudy;
	}

	/**
	 * @return Returns the ethnicity.
	 */
	public String getEthnicity() {
		return ethnicity;
	}

	/**
	 * @param ethnicity The ethnicity to set.
	 */
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}

	/**
	 * @return Returns the karnofskyScore.
	 */
	public String getKarnofskyScore() {
		return karnofskyScore;
	}

	/**
	 * @param karnofskyScore The karnofskyScore to set.
	 */
	public void setKarnofskyScore(String karnofskyScore) {
		this.karnofskyScore = karnofskyScore;
	}

	/**
	 * @return Returns the lanskyScore.
	 */
	public String getLanskyScore() {
		return lanskyScore;
	}

	/**
	 * @param lanskyScore The lanskyScore to set.
	 */
	public void setLanskyScore(String lanskyScore) {
		this.lanskyScore = lanskyScore;
	}

	/**
	 * @return Returns the race.
	 */
	public String getRace() {
		return race;
	}

	/**
	 * @param race The race to set.
	 */
	public void setRace(String race) {
		this.race = race;
	}

}