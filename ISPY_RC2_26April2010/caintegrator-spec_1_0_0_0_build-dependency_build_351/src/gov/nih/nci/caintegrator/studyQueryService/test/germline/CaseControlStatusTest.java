package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Feb 21, 2007
 * Time:   8:05:49 AM
 */
public class CaseControlStatusTest extends GenotypeFindingTest {
    public void setUp() throws Exception {
        super.setUp();
    }
    public void testStatus() {
        executeSearch();
    }
    private void executeSearch() {
        try {
        	StudyCriteria studyCrit = new StudyCriteria();
        	studyCrit.setName("CGEMS Breast Cancer WGAS Phase 1");
            Collection<String> statusValues = manager.getCaseControlStatus(studyCrit);
            System.out.println("Number of Statuses Retrieved: " + statusValues .size());
            for (Iterator<String> iterator = statusValues.iterator(); iterator.hasNext();) {
                System.out.println("Status: " + iterator.next());
            }
        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting Status Objects: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(CaseControlStatusTest.class));
        return suit;
    }

}
