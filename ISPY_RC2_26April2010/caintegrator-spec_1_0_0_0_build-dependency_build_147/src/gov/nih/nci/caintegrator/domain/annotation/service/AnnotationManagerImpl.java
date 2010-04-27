package gov.nih.nci.caintegrator.domain.annotation.service;

import gov.nih.nci.caintegrator.domain.annotation.gene.bean.CytobandPosition;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter;
import gov.nih.nci.caintegrator.enumeration.ArrayPlatformType;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AnnotationManagerImpl implements AnnotationManager {

    private SessionFactory sessionFactory;
    
    public Collection<GeneExprReporter> getGenesForReporters(
            AnnotationCriteria annotationCriteria) {
        ArrayPlatformType arrayPlatformType = annotationCriteria.getArrayPlatformType();
        Collection<String> reporters = annotationCriteria.getReporterIds();
        
        if(arrayPlatformType == null) {
            throw new RuntimeException("Array Platform type cannot be null");
        }
        if(reporters == null || reporters.isEmpty()) {
            throw new RuntimeException("Reporter list must not be empty");
        }
        
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(GeneExprReporter.class);
        criteria.createAlias("geneBioMarker", "gene");
        criteria.add(Restrictions.in("name", reporters));  
        List<GeneExprReporter> reporterList = criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
        
        return reporterList;
    }

    public Map<GeneBiomarker, Collection<GeneExprReporter>> getReportersForGenes(
            AnnotationCriteria annotationCriteria) {
        

        return null;
    }

    public GeneBiomarker getGeneForSymbol(String geneId) {
        Collection<String> genes = new ArrayList<String>();
        AnnotationCriteria criteria = new AnnotationCriteria();
        genes.add(geneId);
        criteria.setGeneSymbols(genes);
        Iterator<GeneBiomarker> i = getGeneAnnotations(criteria).iterator();
        if(i.hasNext()) {
            return i.next();
        } else {
            return null;
        }
            
    }
    
    public Collection<GeneBiomarker> getGeneAnnotations(AnnotationCriteria annotationCriteria) {
        Collection<String> geneIds = annotationCriteria.getGeneSymbols();
        if(geneIds == null || geneIds.isEmpty()) {
            throw new RuntimeException("Gene symbol list cannot be empty");
        }
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(GeneBiomarker.class);
        criteria.createAlias("geneAliasCollection", "alias");
        criteria.add(
                        Restrictions.disjunction().add(
                                Restrictions.in("alias.alias", geneIds)).add(
                                Restrictions.in("alias.hugoGeneSymbol", geneIds)));
        List<GeneBiomarker> genes = criteria.list();
        return genes;
    }
    
    public List<CytobandPosition> getCytobandPositions(String chromosome, String startCytoband, String endCytoband) {
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria criteria = currentSession.createCriteria(CytobandPosition.class);
        criteria.add(Restrictions.eq("chromosomeName", chromosome));
        criteria.add(Restrictions.disjunction().add(Restrictions.eq("cytoband", startCytoband)).add(Restrictions.eq("cytoband", endCytoband)));
        criteria.addOrder(Order.asc("cytobandStartPosition"));
        List<CytobandPosition> positions = criteria.list();
        return positions;
    }
    
    
    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




}
