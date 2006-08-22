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
abstract public class FindingsHandler {
     protected abstract Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO,
                                                                    Set<String> snpAnnotationIDs, Session session, int start, int end);
     protected abstract void initializeProxies(Collection<? extends Finding> findings, Session session);

     public final static Boolean isAnyCriteriaSpecified(AnnotationCriteria annotCrit) {
         boolean annotCritPresent = false;
         if (SNPAnnotationCriteriaHandler.isAnnotationCriteriaPresent(annotCrit) )
            annotCritPresent = true;
         //if (crit)
          return null;
     }


     public Collection<? extends Finding> getFindings(FindingCriteriaDTO critDTO, int fromIndex, int toIndex)
     throws Exception {

         Set<String> snpAnnotationIDs = new HashSet<String>();
         Session session = HibernateUtil.getSessionFactory().getCurrentSession();
         session.beginTransaction();

         /* 1. Handle AnnotationCriteria which will bring back SNPs */
         AnnotationCriteria annotCrit = critDTO.getAnnotationCriteria();
         if (annotCrit != null) {
           snpAnnotationIDs = SNPAnnotationCriteriaHandler.handle(annotCrit, session);
         }

         System.out.print("SNP Annotations Retrieved: " + snpAnnotationIDs.size());
         System.out.println(snpAnnotationIDs);

         /* 2.  Apply all other criteria mentioned in the query and return as concrete type findings */
         Collection<? extends Finding> findings =
                 getMyFindings(critDTO, snpAnnotationIDs, session, fromIndex, toIndex);
         initializeProxies(findings, session);

         session.close();
         return findings;
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


}
