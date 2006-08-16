package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;


import java.util.Collection;

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

    public static Collection<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
    throws Exception {
        return FindingsHandler.getSNPAnnotations(annotCrit);
    }

    public static Collection<Study> getStudies(StudyCriteria studyCrit)
    throws Exception {
        return ObjectQueryHandler.getStudyObjects(studyCrit);
    }
}
