package gov.nih.nci.caintegrator.analysis.test;

import gov.nih.nci.caintegrator.ui.graphing.chart.plot.PrincipalComponentAnalysisPlot;
import gov.nih.nci.caintegrator.ui.graphing.chart.plot.PrincipalComponentAnalysisPlot.PCAcolorByType;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint.PCAcomponent;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.entity.StandardEntityCollection;



public class Pca2Dtest {

	public Pca2Dtest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 try {
			 
			  //read in the sample charts
			 PrincipalComponentAnalysisDataPoint pcaPoint;
			 List<PrincipalComponentAnalysisDataPoint> pointList = new ArrayList<PrincipalComponentAnalysisDataPoint>();
			 
			 //open the sample data file and read
			 try {
					//read in the HF dataset from a file
					
					
					 BufferedReader in = new BufferedReader(new FileReader("HFpcaWsurvival.txt"));
					 String line;
					  StringTokenizer t;
					  String id, diseaseGrp;
					  double pc1, pc2, pc3, survivalInMonths;
					  
					  while ((line = in.readLine()) != null) {
					    t = new StringTokenizer(line, ",");
					    id = t.nextToken().trim();
					    pcaPoint = new PrincipalComponentAnalysisDataPoint(id);
					    pcaPoint.setDiseaseName(t.nextToken().trim());
					    pcaPoint.setPc1value(Double.parseDouble(t.nextToken()));
					    pcaPoint.setPc2value(Double.parseDouble(t.nextToken()));				
					    pcaPoint.setPc3value(Double.parseDouble(t.nextToken()));
					    pcaPoint.setSurvivalInMonths(Double.parseDouble(t.nextToken()));
					    pointList.add(pcaPoint);
					  }
			 }
			 catch (Exception ex) {
		       ex.printStackTrace(System.out);
			 }
	          
	          
	          
	          //Generate the image map. Need to generate custom image map because
	          //overlapping points where not being output by the JFree chart methods.
	          
			  File file_pc1vspc2 = new File("PC1vsPC2.png");
	          PrincipalComponentAnalysisPlot pc1vspc2 = new PrincipalComponentAnalysisPlot(pointList,
	        		  PCAcomponent.PC1, PCAcomponent.PC2, PCAcolorByType.Disease);
	          ChartRenderingInfo pc1vspc2info = new ChartRenderingInfo(
	  				new StandardEntityCollection());
	          ChartUtilities.saveChartAsPNG(file_pc1vspc2, pc1vspc2.getChart(), 650, 400, pc1vspc2info);
	          PrintWriter pw1 = new PrintWriter(new FileWriter("PC1vsPC2.im"));
	          pc1vspc2.writeImageMap(pw1, "PC1vsPC2",pc1vspc2info, true);
	          pw1.close();
	          
	          //PC1 vs PC3
	          File file_pc1vspc3 = new File("PC1vsPC3.png");
	          PrincipalComponentAnalysisPlot pc1vspc3 = new PrincipalComponentAnalysisPlot(pointList,
	        		  PCAcomponent.PC1, PCAcomponent.PC3, PCAcolorByType.Disease);
	          ChartRenderingInfo pc1vspc3info = new ChartRenderingInfo(
	  				new StandardEntityCollection());
	          ChartUtilities.saveChartAsPNG(file_pc1vspc3, pc1vspc3.getChart(), 650, 400, pc1vspc3info);
	          PrintWriter pw2 = new PrintWriter(new FileWriter("PC1vsPC3.im"));
	          pc1vspc3.writeImageMap(pw2, "PC1vsPC3",pc1vspc3info, true);
	          pw2.close();
	          
	          
	          //PC2 vs PC3
	          File file_pc2vspc3 = new File("PC2vsPC3.png");
	          PrincipalComponentAnalysisPlot pc2vspc3 = new PrincipalComponentAnalysisPlot(pointList,
	        		  PCAcomponent.PC2, PCAcomponent.PC3, PCAcolorByType.Disease);
	          ChartRenderingInfo pc2vspc3info = new ChartRenderingInfo(
	  				new StandardEntityCollection());
	          ChartUtilities.saveChartAsPNG(file_pc2vspc3, pc2vspc3.getChart(), 650, 400, pc2vspc3info);
	          PrintWriter pw3 = new PrintWriter(new FileWriter("PC2vsPC3.im"));
	          pc1vspc3.writeImageMap(pw3, "PC2vsPC3",pc2vspc3info, true);
	          pw3.close();
	        }
	        catch (IOException ex) {
	          System.out.println("Could not write chart to png.");
	          ex.printStackTrace(System.out);
	        }

	}
}
