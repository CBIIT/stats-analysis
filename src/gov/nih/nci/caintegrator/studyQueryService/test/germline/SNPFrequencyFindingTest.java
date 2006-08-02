package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.domain.finding.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.Population;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPFrequencyFindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 19, 2006
 * Time:   6:49:07 PM
 */
public class SNPFrequencyFindingTest extends GenotypeFindingTest {
    private SNPFrequencyFindingCriteriaDTO  freqDTO;
    protected void setUp() throws Exception {
        annotCrit = new AnnotationCriteria();
        freqDTO = new SNPFrequencyFindingCriteriaDTO();
        freqDTO.setAnnotationCriteria(annotCrit);

    }
    public void testSNPFrequencyFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
        setUpSNPPhysicalPositionCrit();
        setUpDBSnpCrit();
        setUpPanelCrit();
        setUpGeneBiomarkerCrit();

        freqDTO.setPopulationName("Mexican");

        executeSNPFrequencyFindingSearch(0, 10000);
   }

    private void executeSNPFrequencyFindingSearch(int startIndex, int endIndex) {
           try {
             Collection<? extends Finding> findings = FindingsManager.getFindings(freqDTO, startIndex, endIndex);
               for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
                   SNPFrequencyFinding finding =  (SNPFrequencyFinding) iterator.next();
                   System.out.println("Finding: " + finding);
                   printSNPAnnotation(finding.getSnpAnnotation());
                //   printPopulation(finding.getPopulation());
               }
               System.out.println("RESULTS COUNT: " + findings.size());
           } catch (Throwable t)  {
             System.out.println("CGEMS Exception: ");
             t.printStackTrace();
           }
    }
    protected void printPopulation(Population p) {
        System.out.println("Population");
        System.out.println("        " + p);
    }
    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SNPFrequencyFinding.class));
        return suit;
    }

    public static void main (String[] args) {
        junit.textui.TestRunner.run(suite());

    }

}
