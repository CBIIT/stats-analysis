package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPFrequencyFindingCriteriaDTO;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.*;
import java.text.MessageFormat;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 17, 2006
 * Time:   5:52:11 PM
 */
public class SNPFrequencyFindingHandler extends FindingsHandler {

    protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs, Session session, int startIndex, int endIndex) {
        List<SNPFrequencyFinding>  snpFrequencyFindings =
                Collections.synchronizedList(new ArrayList<SNPFrequencyFinding>());

        //SNPFrequencyFindingCriteriaDTO findingCritDTO = (SNPFrequencyFindingCriteriaDTO) critDTO;
        final StringBuffer targetHQL = new StringBuffer(
                " FROM SNPFrequencyFinding "+ TARGET_FINDING_ALIAS + " {0} {1} WHERE {2} {3} ");

        if (snpAnnotationIDs != null && snpAnnotationIDs.size() > 0) {
            ArrayList arrayIDs = new ArrayList(snpAnnotationIDs);
            for (int i = 0; i < arrayIDs.size();) {
                StringBuffer hql = new StringBuffer("").append(targetHQL);
                Collection values = new ArrayList();
                int begIndex = i;
                i += IN_PARAMETERS ;
                int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
                values.addAll(arrayIDs.subList(begIndex,  lastIndex));
                Collection<SNPFrequencyFinding> batchFindings = executeTargetFindingQuery(
                        critDTO, values, session, hql, startIndex, endIndex);
                snpFrequencyFindings .addAll(batchFindings);
                if (snpFrequencyFindings.size() > 501)
                    return snpFrequencyFindings.subList(0, 501);
            }
        }
        return snpFrequencyFindings ;
       }



    protected Collection<SNPFrequencyFinding> executeTargetFindingQuery(FindingCriteriaDTO critDTO, Collection<String> snpAnnotationIDs, Session session, StringBuffer targetHQL, int start, int end) {
         final HashMap params = new HashMap();
         SNPFrequencyFindingCriteriaDTO findingCritDTO = (SNPFrequencyFindingCriteriaDTO) critDTO;
         /* 1. Include Annotation Criteria in TargetFinding query   */
         StringBuffer snpAnnotJoin = new StringBuffer("");
         StringBuffer snpAnnotCond = new StringBuffer("");
/*       if (snpAnnotationIDs != null)
         if (snpAnnotationIDs.size() > 0) {
            snpAnnotJoin = "LEFT JOIN FETCH sf.snpAnnotation ";
            snpAnnotCond = " sf.snpAnnotation.id IN (:snpAnnotationIDs) AND ";
            params.put("snpAnnotationIDs", snpAnnotationIDs);
         }
*/       appendAnnotationCriteriaHQL(snpAnnotationIDs, snpAnnotJoin, snpAnnotCond, params);

         /*  2. Handle SNPFrequencyFinding Attributes Criteria itself  and populate targetHQL/params */
         addSNPFrequencyFindingAttriuteCrit(findingCritDTO, targetHQL, params);

         /*  3. Handle population & Study criteria  */
         String populationJoin = "";
         String populationCond = "";
         List<Population> populationList = handlePopulationCriteria(findingCritDTO, session);
         if (populationList.size() > 0) {
            populationJoin = " LEFT JOIN FETCH " + TARGET_FINDING_ALIAS + ".population ";
            populationCond =  TARGET_FINDING_ALIAS + ".population IN (:populationList) ";
            params.put("populationList", populationList);
         }

/*
         /*  4. If no criteria is resulted in any condition to be filtered
            (or if no criteria is specified), return empty list
         if ( (snpAnnotationIDs.size() < 1) && (populationList.size() < 1) &&
                (params.size() < 1) )
            return new ArrayList<SNPFrequencyFinding>();
*/

         String hql  = MessageFormat.format(targetHQL.toString(), new Object[] {
                            snpAnnotJoin.toString(), populationJoin, snpAnnotCond.toString(), populationCond });
         String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
         Query q = session.createQuery(finalHQL);
         HQLHelper.setParamsOnQuery(params, q);
         q.setFirstResult(start);
         q.setMaxResults(end);
         List<SNPFrequencyFinding> findings = q.list();
         return findings;
       }
    private List<Population> handlePopulationCriteria(SNPFrequencyFindingCriteriaDTO findingCritDTO, Session session) {
        String populationName = findingCritDTO.getPopulationName();
        String studyName = findingCritDTO.getStudyName();
        String sponsorIdentifier = findingCritDTO.getSponsorStudyIdentifier();

        if ((populationName == null || populationName.length() < 1) &&
                (studyName == null || studyName.length() < 1) &&
                (sponsorIdentifier == null || sponsorIdentifier.length() < 1) ) {
            return new ArrayList<Population>();
        }

        Criteria popCrit = session.createCriteria(Population.class);
        if (populationName != null && populationName.length() > 0) {
            popCrit.add(Restrictions.eq("name", populationName));
        }
        boolean appendStudy = isAddStudyCriteria(findingCritDTO);
        if (appendStudy) {
            Criteria studyCrit = popCrit.createCriteria("studyCollection");
            addStudyCriteria(findingCritDTO, studyCrit, session);
        }
        List<Population> populationList = popCrit.list();
        return populationList;
    }

    private void addStudyCriteria( SNPFrequencyFindingCriteriaDTO findingCritDTO, Criteria studyCrit, Session session) {
        String studyName = findingCritDTO.getStudyName();
        String sponsorIdentifier = findingCritDTO.getSponsorStudyIdentifier();
        if (studyName != null && studyName.length() > 0) {
            studyCrit.add(Restrictions.eq("name", studyName));
        }
        if (sponsorIdentifier != null && sponsorIdentifier.length() > 0) {
            studyCrit.add(Restrictions.eq("sponsorStudyIdentifier", sponsorIdentifier));
        }
    }
    private boolean isAddStudyCriteria( SNPFrequencyFindingCriteriaDTO findingCritDTO) {
            String studyName = findingCritDTO.getStudyName();
            String sponsorIdentifier = findingCritDTO.getSponsorStudyIdentifier();
            if ((studyName != null && studyName.length() > 0) ||
                    (sponsorIdentifier != null && sponsorIdentifier.length() > 0) )
               return true;

            return false;
    }
    private void addSNPFrequencyFindingAttriuteCrit(SNPFrequencyFindingCriteriaDTO crit, StringBuffer hql, HashMap params) {
        Float hardyWeinbergPValue  = crit.getHardyWeinbergPValue();
        Integer heterCount = crit.getHeterozygoteCount();

        // TODO : uncomment below after minorAlleleFrequency is fianlized with DB
        //Float minorAlleleFreq = crit.getMinorAlleleFrequency();

        Integer missingAlleleCnt = crit.getMissingAlleleCount();
        Integer missingGenotypeCnt = crit.getMissingGenotypeCount();
        String otherAllele = crit.getOtherAllele();
        Integer otherAllelCnt = crit.getOtherAlleleCount();
        Integer otherHomogyoteCnt = crit.getOtherHomogygoteCount();
        String referenceAllele = crit.getReferenceAllele();
        Integer referenceAlleleCnt = crit.getReferenceAlleleCount();
        Integer referenceHomogzoteCnt = crit.getReferenceHomogyzoteCount();
        Double completionRate = crit.getCompletionRate();
        ArithematicOperator completeRateOperator = crit.getCompleteRateOperator();


        if (completionRate != null) {
            if (completeRateOperator == null) completeRateOperator = ArithematicOperator.EQ; // default
            String clause =  TARGET_FINDING_ALIAS + ".completionRate {0} :completionRate AND ";
            String condition = HQLHelper.prepareCondition(completeRateOperator);
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("completionRate", completionRate);
        }

        if (hardyWeinbergPValue != null) {
            hql.append( TARGET_FINDING_ALIAS + ".hardyWeinbergPValue = :pValue AND ");
            params.put("pValue", hardyWeinbergPValue);
        }
        if (heterCount != null) {
           hql.append( TARGET_FINDING_ALIAS + ".heterozygoteCount = :heterCount AND ");
           params.put("heterCount", heterCount);
        }

        // TODO : uncomment below after minorAlleleFrequency is fianlized with DB
        /*
        if (minorAlleleFreq != null) {
            hql.append(" sf.minorAlleleFrequency = :minorAlleleFreq AND ");
            params.put("minorAlleleFreq", minorAlleleFreq);
        }
        */


        if (missingAlleleCnt != null) {
            hql.append( TARGET_FINDING_ALIAS + ".missingAlleleCount = :missingAlleleCnt AND ");
            params.put("missingAlleleCnt", missingAlleleCnt);
        }
        if (missingGenotypeCnt != null) {
            hql.append( TARGET_FINDING_ALIAS + ".missingAlleleCount = :missingGenotypeCnt AND ");
            params.put("missingGenotypeCount", missingGenotypeCnt);
        }
        if (otherAllele != null) {
            hql.append( TARGET_FINDING_ALIAS + ".missingAlleleCount = :otherAllele AND ");
            params.put("otherAllele", otherAllele);
        }
        if (otherAllelCnt != null) {
            hql.append( TARGET_FINDING_ALIAS + ".otherAlleleCount = :otherAllelCnt AND ");
            params.put("otherAllelCnt", otherAllelCnt);
        }
        if (otherHomogyoteCnt != null) {
            hql.append( TARGET_FINDING_ALIAS + ".otherHomogygoteCount = :otherHomogyoteCnt AND ");
            params.put("otherHomogyoteCnt", otherHomogyoteCnt);
        }
        if (referenceAllele != null) {
            hql.append( TARGET_FINDING_ALIAS + ".referenceAllele = :referenceAllele AND ");
            params.put("referenceAllele", referenceAllele);
        }
        if (referenceAlleleCnt != null) {
            hql.append( TARGET_FINDING_ALIAS + ".referenceAlleleCount = :referenceAlleleCnt AND ");
            params.put("referenceAlleleCnt", referenceAlleleCnt);
        }
        if (referenceHomogzoteCnt != null) {
            hql.append( TARGET_FINDING_ALIAS + ".referenceHomogyzoteCount = :referenceHomogzoteCnt AND ");
            params.put("referenceHomogzoteCnt", referenceHomogzoteCnt);
        }

    }
    protected void initializeProxies(Collection<? extends Finding> findings, Session session) {

        /* initialize GeneBioMarkers Collection associated with SNPAnnotation objects corresponding
           to SNPFrequecyFindings
        */
        List<GeneBiomarker> gbObjs = new ArrayList<GeneBiomarker>();
        for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
           SNPFrequencyFinding finding = (SNPFrequencyFinding) iterator.next();
           gbObjs.addAll(finding.getSnpAnnotation().getGeneBiomarkerCollection());
        }
        Hibernate.initialize(gbObjs);
    }

    protected Boolean ifFindingCriteriaSpecified(SNPFrequencyFindingCriteriaDTO crit) {
        return null;
    }
}
