package gov.nih.nci.caintegrator.studyQueryService.test.ihc;

import gov.nih.nci.caintegrator.domain.finding.copyNumber.fish.bean.FISHFinding;
import gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean.LossOfExpressionIHCFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.ihc.LossOfExpressionIHCFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.protein.ProteinBiomarkerCriteia;
import gov.nih.nci.caintegrator.studyQueryService.ihc.LossOfExpressionIHCFindingHandler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


public class IHCLossTest extends TestCase {
    
   private LossOfExpressionIHCFindingCriteria inCriteria;
   private ProteinBiomarkerCriteia protCriteria;
   
   public void setUp() throws Exception{
       inCriteria = new LossOfExpressionIHCFindingCriteria();
       protCriteria = new ProteinBiomarkerCriteia();
       }
    
   public static Test suite() {
        TestSuite suit =  new TestSuite();          
        suit.addTest(new TestSuite(IHCLossTest.class));
        return suit;
      }
   public void testIHCSearch() {
       setUpIHCLossAttributesCriteria();       
       executeSearch();
   }  
   
  
   private void setUpIHCLossAttributesCriteria() {
       inCriteria = new LossOfExpressionIHCFindingCriteria();
       Set<String> biomarkers = new HashSet<String>();
       biomarkers.add("P27");
       protCriteria.setProteinNameCollection(biomarkers);
       inCriteria.setProteinBiomarkerCrit(protCriteria);
       inCriteria.setBenignSumOperator(" <= ");
       inCriteria.setBenignSum(new Integer("20"));
   }
   
   private  Collection executeSearch() {
        
         try {
             System.setProperty("gov.nih.nci.caintegrator.configFile","C:/devtools/jboss/jboss-4.0.4.GA/server/default/conf/caIntegratorConfig.xml");
             LossOfExpressionIHCFindingHandler lHandler = new LossOfExpressionIHCFindingHandler();
             Collection<LossOfExpressionIHCFinding> findings = lHandler.getLossExpFindings(inCriteria);             
             System.out.println("Number of LossOfExpressionIHC finding Retrieved: " + findings.size());
             
             for (Iterator<LossOfExpressionIHCFinding> iterator = findings.iterator(); iterator.hasNext();) {
                 LossOfExpressionIHCFinding lFinding =  iterator.next();
                 System.out.println("LossOfExpressionIHC finding ID: " +
                                     lFinding.getId());
                 System.out.println("protein: " + lFinding.getProteinBiomarker());
                 System.out.println("benignSum: " + lFinding.getBenignSum());
                 System.out.println("invasiveSum:  " + lFinding.getInvasiveSum());
                 System.out.println("benignPresentValue: " + lFinding.getBenignPresentValue());
                 System.out.println("invasiveBenignDiffd: "+ lFinding.getInvasiveBenignDiff());
                 System.out.println("lossResult: " + lFinding.getLossResult());
                 //System.out.println("patient did: " + lFinding.getSpecimen().getPatientDID());
                 //System.out.println("specimen id: "+ lFinding.getSpecimen().getId());                 
                 //if (lFinding.getSpecimen().getTimePoint() != null)
                 //    System.out.println("time point:" + lFinding.getSpecimen().getTimePoint());
             }
             //return findings;
         } catch (Throwable t)  {
            System.out.println("LossExpr Exception in getting data: " + t.toString());
            t.printStackTrace();
        }
         
        return null;
    }   
    
 
    public void testAll() {       
        Collection findings =  executeSearch();
    }    
    
    
    public static void main (String[] args) {
        junit.textui.TestRunner.run(suite());

    }


}
