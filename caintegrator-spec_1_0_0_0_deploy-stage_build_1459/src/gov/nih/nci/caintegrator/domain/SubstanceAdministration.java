package gov.nih.nci.caintegrator.domain;





/**
 * The schedule and route of applying, dispensing or giving agents or medications to subjects as prescribed within a
 * clinical trial protocol.
 * @created 18-Nov-2005 01:57:07 PM
 */
public class SubstanceAdministration extends Activity {

	/**
	 * The total dose of study drug given to the patient in the time period encompassed by the duration.
	 */
	private Long doseQuantity;
	/**
	 * Unit of measurement (UOM) used to express the amount of agent used in dosing.
	 * NOTE: Includes 110 Values.
	 */
	private String doseUnitOfMeasure;
	/**
	 * Name of an access route for administration of agents, evaluation of vital signs, etc. Values include:  Gastrostomy Tube,
	 * CIV Continuous Intravenous Infusion, IA Intra-Arterial, ID Intradermal, IH  Intrahepatic, IHI  Intrahepatic Infusion,
	 * IM  Intramuscular, Inhalatn  Inhalation, IP  Intraperitoneal, IT  Intrathecal, IV  Intravenous Bolus, IVI  Intravenous
	 * Fusion, NASAL, NG  Nasogastric, Oph Each  Ophthalmic, Each Eye ;  Oph Left  Ophthalmic, Left Eye; Oph Rt  Ophthalmic,
	 * Right Eye; PO  Oral, PR  Rectal, RT  Radiation, SC  Subcutaneous, SWSP  Swish & Spit, SWSW  Swish & Swallow, TOP
	 * Topical, INTUM  Intratumoral. 
	 */
	private String routeCode;
	/**
	 * The description of the therapy schedule. Values include:
	 * STAT Immediately, QD Every Day, BID Twice A Day, QID Four Times A Day, BIW Twice A Week, AC Before Meals, Q4HR Every 4
	 * Hours, Q8HR Every 8 Hours, PRN As Needed, QOD Every Other Day, TID Three Times A Day, HS At Bedtime, TIW Three Times A
	 * Week, PC After Meals, Q6HR Every 6 Hours, Q12HR Every 12 Hours
	 */
	private String medicationSchedule;
	/**
	 * The number of regular recurrences in a given time. Values include: Daily, Weekly, Monthly, Yearly, Never, Unknown, Some
	 * days (1-2 DAYS), Refused to answer the question.
	 */
	private String frequency;
	/**
	 * Value to represent the total dose administered of an agent within one day. 
	 */
	private Long totalDailyDose;
	/**
	 * A description of the modification of the dose. Values include: Agent Added, Agent Dose Decreased, Agent Dose Increased,
	 * Agent Dropped, Course Added, Course Decreased, Course Dropped, Course Increased, Cycle/Rotation Added, Cycle/Rotation
	 * Decreased, Cycle/Rotation Dropped, Cycle/Rotation Increased, Regimen Interrupted, Therapy Discontinued.
	 * 
	 * NOTE: Also maps to Dose Change Type	 2008137.
	 */
	private String doseModificationType;
	/**
	 * Value to represent a change in the plan for treatment dosage.  The change may be known or unknown, as well as planned
	 * or unplanned. Values include: 9 Unknown, 3 No, 1 Yes Planned, 2 Yes Unplanned.
	 */
	public enum DoseChangeType {Unknown, No, Yes, Planned, Unplanned};
	private DoseChangeType doseChangeType;
	/**
	 * Value that represents the total dose of an agent.  
	 */
	private Long totalDoseQuantity;

	public SubstanceAdministration(){

	}

	/**
	 * @return Returns the doseChangeType.
	 */
	public DoseChangeType getDoseChangeType() {
		return doseChangeType;
	}

	/**
	 * @param doseChangeType The doseChangeType to set.
	 */
	public void setDoseChangeType(DoseChangeType doseChangeType) {
		this.doseChangeType = doseChangeType;
	}

	/**
	 * @return Returns the doseModificationType.
	 */
	public String getDoseModificationType() {
		return doseModificationType;
	}

	/**
	 * @param doseModificationType The doseModificationType to set.
	 */
	public void setDoseModificationType(String doseModificationType) {
		this.doseModificationType = doseModificationType;
	}

	/**
	 * @return Returns the doseQuantity.
	 */
	public Long getDoseQuantity() {
		return doseQuantity;
	}

	/**
	 * @param doseQuantity The doseQuantity to set.
	 */
	public void setDoseQuantity(Long doseQuantity) {
		this.doseQuantity = doseQuantity;
	}

	/**
	 * @return Returns the doseUnitOfMeasure.
	 */
	public String getDoseUnitOfMeasure() {
		return doseUnitOfMeasure;
	}

	/**
	 * @param doseUnitOfMeasure The doseUnitOfMeasure to set.
	 */
	public void setDoseUnitOfMeasure(String doseUnitOfMeasure) {
		this.doseUnitOfMeasure = doseUnitOfMeasure;
	}

	/**
	 * @return Returns the frequency.
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency The frequency to set.
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	/**
	 * @return Returns the medicationSchedule.
	 */
	public String getMedicationSchedule() {
		return medicationSchedule;
	}

	/**
	 * @param medicationSchedule The medicationSchedule to set.
	 */
	public void setMedicationSchedule(String medicationSchedule) {
		this.medicationSchedule = medicationSchedule;
	}

	/**
	 * @return Returns the routeCode.
	 */
	public String getRouteCode() {
		return routeCode;
	}

	/**
	 * @param routeCode The routeCode to set.
	 */
	public void setRouteCode(String routeCode) {
		this.routeCode = routeCode;
	}

	/**
	 * @return Returns the totalDailyDose.
	 */
	public Long getTotalDailyDose() {
		return totalDailyDose;
	}

	/**
	 * @param totalDailyDose The totalDailyDose to set.
	 */
	public void setTotalDailyDose(Long totalDailyDose) {
		this.totalDailyDose = totalDailyDose;
	}

	/**
	 * @return Returns the totalDoseQuantity.
	 */
	public Long getTotalDoseQuantity() {
		return totalDoseQuantity;
	}

	/**
	 * @param totalDoseQuantity The totalDoseQuantity to set.
	 */
	public void setTotalDoseQuantity(Long totalDoseQuantity) {
		this.totalDoseQuantity = totalDoseQuantity;
	}

}