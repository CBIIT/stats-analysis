package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 5, 2006
 * Time:   2:34:18 PM
 */
abstract public class FindingsHandler extends BatchFindingsHandler {

     private SessionFactory sessionFactory;
     protected static final String TARGET_FINDING_ALIAS = " finding";
     protected abstract Class getTargeFindingType();
     protected abstract StringBuffer getTargetFindingHQL() ;
     protected abstract void initializeProxies(Collection<? extends Finding> findings, Session session);
     protected abstract Collection<? extends Finding> executeFindingSetQuery(FindingCriteriaDTO critDTO,
                                        StringBuffer targetHQL, Session session, int start, int end ) throws Exception;

     public Collection<? extends Finding> getFindings(FindingCriteriaDTO critDTO, int fromIndex, int toIndex)
     throws Exception {
        Collection<? extends Finding> findings ;
        Session session = getSessionFactory().getCurrentSession();
        StringBuffer targetHQL = getTargetFindingHQL();
        findings = executeFindingSetQuery(critDTO, targetHQL, session, fromIndex, toIndex);
        initializeProxies(findings, session);
        session.clear();
        return findings;
    }

    protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Session session,
                                                                   int startIndex, int endIndex) throws Exception {
        StringBuffer targetHQL = getTargetFindingHQL();
        Collection<? extends Finding>  findings = executeFindingSetQuery(critDTO, targetHQL, session, startIndex, endIndex);
        return findings;
    }

    protected void appendAnnotationCritHQL(FindingCriteriaDTO critDTO, HashMap params, StringBuffer snpAnnotCond) throws Exception {
        if (critDTO.getAnnotationCriteria() != null) {
            StringBuffer annotJoin = SNPAnnotationCriteriaHandler.getAnnotHQLWithParams(
                                                                            critDTO.getAnnotationCriteria(), params);
            snpAnnotCond.append(TARGET_FINDING_ALIAS + ".snpAnnotation.id IN ( " + annotJoin.toString() + " ) AND ");
        }
    }

    public void getFindingForFTP(FindingCriteriaDTO critDTO, List toBePopulated) throws Exception{
        Session session = getSessionFactory().getCurrentSession();
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

     public List<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit)
     throws Exception {
         List<SNPAnnotation> snpAnnotationObjs;
         Session session = getSessionFactory().getCurrentSession();
         /*  TODO: refer to the below method implementation  */
         snpAnnotationObjs = SNPAnnotationCriteriaHandler.getSNPAnnotations(annotCrit, session);
         return snpAnnotationObjs;
     }

    protected boolean isOnlyPanelCriteria(AnnotationCriteria annotCrit) {
        if ((annotCrit.getGeneSymbols() == null) && (annotCrit.getPhysicalPositionCriteria() == null) &&
           (annotCrit.getSnpIdentifiers() == null) &&  (annotCrit.getPanelCriteria() != null)) return true;
        else return false;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}
