package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.domain.study.bean.Specimen;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 18, 2006
 * Time:   10:13:15 AM
 */
public class SubjectSearchHandler {

    public static Collection<StudyParticipant> getStudySubjects(StudyParticipantCriteria spCrit, int fromIndex, int toIndex) {
       Session session = HibernateUtil.getSessionFactory().getCurrentSession();
       session.beginTransaction();
       List<String> specimenIDs = StudyParticipantCriteriaHandler.retrieveSpecimens(spCrit, session);
       List<StudyParticipant> subjects = new ArrayList<StudyParticipant>();
       Criteria crit = null;

       if (specimenIDs == null) {
           /* meanse either StudyParticipantCriteria  is null or no StudyParticipantCriteria
              attributes are mentioned.  So ignore StudyParticipantCriteria and return all StudyParticipant* */
           crit = session.createCriteria(StudyParticipant.class).
                            setFetchMode("population", FetchMode.EAGER);
           subjects = crit.list();
       }
       else if (specimenIDs.size() == 0) {
            /* means StudyParticipantCriteria did not select and Specimens  Hence return
                no StudyParticipants */
            session.close();
            return subjects;
       }
        /*  means  specimens.size() > 0 so retrieve StudyPartipants beased on the Specimens */
       else  if (specimenIDs != null && specimenIDs.size() > 0) {

             ArrayList<String> arrayIDs = new ArrayList<String>(specimenIDs);
             for (int i = 0; i < arrayIDs.size();) {
                //StringBuffer hql = new StringBuffer("").append(targetHQL);
                 List<String> values = new ArrayList<String>();
                 int begIndex = i;
                 i += FindingsHandler.IN_PARAMETERS ;
                 int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
                 values.addAll(arrayIDs.subList(begIndex,  lastIndex));
                 crit = session.createCriteria(StudyParticipant.class).
                                   createAlias("specimenCollection", "specimens").
                                   setFetchMode("population", FetchMode.EAGER).
                                   add(Restrictions.in("specimens.specimenIdentifier", values));
                 Collection<StudyParticipant> sps =
                         executeBatchSearch(crit, session, values, fromIndex, toIndex);
                 subjects.addAll(sps);
                 if (subjects.size() > 501)  {
                    session.close();
                    return subjects.subList(0, 501);
                 }
               }
        }
        session.close();
        return subjects;
    }

    private static Collection<StudyParticipant> executeBatchSearch(Criteria crit, Session session, List<String> specimenIDs, int fromIndex, int toIndex) {
        crit.setFirstResult(fromIndex);
        crit.setMaxResults(toIndex - fromIndex);
        Collection<StudyParticipant> studySubjects = crit.list();
        return studySubjects;
    }
}
