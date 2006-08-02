package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;
import gov.nih.nci.caintegrator.studyQueryService.germline.GenotypeFindingsHandler;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/

public class GenotypeFindingCriteriaDTO extends FindingCriteriaDTO {

    private Float qualityScore;
    private String status;
    public ArithematicOperator operatorType = ArithematicOperator.EQ; //default
    public StudyParticipantCriteria StudyParticipantCriteria;

    public GenotypeFindingCriteriaDTO(){ }

    /**
     *
     * @param qualityScore
     * @param operator
     */
    public void setQualityScore(Float qualityScore,  ArithematicOperator operator){
        this.qualityScore = qualityScore;
        this.operatorType = operator;
    }

    public Float getQualityScore() {
        return qualityScore;
    }

    public String getStatus() {
        return status;
    }

    public ArithematicOperator getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(ArithematicOperator operatorType) {
        this.operatorType = operatorType;
    }

    public StudyParticipantCriteria getStudyParticipantCriteria() {
        return StudyParticipantCriteria;
    }

    public void setStudyParticipantCriteria(StudyParticipantCriteria studyParticipantCriteria) {
        StudyParticipantCriteria = studyParticipantCriteria;
    }

    public AnnotationCriteria getAnnotationCriteria() {
        return AnnotationCriteria;
    }

    public void setAnnotationCriteria(AnnotationCriteria annotationCriteria) {
        AnnotationCriteria = annotationCriteria;
    }

     public FindingsHandler getHandler() {
        return new GenotypeFindingsHandler();
    }

}