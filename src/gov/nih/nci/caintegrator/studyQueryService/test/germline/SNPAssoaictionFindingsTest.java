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
        safDTO = new  SNPAssociationFindingCriteriaDTO(studyCrit);
        safDTO.setAnnotationCriteria(annotCrit);
    }

    public void testSNPAssocAnalysisFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
        setUpSNPPhysicalPositionCrit();
        //setUpDBSnpCrit();
        setUpPanelCrit();
        //setUpGeneBiomarkerCrit();

        //setSNPAssociationAnalysisCriteria();
        //setSNPAssociationGroupCriteria();

        setSNPFindingCriteria();
        studyCrit.setName("CGEMS Prostate Cancer WGAS Phase 1A");
        safDTO.setStudyCriteria(studyCrit);

        executeSearch(0, 501);
    }



    public Collection executeSearch(int startIndex, int endIndex) {
            try {
                Long t1 = System.currentTimeMillis();
                Collection<? extends Finding> findings = manager.getFindings(safDTO, startIndex, endIndex);
                System.out.println("RESULTS COUNT: " + findings.size());
                for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
                    SNPAssociationFinding finding =  (SNPAssociationFinding) iterator.next();

                    System.out.println("ID: " + finding.getId());
                    System.out.println("pValue" + finding.getPvalue());
                    System.out.println("Rank" + finding.getRank());
                    System.out.println("OrAggressiveHeterozygote: " + finding.getOrAggressiveHeterozygote());
                    System.out.println("OrAggressiveHomozygote: " + finding.getOrAggressiveHomozygote());
                    System.out.println("OrNonAggressiveHeterozygote: " + finding.getOrNonaggressiveHeterozygote());
                    System.out.println("OrNonAggressiveHomozygote: " + finding.getOrNonaggressiveHomozygote());

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
                System.out.println("Time Taken: " + (t2 - t1) + " ms" );
                return findings;
            } catch (Throwable t)  {
                System.out.println("CGEMS Exception: ");
                t.printStackTrace();
            }
        return null;
    }

    private void setSNPAssociationGroupCriteria() {
        AnalysisGroupCriteria groupCrit = new AnalysisGroupCriteria("CGEMS Prostate Cancer WGAS Phase 1");
        String[] names = new String[] {"Test Name for 9999", "Both Name And Method", "Only Name"};
        groupCrit.setNames(names);
        safDTO.setAnalysisGroupCriteria(groupCrit);
    }

    private void setSNPFindingCriteria() {
        //safDTO.setpValue(new Float(0.4), ArithematicOperator.LE);
        SNPAssociationAnalysisCriteria  assocCrit =
                new SNPAssociationAnalysisCriteria("CGEMS Prostate Cancer WGAS Phase 1A");
        assocCrit.setName("Incidence density sampling, Unadjusted score test");
        Collection<SNPAssociationAnalysisCriteria> list = new ArrayList<SNPAssociationAnalysisCriteria>();
        list.add(assocCrit);
        safDTO.setSnpAssociationAnalysisCriteriaCollection(list);
        safDTO.setRank(new Integer(1000), ArithematicOperator.LE);

    }

    private void setSNPAssociationAnalysisCriteria() {
        Collection analysisCrits = new ArrayList<SNPAssociationAnalysisCriteria>();

        SNPAssociationAnalysisCriteria methodAndNameCrit = new SNPAssociationAnalysisCriteria("CGEMS Prostate Cancer WGAS Phase 1");
        //methodAndNameCrit.setMethods("P-Test");
        methodAndNameCrit.setName("Incidence density sampling, Unadjusted score test");
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
        //setUpSNPPhysicalPositionCrit();
        //setUpGeneBiomarkerCrit();

       //setSNPAssociationAnalysisCriteria();
        
       //setSNPAssociationGroupCriteria();

        setUpPanelCrit();
        setSNPFindingCriteria();
        studyCrit.setName("CGEMS Prostate Cancer WGAS Phase 1A");
        safDTO.setStudyCriteria(studyCrit);

        try {
             HashSet actualBatchFindings = new HashSet();
             final List findingsToBePopulated =  Collections.synchronizedList(new ArrayList());
             new Thread(new Runnable() {
                 public void run() {
                     try {
                        manager.populateFindings(safDTO, findingsToBePopulated);
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
            boolean run = true;

            do {

                synchronized(findingsToBePopulated) {

                    if (findingsToBePopulated.size() > 0) {
                        run = true;
                         actualBatchFindings  = (HashSet) findingsToBePopulated.remove(0);
                         for (Iterator iterator = actualBatchFindings.iterator(); iterator.hasNext();) {
                            SNPAssociationFinding finding =  (SNPAssociationFinding) iterator.next();
                                    System.out.println("ID: " + finding.getId());
                                    System.out.println("pValue" + finding.getPvalue());
                                    System.out.println("Rank" + finding.getRank());
                                    System.out.println("DBSNP ID: " + finding.getSnpAnnotation().getDbsnpId());
                                    System.out.println("Analysis Name: " + finding.getSnpAssociationAnalysis().getName());
                                    System.out.println("Physical Position: " + finding.getSnpAnnotation().getChromosomeLocation());
                                    System.out.println("Chromosome: " + finding.getSnpAnnotation().getChromosomeName());
                                    System.out.print("Associated Genes: "  );
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
                for (Iterator iterator = findingsToBePopulated.iterator(); iterator.hasNext();) {
                   Object toBeGCed = iterator.next();
                   toBeGCed = null;
                }

                actualBatchFindings = null;

             }  while(true);

            System.out.println("ALL RESULTS WERE RECEIVED TOTAL: " + noOfResults);

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
