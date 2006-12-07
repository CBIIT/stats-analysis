package gov.nih.nci.caintegrator.studyQueryService.test.fish;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import gov.nih.nci.caintegrator.studyQueryService.fish.FISHFindingHandler;
import gov.nih.nci.caintegrator.studyQueryService.germline.BatchFindingsHandler;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.studyQueryService.test.germline.SubjectSearchTest;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.PhysicalPositionCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.fish.FISHFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.finding.copyNumber.fish.bean.FISHFinding;
import gov.nih.nci.caintegrator.domain.study.bean.DNASpecimen;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;

import java.util.Collection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class FISHTest extends TestCase {
	
   private FISHFindingCriteria inCriteria;
   
   public void setUp() throws Exception{
	   inCriteria = new FISHFindingCriteria();   
	   }
	
   public static Test suite() {
	    TestSuite suit =  new TestSuite();	        
	    suit.addTest(new TestSuite(FISHTest.class));
	    return suit;
	  }
   public void testFISHSearch() {
	   setUpFISHAttributesCriteria();       
       executeSearch();
   }  
   
  
   private void setUpFISHAttributesCriteria() {
	   inCriteria = new FISHFindingCriteria();
	   Set<String> biomarkers = new HashSet<String>();
	   biomarkers.add("ERBB2");
	   inCriteria.setBioMarkerCollection(biomarkers);      
   }
   
   private  Collection executeSearch() {
    	
    	 try {
    		 
    		 FISHFindingHandler fishHandler = new FISHFindingHandler();
             Collection<FISHFinding> fish = fishHandler.getFISHFindings(inCriteria);             
             System.out.println("Number of fish finding Retrieved: " + fish.size());
             
             for (Iterator<FISHFinding> iterator = fish.iterator(); iterator.hasNext();) {
            	 FISHFinding fishFinding =  iterator.next();
                 System.out.println("FISH finding ID: " +
                		             fishFinding.getId());
                 System.out.println("GENE: " + fishFinding.getGene());
                 System.out.println("abnomality status: " + fishFinding.getAbnomalityStatus());
                 System.out.println("ratio:  " + fishFinding.getRatio());
                 System.out.println("patient did: " + fishFinding.getSpecimen().getPatientDID());
                 System.out.println("specimen id: "+ fishFinding.getSpecimen().getId());
                 if (fishFinding.getSpecimen().getTimePoint() != null)
                     System.out.println("time point:" + fishFinding.getSpecimen().getTimePoint());
             }
             return fish;
         } catch (Throwable t)  {
            System.out.println("FISH Exception in getting data: " + t.toString());
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
