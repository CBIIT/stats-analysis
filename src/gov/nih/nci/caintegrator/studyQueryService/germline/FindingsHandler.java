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
     protected abstract StringBuffer getTargetFindingHQL() ;
     protected abstract void initializeProxies(Collection<? extends Finding> findings, Session session);
     protected abstract Collection<? extends Finding> executeFindingSetQuery(FindingCriteriaDTO critDTO,StringBuffer targetHQL,
                                            StringBuffer snpAnnotCond, HashMap params, Session session,
                                            int start, int end ) throws Exception;

     public Collection<? extends Finding> getFindings(FindingCriteriaDTO critDTO, int fromIndex, int toIndex)
     throws Exception {

        Collection<? extends Finding> findings ;
        AnnotationCriteria annotCrit = critDTO.getAnnotationCriteria();
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();

        if ((annotCrit == null) || !isOnlyPanelCriteria(annotCrit)) findings = getMyFindings(critDTO, session, fromIndex, toIndex);
        else findings = executePanelOnlySearch(critDTO, session, fromIndex, toIndex);

        initializeProxies(findings, session);
        session.clear();
        session.close();
        return findings;
    }

    protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Session session,
                                                                        int startIndex, int endIndex) throws Exception {
        Collection<? extends Finding>  findings ;

        StringBuffer targetHQL = getTargetFindingHQL();
        HashMap params = new HashMap();
        StringBuffer snpAnnotCond = new StringBuffer();

        /* if AnnotationCrit is specified, then append required HQL (to snpAnnotCondition) for handling AnnotationCrit*/
        if (critDTO.getAnnotationCriteria() != null) {
             StringBuffer annotJoin = SNPAnnotationCriteriaHandler.getAnnotHQLWithParams(
                                                                            critDTO.getAnnotationCriteria(), params);
             snpAnnotCond.append(TARGET_FINDING_ALIAS + ".snpAnnotation.id IN ( " + annotJoin.toString() + " ) AND ");
        }

        findings = executeFindingSetQuery(critDTO, targetHQL, snpAnnotCond, params, session, startIndex, endIndex);
        return findings;
    }

    public void getFindingForFTP(FindingCriteriaDTO critDTO, List toBePopulated) throws Exception{
        AnnotationCriteria annotCrit = critDTO.getAnnotationCriteria();
        if ((annotCrit == null) || !isOnlyPanelCriteria(annotCrit))  populateFindings(critDTO, toBePopulated);
        else populateFindingsForPanelOnly(critDTO, toBePopulated);
    }

     protected void sendMyFindings(FindingCriteriaDTO critDTO, Session session, List toBePopulated) throws Exception {
        Collection findings ;
        int start = 0;
        int end = BATCH_OBJECT_INCREMENT ;
        Set toBeSent;
        do {
            findings =  getMyFindings(critDTO, session, start, end);
            initializeProxies(findings, session);
            toBeSent = new HashSet();
            toBeSent.addAll(findings);
            process(toBePopulated,  toBeSent, session);
            start += BATCH_OBJECT_INCREMENT;
            end += BATCH_OBJECT_INCREMENT;;
        }  while(findings.size() >= BATCH_OBJECT_INCREMENT );

        /* send empty data object to let the client know that no more results are present */
        process(toBePopulated, getConcreteTypedFindingSet(),session);
        return ;
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
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        sendMyFindings(critDTO, session, toBePopulated);
        session.close();
    }

     public static List<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
     throws Exception {
         List<SNPAnnotation> snpAnnotationObjs;
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();
         snpAnnotationObjs = SNPAnnotationCriteriaHandler.getSNPAnnotations(annotCrit, session);
         session.close();
         return snpAnnotationObjs;
     }

    private boolean isOnlyPanelCriteria(AnnotationCriteria annotCrit) {
        if ((annotCrit.getGeneSymbols() == null) && (annotCrit.getPhysicalPositionCriteria() == null) &&
           (annotCrit.getSnpIdentifiers() == null) &&  (annotCrit.getPanelCriteria() != null)) return true;
        else return false;
    }

    public abstract Collection<? extends Finding> executePanelOnlySearch(FindingCriteriaDTO findingCritDTO,
                                                                  Session session, int start, int end);
}
