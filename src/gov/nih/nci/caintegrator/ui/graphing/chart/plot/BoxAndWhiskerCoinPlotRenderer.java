/**
 * 
 */
package gov.nih.nci.caintegrator.ui.graphing.chart.plot;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotRenderingInfo;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;
import org.jfree.chart.renderer.OutlierListCollection;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.io.SerialUtilities;
import org.jfree.ui.RectangleEdge;
import org.jfree.util.PaintUtilities;

/**
 * A box-and-whisker renderer.
 */
/**
 * @author sahnih
 *
 */
public class BoxAndWhiskerCoinPlotRenderer extends BoxAndWhiskerRenderer {
    

	private static final long serialVersionUID = 1L;

    
    /** caIntegrator extension: 
     * to limit the width of the bar. 
     * Used in method initialise()
     * A constant to limit the width of a bar.
     */
    private double maxBarWidth = 40.00 ;
    
    /** caIntegrator extension: 
     *  Get the data for a given row/column pair for plotting.
     */

    private HashMap<String, List> caIntegatorCoinList;
    
    /** caIntegrator extension: 
     *  Allow option to plot or not plot the mean line on the plot
     *  default is display Median
     */
    private boolean displayMean = true;
    
    /** caIntegrator extension: 
     *  Allow option to plot the median circle on the plot
     *  default is display Mean
     */
    private boolean displayMedian = true;

    /** caIntegrator extension: 
     *  Allow option to plot outliers without averaging or considering them farouts
     *  default is to plot ouliers as standard JFree Implemetation
     */
    private boolean displayAllOutliers = false;

    /** caIntegrator extension: 
     *  Allow option to plot all values as coins on the plot
     *  default is NOt is plot the coin cloud
     */
    private boolean displayCoinCloud = false;
    
    /**
	 * value of the denominator to calculate the radious of the outlier circle.
	 * default 3
	 * usually 10 used for coin plots
	 */
    private int outlierRadiusDenominator = 3;
    
    /**
     * set default plot color
     */
    
    String plotColor = null;
    
    /**
     * Default constructor.
     */
    public BoxAndWhiskerCoinPlotRenderer() {
    	super();
        this.setFillBox(false);
    }
    public BoxAndWhiskerCoinPlotRenderer(HashMap<String, List> yOutliers) {
    	super();
    	this.caIntegatorCoinList = yOutliers;
        this.setFillBox(false);
        outlierRadiusDenominator = 8;
        plotColor = "black";
        
    }
    /**
     * Initialises the renderer.  This method gets called once at the start of 
     * the process of drawing a chart.
     *
     * @param g2  the graphics device.
     * @param dataArea  the area in which the data is to be plotted.
     * @param plot  the plot.
     * @param rendererIndex  the renderer index.
     * @param info  collects chart rendering information for return to caller.
     *
     * @return The renderer state.
     */
    public CategoryItemRendererState initialise(Graphics2D g2,
                                                Rectangle2D dataArea,
                                                CategoryPlot plot,
                                                int rendererIndex,
                                                PlotRenderingInfo info) {

        CategoryItemRendererState state = super.initialise(
            g2, dataArea, plot, rendererIndex, info
        );

             
       if (state.getBarWidth() > maxBarWidth)
        	state.setBarWidth(maxBarWidth);
        return state;

    }
    /**
     * Draws the visual representation of a single data item when the plot has 
     * a vertical orientation.
     *
     * @param g2  the graphics device.
     * @param state  the renderer state.
     * @param dataArea  the area within which the plot is being drawn.
     * @param plot  the plot (can be used to obtain standard color information 
     *              etc).
     * @param domainAxis  the domain axis.
     * @param rangeAxis  the range axis.
     * @param dataset  the dataset.
     * @param row  the row index (zero-based).
     * @param column  the column index (zero-based).
     */
    public void drawVerticalItem(Graphics2D g2, 
                                 CategoryItemRendererState state,
                                 Rectangle2D dataArea,
                                 CategoryPlot plot, 
                                 CategoryAxis domainAxis, 
                                 ValueAxis rangeAxis,
                                 CategoryDataset dataset, 
                                 int row, 
                                 int column) {

        BoxAndWhiskerCategoryDataset bawDataset 
            = (BoxAndWhiskerCategoryDataset) dataset;
        
        double categoryEnd = domainAxis.getCategoryEnd(
            column, getColumnCount(), dataArea, plot.getDomainAxisEdge()
        );
        double categoryStart = domainAxis.getCategoryStart(
            column, getColumnCount(), dataArea, plot.getDomainAxisEdge()
        );
        double categoryWidth = categoryEnd - categoryStart;

        double xx = categoryStart;
        int seriesCount = getRowCount();
        int categoryCount = getColumnCount();

        if (seriesCount > 1) {
            double seriesGap = dataArea.getWidth() * getItemMargin() 
                               / (categoryCount * (seriesCount - 1));
            double usedWidth = (state.getBarWidth() * seriesCount) 
                               + (seriesGap * (seriesCount - 1));
            // offset the start of the boxes if the total width used is smaller
            // than the category width
            double offset = (categoryWidth - usedWidth) / 2;
            xx = xx + offset + (row * (state.getBarWidth() + seriesGap));
        } 
        else {
            // offset the start of the box if the box width is smaller than the 
            // category width
            double offset = (categoryWidth - state.getBarWidth()) / 2;
            xx = xx + offset;
        } 
        
        double yyAverage = 0.0;
        double yyOutlier;

//      bar colors are determined by the Paint p obtained here in a rotational
		//manner (from a Color array).  By switching the column and raw values,
		//you can get a different color pattern for the bar:  In the method 
		//getItemPaint(), only the first argument counts for the color. The original
		//code Paint p = getItemPaint(row, column); is commented out for a difference.
        Paint p = null;
        if(this.getPlotColor() != null){
          	 p = PaintUtilities.stringToColor(getPlotColor()); // coin plot should all be one color
          }
        else{
        	 p = getItemPaint(row, column);
         }
        
       // Paint p = PaintUtilities.stringToColor("red"); 
        if (p != null) {
            g2.setPaint(p);
        }
  

       
        Stroke s = getItemStroke(row, column);
        g2.setStroke(s);


        double aRadius = 0;                 // average radius

        RectangleEdge location = plot.getRangeAxisEdge();

        Number yQ1 = bawDataset.getQ1Value(row, column);
        Number yQ3 = bawDataset.getQ3Value(row, column);
        Number yMax = bawDataset.getMaxRegularValue(row, column);
        Number yMin = bawDataset.getMinRegularValue(row, column);
        Shape box = null;
        if (yQ1 != null && yQ3 != null && yMax != null && yMin != null) {

            double yyQ1 = rangeAxis.valueToJava2D(
                yQ1.doubleValue(), dataArea, location
            );
            double yyQ3 = rangeAxis.valueToJava2D(
                yQ3.doubleValue(), dataArea, location
            );
            double yyMax = rangeAxis.valueToJava2D(
                yMax.doubleValue(), dataArea, location
            );
            double yyMin = rangeAxis.valueToJava2D(
                yMin.doubleValue(), dataArea, location
            );
            double xxmid = xx + state.getBarWidth() / 2.0;
            
            // draw the upper shadow...
            g2.draw(new Line2D.Double(xxmid, yyMax, xxmid, yyQ3));
            g2.draw(
                new Line2D.Double(xx, yyMax, xx + state.getBarWidth(), yyMax)
            );

            // draw the lower shadow...
            g2.draw(new Line2D.Double(xxmid, yyMin, xxmid, yyQ1));
            g2.draw(
                new Line2D.Double(xx, yyMin, xx + state.getBarWidth(), yyMin)
            );

            // draw the body...
            box = new Rectangle2D.Double(
                xx, Math.min(yyQ1, yyQ3), state.getBarWidth(), 
                Math.abs(yyQ1 - yyQ3)
            );
            if (getFillBox()) {
                g2.fill(box);
            }
            g2.draw(box);
  
        }
        
        g2.setPaint(getArtifactPaint());

        if(this.isDisplayMean()){
        	// draw mean - SPECIAL AIMS REQUIREMENT...
	        Number yMean = bawDataset.getMeanValue(row, column);
	        if (yMean != null) {
	            yyAverage = rangeAxis.valueToJava2D(
	                yMean.doubleValue(), dataArea, location
	            );
	            aRadius = state.getBarWidth() / 4;
	            Ellipse2D.Double avgEllipse = new Ellipse2D.Double(
	                xx + aRadius, yyAverage - aRadius, aRadius * 2, aRadius * 2
	            );
	            g2.fill(avgEllipse);
	            g2.draw(avgEllipse);
	        }
        }

        if(this.isDisplayMedian()){
        // draw median...
	        Number yMedian = bawDataset.getMedianValue(row, column);
	        if (yMedian != null) {
	            double yyMedian = rangeAxis.valueToJava2D(
	                yMedian.doubleValue(), dataArea, location
	            );
	            g2.draw(
	                new Line2D.Double(
	                    xx, yyMedian, xx + state.getBarWidth(), yyMedian
	                )
	            );
	        }
        }
        
        // draw yOutliers...
        double maxAxisValue = rangeAxis.valueToJava2D(
            rangeAxis.getUpperBound(), dataArea, location
        ) + aRadius;
        double minAxisValue = rangeAxis.valueToJava2D(
            rangeAxis.getLowerBound(), dataArea, location
        ) - aRadius;

        g2.setPaint(p);
        
        
        if(this.isDisplayCoinCloud()){
	        //draw coin clouds
	        drawCoinCloud( g2, state, dataArea, location, rangeAxis, xx, row, column);
        }
		//caIntegrator: oRadius is the radius of the outlier circles. It was used to be 3.
        // draw outliers
        double oRadius = state.getBarWidth() / this.outlierRadiusDenominator;    // outlier radius
        List outliers = new ArrayList();
        OutlierListCollection outlierListCollection 
            = new OutlierListCollection();

       	List yOutliers = bawDataset.getOutliers(row, column);
        if (yOutliers != null) {
            for (int i = 0; i < yOutliers.size(); i++) {
                double outlier = ((Number) yOutliers.get(i)).doubleValue();
                Number minOutlier = bawDataset.getMinOutlier(row, column);
                Number maxOutlier = bawDataset.getMaxOutlier(row, column);
                Number minRegular = bawDataset.getMinRegularValue(row, column);
                Number maxRegular = bawDataset.getMaxRegularValue(row, column);
	                if (outlier > maxOutlier.doubleValue()) {
	                    outlierListCollection.setHighFarOut(true);
	                } 
	                else if (outlier < minOutlier.doubleValue()) {
	                    outlierListCollection.setLowFarOut(true);
	                }
	                else if (outlier > maxRegular.doubleValue()) {
	                    yyOutlier = rangeAxis.valueToJava2D(
	                        outlier, dataArea, location
	                    );
	                    outliers.add(
	                        new Outlier(
	                            xx + state.getBarWidth() / 2.0, yyOutlier, oRadius
	                        )
	                    );
	                }
	                else if (outlier < minRegular.doubleValue() ) {
	                    yyOutlier = rangeAxis.valueToJava2D(
	                        outlier, dataArea, location
	                    );
	                    outliers.add(
	                        new Outlier(
	                            xx + state.getBarWidth() / 2.0, yyOutlier, oRadius
	                        )
	                    );
	                }

                Collections.sort(outliers);
            }
            //display farouts as JFreeChart Implemetation
            if(!displayAllOutliers){
	            // Process outliers. Each outlier is either added to the 
	            // appropriate outlier list or a new outlier list is made
            	for (int i = 0; i < yOutliers.size(); i++) {
            		 Number minRegular = bawDataset.getMinRegularValue(row, column);
                     Number maxRegular = bawDataset.getMaxRegularValue(row, column);
                    double outlier = ((Number) yOutliers.get(i)).doubleValue();
                    if (outlier < minRegular.doubleValue() ||
                    		outlier > maxRegular.doubleValue()) {
	                    yyOutlier = rangeAxis.valueToJava2D(
	                        outlier, dataArea, location
	                    );
	                    outliers.add(
	                        new Outlier(
	                            xx + state.getBarWidth() / 2.0, yyOutlier, oRadius
	                        )
	                    );
                    }
                }
                    
	            for (Iterator iterator = outliers.iterator(); iterator.hasNext();) {
	                Outlier outlier = (Outlier) iterator.next();
	                outlierListCollection.add(outlier);
	            }
	
	            for (Iterator iterator = outlierListCollection.iterator(); 
	                 iterator.hasNext();) {
	                OutlierList list = (OutlierList) iterator.next();
	                Outlier outlier = list.getAveragedOutlier();
	                Point2D point = outlier.getPoint();
	
	                if (list.isMultiple()) {
	                    drawMultipleEllipse(
	                        point, state.getBarWidth(), oRadius, g2
	                    );
	                } 
	                else {
	                    drawEllipse(point, oRadius, g2);
	                }
	            }
	            // draw farout indicators
	            if (outlierListCollection.isHighFarOut()) {
	                drawHighFarOut(
	                    aRadius / 2.0, g2, xx + state.getBarWidth() / 2.0, 
	                    maxAxisValue
	                );
	            }
	        
	            if (outlierListCollection.isLowFarOut()) {
	                drawLowFarOut(
	                    aRadius / 2.0, g2, xx + state.getBarWidth() / 2.0, 
	                    minAxisValue
	                );
	            }
            }
            else{
            	for (int i = 0; i < yOutliers.size(); i++) {
           		 Number minRegular = bawDataset.getMinRegularValue(row, column);
                    Number maxRegular = bawDataset.getMaxRegularValue(row, column);
                   double outlier = ((Number) yOutliers.get(i)).doubleValue();
                   if (outlier < minRegular.doubleValue() ||
                   		outlier > maxRegular.doubleValue()) {
	                    yyOutlier = rangeAxis.valueToJava2D(
	                        outlier, dataArea, location
	                    );
	                    outliers.add(
	                        new Outlier(
	                            xx + state.getBarWidth() / 2.0, yyOutlier, oRadius
	                        )
	                    );
                   }
               }
            	Collections.sort(outliers);    
            	for (Iterator iterator = outliers.iterator(); iterator.hasNext();) {
	                Outlier outlier = (Outlier) iterator.next();
	                Point2D point = outlier.getPoint();
	
	                drawEllipse(point, oRadius, g2);
	                }
	            }
        }
        // collect entity and tool tip information...
        if (state.getInfo() != null) {
            EntityCollection entities = state.getEntityCollection();
            if (entities != null) {
                String tip = null;
                CategoryToolTipGenerator tipster 
                    = getToolTipGenerator(row, column);
                if (tipster != null) {
                    tip = tipster.generateToolTip(dataset, row, column);
                }
                String url = null;
                if (getItemURLGenerator(row, column) != null) {
                    url = getItemURLGenerator(row, column).generateURL(
                        dataset, row, column
                    );
                }
                CategoryItemEntity entity = new CategoryItemEntity(
                    box, tip, url, dataset, row, dataset.getColumnKey(column), 
                    column
                );
                entities.add(entity);
            }
        }

    }

    /**
     * Draws a dot to represent an outlier. 
     * 
     * @param point  the location.
     * @param oRadius  the radius.
     * @param g2  the graphics device.
     */
    private void drawEllipse(Point2D point, double oRadius, Graphics2D g2) {
        Ellipse2D dot = new Ellipse2D.Double(
            point.getX() + oRadius / 2, point.getY(), oRadius, oRadius
        );
        g2.draw(dot);
    }

    /**
     * Draws two dots to represent the average value of more than one outlier.
     * 
     * @param point  the location
     * @param boxWidth  the box width.
     * @param oRadius  the radius.
     * @param g2  the graphics device.
     */
    private void drawMultipleEllipse(Point2D point, double boxWidth, 
                                     double oRadius, Graphics2D g2)  {
                                         
        Ellipse2D dot1 = new Ellipse2D.Double(
            point.getX() - (boxWidth / 2) + oRadius, point.getY(), 
            oRadius, oRadius
        );
        Ellipse2D dot2 = new Ellipse2D.Double(
            point.getX() + (boxWidth / 2), point.getY(), oRadius, oRadius
        );
        g2.draw(dot1);
        g2.draw(dot2);
    }

    /**
     * Draws a triangle to indicate the presence of far-out values.
     * 
     * @param aRadius  the radius.
     * @param g2  the graphics device.
     * @param xx  the x coordinate.
     * @param m  the y coordinate.
     */
    private void drawHighFarOut(double aRadius, Graphics2D g2, double xx, 
                                double m) {
        double side = aRadius * 2;
        g2.draw(new Line2D.Double(xx - side, m + side, xx + side, m + side));
        g2.draw(new Line2D.Double(xx - side, m + side, xx, m));
        g2.draw(new Line2D.Double(xx + side, m + side, xx, m));
    }

    /**
     * Draws a triangle to indicate the presence of far-out values.
     * 
     * @param aRadius  the radius.
     * @param g2  the graphics device.
     * @param xx  the x coordinate.
     * @param m  the y coordinate.
     */
    private void drawLowFarOut(double aRadius, Graphics2D g2, double xx, 
                               double m) {
        double side = aRadius * 2;
        g2.draw(new Line2D.Double(xx - side, m - side, xx + side, m - side));
        g2.draw(new Line2D.Double(xx - side, m - side, xx, m));
        g2.draw(new Line2D.Double(xx + side, m - side, xx, m));
    }
    
    /**
     * Tests this renderer for equality with an arbitrary object.
     *
     * @param obj  the object (<code>null</code> permitted).
     *
     * @return <code>true</code> or <code>false</code>.
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;   
        }
        if (!(obj instanceof BoxAndWhiskerRenderer)) {
            return false;   
        }
        if (!super.equals(obj)) {
            return false;
        }
        BoxAndWhiskerCoinPlotRenderer that = (BoxAndWhiskerCoinPlotRenderer) obj;
        if (!PaintUtilities.equal(this.getArtifactPaint(), that.getArtifactPaint())) {
            return false;
        }
        if (!(this.getFillBox() == that.getFillBox())) {
            return false;   
        }
        if (!(this.getItemMargin() == that.getItemMargin())) {
            return false;   
        }
        if (!(this.maxBarWidth == that.maxBarWidth)){
        	return false;
        }
        if (!(this.caIntegatorCoinList  == that.caIntegatorCoinList)){
        	return false;
        }
        if (!(this.displayMean == this.displayMean)){
        	return false;
        }
        if (!(this.displayMedian == that.displayMedian)){
        	return false;
        }
        if (!(this.displayAllOutliers == that.displayAllOutliers)){
        	return false;
        }
        if(!(this.displayCoinCloud == that.displayCoinCloud)){
        	return false;
        }
        if(!(this.outlierRadiusDenominator == that.outlierRadiusDenominator)){
        	return false;
        }
        return true;
    }
    
    /**
     * Provides serialization support.
     *
     * @param stream  the output stream.
     *
     * @throws IOException  if there is an I/O error.
     */
    private void writeObject(ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();
        SerialUtilities.writePaint(this.getArtifactPaint(), stream);
    }

    /**
     * Provides serialization support.
     *
     * @param stream  the input stream.
     *
     * @throws IOException  if there is an I/O error.
     * @throws ClassNotFoundException  if there is a classpath problem.
     */
    private void readObject(ObjectInputStream stream) 
        throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        setArtifactPaint( SerialUtilities.readPaint(stream));
    }
    
    private void drawCoinCloud(	Graphics2D g2, 
    							CategoryItemRendererState state,
    							Rectangle2D dataArea,
    							RectangleEdge location,
    							ValueAxis rangeAxis,
    							double xx,
    							int row, 
    							int column){
        double yyOutlier;
        List outliers = new ArrayList();
		//caIntegrator Modify: oRadius is the radius of the outlier circles. It used to be 3.
        // draw outliers
        double oRadius = state.getBarWidth() / outlierRadiusDenominator;    // outlier radius
        
        // From outlier array sort out which are outliers and put these into a 
        // list If there are any farouts, set the flag on the 
        // OutlierListCollection
        // CaIntegrator Extension
       	List yCoinList = this.caIntegatorCoinList.get(String.valueOf(row)+"_"+String.valueOf(column));
       	Random generator = new Random();
        if (yCoinList != null) {
            for (int i = 0; i < yCoinList.size(); i++) {
                double outlier = ((Number) yCoinList.get(i)).doubleValue();
				yyOutlier = rangeAxis.valueToJava2D(
                	outlier, dataArea, location
                );
				double xxOutlier = (xx + state.getBarWidth()/5)+ generator.nextInt((int)state.getBarWidth());
				outliers.add(new Outlier(xxOutlier , yyOutlier, oRadius ));

                Collections.sort(outliers);
            }

			//Sort the raw data according to its Y axis first as groups.
			//Grouping of these raw data is based on a single standard:
			//if any number of data, when plotted on a vertical line, overlap
			//with one another, they belong to the same group. In this case, 
			//the grouping is largely determined by the diameter of the dot, that
			//represents each raw data.
			boolean firstOutlier = true;
			double topY = 0;
			double bottomY = 0;
			List groupList = new ArrayList();
			List tempList = null;
			double diameter = 2*oRadius;
			
			double difference = 0;
			for (Iterator iterator = outliers.iterator(); iterator.hasNext();) {                	
                 
                Outlier outlier = (Outlier)iterator.next();	
                
                //Set the smallest outlier as the base bottom line
                if (firstOutlier)
                {
                	firstOutlier = false;
                	bottomY = outlier.getY();
                	tempList = new ArrayList();
                	tempList.add(outlier);
                	continue;
                }
                
                topY = outlier.getY();
                
                //If this one and the one before it is overlapping,
                //Then put them in the same group, so we can spread them
                //horizontally
                difference = topY - bottomY;
                
                if (difference < diameter)
                {
                	tempList.add(outlier);
                }
                //They do not overlap, they belong to the different groups.
                else
                {
                	bottomY = topY;
                	groupList.add(tempList);
                	tempList = new ArrayList();
                	tempList.add(outlier);
                }
			}
           
			//caIntegrator - x axis cloud
           //Process each outlier's x coordinates  
           boolean isOdd = true;
           double offSet = 0;
           int listSize = 0;

           for (int m = 0; m < groupList.size(); m++)
           {
              List list = (List)groupList.get(m);
              if (list != null && list.size() > 1)
              {
					listSize = list.size();
              		isOdd = (listSize%2 == 1)?true:false;
              	
              		if (isOdd)
              		{
              			offSet = diameter*(listSize/2);
              		}
              		else
              		{
              			offSet = diameter*(listSize/2) - oRadius;
              		}
              		
              		Random r = new Random();
          			offSet = (Math.abs(r.nextInt()) % 3)*3;
              		offSet = 0;
              		
              		for (int n = 0; n < list.size(); n++)
              		{
              			Outlier outlier = (Outlier)list.get(n);
              		
              			outlier.setPoint(new Point2D.Double(outlier.getX() - offSet, outlier.getY()));
              			offSet = offSet - diameter;
              			r = new Random();
              			int randInt = Math.abs(r.nextInt()) % 3;
              			offSet = randInt*2;
              		}
              	}              
              }
                 
             //Draw these dots on the graph.   		
             for (Iterator iterator = groupList.iterator(); 
                 iterator.hasNext();) {                	

                List list = (List) iterator.next();
                for (int i = 0; i < list.size(); i++)
                {
                	Outlier outlier = (Outlier)list.get(i);
                	Point2D point = outlier.getPoint();
					drawEllipse(point, oRadius, g2);
            	}
            }			 
        }
    	
    }
	/**
	 * @return Returns the maxBarWidth.
	 */
	public double getMaxBarWidth() {
		return maxBarWidth;
	}
	/**
	 * @param maxBarWidth The maxBarWidth to set.
	 */
	public void setMaxBarWidth(double maxBarWidth) {
		this.maxBarWidth = maxBarWidth;
	}
	/**
	 * @return Returns the displayCoinCloud.
	 */
	public boolean isDisplayCoinCloud() {
		return displayCoinCloud;
	}
	/**
	 * @param displayCoinCloud The displayCoinCloud to set.
	 */
	public void setDisplayCoinCloud(boolean displayCoinCloud) {
		this.displayCoinCloud = displayCoinCloud;
	}
	/**
	 * @return Returns the displayMean.
	 */
	public boolean isDisplayMean() {
		return displayMean;
	}
	/**
	 * @param displayMean The displayMean to set.
	 */
	public void setDisplayMean(boolean displayMean) {
		this.displayMean = displayMean;
	}
	/**
	 * @return Returns the displayMedian.
	 */
	public boolean isDisplayMedian() {
		return displayMedian;
	}
	/**
	 * @param displayMedian The displayMedian to set.
	 */
	public void setDisplayMedian(boolean displayMedian) {
		this.displayMedian = displayMedian;
	}
	/**
	 * @return Returns the outlierRadiusDenominator.
	 */
	public int getOutlierRadiusDenominator() {
		return outlierRadiusDenominator;
	}
	/**
	 * @param outlierRadiusDenominator The outlierRadiusDenominator to set.
	 */
	public void setOutlierRadiusDenominator(int outlierRadiusDenominator) {
		this.outlierRadiusDenominator = outlierRadiusDenominator;
	}
	/**
	 * @return Returns the displayAllOutliers.
	 */
	public boolean isDisplayAllOutliers() {
		return displayAllOutliers;
	}
	/**
	 * @param displayAllOutliers The displayAllOutliers to set.
	 */
	public void setDisplayAllOutliers(boolean displayAllOutliers) {
		this.displayAllOutliers = displayAllOutliers;
	}
	/**
	 * @return Returns the plotColor.
	 */
	public String getPlotColor() {
		return plotColor;
	}
	/**
	 * @param plotColor The plotColor to set.
	 */
	public void setPlotColor(String plotColor) {
		this.plotColor = plotColor;
	}
   
}


