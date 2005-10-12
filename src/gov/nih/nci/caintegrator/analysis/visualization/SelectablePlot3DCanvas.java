package gov.nih.nci.caintegrator.analysis.visualization;

import org.math.plot.canvas.Plot3DCanvas;
import org.math.plot.plotObjects.Base;
import org.math.plot.plotObjects.BasePlot;
import org.math.plot.plots.ScatterPlot;



import java.awt.*;
import java.awt.event.*;

/**
 * This class extends the JMathPlot Plot3DCanvas. 
 * It adds tooltips that popup when the mouse moves over
 * a data point.
 * 
 * @author Michael A. Harris
 *
 */

public class SelectablePlot3DCanvas extends Plot3DCanvas {

	public SelectablePlot3DCanvas() {
		super();
	}

	public SelectablePlot3DCanvas(Base b, BasePlot bp) {
		super(b, bp);
	}

	public SelectablePlot3DCanvas(double[] min, double[] max, String[] axesScales, String[] axesLabels) {
		super(min, max, axesScales, axesLabels);
	}
	
	public void mouseClicked(MouseEvent event) {
	  //super.mouseClicked(event);
	  System.out.println("Mouse clicked on point=" + event.getPoint());
	}
	
	public void paint(Graphics g) {
		//System.out.println("SelectablePlot3DCanvas.paint");
		super.paint(g);
	}
	
	public void paintComponent(Graphics g) {
		//System.out.println("SelectablePlot3DCanvas.paintComponent");
		super.paintComponent(g);
	}
	
	public void mouseMoved(MouseEvent event) {
	  super.mouseMoved(event);
	  
	  int[] mousePos = new int[2];
	  mousePos[0] = event.getX();
	  mousePos[1] = event.getY();
	  boolean foundMatch = false;
	  java.util.List<PlotData> matchedData;
	  for (int i = 0; i < plots.size(); i++) {
			matchedData = ((ScatterPlot3D)getPlot(i)).getPickedData(mousePos, draw);
			if (!matchedData.isEmpty()) {
			  PlotData dp = matchedData.get(0);
			  setToolTipText("Mouse over data point=" + dp);
			  foundMatch = true;
			  break;
			}
	  }		
	  
	  if (!foundMatch) {
	    setToolTipText(null);
	  }
	}

}
