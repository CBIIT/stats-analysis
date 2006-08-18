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
       List<String> specimenIDs = StudyParticipantCriteriaHandler.handle(spCrit, session);
       /*StringBuffer hql = new StringBuffer(
               " SELECT StudyParticipant sp JOIN sp.specimenCollection " +
               " WHERE sp.specimenCollection.specimenIdentifier IN (:specimenIDs) ");
       */
        if (specimenIDs.size() < 1) {
            session.close();
            return new ArrayList<StudyParticipant>();
        }
        Criteria crit = session.createCriteria(StudyParticipant.class).createAlias("specimenCollection", "specimens").
                                               add(Restrictions.in("specimens.specimenIdentifier", specimenIDs));


       //Criteria crit = session.createCriteria(hql.toString());
       crit.setFirstResult(fromIndex);
       crit.setMaxResults(toIndex);
       Collection<StudyParticipant> studySubjects = crit.list();
       session.close();
       return studySubjects;
    }

}
