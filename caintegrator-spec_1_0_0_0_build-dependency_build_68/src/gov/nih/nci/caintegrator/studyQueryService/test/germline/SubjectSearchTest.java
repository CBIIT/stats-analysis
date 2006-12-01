package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;

import java.util.*;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 16, 2006
 * Time:   8:05:49 AM
 */
public class SubjectSearchTest extends CGEMSTest {
    public void testSubjectSearch() {
        setUpStudyParticipantAttributesCriteria();
        setUpPopulationCriteria();
        //setUpAnalysisGroupCriteria();
        executeSearch(0,501);
        //testAll();
        //System.out.println("Findings Found: " + findingsFound);

        /*Collection<String> caseStatus = FindingsManager.getGenotypeFindingQCStatus();
        System.out.println("Case Status: " + caseStatus);

        //FindingsManager.getCaseControlStatus();

        Collection<Integer> upperRangeLimits = FindingsManager.getAgeUpperLimitValues();
        System.out.println("Age UpperLimits: " + upperRangeLimits);

        Collection<Integer> lowerRangeLimits = FindingsManager.getAgeLowerLimitValues();
        System.out.println("Age LowerLimits: " + lowerRangeLimits );


*/



    }


    protected Collection executeSearch(int start, int end) {
        try {
            Collection<StudyParticipant> subjects = FindingsManager.getStudySubjects(spCrit, start, end );
            System.out.println("Number of Subjects Retrieved: " + subjects.size());
            for (Iterator<StudyParticipant> iterator = subjects.iterator(); iterator.hasNext();) {
                StudyParticipant subject =  iterator.next();
                System.out.println("STUDY PARTICIPANT DE_IDENTIFIER ID: " +
                                    subject.getStudySubjectIdentifier());
                System.out.println("GENDER: " + subject.getAdministrativeGenderCode());
                System.out.println("AGE (PLEASE CONFIRM THIS - WHICH AGE -): " + subject.getAgeAtEnrollment());
                System.out.println("AFFECTION STATUS: (PLEASE CONFIRM THIS -): " + subject.getSurvivalStatus());
                System.out.println("FAMILY HISTORY: " + subject.getFamilyHistory());
                System.out.println("Population Name: "+ subject.getPopulation().getName());
                if (subject.getAgeAtEnrollment() != null)
                    System.out.println("Enroll Age:" + subject.getAgeAtEnrollment().getAbsoluteValue());
            }
            return subjects;
        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting Study Subjects: " + t.toString());
           t.printStackTrace();
       }
        return null;
    }

    public void testPopulateFindings() {
        setUpPopulationCriteria();
        try {
             HashSet<StudyParticipant> actualBatchFindings = null;
             final List findingsToBePopulated =  Collections.synchronizedList(new ArrayList());
             new Thread(new Runnable() {
                 public void run() {
                     try {
                        FindingsManager.populateStudySubjects(spCrit, findingsToBePopulated);
                     } catch(Throwable t) {
                         t.printStackTrace();
                         System.out.println("Error from FindingsManager.populateStudySubjects call: ");
                     }
                 }
                       }
            ).start();

            int count = 1;
            int noOfResults = 0;
            do {
                synchronized(findingsToBePopulated) {
                    if (findingsToBePopulated.size() > 0) {
                         actualBatchFindings  = (HashSet<StudyParticipant>)findingsToBePopulated.remove(0);
                         for (Iterator<StudyParticipant> iterator = actualBatchFindings.iterator(); iterator.hasNext();) {
                             StudyParticipant sp = iterator.next();
                             System.out.print("ID: " + sp.getId());
                             System.out.print("  Case Control Status: " + sp.getCaseControlStatus());                         }
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


    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SubjectSearchTest.class));
        return suit;
    }

}
