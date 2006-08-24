package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;


import java.util.Collection;
import java.util.List;

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

    public static Collection<StudyParticipant> getStudySubjects(StudyParticipantCriteria spCrit, int fromIndex, int toIndex)  {
        return SubjectSearchHandler.getStudySubjects(spCrit, fromIndex, toIndex);
    }

    public static Collection<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
    throws Exception {
            return FindingsHandler.getSNPAnnotations(annotCrit);
    }

    public static Collection<Study> getStudies(StudyCriteria studyCrit)
    throws Exception {
        return ObjectQueryHandler.getStudyObjects(studyCrit);
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

    public static List<String> getChromosomes()
    throws Exception {
        return ObjectQueryHandler.getChromosomes();
    }



}
