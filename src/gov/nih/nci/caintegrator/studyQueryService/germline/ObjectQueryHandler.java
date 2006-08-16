package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.HibernateUtil;
import gov.nih.nci.caintegrator.domain.study.bean.Study;


import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.MessageFormat;

import org.hibernate.Session;
import org.hibernate.Query;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 16, 2006
 * Time:   7:39:39 AM
 */

public class ObjectQueryHandler {

    public static Collection<Study> getStudyObjects(StudyCriteria studyCrit) {
        if (studyCrit == null) return new ArrayList<Study>();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        HashMap params = new HashMap();
        String studyCritHQL = " FROM Study s WHERE {0} {1} ";
        StringBuffer studyNameJoin = new StringBuffer("");
        String studyName = studyCrit.getName();
        String sponsorStudyIdentifier = studyCrit.getSponsorStudyIdentifier();

        if ((studyName != null) && (studyName.length() > 0)) {
           studyNameJoin.append(" s.name = :studyName  ");
           params.put("studyName", studyName);
        }

        StringBuffer sponsorJoin = new StringBuffer("");
        if ((sponsorStudyIdentifier != null) && (sponsorStudyIdentifier.length() > 0))  {
             sponsorJoin .append(" AND s.sponsorStudyIdentifier = :sponsorStudyIdentifier ");
             params.put("sponsorStudyIdentifier", sponsorStudyIdentifier);
        }

        String hql = MessageFormat.format(studyCritHQL, new Object[] {
                            studyNameJoin, sponsorJoin});

        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "WHERE");
        Query studyQuery = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, studyQuery );
        List<Study> studyObjs = studyQuery.list();
        return studyObjs;
    }
}
