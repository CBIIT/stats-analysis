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

        PhysicalPositionCriteria poistionCrit = annotCrit.getPhysicalPositionCriteria();
        Collection<String> dbSNPIdentifiers = annotCrit.getSnpIdentifiers();
        Collection<String> geneSymbols = annotCrit.getGeneSymbols();

        PanelCriteria panelCrit = annotCrit.getPanelCriteria();
        HashMap params = new HashMap();  // used to hold HQL parameters

        /* at least one other annotation should be specified when panelCriteria
           is specified in the AnnotationCriteria.  Otherwise throw an exception */
       if ((panelCrit != null) && (poistionCrit == null && dbSNPIdentifiers == null) )
          throw new Exception("At least one other annotation should be specified with panelCriteria ");

      /* 0  Handle PanelCritera */
      StringBuffer panelBasedSNPAnnotCrit = handlePanelCriteriaInHSQL(panelCrit, params);


       /* 1.  Handle SNPAnnotation itself */
       String annotHSQL = new String("  SELECT s.id FROM SNPAnnotation s WHERE {0} ");
       StringBuffer snpAnnotHSQL = new StringBuffer(annotHSQL);

       // String geneSymbolJoin = " LEFT JOIN FETCH s.geneBiomarkerCollection ";
        String geneSymbolCond = "";
        if (geneSymbols != null && geneSymbols.size() > 0) {
            geneSymbolCond = " s.geneBiomarkerCollection.hugoGeneSymbol IN (:geneSymbols) AND ";
            params.put("geneSymbols", geneSymbols);
        }

        /* 1.1 Handle PhysicalPositionCriteria */
        if (poistionCrit != null) {
            handlePositionCriteria(poistionCrit, snpAnnotHSQL, params);
        }



        //  1.2 Handle CytobandCriteria, GeneOntology, GenePathway
        if ((annotCrit.getCytobandCriteria() != null) ||
           (annotCrit.getGeneOntology() != null) || (annotCrit.getGenePathways() != null) )
           throw new RuntimeException (" This method is not implelemted for now: ");

        /* 1.3 Handle SNPIdentifiers */
        dbSNPIdentifiers = annotCrit.getSnpIdentifiers();
        if (dbSNPIdentifiers !=  null && dbSNPIdentifiers.size() > 0) {
            String tmp = new String(" s.dbsnpId IN (:dbSnps ) OR ");
            params.put("dbSnps", dbSNPIdentifiers);
            snpAnnotHSQL.append(tmp);
        }

        /* 1.4  Remove any trailing AND / OR and append AND */
        String paramReplacedHql = MessageFormat.format(snpAnnotHSQL.toString(), new Object[] { geneSymbolCond });
        String interHSQL = HQLHelper.removeTrailingAND(new StringBuffer(paramReplacedHql));
        String finalWithWhereHSQL = HQLHelper.removeTrailingOR(new StringBuffer(interHSQL));
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(finalWithWhereHSQL), "WHERE");

        if (panelBasedSNPAnnotCrit.length() > 0) {
            // append the above SNPAnnotation criteria as sub select
           panelBasedSNPAnnotCrit.append(" ( " + finalHQL + " )");
        }
        else {
           panelBasedSNPAnnotCrit.append(finalHQL);
        }

        Query q = session.createQuery(panelBasedSNPAnnotCrit.toString());
        HQLHelper.setParamsOnQuery(params, q);
        List annotIDs =  q.list();

        allSNPAnnotIDs.addAll(annotIDs);
        System.out.println("Total Annot IDs retrieved: " + allSNPAnnotIDs.size());
        return allSNPAnnotIDs;
    }

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

  /*  public static List<SNPAnnotation> handle(AnnotationCriteria annotCrit,  Session session)
    throws Exception {

    }*/
    private static void handlePositionCriteria(PhysicalPositionCriteria poistionCrit, StringBuffer snpAnnotHSQL, HashMap params) {
        String chromosome = poistionCrit.getChromosome();
        Integer startPos = poistionCrit.getStartPosition();
        Integer endPos = poistionCrit.getEndPosition();

        if ((chromosome == null) || (startPos == null) || (endPos == null) )
             throw new RuntimeException("Chromosme, StartPosition, EndPosition are required ");
        String tmp = new String(" s.chromosomeName=:chr AND ( s.chromosomeLocation  BETWEEN :start AND :end ) OR ");
        params.put("chr", chromosome);
        params.put("start", startPos);
        params.put("end", endPos);
        snpAnnotHSQL.append(tmp);
    }

    private static StringBuffer handlePanelCriteriaInHSQL(PanelCriteria panelCrit,  HashMap params ) {
            StringBuffer emptyBuffer = new StringBuffer("");
            if (panelCrit == null) return emptyBuffer;
            String name = panelCrit.getName();
            String version = panelCrit.getVersion();

            if (name == null & version == null) return emptyBuffer;

            StringBuffer snpAnnotIDsCrit = new StringBuffer(
      //              " SELECT annot.id FROM SNPAssay sa join sa.snpAnnotation annot join sa.snpPanel sp WHERE ");
                " SELECT sa.snpAnnotation.id FROM SNPAssay sa JOIN sa.snpPanel sp WHERE ");

            if (name != null) {
              snpAnnotIDsCrit.append(" sp.name = :name AND ");
              params.put( "name", name);
            }
            if (version != null) {
              snpAnnotIDsCrit.append(" sp.version = :version ");
              params.put( "version", version);
            }

            //String finalHQL = HQLHelper.removeTrailingToken(snpAnnotIDsCrit, "WHERE");

          /*  Query q = session.createQuery(finalHQL);
            HQLHelper.setParamsOnQuery(params, q);
            panelBasedSNPAnnotIDs = q.list();
            */

            /* now we will attach the cluase that will be appended in calling
                method for SNPAnnotation crti itself */
            snpAnnotIDsCrit.append(" AND sa.snpAnnotation.id IN ");
            return snpAnnotIDsCrit;
        }


}
