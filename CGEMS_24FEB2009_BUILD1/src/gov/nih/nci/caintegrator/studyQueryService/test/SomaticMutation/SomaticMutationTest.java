package gov.nih.nci.caintegrator.studyQueryService.test.SomaticMutation;

import gov.nih.nci.caintegrator.studyQueryService.SomaticMutationQueryService.SomaticMutationCriteriaHandler;
import gov.nih.nci.caintegrator.studyQueryService.dto.somaticMutation.SomaticMutationFindingCriteria;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.List;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.hibernate.Session;

public class SomaticMutationTest extends TestCase {

    private SomaticMutationFindingCriteria somMutFindingCrit ;

    protected void setUp() throws Exception {
    	somMutFindingCrit = new SomaticMutationFindingCriteria();
    }

    public void testSomaticMutationFindingCriteria() {
        setUpSomaticMutationFindingCriteria();
        executeSearch();
    }

    protected void setUpSomaticMutationFindingCriteria() {
    	somMutFindingCrit = new SomaticMutationFindingCriteria() ;
    	somMutFindingCrit.setSizeOfMutation("1") ;
    }

    private void executeSearch() 
    {
        try 
        {
        	Session session = HibernateUtil.getSessionFactory().getCurrentSession();
            session.beginTransaction();
            SomaticMutationFindingCriteria  somMutQuery = new SomaticMutationFindingCriteria() ;
        	SomaticMutationCriteriaHandler somMutQueryHandler = new SomaticMutationCriteriaHandler() ;
        	List<String> somIds = somMutQueryHandler.handle(somMutQuery,session) ;
        
            for (String somID: somIds) 
            {               
                System.out.println("Somatic Mutation ID: " + somID);
            }

            session.close() ;
        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting studies: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SomaticMutationTest.class));
        return suit;
    }
}