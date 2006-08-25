package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.finding.bean.Finding;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.*;
import gov.nih.nci.caintegrator.util.ArithematicOperator;
import gov.nih.nci.caintegrator.util.HQLHelper;

import java.util.*;
import java.text.MessageFormat;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 21, 2006
 * Time:   2:20:11 PM
 */

public class SNPAssociationFindingsHandler extends FindingsHandler {
    protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs,  Session session, int start, int end) {
        List<SNPAssociationFinding>  snpAssociationFindings =
                            Collections.synchronizedList(new ArrayList<SNPAssociationFinding>());

        SNPAssociationFindingCriteriaDTO findingCritDTO = (SNPAssociationFindingCriteriaDTO) critDTO;
        StringBuffer targetHQL =
/*
                        new StringBuffer(
                            "SELECT sa,snpAnnot.id, snpAnnot.chromosomeLocation, " +
                                    " snpAnnot.chromosomeName, snpAnnot.dbsnpId," +
                                    " biomarkers.hugoGeneSymbol,  analysis.name " +
                                    " FROM SNPAssociationFinding sa " +
                                    " JOIN sa.snpAnnotation snpAnnot " +
                                    " JOIN snpAnnot.geneBiomarkerCollection biomarkers" +
                                    " JOIN sa.snpAssociationAnalysis analysis "  +
                                    " {0} {1} " +
                                    " WHERE {2} {3} {4} "
                        );
*/
                new StringBuffer(
                            " FROM SNPAssociationFinding sa JOIN sa.snpAnnotation snpAnnot " +
                            " JOIN sa.snpAssociationAnalysis analysis "  +
                            " {0} {1} " +
                            " WHERE {2} {3} {4} "
                    );

      //  if (snpAnnotationIDs != null && if (snpAnnotationIDs.size() > 0) {
      //      /* means some annotation criteria is specified */

        if (snpAnnotationIDs != null && snpAnnotationIDs.size() > 0) {
            ArrayList arrayIDs = new ArrayList(snpAnnotationIDs);
            for (int i = 0; i < arrayIDs.size();) {
                StringBuffer hql = new StringBuffer("").append(targetHQL);
                Collection values = new ArrayList();
                int begIndex = i;
                i += IN_PARAMETERS ;
                int endIndex = (i < arrayIDs.size()) ? endIndex = i : (arrayIDs.size());
                values.addAll(arrayIDs.subList(begIndex,  endIndex));
                Collection<SNPAssociationFinding> batchFindings = executeTargetFindingQuery(findingCritDTO, values, session, hql, start, end);
                snpAssociationFindings.addAll(batchFindings);
                if (snpAssociationFindings.size() > 500)  break;
            }
        }


        return snpAssociationFindings.subList(0, 500);
    }

    private Collection<SNPAssociationFinding> executeTargetFindingQuery(SNPAssociationFindingCriteriaDTO findingCritDTO, Collection<String> snpAnnotationIDs, Session session, StringBuffer targetHQL, int start, int end) {
        Collection<SNPAssociationFinding>  snpAssociationFindings =
                                    new ArrayList<SNPAssociationFinding>();

        final HashMap params = new HashMap();

        /* 1.  Include SNPAssociationFinding attribute criteria in  TargetFinding query */
        StringBuffer myAttributeHql = handleMyOwnAttributeCriteria(findingCritDTO, params);

        /* 2. Include Annotation Criteria in TargetFinding query   */
        String snpAnnotJoin = "";
        String snpAnnotCond = "";
        if (snpAnnotationIDs != null) {
            /* means some annotation criteria is specified */
            if (snpAnnotationIDs.size() > 0) {
                snpAnnotJoin = " LEFT JOIN FETCH sa.snpAnnotation ";
                snpAnnotCond = " sa.snpAnnotation.id IN (:snpAnnotationIDs) AND ";
                params.put("snpAnnotationIDs", snpAnnotationIDs);
            }
            else {
                /* means no annotations were selected from the Annotation Criteria Hence  when we
                   and with rest of other criteria, no results should be returned */
                snpAnnotJoin = " LEFT JOIN FETCH sa.snpAnnotation ";
                snpAnnotCond = " (0 != 0) AND ";
            }
        }

        /* 3. Include SNPAnalysisGroup Criteria in TargetFinding query by converting and adding to AnalysisGroupCriteria */
        handleAnalysisGroupCriteria(findingCritDTO, session);

        /* 4. Include SNPAssociationAnalysisCriteria Criteria in TargetFinding query */
        HashMap h = applySnpassociationAnalysisCriteria(findingCritDTO, params, targetHQL);
        String analysisJoin = (String) h.get("ANALYSIS_JOIN");
        String analysisCondition = h.get("ANALYSIS_COND").toString();

        /* 5. Assemble the Query with all criteria conditions together */
        String tmpHQL = MessageFormat.format(targetHQL.toString(), new Object[] {
                 snpAnnotJoin, analysisJoin, myAttributeHql, snpAnnotCond, analysisCondition});
        String hql= HQLHelper.removeTrailingToken(new StringBuffer(tmpHQL), " AND");
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), " OR");

        /* 6. Now execute the final TargetFinding query and return results  */
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);
        q.setFirstResult(start);
        q.setMaxResults(end);
        Iterator triplets = q.list().iterator();
        while(triplets.hasNext()) {
            Object[] triplet = (Object[]) triplets.next();
            SNPAssociationFinding finding = (SNPAssociationFinding) triplet[0];
            SNPAnnotation snpAnnot = (SNPAnnotation) triplet[1];
            finding.setSnpAnnotation(snpAnnot);
            SNPAssociationAnalysis analysis = (SNPAssociationAnalysis) triplet[2];
            finding.setSnpAssociationAnalysis(analysis);
            snpAssociationFindings.add(finding);
        }

        return snpAssociationFindings ;
    }

    private StringBuffer handleMyOwnAttributeCriteria(SNPAssociationFindingCriteriaDTO findingCritDTO, HashMap params) {
        StringBuffer myHql = new StringBuffer("");

        Float pValue = findingCritDTO.getpValue();
        if (pValue != null) {
            ArithematicOperator pValueOP = findingCritDTO.getpValueOperator();
            if (pValueOP == null) pValueOP = ArithematicOperator.EQ; // (default)
            StringBuffer hql = new StringBuffer("");
            String condition = prepareCondition(pValueOP);
            String clause = " sa.pvalue {0} :pValue AND ";
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("pValue", pValue);
            myHql.append(hql);
        }

        Integer rank = findingCritDTO.getRank();
        if (rank != null) {
            ArithematicOperator rankOP = findingCritDTO.getRankOperator();
            if (rankOP == null) rankOP = ArithematicOperator.EQ; // (default)
            StringBuffer hql = new StringBuffer("");
            String condition = prepareCondition(rankOP);
            String clause = " sa.rank {0} :rank AND ";
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("rank", rank);
            myHql.append(hql);
        }
        return myHql;
    }

    private String prepareCondition(ArithematicOperator pValueOP) {
        String condition = null;
        switch(pValueOP) {
            case GT: {
              condition = " > ";
              break;
            }
            case LT: {
              condition = " < ";
              break;
            }
            case EQ: {
              condition = " = ";
              break;
            }
            case LE: {
              condition = " <= ";
              break;
            }
            case GE: {
              condition = " >= ";
              break;
            }
            default: {
                // this should never happen.
                condition = " = ";
            }
         }

         return condition;
    }

    private void handleAnalysisGroupCriteria(SNPAssociationFindingCriteriaDTO findingCritDTO, Session session) {
        AnalysisGroupCriteria groupCrit = findingCritDTO.getAnalysisGroupCriteria();
        if (groupCrit != null) {
            String[] names = groupCrit.getNames();
            if (names != null && names.length > 0) {
               Criteria c = session.createCriteria(SNPAssociationAnalysis.class).createAlias("analysisGroupCollection", "analysisGroup").
                                          add(Restrictions.in("analysisGroup.name", names));

               List<SNPAssociationAnalysis> assocAnalysisObjs = c.list();

               /* 1. Convert these SNPAssociationAnalysis in to SNPAssociationAnalysisCriteria */
               Collection analysisCrits = new ArrayList<SNPAssociationAnalysisCriteria>();
               for (int i = 0; i < assocAnalysisObjs.size(); i++) {
                    SNPAssociationAnalysis assocAnalysisObj =  assocAnalysisObjs.get(i);
                    SNPAssociationAnalysisCriteria methodAndNameCrit =
                                                    new SNPAssociationAnalysisCriteria();
                    methodAndNameCrit.setMethods(assocAnalysisObj.getMethods());
                    methodAndNameCrit.setName(assocAnalysisObj.getName());
                    analysisCrits.add(methodAndNameCrit);
               }

               /* 2. Now set these SNPAssociationAnalysisCriteria objects back to SNPAssociationFindingCriteriaDTO */
               Collection<SNPAssociationAnalysisCriteria> anaCrits = findingCritDTO.getSnpAssociationAnalysisCriteriaCollection();
               if (anaCrits == null) {
                 /* means no SNPAssociationAnalysisCriteria was specified in the Query DTO
                    (SNPAssociationFindingCriteriaDTO) So intantiate one and add it to QueryDTO */
                  anaCrits = new ArrayList<SNPAssociationAnalysisCriteria>();
                  findingCritDTO.setSnpAssociationAnalysisCriteriaCollection(anaCrits);
               }
               anaCrits.addAll(analysisCrits);
            }
        }
    }

    /**
     * This method returns SNPAssociationAnalysis Condition & Join in a hashMap
     * @param findingCritDTO
     * @param params
     * @param targetHQL
     * @return Map containing Condition & Join
     */
    private HashMap applySnpassociationAnalysisCriteria(SNPAssociationFindingCriteriaDTO findingCritDTO,
                                                        HashMap params, StringBuffer targetHQL) {
        String analysisJoin = "";
        StringBuffer analysisCond = new StringBuffer("");
        Collection<SNPAssociationAnalysisCriteria>  anaCrits =
                findingCritDTO.getSnpAssociationAnalysisCriteriaCollection();

        if (anaCrits != null && anaCrits.size() > 0) {
            //analysisJoin = " LEFT JOIN FETCH sa.snpAssociationAnalysis ";
            int suffix = 0;
            for (Iterator<SNPAssociationAnalysisCriteria> iterator = anaCrits.iterator(); iterator.hasNext();) {
                SNPAssociationAnalysisCriteria anaCritObj =  iterator.next();
                String methods = anaCritObj.getMethods();
                String name = anaCritObj.getName();

                if ((methods == null) && (name == null)) continue;

                StringBuffer methodTrailingAND = new StringBuffer("");
                if (methods != null) {
                    String methodParam = "methods" + suffix;
                    StringBuffer tmpAnalysisCond = new StringBuffer("");
                    tmpAnalysisCond.append(" sa.snpAssociationAnalysis.methods = :{0} ");
                    analysisCond.append(MessageFormat.format(tmpAnalysisCond.toString(), new Object[] { methodParam }));
                    params.put(methodParam, methods);
                    methodTrailingAND.append(" AND ");
                }

                if (name != null) {
                    analysisCond.append(methodTrailingAND);
                    String nameParam = "name" + suffix;
                    StringBuffer tmpAnalysisCond = new StringBuffer("");
                    tmpAnalysisCond.append(" sa.snpAssociationAnalysis.name = :{0} ");
                    analysisCond.append(MessageFormat.format(tmpAnalysisCond.toString(), new Object[] { nameParam }));
                    params.put(nameParam, name);
                }
                analysisCond.append(" OR ");
                suffix++;
            }
        }

        String analCondition = HQLHelper.removeTrailingToken(new StringBuffer(analysisCond), " OR");
        String paramCond = " ( {0} ) ";
        String param = (analCondition.length() < 1) ? "(0 = 0)" : analCondition;
        String finalAnalysisCond = MessageFormat.format(paramCond, new Object[] {param} );



        HashMap h = new HashMap();
        h.put("ANALYSIS_JOIN", analysisJoin);
        h.put("ANALYSIS_COND", finalAnalysisCond);

        return h;
    }

    protected void initializeProxies(Collection<? extends Finding> findings, Session session) {
        List<GeneBiomarker> gbObjs = new ArrayList<GeneBiomarker>();
        for (Iterator<? extends Finding> iterator = findings.iterator(); iterator.hasNext();) {
           SNPAssociationFinding finding = (SNPAssociationFinding) iterator.next();
           gbObjs.addAll(finding.getSnpAnnotation().getGeneBiomarkerCollection());
           //Collection<GeneBiomarker> gbs = finding.getSnpAnnotation().getGeneBiomarkerCollection();
        }
        Hibernate.initialize(gbObjs);
    }

}
