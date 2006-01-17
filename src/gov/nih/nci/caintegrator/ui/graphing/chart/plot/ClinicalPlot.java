package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import gov.nih.nci.caintegrator.enumeration.ClinicalFactorType;
import gov.nih.nci.caintegrator.enumeration.DiseaseType;
import gov.nih.nci.caintegrator.ui.graphing.data.DataRange;
import gov.nih.nci.caintegrator.ui.graphing.data.clinical.ClinicalDataPoint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.Collection;
import java.util.Iterator;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;



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

public class ClinicalPlot {
	
	private JFreeChart clinicalChart = null;
	private ClinicalFactorType factor1;
	private ClinicalFactorType factor2;
	private String factor1AxisLabel;
	private String factor2AxisLabel;
	private Collection<ClinicalDataPoint> dataPoints;
	private NumberFormat nf = NumberFormat.getNumberInstance();
	
	//private Map diseaseColorMap = new HashMap();

	public ClinicalPlot(Collection<ClinicalDataPoint> clinicalData, gov.nih.nci.caintegrator.enumeration.ClinicalFactorType factor1, String factor1AxisLabel, gov.nih.nci.caintegrator.enumeration.ClinicalFactorType factor2, String factor2AxisLabel) {
	  this.factor1 = factor1;
	  this.factor2 = factor2;
	  this.dataPoints = clinicalData;
	  this.nf.setMaximumFractionDigits(1);
	  this.factor1AxisLabel = factor1AxisLabel;
	  this.factor2AxisLabel = factor2AxisLabel;
	  
	  createChart();	  
	}
	public JFreeChart getChart() { return clinicalChart; }

	
	private void createChart() {
		
		//String xLabel = factor1.toString();
		String xLabel = factor1AxisLabel;
		//String yLabel = factor2.toString();
		String yLabel = factor2AxisLabel;
			
		clinicalChart = ChartFactory.createScatterPlot("Clinical Plot",xLabel, yLabel, null,  PlotOrientation.VERTICAL,
	            true, 
	            true, 
	            false );
		
		XYPlot plot = (XYPlot) clinicalChart.getPlot();
		
		buildLegend();
		
	    plot.setNoDataMessage(null);
	    XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) plot.getRenderer();
	    renderer.setToolTipGenerator(new StandardXYToolTipGenerator());
	    renderer.setUseOutlinePaint(true);
        plot.setRangeCrosshairVisible(false);
	    plot.setDomainCrosshairVisible(false);
	   
	       	        
        NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
        NumberAxis rangeAxis  =	(NumberAxis) plot.getRangeAxis();
        
        //should determine axis range using datapoints.
        
        domainAxis.setAutoRangeIncludesZero(false);
        
        //get domain and range of the axis.
        DataRange domainAxisLimits = getDataRange(dataPoints, factor1, true);
        DataRange rangeAxisLimits = getDataRange(dataPoints, factor2,  true);
        
        
        //domainAxis.setRange(domainAxisLimits.getMinRange(), domainAxisLimits.getMaxRange());
        //rangeAxis.setRange(rangeAxisLimits.getMinRange(), rangeAxisLimits.getMaxRange());
        
        double domainMax = Math.max(100.0, domainAxisLimits.getMaxRange())+5.0;
        double rangeMax = Math.max(100.0, rangeAxisLimits.getMaxRange())+5.0;
        
        domainAxis.setRange(0.0,domainMax);
        rangeAxis.setRange(0.0,rangeMax);
     
        System.out.println("domainAxis=" + domainAxis.getLabel());
        System.out.println("rangeAxis=" + rangeAxis.getLabel());
         
	    createGlyphsAndAddToPlot(plot);     
	}
	
	/**
	 * Get the range of values for a given clinical factor
	 * @param dataPoints
	 * @param factor
	 * @return
	 */
	private DataRange getDataRange(Collection<ClinicalDataPoint> dataPoints2, gov.nih.nci.caintegrator.enumeration.ClinicalFactorType factor, boolean onlyIncludePositveValues) {
	  double maxValue = Double.MIN_VALUE;
	  double minValue = Double.MAX_VALUE;
	  double value;
	  ClinicalDataPoint dataPoint;
	  for (Iterator i=dataPoints.iterator(); i.hasNext(); ) {
		dataPoint = (ClinicalDataPoint)i.next();
		value = dataPoint.getFactorValue(factor);
		if ((value < minValue)&&(value >= 0)) {
		  minValue = value;
		}
		
		if ((value > maxValue)&&(value >= 0)) {
		  maxValue = value;
		}
	  }
	  
	  DataRange range = new DataRange(minValue, maxValue);
	  return range;
	}
	
	private void createGlyphsAndAddToPlot(XYPlot plot) {
	  XYShapeAnnotation glyph;
	  Shape glyphShape;
	  Color glyphColor;
	  
	  ClinicalDataPoint clinicalPoint;
	  String survivalLenStr;
	  double x, y;
	  for (Iterator i=dataPoints.iterator(); i.hasNext(); ) {
	    clinicalPoint = (ClinicalDataPoint) i.next();
	    
	    x = clinicalPoint.getFactorValue(factor1);
	    y = clinicalPoint.getFactorValue(factor2);
	    
	    if ((x!= ClinicalDataPoint.MISSING_CLINICAL_FACTOR_VALUE) && 
	        (y!= ClinicalDataPoint.MISSING_CLINICAL_FACTOR_VALUE)) {
	    
	    	//Make this a triangle
	    	 GeneralPath gp = new GeneralPath();
		     float xf = (float)x;
		     float yf = (float)y;
		      //make a triangle
		      gp.moveTo(xf,yf);
		      gp.lineTo(xf+1.5f,yf-1.5f);
		      gp.lineTo(xf-1.5f,yf-1.5f);
		      gp.closePath();
		      glyphShape = gp;
	    	
	    	//Rectangle2D.Double rect = new Rectangle2D.Double();
		    //rect.setFrameFromCenter(x,y, x+1,y+1);
		    //glyphShape = rect;
		    glyphColor = getColorForDataPoint(clinicalPoint); 
		    glyph = new XYShapeAnnotation(glyphShape, new BasicStroke(1.0f), Color.BLACK, glyphColor);
		    
		    if (clinicalPoint.getSurvivalInMonths() >= 0.0) {
		      survivalLenStr = nf.format(clinicalPoint.getSurvivalInMonths());
		    }
		    else {
		      survivalLenStr = "";
		    }
		    
		    String tooltip = clinicalPoint.getPatientId() + " " + clinicalPoint.getDiseaseName() + " survivalMonths=" + survivalLenStr;
		    glyph.setToolTipText(tooltip);
		    plot.addAnnotation(glyph);
	    }  
	  }
		
	}
	
	private Color getColorForDataPoint(ClinicalDataPoint clinicalPoint) {
        
	  String diseaseName = clinicalPoint.getDiseaseName();
	  Color diseaseColor = Color.GRAY;
	  Color defaultColor = Color.GRAY;
	  Color retColor = Color.GRAY;
	  
	  if (diseaseName != null) {
	    DiseaseType disease = DiseaseType.valueOf(diseaseName);
	    diseaseColor = disease.getColor();
	  }
	    
	  int grade = clinicalPoint.getDiseaseGrade();
	  if (grade > 0) {
	    for (int i=0; i < grade-1; i++) {
	      diseaseColor = diseaseColor.brighter();
	    }
	  }
	  retColor = diseaseColor;
	  
	  	    
	  if (retColor == null) {
	    retColor = defaultColor;
	  }
		  
	  return retColor;
	}
	
	/**
	 * Build the legend
	 *
	 */
	private void buildLegend() {
	
	  LegendTitle legend = clinicalChart.getLegend();
	  LegendItemSource[] sources = new LegendItemSource[1];
	  ClinicalLegendItemSource legendSrc = new ClinicalLegendItemSource();
	  LegendItem item = null;
	       
      //go through the disease color map and add legend items
      String diseaseName = null;
	  Color diseaseColor = null;
	  DiseaseType[] diseases = DiseaseType.values();
	  for (int i=0; i < diseases.length; i++ ) {
	    diseaseName = diseases[i].name();
	    diseaseColor = diseases[i].getColor();
	    item = new LegendItem(diseaseName, null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), diseaseColor);	 
	    legendSrc.addLegendItem(item);
	  }
      
//      for (Iterator i=diseaseColorMap.keySet().iterator(); i.hasNext(); ) {
//	    diseaseName = (String) i.next();
//	    diseaseColor = (Color) diseaseColorMap.get(diseaseName);
//	    item = new LegendItem(diseaseName, null, null, null, new Line2D.Double(0,0,6,6), new BasicStroke(3.0f), diseaseColor);
//	    //item = new LegendItem(diseaseName, null, null, null, new Rectangle2D.Double(0,0,6,6), diseaseColor);
//	    legendSrc.addLegendItem(item);
//	  }
		    
	  sources[0] = legendSrc;
	  legend.setSources(sources);
	}
	
	/**
	 * A class for building the legend
	 * @author harrismic
	 *
	 */
	private class ClinicalLegendItemSource implements LegendItemSource {

		private LegendItemCollection items = new LegendItemCollection();
		
		public void addLegendItem(LegendItem item) {
		  items.add(item); 
		}
		
		public LegendItemCollection getLegendItems() {
			return items;
		}
		
	}
	
}
