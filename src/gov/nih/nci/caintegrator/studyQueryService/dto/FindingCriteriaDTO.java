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
    public int index;

    public FindingCriteriaDTO(){ }

    public AnnotationCriteria getAnnotationCriteria() {
        return AnnotationCriteria;
    }

    public void setAnnotationCriteria(AnnotationCriteria annotationCriteria) {
        AnnotationCriteria = annotationCriteria;
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}