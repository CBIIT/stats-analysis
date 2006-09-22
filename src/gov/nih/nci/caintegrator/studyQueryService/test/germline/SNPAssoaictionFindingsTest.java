package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding;
import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.*;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.*;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 21, 2006
 * Time:   4:38:44 PM
 */
public class SNPAssoaictionFindingsTest extends CGEMSTest {
    private SNPAssociationFindingCriteriaDTO safDTO;

    public void setUp() throws Exception {
        super.setUp();
        safDTO = new  SNPAssociationFindingCriteriaDTO();
        safDTO.setAnnotationCriteria(annotCrit);
    }
    public void testAll() {
        super.testAll();
    }

    public void testSNPAssocAnalysisFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
       setUpSNPPhysicalPositionCrit();
        //setUpDBSnpCrit();
        //setUpPanelCrit();
        //setUpGeneBiomarkerCrit();

        //setSNPAssociationAnalysisCriteria();
        //setSNPAssociationGroupCriteria();

        //setSNPFindingCriteria();
        //executeSNPAssoaictionFindingsSearch(500, 1000);
    }



    public Collection executeSearch(int startIndex, int endIndex) {
            try {
                Long t1 = System.currentTimeMillis();
                Collection<? extends Finding> findings = FindingsManager.getFindings(safDTO, startIndex, endIndex);
                /*System.out.println("RESULTS COUNT: " + findings.size());
                for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
                    SNPAssociationFinding finding =  (SNPAssociationFinding) iterator.next();

                    System.out.println("ID: " + finding.getId());
                    System.out.println("pValue" + finding.getPvalue());
                    System.out.println("Rank" + finding.getRank());
                    System.out.println("DBSNP ID: " + finding.getSnpAnnotation().getDbsnpId());
                    System.out.println("Analysis Name: " + finding.getSnpAssociationAnalysis().getName());
                    System.out.println("Physical Position: " + finding.getSnpAnnotation().getChromosomeLocation());
                    System.out.println("Chromosome: " + finding.getSnpAnnotation().getChromosomeName());
                    System.out.print("Associated Genes: "  );

                    Collection<GeneBiomarker> bioMarkers = finding.getSnpAnnotation().getGeneBiomarkerCollection();
                    for (Iterator<GeneBiomarker> iterator1 = bioMarkers.iterator(); iterator1.hasNext();) {
                        GeneBiomarker geneBiomarker =  iterator1.next();
                        System.out.println(geneBiomarker.getHugoGeneSymbol() + " ");
                    }
                 }
                 Long t2 = System.currentTimeMillis();
                System.out.println("Time Taken: " + (t2 - t1) + " ms" );*/
                return findings;
            } catch (Throwable t)  {
                System.out.println("CGEMS Exception: ");
                t.printStackTrace();
            }
        return null;
    }

    private void setSNPAssociationGroupCriteria() {
        AnalysisGroupCriteria groupCrit = new AnalysisGroupCriteria();
        String[] names = new String[] {"Test Name for 9999", "Both Name And Method", "Only Name"};
        groupCrit.setNames(names);
        safDTO.setAnalysisGroupCriteria(groupCrit);
    }

    private void setSNPFindingCriteria() {
        //safDTO.setpValue(new Float(0.4), ArithematicOperator.LE);
        safDTO.setRank(new Integer(800), ArithematicOperator.LT);
    }

    private void setSNPAssociationAnalysisCriteria() {
        Collection analysisCrits = new ArrayList<SNPAssociationAnalysisCriteria>();

        SNPAssociationAnalysisCriteria methodAndNameCrit = new SNPAssociationAnalysisCriteria();
        //methodAndNameCrit.setMethods("P-Test");
        methodAndNameCrit.setName("score test");
        analysisCrits.add(methodAndNameCrit);

   /*     SNPAssociationAnalysisCriteria methodOnlyCrit = new SNPAssociationAnalysisCriteria();
        methodOnlyCrit.setMethods("Q-Test");
        analysisCrits.add(methodOnlyCrit);

        SNPAssociationAnalysisCriteria nameOnlyCrit = new SNPAssociationAnalysisCriteria();
        nameOnlyCrit.setName("Cluster");
        analysisCrits.add(nameOnlyCrit);
*/
        safDTO.setSnpAssociationAnalysisCriteriaCollection(analysisCrits);
     }

    public void testPopulateFindings() {
        setUpSNPPhysicalPositionCrit();
        setSNPFindingCriteria();
        try {
             HashSet actualBatchFindings = new HashSet();
             final List findingsToBePopulated =  Collections.synchronizedList(new ArrayList());
             new Thread(new Runnable() {
                 public void run() {
                     try {
                        FindingsManager.populateFindings(safDTO, findingsToBePopulated);
                     } catch(Throwable t) {
                         t.printStackTrace();
                         System.out.println("Error from FindingsManager.populateFindings call: ");
                     }
                 }
                       }
            ).start();

            boolean sleep = true;
            int count = 1;
            int noOfResults = 0;
            do {
                synchronized(findingsToBePopulated) {
                    if (findingsToBePopulated.size() > 0) {
                         actualBatchFindings  = (HashSet) findingsToBePopulated.remove(0);
                         for (Iterator iterator = actualBatchFindings.iterator(); iterator.hasNext();) {
                            SNPAssociationFinding sf =  (SNPAssociationFinding) iterator.next();
                            System.out.print("ID: " + sf.getId());
                            System.out.print("  pValue" + sf.getPvalue() + "\n\n");
                         }
                         noOfResults += actualBatchFindings.size();
                         System.out.println("WRITTEN BATCH: " + count++ + " SIZE: " +
                                                          actualBatchFindings.size() + "\n\n");
                         if (actualBatchFindings.size() == 0) {
                            /* means no more to results are coming.  Finished */
                             break;
                         }
                     }
                 }
                 Thread.currentThread().sleep(10);

             }  while(true);

            System.out.println("ALL RESULTS WERE RECEIVED TOTAL: " + noOfResults);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
