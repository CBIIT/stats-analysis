package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 16, 2006
 * Time:   8:05:49 AM
 */
public class SubjectSearchTest extends GenotypeFindingTest {

    public void testSubjectSearch() {
        setUpStudyParticipantAttributesCriteria();
        setUpPopulationCriteria();
        setUpAnalysisGroupCriteria();
        executeSearch();
    }

    private void executeSearch() {
        try {
            Collection<StudyParticipant> subjects = FindingsManager.getStudySubjects(spCrit, 0, 40 );
            System.out.println("Number of Subjects Retrieved: " + subjects.size());
            for (Iterator<StudyParticipant> iterator = subjects.iterator(); iterator.hasNext();) {
                StudyParticipant subject =  iterator.next();
                System.out.println("Study Subject Identifier: " + subject.getStudySubjectIdentifier());
                System.out.println("Institution Name: " + subject.getInstitutionName());
                System.out.println("Race Code: " + subject.getRaceCode());
                System.out.println("Case Control Status: " + subject.getCaseControlStatus());
                System.out.println("Days On Study: " + subject.getDaysOnStudy());
                // below are NOt included as lazily initialized.  If needed can initialize it
                System.out.println("Analysis Group Collection: \n" + subject.getAnalysisGroupCollection());
                System.out.println("Population: "+ subject.getPopulation());
            }
        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting Chromosomes: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SubjectSearchTest.class));
        return suit;
    }

}
