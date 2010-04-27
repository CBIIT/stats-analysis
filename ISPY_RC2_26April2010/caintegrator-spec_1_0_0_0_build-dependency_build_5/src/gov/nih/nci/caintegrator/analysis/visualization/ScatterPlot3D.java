package gov.nih.nci.caintegrator.analysis.visualization;

import java.awt.*;

import javax.swing.*;
import java.util.*;

import org.math.plot.*;
import org.math.plot.render.*;
import org.math.plot.plots.*;

/**
 * This class extends the JMathPlot Plot class. It adds the
 * ability to create 3DScatterPlots using PlotData instead of an 
 * array of doubles.
 * 
 * @author Michael A. Harris
 *
 */

public class ScatterPlot3D extends Plot {

	private int type;

	private int radius;

	private boolean[][] pattern;

	private boolean use_pattern;

	private PlotData[] plotData;
	
	private double[][] XY;

	public ScatterPlot3D(String n, Color c, boolean[][] _pattern, PlotData[] plotData) {
		super(n, c);
		this.plotData = plotData;
		use_pattern = true;
		pattern = _pattern;
		setPlotData(plotData);
	}

	public ScatterPlot3D(String n, Color c, int _type, int _radius, PlotData[] plotData) {
		super(n, c);
		use_pattern = false;
		type = _type;
		radius = _radius;
		setPlotData(plotData);
	}

	public ScatterPlot3D(String n, Color c, PlotData[] plotData) {
		this(n, c, AbstractDrawer.ROUND_DOT, AbstractDrawer.DEFAULT_DOT_RADIUS, plotData);
	}

	public void plot(AbstractDrawer draw, Color c) {
		if (!visible)
			return;

		draw.setColor(c);
		if (use_pattern) {
			draw.setDotType(AbstractDrawer.PATTERN_DOT);
			draw.setDotPattern(pattern);
		} else {
			draw.setDotRadius(radius);
			if (type == AbstractDrawer.CROSS_DOT)
				draw.setDotType(AbstractDrawer.CROSS_DOT);
			else
				draw.setDotType(AbstractDrawer.ROUND_DOT);
		}

		double[] plotDataArr = new double[3];
		
		for (int i = 0; i < plotData.length; i++) {
			plotDataArr[0] = plotData[i].getX();
			plotDataArr[1] = plotData[i].getY();
			plotDataArr[2] = plotData[i].getZ();
 			//draw.drawDot(plotData[i].getX(), plotData[i].getY(), plotData[i].getZ());
			draw.drawDot(plotDataArr);
		}
	}

	public void setDotPattern(int t) {
		type = t;
		use_pattern = false;
	}

	public void setDotPattern(boolean[][] t) {
		use_pattern = true;
		pattern = t;
	}

	public void setPlotData(PlotData[] plotData) {
		this.plotData = plotData;
		
		XY = new double[plotData.length][3];
		for (int i=0; i < plotData.length; i++) {
		  XY[i][0] = plotData[i].getX();
		  XY[i][1] = plotData[i].getY();
		  XY[i][2] = plotData[i].getZ();
		}
	}

	public PlotData[] getPlotData() {
		return plotData;
	}
	
	public java.util.List getPickedData(int[] screenCoordTest, AbstractDrawer draw) {
		java.util.List matchedData = new ArrayList();
		double[] plotDataArr = new double[3];
		for (int i = 0; i < plotData.length; i++) {
			plotDataArr[0] = plotData[i].getX();
			plotDataArr[1] = plotData[i].getY();
			plotDataArr[2] = plotData[i].getZ();
			//int[] screenCoord = draw.project(plotData[i].getX(), plotData[i].getY(), plotData[i].getZ());
			int [] screenCoord = draw.project(plotDataArr);

			//System.out.println("isSelected checking screenCoord=(" + screenCoord[0] + "," + screenCoord[1] + ") against testCoord=(" + screenCoordTest[0] + "," + screenCoordTest[1] + ")");
			
			if ((screenCoord[0] + note_precision > screenCoordTest[0]) && (screenCoord[0] - note_precision < screenCoordTest[0])
					&& (screenCoord[1] + note_precision > screenCoordTest[1]) && (screenCoord[1] - note_precision < screenCoordTest[1])) {
				//System.out.println("isSelected found a match! returning data point=" + plotData[i]);
				matchedData.add(plotData[i]);
			}
		}
		return matchedData;
	}

	public double[] isSelected(int[] screenCoordTest, AbstractDrawer draw) {
//		for (int i = 0; i < plotData.length; i++) {
//			int[] screenCoord = draw.project(XY[i]);
//
//			System.out.println("isSelected checking screenCoord=(" + screenCoord[0] + "," + screenCoord[1] + ") against testCoord=(" + screenCoordTest[0] + "," + screenCoordTest[1] + ")");
//			
//			if ((screenCoord[0] + note_precision > screenCoordTest[0]) && (screenCoord[0] - note_precision < screenCoordTest[0])
//					&& (screenCoord[1] + note_precision > screenCoordTest[1]) && (screenCoord[1] - note_precision < screenCoordTest[1])) {
//				System.out.println("isSelected found a match! returning data point=(" + XY[i][0] + "," + XY[i][1] + "," + XY[i][2] + ")");
//				return XY[i];
//			}
//		}
//		return null;
		throw new IllegalStateException("Call getPickedData instead.");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// double[][] XYZ = new double[][]
		// {{.1,.2,.3},{.4,.5,.6},{.7,.8,.9},{1.0,1.1,1.2},{1.3,1.4,1.5},{1.6,1.7,1.8}};

		Plot3DPanel p = new Plot3DPanel();
		for (int i = 0; i < 10; i++) {
			double[][] XYZ = new double[100][3];
			for (int j = 0; j < XYZ.length; j++) {
				XYZ[j][0] = 1 + Math.random();
				XYZ[j][1] = 100 * Math.random();
				XYZ[j][2] = 0.0001 * Math.random();
			}
			p.addScatterPlot("toto" + i, XYZ);
		}
		p.addQuantiletoPlot(0, 0, 0.5);

		p.setLegendOrientation(PlotPanel.SOUTH);
		new FrameView(p).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Plot2DPanel p2 = new Plot2DPanel();
		for (int i = 0; i < 10; i++) {
			double[][] XYZ = new double[100][2];
			for (int j = 0; j < XYZ.length; j++) {
				XYZ[j][0] = 1 + Math.random();
				XYZ[j][1] = 100 * Math.random();
			}
			p2.addScatterPlot("toto" + i, XYZ);
		}
		p2.addQuantiletoPlot(0, 0, 0.5);

		p2.setLegendOrientation(PlotPanel.SOUTH);
		new FrameView(p2).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setData(double[][] d) {
		throw new IllegalStateException("Call setPlotData instead");
	}

	public double[][] getData() {
		return XY;
	}

}