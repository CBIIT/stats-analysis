package gov.nih.nci.caintegrator.analysis.visualization;

/**
 * This class extends the JMathPlot Plot3DPanel.   It adds the ability to create
 * 3D scatter plots of named data points. 
 * 
 * @author Michael A. Harris
 */

import java.awt.Color;

import org.math.plot.Plot3DPanel;
import org.math.plot.canvas.Plot3DCanvas;
import org.math.plot.canvas.PlotCanvas;
import org.math.plot.plots.ScatterPlot;

public class SelectablePlot3DPanel extends Plot3DPanel {

	public SelectablePlot3DPanel() {
		super(new SelectablePlot3DCanvas());
	}

	public SelectablePlot3DPanel(double[] min, double[] max, String[] axesScales, String[] axesLabels) {
		super(new SelectablePlot3DCanvas(min, max, axesScales, axesLabels));
	}

	public SelectablePlot3DPanel(PlotCanvas _canvas, String legendOrientation) {
		super(_canvas, legendOrientation);
	}

	public SelectablePlot3DPanel(PlotCanvas _canvas) {
		super(_canvas);
	}

	public SelectablePlot3DPanel(String legendOrientation) {
		super(new SelectablePlot3DCanvas(), legendOrientation);
	}
	
//	public int addSelectableScatterPlot(String name, Color c, PlotData[] plotData) {
//		return ((SelectablePlot3DCanvas) plotCanvas).addScatterPlot(name, c, plotData);
//	}
	
	public int addScatterPlot(String name, Color c, double[]... XY) {
		return ((SelectablePlot3DCanvas) plotCanvas).addScatterPlot(name, c, XY);
	}

	public int addScatterPlot(String name, double[]... XY) {
		return addScatterPlot(name, getNewColor(), XY);
	}

	
	public int addScatterPlot(String name, PlotData[] dataPoints) {
		return addScatterPlot(name, getNewColor(), dataPoints);
	}
	
	public int addScatterPlot(String name, Color c, PlotData[] dataPoints) {		
		return addPlot(new ScatterPlot3D(name, c, dataPoints));
	}
}
