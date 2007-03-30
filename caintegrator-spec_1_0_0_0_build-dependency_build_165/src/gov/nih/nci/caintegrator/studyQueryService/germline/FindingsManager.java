package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel;
import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;

import java.util.Collection;
import java.util.List;
import java.util.Iterator;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
 */
public class FindingsManager {
    private ObjectQueryHandler objectQueryHandler;
    private FindingsHandler snpAssociationFindingsHandler;
    private SubjectSearchHandler subjectSearchHandler;

    public FindingsManager() {

    }
    public SubjectSearchHandler getSubjectSearchHandler() {
        return subjectSearchHandler;
    }

    public void setSubjectSearchHandler(SubjectSearchHandler subjectSearchHandler) {
        this.subjectSearchHandler = subjectSearchHandler;
    }

    public FindingsHandler getSnpAssociationFindingsHandler() {
        return snpAssociationFindingsHandler;
    }

    public void setSnpAssociationFindingsHandler(FindingsHandler snpAssociationFindingsHandler) {
        this.snpAssociationFindingsHandler = snpAssociationFindingsHandler;
    }
    public ObjectQueryHandler getObjectQueryHandler() {
        return objectQueryHandler;
    }

    public void setObjectQueryHandler(ObjectQueryHandler objectQueryHandler) {
        this.objectQueryHandler = objectQueryHandler;
    }

    public Collection<? extends Finding> getFindings(FindingCriteriaDTO findingCritDTO, int fromIndex, int toIndex)
    throws Exception {
        return findingCritDTO.getHandler().getFindings(findingCritDTO, fromIndex, toIndex);
    }

    public void populateFindings(FindingCriteriaDTO findingCritDTO, List toBePopulated)
    throws Exception {
        findingCritDTO.getHandler().getFindingForFTP(findingCritDTO, toBePopulated);
    }

    public Collection<StudyParticipant> getStudySubjects(StudyParticipantCriteria spCrit, int fromIndex, int toIndex) {
        return subjectSearchHandler.getStudySubjects(spCrit, fromIndex, toIndex);
    }

    public void populateStudySubjects(StudyParticipantCriteria spCrit,List toBePopulated ) {
       subjectSearchHandler.populateFindings(spCrit, toBePopulated);
    }


    public Collection<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
    throws Exception {
        /*  TODO: refer to the below method implementation  */
        return snpAssociationFindingsHandler.getSNPAnnotations(annotCrit);
    }

    public Collection<Study> getStudies(StudyCriteria studyCrit)
    throws Exception {
        return objectQueryHandler.getStudyObjects(studyCrit);
    }

    public Collection<SNPPanel> getPanels(StudyCriteria studyCrit)
    throws Exception {
        return objectQueryHandler.getPanelObjects(studyCrit);
    }

    /**
     * This method returns  Population objects based on criteria.  If criteria object is
     * passed in that does not have name criteria specified, this method will return <b>all</b>
     * Population Objects.  If name is specified in populationCrit, then this method returns
     * all population object that matches the names (or LIKE name)
     *
     * @param populationCrit
     * @return Collection of Population Objects
     * @throws Exception
     */
    public Collection<Population> getPopulations(PopulationCriteria populationCrit)
    throws Exception {
        return objectQueryHandler.getPopulationObjects(populationCrit);
    }
    public Collection<SNPAssociationAnalysis> getSNPAssociationAnalysis(SNPAssociationAnalysisCriteria  assocCrit)
    throws Exception {
        return objectQueryHandler.getSNPAssociationAnalysisObjects(assocCrit);
    }
    public Collection<SNPAnalysisGroup> getSNPAnalysisGroups(AnalysisGroupCriteria   analGrpCrit)
    throws Exception {
        return objectQueryHandler.getAnalysisGroups(analGrpCrit);
    }
    public List<String> getChromosomes()
    throws Exception {
        return objectQueryHandler.getChromosomes();
    }

    public Collection<String> getGenotypeFindingQCStatus() {
        return objectQueryHandler.getAllQCStatus();
    }

    public Collection<String> getCaseControlStatus(StudyCriteria studyCrit) {
        return objectQueryHandler.getCaseControlStatus(studyCrit);
    }

    public Collection<Integer> getAgeLowerLimitValues(StudyCriteria studyCrit) {
        return objectQueryHandler.getAgeLowerLimitValues( studyCrit);
    }

    public Collection<Integer> getAgeUpperLimitValues(StudyCriteria studyCrit) {
        return objectQueryHandler.getAgeUpperLimitValues( studyCrit);
    }
}
