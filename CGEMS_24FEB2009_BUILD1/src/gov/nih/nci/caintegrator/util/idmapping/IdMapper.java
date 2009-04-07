package gov.nih.nci.caintegrator.util.idmapping;

import java.util.Set;

import org.hibernate.SessionFactory;

public interface IdMapper {

    public Set getRbinaryIdsForPatientDIDs(IdMappingCriteria criteria);
    public Set getPatientDIDsForAnalysisIds(IdMappingCriteria criteria);
    public Set getRbinaryIdsForPatientDIDs(Set patientDIDs, String tissue, String rBinaryFileName);
    public String getPlatformNameFromDataSetName(IdMappingCriteria criteria);
    public SessionFactory getSessionFactory();
    public void setSessionFactory(SessionFactory sessionFactory);
}
