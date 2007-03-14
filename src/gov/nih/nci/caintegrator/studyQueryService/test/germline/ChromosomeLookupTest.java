package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
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
public class ChromosomeLookupTest extends GenotypeFindingTest {

    public void testGetChromosomesMethod() {
        executeSearch();
    }

    private void executeSearch() {
        try {
            Collection<String> chromosomes = FindingsManager.getChromosomes();
            System.out.println("Number of Chromosomes Retrieved: " + chromosomes .size());
            for (Iterator<String> iterator = chromosomes .iterator(); iterator.hasNext();) {
                String chromosome = iterator.next();
                System.out.println("chromosomes Name: " + chromosome);
            }

        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting Chromosomes: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(ChromosomeLookupTest.class));
        return suit;
    }

}
