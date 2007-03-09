package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import gov.nih.nci.caintegrator.enumeration.DiseaseType;
import gov.nih.nci.caintegrator.enumeration.GenderType;
import gov.nih.nci.caintegrator.ui.graphing.data.DataRange;
import gov.nih.nci.caintegrator.ui.graphing.data.clinical.ClinicalDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint;
import gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis.PrincipalComponentAnalysisDataPoint.PCAcomponent;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.io.PrintWriter;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator;
import org.jfree.chart.imagemap.StandardURLTagFragmentGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.util.ShapeUtilities;
import org.jfree.util.StringUtils;
/**
 * This class generates a plot for the PrincipalComponentAnalysis graph.
 * @author Michael A Harris
 *
 */


/**
* caIntegrator License
* 
* Copyright 2001-2005 Science Applications International Corporation ("SAIC"). 
* The software subject to this notice and license includes both human readable source code form and machine readable, 
* binary, object code form ("the caIntegrator Software"). The caIntegrator Software was developed in conjunction with 
* the National Cancer Institute ("NCI") by NCI employees and employees of SAIC. 
* To the extent government employees are authors, any rights in such works shall be subject to Title 17 of the United States
* Code, section 105. 
* This caIntegrator Software License (the "License") is between NCI and You. "You (or "Your") shall mean a person or an 
* entity, and all other entities that control, are controlled by, or are under common control with the entity. "Control" 
* for purposes of this definition means (i) the direct or indirect power to cause the direction or management of such entity,
*  whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) 
* beneficial ownership of such entity. 
* This License is granted provided that You agree to the conditions described below. NCI grants You a non-exclusive, 
* worldwide, perpetual, fully-paid-up, no-charge, irrevocable, transferable and royalty-free right and license in its rights 
* in the caIntegrator Software to (i) use, install, access, operate, execute, copy, modify, translate, market, publicly 
* display, publicly perform, and prepare derivative works of the caIntegrator Software; (ii) distribute and have distributed 
* to and by third parties the caIntegrator Software and any modifications and derivative works thereof; 
* and (iii) sublicense the foregoing rights set out in (i) and (ii) to third parties, including the right to license such 
* rights to further third parties. For sake of clarity, and not by way of limitation, NCI shall have no right of accounting
* or right of payment from You or Your sublicensees for the rights granted under this License. This License is granted at no
* charge to You. 
* 1. Your redistributions of the source code for the Software must retain the above copyright notice, this list of conditions
*    and the disclaimer and limitation of liability of Article 6, below. Your redistributions in object code form must reproduce 
*    the above copyright notice, this list of conditions and the disclaimer of Article 6 in the documentation and/or other materials
*    provided with the distribution, if any. 
* 2. Your end-user documentation included with the redistribution, if any, must include the following acknowledgment: "This 
*    product includes software developed by SAIC and the National Cancer Institute." If You do not include such end-user 
*    documentation, You shall include this acknowledgment in the Software itself, wherever such third-party acknowledgments 
*    normally appear.
* 3. You may not use the names "The National Cancer Institute", "NCI" "Science Applications International Corporation" and 
*    "SAIC" to endorse or promote products derived from this Software. This License does not authorize You to use any 
*    trademarks, service marks, trade names, logos or product names of either NCI or SAIC, except as required to comply with
*    the terms of this License. 
* 4. For sake of clarity, and not by way of limitation, You may incorporate this Software into Your proprietary programs and 
*    into any third party proprietary programs. However, if You incorporate the Software into third party proprietary 
*    programs, You agree that You are solely responsible for obtaining any permission from such third parties required to 
*    incorporate the Software into such third party proprietary programs and for informing Your sublicensees, including 
*    without limitation Your end-users, of their obligation to secure any required permissions from such third parties 
*    before incorporating the Software into such third party proprietary software programs. In the event that You fail 
*    to obtain such permissions, You agree to indemnify NCI for any claims against NCI by such third parties, except to 
*    the extent prohibited by law, resulting from Your failure to obtain such permissions. 
* 5. For sake of clarity, and not by way of limitation, You may add Your own copyright statement to Your modifications and 
*    to the derivative works, and You may provide additional or different license terms and conditions in Your sublicenses 
*    of modifications of the Software, or any derivative works of the Software as a whole, provided Your use, reproduction, 
*    and distribution of the Work otherwise complies with the conditions stated in this License.
* 6. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, 
*    THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. 
*    IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE, SAIC, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, 
*    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
*    GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
*    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
*    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
*/

public class PrincipalComponentAnalysisPlot {

	
	//Color for Disease grade will be brighter the higher the grade
	//if this doesn't work we will use distinct colors when coloring by disease grade.
	
	public static enum PCAcolorByType {Disease, DiseaseGrade, Gender, NONE };
	
	protected PCAcolorByType colorBy;
	protected PCAcomponent component1;
	protected PCAcomponent component2;
	//private Map diseaseColorMap = new HashMap();
	protected Collection<PrincipalComponentAnalysisDataPoint> dataPoints;
	protected JFreeChart pcaChart = null;
	protected NumberFormat nf = NumberFormat.getNumberInstance();
	
	public PrincipalComponentAnalysisPlot(Collection<PrincipalComponentAnalysisDataPoint> dataPoints, PCAcomponent component1, PCAcomponent component2, PCAcolorByType colorBy) {
	  this.colorBy = colorBy;
	  this.component1 = component1;
	  this.component2 = component2;
	  this.dataPoints = dataPoints;
	  this.nf.setMaximumFractionDigits(1);
	  
//	  diseaseColorMap.put("GBM", Color.GREEN);
//	  diseaseColorMap.put("ASTRO", Color.BLUE);
//	  diseaseColorMap.put("NORMAL", Color.YELLOW);
//	  diseaseColorMap.put("OLIGO", Color.CYAN);
//	  diseaseColorMap.put("MIXED", Color.MAGENTA);
	  
	  createChart();
	  
	}
	
	protected void createChart() {
		
		String xLabel = component1.toString();
		String yLabel = component2.toString();
		
		
		
		pcaChart = ChartFactory.createScatterPlot("Principal Component Analysis",xLabel, yLabel, null,  PlotOrientation.VERTICAL,
	            true, 
	            true, 
	            false );
		
		XYPlot plot = (XYPlot) pcaChart.getPlot();
		
		if(!this.colorBy.equals(PCAcolorByType.NONE)){
			buildLegend();
		}	
		
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
        DataRange component1Range = getDataRange(dataPoints, PCAcomponent.PC1);
        DataRange component2Range = getDataRange(dataPoints, PCAcomponent.PC2);
        DataRange component3Range = getDataRange(dataPoints, PCAcomponent.PC3);
        
        Double pc1AbsMax = Math.max(Math.abs(component1Range.getMaxRange()), Math.abs(component1Range.getMinRange()));
        Double pc2AbsMax = Math.max(Math.abs(component2Range.getMaxRange()), Math.abs(component2Range.getMinRange()));
        Double pc3AbsMax = Math.max(Math.abs(component3Range.getMaxRange()), Math.abs(component3Range.getMinRange()));
        
        Double maxAbsVal = Math.max(pc1AbsMax, pc2AbsMax);
        
        maxAbsVal = Math.max(maxAbsVal, pc3AbsMax);
        
        maxAbsVal = Math.max(150.0, maxAbsVal);
        
        domainAxis.setAutoRangeIncludesZero(false);
         
        domainAxis.setRange(-maxAbsVal, maxAbsVal);
        rangeAxis.setRange(-maxAbsVal, maxAbsVal);
        
        domainAxis.setTickUnit(new NumberTickUnit(25.0));
        rangeAxis.setTickUnit(new NumberTickUnit(25.0));
          
	    createGlyphsAndAddToPlot(plot);  
	    
	   // Paint p = new GradientPaint(0, 0, Color.white, 1000, 0, Color.green);
	    //try and match the UI e9e9e9
	    Paint p = new Color(233, 233, 233);
	    
	    pcaChart.setBackgroundPaint(p);
	}
	
	/**
	 * Build the legend
	 *
	 */
	protected void buildLegend() {
	
	  LegendTitle legend = pcaChart.getLegend();
	  LegendItemSource[] sources = new LegendItemSource[1];
	  PcaLegendItemSource legendSrc = new PcaLegendItemSource();
	  LegendItem item = null;
	    
	  //Rect=survival less than 10 months
	  item = new LegendItem("Survival less than 10 months", null, null, null, new Rectangle2D.Double(0,0,8,8), Color.BLACK);
	  legendSrc.addLegendItem(item);
	  
	  //Circle=survival 10 months or more
	  item = new LegendItem("Survival over 10 months", null, null, null, new Ellipse2D.Double(0,0,8,8), Color.BLACK);
	  legendSrc.addLegendItem(item);
	  
	  //Triangle if data if survival data is missing
	  GeneralPath triangle = new GeneralPath();
//	  triangle.moveTo(1.0f,0.0f);
//	  triangle.moveTo(0.0f,1.0f);
//	  triangle.moveTo(1.0f,1.0f);
	  triangle.moveTo(0.0f, -4.0f);
	  triangle.lineTo(4.0f, 4.0f);
	  triangle.lineTo(-4.0f, 4.0f);
	  triangle.closePath();
	  //triangle.closePath();
	  item = new LegendItem("Survival Unknown", null, null, null, triangle, Color.BLACK);
	  legendSrc.addLegendItem(item);  
	  
	  //Diamond=survival N/A, for non_tumor/normal
	  Shape r = new Rectangle2D.Double(0,0,8,8);
	  Shape d = ShapeUtilities.rotateShape(r, new Double(0.785398163), new Float(0),new Float(0));
	  item = new LegendItem("Survival N/A", null, null, null, d, Color.BLACK);
	  legendSrc.addLegendItem(item);
	  
	  
	  if (colorBy == PCAcolorByType.Disease) {
	    //go through the disease color map and add legend items
		String diseaseName = null;
		Color diseaseColor = null;
		DiseaseType[] diseases = DiseaseType.values();
		for (int i=0; i < diseases.length; i++ ) {
		  diseaseName = diseases[i].name();
		  if(diseases[i].equals(DiseaseType.UNCLASSIFIED))	{
			  continue; //remove unclassified from the legend
		  }
		  diseaseColor = diseases[i].getColor();
		  item = new LegendItem(diseaseName, null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), diseaseColor);
		  //item = new LegendItem(diseaseName, null, null, null, new Rectangle2D.Double(0,0,6,6), diseaseColor);
		  legendSrc.addLegendItem(item);
		}
//		item = new LegendItem("Unknown", null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), Color.GRAY);
//		legendSrc.addLegendItem(item);
	  }
	  else if (colorBy == PCAcolorByType.Gender) {
		  String genderName = null;
		  Color genderColor = null;
		  GenderType[] genderTypes = GenderType.values();
		  for (int i=0; i < genderTypes.length; i++) {
		    genderName = genderTypes[i].toString();
		    genderColor = genderTypes[i].getColor();
		    item = new LegendItem(genderName, null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), genderColor);
		    legendSrc.addLegendItem(item);
		  }
//		  item = new LegendItem("Male", null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), Color.BLUE);
//		  legendSrc.addLegendItem(item);
//		  item = new LegendItem("Female", null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), Color.PINK);
//		  legendSrc.addLegendItem(item);
//		  item = new LegendItem("Unknown", null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f),Color.GRAY);
//		  legendSrc.addLegendItem(item);
	  }
	  
	    
	  sources[0] = legendSrc;
	  legend.setSources(sources);
	}
	
	/**
	 * This chart uses the XYAnnotation as a glyph to represent
	 * a single pca data point. Glyph shape is determined by survival time.
	 * Survival of more than 10 months is represented by a circle. 10 months or less
	 * is represented by a square. Component1 values are represented by X 
	 * Component2 values are represented by Y
	 */
	protected void createGlyphsAndAddToPlot(XYPlot plot) {
	  XYShapeAnnotation glyph;
	  Shape glyphShape;
	  Color glyphColor;
	  
	  PrincipalComponentAnalysisDataPoint pcaPoint;
	  double x, y;
	  for (Iterator i=dataPoints.iterator(); i.hasNext(); ) {
	    pcaPoint = (PrincipalComponentAnalysisDataPoint) i.next();
	    
	    x = pcaPoint.getComponentValue(component1);
	    y = pcaPoint.getComponentValue(component2);
	    double survival = pcaPoint.getSurvivalInMonths();
	    if ((survival > 0) && (survival < 10.0)) {
	      Rectangle2D.Double rect = new Rectangle2D.Double();
	      rect.setFrameFromCenter(x,y, x+2,y+2);
	      glyphShape = rect;
	    }
	    else if ((survival > 0) && (survival >= 10.0)) {
	      Ellipse2D.Double circle = new Ellipse2D.Double();
	      circle.setFrameFromCenter(x,y, x+2, y+2);
	      glyphShape = circle;
	    }
	    else {
	      //Rectangle2D.Double rect = new Rectangle2D.Double();
	      //rect.setFrameFromCenter(x,y, x+2,y+2);
	      GeneralPath gp = new GeneralPath();
	      float xf = (float)x;
	      float yf = (float)y;
	      //make a triangle
	      gp.moveTo(xf,yf);
	      gp.lineTo(xf+3.0f,yf-3.0f);
	      gp.lineTo(xf-3.0f,yf-3.0f);
	      gp.closePath();
	      glyphShape = gp;
	    }
	    
	    glyphColor = getColorForDataPoint(pcaPoint); 
	    glyph = new XYShapeAnnotation(glyphShape, new BasicStroke(1.0f), Color.BLACK, glyphColor);
        String tooltip = "";   
            if(pcaPoint.getSurvivalInMonths()<=0.0){
    	        tooltip = pcaPoint.getSampleId() + " " + pcaPoint.getDiseaseName();
            }
            else{
               tooltip = pcaPoint.getSampleId() + " " + pcaPoint.getDiseaseName() + " survivalMonths=" + nf.format(pcaPoint.getSurvivalInMonths());
            }
        glyph.setToolTipText(tooltip);
	    plot.addAnnotation(glyph);
	  }
	  
		
	}

	
	/**
	 * Get the color for a PCA data point. The color is determined by the Color by parameter.
	 * @param pcaPoint
	 * @return
	 */
	protected Color getColorForDataPoint(PrincipalComponentAnalysisDataPoint pcaPoint) {
	  Color defaultColor = Color.GRAY;
	  Color retColor = null;
	  
	  if (colorBy == PCAcolorByType.Disease) {
		String diseaseName = pcaPoint.getDiseaseName();
		Color diseaseColor = Color.GRAY;
		if (diseaseName != null) {
		  DiseaseType disease = DiseaseType.valueOf(diseaseName);
		  diseaseColor = disease.getColor();
		}
	    
	    int grade = pcaPoint.getDiseaseGrade();
	    for (int i=0; i < grade-1; i++) {
	      diseaseColor = diseaseColor.brighter();
	    }
	    retColor = diseaseColor;
	  }
	  else if (colorBy == PCAcolorByType.Gender) {
	    GenderType gender = pcaPoint.getGender();
	    
	    if (gender != null) { 
	      retColor = gender.getColor();
	    }

	  }
	  
	  if (retColor == null) {
	    retColor = defaultColor;
	  }
	  
	  return retColor;
	}

	public JFreeChart getChart() { return pcaChart; }
	
	/**
	 * Same interface as ChartUtilities.writeImageMap. This version will find the 
	 * bounding rectangles for the entities in the ChartRenderingInfo object and will write those
	 * to the image map.
	 * @param writer
	 * @param name
	 * @param info
	 * @param useOverlibToolTip
	 */
	public void writeBoundingRectImageMap(PrintWriter writer, String name, ChartRenderingInfo info, boolean useOverlibToolTip) {
	  EntityCollection collection = info.getEntityCollection();
      Collection entities = collection.getEntities();	
		
      Collection<ChartEntity> boundingEntities = getBoundingEntities(entities);
      writeBoundingRectImageMap(writer, name, boundingEntities, useOverlibToolTip);
		
	}
	
	/**
	 * Write the image map for the collection of bounding entities.
	 * @param writer
	 * @param name
	 * @param boundingEntities
	 * @param useOverlibToolTip
	 */
	protected void writeBoundingRectImageMap(PrintWriter writer, String name, Collection<ChartEntity> boundingEntities, boolean useOverlibToolTip) {
	  System.out.println("Num entities=" + boundingEntities.size());
	  StringBuffer sb = new StringBuffer();
      ChartEntity chartEntity;
      String areaTag;

      StandardToolTipTagFragmentGenerator ttg = new StandardToolTipTagFragmentGenerator();
      StandardURLTagFragmentGenerator urlg = new StandardURLTagFragmentGenerator();
      sb.append("<map id=\"" + name + "\" name=\"" + name + "\">");
	  sb.append(StringUtils.getLineSeparator());
      for (Iterator i=boundingEntities.iterator(); i.hasNext(); ) {
       	 chartEntity = (ChartEntity) i.next();
       	 areaTag = chartEntity.getImageMapAreaTag(ttg, urlg).trim();
   	     if (areaTag.length() > 0) {
           sb.append(chartEntity.getImageMapAreaTag(ttg, urlg));
           sb.append(StringUtils.getLineSeparator());
   	     }
      }
      sb.append("</map>");
      writer.println(sb.toString());
	}
	
	/**
	 * Get a collection of entities with the area shape equal to the bounding rectangle
	 * for the shape of original entity. This is necessary because the Javascript for the sample 
	 * selection lasso can only handle rect objects.
	 * @param entities
	 * @return a collection of entities containing the bounding rectangles of the original entities
	 */
	protected Collection<ChartEntity> getBoundingEntities(Collection entities) {
	  ChartEntity entity;
	  ChartEntity boundingEntity;
	  Shape shape;
	  Rectangle2D boundingRect;
	  Collection<ChartEntity> boundingEntities = new ArrayList<ChartEntity>();
	  for (Iterator i=entities.iterator(); i.hasNext(); ) {
	     entity = (ChartEntity) i.next();
	     shape = entity.getArea();
	     boundingRect = shape.getBounds2D();
	     boundingEntity = new ChartEntity(boundingRect, entity.getToolTipText(), entity.getURLText());
	     boundingEntities.add(boundingEntity);
	  }
	  return boundingEntities;
	}
	
	
	/**
	 * Get the range of values for a given clinical factor
	 * @param dataPoints
	 * @param factor
	 * @return
	 */
	protected DataRange getDataRange(Collection<PrincipalComponentAnalysisDataPoint> dataPoints, PCAcomponent component) {
	  double maxValue = Double.MIN_VALUE;
	  double minValue = Double.MAX_VALUE;
	  double value;
	  
	  for (PrincipalComponentAnalysisDataPoint dataPoint:dataPoints) {
		value = dataPoint.getComponentValue(component);
		if (value < minValue) {
		  minValue = value;
		}
		
		if (value > maxValue) {
		  maxValue = value;
		}
	  }
	  
	  DataRange range = new DataRange(minValue, maxValue);
	  return range;
	}
	
	/**
	 * A class for building the legend
	 * @author harrismic
	 *
	 */
	protected class PcaLegendItemSource implements LegendItemSource {

		protected LegendItemCollection items = new LegendItemCollection();
		
		public void addLegendItem(LegendItem item) {
		  items.add(item); 
		}
		
		public LegendItemCollection getLegendItems() {
			return items;
		}
		
	}
}
