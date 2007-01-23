package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 16, 2006
 * Time:   8:05:49 AM
 */
public class SNPAssociationAnalysisCriteriaTest extends GenotypeFindingTest {

    private SNPAssociationAnalysisCriteria  assocCrit ;

    public void setUp() throws Exception {
        assocCrit = new SNPAssociationAnalysisCriteria();
    }

    public void testSNPAssociationAnalysis() {
        setUpSNPAssociationAnalysisCriteria();
        executeSearch();
    }

    protected void setUpSNPAssociationAnalysisCriteria() {
        //assocCrit.setName("score test");
        //assocCrit.setMethods("contigency table test");
    }

    private void executeSearch() {
        try {
            Collection<SNPAssociationAnalysis> assocObjs = FindingsManager.getSNPAssociationAnalysis(assocCrit);
            System.out.println("Number of Association Objects Retrieved: " + assocObjs .size());
            for (Iterator<SNPAssociationAnalysis> iterator = assocObjs .iterator(); iterator.hasNext();) {
                SNPAssociationAnalysis analysis = iterator.next();
                System.out.println("Analysis Name: " + analysis.getName());
                System.out.println("Analysis Abstract: " + analysis.getMethods());
                System.out.println("Analysis Description: " + analysis.getDescription());
            }

        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting studies: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SNPAssociationAnalysisCriteriaTest.class));
        return suit;
    }

}
