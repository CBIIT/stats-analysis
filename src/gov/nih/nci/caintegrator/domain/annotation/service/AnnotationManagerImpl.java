package gov.nih.nci.caintegrator.domain.annotation.service;

import gov.nih.nci.caintegrator.domain.annotation.gene.bean.CytobandPosition;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneAlias;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter;
import gov.nih.nci.caintegrator.enumeration.ArrayPlatformType;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class AnnotationManagerImpl implements AnnotationManager {

	SessionFactory sessionFactory;

	public Map<String, Collection<GeneBiomarker>> getGenesForReporters(
			AnnotationCriteria annotationCriteria) {

		HashMap<String, Collection<GeneBiomarker>> reporterMap = new HashMap<String, Collection<GeneBiomarker>>();
		ArrayPlatformType arrayPlatformType = annotationCriteria
				.getArrayPlatformType();
		Collection<String> reporters = annotationCriteria.getReporterIds();

		if (arrayPlatformType == null) {
			throw new RuntimeException("Array Platform type cannot be null");
		}
		if (reporters == null || reporters.isEmpty()) {
			throw new RuntimeException("Reporter list must not be empty");
		}

		Session currentSession = sessionFactory.getCurrentSession();

		List<GeneExprReporter> reporterList = new ArrayList<GeneExprReporter>();
		if (reporters.size() > 1000) {
			for (int i = 0; i < ((reporters.size() / 1000) + 1); i++) {
				Criteria criteria = currentSession
						.createCriteria(GeneExprReporter.class);
				criteria.createAlias("geneBiomarkerCollection", "gene",
						CriteriaSpecification.LEFT_JOIN);

				int size;
				if (i == (reporters.size() / 1000)) {
					size = reporters.size() % 1000;
				} else {
					size = 1000;
				}
				String[] tempArray = new String[size];
				System.arraycopy(reporters.toArray(), i * 1000, tempArray, 0,
						size);
				Collection tempList = new ArrayList();
				Collections.addAll(tempList, tempArray);
				criteria.add(Restrictions.in("name", tempList));
				reporterList.addAll(criteria.setResultTransformer(
						Criteria.DISTINCT_ROOT_ENTITY).list());
			}
		} else {
			Criteria criteria = currentSession
					.createCriteria(GeneExprReporter.class);
			criteria.createAlias("geneBiomarkerCollection", "gene",
					CriteriaSpecification.LEFT_JOIN);
			criteria.add(Restrictions.in("name", reporters));
			reporterList = criteria.setResultTransformer(
					Criteria.DISTINCT_ROOT_ENTITY).list();
		}

		for (GeneExprReporter reporter : reporterList) {
			reporterMap.put(reporter.getName(), reporter
					.getGeneBiomarkerCollection());
		}

		return reporterMap;
	}

	public Map<GeneBiomarker, Collection<GeneExprReporter>> getReportersForGenes(
			AnnotationCriteria annotationCriteria) {
		HashMap<GeneBiomarker, Collection<GeneExprReporter>> reporterMap = new HashMap<GeneBiomarker, Collection<GeneExprReporter>>();

		List<GeneBiomarker> geneList = new ArrayList<GeneBiomarker>();

		Collection<String> genes = annotationCriteria.getGeneSymbols();
		String platform = annotationCriteria.getArrayPlatformName();
		
		if (platform == null) {
			throw new RuntimeException("Array Platform name cannot be null");
		}
		if (genes == null || genes.isEmpty()) {
			throw new RuntimeException("Gene list must not be empty");
		}
		
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(GeneBiomarker.class);
		criteria.createAlias("geneExprReporterCollection", "reporter",
				CriteriaSpecification.LEFT_JOIN);
		if (genes.size() > 1000) {
			for (int i = 0; i < ((genes.size() / 1000) + 1); i++) {

				int size;
				if (i == (genes.size() / 1000)) {
					size = genes.size() % 1000;
				} else {
					size = 1000;
				}
				String[] tempArray = new String[size];
				System.arraycopy(genes.toArray(), i * 1000, tempArray, 0, size);
				Collection tempList = new ArrayList();
				Collections.addAll(tempList, tempArray);
				criteria.add(Restrictions.in("hugoGeneSymbol", tempList));
				criteria.add(Restrictions.eq("reporter.platform", platform));
				geneList.addAll(criteria.setResultTransformer(
						Criteria.DISTINCT_ROOT_ENTITY).list());

			}
		} else {

			criteria.add(Restrictions.in("hugoGeneSymbol", genes));
			criteria.add(Restrictions.eq("reporter.platform", platform));
			geneList = criteria.setResultTransformer(
					Criteria.DISTINCT_ROOT_ENTITY).list();

		}
		
		for (GeneBiomarker gene : geneList) {
			reporterMap.put(gene, gene
					.getGeneExprReporterCollection());
		}
		
		return reporterMap;
	}

	public GeneBiomarker getGeneForSymbol(String geneId) {
		Collection<String> genes = new ArrayList<String>();
		AnnotationCriteria criteria = new AnnotationCriteria();
		genes.add(geneId);
		criteria.setGeneSymbols(genes);
		Iterator<GeneBiomarker> i = getGeneAnnotations(criteria).iterator();
		if (i.hasNext()) {
			return i.next();
		} else {
			return null;
		}

	}

	public Collection<GeneExprReporter> getReportersForPlatform(
			AnnotationCriteria annotationCriteria) {
		Session currentSession = sessionFactory.getCurrentSession();

		Criteria criteria = currentSession
				.createCriteria(GeneExprReporter.class);
		criteria.createAlias("geneBiomarkerCollection", "gene",
				CriteriaSpecification.LEFT_JOIN);
		criteria.createAlias("geneReporterAnnotationCollection", "annotation",
				CriteriaSpecification.LEFT_JOIN);
		criteria.add(Restrictions.eq("platform", annotationCriteria
				.getArrayPlatformName()));
		return criteria.list();
	}

	public Collection<GeneExprReporter> getReporterAnnotations(
			AnnotationCriteria annotationCriteria) {
		Collection<String> reporters = annotationCriteria.getReporterIds();

		if (reporters == null || reporters.isEmpty()) {
			throw new RuntimeException("Reporter list must not be empty");
		}

		Session currentSession = sessionFactory.getCurrentSession();

		List<GeneExprReporter> reporterList = new ArrayList<GeneExprReporter>();
		if (reporters.size() > 1000) {
			for (int i = 0; i < ((reporters.size() / 1000) + 1); i++) {
				Criteria criteria = currentSession
						.createCriteria(GeneExprReporter.class);
				criteria.createAlias("geneBiomarkerCollection", "gene",
						CriteriaSpecification.LEFT_JOIN);
				criteria.createAlias("geneReporterAnnotationCollection",
						"annotation", CriteriaSpecification.LEFT_JOIN);

				int size;
				if (i == (reporters.size() / 1000)) {
					size = reporters.size() % 1000;
				} else {
					size = 1000;
				}
				String[] tempArray = new String[size];
				System.arraycopy(reporters.toArray(), i * 1000, tempArray, 0,
						size);
				Collection tempList = new ArrayList();
				Collections.addAll(tempList, tempArray);
				criteria.add(Restrictions.in("name", tempList));
				reporterList.addAll(criteria.setResultTransformer(
						Criteria.DISTINCT_ROOT_ENTITY).list());
			}
		} else {
			Criteria criteria = currentSession
					.createCriteria(GeneExprReporter.class);
			criteria.createAlias("geneBiomarkerCollection", "gene",
					CriteriaSpecification.LEFT_JOIN);
			criteria.createAlias("geneReporterAnnotationCollection",
					"annotation", CriteriaSpecification.LEFT_JOIN);
			criteria.add(Restrictions.in("name", reporters));
			reporterList = criteria.setResultTransformer(
					Criteria.DISTINCT_ROOT_ENTITY).list();
		}

		return reporterList;
	}

	public Collection<GeneBiomarker> getGeneAnnotations(
			AnnotationCriteria annotationCriteria) {
		Collection<String> geneIds = annotationCriteria.getGeneSymbols();
		if (geneIds == null || geneIds.isEmpty()) {
			throw new RuntimeException("Gene symbol list cannot be empty");
		}
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(GeneBiomarker.class);
		criteria.createAlias("geneAliasCollection", "alias");
		criteria.add(Restrictions.disjunction().add(
				Restrictions.in("alias.alias", geneIds)).add(
				Restrictions.in("alias.hugoGeneSymbol", geneIds)));
		List<GeneBiomarker> genes = criteria.list();
		return genes;
	}

	public List<CytobandPosition> getCytobandPositions(String chromosome,
			String startCytoband, String endCytoband) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession
				.createCriteria(CytobandPosition.class);
		criteria.add(Restrictions.eq("chromosomeName", chromosome));
		if (startCytoband != null && endCytoband != null) {
			criteria.add(Restrictions.disjunction().add(
					Restrictions.eq("cytoband", startCytoband)).add(
					Restrictions.eq("cytoband", endCytoband)));
		}
		criteria.addOrder(Order.asc("cytobandStartPosition"));
		List<CytobandPosition> positions = criteria.list();
		return positions;
	}

	public List<CytobandPosition> getCytobandPositions(String chromosome) {
		return getCytobandPositions(chromosome, null, null);
	}

	public List<VariationReporter> getReportersForDbSnpId(String dbSnpId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession
				.createCriteria(VariationReporter.class);
		criteria.add(Restrictions.ilike("snpAnnotation.dbsnpId", dbSnpId));
		return criteria.list();
	}

	public List<GeneAlias> getGeneAliasForSymbol(String symbol) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(GeneAlias.class);
		criteria.add(Restrictions.disjunction().add(
				Restrictions.ilike("alias", symbol, MatchMode.START)).add(
				Restrictions.ilike("hugoGeneSymbol", symbol, MatchMode.START)));
		return criteria.list();
	}

	public List<SNPAnnotation> getSnpAnnotationsForGene(String geneId,
			Long kbUpstream, Long kbDownstream) {
		GeneBiomarker gene = getGeneForSymbol(geneId);

		String chr = gene.getChromosome();
		Long start = gene.getStartPhyscialLocation();
		Long end = gene.getEndPhysicalLocation();

		Session sess = sessionFactory.getCurrentSession();

		Criteria criteria = sess.createCriteria(SNPAnnotation.class);

		criteria.add(Restrictions.eq("chromosomeName", chr));
		criteria.add(Restrictions.ge("chromosomeLocation", start
				- (kbUpstream * 1000)));
		criteria.add(Restrictions.le("chromosomeLocation", end
				+ (kbDownstream * 1000)));
		return criteria.list();
	}

	public List<SNPAnnotation> getSnpAnnotationsForSymbol(String symbol) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria criteria = currentSession.createCriteria(SNPAnnotation.class);
		Disjunction ids = Expression.disjunction();
		ids.add(Restrictions.ilike("dbsnpId", symbol));
		ids.add(Restrictions.ilike("secondaryIdentifier", symbol));
		criteria.add(ids);
		return criteria.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
