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

        Set<String> allSNPAnnotIDs = null;
        if (annotCrit == null) throw new Exception ("Annotation criteria can not be null");

        List<SNPAnnotation> annotObjs = getSNPAnnotations(annotCrit, session);

        if (annotObjs != null) {
            allSNPAnnotIDs = new HashSet();
            /* add ids from this annotObjs list to results i.e allSNPAnnotIDs */
            for (int i = 0; i < annotObjs.size(); i++) {
                SNPAnnotation snpAnnotation =  annotObjs.get(i);
                allSNPAnnotIDs.add(snpAnnotation.getId());
            }
            System.out.println("Total SNPAnnotations Retrieved: " + allSNPAnnotIDs.size());
        }
        return allSNPAnnotIDs;
    }

    /**
     * This method retrieves ANPAnnotations based on AnnotationCriteria passed in.
     * In the current release AnnotationCriteria only PanelCriteria, PositionCriteria
     * and SnpIdentifier are supported.  CytobandCriteria,   GenePathways,
     * GeneOntology will be supported in later releases.
     *
     * @param annotCrit
     * @param session
     * @return List of SNPAnnotation objects
     */

    public static List<SNPAnnotation> getSNPAnnotations(AnnotationCriteria annotCrit,  Session session)
    throws Exception {

        List<SNPAnnotation> annotObjs = new ArrayList<SNPAnnotation>();
        if (annotCrit == null) throw new Exception ("Annotation criteria can not be null");

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
        String finalWithoutWhereHQL = HQLHelper.removeTrailingToken(new StringBuffer(finalWithWhereHSQL), "WHERE");

        /* 6  Include PanelCritera */
        String panelBasedSNPAnnotCrit = includePanelCriteriaInHSQL(panelCrit, params);
        String finalHQL = new String("");
        if (panelBasedSNPAnnotCrit.length() > 0 ) {
            /* implies that there is already at least one other criteria (such as PhysicalPosition,
               dbSNPIdentifiers etc) was metnioned and at the samtime there is also hql for PanelCrit
               is included.  So add panel criteria to the above SNPAnnotation criteria as subselect with
               preciding OR operator */
            finalHQL = new StringBuffer(finalWithoutWhereHQL).append(" OR ").append(panelBasedSNPAnnotCrit).toString();
        } else {
            finalHQL = new StringBuffer(finalWithoutWhereHQL).toString();
        }
/*
        if (panelBasedSNPAnnotCrit.length() > 0) {
            // append the above SNPAnnotation criteria as sub select
           panelBasedSNPAnnotCrit.append(" ( " + finalHQL + " )");
        }
        else {
           panelBasedSNPAnnotCrit.append(finalHQL);
        }
*/
        if (finalHQL.indexOf(" WHERE ") == -1) {
            /* means no WHERE clause at all which means selecting entire table.  So return no anotations
             so that the annotaiton clause does not need to be included in final Finding HQL */
            /* TODO: this way of returning "null" in general is a bad parctice.  This is done as
               temporary fix.  It will be re-factored later --  Ram 08/23/06
            */
            return null;
        }
        Query q = session.createQuery(finalHQL.toString());
        HQLHelper.setParamsOnQuery(params, q);
        annotObjs =  q.list();
        return annotObjs;
    }

    public static Boolean isAnnotationCriteriaPresent(AnnotationCriteria annotCrit) {
        boolean criteriaPresent = false;

        PhysicalPositionCriteria poistionCrit = annotCrit.getPhysicalPositionCriteria();
        Collection<String> dbSNPIdentifiers = annotCrit.getSnpIdentifiers();
        Collection<String> geneSymbols = annotCrit.getGeneSymbols();
        PanelCriteria panelCrit = annotCrit.getPanelCriteria();
        /* TODO: when the following are implemented in  the next release pl take care of the below:
        String[] geneOntology = annotCrit.getGeneOntology();
        String[] genePathways = annotCrit.getGenePathways();
        CytobandCriteria cytobandCriteria = annotCrit.CytobandCriteria();
        */
        if (poistionCrit != null) {
          String chromosome = poistionCrit.getChromosome();
          Integer startPos = poistionCrit.getStartPosition();
          Integer endPos = poistionCrit.getEndPosition();
          if ((chromosome != null)) criteriaPresent = true;
        }

        if (dbSNPIdentifiers !=  null && dbSNPIdentifiers.size() > 0) criteriaPresent = true;
        if (geneSymbols != null && geneSymbols.size() > 0) criteriaPresent = true;
        if (panelCrit != null) {
            String name = panelCrit.getName();
            String version = panelCrit.getVersion();
            if (name != null || version != null) criteriaPresent = true;
        }

        return new Boolean(criteriaPresent);
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

    /**
     * This method call implies that there is already at least one other criteria (such as PhysicalPosition,
     * dbSNPIdentifiers etc) was metnioned.
     * @param panelCrit
     * @param params
     * @return hql containg panelCriteria (or empty string if no PanelCrit is specified)
     */
    private static String includePanelCriteriaInHSQL(PanelCriteria panelCrit,  HashMap params ) {

            StringBuffer emptyBuffer = new StringBuffer("");
            if (panelCrit == null) return emptyBuffer.toString();

            String name = panelCrit.getName();
            String version = panelCrit.getVersion();
            if (name == null & version == null) return emptyBuffer.toString();

            StringBuffer snpAnnotIDsCrit = new StringBuffer("");
            boolean panelCritAdded = false;
            StringBuffer panelClause = new StringBuffer("");
            if (name != null) {
              panelClause.append(" sp.name = :name AND ");
              params.put( "name", name);
              panelCritAdded = true;
            }
            if (version != null) {
              panelClause.append(" sp.version = :version ");
              params.put( "version", version);
              panelCritAdded = true;
            }

            if (panelCritAdded) {
                snpAnnotIDsCrit.append( " s.id IN ( SELECT sa.snpAnnotation.id " +
                                        " FROM SNPAssay sa JOIN sa.snpPanel sp WHERE ");
                snpAnnotIDsCrit.append(panelClause);
            }

            StringBuffer finalHQL = new StringBuffer("");
            if (snpAnnotIDsCrit.length() > 0) {
                String interHQL = HQLHelper.removeTrailingToken(snpAnnotIDsCrit, "AND");
                finalHQL = new StringBuffer(interHQL).append(" ) ");
            }

            return finalHQL.toString();
        }
}
