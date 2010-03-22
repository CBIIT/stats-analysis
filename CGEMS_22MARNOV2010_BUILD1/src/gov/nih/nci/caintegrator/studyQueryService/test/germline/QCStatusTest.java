package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.domain.study.bean.Population;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Feb 21, 2007
 * Time:   8:05:49 AM
 */
public class QCStatusTest extends GenotypeFindingTest {
  
    public void setUp() throws Exception {
        super.setUp();
    }

    public void testQCStatus() {
        executeSearch();
    }

    private void executeSearch() {
        try {
            Collection<String> statusValues = manager.getGenotypeFindingQCStatus();
            System.out.println("Number of Statuses Retrieved: " + statusValues .size());
            for (Iterator<String> iterator = statusValues.iterator(); iterator.hasNext();) {

                System.out.println("Status: " +
                                    iterator.next());
            }
        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting Status Objects: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(QCStatusTest.class));
        return suit;
    }

}
