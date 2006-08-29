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
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 6, 2006
 * Time:   5:53:05 PM
 */

public class GenotypeFindingTest extends TestCase {
    protected AnnotationCriteria annotCrit;
    private GenotypeFindingCriteriaDTO gfDTO;
    protected StudyParticipantCriteria spCrit;

    protected void setUp() throws Exception {
        gfDTO = new GenotypeFindingCriteriaDTO();
        annotCrit = new AnnotationCriteria();
        gfDTO.setAnnotationCriteria(annotCrit);
        spCrit = new StudyParticipantCriteria();
        gfDTO.setStudyParticipantCriteria(spCrit);
    }
    private void setUpGenotypeCrit() {
        gfDTO.setQualityScore(new Float(0.50), ArithematicOperator.LT);
    }
    protected void setUpSNPPhysicalPositionCrit() {
        PhysicalPositionCriteria ppc = new PhysicalPositionCriteria();
/*
        ppc.setChromosome("8");
        ppc.setStartPosition(new Integer(76065000));  // 76065158
        ppc.setEndPosition(new Integer(76075000));    // should give 4 GenotypeFindings

*/
        ppc.setChromosome("X");
        ppc.setStartPosition(new Integer(1));  // 76065158
        ppc.setEndPosition(new Integer(1000000000));    // should give 4 GenotypeFindings

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

        CHRM2
        ARID4A
        ARNT
        ARNT2
        ARNTL2
        ARX
        ASCL1
        ATBF1
        ATF3
        ATF6
        ATF7
        ATOH1
        ATRX
        BACH1
        BARHL1
        BARX1
        BARX2
        BATF
        BCL6
        BHLHB2
        BHLHB3
        BNC1
        BRD8
        BTEB1
        BTG2
        C10orf48
        C16orf7
        C20orf17
        CALML5
        CART1
        CBFA2T2
        CBFA2T3
        CBL
        CCRN4L
        CDX1
        CDX2
        CEBPB
        CITED1
        CITED2
        CKLFSF4
        CLOCK
        CNOT7
        CREB1
        CREB3L1
        CREBBP
        CREBL2
        CRX
        CSDA
        CTCF
        CUTL2
        DDIT3
        DLX2
        DLX3
        DLX4
        DLX5
        DLX6
        DMRT1
        DMRT2
        DMRT3
        DMRTA1
        DMRTC2
        DMTF1
        DSCR1
        DSIPI
        DUX1
        E2F1
        E2F3
        E2F4
        E2F6
        E4F1
        EGR4
        EHF
        ELF1
        ELF2
        ELF3
        ELF5
        ELK1
        ELK4
        EMX1
        EMX2
        EN2
        ENO1
        EOMES
        EP300
        EPAS1
        ERG
        ESR2
        ESRRA
        ESRRB
        ESX1L
        ETS1
        ETS2
        ETV1
        ETV2
        ETV5
        ETV6
        ETV7
        EVX1
        FEV
        FLI1
        FLJ11011
        FLJ12895
        FLJ20626
        FLJ23614
        FLJ25169
        FLJ25680
        FLJ30678
        FLJ37970
        FMNL2
        FOSL1
        FOSL2
        FOXA1
        FOXA2
        FOXA3
        FOXC2
        FOXD1
        FOXD2
        FOXD3
        FOXD4L1
        FOXE1
        FOXE3
        FOXF1
        FOXG1B
        PARVB
        PARVG
        PFN1
        PIP
        PLEC1
        PLEKHH2
        PLS1
        PLS3
        PTK9L
        RDX
        SCIN
        SMTN
        SNTA1
        SNTB1
        SNTG2
        SORBS1
        SPTA1
        SPTB
        SPTBN1
        SPTBN5
        SVIL
        SYNE1
        TAGLN
        TLN1
        TMOD1
        TMOD3
        TMOD4
        TMSB10
        TMSNB
        TNNI1
        TNNI3
        TPM1
        TPM2
        TPM3
        VASP
        VCL
        VILL
        WASF1
        WASF2
        WASL
        WDR1
        YWHAH
        ARP3BETA
        FLNA
        FSCN3
        ZNF6
        ZNF606
        ZNF623
        ZNF647
        ZNF7
        ZNF71
        ZNF74
        ZNF77
        ZNF79
        ZNF8
        ZNF83
        ZNF84
        ZNF90
        ZNF91
        ZNF92
        ZNFN1A2
        ZNRD1
        ZRF1
        ZXDB
        ZZZ3
        ATRX
        DDX11
        RAD54B
        RECQL
        RECQL4
        RECQL5
        RUVBL1
        WRN
        HMGA1
        HMGA2
        ACTL6A
        ARID4B
        ASF1A
        CBX1
        CBX3
        CBX6
        CBX7
        CDY1
        CDY2
        CDYL
        CDYL2
        CHAF1A
        CHAF1B
        CHD1
        CHD3
        CHD4
        CHD5
        CHD6
        EZH1
        HSMPP8
        KLHDC3
        MGC10561
        MPO
        MYST1
        NCOA6
        NSBP1
        PB1
        SMARCC2
        SMC1L1
        SUV39H1
        VCX
        VCX3
        ANKRD17
        BRCA1
        DDB2
        ERCC1
        ERCC3
        FEN1
        GTF2H3
        JTV1
        MPG
        MSH4
        MSH5
        MSH6
        N4BP2
        OGG1
        PMS2L4
        PMS2L9
        POLH
        POLQ
        RAD1
        RAD18
        RAD51C
        RAD51L3
        REV1L
        XPA
        XPC
        XRCC1
        XRCC2
        ORC2L
        ORC4L
        ORC5L
        CSDA
        FEN1
        G22P1
        HLF
        HNRPDL
        IFI16
        MTERF
        PIR51
        PNKP
        RBMS1
        SATB1
        XRCC5
        ZNF638
        ZBP1
        MBD2
        MBD4
        MLH3
        BRCA2
        ERCC5
        HNRPDL
        IGHMBP2
        KHDRBS1
        LRPPRC
        PC4
        PCBP1
        PIR51
        POLG2
        PURA
        RPA1
        RPA2
        RPA3
        SMUG1
        SSBP2
        SSBP4
        TAF15
        TREX1
        XPC
        ADNP
        AF5Q31
        AHR
        AIRE
        ALX3
        ANKRD30A
        AP2E
        KIF5C
        KIF9
        KIFC1
        KLC2
        KNS2
        KNSL7
        LOC84643
        MYH1
        MYH11
        MYH13
        MYH14
        MYH15
        MYH3
        MYH4
        MYH7B
        MYH8
        MYH9
        MYO15A
        MYO15B
        MYO18B
        MYO1B
        MYO1C
        MYO1D
        MYO1F
        MYO3A
        MYO5A
        MYO5B
        MYO5C
        MYO6
        MYO9A
        MYO9B
        MYR8
        OPA1
        PLEKHH1
        APPBP2
        CENPE
        CSPG6
        DNAH12
        DNAH14
        DNAH3
        DNAH5
        DNAH6
        DNAH8
        DNAH9
        DNAL4
        DNALI1
        DNCH1
        DNCL1
        DNCL2A
        DNCL2B
        Dlc2
        FLJ32752
        FLJ40427
        KIF13B
        KIF1B
        KIF22
        KIF2C
        KIF3B
        KIF4A
        KIF5B
        KLC2
        KLC2L
        KNS2
        KNSL8
        NPHP3
        TCTEL1
        ABLIM1
        ABLIM2
        ABLIM3
        ACTN2
        ACTN3
        ACTN4
        ADD2
        ANLN
        AVIL
        BCL7B
        BIRC4
        CALD1
        CAPZA1
        CAPZA3
        CFL1
        CFL2
        CFLP1
        CLMN
        CNN1
        CORO1A
        CORO1B
        CORO1C
        CORO2B
        DAAM1
        DAAM2
        DBNL
        DIAPH1
        DIAPH3
        DST
        DSTN
        EPB41
        EPB41L1
        EPB41L2
        FHOD1
        FHOD3
        FLII
        FLNA
        FLNB

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

    protected void setUpStudyParticipantAttributesCriteria() {
        //spCrit.setAgeAtDeath(85);
        //spCrit.setAgeAtDiagnosis(45);
        //spCrit.setAgeAtEnrollment(2);
        //spCrit.setDaysOffStudy(100);
        spCrit.setDaysOnStudy(999);
        //spCrit.setSurvivalStatus(Boolean.TRUE);
        //spCrit.setOffStudy(Boolean.FALSE);

        // set collections
        Collection ca = new ArrayList();
        ca.add("MALE");
        spCrit.setAdministrativeGenderCodeCollection(ca);

        Collection ce = new ArrayList();
        ce.add("CAUCASIAN");
        spCrit.setEthnicGroupCodeCollection(ce);

/*
        Collection cf = new ArrayList();
        cf.add("Chelestrol");
        spCrit.setFamilyHistoryCollection(cf);
*/

/*
        Collection ci = new ArrayList();
        ci.add("NCICB");
        spCrit.setInstitutionNameCollection(ci);

        Collection cr = new ArrayList();
        cr.add("Hispanic");
        spCrit.setRaceCodeCollection(cr);

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

    protected void setUpStudyCriteria() {
        StudyCriteria studyCrit = new StudyCriteria();
        studyCrit.setName("A");
        studyCrit.setSponsorStudyIdentifier("NIH");
        spCrit.setStudyCriteria(studyCrit);
    }

    protected void setUpAnalysisGroupCriteria() {
        AnalysisGroupCriteria crit = new AnalysisGroupCriteria();
        crit.setNames(new String[] {"control"});
        //"early", "advanced"
        spCrit.setAnalysisGroupCriteria(crit);
    }

     protected void setUpPopulationCriteria() {
        PopulationCriteria popCrit = new PopulationCriteria();
        popCrit.setName("CASE_ADVANCED");
        spCrit.setPopulationCriteria(popCrit);
     }

    public void testGenotypeFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
        //setUpSNPPhysicalPositionCrit();
        //setUpDBSnpCrit();
        //setUpGeneBiomarkerCrit();
        //setUpPopulationCriteria();

        // 2. setup StudyParticipant Criteria
        //setUpStudyParticipantCrit();
        //setUpStudyParticipantAttributesCriteria();


        //setUpAnalysisGroupCriteria();

        // 3. set up Genotype Crit itself
        //setUpGenotypeCrit();

        // 4. execute search
        executeGenotypeFindingSearch(0, 500);
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
               printSNPAnnotation(finding.getSnpAnnotation());
           }

       } catch (Throwable t)  {
           System.out.println("CGEMS Exception: ");
           t.printStackTrace();
       }
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

    private void executeSearch() {
       int startIndex = 0;
       int endIndex = 100;
       try {
        Collection<? extends Finding> findings =
                FindingsManager.getFindings(gfDTO, startIndex, endIndex);
        System.out.println("RESULTS COUNT: " + findings.size());

           for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
               SpecimenBasedMolecularFinding finding =  (SpecimenBasedMolecularFinding)iterator.next();
               System.out.println("Specimen ID: " + finding.getSpecimen().getId());
           }

       } catch (Throwable t)  {
           System.out.println("CGEMS Exception: ");
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(GenotypeFindingTest.class));
        return suit;
    }

    public static void main (String[] args) {
        junit.textui.TestRunner.run(suite());

    }
}
