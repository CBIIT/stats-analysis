package gov.nih.nci.caintegrator.studyQueryService.dto.germline;


import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;
import gov.nih.nci.caintegrator.studyQueryService.germline.SNPAssociationFindingsHandler;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.Collection;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 21, 2006
 * Time:   2:13:50 PM
 */

public class SNPAssociationFindingCriteriaDTO extends FindingCriteriaDTO {

    private Float pValue;
    private Integer rank;
    public AnalysisGroupCriteria analysisGroupCriteria;
    public Collection<SNPAssociationAnalysisCriteria> snpAssociationAnalysisCriteriaCollection;
    private ArithematicOperator pValueOperator;
    private ArithematicOperator rankOperator;

    public SNPAssociationFindingCriteriaDTO(StudyCriteria studyCriteria) throws Exception{
        super(studyCriteria);
    }

    public Float getpValue() {
        return pValue;
    }

    public void setpValue(Float pValue, ArithematicOperator pValueOperator) {
        this.pValue = pValue;
        this.pValueOperator = pValueOperator;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank, ArithematicOperator rankOperator) {
        this.rank = rank;
        this.rankOperator = rankOperator;
    }

    public AnalysisGroupCriteria getAnalysisGroupCriteria() {
        return analysisGroupCriteria;
    }

    public void setAnalysisGroupCriteria(AnalysisGroupCriteria analysisGroupCriteria) {
        this.analysisGroupCriteria = analysisGroupCriteria;
    }

    public Collection<SNPAssociationAnalysisCriteria> getSnpAssociationAnalysisCriteriaCollection() {
        return snpAssociationAnalysisCriteriaCollection;
    }

    public void setSnpAssociationAnalysisCriteriaCollection(Collection<SNPAssociationAnalysisCriteria> snpAssociationAnalysisCriteriaCollection) {
        this.snpAssociationAnalysisCriteriaCollection = snpAssociationAnalysisCriteriaCollection;
    }

    public ArithematicOperator getpValueOperator() {
        return pValueOperator;
    }

    public ArithematicOperator getRankOperator() {
        return rankOperator;
    }

    public FindingsHandler getHandler() {
        return new SNPAssociationFindingsHandler();
    }

	@Override
	public String toString()
	{	
		String str = "SNP Associations search\n";
		
		if (pValue != null)
			str = str + "pValue <= " + pValue + "\n";
		if (rank != null)
			str = str + "rank <= " + rank + "\n";
		if (analysisGroupCriteria != null)
			str = str + analysisGroupCriteria.toString();
		if (snpAssociationAnalysisCriteriaCollection != null)
		{
			str = str + "Analysis:\n";
			for(SNPAssociationAnalysisCriteria analysis : snpAssociationAnalysisCriteriaCollection)
			{
				if (analysis != null)
					str = str + analysis.getName() + "\n";
			}
		}
		
		str = str + super.toString();
		
		return str;
	}

}