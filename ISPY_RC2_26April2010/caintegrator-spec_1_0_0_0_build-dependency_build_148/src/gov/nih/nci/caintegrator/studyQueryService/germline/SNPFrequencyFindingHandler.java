package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPFrequencyFindingCriteriaDTO;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

import java.util.*;
import java.text.MessageFormat;

import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 17, 2006
 * Time:   5:52:11 PM
 */
public class SNPFrequencyFindingHandler extends FindingsHandler {

    protected Class getTargeFindingType() {
        return SNPFrequencyFinding.class;
    }
    protected List<? extends Finding> getConcreteTypedFindingList() {
        return new ArrayList<SNPFrequencyFinding>();
    }

    protected Set getConcreteTypedFindingSet() {
        return new HashSet<SNPFrequencyFinding>();
    }

    protected StringBuffer getTargetFindingHQL() {
        StringBuffer targetHQL = new StringBuffer(" FROM SNPFrequencyFinding "+ TARGET_FINDING_ALIAS +
                                                  " {0} {1} WHERE {2} {3} ");
        return targetHQL;
    }

    protected Collection< ? extends Finding> executeFindingSetQuery(FindingCriteriaDTO critDTO,StringBuffer targetHQL,
                                                               Session session, int start, int end ) throws Exception {
        SNPFrequencyFindingCriteriaDTO findingCritDTO = (SNPFrequencyFindingCriteriaDTO) critDTO;
        AnnotationCriteria annotCrit = critDTO.getAnnotationCriteria();
        if ((annotCrit != null) && isOnlyPanelCriteria(annotCrit))
               return executePanelOnlySearch(critDTO, session, start, end);

        HashMap params = new HashMap();
        StringBuffer snpAnnotCond = new StringBuffer();

        /* 0. if AnnotationCrit is specified, then append required HQL (to snpAnnotCondition) for handling AnnotationCrit*/
        appendAnnotationCritHQL(critDTO, params, snpAnnotCond);
        
        /* 1. Include Annotation Criteria in TargetFinding query   */
        StringBuffer snpAnnotJoin = new StringBuffer("");

       /*  2. Handle population Criteria */
       StringBuffer populationJoin = new StringBuffer("");
       StringBuffer populationCond = new StringBuffer("");
       preparePopulationCriteria(findingCritDTO, session, populationJoin, populationCond, params);

       String hql  = MessageFormat.format(targetHQL.toString(),
                                new Object[] {  snpAnnotJoin.toString(), populationJoin.toString(),
                                                snpAnnotCond.toString(), populationCond.toString() });

       StringBuffer formattedTargetHQL = new StringBuffer(hql);

       /*  3. Handle SNPFrequencyFinding Attributes Criteria itself  and populate targetHQL/params */
       addSNPFrequencyFindingAttriuteCrit(findingCritDTO, formattedTargetHQL, params);

       String andRemovedHQL = HQLHelper.removeTrailingToken(new StringBuffer(formattedTargetHQL), "AND");
       String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(andRemovedHQL), "WHERE");
       Query q = session.createQuery(finalHQL);
       HQLHelper.setParamsOnQuery(params, q);
       q.setFirstResult(start);
       q.setMaxResults(end - start);

       List<SNPFrequencyFinding> findings = q.list();
       HashSet<SNPFrequencyFinding> results = new HashSet<SNPFrequencyFinding>();
       results.addAll(findings);
       return results;
    }

    private List<Population> handlePopulationCriteria(SNPFrequencyFindingCriteriaDTO findingCritDTO, Session session) {
       String[] populationNames = findingCritDTO.getPopulationNames();
       String studyName = findingCritDTO.getStudyName();
       String sponsorIdentifier = findingCritDTO.getSponsorStudyIdentifier();

       if ((populationNames == null || populationNames.length < 1) && (studyName == null || studyName.length() < 1) &&
                                                    (sponsorIdentifier == null || sponsorIdentifier.length() < 1) ) {
            return new ArrayList<Population>();
       }

       Criteria popCrit = session.createCriteria(Population.class);
       if (populationNames != null && populationNames.length > 0) {
           popCrit.add(Restrictions.in("name", populationNames));
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

    public void addSNPFrequencyFindingAttriuteCrit(SNPFrequencyFindingCriteriaDTO crit, StringBuffer hql, HashMap params) {
        StudyCriteria studyCrit = crit.getStudyCriteria();

        Float hardyWeinbergPValue  = crit.getHardyWeinbergPValue();
        ArithematicOperator hardyWeinbergPValueOperator = crit.getHardyWeinbergPValueOperator();

        Float minorAlleleFreq = crit.getMinorAlleleFrequency();
        ArithematicOperator minorAlleleOperator = crit.getMinorAlleleOperator();

        Double completionRate = crit.getCompletionRate();
        ArithematicOperator completeRateOperator = crit.getCompleteRateOperator();

        Integer heterCount = crit.getHeterozygoteCount();
        Integer missingAlleleCnt = crit.getMissingAlleleCount();
        Integer missingGenotypeCnt = crit.getMissingGenotypeCount();
        String otherAllele = crit.getOtherAllele();
        Integer otherAllelCnt = crit.getOtherAlleleCount();
        Integer otherHomogyoteCnt = crit.getOtherHomogygoteCount();
        String referenceAllele = crit.getReferenceAllele();
        Integer referenceAlleleCnt = crit.getReferenceAlleleCount();
        Integer referenceHomogzoteCnt = crit.getReferenceHomogyzoteCount();

        if (completionRate != null) {
            if (completeRateOperator == null) completeRateOperator = ArithematicOperator.EQ; // default
            String clause =  TARGET_FINDING_ALIAS + ".completionRate {0} :completionRate AND ";
            String condition = HQLHelper.prepareCondition(completeRateOperator);
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("completionRate", completionRate);
        }

        if (hardyWeinbergPValue != null) {
            if (hardyWeinbergPValueOperator == null) hardyWeinbergPValueOperator = ArithematicOperator.EQ; // default
            String clause =  TARGET_FINDING_ALIAS + ".hardyWeinbergPValue {0} :hardyWeinbergPValue AND ";
            String condition = HQLHelper.prepareCondition(hardyWeinbergPValueOperator);
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("hardyWeinbergPValue", hardyWeinbergPValue);
        }

        if (minorAlleleFreq != null) {
            if (minorAlleleOperator == null) minorAlleleOperator = ArithematicOperator.EQ; // default
            String clause =  TARGET_FINDING_ALIAS + ".minorAlleleFrequency  {0} :minorAlleleFrequency  AND ";
            String condition = HQLHelper.prepareCondition(minorAlleleOperator);
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("minorAlleleFrequency", minorAlleleFreq);
        }

        if (heterCount != null) {
           hql.append( TARGET_FINDING_ALIAS + ".heterozygoteCount = :heterCount AND ");
           params.put("heterCount", heterCount);
        }

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

        if (studyCrit != null) {
            if (studyCrit.getName() != null) {
                hql.append( TARGET_FINDING_ALIAS + ".study.name = :studyName AND ");
                params.put("studyName", studyCrit.getName().trim());
            }
        }

    }
    protected void initializeProxies(Collection<? extends Finding> findings, Session session) {

        /* initialize SNPAnnotations */
//        Collection<String> snpAnnotsIDs = new HashSet<String>();
//        Collection<Long> populationIDs = new HashSet<Long>();
//        for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
//                SNPFrequencyFinding finding =  (SNPFrequencyFinding) iterator.next();
//                snpAnnotsIDs.add(finding.getSnpAnnotation().getId());
//                populationIDs.add(finding.getPopulation().getId());
//        }
//        if(snpAnnotsIDs.size() >0) {
//              ArrayList arrayIDs = new ArrayList(snpAnnotsIDs);
//              for (int i = 0; i < arrayIDs.size();) {
//                  Collection values = new ArrayList();
//                  int begIndex = i;
//                  i += IN_PARAMETERS ;
//                  int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
//                  values.addAll(arrayIDs.subList(begIndex,  lastIndex));
//                  Criteria snpAnnotcrit = session.createCriteria(SNPAnnotation.class).
//                  setFetchMode("geneBiomarkerCollection", FetchMode.EAGER).
//                  add(Restrictions.in("id", values));
//                  snpAnnotcrit.list();
//              }
//        }
//
//        /* initialize Population */
//        if (populationIDs.size() > 0) {
//            Criteria populationCrit = session.createCriteria(Population.class).
//                                add(Restrictions.in("id", populationIDs));
//            populationCrit.list();
//        }

        Collection findingIDs = new HashSet();
        for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
           SNPFrequencyFinding finding = (SNPFrequencyFinding) iterator.next();
           findingIDs.add(finding.getId());
        }

        Criteria crit;
        ArrayList<String> arrayIDs = new ArrayList<String>(findingIDs);
        for (int i = 0; i < arrayIDs.size();) {
            List<String> values = new ArrayList<String>();
            int begIndex = i;
            i += 1000 ;
            int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
            values.addAll(arrayIDs.subList(begIndex,  lastIndex));
            crit = session.createCriteria(SNPAnnotation.class).
                                      createAlias("snpFrequencyCollection", "findings").
                                      setFetchMode("geneBiomarkerCollection", FetchMode.EAGER).
                                      add(Restrictions.in("findings.id", values));
            crit.list();
        }

        for (int i = 0; i < arrayIDs.size();) {
            List<String> values = new ArrayList<String>();
            int begIndex = i;
            i += 1000 ;
            int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
            values.addAll(arrayIDs.subList(begIndex,  lastIndex));
            crit = session.createCriteria(Population.class).
                                        createAlias("snpFrequencyCollection", "findings").
                                        add(Restrictions.in("findings.id", values));
            crit.list();
        }
    }

   protected Collection<? extends Finding> getFindingsFromResults(List results) {
        Collection<SNPFrequencyFinding> findings = new ArrayList<SNPFrequencyFinding>(results.size());
        Iterator findingsAndAnnotsIter = results.iterator();
        while(findingsAndAnnotsIter.hasNext()) {
            Object[] duplet = (Object[]) findingsAndAnnotsIter.next();
            SNPFrequencyFinding finding = (SNPFrequencyFinding) duplet[0];
            findings.add(finding);
        }
        return findings;
    }

    public Collection<? extends Finding> executePanelOnlySearch(FindingCriteriaDTO critDTO, Session session,
                                                                                                int start, int end) {
        SNPFrequencyFindingCriteriaDTO   findingCritDTO = (SNPFrequencyFindingCriteriaDTO)critDTO;
        AnnotationCriteria annotCrit = findingCritDTO.getAnnotationCriteria();

        final StringBuffer snpTargetHQL = new StringBuffer(
                                      " FROM SNPFrequencyFinding "+ TARGET_FINDING_ALIAS + ", SNPAssay s  JOIN "+
                                      TARGET_FINDING_ALIAS + ".snpAnnotation " + " {0} WHERE s.snpPanel.id = {1} AND "+
                                      TARGET_FINDING_ALIAS + ".snpAnnotation = s.snpAnnotation " + " AND {2} ");

        HashMap params = new HashMap();
        StringBuffer populationJoin = new StringBuffer("");
        StringBuffer populationCond = new StringBuffer("");
        preparePopulationCriteria(findingCritDTO, session, populationJoin, populationCond, params);

        StringBuffer hql = new StringBuffer (
                          MessageFormat.format( snpTargetHQL.toString(),
                                        new Object[] { populationJoin.toString(),
                                          annotCrit.getPanelCriteria().getSnpPanelID(), populationCond.toString() }));

        StringBuffer hqlWithAND = new StringBuffer(HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND"));
        hqlWithAND.append(" AND ");

        StringBuffer formattedTargetHQL = new StringBuffer(hqlWithAND);
        addSNPFrequencyFindingAttriuteCrit(findingCritDTO, formattedTargetHQL, params);

        String andRemovedHQL = HQLHelper.removeTrailingToken(new StringBuffer(formattedTargetHQL), "AND");
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(andRemovedHQL), "WHERE");
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);

        if (start == -1 || end == -1) {}
        else {
            q.setFirstResult(start);
            q.setMaxResults(end - start);
        }

        Collection<? extends Finding> finalResults = getFindingsFromResults(q.list());
        initializeProxies(finalResults, session);
        List<SNPFrequencyFinding> results =  new ArrayList<SNPFrequencyFinding>(finalResults.size());
        for (Iterator<? extends Finding> iterator = finalResults.iterator(); iterator.hasNext();) {
            SNPFrequencyFinding finding =  (SNPFrequencyFinding)iterator.next();
            results.add(finding);
        }
        return results;
    }

    private void preparePopulationCriteria(SNPFrequencyFindingCriteriaDTO findingCritDTO, Session session, StringBuffer populationJoin, StringBuffer populationCond, HashMap params) {
        List<Population> populationList = handlePopulationCriteria(findingCritDTO, session);
        if (populationList.size() > 0) {
           populationJoin.append(" LEFT JOIN FETCH " + TARGET_FINDING_ALIAS + ".population ");
           populationCond.append( TARGET_FINDING_ALIAS + ".population IN (:populationList) AND ");
           params.put("populationList", populationList);
        }
    }

}
