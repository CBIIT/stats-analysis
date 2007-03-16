package gov.nih.nci.caintegrator.studyQueryService.germline;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

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

        List<String> annotObjIDs = getSNPAnnotationsIDs(annotCrit, session);

        if (annotObjIDs != null) {
            allSNPAnnotIDs = new HashSet();
            allSNPAnnotIDs.addAll(annotObjIDs);
            System.out.println("Total SNPAnnotations Retrieved: " + allSNPAnnotIDs.size() + " : " + allSNPAnnotIDs);
        }
        return allSNPAnnotIDs;
    }

    /**
     * This method retrieves SNPAnnotations based on AnnotationCriteria passed in.
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
        List<String> annotObjIDs = getSNPAnnotationsIDs(annotCrit, session);
        /* TODO:  convert HibernateCriteria query below in to HQL Query. */
        Criteria crit = session.createCriteria(SNPAnnotation.class);
        crit.add(Restrictions.in("id", annotObjIDs));
        List<SNPAnnotation> snpAnnotObjs = crit.list();
        return snpAnnotObjs;
    }

    /**
     * This method retrieves SNPAnnotationsIDs based on AnnotationCriteria passed in.
     * In the current release AnnotationCriteria only PanelCriteria, PositionCriteria
     * and SnpIdentifier are supported.  CytobandCriteria,   GenePathways,
     * GeneOntology will be supported in later releases.
     *
     * @param annotCrit
     * @param session
     * @return List of SNPAnnotationID objects
     */

    public static List<String> getSNPAnnotationsIDs(AnnotationCriteria annotCrit,  Session session)
    throws Exception {
        if (annotCrit == null) throw new Exception ("Annotation criteria can not be null");
        HashMap params = new HashMap();
        StringBuffer finalHQL = getAnnotHQLWithParams(annotCrit, params);

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
        List<String> annotObjIDs =  q.list();
        return annotObjIDs;
    }
/*
    public static StringBuffer getSNPAnnoIDsWithOnlyPanelCrit(AnnotationCriteria annotCrit,  Session session) {
        PanelCriteria panelCrit = annotCrit.getPanelCriteria();
        StringBuffer hql = new StringBuffer();
        //hql.append(" SELECT s.snpAnnotation.id FROM SNPAssay s WHERE s.snpPanel.id=" + panelCrit.getSnpPanelID());
        hql.append(" SELECT s.snpAnnotation.id FROM SNPAssay s WHERE s.snpPanel.id=" + panelCrit.getSnpPanelID());


        Query q = session.createQuery(hql);
        List<String> snpAnnotIDs=q.list();
        return hql;
    }
*/

//    public static StringBuffer getAnnotAndGeneBiomarkerHQLWithParams(AnnotationCriteria annotCrit, HashMap params)  {
//      /* String annotHSQL = new String(
//                                    " FROM SNPAnnotation s LEFT JOIN FETCH s.geneBiomarkerCollection " +
//                                    " WHERE {0} {1} ");*/
//
//        String annotHSQL = new String(
//                                            " FROM SNPAnnotation s  " +
//                                            " WHERE {0} {1} ");
//
//        return getAnnotHQLWithParams(annotCrit, annotHSQL, params);
//    }

    public static StringBuffer getAnnotHQLWithParams(AnnotationCriteria annotCrit, HashMap params)  {
        String annotHSQL = new String(" SELECT s.id FROM SNPAnnotation s WHERE {0} {1} ");
        return getAnnotHQLWithParams(annotCrit, annotHSQL, params);
    }


     public static StringBuffer getAnnotHQLWithParams(AnnotationCriteria annotCrit, String annotHSQL, HashMap params)  {
        PhysicalPositionCriteria poistionCrit = annotCrit.getPhysicalPositionCriteria();

        //String annotHSQL = new String(" SELECT s.id FROM SNPAnnotation s WHERE {0} {1} ");

        /* 0.  Handle GeneSymbol Criteria */
        Collection<String> geneSymbols = null;
        if (annotCrit.getGeneSymbols() != null) geneSymbols = HQLHelper.trimCollection(annotCrit.getGeneSymbols());
        StringBuffer snpAnnotHSQL = new StringBuffer(annotHSQL);
        String geneSymbolCond = "";
        if (geneSymbols != null && geneSymbols.size() > 0) {
            geneSymbolCond = " s.geneBiomarkerCollection.hugoGeneSymbol IN (:geneSymbols) AND ";
            params.put("geneSymbols", geneSymbols);
        }

        /* 1.  Handle Panel Criteria */
        PanelCriteria panelCrit = annotCrit.getPanelCriteria();
        StringBuffer panelCond = new StringBuffer("");
        if (panelCrit != null) handlePanelCriteria(panelCrit, panelCond, params);

        /* 2 Handle PhysicalPositionCriteria */
        if (poistionCrit != null) handlePositionCriteria(poistionCrit, snpAnnotHSQL, params);

        /* 3 Handle CytobandCriteria, GeneOntology, GenePathway */
        if ((annotCrit.getCytobandCriteria() != null) || (annotCrit.getGeneOntology() != null) ||
                                                                    (annotCrit.getGenePathways() != null) )
           throw new RuntimeException (" This method is not implelemted for now: ");

        /* 4 Handle SNPIdentifiers */
        Collection<String> dbSNPIdentifiers = annotCrit.getSnpIdentifiers();
        if (dbSNPIdentifiers !=  null && dbSNPIdentifiers.size() > 0) {
            String tmp = new String(" s.dbsnpId IN (:dbSnps ) AND ");
            params.put("dbSnps", dbSNPIdentifiers);
            snpAnnotHSQL.append(tmp);
        }

        /* 5 Remove any trailing AND / OR and append AND */
        String paramReplacedHql = MessageFormat.format(snpAnnotHSQL.toString(),
                             geneSymbolCond, panelCond.toString() );
        String interHSQL = HQLHelper.removeTrailingAND(new StringBuffer(paramReplacedHql));
        String finalWithWhereHSQL = HQLHelper.removeTrailingOR(new StringBuffer(interHSQL));
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(finalWithWhereHSQL), "WHERE");

        return new StringBuffer(finalHQL);
    }
    private static void handlePanelCriteria(PanelCriteria panelCrit, StringBuffer panelCond, HashMap params) {
        if (panelCrit != null)  {
            if (panelCrit.getSnpPanelID() != null) {
                 panelCond.append("s.snpPanelCollection.id = (:snpPanelID) AND ") ;
                 params.put("snpPanelID", panelCrit.getSnpPanelID());
            }
        }
    }

    private static void handlePositionCriteria(PhysicalPositionCriteria poistionCrit,
                                                           StringBuffer snpAnnotHSQL, HashMap params) {
        String chromosome = poistionCrit.getChromosome();
        assert(chromosome != null);
        Long startPos = poistionCrit.getStartPosition();
        Long endPos = poistionCrit.getEndPosition();
        String tmp;

        if (startPos != null && endPos != null) { //get entire range 
            tmp = new String(" (s.chromosomeName=:chr AND ( s.chromosomeLocation  BETWEEN :start AND :end )) AND ");
            params.put("start", startPos);
            params.put("end", endPos);
        }else if (startPos != null && endPos == null){ //get values from start position to end of chr
        	tmp = new String(" (s.chromosomeName=:chr AND ( s.chromosomeLocation  BETWEEN :start AND :end)) AND ");
            params.put("start", startPos);
            params.put("end", java.lang.Long.MAX_VALUE);
        }else if (endPos != null  && startPos == null){ //get values from start of chr to end pos
        	tmp = new String(" (s.chromosomeName=:chr AND ( s.chromosomeLocation  BETWEEN :start AND :end)) AND ");
        	params.put("start", new Long(0));
            params.put("end", endPos);
        }else tmp = new String(" (s.chromosomeName=:chr) AND ");

        params.put("chr", chromosome);
        snpAnnotHSQL.append(tmp);
    }
}
