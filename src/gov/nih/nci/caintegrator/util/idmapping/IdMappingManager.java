package gov.nih.nci.caintegrator.util.idmapping;

import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter;

import java.util.List;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class IdMappingManager implements IdMapper{

	SessionFactory sessionFactory;
	
	public Set getRbinaryIdsForPatientDIDs(IdMappingCriteria criteria) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		  Criteria c = currentSession
          .createCriteria(IdMapping.class);
          c.add(Restrictions.in("pdid", criteria.getPatientIds()));
          c.add(Restrictions.eq("fileName", criteria.getFileName()));
          List<IdMapping> objs = c.list();
          Set<String> rbinaryIds = new HashSet<String>();
          for (IdMapping idm : objs) {
             rbinaryIds.add(idm.getAnalysisFileId());
          }
          
          return rbinaryIds;
	}
	
	public Set getRbinaryIdsForPatientDIDs(Set patientDIDs, String tissue, String rBinaryFileName) {
		
		
		return null;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
}
