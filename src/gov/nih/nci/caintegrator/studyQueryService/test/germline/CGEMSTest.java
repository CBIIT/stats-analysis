package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import junit.framework.TestCase;
import gov.nih.nci.caintegrator.studyQueryService.germline.BatchFindingsHandler;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.PhysicalPositionCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.PanelCriteria;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.study.bean.DNASpecimen;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author: Ram Bhattaru
 * Date:   Sep 20, 2006
 * Time:   5:37:48 AM
 */
public abstract class CGEMSTest extends TestCase {
    protected abstract Collection executeSearch(int start, int end);
    //protected static int TOTAL_FINDINGS = 0;
    protected AnnotationCriteria annotCrit;
    protected StudyCriteria studyCrit;



    protected StudyParticipantCriteria spCrit;
        protected void setUpPanelCrit() {
        PanelCriteria p = new PanelCriteria();
        //p.setName("HumanHap300");
       //p.setName("HumanHap550");
        //p.setVersion("1.1");
       //p.setSnpPanelID(new Long(100));
            p.setSnpPanelID(new Long(100));
        annotCrit.setPanelCriteria(p);
    }

    public void setUp() throws Exception{
        annotCrit = new AnnotationCriteria();
        spCrit = new StudyParticipantCriteria();
        studyCrit = new StudyCriteria();
    }
    protected void setUpSNPPhysicalPositionCrit() {
        PhysicalPositionCriteria ppc = new PhysicalPositionCriteria();

        ppc.setChromosome("8");
      ppc.setStartPosition(new Long(1));  // 76065158
      ppc.setEndPosition(new Long(100000000));    // should give 4 GenotypeFindings


/*
        ppc.setChromosome("7");
        ppc.setStartPosition(new Long(40000000 ));
        ppc.setEndPosition(new Long(55000000));
*/

        /*
        ppc.setChromosome("X");
        ppc.setStartPosition(new Long(2693518));   // entire chromosome
        ppc.setEndPosition(new Long(154493116));
        */

        annotCrit.setPhysicalPositionCriteria(ppc);

    }
    protected void setUpStudyCriteria() {
       studyCrit.setName("CGEMS Prostate Cancer WGAS Phase 1A");

    }

    protected void setUpGeneBiomarkerCrit() {
        Collection<String> geneSymbols = new ArrayList<String> ();
        //geneSymbols.add(new String("USP48"));
        //geneSymbols.add(new String("HSPG2"));
        geneSymbols.add(new String("MET"));
        //geneSymbols.add(new String("12FOO34"));


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
    protected void setUpAnalysisGroupCriteria() {
         AnalysisGroupCriteria crit = new AnalysisGroupCriteria("CGEMS Prostate Cancer WGAS Phase 1");
         crit.setNames(new String[] {"Incidence density sampling, Unadjusted score test, Controls"});
         //"early", "advanced"
         spCrit.setAnalysisGroupCriteria(crit);
     }
     protected void setUpDBSnpCrit() {
        Collection<String> dbSNPIds = new ArrayList<String>();
        dbSNPIds.add("rs10215692");
        dbSNPIds.add("rs10216611");
        dbSNPIds.add("rs10170496");
        dbSNPIds.add("rs7867544");
        dbSNPIds.add("rs1160166");
        dbSNPIds.add("rs10504944");
        annotCrit.setSnpIdentifiers(dbSNPIds );
    }

    protected void setUpStudyParticipantAttributesCriteria() {
        //spCrit.setLowerAgeLimit(55);
        spCrit.setUpperAgeLimit(60);
        Collection fhs = new ArrayList<String>();
        //fhs.add("YeS");
        fhs.add("nO");
        spCrit.setFamilyHistoryCollection(fhs);

        //spCrit.setDaysOffStudy(100);
        //spCrit.setDaysOnStudy(999);
        //spCrit.setSurvivalStatus(Boolean.TRUE);
        //spCrit.setOffStudy(Boolean.FALSE);

        // set collections

/*
        Collection ci = new ArrayList();
        ci.add("NCICB");
        spCrit.setInstitutionNameCollection(ci);


        Collection cs = new ArrayList();
        cs.add("1");
        cs.add("2");
        cs.add("3");
        cs.add("4");
        cs.add("5");
        cs.add("6");
        cs.add("7");
        cs.add("8");
        cs.add("9");cs.add("10");
        spCrit.setStudySubjectIdentifierCollection (cs);
*/
    }

    protected void setUpPopulationCriteria() {
       Collection<String> names = new ArrayList<String>();
       //names.add("CASE_ADVANCED");
       names.add("CONTROL");
       PopulationCriteria popCrit = new PopulationCriteria(names);
       spCrit.setPopulationCriteria(popCrit);
    }


    public void testAll() {

        Collection allFindings = new HashSet();
        int findingsFound = 0;
        int start = 0;
        int end = BatchFindingsHandler.BATCH_OBJECT_INCREMENT + 1;
        Collection findings = null;
        do {
            findings = executeSearch(start, end);
            HashSet uniqueFindings = new HashSet();
            uniqueFindings.addAll(findings);
            if (findings == null) {
                System.out.println("Error Occured in executeSearch() method");
                System.exit(1);
            }
            allFindings.addAll(findings);
            //findingsFound = findings.size();

            System.out.println("\n\n ***** Findings Found For Start:" + start + " And End:" + end
                                    + "  = " + findings.size() + " ***** \n\n");
            //TOTAL_FINDINGS += findingsFound;
            start += BatchFindingsHandler.BATCH_OBJECT_INCREMENT;
            end += BatchFindingsHandler.BATCH_OBJECT_INCREMENT;;
        } while(findings.size() > (BatchFindingsHandler.BATCH_OBJECT_INCREMENT ));
        System.out.println("TOTAL UNIQUE FINDINGS FOUND: " + allFindings.size());
    }
    protected void printSNPAnnotation(SNPAnnotation annot) {
        System.out.println("              SNPAnnotation ID:    " + annot.getId());
        System.out.println("              Chromosome:          " + annot.getChromosomeName());
        System.out.println("              Chromosome Location: " + annot.getChromosomeLocation());


        System.out.println("              DbsnpId:             " + annot.getDbsnpId());
    }

    protected void printSpecimen(DNASpecimen s) {
        System.out.println(s );
    }



}
