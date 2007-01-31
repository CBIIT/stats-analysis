package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.util.HibernateUtil;
import gov.nih.nci.caintegrator.util.HQLHelper;

import java.util.*;
import java.text.MessageFormat;
import java.lang.reflect.Array;

import org.hibernate.Session;
import org.hibernate.Query;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 5, 2006
 * Time:   2:34:18 PM
 */
abstract public class FindingsHandler extends BatchFindingsHandler {

     protected static final String TARGET_FINDING_ALIAS = " finding";

     protected abstract Class getTargeFindingType();

     protected abstract Collection<? extends Finding> getFindingsFromResults(List results);

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

        Collection<? extends Finding> findings = null;
        Set<String> snpAnnotationIDs = null;
        AnnotationCriteria annotCrit = critDTO.getAnnotationCriteria();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        if (annotCrit == null) findings = getMyFindings(critDTO, snpAnnotationIDs, session, fromIndex, toIndex);
        else {
            if (isOnlyPanelCriteria(annotCrit)) findings =
                    executePanelOnlySearch(critDTO, session, fromIndex, toIndex);
            else {
                /* either snpAnnotationCrit & PanelCriteria both are present or only snpAnnotationCrit is present */
                snpAnnotationIDs = SNPAnnotationCriteriaHandler.handle(critDTO.getAnnotationCriteria(), session);
                findings = getMyFindings(critDTO, snpAnnotationIDs, session, fromIndex, toIndex);
            }
        }

        initializeProxies(findings, session);
        session.clear();
        session.close();
        return findings;
    }

    public void getFindingForFTP(FindingCriteriaDTO critDTO, List toBePopulated) throws Exception{
        AnnotationCriteria annotCrit = critDTO.getAnnotationCriteria();
        if (annotCrit == null) populateFindings(critDTO, toBePopulated);
        else {
            if (isOnlyPanelCriteria(annotCrit)) populateFindingsForPanelOnly(critDTO, toBePopulated);
            else {
                populateFindings(critDTO, toBePopulated);
            }
        }

    }
     private void populateFindingsForPanelOnly(FindingCriteriaDTO critDTO, List toBePopulated)
     throws Exception {
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();

         Collection findings = null;
         int start = 0;
         int end = BatchFindingsHandler.BATCH_OBJECT_INCREMENT ;
         do {
             findings =  executePanelOnlySearch(critDTO, session, start, end);
             initializeProxies(findings, session);
             Set toBeSent = getConcreteTypedFindingSet();
             //Set toBeSent = new HashSet<SNPFrequencyFinding>();
             toBeSent.addAll(findings);
             process(toBePopulated,  toBeSent, session);
             System.out.println("Retrieved from start: " + start + " end: " + end);
             start += BatchFindingsHandler.BATCH_OBJECT_INCREMENT ;
             end += BatchFindingsHandler.BATCH_OBJECT_INCREMENT ;
         }  while(findings.size() >= BatchFindingsHandler.BATCH_OBJECT_INCREMENT  );

         Set h = getConcreteTypedFindingSet();
         /* send empty data object to let the client know that no more results are present */
         process(toBePopulated, h, session);
         if (session.isOpen())
            session.close();
       }

    protected void populateFindings(FindingCriteriaDTO critDTO, List toBePopulated)
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

    private boolean isOnlyPanelCriteria(AnnotationCriteria annotCrit) {
        if ((annotCrit.getGeneSymbols() == null) && (annotCrit.getPhysicalPositionCriteria() == null) &&
           (annotCrit.getSnpIdentifiers() == null) &&  (annotCrit.getPanelCriteria() != null)) return true;
        else return false;
    }

    private Collection<? extends Finding> getFindingsWithOnlyPanelCrit(FindingCriteriaDTO findingCritDTO, Session session, int fromIndex, int toIndex) {
        /*    ********************************************* NOW
         AnnotationCriteria annotCrit = findingCritDTO.getAnnotationCriteria();
         Collection<? extends Finding> findings = null;
         String findingType =  getTargeFindingType().getName();
         StringBuffer hql = new StringBuffer(" FROM {0} {1}, SNPAssay s JOIN s.snpAnnotation {3} " +
                                             " WHERE s.snpPanel.id = {2} AND {4} " );
         //StringBuffer anotherJoin = new StringBuffer("");
         //StringBuffer anotherCond = new StringBuffer("");
         StringBuffer panelHQLWithValues = new StringBuffer (
                  MessageFormat.format( hql.toString(), new Object[] {
                         findingType, TARGET_FINDING_ALIAS,
                          annotCrit.getPanelCriteria().getSnpPanelID()})  );

         // add  HQL for Finding criteria attributes itself
         StringBuffer findingHQL = new StringBuffer("");
         HashMap params = new HashMap();
         StringBuffer finalPanelHQL = addHQLForFindingAttributeCriteria(findingCritDTO, findingHQL, params,panelHQLWithValues, session);
         StringBuffer finalHQLWithAND = new StringBuffer(HQLHelper.removeTrailingToken(new StringBuffer(finalPanelHQL), "AND"));
         finalHQLWithAND.append(" AND ");
         finalHQLWithAND.append(findingHQL);
         String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(finalHQLWithAND), "AND");

         Query q = session.createQuery(finalHQL);
         HQLHelper.setParamsOnQuery(params, q);
         q.setFirstResult(fromIndex);
         q.setMaxResults(toIndex);
         List results = q.list();
         findings = getFindingsFromResults(results);
         return findings;
        ***************************** NOW *************/
        //executePanelOnlyBatchSearch()
        return null;
    }
    public abstract Collection<? extends Finding> executePanelOnlySearch(FindingCriteriaDTO findingCritDTO,
                                                                  Session session, int start, int end);
}
