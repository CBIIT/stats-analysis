package gov.nih.nci.cgems.service;

import gov.nih.nci.cgems.dto.GenotypeFindingCriteriaDTO;
import gov.nih.nci.cgems.dto.StudyParticipantCriteria;
import gov.nih.nci.cgems.dto.ArithematicOperator;
import gov.nih.nci.cgems.dto.CGEMSFindingCriteriaDTO;
import gov.nih.nci.cgems.util.HQLHelper;
import gov.nih.nci.cgems.util.ThreadPool;
import gov.nih.nci.cgems.util.DBEvent;
import gov.nih.nci.cgems.util.ThreadController;
import gov.nih.nci.caintegrator.domain.cgems.finding.Finding;
import gov.nih.nci.caintegrator.domain.cgems.finding.variation.germline.GenotypeFinding;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Hibernate;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 5, 2006
 * Time:   3:08:00 PM
 */
public class GenotypeFindingsHandler extends FindingsHandler {
    Collection<GenotypeFinding>  genotypeFindings = Collections.synchronizedList(new ArrayList<GenotypeFinding>());
    List factEventList = Collections.synchronizedList(new ArrayList());
    private final static int VALUES_PER_THREAD = 50;

    protected Collection<? extends Finding> getMyFindings(CGEMSFindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs,
                                                          final Session session, final int fromIndex, final int toIndex) {
        GenotypeFindingCriteriaDTO findingCritDTO = (GenotypeFindingCriteriaDTO) critDTO;

        final StringBuffer targetHQL = new StringBuffer(" FROM GenotypeFinding g WHERE ");
        final Hashtable params = new Hashtable();

        /* 1. Handle GenoType Attributes Criteria itself  and populate targetHQL/params */
        addGenoTypeAttributeCriteria(findingCritDTO, targetHQL, params);

         /* 2. Add hql to handle StudyParticipantCriteria */
         StudyParticipantCriteria spCrit = findingCritDTO.getStudyParticipantCriteria();
         if (spCrit != null) {
             List<String> specimenIDs = StudyParticipantCriteriaHandler.handle(spCrit, session);
             if (specimenIDs.size() > 0) {
                 targetHQL.append(" g.specimen.id IN ( :specimenIDs ) AND ");
                 params.put("specimenIDs", specimenIDs);
             }
         }

       /* 2. Add hql to handle AnnotationCriteria (using the SNPAnnotatiosIDs passed in) */
       if (snpAnnotationIDs.size() > 0)  {

            targetHQL.append(" g.snpAnnotation.id IN ( :snpAnnotationIDs )");
            ArrayList arrayIDs = new ArrayList(snpAnnotationIDs);

            int threads = arrayIDs.size()/VALUES_PER_THREAD ;

            final int noOfThreads = (threads == 0) ? 1 : threads;
            final int MAX_RESULT_SETTING = ((toIndex - fromIndex) > noOfThreads) ?
                                            ((toIndex - fromIndex))/noOfThreads : 1;

            for (int i = 0, threadCount = 0; i < arrayIDs.size();) {
                Collection values = new ArrayList();
                int begIndex = i;
                i += VALUES_PER_THREAD ;
                int endIndex = (i < arrayIDs.size()) ? endIndex = i : (arrayIDs.size());
                values.addAll(arrayIDs.subList(begIndex,  endIndex));
                params.put("snpAnnotationIDs", values);

                System.out.println("Thread ID: "+ threadCount++);
                final DBEvent.GenotypeRetrieveEvent dbEvent = new DBEvent.GenotypeRetrieveEvent();
                factEventList.add(dbEvent);

                ThreadPool.AppThread t = ThreadPool.newAppThread(
                          new ThreadPool.MyRunnable() {
                              public void codeToRun() {
                                  Query q = session.createQuery(targetHQL.toString());
                                  HQLHelper.setParamsOnQuery(params, q);
                                  q.setFirstResult(fromIndex);
                                  List objs = q.setMaxResults(MAX_RESULT_SETTING).list();
                                  genotypeFindings.addAll(objs);
                                  dbEvent.setCompleted(true);
                              }
                          }
                );
                t.start();
           }
       }
        try {
            ThreadController.sleepOnEvents(factEventList);
        } catch (InterruptedException e) {
            // No big deal.  Ignore it
            e.printStackTrace();
        }
        return genotypeFindings;
    }

    private void addGenoTypeAttributeCriteria(GenotypeFindingCriteriaDTO crit, StringBuffer hql, Hashtable params) {
        Float score = crit.getQualityScore();
        String status = crit.getStatus();
        ArithematicOperator oper =
           (crit.getOperatorType() == null) ? ArithematicOperator.EQ : crit.getOperatorType();

        if (status != null) {
           hql.append(" g.status = :status AND ");
           params.put("status", status);
        }

        if (score != null) {
           applyScoreCondition(oper, hql);
           params.put("score", score);
        }
    }

    private void applyScoreCondition(ArithematicOperator oper, StringBuffer hql) {
        switch(oper) {
              case GT: {
                 hql.append("g.qualityScore > :score AND ");
                 break;
              }
              case LT: {
                  hql.append("g.qualityScore < :score AND ");
                  break;
              }
              case EQ: {
                  hql.append("g.qualityScore = :score AND ");
              }
              default: {
                  // this should never happen.  If happens simply ignore it
              }
          }
    }
    /*  protected StringBuffer buildTargetFindingHSQL() {
        String targetHSQL = new String(" FROM {0} {1} LEFT JOIN FETCH {2}.specimen " +
                                 " LEFT JOIN FETCH {3}.specimen.studyParticipant WHERE ");
        return new StringBuffer(MessageFormat.format(targetHSQL, new Object[]
                                {getFindingType().getName(), FINDING_ALIAS, FINDING_ALIAS, FINDING_ALIAS}));
    }*/

    protected void initializeProxies(Collection<? extends Finding> findings) {
        for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
            GenotypeFinding finding =  (GenotypeFinding) iterator.next();
            Hibernate.initialize(finding.getSnpAnnotation());
            Hibernate.initialize(finding.getSnpAssay());
            Hibernate.initialize(finding.getStudy());
        }
    }
}
