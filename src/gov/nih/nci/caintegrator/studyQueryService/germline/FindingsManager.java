package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;


import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
 */
public class FindingsManager {
    public static Collection<? extends Finding> getFindings(FindingCriteriaDTO findingCritDTO, int fromIndex, int toIndex)
    throws Exception {
        return findingCritDTO.getHandler().getFindings(
                findingCritDTO, fromIndex, toIndex);
    }

    public static void populateFindings(FindingCriteriaDTO findingCritDTO, List toBePopulated)
    throws Exception {
        findingCritDTO.getHandler().getFindingForFTP(findingCritDTO, toBePopulated);
    }

    public static Collection<StudyParticipant> getStudySubjects(StudyParticipantCriteria spCrit,
                                                      int fromIndex, int toIndex)  {
        SubjectSearchHandler handler = new SubjectSearchHandler();
        return handler.getStudySubjects(spCrit, fromIndex, toIndex);
    }

    public static void populateStudySubjects(StudyParticipantCriteria spCrit,List toBePopulated ) {
       SubjectSearchHandler handler = new SubjectSearchHandler();
       handler.populateFindings(spCrit, toBePopulated);
    }


    public static Collection<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
    throws Exception {
            return FindingsHandler.getSNPAnnotations(annotCrit);
    }

    public static Collection<Study> getStudies(StudyCriteria studyCrit)
    throws Exception {
        return ObjectQueryHandler.getStudyObjects(studyCrit);
    }

    public static Collection<SNPPanel> getPanels(StudyCriteria studyCrit)
    throws Exception {
        return ObjectQueryHandler.getPanelObjects(studyCrit);
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
    public static Collection<Population> getPopulations(PopulationCriteria populationCrit)
    throws Exception {
        return ObjectQueryHandler.getPopulationObjects(populationCrit);
    }
    public static Collection<SNPAssociationAnalysis> getSNPAssociationAnalysis(SNPAssociationAnalysisCriteria  assocCrit)
    throws Exception {
        return ObjectQueryHandler.getSNPAssociationAnalysisObjects(assocCrit);
    }
    public static Collection<SNPAnalysisGroup> getSNPAnalysisGroups(AnalysisGroupCriteria   analGrpCrit)
    throws Exception {
        return ObjectQueryHandler.getAnalysisGroups(analGrpCrit);
    }
    public static List<String> getChromosomes()
    throws Exception {
        return ObjectQueryHandler.getChromosomes();
    }

    public static Collection<String> getGenotypeFindingQCStatus() {
        return ObjectQueryHandler.getAllQCStatus();
    }

    public static Collection<String> getCaseControlStatus() {
        return ObjectQueryHandler.getCaseControlStatus();
    }

    public static Collection<Integer> getAgeLowerLimitValues() {
        return ObjectQueryHandler.getAgeLowerLimitValues();
    }

    public static Collection<Integer> getAgeUpperLimitValues() {
        return ObjectQueryHandler.getAgeUpperLimitValues();
    }


    /**
     * This method posts the Findings to an FTP site that is configured during application start up
     * @param email
     * @param findingCritDTO
     * @param fromIndex
     * @param toIndex
     * @throws Exception
     */
    public static void getFindingsViaFTP(String email, FindingCriteriaDTO findingCritDTO, int fromIndex, int toIndex)
    throws Exception {

    }



}
