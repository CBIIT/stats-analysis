package gov.nih.nci.cgems.dto;

import gov.nih.nci.cgems.service.FindingsHandler;
import gov.nih.nci.cgems.dto.AnnotationCriteria;

/**
 * User: Ram Bhattaru
 * Date: Jul 6, 2006
 * Time: 4:13:49 PM
*/
public abstract class CGEMSFindingCriteriaDTO {

    abstract public FindingsHandler getHandler();

    public AnnotationCriteria AnnotationCriteria;

    public CGEMSFindingCriteriaDTO(){ }

    public AnnotationCriteria getAnnotationCriteria() {
        return AnnotationCriteria;
    }

    public void setAnnotationCriteria(AnnotationCriteria annotationCriteria) {
        AnnotationCriteria = annotationCriteria;
    }

}