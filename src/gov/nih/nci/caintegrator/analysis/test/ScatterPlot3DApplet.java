package gov.nih.nci.caintegrator.analysis.test;


import gov.nih.nci.caintegrator.analysis.visualization.PlotData;
import gov.nih.nci.caintegrator.analysis.visualization.SelectablePlot3DPanel;

import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTabbedPane;

import org.math.plot.*;

/**
 * E
 * 
 * @author Yann RICHET
 */
public class ScatterPlot3DApplet extends Applet {

	public void init() {
		int n = 100;
		PlotData[] pd1 = new PlotData[n];
		PlotData[] pd2 = new PlotData[n];
		String name1, name2;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				name1 = "dataSet1_" + i;
				pd1[i] = new PlotData(name1, Math.random(), Math.random(), Math.random());
				name2 = "dataSet2_" + i;
				pd2[i] = new PlotData(name2, Math.random(), Math.random(), Math.random());
				
			}
		}

		// PlotPanel construction
		SelectablePlot3DPanel plotpanel = new SelectablePlot3DPanel();
		plotpanel.addLegend("SOUTH");

		// Data plots addition
		plotpanel.addScatterPlot("datas1", pd1);
		//plotpanel.addBarPlot("datas2", data2); // include plot in applet
		plotpanel.addScatterPlot("datas2", pd2);
		plotpanel.setEditable(true);
		plotpanel.setNotable(true);
		add(plotpanel);	
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