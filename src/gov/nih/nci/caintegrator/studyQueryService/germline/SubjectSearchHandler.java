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

       Criteria crit = null;

       if (specimenIDs == null) {
            /* meanse either StudyParticipantCriteria  is null or no StudyParticipantCriteria
                attributes are mentioned.  So ignore StudyParticipantCriteria and return all StudyParticipant* */
            crit = session.createCriteria(StudyParticipant.class).
                            setFetchMode("population", FetchMode.EAGER);
       }
       else if (specimenIDs.size() == 0) {
            /* means StudyParticipantCriteria did not select and Specimens  Hence return
                no StudyParticipants */
            session.close();
            return new ArrayList<StudyParticipant>();
       }
        /*  means  specimens.size() > 0 so retrieve StudyPartipants beased on the Specimens */
        crit = session.createCriteria(StudyParticipant.class).
                                createAlias("specimenCollection", "specimens").
                                setFetchMode("population", FetchMode.EAGER).
                                add(Restrictions.in("specimens.specimenIdentifier", specimenIDs));

       crit.setFirstResult(fromIndex);
       crit.setMaxResults(toIndex);
       Collection<StudyParticipant> studySubjects = crit.list();
       session.close();
       return studySubjects;
    }
}
