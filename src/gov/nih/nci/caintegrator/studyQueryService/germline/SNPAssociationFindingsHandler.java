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
	
    protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs,  Session session, int startIndex, int endIndex) {
        List<SNPAssociationFinding>  snpAssociationFindings =
                            Collections.synchronizedList(new ArrayList<SNPAssociationFinding>());

        /* if AnnotationCriteria results in no SNPs then return no findings */
          if (snpAnnotationIDs != null && snpAnnotationIDs.size() == 0)
              return snpAssociationFindings;

        SNPAssociationFindingCriteriaDTO findingCritDTO = (SNPAssociationFindingCriteriaDTO) critDTO;
        StringBuffer targetHQL = new StringBuffer(
                            " FROM SNPAssociationFinding " + TARGET_FINDING_ALIAS +
                             " JOIN "+ TARGET_FINDING_ALIAS +
                              ".snpAnnotation snpAnnot " + " JOIN "+ TARGET_FINDING_ALIAS +
                              ".snpAssociationAnalysis analysis "  + " {0} {1} " +
                              " WHERE {2} {3} {4} "
                            );

        if (snpAnnotationIDs != null && snpAnnotationIDs.size() > 0)
        {
            ArrayList arrayIDs = new ArrayList(snpAnnotationIDs);
            for (int i = critDTO.getIndex(); i < arrayIDs.size();) {
                StringBuffer hql = new StringBuffer("").append(targetHQL);
                Collection values = new ArrayList();
                int begIndex = i;
                i += IN_PARAMETERS ;
                int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
                values.addAll(arrayIDs.subList(begIndex,  lastIndex));
                Collection<SNPAssociationFinding> batchFindings = executeTargetFindingQuery(findingCritDTO, values, session, hql, startIndex, endIndex);
                snpAssociationFindings.addAll(batchFindings);
                if (snpAssociationFindings.size() >= (endIndex - startIndex + 1))
                {
                	critDTO.setIndex(lastIndex);
                    return snpAssociationFindings;
                }
            }
        } else { /* means no AnnotationCriteria was specified in the FindingCriteriaDTO  */
             Collection<SNPAssociationFinding> findings = executeTargetFindingQuery(
                    critDTO, session, targetHQL, startIndex, endIndex);
              snpAssociationFindings.addAll(findings);
        }
        return snpAssociationFindings;
    }

    /**
     *
     * @param critDTO
     * @param snpAnnotationIDs
     * @param session
     * @param targetHQL
     * @param start This is the start index.  A value of -1 represents not to use this param
     * in the actual query to Hibernate
     * @param end This is the end Index. A value of -1 represents not to use this param
     * in the actual query to Hibernate
     * @return  Collection of SNPAssociationFindings
     */
    protected Collection<SNPAssociationFinding> executeTargetFindingQuery(FindingCriteriaDTO critDTO,
                            Collection<String> snpAnnotationIDs,
                            Session session, StringBuffer targetHQL
                            ,int start, int end
                            ) {

        SNPAssociationFindingCriteriaDTO  findingCritDTO= (SNPAssociationFindingCriteriaDTO) critDTO;
        Collection<SNPAssociationFinding>  snpAssociationFindings =
                                    new ArrayList<SNPAssociationFinding>();

        final HashMap params = new HashMap();

        /* 1.  Include SNPAssociationFinding attribute criteria in  TargetFinding query */
        StringBuffer myAttributeHql = handleMyOwnAttributeCriteria(findingCritDTO, params);

        /* 2. Include HQL to handle Annotation Criteria to snpAnnotJoin & snpAnnotCond */
        StringBuffer snpAnnotJoin = new StringBuffer("");
        StringBuffer snpAnnotCond = new StringBuffer("");
        appendAnnotationCriteriaHQL(snpAnnotationIDs, snpAnnotJoin, snpAnnotCond, params);

        /* 3. Include SNPAnalysisGroup Criteria in TargetFinding query by converting and adding to AnalysisGroupCriteria */
        handleAnalysisGroupCriteria(findingCritDTO, session);

        /* 4. Include SNPAssociationAnalysisCriteria Criteria in TargetFinding query */
        HashMap h = applySnpassociationAnalysisCriteria(findingCritDTO, params, targetHQL);
        String analysisJoin = (String) h.get("ANALYSIS_JOIN");
        String analysisCondition = h.get("ANALYSIS_COND").toString();

        /* 5. Assemble the Query with all criteria conditions together */
        String tmpHQL = MessageFormat.format(targetHQL.toString(), new Object[] {
                 snpAnnotJoin.toString(), analysisJoin, myAttributeHql, snpAnnotCond.toString(), analysisCondition});
        String hql= HQLHelper.removeTrailingToken(new StringBuffer(tmpHQL), " AND");
        String noORHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), " OR");
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(noORHQL), "WHERE");

        /* 6. Now execute the final TargetFinding query and return results  */
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);

        if (start == -1 || end == -1) {
            // do not use these indexes.  Just retrieve everything
        }
        else { // set the index values
            q.setFirstResult(start); //RAM: 09/22/06 changed back to original before ftp bug
            q.setMaxResults(end - start);
        }
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
    
    protected Collection<SNPAssociationFinding> executeTargetFindingQuery(FindingCriteriaDTO critDTO, Session session, StringBuffer targetHQL, int start, int end) {

        SNPAssociationFindingCriteriaDTO  findingCritDTO= (SNPAssociationFindingCriteriaDTO) critDTO;
        Collection<SNPAssociationFinding>  snpAssociationFindings =
                                    new ArrayList<SNPAssociationFinding>();

        final HashMap params = new HashMap();

        /* 1.  Include SNPAssociationFinding attribute criteria in  TargetFinding query */
        StringBuffer myAttributeHql = handleMyOwnAttributeCriteria(findingCritDTO, params);

        /* 2. Include HQL to handle Annotation Criteria to snpAnnotJoin & snpAnnotCond */
        StringBuffer snpAnnotJoin = new StringBuffer("");
        StringBuffer snpAnnotCond = new StringBuffer("");

        /* 3. Include SNPAnalysisGroup Criteria in TargetFinding query by converting and adding to AnalysisGroupCriteria */
        handleAnalysisGroupCriteria(findingCritDTO, session);

        /* 4. Include SNPAssociationAnalysisCriteria Criteria in TargetFinding query */
        HashMap h = applySnpassociationAnalysisCriteria(findingCritDTO, params, targetHQL);
        String analysisJoin = (String) h.get("ANALYSIS_JOIN");
        String analysisCondition = h.get("ANALYSIS_COND").toString();

        /* 5. Assemble the Query with all criteria conditions together */
        String tmpHQL = MessageFormat.format(targetHQL.toString(), new Object[] {
                 snpAnnotJoin.toString(), analysisJoin, myAttributeHql, snpAnnotCond.toString(), analysisCondition});
        String hql= HQLHelper.removeTrailingToken(new StringBuffer(tmpHQL), " AND");
        String noORHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), " OR");
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(noORHQL), "WHERE");

        /* 6. Now execute the final TargetFinding query and return results  */
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);
        q.setFirstResult(start);
        q.setMaxResults(end - start);
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
            String condition = HQLHelper.prepareCondition(pValueOP);
            String clause = TARGET_FINDING_ALIAS + ".pvalue {0} :pValue AND ";
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
            String condition = HQLHelper.prepareCondition(rankOP);
            String clause = TARGET_FINDING_ALIAS + ".rank {0} :rank AND ";
            String formattedClause = MessageFormat.format(clause, new Object[] {condition} );
            hql.append(formattedClause);
            params.put("rank", rank);
            myHql.append(hql);
        }
        return myHql;
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
                    tmpAnalysisCond.append( TARGET_FINDING_ALIAS + ".snpAssociationAnalysis.methods = :{0} ");
                    analysisCond.append(MessageFormat.format(tmpAnalysisCond.toString(), new Object[] { methodParam }));
                    params.put(methodParam, methods);
                    methodTrailingAND.append(" AND ");
                }

                if (name != null) {
                    analysisCond.append(methodTrailingAND);
                    String nameParam = "name" + suffix;
                    StringBuffer tmpAnalysisCond = new StringBuffer("");
                    tmpAnalysisCond.append(TARGET_FINDING_ALIAS + ".snpAssociationAnalysis.name = :{0} ");
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
        }
        Hibernate.initialize(gbObjs);
    }

     protected void sendMyFindings(FindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs,
                                   Session session, List toBePopulated) {

        /* if AnnotationCriteria results in no SNPs then return no findings */
          if (snpAnnotationIDs != null && snpAnnotationIDs.size() == 0)
              return ;

        SNPAssociationFindingCriteriaDTO findingCritDTO = (SNPAssociationFindingCriteriaDTO) critDTO;
        StringBuffer targetHQL = new StringBuffer(
                            " FROM SNPAssociationFinding " + TARGET_FINDING_ALIAS +
                             " JOIN "+ TARGET_FINDING_ALIAS +
                              ".snpAnnotation snpAnnot " + " JOIN "+ TARGET_FINDING_ALIAS +
                              ".snpAssociationAnalysis analysis "  + " {0} {1} " +
                              " WHERE {2} {3} {4} "
                            );

        if (snpAnnotationIDs != null && snpAnnotationIDs.size() > 0) {
            handleFindingsWithAnnotationCriteria(snpAnnotationIDs, targetHQL, findingCritDTO,
                                                                             session, toBePopulated);
        }  else { /* means no AnnotationCriteria was specified in the FindingCriteriaDTO */
            handleFindingsWithoutAnnotationCriteria(critDTO, session, targetHQL, toBePopulated);
        }
        return ;
    }

    private void handleFindingsWithAnnotationCriteria(
                                Set<String> snpAnnotationIDs, StringBuffer targetHQL,
                                SNPAssociationFindingCriteriaDTO findingCritDTO,
                                Session session, List toBePopulated) {

        List<SNPAssociationFinding>  snpAssociationFindings = new ArrayList<SNPAssociationFinding>();
        ArrayList arrayIDs = new ArrayList(snpAnnotationIDs);
        for (int i = 0; i < arrayIDs.size();) {
             StringBuffer hql = new StringBuffer("").append(targetHQL);
             Collection values = new ArrayList();
             int begIndex = i;
             i += IN_PARAMETERS ;
             int lastIndex = (i < arrayIDs.size()) ? i : (arrayIDs.size());
             values.addAll(arrayIDs.subList(begIndex,  lastIndex));

             /* send -1 for start & end index to indicate these values not to be included
                in the final Hibernate Query */
             Collection<SNPAssociationFinding> currentFindings =
                                        executeTargetFindingQuery(findingCritDTO, values, session, hql, -1, -1);
             initializeProxies(currentFindings, session);

             /* convert these  currentFindings in to a List for convenience */
             snpAssociationFindings.addAll(currentFindings );

             while (snpAssociationFindings.size() >= BATCH_OBJECT_INCREMENT )  {
                 populateCurrentResultSet(snpAssociationFindings, toBePopulated);
             }
        }
        /* Now write remaining findings i.e. less than 500 in one call */
        if (snpAssociationFindings != null)
            populateCurrentResultSet(snpAssociationFindings, toBePopulated);

        /* Finally after all the results were written, write an empty Object (HashSet of size=0
          to indicate the caller that all results were written */
         populateCurrentResultSet(new ArrayList<SNPAssociationFinding>(), toBePopulated);

    }

    private void populateCurrentResultSet(List<SNPAssociationFinding> snpAssociationFindings, List toBePopulated) {
        /*  1. Remove the first 500 objects and add it to a new HashSet */
        HashSet<SNPAssociationFinding> toBeSent = new HashSet<SNPAssociationFinding>();

        int size = snpAssociationFindings.size();
        //for (int index = 0;  (toBeSent.size() < size) && (index <= BATCH_OBJECT_INCREMENT); index++) {
        for (int index = 0;  (index < size) && (index <= BATCH_OBJECT_INCREMENT); index++) {
            SNPAssociationFinding f =  snpAssociationFindings.remove(0);
            toBeSent.add(f);
        }


        /* 2. Add results to toBePopulated after making sure it is empty */
         do {
            synchronized(toBePopulated) {
                   if (toBePopulated.size() == 0)  {
                       toBePopulated.add(toBeSent);
                       break;
                   }
            }
            try {
                 Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                   e.printStackTrace(); // no big deal
            }
         } while (true);
    }

    private void handleFindingsWithoutAnnotationCriteria(FindingCriteriaDTO critDTO, Session session, StringBuffer targetHQL, List toBePopulated) {
        Collection<SNPAssociationFinding> findings ;

        int start = 0;
        int end = FindingsHandler.BATCH_OBJECT_INCREMENT ;  // 500 for now
        HashSet<SNPAssociationFinding> toBeSent = null;
        do {
            findings =  executeTargetFindingQuery(
                      critDTO, null, session, targetHQL, start, end);
            initializeProxies(findings, session);

            toBeSent = new HashSet<SNPAssociationFinding>();
            toBeSent.addAll(findings);


/*
            //Add results to toBePopulated after making sure it is empty
            while (true) {
                synchronized(toBePopulated) {
                   if (toBePopulated.size() == 0)  {
                      toBePopulated.add(toBeSent);
                      break;
                   }
                }
                try {
                     Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                       e.printStackTrace(); // no big deal
                }
             }

*/

            process(toBePopulated,  toBeSent);
            start += BATCH_OBJECT_INCREMENT;
            end += BATCH_OBJECT_INCREMENT;;

        }  while(findings.size() >= BATCH_OBJECT_INCREMENT );

        /* send empty data object to let the client know that no more results are present */
        process(toBePopulated, new HashSet<SNPAssociationFinding>());
    }


    private void process(List toBePopulated, HashSet<SNPAssociationFinding> toBeSent) {

        /*  Add results to toBePopulated after making sure it is empty */
        while (true) {
            synchronized(toBePopulated) {
               if (toBePopulated.size() == 0)  {
                  toBePopulated.add(toBeSent);
                  break;
               }
            }
            try {
                 Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                   e.printStackTrace(); // no big deal
            }
         }
         return;
    }

   /* protected Collection<? extends Finding> getMyFindings(FindingCriteriaDTO critDTO, Set<String> snpAnnotationIDs, Session session) {
        List<SNPAssociationFinding>  associationFindings = Collections.synchronizedList(
                                                   new ArrayList<SNPAssociationFinding>());
        int fromIndex = 0;
        int toIndex = fromIndex + BATCH_OBJECT_INCREMENT;
        Collection batchFindings = new ArrayList<SNPAssociationFinding>();
        do {
            batchFindings =
                    getMyFindings(critDTO, snpAnnotationIDs, session, fromIndex, toIndex);
            associationFindings.addAll(batchFindings);
            fromIndex =  toIndex;
            toIndex = fromIndex + BATCH_OBJECT_INCREMENT;;
            System.out.println("Start Index:"+ fromIndex + " End Index:" + toIndex +
                    " Findings Retrieved: " + associationFindings.size());
        }  while(batchFindings.size() >= BATCH_OBJECT_INCREMENT);

        System.out.println("TOTAL associationFindings retrieved: " + associationFindings.size());
        return associationFindings;
    }*/

}
