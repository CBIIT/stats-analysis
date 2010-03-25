package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel;
import gov.nih.nci.caintegrator.test.BaseSpringTestCase;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.framework.TestCase;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 16, 2006
 * Time:   8:05:49 AM
 */
public class StudyPanelTest extends CGEMSTest {

    private StudyCriteria studyCrit ;

    public void setUp() throws Exception {
        studyCrit = new StudyCriteria();
    }

    public void testPanelCriteria() {
        setUpStudyCriteria();
        executeSearch();
    }

    protected void setUpStudyCriteria() {
        studyCrit.setName("CGEMS Prostate Cancer WGAS Phase 1");
        //studyCrit.setSponsorStudyIdentifier("NCI DCEG, NCI OCG");
    }

    private void executeSearch() {
        try {
            Collection<SNPPanel> panelObjs = manager.getPanels(studyCrit);
            System.out.println("Number of Panel Objects Retrieved: " + panelObjs.size());
            for (Iterator<SNPPanel> iterator = panelObjs.iterator(); iterator.hasNext();) {
                SNPPanel panel = iterator.next();
                System.out.println("PANEL NAME: " + panel.getName());
              /*  System.out.println("Panel Technology: " + panel.getTechnology());
                System.out.println("Panel Description: " + panel.getDescription());
                System.out.println("Panel Version: " + panel.getVersion());
                System.out.println("Panel VendorPanel ID: " + panel.getVendorPanelId());*/
            }

        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting panels: " + t.toString());
           t.printStackTrace();
       }
    }

    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(StudyPanelTest.class));
        return suit;
    }

}
