package gov.nih.nci.caintegrator.util.idmapping;

import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.util.CaIntegratorConstants;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;
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


    public String getPlatformNameFromDataSetName(IdMappingCriteria criteria) {
        String platform = "";
        Session theSession = sessionFactory.getCurrentSession();        
        String theHQL = "";
        Query theQuery = null;
        Collection objs = null;        
        theHQL = "select distinct im.platform from IdMapping im where im.fileName=:dataSetName";
        theQuery = theSession.createQuery(theHQL);
        theQuery.setParameter("dataSetName", criteria.getFileName());
        System.out.println("HQL: " + theHQL);        
        objs = theQuery.list();
        ArrayList<String> list = new ArrayList<String>(objs);        
        platform = (String)list.get(0);
        return platform;
    }


	public Set<String> getControlPatientDIDs(IdMappingCriteria criteria) {
		Session currentSession = sessionFactory.getCurrentSession();
		  Criteria c = currentSession
        .createCriteria(IdMapping.class);
        c.add(Expression.eq("caseControlStatus", CaIntegratorConstants.CONTROL));
        c.add(Restrictions.eq("fileName", criteria.getFileName()));
        List<IdMapping> objs = c.list();
        Set<String> patientIds = new HashSet<String>();
        for (IdMapping idm : objs) {
        	patientIds.add(idm.getPdid());
        }
        
        return patientIds;
	}
}
