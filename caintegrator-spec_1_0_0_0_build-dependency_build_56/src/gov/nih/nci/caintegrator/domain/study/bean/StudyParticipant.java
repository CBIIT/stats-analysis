

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */

public  class StudyParticipant 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
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
   * Phenotype status of the subject relative to the disease of interest. Possible values: CONTROL, 
   * CASE, CASE_EARLY, CASE_ADVANCED, UNKNOWN 
   * 
   */

    private java.lang.String caseControlStatus;
    /**
   * Phenotype status of the subject relative to the disease of interest. Possible values: CONTROL, 
   * CASE, CASE_EARLY, CASE_ADVANCED, UNKNOWN 
   * 
   */

	public  java.lang.String getCaseControlStatus(){
        return caseControlStatus;
    }
    public void setCaseControlStatus( java.lang.String caseControlStatus){
        this.caseControlStatus = caseControlStatus;
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
   * Unique identifier for the instance of StudyParticipant.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of StudyParticipant.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The name of institution where patient is enrolled.
   */

    private java.lang.String institutionName;
    /**
   * The name of institution where patient is enrolled.
   */

	public  java.lang.String getInstitutionName(){
        return institutionName;
    }
    public void setInstitutionName( java.lang.String institutionName){
        this.institutionName = institutionName;
    }
	
	   
    /**
   * Indicates whether a patient is off study.
   */

    private java.lang.Boolean isOffStudy;
    /**
   * Indicates whether a patient is off study.
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
   * Indicates whether a patient is surviving.
   */

    private java.lang.String survivalStatus;
    /**
   * Indicates whether a patient is surviving.
   */

	public  java.lang.String getSurvivalStatus(){
        return survivalStatus;
    }
    public void setSurvivalStatus( java.lang.String survivalStatus){
        this.survivalStatus = survivalStatus;
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

	
	   
	   
	   
	      
			
			
			
			
      /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Population population;
      /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Population getPopulation(){
        return population;			
    }

	      
	               
	   

    public void setPopulation(gov.nih.nci.caintegrator.domain.study.bean.Population population){
        this.population = population;
    }	
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * A standard of basic quantity or increment represented by numeric value  
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement ageAtDeath;
      /**
   * A standard of basic quantity or increment represented by numeric value  
   */

    public gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getAgeAtDeath(){
        return ageAtDeath;			
    }

	      
	               
	   

    public void setAgeAtDeath(gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement ageAtDeath){
        this.ageAtDeath = ageAtDeath;
    }	
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Study study;
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Study getStudy(){
        return study;			
    }

	      
	               
	   

    public void setStudy(gov.nih.nci.caintegrator.domain.study.bean.Study study){
        this.study = study;
    }	
	   
	   
	
	   
	   
	   
	      
      /**
   * The secondary unique identifier assigned to identify a patient on a study.
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.SecondaryParticipantIdentifier> secondaryParticipantIdentifierCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.SecondaryParticipantIdentifier>();
      /**
   * The secondary unique identifier assigned to identify a patient on a study.
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.SecondaryParticipantIdentifier> getSecondaryParticipantIdentifierCollection(){
        return secondaryParticipantIdentifierCollection;
    }

	      
	               
	   
    public void setSecondaryParticipantIdentifierCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.SecondaryParticipantIdentifier> secondaryParticipantIdentifierCollection){
        this.secondaryParticipantIdentifierCollection = secondaryParticipantIdentifierCollection;
    }
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * A standard of basic quantity or increment represented by numeric value  
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement ageAtEnrollment;
      /**
   * A standard of basic quantity or increment represented by numeric value  
   */

    public gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getAgeAtEnrollment(){
        return ageAtEnrollment;			
    }

	      
	               
	   

    public void setAgeAtEnrollment(gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement ageAtEnrollment){
        this.ageAtEnrollment = ageAtEnrollment;
    }	
	   
	   
	
	   
	   
	   
	      
      /**
   * Indicates analysis tasks in the trial such as procdure or SubstanceAdministration. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Activity> activityCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Activity>();
      /**
   * Indicates analysis tasks in the trial such as procdure or SubstanceAdministration. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Activity> getActivityCollection(){
        return activityCollection;
    }

	      
	               
	   
    public void setActivityCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Activity> activityCollection){
        this.activityCollection = activityCollection;
    }
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * A standard of basic quantity or increment represented by numeric value  
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement ageAtDiagnosis;
      /**
   * A standard of basic quantity or increment represented by numeric value  
   */

    public gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getAgeAtDiagnosis(){
        return ageAtDiagnosis;			
    }

	      
	               
	   

    public void setAgeAtDiagnosis(gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement ageAtDiagnosis){
        this.ageAtDiagnosis = ageAtDiagnosis;
    }	
	   
	   
	
	   
	   
	   
	      
      /**
   * Representation of the analysis groups such as "CEPH Population" or "Non-Tumor Samples" 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup> analysisGroupCollection = new HashSet<gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup>();
      /**
   * Representation of the analysis groups such as "CEPH Population" or "Non-Tumor Samples" 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup> getAnalysisGroupCollection(){
        return analysisGroupCollection;
    }

	      
	               
	   
    public void setAnalysisGroupCollection(Set<gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup> analysisGroupCollection){
        this.analysisGroupCollection = analysisGroupCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Specimen> specimenCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Specimen>();
      /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Specimen> getSpecimenCollection(){
        return specimenCollection;
    }

	      
	               
	   
    public void setSpecimenCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Specimen> specimenCollection){
        this.specimenCollection = specimenCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * Results of a clinical analysis
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding> clinicalFindingCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding>();
      /**
   * Results of a clinical analysis
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding> getClinicalFindingCollection(){
        return clinicalFindingCollection;
    }

	      
	               
	   
    public void setClinicalFindingCollection(Set<gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding> clinicalFindingCollection){
        this.clinicalFindingCollection = clinicalFindingCollection;
    }


    public String toString() {
        return "StudyParticipant{" +
                "administrativeGenderCode='" + administrativeGenderCode + '\'' +
                ", caseControlStatus='" + caseControlStatus + '\'' +
                ", daysOffStudy=" + daysOffStudy +
                ", daysOnStudy=" + daysOnStudy +
                ", ethnicGroupCode='" + ethnicGroupCode + '\'' +
                ", familyHistory='" + familyHistory + '\'' +
                ", id='" + id + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", isOffStudy=" + isOffStudy +
                ", raceCode='" + raceCode + '\'' +
                ", studySubjectIdentifier='" + studySubjectIdentifier + '\'' +
                ", survivalStatus='" + survivalStatus + '\'' +
                ", population=" + population +
                '}';
    }
}