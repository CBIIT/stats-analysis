/**
 * 
 */
package gov.nih.nci.caintegrator.util.idmapping;

import java.util.Set;

import org.hibernate.SessionFactory;

/**
 * @author rossok
 * This class can be injected into a km implementation that does
 * not necessitate mapping of ids to seperate analysis ids
 *
 */
public class NullIdMappingManager implements IdMapper {

    /* (non-Javadoc)
     * @see gov.nih.nci.caintegrator.util.idmapping.IdMapper#getRbinaryIdsForPatientDIDs(gov.nih.nci.caintegrator.util.idmapping.IdMappingCriteria)
     */
    public Set getRbinaryIdsForPatientDIDs(IdMappingCriteria criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see gov.nih.nci.caintegrator.util.idmapping.IdMapper#getRbinaryIdsForPatientDIDs(java.util.Set, java.lang.String, java.lang.String)
     */
    public Set getRbinaryIdsForPatientDIDs(Set patientDIDs, String tissue,
            String binaryFileName) {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see gov.nih.nci.caintegrator.util.idmapping.IdMapper#getSessionFactory()
     */
    public SessionFactory getSessionFactory() {
        // TODO Auto-generated method stub
        return null;
    }

    /* (non-Javadoc)
     * @see gov.nih.nci.caintegrator.util.idmapping.IdMapper#setSessionFactory(org.hibernate.SessionFactory)
     */
    public void setSessionFactory(SessionFactory sessionFactory) {
        // TODO Auto-generated method stub

    }

    public Set getPatientDIDsForAnalysisIds(IdMappingCriteria criteria) {
        // TODO Auto-generated method stub
        return null;
    }

    public String getPlatformNameFromDataSetName(IdMappingCriteria criteria) {
        // TODO Auto-generated method stub
        return null;
    }

}
