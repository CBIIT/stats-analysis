package gov.nih.nci.caintegrator.studyQueryService.germline;

import org.hibernate.Session;
import org.hibernate.Query;

import java.util.*;
import java.text.MessageFormat;

import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.PhysicalPositionCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.PanelCriteria;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 5, 2006
 * Time:   4:52:03 PM
 */
public class SNPAnnotationCriteriaHandler {
    /**
     * This method converts each of the annotation specified in the criteria in
     * to AnnotationIDs.  In the current release only PanelCriteria, PositionCriteria
    *  and SnpIdentifier are only supported.  CytobandCriteria,   GenePathways,
    *  GeneOntology are not supported in thie release.
    *  criteria
     *
     * @param annotCrit
     * @param session
     * @return Set of SNPAnnotation IDs
     */

    public static Set<String> handle(AnnotationCriteria annotCrit,  Session session)
    throws Exception {

        Set<String> allSNPAnnotIDs = new HashSet();
        if (annotCrit == null) return allSNPAnnotIDs;

        List<SNPAnnotation> annotObjs = getSNPAnnotations(annotCrit, session);

        /* add ids from this annotObjs list to results i.e allSNPAnnotIDs */
        for (int i = 0; i < annotObjs.size(); i++) {
            SNPAnnotation snpAnnotation =  annotObjs.get(i);
            allSNPAnnotIDs.add(snpAnnotation.getId());
        }

        System.out.println("Total SNPAnnotations Retrieved: " + allSNPAnnotIDs.size());
        return allSNPAnnotIDs;
    }

    /**
     * This method retrieves ANPAnnotations based on AnnotationCriteria passed in.
     * In the current release AnnotationCriteria only PanelCriteria, PositionCriteria
     * and SnpIdentifier are supported.  CytobandCriteria,   GenePathways,
     *  GeneOntology will be supported in later releases.
     *
     * @param annotCrit
     * @param session
     * @return List of SNPAnnotation objects
     */

    public static List<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit,  Session session)
    throws Exception {

        List<SNPAnnotation> annotObjs = new ArrayList<SNPAnnotation>();
        if (annotCrit == null) return annotObjs;

        PhysicalPositionCriteria poistionCrit = annotCrit.getPhysicalPositionCriteria();
        Collection<String> dbSNPIdentifiers = annotCrit.getSnpIdentifiers();
        Collection<String> geneSymbols = annotCrit.getGeneSymbols();

        HashMap params = new HashMap();  // used to hold HQL parameters

        PanelCriteria panelCrit = annotCrit.getPanelCriteria();
        /* at least one other annotation should be specified when panelCriteria
           is specified in the AnnotationCriteria.  Otherwise throw an exception */
        if ((panelCrit != null) && (poistionCrit == null && dbSNPIdentifiers == null) )
          throw new Exception("At least one other annotation should be specified with panelCriteria ");

        /* 1.  Handle SNPAnnotation itself */
        String annotHSQL = new String(" FROM SNPAnnotation s WHERE {0} ");
        StringBuffer snpAnnotHSQL = new StringBuffer(annotHSQL);
        String geneSymbolCond = "";
        if (geneSymbols != null && geneSymbols.size() > 0) {
            geneSymbolCond = " s.geneBiomarkerCollection.hugoGeneSymbol IN (:geneSymbols) OR ";
            params.put("geneSymbols", geneSymbols);
        }

        /* 2 Handle PhysicalPositionCriteria */
        if (poistionCrit != null) {
            handlePositionCriteria(poistionCrit, snpAnnotHSQL, params);
        }

        /* 3 Handle CytobandCriteria, GeneOntology, GenePathway */
        if ((annotCrit.getCytobandCriteria() != null) ||
           (annotCrit.getGeneOntology() != null) || (annotCrit.getGenePathways() != null) )
           throw new RuntimeException (" This method is not implelemted for now: ");

        /* 4 Handle SNPIdentifiers */
        dbSNPIdentifiers = annotCrit.getSnpIdentifiers();
        if (dbSNPIdentifiers !=  null && dbSNPIdentifiers.size() > 0) {
            String tmp = new String(" s.dbsnpId IN (:dbSnps ) OR ");
            params.put("dbSnps", dbSNPIdentifiers);
            snpAnnotHSQL.append(tmp);
        }

        /* 5 Remove any trailing AND / OR and append AND */
        String paramReplacedHql = MessageFormat.format(snpAnnotHSQL.toString(), new Object[] { geneSymbolCond });
        String interHSQL = HQLHelper.removeTrailingAND(new StringBuffer(paramReplacedHql));
        String finalWithWhereHSQL = HQLHelper.removeTrailingOR(new StringBuffer(interHSQL));
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(finalWithWhereHSQL), "WHERE");

        /* 6  Handle PanelCritera */
        String panelBasedSNPAnnotCrit = handlePanelCriteriaInHSQL(panelCrit, params);
/*
        if (panelBasedSNPAnnotCrit.length() > 0) {
            // append the above SNPAnnotation criteria as sub select
           panelBasedSNPAnnotCrit.append(" ( " + finalHQL + " )");
        }
        else {
           panelBasedSNPAnnotCrit.append(finalHQL);
        }
*/
        // add panel criteria to the above SNPAnnotation criteria as subselect
        StringBuffer allAnnotCrit = new StringBuffer().append(finalHQL).append(panelBasedSNPAnnotCrit);
        Query q = session.createQuery(allAnnotCrit.toString());
        HQLHelper.setParamsOnQuery(params, q);
        annotObjs =  q.list();
        return annotObjs;
    }

    private static void handlePositionCriteria(PhysicalPositionCriteria poistionCrit, StringBuffer snpAnnotHSQL, HashMap params) {
        String chromosome = poistionCrit.getChromosome();
        Integer startPos = poistionCrit.getStartPosition();
        Integer endPos = poistionCrit.getEndPosition();

        if ((chromosome == null) || (startPos == null) || (endPos == null) )
             throw new RuntimeException("Chromosme, StartPosition, EndPosition are required ");
        String tmp = new String(" (s.chromosomeName=:chr AND ( s.chromosomeLocation  BETWEEN :start AND :end )) OR ");
        params.put("chr", chromosome);
        params.put("start", startPos);
        params.put("end", endPos);
        snpAnnotHSQL.append(tmp);
    }

    private static String handlePanelCriteriaInHSQL(PanelCriteria panelCrit,  HashMap params ) {
            StringBuffer emptyBuffer = new StringBuffer("");
            if (panelCrit == null) return emptyBuffer.toString();

            String name = panelCrit.getName();
            String version = panelCrit.getVersion();

            if (name == null & version == null) return emptyBuffer.toString();

            StringBuffer snpAnnotIDsCrit = new StringBuffer(
      //              " SELECT annot
                    //  FROM SNPAssay sa join sa.snpAnnotation annot join sa.snpPanel sp WHERE ");
                //"  FROM SNPAssay sa JOIN sa.snpPanel sp WHERE ");
                " OR s.id IN ( SELECT sa.snpAnnotation.id " +
                              " FROM SNPAssay sa JOIN sa.snpPanel sp WHERE ");

            if (name != null) {
              snpAnnotIDsCrit.append(" sp.name = :name AND ");
              params.put( "name", name);
            }
            if (version != null) {
              snpAnnotIDsCrit.append(" sp.version = :version ");
              params.put( "version", version);
            }

            String interHQL = HQLHelper.removeTrailingToken(snpAnnotIDsCrit, "AND");
            StringBuffer finalHQL = new StringBuffer(interHQL).append(" ) ");
          /*  Query q = session.createQuery(finalHQL);
            HQLHelper.setParamsOnQuery(params, q);
            panelBasedSNPAnnotIDs = q.list();
            */

            /* now we will attach the cluase that will be appended in calling
                method for SNPAnnotation crti itself */
            //snpAnnotIDsCrit.append(" AND sa.snpAnnotation.id IN ");
            return finalHQL.toString();
        }


}
