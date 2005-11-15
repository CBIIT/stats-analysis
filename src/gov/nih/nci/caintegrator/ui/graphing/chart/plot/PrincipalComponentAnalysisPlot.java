package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.entity.XYAnnotationEntity;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.util.StringUtils;

import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.util.*;
import java.awt.geom.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrincipalComponentAnalysisPlot {

	
	//Color for Disease grade will be brighter the higher the grade
	//if this doesn't work we will use distinct colors when coloring by disease grade.
	
	public static enum PCAcolorByType {Disease, DiseaseGrade, Gender };
	
	private PCAcolorByType colorBy;
	private PCAcomponent component1;
	private PCAcomponent component2;
	private Map diseaseColorMap = new HashMap();
	private Collection<PrincipalComponentAnalysisDataPoint> dataPoints;
	private JFreeChart pcaChart = null;
	
	public PrincipalComponentAnalysisPlot(Collection<PrincipalComponentAnalysisDataPoint> dataPoints, PCAcomponent component1, PCAcomponent component2, PCAcolorByType colorBy) {
	  this.colorBy = colorBy;
	  this.component1 = component1;
	  this.component2 = component2;
	  this.dataPoints = dataPoints;
	  
	  diseaseColorMap.put("GBM", Color.GREEN);
	  diseaseColorMap.put("ASTRO", Color.BLUE);
	  diseaseColorMap.put("NORMAL", Color.YELLOW);
	  diseaseColorMap.put("OLIGO", Color.CYAN);
	  diseaseColorMap.put("MIXED", Color.MAGENTA);
	  
	  createChart();
	  
	}
	
	private void createChart() {
		
		String xLabel = component1.toString();
		String yLabel = component2.toString();
		
		pcaChart = ChartFactory.createScatterPlot("Principal Component Analysis",xLabel, yLabel, null,  PlotOrientation.VERTICAL,
	            true, 
	            true, 
	            false );
		
		XYPlot plot = (XYPlot) pcaChart.getPlot();
	    plot.setNoDataMessage(null);
	    XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
	    renderer.setToolTipGenerator(new StandardXYToolTipGenerator());
	    renderer.setUseOutlinePaint(true);
        plot.setRangeCrosshairVisible(false);
	    plot.setDomainCrosshairVisible(false);
	        
//	     XYShapeAnnotation annotation = new XYShapeAnnotation(new Rectangle2D.Double(25.0, 25.0, 5, 5));
//	        
//	     plot.addAnnotation(annotation);
	       
	        
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis rangeAxis  =	(NumberAxis) plot.getRangeAxis();
        
        //should determine axis range using datapoints.
        
        domainAxis.setAutoRangeIncludesZero(false);
        
        
        domainAxis.setRange(-150.0, 150.0);
        rangeAxis.setRange(-150.0, 150.0);
        
        
        System.out.println("domainAxis=" + domainAxis.getLabel());
        System.out.println("rangeAxis=" + rangeAxis.getLabel());
	        
	    createGlyphsAndAddToPlot(plot);     
	}
	
	/**
	 * This chart uses the XYAnnotation as a glyph to represent
	 * a single pca data point. Glyph shape is determined by survival time.
	 * Survival of more than 10 months is represented by a circle. 10 months or less
	 * is represented by a square. Component1 values are represented by X 
	 * Component2 values are represented by Y
	 */
	private void createGlyphsAndAddToPlot(XYPlot plot) {
	  XYShapeAnnotation glyph;
	  Shape glyphShape;
	  Color glyphColor;
	  
	  PrincipalComponentAnalysisDataPoint pcaPoint;
	  double x, y;
	  for (Iterator i=dataPoints.iterator(); i.hasNext(); ) {
	    pcaPoint = (PrincipalComponentAnalysisDataPoint) i.next();
	    
	    x = pcaPoint.getComponentValue(component1);
	    y = pcaPoint.getComponentValue(component2);
	    
	    if (pcaPoint.getSurvivalInMonths() < 10.0) {
	      Rectangle2D.Double rect = new Rectangle2D.Double();
	      rect.setFrameFromCenter(x,y, x+3,y+3);
	      glyphShape = rect;
	    }
	    else {
	      Ellipse2D.Double circle = new Ellipse2D.Double();
	      circle.setFrameFromCenter(x,y, x+3, y+3);
	      glyphShape = circle;
	    }
	    
	    glyphColor = getColorForDataPoint(pcaPoint); 
	    glyph = new XYShapeAnnotation(glyphShape, new BasicStroke(1.0f), Color.BLACK, glyphColor);
	    String tooltip = pcaPoint.getSampleId() + " " + pcaPoint.getDiseaseName() + " survivalMonths=" + pcaPoint.getSurvivalInMonths();
	    glyph.setToolTipText(tooltip);
	    plot.addAnnotation(glyph);
	  }
	  
		
	}

	
	/**
	 * Get the color for a PCA data point. The color is determined by the Color by parameter.
	 * @param pcaPoint
	 * @return
	 */
	private Color getColorForDataPoint(PrincipalComponentAnalysisDataPoint pcaPoint) {
	  Color defaultColor = Color.GRAY;
	  Color retColor = null;
	  
	  if (colorBy == PCAcolorByType.Disease) {
	    Color diseaseColor = (Color) diseaseColorMap.get(pcaPoint.getDiseaseName());
	    
	    int grade = pcaPoint.getDiseaseGrade();
	    for (int i=0; i < grade-1; i++) {
	      diseaseColor = diseaseColor.brighter();
	    }
	    retColor = diseaseColor;
	  }
	  else if (colorBy == PCAcolorByType.Gender) {
	    PatientGenderType gender = pcaPoint.getGender();
	    if (gender == PatientGenderType.Female) {
	      retColor = Color.PINK;
	    }
	    else if (gender == PatientGenderType.Male) {
	      retColor = Color.BLUE;
	    }
	  }
	  
	  if (retColor == null) {
	    retColor = defaultColor;
	  }
	  
	  return retColor;
	}

	public JFreeChart getChart() { return pcaChart; }
	
	
	/**
	 * This method handles overlapping entities.  The JFreeChart writeImageMap 
	 * utilities appear to not report entities that overlap with other entities.
	 * @param b 
	 * @param info2 
	 * @param string 
	 * @param writer 
	 *
	 */
	public void writeImageMap(PrintWriter writer, String name, ChartRenderingInfo info, boolean useOverlibToolTip) {
		
		
		 /*
		  *  StringBuffer sb = new StringBuffer();
        sb.append("<map id=\"" + name + "\" name=\"" + name + "\">");
        sb.append(StringUtils.getLineSeparator());
        EntityCollection entities = info.getEntityCollection();
        if (entities != null) {
            int count = entities.getEntityCount();
            for (int i = count - 1; i >= 0; i--) {
                ChartEntity entity = entities.getEntity(i);
                if (entity.getToolTipText() != null 
                        || entity.getURLText() != null) {
                    String area = entity.getImageMapAreaTag(
                        toolTipTagFragmentGenerator, urlTagFragmentGenerator
                    );
                    if (area.length() > 0) {
                        sb.append(area);
                        sb.append(StringUtils.getLineSeparator());
                    }
                }
            }
        }
        sb.append("</map>");
		  */
		
		 StringBuffer sb = new StringBuffer();
		 sb.append("<map id=\"" + name + "\" name=\"" + name + "\">");
		 sb.append(StringUtils.getLineSeparator());
		 
		 EntityCollection collection = info.getEntityCollection();
         Collection entities = collection.getEntities();
         System.out.println("Num entities=" + entities.size());
         XYAnnotationEntity annotationEntity;
         ChartEntity chartEntity;
         int count = 0;
         StandardToolTipTagFragmentGenerator ttg = new StandardToolTipTagFragmentGenerator();
         StandardURLTagFragmentGenerator urlg = new StandardURLTagFragmentGenerator();
         for (Iterator i=entities.iterator(); i.hasNext(); ) {
	       	 chartEntity = (ChartEntity) i.next();
	       	 if (chartEntity instanceof XYAnnotationEntity) {
	       	   annotationEntity = (XYAnnotationEntity) chartEntity;
	           sb.append(annotationEntity.getImageMapAreaTag(ttg, urlg));
	           sb.append(StringUtils.getLineSeparator());	             
	       	 }
         }
         sb.append("</map>");
         writer.println(sb.toString());
	}

	

}
