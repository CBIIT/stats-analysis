package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 30, 2006
 * Time:   2:19:49 PM
 */
public class SNPAssociationAnalysisGroupTest extends GenotypeFindingTest {

    private AnalysisGroupCriteria  assocCrit ;

    public void setUp() throws Exception {
        super.setUp();
        assocCrit = new AnalysisGroupCriteria("CGEMS Prostate Cancer WGAS Phase 1");
    }

    public void testSNPAssociationAnalysisGroup() {
        //setUpSNPAnalysisGroupCriteria();
        executeSearch();
    }

    protected void setUpSNPAnalysisGroupCriteria() {
         assocCrit.setNames(new String[] {"Incidence density sampling,Unadjusted score test,Controls", "control"});
    }

    private void executeSearch() {
        try {
            Collection<SNPAnalysisGroup> assocObjs = manager.getSNPAnalysisGroups(assocCrit);
            System.out.println("Number of Group Objects Retrieved: " + assocObjs .size());
            for (Iterator<SNPAnalysisGroup> iterator = assocObjs .iterator(); iterator.hasNext();) {
                SNPAnalysisGroup group = iterator.next();
                System.out.println("Group Name: " + group.getName());
            }
      } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting studies: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SNPAssociationAnalysisGroupTest.class));
        return suit;
    }

}
