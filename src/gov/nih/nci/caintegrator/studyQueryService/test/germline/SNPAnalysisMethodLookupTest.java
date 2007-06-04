package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisMethod;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;

import java.util.Collection;
import java.util.Iterator;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Author: Himanso Sahni
 * Date:   May 4, 2007
 * Time:   10:30 AM
 */
public class SNPAnalysisMethodLookupTest extends GenotypeFindingTest {

    public void testGetAnalysisMethodTypesMethod() {
    	for(long studyId:studyIDs){
    		studyCrit.setId(studyId);
        	executeGetAnalysisMethodsMethod(studyCrit);
        	executeGetAnalysisMethodTypesMethod(studyCrit);        	
    	}
     	
    }

    private void executeGetAnalysisMethodTypesMethod(StudyCriteria studyCrit) {
    	try {
            Collection<String> analysisMethodTypes = manager.getAnalysisMethodTypes(studyCrit);
            System.out.println("Number of AnalysisMethodTypes Retrieved: " + analysisMethodTypes.size()+
            		"for Study: "+ studyCrit.getName()+studyCrit.getVersion());
            for (String analysisMethodType:analysisMethodTypes) {
               System.out.println("AnalysisMethodType Name: " + analysisMethodType);
               executeGetAnalysisMethodTypesMethod(studyCrit,analysisMethodType);
            }

        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting analysisMethodTypes: " + t.toString());
           t.printStackTrace();
       }
    }
    private void executeGetAnalysisMethodTypesMethod(StudyCriteria studyCrit, String analysisMethodType){
    	try{
            Collection<SNPAnalysisMethod> analysisMethods = manager.getSNPAnalysisMethods(studyCrit, analysisMethodType);
            System.out.println("Number of SNPAnalysisMethod Retrieved: " + analysisMethods.size()+
            		"for Study: "+ studyCrit.getName() + studyCrit.getVersion()+"and SNPAnalysisMethod: "+analysisMethodType);
            System.out.println("methodType "+"\t|"+
		   			  "methodName "+"\t|"+
		   			  "methodDesc "+"\t|"+
		   			  "repCode "+"\t|"+
		   			  "displayOrder "+"\t|");
            for (SNPAnalysisMethod analysisMethod:analysisMethods) {
               System.out.println(analysisMethod.getMethodType() +"\t|"+
            		   			  analysisMethod.getMethodName() +"\t|"+
            		   			  analysisMethod.getMethodDescription() +"\t|"+
            		   			  analysisMethod.getRepresensitiveCode() +"\t|"+
            		   			  analysisMethod.getDisplayOrder());
            }

        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting analysisMethodTypes: " + t.toString());
           t.printStackTrace();
       }
    }
    private void executeGetAnalysisMethodsMethod(StudyCriteria studyCrit){
    	try{
            Collection<SNPAnalysisMethod> analysisMethods = manager.getSNPAnalysisMethods(studyCrit);
            System.out.println("Number of SNPAnalysisMethod Retrieved: " + analysisMethods.size()+
            		"for Study: "+ studyCrit.getName()+studyCrit.getVersion());
            System.out.println("methodType "+"\t|"+
		   			  "methodName "+"\t|"+
		   			  "methodDesc "+"\t|"+
		   			  "repCode "+"\t|"+
		   			  "displayOrder "+"\t|");
	          for (SNPAnalysisMethod analysisMethod:analysisMethods) {
	             System.out.println(analysisMethod.getMethodType() +"\t|"+
	          		   			  analysisMethod.getMethodName() +"\t|"+
	          		   			  analysisMethod.getMethodDescription() +"\t|"+
	          		   			  analysisMethod.getRepresensitiveCode() +"\t|"+
	          		   			  analysisMethod.getDisplayOrder());
	          }

        } catch (Throwable t)  {
           System.out.println("CGEMS Exception in getting analysisMethodTypes: " + t.toString());
           t.printStackTrace();
       }
    }
    public static Test suite() {
        TestSuite suit =  new TestSuite();
        suit.addTest(new TestSuite(SNPAnalysisMethodLookupTest.class));
        return suit;
    }

}
