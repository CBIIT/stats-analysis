package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPFrequencyFindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 19, 2006
 * Time:   6:49:07 PM
 */
public class SNPFrequencyFindingTest extends GenotypeFindingTest {
    private SNPFrequencyFindingCriteriaDTO  freqDTO;
     protected StudyParticipantCriteria spCrit;
    protected void setUp() throws Exception {
        annotCrit = new AnnotationCriteria();
        freqDTO = new SNPFrequencyFindingCriteriaDTO();
        freqDTO.setAnnotationCriteria(annotCrit);
        spCrit = new StudyParticipantCriteria();

    }
    protected void setUpPopulationCriteria() {
        Collection<String> names = new ArrayList<String>();
        //names.add("CASE_ADVANCED");
        names.add("CASE_EARLY");
        PopulationCriteria popCrit = new PopulationCriteria(names);
        spCrit.setPopulationCriteria(popCrit);
     }

    public void testSNPFrequencyFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
       //setUpSNPPhysicalPositionCrit();
       //setUpDBSnpCrit();
       // setUpPanelCrit();

       // setUpGeneBiomarkerCrit();

        freqDTO.setMinorAlleleFrequency(new Float(1.0), ArithematicOperator.GE);
        freqDTO.setPopulationNames(new String[] {"CASE_EARLY"});

        // freqDTO.setCompletionRate(new Double(1.0), ArithematicOperator.GE);
        //freqDTO.setHardyWeinbergPValue(new Float(0.1), ArithematicOperator.LE);
        executeSNPFrequencyFindingSearch(0, 501);
   }

    public void testFTPSNPFrequencyFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
       //setUpSNPPhysicalPositionCrit();
       //setUpDBSnpCrit();
       // setUpPanelCrit();

       // setUpGeneBiomarkerCrit();

        //freqDTO.setMinorAlleleFrequency(new Float(1.0), ArithematicOperator.GE);
        freqDTO.setPopulationNames(new String[] {"CASE_EARLY", "CASE_ADVANCED"});

        // freqDTO.setCompletionRate(new Double(1.0), ArithematicOperator.GE);
        //freqDTO.setHardyWeinbergPValue(new Float(0.1), ArithematicOperator.LE);
        executeFTPSNPFrequencyFindingSearch();
   }

    private void executeFTPSNPFrequencyFindingSearch() {
           try {
               Collection<? extends Finding> findings = FindingsManager.getFindingsForFTP(freqDTO);
               System.out.println("RESULTS COUNT: " + findings.size());
           } catch (Throwable t)  {
                System.out.println("CGEMS Ex   ception: ");
                t.printStackTrace();
            }
    }
    private void executeSNPFrequencyFindingSearch(int startIndex, int endIndex) {
           try {
               Collection<? extends Finding> findings = FindingsManager.getFindings(freqDTO, startIndex, endIndex);
               System.out.println("RESULTS COUNT: " + findings.size());
               for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
                   SNPFrequencyFinding finding =  (SNPFrequencyFinding) iterator.next();
                   System.out.println("Completion Rate: " + finding.getCompletionRate());
                   System.out.println("HardyWeinbergPValue: " + finding.getHardyWeinbergPValue());
                   System.out.println("HeterozygoteCount: " + finding.getHeterozygoteCount());
                   System.out.println("MissingAlleleCount: " + finding.getMissingAlleleCount());
                   System.out.println("OtherAllele: " + finding.getOtherAllele());
                   System.out.println("OtherAlleleCount: " + finding.getOtherAlleleCount());
                   System.out.println("MissingGenotypeCount: " + finding.getMissingGenotypeCount());
                   System.out.println("MinorAlleleFrequency : " + finding.getMinorAlleleFrequency());
                   printSNPAnnotation(finding.getSnpAnnotation());
                   printPopulation(finding.getPopulation());
               }
               } catch (Throwable t)  {
             System.out.println("CGEMS Ex   ception: ");
             t.printStackTrace();
           }
    }
    protected void printSNPAnnotation(SNPAnnotation annot) {
        super.printSNPAnnotation(annot);
        Collection<GeneBiomarker> c = annot.getGeneBiomarkerCollection();
        for (Iterator<GeneBiomarker> iterator = c.iterator(); iterator.hasNext();) {
            GeneBiomarker geneBiomarker =  iterator.next();
            System.out.println("Biomarker: " + geneBiomarker.getHugoGeneSymbol());
        }
    }

    protected void printPopulation(Population p) {
        System.out.println("Population");
        System.out.println("        " + p);
    }
    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SNPFrequencyFindingTest.class));
        return suit;
    }

    public static void main (String[] args) {
        junit.textui.TestRunner.run(suite());

    }

}
