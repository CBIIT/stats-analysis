package gov.nih.nci.caintegrator.studyQueryService.dto.study;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;

import java.util.Collection;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/

public class StudyParticipantCriteria {
    private PopulationCriteria populationCriteria;
    private StudyCriteria studyCriteria;
    private AnalysisGroupCriteria analysisGroupCriteria;
    private Collection<String> administrativeGenderCodeCollection;
	private Integer lowerAgeLimit;
    private Integer upperAgeLimit;
    private Integer daysOffStudy;
	private Integer daysOnStudy;
	private Collection<String> ethnicGroupCodeCollection;
	private Collection<String> familyHistoryCollection;
	private Collection<String> institutionNameCollection;
	private Boolean isOffStudy;
	private Collection<String> raceCodeCollection;
	private Collection<String> studySubjectIdentifierCollection;
	private Boolean survivalStatus;
    private String caseControlStatus;

    public PopulationCriteria getPopulationCriteria() {
        return populationCriteria;
    }

    public String getCaseControlStatus() {
        return caseControlStatus;
    }

    public void setCaseControlStatus(String caseControlStatus) {
        this.caseControlStatus = caseControlStatus;
    }

    public void setPopulationCriteria(PopulationCriteria populationCriteria) {
        this.populationCriteria = populationCriteria;
    }

    public StudyCriteria getStudyCriteria() {
        return studyCriteria;
    }

    public void setStudyCriteria(StudyCriteria studyCriteria) {
        this.studyCriteria = studyCriteria;
    }


    public Integer getLowerAgeLimit() {
        return lowerAgeLimit;
    }

    public void setLowerAgeLimit(Integer lowerAgeLimit) {
        this.lowerAgeLimit = lowerAgeLimit;
    }

    public Integer getUpperAgeLimit() {
        return upperAgeLimit;
    }

    public void setUpperAgeLimit(Integer upperAgeLimit) {
        this.upperAgeLimit = upperAgeLimit;
    }

    public Integer getDaysOffStudy() {
        return daysOffStudy;
    }

    public void setDaysOffStudy(Integer daysOffStudy) {
        this.daysOffStudy = daysOffStudy;
    }

    public Integer getDaysOnStudy() {
        return daysOnStudy;
    }

    public void setDaysOnStudy(Integer daysOnStudy) {
        this.daysOnStudy = daysOnStudy;
    }

    public Collection<String> getEthnicGroupCodeCollection() {
        return ethnicGroupCodeCollection;
    }

    public void setEthnicGroupCodeCollection(Collection<String> ethnicGroupCodeCollection) {
        this.ethnicGroupCodeCollection = ethnicGroupCodeCollection;
    }

    public Collection<String> getFamilyHistoryCollection() {
        return familyHistoryCollection;
    }

    public void setFamilyHistoryCollection(Collection<String> familyHistoryCollection) {
        this.familyHistoryCollection = familyHistoryCollection;
    }

    public Collection<String> getInstitutionNameCollection() {
        return institutionNameCollection;
    }

    public void setInstitutionNameCollection(Collection<String> institutionNameCollection) {
        this.institutionNameCollection = institutionNameCollection;
    }

    public Boolean getOffStudy() {
        return isOffStudy;
    }

    public void setOffStudy(Boolean offStudy) {
        isOffStudy = offStudy;
    }

    public Collection<String> getRaceCodeCollection() {
        return raceCodeCollection;
    }

    public void setRaceCodeCollection(Collection<String> raceCodeCollection) {
        this.raceCodeCollection = raceCodeCollection;
    }

    public Collection<String> getStudySubjectIdentifierCollection() {
        return studySubjectIdentifierCollection;
    }

    public void setStudySubjectIdentifierCollection(Collection<String> studySubjectIdentifierCollection) {
        this.studySubjectIdentifierCollection = studySubjectIdentifierCollection;
    }

    public Boolean getSurvivalStatus() {
        return survivalStatus;
    }

    public void setSurvivalStatus(Boolean survivalStatus) {
        this.survivalStatus = survivalStatus;
    }

    public Collection<String> getAdministrativeGenderCodeCollection() {
        return administrativeGenderCodeCollection;
    }

    public void setAdministrativeGenderCodeCollection(Collection<String> administrativeGenderCodeCollection) {
        this.administrativeGenderCodeCollection = administrativeGenderCodeCollection;
    }

    public AnalysisGroupCriteria getAnalysisGroupCriteria() {
        return analysisGroupCriteria;
    }

    public void setAnalysisGroupCriteria(AnalysisGroupCriteria analysisGroupCriteria) {
        this.analysisGroupCriteria = analysisGroupCriteria;
    }

	@Override
	public String toString()
	{
		String str = "Subject search\n";
		
		if (studyCriteria != null)
			str = str + studyCriteria.toString();
		if (populationCriteria != null)
			str = str + populationCriteria.toString();
		if (analysisGroupCriteria != null)
			str = str + analysisGroupCriteria.toString();
		if (lowerAgeLimit != null)
			str = str + "Lower Age Limit: " + lowerAgeLimit + "\n";
		if (upperAgeLimit != null)
			str = str + "Upper Age Limit: " + upperAgeLimit + "\n";
		if (caseControlStatus != null)
			str = str + "Case Control Status: " + caseControlStatus + "\n";
		if ((administrativeGenderCodeCollection != null) && (administrativeGenderCodeCollection.size() > 0))
		{
			str = str + "Gender:\n";
			for (String gender : administrativeGenderCodeCollection)
			{
				str = str + gender + "\n";
			}
		}
		if ((familyHistoryCollection != null) && (familyHistoryCollection.size() > 0))
		{
			str = str + "Family History:\n";
			for (String history : familyHistoryCollection)
			{
				str = str + history + "\n";
			}
		}
		
		return str;
	}
}