package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding;
import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.*;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 21, 2006
 * Time:   4:38:44 PM
 */
public class SNPAssoaictionFindingsTest extends GenotypeFindingTest {
    private SNPAssociationFindingCriteriaDTO safDTO;

    protected void setUp() throws Exception {
        annotCrit = new AnnotationCriteria();
        safDTO = new  SNPAssociationFindingCriteriaDTO();
        safDTO.setAnnotationCriteria(annotCrit);
    }
    public void testSNPAssocAnalysisFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
        setUpSNPPhysicalPositionCrit();
        setUpDBSnpCrit();
        setUpPanelCrit();
        setUpGeneBiomarkerCrit();

        setSNPAssociationAnalysisCriteria();
        setSNPAssociationGroupCriteria();
        setSNPFindingCriteria();
        executeSNPFrequencyFindingSearch(0, 50);
    }

    private void executeSNPFrequencyFindingSearch(int startIndex, int endIndex) {
            try {
                Collection<? extends Finding> findings = FindingsManager.getFindings(safDTO, startIndex, endIndex);
                for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
                    SNPAssociationFinding finding =  (SNPAssociationFinding) iterator.next();
                    System.out.println("RESULTS COUNT: " + findings.size());
                    System.out.println("ID: " + finding.getId());
                    System.out.println("pValue" + finding.getPvalue());
                    System.out.println("Rank" + finding.getRank());
                    System.out.println("SNP Association Analysis: " + finding.getSnpAssociationAnalysis());
                    System.out.println("SNP SNPAnalysisGroup: " + finding.getSnpAssociationAnalysis().getAnalysisGroupCollection());
                    System.out.println("SNP Annotation: ");
                    printSNPAnnotation(finding.getSnpAnnotation());
                }
            } catch (Throwable t)  {
                System.out.println("CGEMS Exception: ");
                t.printStackTrace();
            }
    }

    private void setSNPAssociationGroupCriteria() {
        AnalysisGroupCriteria groupCrit = new AnalysisGroupCriteria();
        String[] names = new String[] {"Test Name for 9999", "Both Name And Method", "Only Name"};
        groupCrit.setNames(names);
        safDTO.setAnalysisGroupCriteria(groupCrit);
    }

    private void setSNPFindingCriteria() {
        safDTO.setpValue(new Float(4.00), ArithematicOperator.GT);
        safDTO.setRank(new Integer(7), ArithematicOperator.LT);
    }

    private void setSNPAssociationAnalysisCriteria() {
        Collection analysisCrits = new ArrayList<SNPAssociationAnalysisCriteria>();

        SNPAssociationAnalysisCriteria methodAndNameCrit = new SNPAssociationAnalysisCriteria();
        methodAndNameCrit.setMethods("P-Test");
        methodAndNameCrit.setName("HigherOrder");
        analysisCrits.add(methodAndNameCrit);

        SNPAssociationAnalysisCriteria methodOnlyCrit = new SNPAssociationAnalysisCriteria();
        methodOnlyCrit.setMethods("Q-Test");
        analysisCrits.add(methodOnlyCrit);

        SNPAssociationAnalysisCriteria nameOnlyCrit = new SNPAssociationAnalysisCriteria();
        nameOnlyCrit.setName("Cluster");
        analysisCrits.add(nameOnlyCrit);

        safDTO.setSnpAssociationAnalysisCriteriaCollection(analysisCrits);
     }

}
