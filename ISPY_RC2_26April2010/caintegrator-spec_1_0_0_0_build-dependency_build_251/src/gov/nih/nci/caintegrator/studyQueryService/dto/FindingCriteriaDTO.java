package gov.nih.nci.caintegrator.studyQueryService.dto;

import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;

/**
 * User: Ram Bhattaru
 * Date: Jul 6, 2006
 * Time: 4:13:49 PM
*/
public abstract class FindingCriteriaDTO {


    public AnnotationCriteria AnnotationCriteria;
    public StudyCriteria studyCriteria;
    private FindingsHandler handler;
    public int index;

    //public FindingCriteriaDTO(StudyCriteria studyCrit){ }
    public FindingCriteriaDTO() {
    }

    protected FindingCriteriaDTO(StudyCriteria studyCriteria) throws Exception {
        if (studyCriteria == null) throw new Exception("Study Criteria can not be null");
        this.studyCriteria = studyCriteria;
    }

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

    public StudyCriteria getStudyCriteria() {
        return studyCriteria;
    }

    public void setStudyCriteria(StudyCriteria studyCriteria) {
        this.studyCriteria = studyCriteria;
    }

    @Override
	public String toString()
	{
		String str = new String();
		
		if (AnnotationCriteria != null)
			str = str + AnnotationCriteria.toString();
		
		if (studyCriteria != null)
			str = str + studyCriteria.toString();
		
		return str;
	}

    public void setHandler(FindingsHandler handler) {
        this.handler = handler;
    }

    public FindingsHandler getHandler() {
        return handler;
    }

}