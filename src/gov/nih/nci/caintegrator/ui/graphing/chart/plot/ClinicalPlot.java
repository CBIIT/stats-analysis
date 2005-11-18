package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import gov.nih.nci.caintegrator.ui.graphing.data.clinical.ClinicalDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.clinical.ClinicalDataPoint.ClinicalFactorType;

import java.util.Collection;

import org.jfree.chart.JFreeChart;

public class ClinicalPlot {
	
	private JFreeChart clinicalChart = null;

	public ClinicalPlot(Collection<ClinicalDataPoint> clinicalData, ClinicalFactorType factor1, ClinicalFactorType factor2) {
		super();
		// TODO Auto-generated constructor stub
	}
	public JFreeChart getChart() { return clinicalChart; }

}
