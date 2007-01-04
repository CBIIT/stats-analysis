package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding;
import gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.study.bean.DNASpecimen;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.PhysicalPositionCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.GenotypeFindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.PanelCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 6, 2006
 * Time:   5:53:05 PM
 */

public class GenotypeFindingTest extends CGEMSTest {
   // protected AnnotationCriteria annotCrit;
    private GenotypeFindingCriteriaDTO gfDTO;
   // protected static int TOTAL_FINDINGS = 0;


    public void setUp() throws Exception {
        super.setUp();
        gfDTO = new GenotypeFindingCriteriaDTO();
        gfDTO.setAnnotationCriteria(annotCrit);
        gfDTO.setStudyParticipantCriteria(spCrit);
    }

    public void testAll() {
        super.testAll();
    }



    private void setUpGenotypeCrit() {
        //gfDTO.setQualityScore(new Float(0.50), ArithematicOperator.LT);
        gfDTO.setQcStatus("QC+");
    }
    protected void setUpSNPPhysicalPositionCrit() {
        PhysicalPositionCriteria ppc = new PhysicalPositionCriteria();
/*
        ppc.setChromosome("8");
        ppc.setStartPosition(new Integer(76065000));  // 76065158
        ppc.setEndPosition(new Integer(76075000));    // should give 4 GenotypeFindings

*/
        ppc.setChromosome("8");
        ppc.setStartPosition(new Long(76065000));  // 76065158
        ppc.setEndPosition(new Long(76080000));    // should give 4 GenotypeFindings

        /*
        ppc.setChromosome("X");
        ppc.setStartPosition(new Long(2693518));   // entire chromosome
        ppc.setEndPosition(new Long(154493116));
        */

        annotCrit.setPhysicalPositionCriteria(ppc);

    }
    private void setUpSNPHugoGeneSymbolCrit() {
       Collection<String> geneSymbols = new ArrayList();
       //geneSymbols.add()
       annotCrit.setGeneSymbols(geneSymbols);
    }
    protected void setUpDBSnpCrit() {
        Collection<String> dbSNPIds = new ArrayList<String>();
        //dbSNPIds.add("rs10215692");
        //dbSNPIds.add("rs10216611");
        //dbSNPIds.add("rs10170496");
        dbSNPIds.add("rs7867544");
        //dbSNPIds.add("rs1160166");
        //dbSNPIds.add("rs10504944");
        annotCrit.setSnpIdentifiers(dbSNPIds );
    }

    public void testSNPAnnotCrit() {
        setUpSNPPhysicalPositionCrit();
        executeGenotypeFindingSearch(0, 60);
    }

    protected void setUpPanelCrit() {
        PanelCriteria p = new PanelCriteria();
        p.setName("HumanHap300");
        p.setVersion("1.1");
        annotCrit.setPanelCriteria(p);
    }

    public void testPanelCrit() {
        setUpPanelCrit();
        setUpDBSnpCrit();
        executeGenotypeFindingSearch(0, 60);
    }

    public void testDBSnpCrit() {
        setUpDBSnpCrit();
        executeGenotypeFindingSearch(0, 60);
    }
    public void testPanelAndSNPAnnotCrit() {
        setUpPanelCrit();
        setUpSNPPhysicalPositionCrit();
        executeGenotypeFindingSearch(0, 60);
    }
    protected void setUpGeneBiomarkerCrit() {
        Collection<String> geneSymbols = new ArrayList<String> ();
        //geneSymbols.add(new String("USP48"));
        //geneSymbols.add(new String("HSPG2"));
        geneSymbols.add(new String("MET"));



        //geneSymbols.add(new String("blimp"));
/*        geneSymbols.add("MFAP5");
        geneSymbols.add("BPIL2");
        geneSymbols.add("IVL");
        geneSymbols.add("SPRR2A");
        geneSymbols.add("SPRR2B");
        geneSymbols.add("CHST8");
        geneSymbols.add("D4ST1");
        geneSymbols.add("CALM3");
        geneSymbols.add("DNAH12");
        geneSymbols.add("DNAH7");
        geneSymbols.add("ACHE");
        geneSymbols.add("APBB1");
        geneSymbols.add("APOE");
        geneSymbols.add("MAPK8IP2");
        geneSymbols.add("INHA");
        geneSymbols.add("INHBA");
        geneSymbols.add("INHBB");
        geneSymbols.add("CAMK2D");
        geneSymbols.add("CDC2L1");
        geneSymbols.add("CDC2L2");
        geneSymbols.add("CHAD");
        geneSymbols.add("CISH");
        geneSymbols.add("COVA1");
        geneSymbols.add("CTGF");
        geneSymbols.add("CYR61");
        geneSymbols.add("ESM1");
        geneSymbols.add("FGFRL1");
        geneSymbols.add("GAP43");
        geneSymbols.add("IFNG");
        geneSymbols.add("IGFBP1");
        geneSymbols.add("IGFBP3");
        geneSymbols.add("IGFBP7");
        geneSymbols.add("LTBP4");
        geneSymbols.add("MAC30");
        geneSymbols.add("MORF4L1");
        geneSymbols.add("NDN");
        geneSymbols.add("NEDD9");
        geneSymbols.add("OGFR");
        geneSymbols.add("OSM");
        geneSymbols.add("PAPPA2");
        geneSymbols.add("PLCE1");
        geneSymbols.add("PRSS11");
        geneSymbols.add("QSCN6");
        geneSymbols.add("SHC1");
        geneSymbols.add("SOCS1");
        geneSymbols.add("SOCS3");
        geneSymbols.add("SOCS4");
        geneSymbols.add("SOCS5");
        geneSymbols.add("SOCS6");
        geneSymbols.add("SOCS7");
        geneSymbols.add("TPSB2");
        geneSymbols.add("TU3A");
        geneSymbols.add("VEGFB");
        geneSymbols.add("WISP1");
        geneSymbols.add("WISP3");
        geneSymbols.add("PPP1R9B");
        geneSymbols.add("HAO1");
        geneSymbols.add("HAO2");

        geneSymbols.add("ADORA1");
        geneSymbols.add("ADORA2A");
        geneSymbols.add("ADORA2B");
        geneSymbols.add("ADORA3");
        geneSymbols.add("ADRA1B");
        geneSymbols.add("ADRA1D");
        geneSymbols.add("ADRA2B");
        geneSymbols.add("ADRA2C");
        geneSymbols.add("ADRB1");
        geneSymbols.add("ADRB3");
        geneSymbols.add("AGTR1");
        geneSymbols.add("AGTR2");
        geneSymbols.add("AGTRL1");
        geneSymbols.add("AVPR1B");
        geneSymbols.add("BDKRB1");
        geneSymbols.add("BDKRB2");
        geneSymbols.add("BLR1");
        geneSymbols.add("BRS3");
        geneSymbols.add("C3AR1");
        geneSymbols.add("CCBP2");
        geneSymbols.add("CCKBR");
        geneSymbols.add("CCR1");
        geneSymbols.add("CCR3");
        geneSymbols.add("CCR4");
        geneSymbols.add("CCR5");
        geneSymbols.add("CCR8");
        geneSymbols.add("CCR9");
        geneSymbols.add("CCRL1");
        geneSymbols.add("CCRL2");
        geneSymbols.add("CHRM1");

*/
        annotCrit.setGeneSymbols(geneSymbols);

    }
    public void setUpStudyParticipantCrit() {

        /*  Specify StudyParticipantCriteria's Associations Criteria */
        setUpStudyCriteria();
        setUpPopulationCriteria();

        /*  Specify StudyParticipant Attribute Criteria itself */
        //setUpStudyParticipantAttributesCriteria();
   }


    protected void setUpStudyCriteria() {
        StudyCriteria studyCrit = new StudyCriteria();
        studyCrit.setName("CGEMS Prostate Scan 1");
        //studyCrit.setSponsorStudyIdentifier("NIH");
        spCrit.setStudyCriteria(studyCrit);
    }



    public void testGenotypeFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
        setUpSNPPhysicalPositionCrit();
        //setUpDBSnpCrit();
        //setUpGeneBiomarkerCrit();


        // 2. setup StudyParticipant Criteria
        //setUpStudyParticipantCrit();
        //setUpStudyParticipantAttributesCriteria();
        //setUpPopulationCriteria();
        //setUpStudyCriteria();
   //     setUpAnalysisGroupCriteria();

        // 3. set up Genotype Crit itself
        setUpGenotypeCrit();

        // 4. execute search
        executeGenotypeFindingSearch(0, 501);
    }




    private void executeGenotypeFindingSearch(int startIndex, int endIndex) {
       try {
           Collection<? extends Finding> findings =
                FindingsManager.getFindings(gfDTO, startIndex, endIndex);

           System.out.println("RESULTS COUNT: " + findings.size());

           for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
               GenotypeFinding finding =  (GenotypeFinding)iterator.next();
               System.out.println("Fact ID:      " + finding.getId());
               printSNPAnnotation(finding.getSnpAnnotation());

               System.out.println(" Specimen ID: " + finding.getSpecimen().getId());
               System.out.println(" Material Type: " + finding.getSpecimen().getMaterialType());
               System.out.println("Study Partiicpant DE-Identifier Participant ID:  " + finding.getSpecimen().getStudyParticipant().getId());
               System.out.println("QualityScore: " + finding.getQualityScore());
               System.out.println("QC Status:       " + finding.getStatus());
               System.out.println("Allel1:       " + finding.getAllele1());
               System.out.println("Allel2:       " + finding.getAllele2());
               System.out.println("Normalized X-intensity: " + finding.getNormalizedXIntensity() );
               System.out.println("Normalized Y-intensity: " + finding.getNormalizedYIntensity() );
               System.out.println("Raw X-intensity: " + finding.getRawXIntensity() );
               System.out.println("Raw Y-intensity: " + finding.getRawYIntensity() );
               //printSNPAnnotation(finding.getSnpAnnotation());
               //System.out.println("DE-ID: " + finding.getSpecimen().getStudyParticipant().getId());
           }

       } catch (Throwable t)  {
           System.out.println("CGEMS Exception: ");
           t.printStackTrace();
       }
    }

    protected Collection executeSearch(int start, int end) {
       try {
        Collection<? extends Finding> findings =
                FindingsManager.getFindings(gfDTO, start, end);
        System.out.println("RESULTS COUNT: " + findings.size());

           /*for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
               SpecimenBasedMolecularFinding finding =  (SpecimenBasedMolecularFinding)iterator.next();
               System.out.println("Specimen ID: " + finding.getSpecimen().getId());
           }*/
         return findings;
       } catch (Throwable t)  {
           System.out.println("CGEMS Exception: ");
           t.printStackTrace();
       }
        return null;
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(GenotypeFindingTest.class));
        return suit;
    }

    public static void main (String[] args) {
        junit.textui.TestRunner.run(suite());

    }

        public void testPopulateFindings() {
        setUpSNPPhysicalPositionCrit();
        //setUpPopulationCriteria();
        setUpGenotypeCrit();
        try {
             HashSet actualBatchFindings = new HashSet();
             final List findingsToBePopulated =  Collections.synchronizedList(new ArrayList());
             new Thread(new Runnable() {
                 public void run() {
                     try {
                        FindingsManager.populateFindings(gfDTO, findingsToBePopulated);
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
                            GenotypeFinding gf =  (GenotypeFinding) iterator.next();
                            System.out.print("ID: " + gf.getId());
                            System.out.println("QualityScore: " + gf.getQualityScore());
                            System.out.println("QC Status:       " + gf.getStatus());

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
