package gov.nih.nci.caintegrator.domain.cgems.study;

import gov.nih.nci.caintegrator.domain.cgems.analysis.snp.SNPAnalysisGroup;

import java.util.Set;
import java.util.HashSet;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */

public  class StudyParticipant implements java.io.Serializable {

	private static final long serialVersionUID = 1234567890L;

    private String caseControlStatus;

    public String getCaseControlStatus() {
          return caseControlStatus;
    }

    public void setCaseControlStatus(String caseControlStatus) {
          this.caseControlStatus = caseControlStatus;
    }

      /**
   * The subjects designation as a male or female based on a biological construct premised upon biological 
   * characteristics enabling sexual reproduction Values include: Female, Male, Unknown. 
   * 
   */

    private java.lang.String administrativeGenderCode;
    /**
   * The subjects designation as a male or female based on a biological construct premised upon biological 
   * characteristics enabling sexual reproduction Values include: Female, Male, Unknown. 
   * 
   */

	public  java.lang.String getAdministrativeGenderCode(){
        return administrativeGenderCode;
    }
    public void setAdministrativeGenderCode( java.lang.String administrativeGenderCode){
        this.administrativeGenderCode = administrativeGenderCode;
    }

    /**
   * The date when the Patient who was participating in the study died.
   */

    private java.lang.Integer ageAtDeath;

    /**
     * The date when the Patient who was participating in the study died.
     */

	public  java.lang.Integer getAgeAtDeath(){
        return ageAtDeath;
    }
    public void setAgeAtDeath( java.lang.Integer ageAtDeath){
        this.ageAtDeath = ageAtDeath;
    }

    /**
   * DOCUMENT ME!
   */

    private Integer ageAtDiagnosis;

    /**
   * DOCUMENT ME!
   */
	public Integer getAgeAtDiagnosis(){
        return ageAtDiagnosis;
    }
    public void setAgeAtDiagnosis(Integer ageAtDiagnosis){
        this.ageAtDiagnosis = ageAtDiagnosis;
    }

    /**
   * Age at the time of study enrollment, expressed in number of years completed at the last birthday. 
   * Value is collected to two decimal points of precision to meet Clinical Trials Monitoring Service 
   * (CTMS) reporting requirements. 
   * 
   */

    private java.lang.Integer ageAtEnrollment;
    /**
   * Age at the time of study enrollment, expressed in number of years completed at the last birthday. 
   * Value is collected to two decimal points of precision to meet Clinical Trials Monitoring Service 
   * (CTMS) reporting requirements. 
   * 
   */

	public  java.lang.Integer getAgeAtEnrollment(){
        return ageAtEnrollment;
    }
    public void setAgeAtEnrollment( java.lang.Integer ageAtEnrollment){
        this.ageAtEnrollment = ageAtEnrollment;
    }
	
    /**
   * The days when the patient is removed from the protocol, i.e., is not being followed and will not be 
   * retreated 
   * 
   */

    private java.lang.Integer daysOffStudy;
    /**
   * The days when the patient is removed from the protocol, i.e., is not being followed and will not be 
   * retreated 
   * 
   */

	public  java.lang.Integer getDaysOffStudy(){
        return daysOffStudy;
    }
    public void setDaysOffStudy( java.lang.Integer daysOffStudy){
        this.daysOffStudy = daysOffStudy;
    }

    /**
   * days on study from entry to death or last follow-up
   */

    private java.lang.Integer daysOnStudy;
    /**
   * days on study from entry to death or last follow-up
   */

	public  java.lang.Integer getDaysOnStudy(){
        return daysOnStudy;
    }
    public void setDaysOnStudy( java.lang.Integer daysOnStudy){
        this.daysOnStudy = daysOnStudy;
    }

    /**
   * The patient's self declared ethnic origination, independent of racial origination, based on OMB 
   * approved categories. Values include: Hispanic Or Latino, Unknown, Not reported, Not Hispanic 
   * Or Latino. 
   * 
   */

    private java.lang.String ethnicGroupCode;
    /**
   * The patient's self declared ethnic origination, independent of racial origination, based on OMB 
   * approved categories. Values include: Hispanic Or Latino, Unknown, Not reported, Not Hispanic 
   * Or Latino. 
   * 
   */

	public  java.lang.String getEthnicGroupCode(){
        return ethnicGroupCode;
    }
    public void setEthnicGroupCode( java.lang.String ethnicGroupCode){
        this.ethnicGroupCode = ethnicGroupCode;
    }

    /**
   * Indicator if at least one first-degree relative is affected by the disease of interest 
   * 
   */

    private java.lang.String familyHistory;
    /**
   * Indicator if at least one first-degree relative is affected by the disease of interest 
   * 
   */

	public  java.lang.String getFamilyHistory(){
        return familyHistory;
    }
    public void setFamilyHistory( java.lang.String familyHistory){
        this.familyHistory = familyHistory;
    }

    /**
   * DOCUMENT ME!
   */
    private java.lang.String id;

    /**
   * DOCUMENT ME!
   */
	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
    /**
   * DOCUMENT ME!
   */
    private java.lang.String institutionName;

    /**
   * DOCUMENT ME!
   */
	public  java.lang.String getInstitutionName(){
        return institutionName;
    }
    public void setInstitutionName( java.lang.String institutionName){
        this.institutionName = institutionName;
    }

    /**
   * DOCUMENT ME!
   */
    private java.lang.Boolean isOffStudy;

    /**
   * DOCUMENT ME!
   */
	public  java.lang.Boolean getIsOffStudy(){
        return isOffStudy;
    }
    public void setIsOffStudy( java.lang.Boolean isOffStudy){
        this.isOffStudy = isOffStudy;
    }

    /**
   * The patient's self declared racial origination, independent of ethnic origination, using OMB 
   * approved categories. Values include: Not Reported, American Indian or Alaska Native, Native Hawaiian 
   * or other Pacific Islander, Unknown, Asian, White, Black or African American. 
   * 
   */
    private java.lang.String raceCode;

    /**
   * The patient's self declared racial origination, independent of ethnic origination, using OMB 
   * approved categories. Values include: Not Reported, American Indian or Alaska Native, Native Hawaiian 
   * or other Pacific Islander, Unknown, Asian, White, Black or African American. 
   * 
   */
	public  java.lang.String getRaceCode(){
        return raceCode;
    }
    public void setRaceCode( java.lang.String raceCode){
        this.raceCode = raceCode;
    }

    /**
   * The unique number assigned to identify a patient on a study.
   */
    private java.lang.String studySubjectIdentifier;

    /**
   * The unique number assigned to identify a patient on a study.
   */
	public  java.lang.String getStudySubjectIdentifier(){
        return studySubjectIdentifier;
    }
    public void setStudySubjectIdentifier( java.lang.String studySubjectIdentifier){
        this.studySubjectIdentifier = studySubjectIdentifier;
    }

    /**
   * DOCUMENT ME!
   */
    private java.lang.Boolean survivalStatus;

    /**
   * DOCUMENT ME!
   */
	public  java.lang.Boolean getSurvivalStatus(){
        return survivalStatus;
    }
    public void setSurvivalStatus( java.lang.Boolean survivalStatus){
        this.survivalStatus = survivalStatus;
    }
	
   /**
   * The result of examination of tissues under the microscope to assist diagnosis of tumors. For example, 
   * after a biopsy is performed, a pathologist will perform a "histological" evaluation, which means 
   * the tissue collected will be analyzed for any abnormalities. 
   * 
   */

   /* TODO: Fix this: Ram
    private Set <Histology> histologyCollection = new HashSet<Histology>();
    public Set <Histology> getHistologyCollection(){
        return histologyCollection;
    }
    public void setHistologyCollection(Set<Histology> histologyCollection){
        this.histologyCollection = histologyCollection;
    }
   */

   /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */
    private Population population;

   /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */
    public Population getPopulation(){
        return population;			
    }
    public void setPopulation(Population population){
        this.population = population;
    }	

   /**

   */
    private Set<SNPAnalysisGroup> analysisGroupCollection = new HashSet<SNPAnalysisGroup>();
   /**

   */
   public Set <SNPAnalysisGroup> getAnalysisGroupCollection(){
        return analysisGroupCollection;
    }

    public void setAnalysisGroupCollection(Set<SNPAnalysisGroup> analysisGroupCollection){
        this.analysisGroupCollection = analysisGroupCollection;
    }

   /**

   */

   /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    private Study study;
   /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    public Study getStudy(){
        return study;			
    }

    public void setStudy(Study study){
        this.study = study;
    }	
    /**

   */

      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    private Set <Specimen> specimenCollection = new HashSet<Specimen>();
      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    public Set <Specimen> getSpecimenCollection(){
        return specimenCollection;
    }
    public void setSpecimenCollection(Set<Specimen> specimenCollection){
        this.specimenCollection = specimenCollection;
    }

    public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof StudyParticipant) {
				StudyParticipant c =(StudyParticipant)obj; 			 
				String thisId = getId();		
				
					if(thisId != null && thisId.equals(c.getId())) {
					   eq = true;
				    }		
				
			}
			return eq;
		}
		
		public int hashCode(){
			int h = 0;
			
			if(getId() != null) {
				h += getId().hashCode();
			}
			
			return h;
	}

      public String toString() {
          return "StudyParticipant{" +
                  "caseControlStatus='" + caseControlStatus + '\'' +
                  ", administrativeGenderCode='" + administrativeGenderCode + '\'' +
                  ", ageAtDeath=" + ageAtDeath +
                  ", ageAtDiagnosis=" + ageAtDiagnosis +
                  ", ageAtEnrollment=" + ageAtEnrollment +
                  ", daysOffStudy=" + daysOffStudy +
                  ", daysOnStudy=" + daysOnStudy +
                  ", ethnicGroupCode='" + ethnicGroupCode + '\'' +
                  ", familyHistory='" + familyHistory + '\'' +
                  ", id='" + id + '\'' +
                  ", institutionName='" + institutionName + '\'' +
                  ", isOffStudy=" + isOffStudy +
                  ", raceCode='" + raceCode + '\'' +
                  ", studySubjectIdentifier='" + studySubjectIdentifier + '\'' +
                  ", survivalStatus=" + survivalStatus +
                  ", population=" + population +
                  '}';
      }
  }