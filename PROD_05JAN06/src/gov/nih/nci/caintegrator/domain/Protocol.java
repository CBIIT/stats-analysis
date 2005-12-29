package gov.nih.nci.caintegrator.domain;

import java.util.Date;





/**
 * A document that describes the objective(s), background and plan (including design, methodology, statistical
 * considerations and organization) of a Clinical Trial. It is the action plan for the conduct of a clinical trial.
 * @created 18-Nov-2005 01:56:58 PM
 */
public class Protocol {

	private Long id;
	/**
	 * The numeric or alphanumeric identification assigned to the study by the NCI. Inter-Group protocols should use the lead
	 * Groups protocol number.
	 */
	private String number;
	/**
	 * Descriptive text used to represent the long title or name of a protocol.
	 */
	private String longTitle;
	/**
	 * Title of a protocol limited to 30 characters in length.
	 * BRIDG: A name or abbreviated title by which the document is known.
	 */
	private String shortTitle;
	/**
	 * Date of IRB approval of the initial protocol version; the date the IRB Chair signs off on a protocol and patient
	 * enrollment can begin.
	 */
	private Date activationDate;
	/**
	 * Date of closure refers to the closing of a study to enrollment.  Patients enrolled on the study at the time of closure
	 * will continue their treatment plan.
	 */
	private Date closureDate;
	/**
	 * Date of the status change of a protocol to 'suspended', requiring that patient accrual be halted until the protocol is
	 * restored to fully active status.
	 */
	private Date suspensionDate;
	/**
	 * Coded designation of phase (I, II, III, or IV) for a clinical trial. Values include: I, I/II, II, III, NA.
	 */
	private String phaseCode;
	/**
	 * Codes to represent the status of a protocol in relation to the ability to enroll participants/patients. Values include:
	 * C: Closed, O: Open, S: Suspended, T: Terminated.
	 */
	private String statusCode;
	/**
	 * Codes to identify a type of protocol based upon its intent (genetic, diagnostic, preventive, etc.). Values include: D:
	 * Diagnostic Protocol, GN: Genetic Non-therapeutic Protocol, GT: Genetic Therapeutic Protocol, N: Therapeutic Protocol, P:
	 * Primary Treatment Protocol , S:  Supportive Protocol, T: Preventive Protocol.
	 */
	private String intentCode;
	/**
	 * Code to represent the monitor for a protocol. Values iclude: CTEP, CTEP - CTMS; CTEP - CDUS Complete; CTEP - CDUS
	 * Abbreviated; Pharmaceutical Company; Internal Monitor.
	 */
	private String monitorCode;
	/**
	 * Indicator of Yes (Y) or No (N) to specify if a protocol is blinded.
	 */
	private Boolean blindIndicator;
	/**
	 * Code to represent at a  summary level the category of disease treated on a protocol (Cancer, AIDS, and Benign disease).
	 * Values Include: A: AIDS, B: Benign, C: Cancer.
	 */
	private String diseaseCode;
	/**
	 * Code used to identify the sponsor (IND holder) for a clinical trial. Values include: AB  Abbott Labs; AL  Alkermes, Inc.
	 * ; APH  Angiotech; AM  Amgen; BF  Brian Fuller, MD; BI  Boehringer Ingelheim; BM Battelle Memorial, Inc.; BW  Burroughs
	 * Wellcome; CG Celgene; CL  CanLab Pharm Research; CP  CellPro, Inc.; CT  CTEP  Cancer Therapy Evaluation Program, NCI;
	 * DHF  Daniel H. Fowler, MD; EL  Eli Lilly; EV  Ellen Vitetta, MD; FJ  Fujisawa; GH  Genentech; GI  Gilead Sciences; GX
	 * Glaxo; HLR  Hoffman LaRoche; IM  Immunogen; IRC  Immune Response Corp; JA  Janssen; KN  Knoll; LP  The Liposome Company;
	 * ME  Medarex, Inc.; MGI  MGI Pharma, Inc.; MK  Merck and Co., Inc.; MT  Maria Turner, MD; NCI National Cancer Institute
	 * program; NI NIAID; PF  Pfizer; PG  Proctor & Gamble; RF  Robert Fenton, MD; RI  RIBI Immunochem; SA  Sandoz; SG Sugen,
	 * Inc.; SP  Schering-Plough; THN  Therion; TW  Thomas Waldmann, MD; TX  Texcellon; US  US Biosciences; VI	Vion
	 * Pharmaceuticals; WCE  W.C. Eckelman, MD; XE Xenova, Ltd.
	 */
	private String sponsorCode;
	/**
	 * A Yes/No response to indicate if a protocol is being conducted at more than one site concurrently.
	 */
	private Boolean multiInstitutionIndicator;
	/**
	 * Total number of patients/subjects/participants needed for protocol enrollment (accrual). 
	 */
	private Long targetAccrualNumber;
	/**
	 * A structured summary description of a protocol document.
	 */
	private String precis;
	/**
	 * BRIDG: A statement describing the overall rationale of the study [PR Group].
	 */
	private String statementOfPurpose;
	private StudyObjective studyObjective;

	public Protocol(){

	}

	/**
	 * @return Returns the activationDate.
	 */
	public Date getActivationDate() {
		return activationDate;
	}

	/**
	 * @param activationDate The activationDate to set.
	 */
	public void setActivationDate(Date activationDate) {
		this.activationDate = activationDate;
	}

	/**
	 * @return Returns the blindIndicator.
	 */
	public Boolean getBlindIndicator() {
		return blindIndicator;
	}

	/**
	 * @param blindIndicator The blindIndicator to set.
	 */
	public void setBlindIndicator(Boolean blindIndicator) {
		this.blindIndicator = blindIndicator;
	}

	/**
	 * @return Returns the closureDate.
	 */
	public Date getClosureDate() {
		return closureDate;
	}

	/**
	 * @param closureDate The closureDate to set.
	 */
	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	/**
	 * @return Returns the diseaseCode.
	 */
	public String getDiseaseCode() {
		return diseaseCode;
	}

	/**
	 * @param diseaseCode The diseaseCode to set.
	 */
	public void setDiseaseCode(String diseaseCode) {
		this.diseaseCode = diseaseCode;
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
	 * @return Returns the intentCode.
	 */
	public String getIntentCode() {
		return intentCode;
	}

	/**
	 * @param intentCode The intentCode to set.
	 */
	public void setIntentCode(String intentCode) {
		this.intentCode = intentCode;
	}

	/**
	 * @return Returns the longTitle.
	 */
	public String getLongTitle() {
		return longTitle;
	}

	/**
	 * @param longTitle The longTitle to set.
	 */
	public void setLongTitle(String longTitle) {
		this.longTitle = longTitle;
	}

	/**
	 * @return Returns the monitorCode.
	 */
	public String getMonitorCode() {
		return monitorCode;
	}

	/**
	 * @param monitorCode The monitorCode to set.
	 */
	public void setMonitorCode(String monitorCode) {
		this.monitorCode = monitorCode;
	}

	/**
	 * @return Returns the multiInstitutionIndicator.
	 */
	public Boolean getMultiInstitutionIndicator() {
		return multiInstitutionIndicator;
	}

	/**
	 * @param multiInstitutionIndicator The multiInstitutionIndicator to set.
	 */
	public void setMultiInstitutionIndicator(Boolean multiInstitutionIndicator) {
		this.multiInstitutionIndicator = multiInstitutionIndicator;
	}

	/**
	 * @return Returns the number.
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number The number to set.
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return Returns the phaseCode.
	 */
	public String getPhaseCode() {
		return phaseCode;
	}

	/**
	 * @param phaseCode The phaseCode to set.
	 */
	public void setPhaseCode(String phaseCode) {
		this.phaseCode = phaseCode;
	}

	/**
	 * @return Returns the precis.
	 */
	public String getPrecis() {
		return precis;
	}

	/**
	 * @param precis The precis to set.
	 */
	public void setPrecis(String precis) {
		this.precis = precis;
	}

	/**
	 * @return Returns the shortTitle.
	 */
	public String getShortTitle() {
		return shortTitle;
	}

	/**
	 * @param shortTitle The shortTitle to set.
	 */
	public void setShortTitle(String shortTitle) {
		this.shortTitle = shortTitle;
	}

	/**
	 * @return Returns the sponsorCode.
	 */
	public String getSponsorCode() {
		return sponsorCode;
	}

	/**
	 * @param sponsorCode The sponsorCode to set.
	 */
	public void setSponsorCode(String sponsorCode) {
		this.sponsorCode = sponsorCode;
	}

	/**
	 * @return Returns the statementOfPurpose.
	 */
	public String getStatementOfPurpose() {
		return statementOfPurpose;
	}

	/**
	 * @param statementOfPurpose The statementOfPurpose to set.
	 */
	public void setStatementOfPurpose(String statementOfPurpose) {
		this.statementOfPurpose = statementOfPurpose;
	}

	/**
	 * @return Returns the statusCode.
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode The statusCode to set.
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return Returns the studyObjective.
	 */
	public StudyObjective getStudyObjective() {
		return studyObjective;
	}

	/**
	 * @param studyObjective The studyObjective to set.
	 */
	public void setStudyObjective(StudyObjective studyObjective) {
		this.studyObjective = studyObjective;
	}

	/**
	 * @return Returns the suspensionDate.
	 */
	public Date getSuspensionDate() {
		return suspensionDate;
	}

	/**
	 * @param suspensionDate The suspensionDate to set.
	 */
	public void setSuspensionDate(Date suspensionDate) {
		this.suspensionDate = suspensionDate;
	}

	/**
	 * @return Returns the targetAccrualNumber.
	 */
	public Long getTargetAccrualNumber() {
		return targetAccrualNumber;
	}

	/**
	 * @param targetAccrualNumber The targetAccrualNumber to set.
	 */
	public void setTargetAccrualNumber(Long targetAccrualNumber) {
		this.targetAccrualNumber = targetAccrualNumber;
	}

}