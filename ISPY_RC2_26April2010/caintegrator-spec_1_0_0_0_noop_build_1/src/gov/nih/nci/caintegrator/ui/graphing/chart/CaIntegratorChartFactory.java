package gov.nih.nci.caintegrator.ui.graphing.chart;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import gov.nih.nci.caintegrator.enumeration.ClinicalFactorType;
import gov.nih.nci.caintegrator.ui.graphing.chart.plot.ClinicalPlot;
import gov.nih.nci.caintegrator.ui.graphing.chart.plot.KaplanMeierPlot;
import gov.nih.nci.caintegrator.ui.graphing.chart.plot.PrincipalComponentAnalysisPlot;

import gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier.KaplanMeierPlotPointSeriesSet;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint.*;
import gov.nih.nci.caintegrator.ui.graphing.data.clinical.ClinicalDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.clinical.ClinicalDataPoint.*;

import org.jfree.chart.JFreeChart;

import gov.nih.nci.caintegrator.ui.graphing.chart.plot.PrincipalComponentAnalysisPlot.*;

public class CaIntegratorChartFactory {
	
	
	public static JFreeChart getKaplanMeierGraph(Collection<KaplanMeierPlotPointSeriesSet> series) {
		KaplanMeierPlot km = new KaplanMeierPlot(series);
		return km.getKmChart();
	}
	
	/**
	 * Generate 3 JFreeCharts which together give a 2 dimensional representation
	 * of the 3 dimensional principal component data.
	 * 
	 * @param pcaData
	 * @param colorBy
	 * @return a list containing the 3 JFreeCharts
	 */
	public static List<JFreeChart> getPrincipalComponentAnalysisGraphs(Collection<PrincipalComponentAnalysisDataPoint> pcaData, PCAcolorByType colorBy) {
	  List<JFreeChart> pcaPlotList = new ArrayList<JFreeChart>();
	  PrincipalComponentAnalysisPlot PC1vsPC2 = new PrincipalComponentAnalysisPlot(pcaData, PCAcomponent.PC1,PCAcomponent.PC2, colorBy);
	  pcaPlotList.add(PC1vsPC2.getChart());
	  PrincipalComponentAnalysisPlot PC1vsPC3 = new PrincipalComponentAnalysisPlot(pcaData, PCAcomponent.PC1,PCAcomponent.PC3, colorBy);
	  pcaPlotList.add(PC1vsPC3.getChart());
	  PrincipalComponentAnalysisPlot PC2vsPC3 = new PrincipalComponentAnalysisPlot(pcaData, PCAcomponent.PC2,PCAcomponent.PC3, colorBy);
	  pcaPlotList.add(PC2vsPC3.getChart());
	  
	  return pcaPlotList; 
	}
	
	/**
	 * Generate a JFreeChart representing one plane of the 3D pca data.
	 * @param pcaData
	 * @param colorBy
	 * @return a JFreeChart
	 */
	public static JFreeChart getPrincipalComponentAnalysisGraph(Collection<PrincipalComponentAnalysisDataPoint> pcaData, PCAcomponent component1, PCAcomponent component2, PCAcolorByType colorBy) {
	  PrincipalComponentAnalysisPlot plot = new PrincipalComponentAnalysisPlot(pcaData, component1, component2, colorBy);
	  return plot.getChart();
	}
	
	/**
	 * Create three clinical graphs. The clinical graphs are scatter plots:
	 * a) survivalInMonths vs age at diagnosis
	 * b) survivalInMonths vs treatment 
	 * c) survivalInMonths vs Neurological Assessment
	 * 
	 * @param clinicalData
	 * @return
	 */
	public static List<JFreeChart> getClinicalGraphs(Collection<ClinicalDataPoint> clinicalData) {
		List<JFreeChart> clinicalPlotList = new ArrayList<JFreeChart>();
		ClinicalPlot ageAtDxVSsurvival = new ClinicalPlot(clinicalData, ClinicalFactorType.AgeAtDx,ClinicalFactorType.SurvivalLength);
		clinicalPlotList.add(ageAtDxVSsurvival.getChart());
		ClinicalPlot neurologicalAssessmentVSsurvival = new ClinicalPlot(clinicalData, ClinicalFactorType.KarnofskyAssessment,ClinicalFactorType.SurvivalLength);
		clinicalPlotList.add(neurologicalAssessmentVSsurvival.getChart());
		  
		return clinicalPlotList; 
	}
	
	/**
	 * Create three clinical graphs. The clinical graphs are scatter plots:
	 * a) survivalInMonths vs age at diagnosis
	 * b) survivalInMonths vs treatment 
	 * c) survivalInMonths vs Neurological Assessment
	 * 
	 * @param clinicalData
	 * @return
	 */
	public static JFreeChart getClinicalGraph(Collection<ClinicalDataPoint> clinicalData, ClinicalFactorType factor1, ClinicalFactorType factor2) {
		ClinicalPlot plot = new ClinicalPlot(clinicalData, factor1,factor2);
		return plot.getChart();
	}
}
