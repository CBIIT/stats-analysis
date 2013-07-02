/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier;


import gov.nih.nci.caintegrator.ui.graphing.data.CachableGraphData;

import java.text.DecimalFormat;
import java.util.Collection;

/**
 * The purpose of this class is to maintain and hold relevant stored
 * data related to the execution of a Kaplan-Meier Plot
 * 
 * @author BauerD
 *
 */


/**
* 
* 
*/

public class KaplanMeierStoredData implements CachableGraphData{
	private static final long serialVersionUID = 1L;

	private Double upVsRestPvalue = null;
    
	private Double downVsRestPvalue = null;
   
    private Double intVsRestPvalue = null;
   	
	private String geneSymbol;

	private double upFold = 2.0;

	private double downFold = 2.0;

	private String chartTitle = null;

	private Double upVsDownPvalue = null;
	
	private Double sampleList1VsSampleList2 = null;

	private Double upVsIntPvalue = null;

	private Double downVsIntPvalue = null;

	private Double upVsRest = null;

	private Double downVsRest = null;

	private Double intVsRest = null;

	private Integer upSampleCount = new Integer(0);

	private Integer downSampleCount = new Integer(0);

	private Integer intSampleCount = new Integer(0);

	private Integer allSampleCount = new Integer(0);
	
	private Integer sampleList1Count = new Integer(0);
	
	private Integer sampleList2Count = new Integer(0);

	private Collection<KaplanMeierSampleInfo> allSamples;

	private Collection<KaplanMeierSampleInfo> upSamples;

	private Collection<KaplanMeierSampleInfo> downSamples;

	private Collection<KaplanMeierSampleInfo> intSamples;
	
	private Collection<KaplanMeierSampleInfo> sampleList1;
	
	private Collection<KaplanMeierSampleInfo> sampleList2;
	
	private Integer numberOfPlots;

	private Collection<KaplanMeierPlotPointSeriesSet> plotPointSeriesCollection;

	private String downLabel;

	private String upLabel;
	
	private String samplePlot1Label;
	
	private String samplePlot2Label;

	private String id;
     
    private DecimalFormat resultFormat = new DecimalFormat("0.0000000000");


	/**
	 * @return Returns the chartTitle.
	 */
	public String getChartTitle() {
		return chartTitle;
	}

	/**
	 * @param chartTitle The chartTitle to set.
	 */
	public void setChartTitle(String chartTitle) {
		this.chartTitle = chartTitle;
	}

	/**
	 * @return Returns the downFold.
	 */
	public double getDownFold() {
		return downFold;
	}

	/**
	 * @param downFold The downFold to set.
	 */
	public void setDownFold(double downFold) {
		this.downFold = downFold;
	}

	/**
	 * @return Returns the downSampleCount.
	 */
	public Integer getDownSampleCount() {
		return downSampleCount;
	}

	/**
	 * @param downSampleCount The downSampleCount to set.
	 */
	public void setDownSampleCount(Integer downSampleCount) {
		this.downSampleCount = downSampleCount;
	}

	/**
	 * @return Returns the downVsIntPvalue.
	 */
	public Double getDownVsIntPvalue() {
		return downVsIntPvalue;
	}

	/**
	 * @param downVsIntPvalue The downVsIntPvalue to set.
	 */
	public void setDownVsIntPvalue(Double downVsIntPvalue) {
		this.downVsIntPvalue = new Double(resultFormat.format(downVsIntPvalue));
	}

	/**
	 * @return Returns the downVsRest.
	 */
	public Double getDownVsRest() {
		return downVsRest;
	}

	/**
	 * @param downVsRest The downVsRest to set.
	 */
	public void setDownVsRest(Double downVsRest) {
		this.downVsRest = new Double(resultFormat.format(downVsRest));
	}

	/**
	 * @return Returns the geneSymbol.
	 */
	public String getGeneSymbol() {
		return geneSymbol;
	}

	/**
	 * @param geneSymbol The geneSymbol to set.
	 */
	public void setGeneSymbol(String geneSymbol) {
		this.geneSymbol = geneSymbol;
	}

	/**
	 * @return Returns the intSampleCount.
	 */
	public Integer getIntSampleCount() {
		return intSampleCount;
	}

	/**
	 * @param intSampleCount The intSampleCount to set.
	 */
	public void setIntSampleCount(Integer intSampleCount) {
		this.intSampleCount = intSampleCount;
	}

	/**
	 * @return Returns the intVsRest.
	 */
	public Double getIntVsRest() {
		return intVsRest;
	}

	/**
	 * @param intVsRest The intVsRest to set.
	 */
	public void setIntVsRest(Double intVsRest) {
		this.intVsRest = new Double(resultFormat.format(intVsRest));
	}

	/**
	 * @return Returns the upFold.
	 */
	public double getUpFold() {
		return upFold;
	}

	/**
	 * @param upFold The upFold to set.
	 */
	public void setUpFold(double upFold) {
		this.upFold = upFold;
	}

	/**
	 * @return Returns the upSampleCount.
	 */
	public Integer getUpSampleCount() {
		return upSampleCount;
	}

	/**
	 * @param upSampleCount The upSampleCount to set.
	 */
	public void setUpSampleCount(Integer upSampleCount) {
		this.upSampleCount = upSampleCount;
	}

	/**
	 * @return Returns the upVsDownPvalue.
	 */
	public Double getUpVsDownPvalue() {
		return upVsDownPvalue;
	}

	/**
	 * @param upVsDownPvalue The upVsDownPvalue to set.
	 */
	public void setUpVsDownPvalue(Double upVsDownPvalue) {
		this.upVsDownPvalue = new Double(resultFormat.format(upVsDownPvalue));
	}

	/**
	 * @return Returns the upVsIntPvalue.
	 */
	public Double getUpVsIntPvalue() {
		return upVsIntPvalue;
	}

	/**
	 * @param upVsIntPvalue The upVsIntPvalue to set.
	 */
	public void setUpVsIntPvalue(Double upVsIntPvalue) {
		this.upVsIntPvalue = new Double(resultFormat.format(upVsIntPvalue));        
	}

	/**
	 * @return Returns the upVsRest.
	 */
	public Double getUpVsRest() {
		return upVsRest;
	}

	/**
	 * @param upVsRest The upVsRest to set.
	 */
	public void setUpVsRest(Double upVsRest) {
		this.upVsRest = new Double(resultFormat.format(upVsRest));
	}
	

	public void setIntSamples(Collection<KaplanMeierSampleInfo> intSamples) {
		this.intSamples = intSamples;
		
	}

	public void setDownSamples(Collection<KaplanMeierSampleInfo> downSamples) {
		this.downSamples = downSamples;
		
	}

	public void setUpSamples(Collection<KaplanMeierSampleInfo> upSamples) {
		this.upSamples = upSamples;
		
	}
	
	public void setAllSamples(Collection<KaplanMeierSampleInfo> allSamples) {
		this.allSamples = allSamples;
		
	}

	/**
	 * @return Returns the allSampleCount.
	 */
	public Integer getAllSampleCount() {
		return allSampleCount;
	}

	/**
	 * @param allSampleCount The allSampleCount to set.
	 */
	public void setAllSampleCount(Integer allSampleCount) {
		this.allSampleCount = allSampleCount;
	}

	/**
	 * @return Returns the downVsRestPvalue.
	 */
	public Double getDownVsRestPvalue() {
		return downVsRestPvalue;
	}

	/**
	 * @param downVsRestPvalue The downVsRestPvalue to set.
	 */
	public void setDownVsRestPvalue(Double downVsRestPvalue) {
		this.downVsRestPvalue = new Double(resultFormat.format(downVsRestPvalue));
	}

	/**
	 * @return Returns the intVsRestPvalue.
	 */
	public Double getIntVsRestPvalue() {
		return intVsRestPvalue;
	}

	/**
	 * @param intVsRestPvalue The intVsRestPvalue to set.
	 */
	public void setIntVsRestPvalue(Double intVsRestPvalue) {
		this.intVsRestPvalue = new Double(resultFormat.format(intVsRestPvalue));
	}

	/**
	 * @return Returns the upVsRestPvalue.
	 */
	public Double getUpVsRestPvalue() {
		return upVsRestPvalue;
	}

	/**
	 * @param upVsRestPvalue The upVsRestPvalue to set.
	 */
	public void setUpVsRestPvalue(Double upVsRestPvalue) {
		this.upVsRestPvalue = new Double(resultFormat.format(upVsRestPvalue));
	}

	/**
	 * @return Returns the allSamples.
	 */
	public Collection<KaplanMeierSampleInfo> getAllSamples() {
		return allSamples;
	}

	/**
	 * @return Returns the downSamples.
	 */
	public Collection<KaplanMeierSampleInfo> getDownSamples() {
		return downSamples;
	}

	/**
	 * @return Returns the intSamples.
	 */
	public Collection<KaplanMeierSampleInfo> getIntSamples() {
		return intSamples;
	}

	/**
	 * @return Returns the upSamples.
	 */
	public Collection<KaplanMeierSampleInfo> getUpSamples() {
		return upSamples;
	}

	/**
	 * @return Returns the numberOfPlots.
	 */
	public Integer getNumberOfPlots() {
		return numberOfPlots;
	}

	/**
	 * @param numberOfPlots The numberOfPlots to set.
	 */
	public void setNumberOfPlots(Integer numberOfPlots) {
		this.numberOfPlots = numberOfPlots;
	}

	public void setPlotPointSeriesCollection(Collection<KaplanMeierPlotPointSeriesSet> plotPointSeriesSetCollection) {
		this.plotPointSeriesCollection = plotPointSeriesSetCollection;
		
	}

	public void setDownLabel(String downLabel) {
		this.downLabel = downLabel;				
	}
	
	public void setUpLabel(String upLabel) {
		this.upLabel = upLabel;
	}

	/**
	 * @return Returns the downLabel.
	 */
	public String getDownLabel() {
		return downLabel;
	}

	/**
	 * @return Returns the plotPointSeriesCollection.
	 */
	public Collection<KaplanMeierPlotPointSeriesSet> getPlotPointSeriesCollection() {
		return plotPointSeriesCollection;
	}

	/**
	 * @return Returns the upLabel.
	 */
	public String getUpLabel() {
		return upLabel;
	}

	public void setId(String id) {
		this.id = id;
		
	}

	public Object getDataset() {
		return getPlotPointSeriesCollection();
	}

	public String getId() {
		return id;
	}

	/**
	 * @return Returns the sampleList1Count.
	 */
	public Integer getSampleList1Count() {
		return sampleList1Count;
	}

	/**
	 * @param sampleList1Count The sampleList1Count to set.
	 */
	public void setSampleList1Count(Integer sampleList1Count) {
		this.sampleList1Count = sampleList1Count;
	}

	/**
	 * @return Returns the sampleList1VsSampleList2.
	 */
	public Double getSampleList1VsSampleList2() {
		return sampleList1VsSampleList2;
	}

	/**
	 * @param sampleList1VsSampleList2 The sampleList1VsSampleList2 to set.
	 */
	public void setSampleList1VsSampleList2(Double sampleList1VsSampleList2) {
		this.sampleList1VsSampleList2 = new Double(resultFormat.format(sampleList1VsSampleList2));
	}

	/**
	 * @return Returns the sampleList2Count.
	 */
	public Integer getSampleList2Count() {
		return sampleList2Count;
	}

	/**
	 * @param sampleList2Count The sampleList2Count to set.
	 */
	public void setSampleList2Count(Integer sampleList2Count) {
		this.sampleList2Count = sampleList2Count;
	}

	/**
	 * @return Returns the samplePlot1Label.
	 */
	public String getSamplePlot1Label() {
		return samplePlot1Label;
	}

	/**
	 * @param samplePlot1Label The samplePlot1Label to set.
	 */
	public void setSamplePlot1Label(String samplePlot1Label) {
		this.samplePlot1Label = samplePlot1Label;
	}

	/**
	 * @return Returns the samplePlot2Label.
	 */
	public String getSamplePlot2Label() {
		return samplePlot2Label;
	}

	/**
	 * @param samplePlot2Label The samplePlot2Label to set.
	 */
	public void setSamplePlot2Label(String samplePlot2Label) {
		this.samplePlot2Label = samplePlot2Label;
	}

	/**
	 * @return Returns the sampleList1.
	 */
	public Collection<KaplanMeierSampleInfo> getSampleList1() {
		return sampleList1;
	}

	/**
	 * @param sampleList1 The sampleList1 to set.
	 */
	public void setSampleList1(Collection<KaplanMeierSampleInfo> sampleList1) {
		this.sampleList1 = sampleList1;
	}

	/**
	 * @return Returns the sampleList2.
	 */
	public Collection<KaplanMeierSampleInfo> getSampleList2() {
		return sampleList2;
	}

	/**
	 * @param sampleList2 The sampleList2 to set.
	 */
	public void setSampleList2(Collection<KaplanMeierSampleInfo> sampleList2) {
		this.sampleList2 = sampleList2;
	}
}
