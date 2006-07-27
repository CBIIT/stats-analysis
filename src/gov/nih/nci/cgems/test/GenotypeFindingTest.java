package gov.nih.nci.cgems.test;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;
import gov.nih.nci.cgems.dto.*;
import gov.nih.nci.cgems.service.FindingsManager;
import gov.nih.nci.caintegrator.domain.cgems.finding.Finding;
import gov.nih.nci.caintegrator.domain.cgems.finding.SpecimenBasedMolecularFinding;
import gov.nih.nci.caintegrator.domain.cgems.finding.variation.germline.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.cgems.annotation.snp.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.cgems.study.DNASpecimen;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 6, 2006
 * Time:   5:53:05 PM
 */

public class GenotypeFindingTest extends TestCase {
    protected AnnotationCriteria annotCrit;
    private GenotypeFindingCriteriaDTO gfDTO;
    private StudyParticipantCriteria spCrit;

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
        ppc.setChromosome("8");
        ppc.setStartPosition(new Long(76065000));  // 76065158
        ppc.setEndPosition(new Long(76075000));    // should give 4 GenotypeFindings

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
       dbSNPIds.add("rs10215692");
       dbSNPIds.add("rs10216611");
       annotCrit.setSnpIdentifiers(dbSNPIds );
    }

    public void testSNPAnnotCrit() {
        setUpSNPPhysicalPositionCrit();
        executeSearch();
    }

    protected void setUpPanelCrit() {
        PanelCriteria p = new PanelCriteria();
        p.setName("HumanHap300");
        p.setVersion("1.1");
        annotCrit.setPanelCriteria(p);
    }

    public void testPanelCrit() {
        setUpPanelCrit();
        executeSearch();
    }

    public void testPanelAndSNPAnnotCrit() {
        setUpPanelCrit();
        setUpSNPPhysicalPositionCrit();
        executeSearch();
    }
    public void setUpGeneBiomarkerCrit() {
        Collection<String> geneSymbols = new ArrayList<String> ();
        geneSymbols.add(new String("USP48"));
        geneSymbols.add(new String("HSPG2"));
        geneSymbols.add(new String("ALPL"));

        annotCrit.setGeneSymbols(geneSymbols);

    }
    public void setUpStudyParticipantCrit() {

        /*  Specify StudyParticipantCriteria's Associations Criteria */
        setUpStudyCriteria();
        setUpPopulationCriteria();

        /*  Specify StudyParticipant Attribute Criteria itself */
        setUpStudyParticipantAttributesCriteria();
   }

    private void setUpStudyParticipantAttributesCriteria() {
        spCrit.setAgeAtDeath(85);
        spCrit.setAgeAtDiagnosis(45);
        spCrit.setAgeAtEnrollment(46);
        spCrit.setDaysOffStudy(100);
        spCrit.setDaysOnStudy(360);
        spCrit.setSurvivalStatus(Boolean.TRUE);
        spCrit.setOffStudy(Boolean.FALSE);

        // set collections
        Collection ca = new ArrayList();
        ca.add("Male");
        spCrit.setAdministrativeGenderCodeCollection(ca);

        Collection ce = new ArrayList();
        ce.add("Asian");
        spCrit.setEthnicGroupCodeCollection(ce);

        Collection cf = new ArrayList();
        cf.add("Chelestrol");
        spCrit.setFamilyHistoryCollection(cf);

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
    }

    private void setUpStudyCriteria() {
        StudyCriteria studyCrit = new StudyCriteria();
        studyCrit.setName("A");
        studyCrit.setSponsorStudyIdentifier("NIH");
        spCrit.setStudyCriteria(studyCrit);
    }

     private void setUpPopulationCriteria() {
        PopulationCriteria popCrit = new PopulationCriteria();
        popCrit.setName("Mexican");
        spCrit.setPopulationCriteria(popCrit);
     }

    public void testGenotypeFindingCriteriaDTO() {
        // 1. setup Annotation Criteria
        setUpSNPPhysicalPositionCrit();
        setUpDBSnpCrit();
        //setUpGeneBiomarkerCrit();

        // 2. setup StudyParticipant Criteria
        //setUpStudyParticipantCrit();

        // 3. set up Genotype Crit itself
        //setUpGenotypeCrit();

        // 4. execute search
        executeGenotypeFindingSearch(0, 100);
    }

    private void executeGenotypeFindingSearch(int startIndex, int endIndex) {
       try {
           Collection<? extends Finding> findings =
                FindingsManager.getFindings(gfDTO, startIndex, endIndex);

           System.out.println("RESULTS COUNT: " + findings.size());

           for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
               GenotypeFinding finding =  (GenotypeFinding)iterator.next();
               System.out.println("Fact ID:      " + finding.getId());
               System.out.println("Specimen ID:  " + finding.getSpecimen());
               System.out.println("QualityScore: " + finding.getQualityScore());
               System.out.println("Status:       " + finding.getStatus());
               System.out.println("Allel1:       " + finding.getAllele1());
               System.out.println("Allel2:       " + finding.getAllele2());
               System.out.println("SNPAnnotation:" );
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
        System.out.println("              BioMarkers:          " + annot.getGeneBiomarkerCollection());
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
