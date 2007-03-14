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
    private String qcStatus;
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

    public String getQCStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
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

	@Override
	public String toString()
	{
		String str = "Genotype Findings search\n";
		
		if (qualityScore != null)
			str = str + "Quality Score: " + qualityScore + "\n";
		if (qcStatus != null)
			str = str + "QC Status: " + qcStatus + "\n";
		if (StudyParticipantCriteria != null)
			str = str + StudyParticipantCriteria.toString();
		
		str = str + super.toString();
		
		return str;
	}

}