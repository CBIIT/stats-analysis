package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 18, 2006
 * Time:   10:13:15 AM
 */
public class SubjectSearchHandler extends BatchFindingsHandler {
    private static Logger logger = Logger.getLogger(SubjectSearchHandler.class);
    private SessionFactory sessionFactory;
    
    final protected Set getConcreteTypedFindingSet() {
        return new HashSet<StudyParticipant>();
    }

    final protected List getConcreteTypedFindingList() {
        return new ArrayList<StudyParticipant>();
    }


	public Collection<StudyParticipant> getStudySubjects(StudyParticipantCriteria spCrit,
                                                            int fromIndex, int toIndex) {
		   Session session = getSessionFactory().getCurrentSession();
	       List<Long> specimenIDs = StudyParticipantCriteriaHandler.retrieveSpecimens(spCrit, session);
	       List<StudyParticipant> subjects = new ArrayList<StudyParticipant>();
	       HashSet<StudyParticipant> subjectsSet = new HashSet<StudyParticipant>();
	       Criteria crit = null;

	       if (specimenIDs == null) {
	           /* meanse either StudyParticipantCriteria  is null or no StudyParticipantCriteria
	              attributes are mentioned.  So ignore StudyParticipantCriteria and return all StudyParticipant* */
	           crit = session.createCriteria(StudyParticipant.class).
	                            setFetchMode("populationCollection", FetchMode.EAGER);
	           crit.setFirstResult(fromIndex);
	           crit.setMaxResults(toIndex - fromIndex);
	           List<StudyParticipant> list = crit.list();
	           subjectsSet.addAll(list);
	           subjects.addAll(subjectsSet);
	       }
	       else if (specimenIDs.size() == 0) {
	            /* means StudyParticipantCriteria did not select and Specimens  Hence return
	                no StudyParticipants */
	            return subjects;
	       }
	        /*  means  specimens.size() > 0 so retrieve StudyPartipants beased on the Specimens */
	       else  if (specimenIDs != null && specimenIDs.size() > 0) {
	             ArrayList<Long> arrayIDs = new ArrayList<Long>(specimenIDs);
	             for (int i = 0; i < arrayIDs.size();) {
	                 List<Long> values = new ArrayList<Long>();
	                 int begIndex = i;
	                 i += BatchFindingsHandler.IN_PARAMETERS ;
	                 int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
	                 values.addAll(arrayIDs.subList(begIndex,  lastIndex));
	                 crit = session.createCriteria(StudyParticipant.class).
	                                   createAlias("specimenCollection", "specimens").
	                                   setFetchMode("populationCollection", FetchMode.EAGER).
	                                   add(Restrictions.in("specimens.id", values));
	                 //crit.uniqueResult();
	                 crit.setFirstResult(0);
	                 crit.setMaxResults(toIndex - fromIndex);
	                 Collection<StudyParticipant> studySubjects = crit.list();
	                 // avoid duplicates
	                 subjectsSet.addAll(studySubjects);
	                 if (subjects.size() >= (toIndex - fromIndex + 1))  {
	                    subjects.addAll(subjectsSet);
	                    subjectsSet = null;
	                    return subjects.subList(0, (toIndex - fromIndex ));
	                 }
	               }

	               /* means each time it never gotten more than 500 results.  So add to final results */
	               subjects.addAll(subjectsSet);
	        }
	        return subjects;
    }

    public void populateFindings(StudyParticipantCriteria spCrit, List toBePopulated) {
		   Session session = getSessionFactory().getCurrentSession();

	       List<Long> specimenIDs = StudyParticipantCriteriaHandler.retrieveSpecimens(spCrit, session);

	       /* if (specimenIDs == null) either StudyParticipantCriteria  is null or no StudyParticipantCriteria
	          attributes are mentioned.  So ignore StudyParticipantCriteria and return all subjects */
	       if (specimenIDs == null) {
	           sendFindingsWithoutAnnotationCriteria(session, toBePopulated);
	       }

	       /* if (specimenIDs.size() == 0) means that the StudyParticipantCriteria did not select
	           and Specimens  Hence return no StudyParticipants */
	       else if (specimenIDs.size() == 0) {
	            /* send empty data object to let the client know that no more results are present */
	            process(toBePopulated, new HashSet<StudyParticipant>(), session);
	            return ;
	       }
	        /*  means  specimens.size() > 0 so retrieve StudyPartipants beased on the Specimens */
	       else  if (specimenIDs != null && specimenIDs.size() > 0) {
	            sendFindingsWithAnnotationCriteria(specimenIDs, session, toBePopulated);
	       }
    }
    private void sendFindingsWithAnnotationCriteria(Collection<Long> specimenIDs,
                                                    Session session, List toBePopulated) {
        List<StudyParticipant> subjects = new ArrayList<StudyParticipant>();
        HashSet<StudyParticipant> subjectsSet = new HashSet<StudyParticipant>();
        ArrayList<Long> arrayIDs = new ArrayList<Long>(specimenIDs);
        for (int i = 0; i < arrayIDs.size();) {
            List<Long> values = new ArrayList<Long>();
            int begIndex = i;
            i += BatchFindingsHandler.IN_PARAMETERS ;
            int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
            values.addAll(arrayIDs.subList(begIndex,  lastIndex));
            Criteria crit  = session.createCriteria(StudyParticipant.class).
                              createAlias("specimenCollection", "specimens").
                              setFetchMode("populationCollection", FetchMode.EAGER).
                              add(Restrictions.in("specimens.id", values));

            Collection<StudyParticipant> currentFindings = executeBatchSearch(
                                                                    crit, -1, -1);

            /* convert these  currentFindings in to a List for convenience */
            for (Iterator<StudyParticipant> iterator = currentFindings.iterator(); iterator.hasNext();) {
                StudyParticipant studyParticipant =  iterator.next();
                if (! subjectsSet.contains(studyParticipant)) {
                    subjectsSet.add(studyParticipant);
                    subjects.add(studyParticipant);
                }
            }

            while (subjects.size() >= BatchFindingsHandler.BATCH_OBJECT_INCREMENT )
                 populateCurrentResultSet(subjects, toBePopulated, session);
         }
         /* Now write remaining findings i.e. less than 500 in one call */
         if (subjects != null)
             populateCurrentResultSet(subjects, toBePopulated, session);

          /* Finally after all the results were written, write an empty Object (HashSet of size=0
             to indicate the caller that all results were written */
          populateCurrentResultSet(getConcreteTypedFindingList(), toBePopulated, session);

          return;
    }

    private void sendFindingsWithoutAnnotationCriteria( Session session, List toBePopulated ) {
         Criteria crit = session.createCriteria(StudyParticipant.class).
                         setFetchMode("populationCollection", FetchMode.EAGER);

         Collection findings = null;
         int start = 0;
         int end = BatchFindingsHandler.BATCH_OBJECT_INCREMENT ;

         do {
             findings =  executeBatchSearch(crit, start, end);
             Set toBeSent = new HashSet<StudyParticipant>();
             toBeSent.addAll(findings);
             process(toBePopulated,  toBeSent, session);
             start += BatchFindingsHandler.BATCH_OBJECT_INCREMENT ;
             end += BatchFindingsHandler.BATCH_OBJECT_INCREMENT ;

         }  while(findings.size() >= BatchFindingsHandler.BATCH_OBJECT_INCREMENT  );

         /* send empty data object to let the client know that no more results are present */
         process(toBePopulated, new HashSet<StudyParticipant>(), session);
    }

    private static Collection<StudyParticipant> executeBatchSearch(Criteria crit, int start, int end) {
        if (start == -1 || end == -1) {
            // do not use these indexes.  Just retrieve everything
        }
        else { // set the index values
            crit.setFirstResult(start);
            crit.setMaxResults(end - start);
        }
        Collection<StudyParticipant> studySubjects = crit.list();
        return studySubjects;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
