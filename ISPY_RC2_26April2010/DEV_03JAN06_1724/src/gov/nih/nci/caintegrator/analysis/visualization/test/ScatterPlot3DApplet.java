package gov.nih.nci.caintegrator.analysis.visualization.test;


import gov.nih.nci.caintegrator.analysis.visualization.PlotData;
import gov.nih.nci.caintegrator.analysis.visualization.SelectablePlot3DPanel;

import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTabbedPane;

import org.math.plot.*;
import java.io.*;
import java.util.*;
import java.net.*;

/**
 * E
 * 
 * @author Michael Harris
 */
public class ScatterPlot3DApplet extends Applet {

	private List gbmPlotData = new ArrayList();
	private List astroPlotData = new ArrayList();
	private List oligoPlotData = new ArrayList();
	private List mixedPlotData = new ArrayList();
	private List normalPlotData = new ArrayList();
	
	public void init() {
//		int n = 100;
//		PlotData[] pd1 = new PlotData[n];
//		PlotData[] pd2 = new PlotData[n];
//		String name1, name2;
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 3; j++) {
//				name1 = "dataSet1_" + i;
//				pd1[i] = new PlotData(name1, Math.random(), Math.random(), Math.random());
//				name2 = "dataSet2_" + i;
//				pd2[i] = new PlotData(name2, Math.random(), Math.random(), Math.random());
//				
//			}
//		}
		
		SelectablePlot3DPanel plotpanel = new SelectablePlot3DPanel();
		
		//load the HF data
		try {
		  URL source = new URL(getCodeBase(), "HFpca.txt");
		  BufferedReader in = new BufferedReader(new InputStreamReader(source.openStream()));
		  String line;
		  StringTokenizer t;
		  String id, grp;
		  double pc1, pc2, pc3;
		  while ((line = in.readLine()) != null) {
		    t = new StringTokenizer(line, ",");
		    id = t.nextToken().trim();
		    grp = t.nextToken().trim();
		    pc1 = Double.parseDouble(t.nextToken());
		    pc2 = Double.parseDouble(t.nextToken());
		    pc3 = Double.parseDouble(t.nextToken());
		    
		    if (grp.equalsIgnoreCase("GBM")) {
		      gbmPlotData.add(new PlotData(id, pc1, pc2, pc3));
		    }
		    else if (grp.equalsIgnoreCase("ASTRO")) {
		      astroPlotData.add(new PlotData(id, pc1, pc2, pc3));		      
		    }
		    else if (grp.equalsIgnoreCase("OLIGO")) {
		      oligoPlotData.add(new PlotData(id, pc1, pc2, pc3));
		    }
		    else if (grp.equalsIgnoreCase("MIXED")) {
		      mixedPlotData.add(new PlotData(id, pc1, pc2, pc3));
		    }
		    else if (grp.equalsIgnoreCase("NORMAL")) {
		      normalPlotData.add(new PlotData(id, pc1, pc2, pc3));
		    }
		    
		  }
		  plotpanel.addScatterPlot("GBM", getPlotArray(gbmPlotData));
	  	  plotpanel.addScatterPlot("ASTRO", getPlotArray(astroPlotData));
	  	  plotpanel.addScatterPlot("OLIGO", getPlotArray(oligoPlotData));
	  	  plotpanel.addScatterPlot("MIXED", getPlotArray(mixedPlotData));
	  	  plotpanel.addScatterPlot("NORMAL", getPlotArray(normalPlotData));
			
		}
		catch (IOException ex) {
		  ex.printStackTrace(System.out);
		}
		

		// PlotPanel construction
		
		plotpanel.addLegend("SOUTH");

		// Data plots addition
		//plotpanel.addScatterPlot("datas1", pd1);
		//plotpanel.addBarPlot("datas2", data2); // include plot in applet
		//plotpanel.addScatterPlot("datas2", pd2);
		plotpanel.setEditable(true);
		plotpanel.setNotable(true);
		add(plotpanel);	
	}
	
	private PlotData[] getPlotArray(List plotDataList) {
		  PlotData[] retArr = new PlotData[plotDataList.size()];
		  plotDataList.toArray(retArr);
		  return retArr;
	}
	
//	public void initOld() { // Data definition
//		int n = 10;
//		double[][] data1 = new double[n][3];
//		double[][] data2 = new double[n][3];
//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 3; j++) {
//				data1[i][j] = Math.random();
//				data2[i][j] = Math.random();
//			}
//		}
//
//		// PlotPanel construction
//		SelectablePlot3DPanel plotpanel = new SelectablePlot3DPanel();
//		plotpanel.addLegend("SOUTH");
//
//		// Data plots addition
//		plotpanel.addScatterPlot("datas1", data1);
//		//plotpanel.addBarPlot("datas2", data2); // include plot in applet
//		plotpanel.addScatterPlot("datas2", data2);
//		plotpanel.setEditable(true);
//		plotpanel.setNotable(true);
//		add(plotpanel);
//	}
	
}