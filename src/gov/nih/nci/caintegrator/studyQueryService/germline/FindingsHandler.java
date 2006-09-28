package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.*;

import org.hibernate.Session;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 5, 2006
 * Time:   2:34:18 PM
 */
abstract public class FindingsHandler extends BatchFindingsHandler {

     protected static final String TARGET_FINDING_ALIAS = " finding";
     protected abstract Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO,
                                                                    Set<String> snpAnnotationIDs, Session session, int start, int end);
     protected abstract void sendMyFindings(FindingCriteriaDTO critDTO,
                                            Set<String> snpAnnotationIDs, Session session, List toBePopulated);

     protected abstract void initializeProxies(Collection<? extends Finding> findings, Session session);

     protected abstract Collection<? extends Finding> executeAnnotationQueryForFindingSets(
                                        FindingCriteriaDTO findingCritDTO, Collection<String> snpAnnotationIDs,
                                        Session session,  StringBuffer targetHQL, int start, int end);

    protected abstract Collection<? extends Finding> executeQueryForFindingSets(
                                        FindingCriteriaDTO findingCritDTO, Session session,
                                        StringBuffer targetHQL, int start, int end);

    public Collection<? extends Finding> getFindings(FindingCriteriaDTO critDTO, int fromIndex, int toIndex)
            throws Exception {

        Set<String> snpAnnotationIDs = null;
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        /* get AnnotationIDs */
        if (critDTO.getAnnotationCriteria() != null)
            snpAnnotationIDs = SNPAnnotationCriteriaHandler.handle(critDTO.getAnnotationCriteria(), session);

        /* 2.  Apply all other criteria mentioned in the query and return as concrete type findings */
        Collection<? extends Finding> findings =
                getMyFindings(critDTO, snpAnnotationIDs, session, fromIndex, toIndex);
        initializeProxies(findings, session);
        session.clear();

        session.close();
        return findings;
    }

    public void populateFindings(FindingCriteriaDTO critDTO, List toBePopulated)
     throws Exception {

        Set<String> snpAnnotationIDs = new HashSet<String>();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        if (critDTO.getAnnotationCriteria() != null) {
            snpAnnotationIDs = SNPAnnotationCriteriaHandler.handle(critDTO.getAnnotationCriteria(), session);
        }

        /* 2.  Apply all other criteria mentioned in the query and populate concrete type findings
               after initialzing the proxies as well */
        sendMyFindings(critDTO, snpAnnotationIDs, session, toBePopulated);
        session.close();
    }


     public static List<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
     throws Exception {
         List<SNPAnnotation> snpAnnotationObjs = new ArrayList<SNPAnnotation>();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         snpAnnotationObjs = SNPAnnotationCriteriaHandler.getSNPAnnotations(annotCrit, session);
         session.close();
         return snpAnnotationObjs;
     }

    protected static void appendAnnotationCriteriaHQL(Collection<String> snpAnnotationIDs, StringBuffer snpAnnotJoin,
                                                   StringBuffer snpAnnotCond, HashMap params) {
        if (snpAnnotationIDs != null) {
            /* means some annotation criteria is specified */
            if (snpAnnotationIDs.size() > 0) {
                snpAnnotJoin.append(" LEFT JOIN FETCH " + TARGET_FINDING_ALIAS + ".snpAnnotation ");
                snpAnnotCond.append(TARGET_FINDING_ALIAS + ".snpAnnotation.id IN (:snpAnnotationIDs) AND ");
                params.put("snpAnnotationIDs", snpAnnotationIDs);
            }
            else {
                /* means no annotations were selected from the Annotation Criteria Hence  when we
                   and with rest of other criteria, no results should be returned */
                snpAnnotJoin.append(" LEFT JOIN FETCH " + TARGET_FINDING_ALIAS +  ".snpAnnotation ");
                snpAnnotCond.append(" (0 != 0) AND ");
            }
        } else {
            /* no AnnotationCriteria was mentioned at all in the initial query DTO.  But we still need
              to retrieve SNPAnnotations for the retrieved Findings  So just specify LEFT JOIN FETCH
              so that outer-join will be used*/
            snpAnnotJoin.append(" LEFT JOIN FETCH " + TARGET_FINDING_ALIAS +  ".snpAnnotation ");
            /* keep snpAnnotCond as emppty so that it does not have any effect */
        }
    }
}
