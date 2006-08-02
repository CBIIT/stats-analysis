package gov.nih.nci.caintegrator.studyQueryService.dto;

import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;

/**
 * User: Ram Bhattaru
 * Date: Jul 6, 2006
 * Time: 4:13:49 PM
*/
public abstract class FindingCriteriaDTO {

    abstract public FindingsHandler getHandler();

    public AnnotationCriteria AnnotationCriteria;

    public FindingCriteriaDTO(){ }

    public AnnotationCriteria getAnnotationCriteria() {
        return AnnotationCriteria;
    }

    public void setAnnotationCriteria(AnnotationCriteria annotationCriteria) {
        AnnotationCriteria = annotationCriteria;
    }

}