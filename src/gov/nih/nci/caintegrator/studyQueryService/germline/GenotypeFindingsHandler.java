package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.study.bean.Specimen;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.GenotypeFindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.util.ArithematicOperator;
import gov.nih.nci.caintegrator.util.HQLHelper;

import java.util.*;
import java.text.MessageFormat;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Hibernate;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 5, 2006
 * Time:   3:08:00 PM
 */
public class GenotypeFindingsHandler extends FindingsHandler {

    protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs,
                                                          final Session session, final int startIndex, final int endIndex) {
        List<GenotypeFinding>  genotypeFindings = Collections.synchronizedList(
                                                   new ArrayList<GenotypeFinding>());
        final StringBuffer targetHQL = new StringBuffer(
                " FROM GenotypeFinding " + TARGET_FINDING_ALIAS + " {0} WHERE {1} ") ;

       /* 2. Add hql to handle AnnotationCriteria (using the SNPAnnotatiosIDs passed in) */
        if (snpAnnotationIDs != null && snpAnnotationIDs.size() > 0) {
              ArrayList arrayIDs = new ArrayList(snpAnnotationIDs);
              for (int i = 0; i < arrayIDs.size();) {
                  StringBuffer hql = new StringBuffer("").append(targetHQL);
                  Collection values = new ArrayList();
                  int begIndex = i;
                  i += IN_PARAMETERS ;
                  int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
                  values.addAll(arrayIDs.subList(begIndex,  lastIndex));
                  Collection<GenotypeFinding> batchFindings = executeTargetFindingQuery(
                          critDTO, values, session, hql, startIndex, endIndex);
                  genotypeFindings.addAll(batchFindings);
                  if (genotypeFindings.size() > 501)
                      return genotypeFindings.subList(0, 501);
              }
          }

        return genotypeFindings;
    }

    protected Collection<GenotypeFinding> executeTargetFindingQuery(FindingCriteriaDTO critDTO, Collection<String> snpAnnotationIDs, Session session, StringBuffer targetHQL, int start, int end) {
        GenotypeFindingCriteriaDTO findingCritDTO = (GenotypeFindingCriteriaDTO) critDTO;
        final HashMap params = new HashMap();

        /* 1. Include Annotation Criteria in TargetFinding query   */
        StringBuffer snpAnnotJoin = new StringBuffer("");
        StringBuffer snpAnnotCond = new StringBuffer("");
        appendAnnotationCriteriaHQL(snpAnnotationIDs, snpAnnotJoin, snpAnnotCond, params);

        /* 2. Handle GenoType Attributes Criteria itself  and populate targetHQL/params */
        addGenoTypeAttributeCriteria(findingCritDTO, targetHQL, params);

         /* 2. Add hql to handle StudyParticipantCriteria */
         StudyParticipantCriteria spCrit = findingCritDTO.getStudyParticipantCriteria();
         if (spCrit != null) {
             List<String> specimenIDs = StudyParticipantCriteriaHandler.handle(spCrit, session);
             if (specimenIDs.size() > 0) {
                 targetHQL.append(TARGET_FINDING_ALIAS + ".specimen.id IN ( :specimenIDs ) AND ");
                 params.put("specimenIDs", specimenIDs);
             }
         }

         String hql  = MessageFormat.format(targetHQL.toString(), new Object[] {
                        snpAnnotJoin.toString(), snpAnnotCond.toString()} );
         String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
         Query q = session.createQuery(finalHQL);
         HQLHelper.setParamsOnQuery(params, q);
         q.setFirstResult(start);
         q.setMaxResults(end);

         List<GenotypeFinding> findings = q.list();
         return findings;
    }




    private void addGenoTypeAttributeCriteria(GenotypeFindingCriteriaDTO crit, StringBuffer hql, HashMap params) {
        Float score = crit.getQualityScore();
        String status = crit.getStatus();
        ArithematicOperator oper =
           (crit.getOperatorType() == null) ? ArithematicOperator.EQ : crit.getOperatorType();

        if (status != null) {
           hql.append(TARGET_FINDING_ALIAS + "status = :status AND ");
           params.put("status", status);
        }

        if (score != null) {
            String clause =  TARGET_FINDING_ALIAS + ".score {0} :score AND ";
            String condition = HQLHelper.prepareCondition(oper);
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("score", score);
        }
    }


    /*  protected StringBuffer buildTargetFindingHSQL() {
        String targetHSQL = new String(" FROM {0} {1} LEFT JOIN FETCH {2}.specimen " +
                                 " LEFT JOIN FETCH {3}.specimen.studyParticipant WHERE ");
        return new StringBuffer(MessageFormat.format(targetHSQL, new Object[]
                                {getFindingType().getName(), FINDING_ALIAS, FINDING_ALIAS, FINDING_ALIAS}));
    }*/

    protected void initializeProxies(Collection<? extends Finding> findings, Session session) {
      /*  for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
            GenotypeFinding finding =  (GenotypeFinding) iterator.next();
            Hibernate.initialize(finding.getSnpAnnotation());
            Hibernate.initialize(finding.getSnpAssay());
            Hibernate.initialize(finding.getStudy());
        }*/


        /* initialize Specimen objects associated with GenotypeFinding objects */
        List<Specimen> specimenObjs = new ArrayList<Specimen>();
        for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
           GenotypeFinding finding = (GenotypeFinding ) iterator.next();
           specimenObjs.add( finding.getSpecimen());
        }
        Hibernate.initialize(specimenObjs);

        /* initialize Specimen objects associated with GenotypeFinding objects */
        List<StudyParticipant> studyParticipantObjs = new ArrayList<StudyParticipant>();
        for (Iterator<Specimen> iterator = specimenObjs.iterator(); iterator.hasNext();) {
            Specimen specimen =  iterator.next();

        }

    }
}
