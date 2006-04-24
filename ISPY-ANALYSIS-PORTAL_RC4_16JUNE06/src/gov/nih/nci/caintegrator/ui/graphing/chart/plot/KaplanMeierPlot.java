package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier.KaplanMeierPlotPointSeries;
import gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier.KaplanMeierPlotPointSeriesSet;
import gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier.KaplanMeierPlotPointSeries.SeriesType;

import java.awt.Color;
import java.util.Collection;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeriesCollection;
/**
 * The KaplanMeierPlot is a class that will generate a Java2D JFreeChart object
 * with the KaplanMeierPlotPointSeriesSet Collection that is passed to it. The
 * generated plot can then be rendered in a number of ways using the JFreeChart
 * utilities.
 * 
 * The reason for this class is that the Kaplan-Meier survival plot is a mix of 
 * both an XY Line plot and a Scatter plot of different data, and has no 
 * direct representation in the JFreeChart.
 * 
 * @author BauerD
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

public class KaplanMeierPlot{

	private Collection<KaplanMeierPlotPointSeriesSet> kaplanMeierPlotSets;
	private JFreeChart kmChart;
	private XYSeriesCollection finalDataCollection;
	
	public KaplanMeierPlot(Collection<KaplanMeierPlotPointSeriesSet> kmPlotSets) {
		kaplanMeierPlotSets = kmPlotSets;
		finalDataCollection = new XYSeriesCollection();
		/**
		 * Repackage all the datasets to go into the XYSeriesCollection
		 */
		for(KaplanMeierPlotPointSeriesSet dataSet: kaplanMeierPlotSets) {
			finalDataCollection.addSeries(dataSet.getCensorPlotPoints());
			finalDataCollection.addSeries(dataSet.getProbabilityPlotPoints());
		}
		createChart(finalDataCollection);
	}
	
	private void createChart(XYDataset dataset) {
		//Create the chart, dropping in the data set
		JFreeChart chart = ChartFactory.createXYLineChart(
	            "",
	            "Days in Study",
	            "Probability of Survival",
	            dataset,
	            PlotOrientation.VERTICAL,
	            false,//legend
	            true,//tooltips
	            false//urls
	            );
		LegendTitle legend = chart.getLegend();
		XYPlot plot = (XYPlot) chart.getPlot();
	    /********************************************************
	     * IMPORTANT:
	     * Ideally I would create the actual Renderer settings for
	     * the at the time I start to march through the 
	     * KaplanMeierPlotPointSeriesSets, adding them to the actual
	     * Data Set that is going to be going into the Chart plotter.
	     * But you have no idea how they are going to be sitting in
	     * the Plot dataset so there is no guarantee that setting the
	     * renderer based on a supposed index will actually work. In fact
	     * it didn't work when I wrote this.
	     * 
	     */
		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
		for(int i = 0; i < finalDataCollection.getSeriesCount();i++) {
			KaplanMeierPlotPointSeries kmSeries = (KaplanMeierPlotPointSeries)finalDataCollection.getSeries(i);
			if(kmSeries.getType() == SeriesType.CENSOR) {
				renderer.setSeriesLinesVisible(i, false);
		        renderer.setSeriesShapesVisible(i, true);
		    }else if(kmSeries.getType()==SeriesType.PROBABILITY){
		    	renderer.setSeriesLinesVisible(i, true);
		        renderer.setSeriesShapesVisible(i, false);
		        
			}else {
				//don't show this set as it is not a known type
				renderer.setSeriesLinesVisible(i, false);
		        renderer.setSeriesShapesVisible(i, false);
			}
			renderer.setSeriesPaint(i, getKMSetColor(kmSeries.getKey(), kmSeries.getType()),true);
		}
	
		renderer.setToolTipGenerator(new StandardXYToolTipGenerator());
        renderer.setDefaultEntityRadius(6);
        plot.setRenderer(renderer);
        //change the auto tick unit selection to integer units only...
		NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
		rangeAxis.setStandardTickUnits(NumberAxis.createStandardTickUnits());
		// OPTIONAL CUSTOMISATION COMPLETED.
		rangeAxis.setAutoRange(true);
		rangeAxis.setRange(0.0,1.0);
		kmChart=chart;
	}

	/**
	 * @return Returns the kmChart.
	 */
	public JFreeChart getKmChart() {
		return kmChart;
	}
	
	private Color getKMSetColor(Comparable setKey, SeriesType type) {
		for(KaplanMeierPlotPointSeriesSet seriesSet: kaplanMeierPlotSets) {
			 if(seriesSet.getHashKey() == setKey ) {
				 return seriesSet.getColor();
			 }
		}
		//If nothing was found that matched return Color.BLACK
		return Color.BLACK;
	}
}
