package gov.nih.nci.caintegrator.ui.graphing.chart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gov.nih.nci.caintegrator.ui.graphing.chart.plot.KaplanMeierPlot;
import gov.nih.nci.caintegrator.ui.graphing.chart.plot.PrincipalComponentAnalysisPlot;

import gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier.KaplanMeierPlotPointSeriesSet;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint;

import org.jfree.chart.JFreeChart;

import gov.nih.nci.caintegrator.ui.graphing.chart.plot.PrincipalComponentAnalysisPlot.*;

public class CaIntegratorChartFactory {
	
	
	public static JFreeChart getKaplanMeierGraph(Collection<KaplanMeierPlotPointSeriesSet> series) {
		KaplanMeierPlot km = new KaplanMeierPlot(series);
		return km.getKmChart();
	}
	
	public static List<JFreeChart> getPrincipalComponentAnalysisGraphs(Collection<PrincipalComponentAnalysisDataPoint> pcaData, PCAcolorByType colorBy) {
	  List<JFreeChart> pcaPlotList = new ArrayList();
	  PrincipalComponentAnalysisPlot PC1vsPC2 = new PrincipalComponentAnalysisPlot(PCAcomponent.PC1,PCAcomponent.PC2);
	  pcaPlotList.add(PC1vsPC2.getChart());
	  PrincipalComponentAnalysisPlot PC1vsPC3 = new PrincipalComponentAnalysisPlot(PCAcomponent.PC1,PCAcomponent.PC3);
	  pcaPlotList.add(PC1vsPC3.getChart());
	  PrincipalComponentAnalysisPlot PC2vsPC3 = new PrincipalComponentAnalysisPlot(PCAcomponent.PC2,PCAcomponent.PC3);
	  pcaPlotList.add(PC2vsPC3.getChart());
	  
	  return pcaPlotList;
	  
	}
}
