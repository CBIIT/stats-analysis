package gov.nih.nci.cgems.service;

import gov.nih.nci.caintegrator.domain.cgems.finding.Finding;
import gov.nih.nci.caintegrator.domain.cgems.finding.variation.snpFrequency.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.cgems.study.Population;
import gov.nih.nci.cgems.dto.CGEMSFindingCriteriaDTO;
import gov.nih.nci.cgems.dto.SNPFrequencyFindingCriteriaDTO;
import gov.nih.nci.cgems.util.HQLHelper;

import java.util.*;
import java.text.MessageFormat;

import org.hibernate.Session;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 17, 2006
 * Time:   5:52:11 PM
 */
public class SNPFrequencyFindingHandler extends FindingsHandler {

    protected Collection<? extends Finding> getMyFindings(
            CGEMSFindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs, Session session, int startIndex, int endIndex) {

        SNPFrequencyFindingCriteriaDTO findingCritDTO = (SNPFrequencyFindingCriteriaDTO) critDTO;
        final StringBuffer targetHQL = new StringBuffer(
                " FROM SNPFrequencyFinding sf {0} {1} WHERE {2} {3} ");
        final HashMap params = new HashMap();

        /* 1. Include Annotation Criteria in TargetFinding query   */
        String snpAnnotJoin = " LEFT JOIN FETCH sf.snpAnnotation ";
        String snpAnnotCond = "";
        if (snpAnnotationIDs.size() > 0) {
            snpAnnotCond = " sf.snpAnnotation.id IN (:snpAnnotationIDs) AND ";
            params.put("snpAnnotationIDs", snpAnnotationIDs);
        }

        /*  2. Handle SNPFrequencyFinding Attributes Criteria itself  and populate targetHQL/params */
        addSNPFrequencyFindingAttriuteCrit(findingCritDTO, targetHQL, params);

        /*  3. Handle population & Study criteria  */
        String populationJoin = " LEFT JOIN FETCH sf.population ";
        String populationCond = "";
        List<Population> populationList = handlePopulationCriteria(findingCritDTO, session);
        if (populationList.size() > 0) {
            populationCond = " sf.population IN (:populationList) ";
            params.put("populationList", populationList);
        }

        /*  4. If no criteria is resulted in any condition to be filtered
            (or if no criteria is specified), return empty list */
        if ( (snpAnnotationIDs.size() < 1) && (populationList.size() < 1) &&
                (params.size() < 1) )
            return new ArrayList<SNPFrequencyFinding>();

        String hql  = MessageFormat.format(targetHQL.toString(), new Object[] {
                            snpAnnotJoin, populationJoin, snpAnnotCond, populationCond });
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);
        q.setFirstResult(startIndex);
        q.setMaxResults(endIndex);
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
        Float pValue = crit.getHardyWeinbergPValue();
        Integer heterCount = crit.getHeterozygoteCount();
        Float minorAlleleFreq = crit.getMinorAlleleFrequency();
        Integer missingAlleleCnt = crit.getMissingAlleleCount();
        Integer missingGenotypeCnt = crit.getMissingGenotypeCount();
        String otherAllele = crit.getOtherAllele();
        Integer otherAllelCnt = crit.getOtherAlleleCount();
        Integer otherHomogyoteCnt = crit.getOtherHomogygoteCount();
        String referenceAllele = crit.getReferenceAllele();
        Integer referenceAlleleCnt = crit.getReferenceAlleleCount();
        Integer referenceHomogzoteCnt = crit.getReferenceHomogyzoteCount();


        if (pValue != null) {
            hql.append(" sf.hardyWeinbergPValue = :pValue AND ");
            params.put("pValue", pValue);
        }
        if (heterCount != null) {
           hql.append(" sf.heterozygoteCount = :heterCount AND ");
           params.put("heterCount", heterCount);
        }
        if (minorAlleleFreq != null) {
            hql.append(" sf.minorAlleleFrequency = :minorAlleleFreq AND ");
            params.put("minorAlleleFreq", minorAlleleFreq);
        }
        if (missingAlleleCnt != null) {
            hql.append(" sf.missingAlleleCount = :missingAlleleCnt AND ");
            params.put("missingAlleleCnt", missingAlleleCnt);
        }
        if (missingGenotypeCnt != null) {
            hql.append(" sf.missingAlleleCount = :missingGenotypeCnt AND ");
            params.put("missingGenotypeCount", missingGenotypeCnt);
        }
        if (otherAllele != null) {
            hql.append(" sf.missingAlleleCount = :otherAllele AND ");
            params.put("otherAllele", otherAllele);
        }
        if (otherAllelCnt != null) {
            hql.append(" sf.otherAlleleCount = :otherAllelCnt AND ");
            params.put("otherAllelCnt", otherAllelCnt);
        }
        if (otherHomogyoteCnt != null) {
            hql.append(" sf.otherHomogygoteCount = :otherHomogyoteCnt AND ");
            params.put("otherHomogyoteCnt", otherHomogyoteCnt);
        }
        if (referenceAllele != null) {
            hql.append(" sf.referenceAllele = :referenceAllele AND ");
            params.put("referenceAllele", referenceAllele);
        }
        if (referenceAlleleCnt != null) {
            hql.append(" sf.referenceAlleleCount = :referenceAlleleCnt AND ");
            params.put("referenceAlleleCnt", referenceAlleleCnt);
        }
        if (referenceHomogzoteCnt != null) {
            hql.append(" sf.referenceHomogyzoteCount = :referenceHomogzoteCnt AND ");
            params.put("referenceHomogzoteCnt", referenceHomogzoteCnt);
        }

    }
    protected void initializeProxies(Collection<? extends Finding> findings) {

    }
}
