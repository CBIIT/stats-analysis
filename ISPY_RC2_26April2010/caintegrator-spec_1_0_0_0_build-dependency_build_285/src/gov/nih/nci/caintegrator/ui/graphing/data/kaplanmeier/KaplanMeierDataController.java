package gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier;

import gov.nih.nci.caintegrator.util.CaIntegratorConstants;

import java.awt.Color;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.log4j.Logger;

/**
 *  
 * This class generates all the Kaplan-Meier Survival plot data sets for 
 * GeneExpression and copy number related data.  It is entirely possible that
 * we will want to eventutally create KM plots based on other data, which will
 * change the Algorithm applied and the legends that are to be displayed
 * 
 * @author BauerD 
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

public class KaplanMeierDataController implements Serializable{


	private static final long serialVersionUID = 1L;

	private KaplanMeierStoredData storedData;
	
	private String geneSymbol;

	private double upFold = 2.0;

	private double downFold = 2.0;

	private static enum Regulation{UPREGULATED, DOWNREGULATED, ALL_SAMPLES, INTERMEDIATE,SAMPLE_LIST1,SAMPLE_LIST2};
	
	private KaplanMeierAlgorithms kaplanMeier = null;

	private Collection<KaplanMeierPlotPointSeriesSet> plotPointSeriesSetCollection;

	private String plotType = CaIntegratorConstants.GENE_EXP_KMPLOT;

	private static Logger logger = Logger.getLogger(KaplanMeierDataController.class);

	private String upLabel;

	private String downLabel;

	public KaplanMeierDataController(double _upFold, double _downFold, String _geneName,
			KaplanMeierSampleInfo[] samples, String plotType) {
		this(_upFold, _downFold, _geneName, samples, plotType, "");
	}
	public KaplanMeierDataController(double _upFold, double _downFold, String _geneName,
			KaplanMeierSampleInfo[] samples, String plotType, String cName) {
		
		String lbl = (cName != null && cName != "") ? cName : "All Samples";
		
		final DecimalFormat decimalFormat = new DecimalFormat("0.0");	
		geneSymbol = _geneName;
		setPlotType(plotType);
		setUpFold(_upFold);
		setDownFold(_downFold);
		if (samples != null) {
			if (plotType != null && plotType.equals(CaIntegratorConstants.GENE_EXP_KMPLOT)) {	
				plotPointSeriesSetCollection = new ArrayList<KaplanMeierPlotPointSeriesSet>();
				kaplanMeier = new KaplanMeierAlgorithms(samples, this.getUpFold(),
						this.getDownFold());
				// All Sample Series
				plotPointSeriesSetCollection.add(getDataSeries(samples, Regulation.ALL_SAMPLES,
						lbl, Color.BLUE));
				// UpRegulated Samples Series
				plotPointSeriesSetCollection.add(getDataSeries(samples, Regulation.UPREGULATED,
						geneSymbol + getUpLabel() + " >= " + decimalFormat.format(upFold) + "X ",Color.RED));
				// Down Regulation Series
				plotPointSeriesSetCollection
						.add(getDataSeries(samples, Regulation.DOWNREGULATED, geneSymbol
								+ getDownLabel() + " >= " + decimalFormat.format(1/downFold)+ "X ",Color.GREEN));
				// intermediate samples
				plotPointSeriesSetCollection.add(getDataSeries(samples, Regulation.INTERMEDIATE,
						geneSymbol + " Intermediate ",Color.ORANGE));
			}
			else if (plotType != null && plotType.equals(CaIntegratorConstants.COPY_NUMBER_KMPLOT)) {	
				plotPointSeriesSetCollection = new ArrayList<KaplanMeierPlotPointSeriesSet>();
				kaplanMeier = new KaplanMeierAlgorithms(samples, this.getUpFold(),
						this.getDownFold());
				// All Sample Series
				plotPointSeriesSetCollection.add(getDataSeries(samples, Regulation.ALL_SAMPLES,
						lbl, Color.BLUE));
				// UpRegulated Samples Series
				plotPointSeriesSetCollection.add(getDataSeries(samples, Regulation.UPREGULATED,
						geneSymbol + getUpLabel() + " >= " + decimalFormat.format(upFold) + " copies ",Color.RED));
				// Down Regulation Series
				plotPointSeriesSetCollection
						.add(getDataSeries(samples, Regulation.DOWNREGULATED, geneSymbol
								+ getDownLabel() + " <= " + decimalFormat.format(downFold) + " copies ",Color.GREEN));
				// intermediate samples
				plotPointSeriesSetCollection.add(getDataSeries(samples, Regulation.INTERMEDIATE,
						geneSymbol + " Intermediate ",Color.ORANGE));
			}
		} else {
			logger.error("gov.nih.nci.nautilus.ui.struts.form.quicksearch.noRecord");
			// throw new exception
		}
		populateStoredData();
	}
	
	public KaplanMeierDataController(KaplanMeierSampleInfo[] sampleList1, KaplanMeierSampleInfo[] sampleList2, String plotType, String group1Name, String group2Name) {
		String g1 = (group1Name!=null && group1Name.length()>0) ? group1Name : "All Samples";
		String g2 = (group2Name!=null && group2Name.length()>0) ? group2Name : "All Samples";
		
		final DecimalFormat decimalFormat = new DecimalFormat("0.0");	
		setPlotType(plotType);
		kaplanMeier = new KaplanMeierAlgorithms(sampleList1, sampleList2);
		if (sampleList1 != null  && sampleList2 != null) {
			if (plotType != null && plotType.equals(CaIntegratorConstants.SAMPLE_KMPLOT)) {	
				plotPointSeriesSetCollection = new ArrayList<KaplanMeierPlotPointSeriesSet>();
				// Sample List of Interest Series
				plotPointSeriesSetCollection.add(getDataSeries(sampleList1, Regulation.SAMPLE_LIST1,
						g1 /*"Samples Of Interest"*/, Color.RED));
				// Sample List of Interest Series
				plotPointSeriesSetCollection.add(getDataSeries(sampleList2, Regulation.SAMPLE_LIST2,
						g2 /*"Rest of Samples"*/, Color.BLUE));	
			}			
		} else {
			logger.error("gov.nih.nci.nautilus.ui.struts.form.quicksearch.noRecord");
			// throw new exception
		}
		populateStoredDataforSamplePlot(g1,g2);

	}
	
	public KaplanMeierDataController(KaplanMeierSampleInfo[] sampleList1, KaplanMeierSampleInfo[] sampleList2, String plotType) {
		this(sampleList1, sampleList2, plotType, "Samples Of Interest", "Rest of the Samples");
	}
	/**
	 * This method will create and ecapsulate all the required stored data 
	 * associated with the Kaplan-Meier plot that we generated
	 *
	 */
	private void populateStoredData() {
		storedData = new KaplanMeierStoredData();
		storedData.setGeneSymbol(this.geneSymbol);
		storedData.setUpFold(upFold);
		storedData.setDownFold(downFold);
		storedData.setDownLabel(getDownLabel());
		storedData.setUpLabel(getUpLabel());
		NumberFormat numberFormatter;
		numberFormatter = NumberFormat.getNumberInstance();
		numberFormatter.setMaximumFractionDigits(5);
		Collection<KaplanMeierSampleInfo> allSamples = kaplanMeier.getAllSamples();
		Collection<KaplanMeierSampleInfo> upSamples = kaplanMeier.getUpSamples();
		Collection<KaplanMeierSampleInfo> downSamples = kaplanMeier.getDownSamples();
		Collection<KaplanMeierSampleInfo> intSamples = kaplanMeier.getIntSamples();
		storedData.setPlotPointSeriesCollection(plotPointSeriesSetCollection);
		storedData.setAllSamples(allSamples);
		storedData.setIntSamples(intSamples);
		storedData.setDownSamples(downSamples);
		storedData.setUpSamples(upSamples);
		storedData.setUpSampleCount(getSampleCount(upSamples));
		storedData.setDownSampleCount(getSampleCount(downSamples));
		storedData.setIntSampleCount(getSampleCount(intSamples));
		storedData.setUpVsDownPvalue(new Double(kaplanMeier.getLogRankPValue(upSamples,downSamples)));
		storedData.setUpVsIntPvalue(new Double(kaplanMeier.getLogRankPValue(upSamples,intSamples)));
		storedData.setDownVsIntPvalue(new Double(kaplanMeier.getLogRankPValue(downSamples,intSamples)));
		storedData.setUpVsRestPvalue(new Double(kaplanMeier.getLogRankPValue(upSamples)));
		storedData.setDownVsRestPvalue(new Double(kaplanMeier.getLogRankPValue(downSamples)));
		storedData.setIntVsRestPvalue(new Double(kaplanMeier.getLogRankPValue(intSamples)));
		storedData.setNumberOfPlots(getNumberOfPlots());
	}
	/**
	 * This method will create and ecapsulate all the required stored data 
	 * associated with the SAMPLE List Kaplan-Meier plot that we generated
	 *
	 */
	private void populateStoredDataforSamplePlot() {
		/*
		storedData = new KaplanMeierStoredData();
		storedData.setSamplePlot1Label("Samples Of Interest");
		storedData.setSamplePlot2Label("Rest of Samples");
		NumberFormat numberFormatter;
		numberFormatter = NumberFormat.getNumberInstance();
		numberFormatter.setMaximumFractionDigits(5);
		Collection<KaplanMeierSampleInfo> sampleList1 = kaplanMeier.getSampleList1();
		Collection<KaplanMeierSampleInfo> sampleList2 = kaplanMeier.getSampleList2();
		storedData.setPlotPointSeriesCollection(plotPointSeriesSetCollection);
		storedData.setSampleList1(sampleList1);
		storedData.setSampleList2(sampleList2);
		storedData.setSampleList1Count(getSampleCount(sampleList1));
		storedData.setSampleList2Count(getSampleCount(sampleList2));
		storedData.setSampleList1VsSampleList2(new Double(kaplanMeier.getLogRankPValue(sampleList1,sampleList2)));
		storedData.setNumberOfPlots(getNumberOfPlots());
		*/
		populateStoredDataforSamplePlot("Samples Of Interest","Rest of Samples" );
	}
	
	private void populateStoredDataforSamplePlot(String g1,String g2)	{
		storedData = new KaplanMeierStoredData();
		storedData.setSamplePlot1Label(g1);
		storedData.setSamplePlot2Label(g2);
		NumberFormat numberFormatter;
		numberFormatter = NumberFormat.getNumberInstance();
		numberFormatter.setMaximumFractionDigits(5);
		Collection<KaplanMeierSampleInfo> sampleList1 = kaplanMeier.getSampleList1();
		Collection<KaplanMeierSampleInfo> sampleList2 = kaplanMeier.getSampleList2();
		storedData.setPlotPointSeriesCollection(plotPointSeriesSetCollection);
		storedData.setSampleList1(sampleList1);
		storedData.setSampleList2(sampleList2);
		storedData.setSampleList1Count(getSampleCount(sampleList1));
		storedData.setSampleList2Count(getSampleCount(sampleList2));
		storedData.setSampleList1VsSampleList2(new Double(kaplanMeier.getLogRankPValue(sampleList1,sampleList2)));
		storedData.setNumberOfPlots(getNumberOfPlots());
	}
	/**********************************
	 * @param container
	 * @param regulated
	 * @param seriesName
	 * @return
	 */
	private KaplanMeierPlotPointSeriesSet getDataSeries(
			KaplanMeierSampleInfo[] KMsampleInfos, Regulation regulation, String seriesName, Color color) {
		ArrayList<KaplanMeierSampleInfo> samples;
		switch (regulation) {
		case ALL_SAMPLES:
			samples = kaplanMeier.getAllSamples();
			break;
		case DOWNREGULATED:
			samples = kaplanMeier.getDownSamples();
			logger.debug(geneSymbol + " Downregulated: " + this.downFold);
			break;
		case UPREGULATED:
			samples = kaplanMeier.getUpSamples();
			logger.debug(geneSymbol + " Upregulated: " + this.upFold);
			break;
		case INTERMEDIATE:
			samples = kaplanMeier.getIntSamples();
			logger.debug(geneSymbol + " Up: <" + this.getUpFold()
					+ "AND Down: >" + this.getDownFold() + " ");
			break;
		case SAMPLE_LIST1:
			samples = kaplanMeier.getSampleList1();
			break;
		case SAMPLE_LIST2:
			samples = kaplanMeier.getSampleList2();
			break;
		default:
			throw new RuntimeException("Invalid Criteria for KM Plot");
		}

		KaplanMeierPlotPoint[] samplePoints = kaplanMeier
				.getDrawingPoints(samples);

		return createSeries(samplePoints, seriesName, samples, color);

	}

	/***************************************************************************
	 * Creates two data series. One of all data points used to create the step
	 * graph, dataSeries. The second contains the census data that will be
	 * overlaid onto the previous step graph to complete the KM Graph,
	 * censusSeries. It takes the KaplanMeierPlotPoints and breaks them into two
	 * sets of XY points based on whether the data point is checked or not. A
	 * checked datapoint shows that it is actually a censor point and should be
	 * placed in the scatter plot.
	 * 
	 * @param dataPoints
	 * @param seriesName
	 * @return
	 */
	private KaplanMeierPlotPointSeriesSet createSeries(
			KaplanMeierPlotPoint[] dataPoints, String seriesName, ArrayList<KaplanMeierSampleInfo> samples, Color color) {

		// Create the DataPoint Series
		KaplanMeierPlotPointSeries dataSeries = new KaplanMeierPlotPointSeries(
				seriesName, true);
		KaplanMeierPlotPointSeries censusSeries = new KaplanMeierPlotPointSeries(
				seriesName + "Censor Points ", true);
		logger.debug(seriesName);

		for (int i = 0; i < dataPoints.length; i++) {
			logger.debug(dataPoints[i]);
			dataSeries.add(dataPoints[i], i);
			if (dataPoints[i].isChecked()) {
				censusSeries.add(dataPoints[i]);
			}
		}
		dataSeries.setDescription(seriesName);
		censusSeries.setDescription(seriesName);

		KaplanMeierPlotPointSeriesSet kmPointSet = new KaplanMeierPlotPointSeriesSet();
		kmPointSet.setColor(color);
		kmPointSet.setName(seriesName);
		kmPointSet.setCensorPlotPoints(censusSeries);
		kmPointSet.setProbabilityPlotPoints(dataSeries);
		kmPointSet.setLegendTitle(seriesName);
		return kmPointSet;
	}

	/**
	 * @return Returns the downFold.
	 */
	public double getDownFold() {
		return this.downFold;
	}

	/**
	 * @param downFold
	 *            The downFold to set.
	 */
	private void setDownFold(double downFold) {
		// set down fold
		if (getPlotType() != null) {
			if (getPlotType().equals(CaIntegratorConstants.GENE_EXP_KMPLOT)) {
				this.downFold = 1 / downFold;
			} else if (getPlotType().equals(
					CaIntegratorConstants.COPY_NUMBER_KMPLOT)) {
				this.downFold = downFold;
			} else {
				this.downFold = downFold;
			}
		}
	}

	/**
	 * @return Returns the upFold.
	 */
	public double getUpFold() {
		return this.upFold;
	}

	/**
	 * @param upFold
	 *            The upFold to set.
	 */
	private void setUpFold(double upFold) {
		this.upFold = upFold;
	}

	public String getPlotType() {
		return plotType;
	}

	private void setPlotType(String plotType) {
		if (plotType != null
				&& plotType.equals(CaIntegratorConstants.GENE_EXP_KMPLOT)
				|| plotType.equals(CaIntegratorConstants.COPY_NUMBER_KMPLOT)) {
			this.plotType = plotType;
		}
	}

	private String getDownLabel() {
		if (plotType != null) {
			if (plotType.equals(CaIntegratorConstants.GENE_EXP_KMPLOT)) {
				downLabel = " Down-Reg.";
			} else if (plotType.equals(CaIntegratorConstants.COPY_NUMBER_KMPLOT)) {
				downLabel = " Deleted";
			}
		}
		return downLabel;
	}

	private String getUpLabel() {
		if (plotType != null) {
			if (plotType.equals(CaIntegratorConstants.GENE_EXP_KMPLOT)) {
				upLabel = " Up-Reg.";
			} else if (plotType.equals(CaIntegratorConstants.COPY_NUMBER_KMPLOT)) {
				upLabel = " Amplified";
			}
		}
		return upLabel;
	}

	private Integer getSampleCount(Collection<KaplanMeierSampleInfo> samples) {
		Integer count = null;
		if (samples != null) {
			count = new Integer(samples.size());
		}
		return count;
	}

	/**
	 * @return
	 */
	private Integer getNumberOfPlots() {
		int count = 0;
		if (kaplanMeier.getDownSamples() != null
				&& kaplanMeier.getDownSamples().size() > 0) {
			count++;
		}
		if (kaplanMeier.getUpSamples() != null
				&& kaplanMeier.getUpSamples().size() > 0) {
			count++;
		}
		if (kaplanMeier.getIntSamples() != null
				&& kaplanMeier.getIntSamples().size() > 0) {
			count++;
		}
		if (kaplanMeier.getSampleList1() != null
				&& kaplanMeier.getSampleList1().size() > 0) {
			count++;
		}
		if (kaplanMeier.getSampleList2() != null
				&& kaplanMeier.getSampleList2().size() > 0) {
			count++;
		}
		return new Integer(count);
	}
	
	/**
	 * @return Returns the read only attribute storedData.
	 */
	public KaplanMeierStoredData getStoredData() {
		return storedData;
	}

}
