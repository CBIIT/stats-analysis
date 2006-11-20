package gov.nih.nci.caintegrator.studyQueryService.test.fish;

import gov.nih.nci.caintegrator.domain.finding.copyNumber.fish.bean.FISHFinding;
import gov.nih.nci.caintegrator.studyQueryService.dto.fish.FISHFindingCriteria;
import gov.nih.nci.caintegrator.studyQueryService.fish.FISHFindingHandler;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


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
