package gov.nih.nci.caintegrator.util.idmapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

public class IdMappingManager implements IdMapper{

	private SessionFactory sessionFactory;
	
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
	
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    


    public Set getPatientDIDsForAnalysisIds(IdMappingCriteria criteria) {
        Session currentSession = sessionFactory.getCurrentSession();
        Criteria c = currentSession
        .createCriteria(IdMapping.class);
        c.add(Restrictions.in("analysisFileId", criteria.getAnalysisFileIds()));
        c.add(Restrictions.eq("fileName", criteria.getFileName()));
        List<IdMapping> objs = c.list();
        Set<String> patientIds = new HashSet<String>();
        for (IdMapping idm : objs) {
            patientIds.add(idm.getPdid());
        }
        
        return patientIds;
  }
    


    public Set getRbinaryIdsForPatientDIDs(Set patientDIDs, String tissue,
            String binaryFileName) {
        // TODO Auto-generated method stub
        return null;
    }
	
}
