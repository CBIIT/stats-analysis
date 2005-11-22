package gov.nih.nci.caintegrator.analysis.test;

import gov.nih.nci.caintegrator.analysis.messaging.*;
import gov.nih.nci.caintegrator.exceptions.AnalysisServerException;
import gov.nih.nci.caintegrator.enumeration.*;
import gov.nih.nci.caintegrator.analysis.visualization.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.jms.Message;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Queue;
import javax.jms.QueueSender;
import javax.jms.QueueReceiver;
import javax.jms.ObjectMessage;
import javax.jms.MessageListener;
import javax.jms.ExceptionListener;
import javax.jms.Session;
import javax.jms.JMSException;
import javax.jms.DeliveryMode;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYImageAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.encoders.EncoderUtil;
import org.jfree.chart.encoders.ImageFormat;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.Dimension;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.table.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

/**
 * This class tests submitting a request to the analysis server 
 * via JMS
 * @author Michael A. Harris
 *
 */
public class AnalysisSubmitter implements MessageListener, ExceptionListener {

	private static Logger logger = Logger.getLogger(AnalysisSubmitter.class);
    private static String appLocationIp = "156.40.128.136:1099";
	
	private PCAtableModel pcaTableModel = new PCAtableModel();
	private CCtableModel ccTableModel = new CCtableModel();
	//private ImagePanel pcaImagePanel = new ImagePanel();
	private JPanel pcaImages = new JPanel();
	private int pcaCounter = 1;
	private int ccCounter = 1;
	private int hcCounter = 1;
	private QueueConnection queueConnection;

	//pca
	private JTextField pcaVarianceFilterTF = new JTextField(12);
	private JTextField pcaFoldChangeFilterTF = new JTextField(12);
	private JTextField pcaReporterIdsTF = new JTextField(20);
	private JTextField pcaSampleIdsTF = new JTextField(20);
	private ImagePanel pcaImage1 = new ImagePanel();
	private ImagePanel pcaImage2 = new ImagePanel();
	private ImagePanel pcaImage3 = new ImagePanel();
	private SelectablePlot3DPanel pca3Dviz = new SelectablePlot3DPanel();

	private SampleGroup gbmGrp = new SampleGroup("GBM");
	private SampleGroup astroGrp = new SampleGroup("ASTRO");
	private SampleGroup normalGrp = new SampleGroup("NORMAL");
	private SampleGroup oligoGrp = new SampleGroup("OLIGO");
	private SampleGroup mixedGrp = new SampleGroup("MIXED");
	
	private String gbmHFids = "HF0024,HF0031,HF0048,HF0050,HF0066,HF0089,HF0138,HF0142,HF0180,HF0184,HF0212,HF0218,HF0244,HF0268,HF0300.3,HF0316,HF0350,HF0408,HF0435,HF0442.5,HF0445,HF0460,HF0505,HF0520,HF0543,HF0583,HF0627,HF0652.4,HF0654,HF0702,HF0790,HF0850,HF0855,HF0894,HF0936,HF0954.2,HF0963,HF0982,HF0986,HF0990,HF0992,HF0996,HF1057,HF1058,HF1077,HF1078,HF1097,HF1122,HF1137,HF1178,HF1186,HF1191,HF1220,HF1242,HF1255,HF1262,HF1280,HF1286,HF1292,HF1318,HF1326,HF1338,HF1356,HF1357,HF1382,HF1397,HF1409,HF1458,HF1475,HF1490,HF1492,HF1494,HF1509,HF1517,HF1534,HF1538,HF1540,HF1585,HF1589,HF1608,HF1618,HF1628,HF1640,HF1667,HF1671,HF1702";
	private String oligoHFids = "HF0087,HF0251,HF0285,HF0291,HF0327,HF0329,HF0332,HF0434,HF0453,HF0471,HF0488,HF0510,HF0599,HF0615,HF0639,HF0670,HF0726,HF0813,HF0816,HF0822,HF0828,HF0835,HF0897,HF0899,HF0914,HF0920,HF0931,HF0960,HF0962,HF0966,HF0975,HF1136,HF1150,HF1156,HF1167,HF1185,HF1219,HF1227,HF1235,HF1325,HF1334,HF1345,HF1348,HF1380,HF1381,HF1489,HF1493,HF1502,HF1551,HF1606,HF1613,HF1677";
	private String astroHFids = "HF0017,HF0026,HF0108,HF0152,HF0189,HF0223,HF0450,HF0491,HF0608,HF0757,HF0778,HF0953,HF1000,HF1032,HF1139,HF1232,HF1246,HF1269,HF1295,HF1316,HF1344,HF1366,HF1407,HF1442,HF1469,HF1487,HF1511,HF1568,HF1581,HF1587,HF1708";
	private String mixedHFids = "HF0022,HF0183,HF0252,HF0305,HF0606,HF0802,HF0844,HF0891,HF1090,HF1297,HF1319,HF1588";
	private String normalHFids = "HF0088,HF0120,HF0131,HF0137,HF0141,HF0151,HF0163,HF0171,HF0178,HF0201,HF0211,HF0232,HF0295,HF0303,HF0312,HF0377,HF0383,HF0467,HF0512,HF0523,HF0526,HF0533,HF0593,HF0616";

	
	
	//class comparison 
	private JTextField ccSampleGroup1Ids = new JTextField(25);
	private JTextField ccSampleGroup2Ids = new JTextField(25);
	private JTextField ccGroup1Name = new JTextField(10);
	private JTextField ccGroup2Name = new JTextField(10);
	private JComboBox  ccStatisticalMethodCombo = new JComboBox();
	private JComboBox  ccComparisonAdjCombo = new JComboBox();
	private JTextField ccFoldChangeFilterTF = new JTextField(12);
	private JTextField ccPvalueFilterTF = new JTextField(12);
	private JComboBox ccArrayPlatformCombo = new JComboBox();
	
	//hc 
	private JTextField hcaVarianceFilterTF = new JTextField(3);
	private JTextField hcReporterIdsTF = new JTextField(25);
	private JTextField hcSampleIdsTF = new JTextField(25);
	private JComboBox hcaDistanceMatrixCombo = new JComboBox();
	private ButtonGroup hcClusterByGroup = new ButtonGroup();
	private JComboBox hcArrayPlatformCombo = new JComboBox();
	private JComboBox hcaLinkageMethodCombo = new JComboBox();
	private ImagePanel hcaImagePanel = new ImagePanel();
	private JPanel hcaImages = new JPanel();
	
	  /**
	   * Topic session, hold on to this so you may close it.
	   * Also used to create messages.
	   */
	 private QueueSession queueSession;

	  /**
	   * Use this to publish messages.
	   */
	 //private TopicPublisher topicPublisher;
	 
	 private QueueSender requestSender;
	 private QueueReceiver resultReceiver;

	  /**
	   * Destination where to publish.
	   */
	 private Queue requestQueue;
	 private Queue resultQueue;
	 
	 private JFrame frame = null;
	

	
	public AnalysisSubmitter(String factoryJNDI)
	                         throws JMSException, NamingException {
		super();
		// TODO Auto-generated constructor stub
//		 Populate with needed properties
		Hashtable props = new Hashtable();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
		    "org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, appLocationIp);
		props.put("java.naming.rmi.security.manager", "yes");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming");

//		   Get the initial context with given properties
		Context context = new InitialContext(props);  
		  
	    // Get the initial context
	    //Context context = new InitialContext();

	    // Get the connection factory
	    QueueConnectionFactory queueConnectionFactory =
	      (QueueConnectionFactory)context.lookup(factoryJNDI);

	    // Create the connection
	    queueConnection = queueConnectionFactory.createQueueConnection();
	    queueConnection.setExceptionListener(this);

	    // Create the session
	    queueSession = queueConnection.createQueueSession(
	      // No transaction
	      false,
	      // Auto ack
	      Session.AUTO_ACKNOWLEDGE);

	    // Look up the destination
	    requestQueue = (Queue)context.lookup("queue/AnalysisRequest");
	    resultQueue = (Queue)context.lookup("queue/AnalysisResponse");

	    //load sample groups this will be provided in the middle tier
	    initializeSampleGroups();
	    
	    
	    // Create a publisher
	    requestSender = queueSession.createSender(requestQueue);
		resultReceiver = queueSession.createReceiver(resultQueue);
		resultReceiver.setMessageListener(this);
		queueConnection.start();
	}
	
	private void initializeSampleGroups() {
	  initializeSampleGroup(gbmGrp, gbmHFids);
	  initializeSampleGroup(astroGrp, astroHFids);
	  initializeSampleGroup(oligoGrp, oligoHFids);
	  initializeSampleGroup(mixedGrp, mixedHFids);
	  initializeSampleGroup(normalGrp, normalHFids);
	}
	
	private void initializeSampleGroup(SampleGroup grp, String identifierStr) {
	  StringTokenizer t = new StringTokenizer(identifierStr, ",");
	  String id;
	  while(t.hasMoreTokens()) {
	    id = t.nextToken().trim();
	    grp.add(id.trim());
	  }
	}

	/**
	   * Implementation of the MessageListener interface,
	   * messages will be received through this method.
	   */
	  public void onMessage(Message m) {

	    // Unpack the message, be careful when casting to the correct
	    // message type. onMessage should not throw any application
	    // exceptions.
	    try {

	      //String msg = ((TextMessage)m).getText();
	      ObjectMessage msg = (ObjectMessage) m;
	      //AnalysisResult result = (AnalysisResult) msg.getObject();
	      Object result = msg.getObject();
	      
	      
	      //AnalysisRequest request = (AnalysisRequest) requestMap.get(new Integer(result.getTaskId()));
	      //request.setRequestCompleteTime(System.currentTimeMillis());
	      //long messageRTtime = request.getElapsedTime() - result.getResultObjCreateTime();
	      //System.out.println("AnalysisSubmitter got result: " + result + " totalElapsedTime=" + request.getElapsedTime());
	      //System.out.println("\t\t>> result[5]=" + result.getValue(5) + " result[50000][9]=" + result.getValue(50000));
	  
	      if (result instanceof ClassComparisonResult) {
	        processCCresult((ClassComparisonResult)result); 
	      }
	      else if (result instanceof HierarchicalClusteringResult) {
	    	processHCAresult((HierarchicalClusteringResult) result);
	      }
	      else if (result instanceof PrincipalComponentAnalysisResult) {
	    	processPCAresult((PrincipalComponentAnalysisResult)result);
	      }
	      else if (result instanceof AnalysisServerException) {
	        handleException((AnalysisServerException)result);
	      }
	    	  
	    } catch(JMSException ex) {

	      System.err.println("AnalysisSubmitter exception: " + ex);
	      ex.printStackTrace();

	    }

	  }
	  
	private void handleException(AnalysisServerException exception) {
		 JOptionPane.showMessageDialog(null, exception.getMessage(), "AnalysisServerException", JOptionPane.ERROR_MESSAGE);
	}
	
	private PlotData convertPCAresultEntry2plotData(PCAresultEntry entry) {
	  PlotData pd = new PlotData(entry.getSampleId(), entry.getPc1(), entry.getPc2(), entry.getPc3());
	  return pd;
	}
	
	private PlotData[] getPlotArray(List<PlotData> plotDataList) {
	  PlotData[] retArr = new PlotData[plotDataList.size()];
	  plotDataList.toArray(retArr);
	  return retArr;
	}

	private void dumpPlotData(PrintWriter out, String groupName,  List<PlotData> theList) {
		for (PlotData data : theList) {
		  out.println(data.getName() + "," + groupName + "," + data.getX() + "," + data.getY() + "," + data.getZ());
		}
	}
	
	private void processPCAresult(PrincipalComponentAnalysisResult result) {
		  System.out.println("Proccessing PCA result=" + result);
		  List<PCAresultEntry> entryList = result.getResultEntries();
		  pcaTableModel.setPCAdata(entryList);
		  
		  
		  
		  PlotData[] plotData = new PlotData[entryList.size()];
		  int i = 0;
		  PlotData pd;
		  List<PlotData> gbmPlotData = new ArrayList<PlotData>();
		  List<PlotData> astroPlotData = new ArrayList<PlotData>();
		  List<PlotData> oligoPlotData = new ArrayList<PlotData>();
		  List<PlotData> mixedPlotData = new ArrayList<PlotData>();
		  List<PlotData> normalPlotData = new ArrayList<PlotData>();
		  
		  for (PCAresultEntry entry : entryList) {
			 pd = convertPCAresultEntry2plotData(entry);
			 if (gbmGrp.contains(pd.getName())) {
			   gbmPlotData.add(pd);
			 }
			 else if (oligoGrp.contains(pd.getName())) {
			   oligoPlotData.add(pd);
			 }
			 else if (astroGrp.contains(pd.getName())) {
				astroPlotData.add(pd); 
			 }
			 else if (mixedGrp.contains(pd.getName())) {
				mixedPlotData.add(pd);
			 }
			 else if (normalGrp.contains(pd.getName())) {
				normalPlotData.add(pd);
			 }
		  }
		  
//		dump the pca data
//		  try {
//			  PrintWriter out = new PrintWriter(new FileWriter("HFpca.txt"));
//		      dumpPlotData(out, "GBM",  gbmPlotData);
//		      dumpPlotData(out, "ASTRO", astroPlotData);
//		      dumpPlotData(out, "OLIGO", oligoPlotData);
//		      dumpPlotData(out, "MIXED", mixedPlotData);
//		      dumpPlotData(out, "NORMAL", normalPlotData);	  
//			  out.close();
//		  } catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//		  }
		  
	  	  pca3Dviz.addScatterPlot("GBM", getPlotArray(gbmPlotData));
	  	  pca3Dviz.addScatterPlot("ASTRO", getPlotArray(astroPlotData));
	  	  pca3Dviz.addScatterPlot("OLIGO", getPlotArray(oligoPlotData));
	  	  pca3Dviz.addScatterPlot("MIXED", getPlotArray(mixedPlotData));
	  	  pca3Dviz.addScatterPlot("NORMAL", getPlotArray(normalPlotData));
		  
		  //create the image from the PCA data
		  byte[] img1Bytes = result.getImage1Bytes();
		  byte[] img2Bytes = result.getImage2Bytes();
		  byte[] img3Bytes = result.getImage3Bytes();
		  
		  Image img1 = Toolkit.getDefaultToolkit().createImage(img1Bytes);
		  Image img2 = Toolkit.getDefaultToolkit().createImage(img2Bytes);
		  Image img3 = Toolkit.getDefaultToolkit().createImage(img3Bytes);
		  		  
		  pcaImage1.setImage(img1, 750, 750);
		  pcaImage2.setImage(img2, 750, 750);
		  pcaImage3.setImage(img3, 750, 750);
		 		    
		  pcaImages.repaint();
	  }
	  
	  private void processHCAresult(HierarchicalClusteringResult result) {
		  System.out.println("Processing HCA result=" + result);
		  
		  Image img = Toolkit.getDefaultToolkit().createImage(result.getImageCode());
		  
		  hcaImagePanel.setImage(img,750,750);
		  hcaImages.repaint();
		  
		  //write the bytes to a file
		  byte imageBytes[] = result.getImageCode();
		  
		  try {
			  OutputStream out = new FileOutputStream("image_file_save.png");
			  //PrintWriter out = new PrintWriter(new FileWriter("image_test.png"));
			  out.write(imageBytes, 0, imageBytes.length);
//			  for (int i=0; i < imageBytes.length; i++) {
//			    out.write(imageBytes[i]);
//			  }
			  out.close();
		  }
		  catch (IOException ex) {
		    ex.printStackTrace(System.out);
		  }
		  
		  
		  //try writing the image to a file
		  JFreeChart hcChart = ChartFactory.createScatterPlot("Principal Component Analysis","", "", null,  PlotOrientation.VERTICAL,
		            true, 
		            true, 
		            false );
		  
		  
		 
		  hcChart.setBackgroundImage(img);
		  XYPlot plot = (XYPlot) hcChart.getPlot();
		  
		  NumberAxis domainAxis = (NumberAxis) plot.getDomainAxis();
	      NumberAxis rangeAxis  =	(NumberAxis) plot.getRangeAxis();
	        
	        //should determine axis range using datapoints.
	        
	        //domainAxis.setAutoRangeIncludesZero(false);
	        
	        
	        domainAxis.setRange(0.0, 800.0);
	        rangeAxis.setRange(0.0, 800.0);
		  
		  XYImageAnnotation annot = new XYImageAnnotation(200,200,img);
		  plot.addAnnotation(annot);
		  
		  
		  
		  String fileName = "hcResult2.png";
		  File pngFile = new File(fileName);
		  try {
		  ChartUtilities.saveChartAsPNG(pngFile, hcChart, 750, 750);
		  }
		  catch (IOException ex) {
		    ex.printStackTrace(System.out);
		  }
		  
		  
//		  BufferedImage buffImg = new BufferedImage(800, 800, BufferedImage.TYPE_INT_RGB);
//		  Graphics g = buffImg.createGraphics();

//		  //g.drawImage(img, null, 0,0);
//		  g.drawImage(img, 0,0, Color.GREEN, null);
//		  String fileName = "hcResult_" + result.getSessionId() + "_" + result.getTaskId() + ".png";
//		  try {
//		    FileOutputStream out = new FileOutputStream(fileName);
//		    //ChartUtils.saveChartAsPNG();
//		    EncoderUtil.writeBufferedImage(buffImg, ImageFormat.PNG, out);
//		    ChartUtilities.saveChartAsPNG()
//		    out.close();
//		  }
//		  catch (IOException ex) {
//		    ex.printStackTrace(System.out);
//		  }
		  
	  }
	  
	  private void processCCresult(ClassComparisonResult result) {
		 System.out.println("Processiong CC result=" + result);  
		 ccTableModel.setCCdata(result); 
	  }
	
	/**
	   * Publish the given String as a JMS message to the testTopic topic.
	   */
	  public void sendRequest(AnalysisRequest request) throws JMSException {
  
	    // Create a message
	    ObjectMessage msg = queueSession.createObjectMessage(request);
	

	    // Send the message
	    requestSender.send(msg, DeliveryMode.NON_PERSISTENT, Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);
	    
	  }

	  /**
	   * Close session and connection.
	   * When done, no publishing is possible any more.
	   */
	  public void close() throws JMSException {

	    queueSession.close();
	    queueConnection.close();

	  }
	  
	  private void buildCCGui(JTabbedPane tabbedPane) {
		  JSplitPane ccSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		  tabbedPane.addTab("Class Comparison", ccSplitPane);
		 
		  JPanel ccRequestPanel = new JPanel(new BorderLayout());
		  JPanel ccResponsePanel = new JPanel();
		  
		  ccSplitPane.add(ccRequestPanel, JSplitPane.TOP);
		  ccSplitPane.add(ccResponsePanel, JSplitPane.BOTTOM);
		  
          JPanel ccButtonPanel = new JPanel();
          JButton ccSubmitButton = new JButton("Submit");
          
          ccSubmitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			  System.out.println("Submitting class comparison request");
			  ClassComparisonRequest ccRequest = new ClassComparisonRequest(Integer.toString(4567),Integer.toString(ccCounter++));
				
			  //fill out the request
			  ccRequest.setStatisticalMethod((StatisticalMethodType)ccStatisticalMethodCombo.getSelectedItem());
			  ccRequest.setMultiGroupComparisonAdjustmentType((MultiGroupComparisonAdjustmentType)ccComparisonAdjCombo.getSelectedItem());
			  ccRequest.setFoldChangeThreshold(Double.parseDouble(ccFoldChangeFilterTF.getText()));
			  ccRequest.setPvalueThreshold(Double.parseDouble(ccPvalueFilterTF.getText()));
			  ccRequest.setArrayPlatform((ArrayPlatformType) ccArrayPlatformCombo.getSelectedItem());
			  
			  //create the sample groups
			  SampleGroup group1 = new SampleGroup(ccGroup1Name.getText());
			  StringTokenizer t1 = new StringTokenizer(ccSampleGroup1Ids.getText(), ",");
			  while  (t1.hasMoreTokens()) {
			    String sampleId = t1.nextToken().trim();
				group1.add(sampleId);
			  }
			  ccRequest.setGroup1(group1);
			  SampleGroup group2 = null;
			  String group2Name = ccGroup2Name.getText();
			  if ((group2Name != null)&&(group2Name.trim().length() > 0)) {
			     group2 = new SampleGroup(group2Name);
			     StringTokenizer t2 = new StringTokenizer(ccSampleGroup2Ids.getText(), ",");
			     while (t2.hasMoreTokens()) {
			       String sampleId = t2.nextToken().trim();
			       group2.add(sampleId);
			     }
			     ccRequest.setGroup2(group2);
			  }
			  
			  //fill in the paramters
			  
			  try {
				sendRequest(ccRequest);
			  } catch (JMSException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			  }
			}  
          });
          
          ccButtonPanel.add(ccSubmitButton);
          
         
          ccRequestPanel.add(ccButtonPanel, BorderLayout.SOUTH);
          JPanel ccRequestCenterPanel = new JPanel();
          BoxLayout bl = new BoxLayout(ccRequestCenterPanel, BoxLayout.Y_AXIS);
          ccRequestCenterPanel.setLayout(bl);
          ccRequestPanel.add(ccRequestCenterPanel, BorderLayout.CENTER);
          
          ccSampleGroup1Ids.setBorder(new TitledBorder("Group1 Samples"));
          ccSampleGroup2Ids.setBorder(new TitledBorder("Group2 Samples"));
          ccGroup1Name.setBorder(new TitledBorder("Group1 Name"));
          ccGroup2Name.setBorder(new TitledBorder("Group2 Name"));
          ccRequestCenterPanel.add(ccGroup1Name);          
          ccRequestCenterPanel.add(ccSampleGroup1Ids);
          ccRequestCenterPanel.add(ccGroup2Name);
          ccRequestCenterPanel.add(ccSampleGroup2Ids);
          ccStatisticalMethodCombo.addItem(StatisticalMethodType.TTest);
          ccStatisticalMethodCombo.addItem(StatisticalMethodType.Wilcoxin);
          ccStatisticalMethodCombo.setBorder(new TitledBorder("Statistical Method"));
          ccRequestCenterPanel.add(ccStatisticalMethodCombo);
          
          ccComparisonAdjCombo.addItem(MultiGroupComparisonAdjustmentType.NONE);
          ccComparisonAdjCombo.addItem(MultiGroupComparisonAdjustmentType.FDR);
          ccComparisonAdjCombo.addItem(MultiGroupComparisonAdjustmentType.FWER);
          ccComparisonAdjCombo.setBorder(new TitledBorder("Multiple Comparison Adjustment"));
          ccRequestCenterPanel.add(ccComparisonAdjCombo);
          ccComparisonAdjCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			  MultiGroupComparisonAdjustmentType adjMethod = (MultiGroupComparisonAdjustmentType)ccComparisonAdjCombo.getSelectedItem();
			  TitledBorder border = (TitledBorder) ccPvalueFilterTF.getBorder();
			  if (adjMethod == MultiGroupComparisonAdjustmentType.NONE) {
			    border.setTitle("P-Value Filter Value");
			  }
			  else {
				border.setTitle("Adjusted P-Value Filter Value");
			  }
			}  
          });
          
          ccFoldChangeFilterTF.setBorder(new TitledBorder("Fold Change Filter Value"));
          ccFoldChangeFilterTF.setText("2");
          ccRequestCenterPanel.add(ccFoldChangeFilterTF);
          
          ccPvalueFilterTF.setBorder(new TitledBorder("P-Value Filter Value"));
          ccPvalueFilterTF.setText("0.001");
          ccRequestCenterPanel.add(ccPvalueFilterTF);
          
          ccArrayPlatformCombo.addItem(ArrayPlatformType.AFFY_OLIGO_PLATFORM);
          ccArrayPlatformCombo.addItem(ArrayPlatformType.CDNA_ARRAY_PLATFORM);
          ccArrayPlatformCombo.setBorder(new TitledBorder("Array Platform"));
          ccRequestCenterPanel.add(ccArrayPlatformCombo);
          
          JSplitPane ccResponseSP = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
          JTable ccResultTable = new JTable(ccTableModel);
          JScrollPane ccResultTableSP = new JScrollPane(ccResultTable);
          ccResponseSP.add(ccResultTableSP, JSplitPane.TOP);
          ccResponsePanel.add(ccResponseSP);
		
	}

	private void buildHCGui(JTabbedPane tabbedPane) {
		
		 JSplitPane hcSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		 tabbedPane.addTab("Hierarchical Clustering", hcSplitPane);
		 
		 JPanel hcRequestPanel = new JPanel(new BorderLayout());
		 JPanel hcResponsePanel = new JPanel();
		 
		 hcSplitPane.add(hcRequestPanel, JSplitPane.TOP);
		 hcSplitPane.add(hcResponsePanel, JSplitPane.BOTTOM);
		 
		 hcaImages.add(hcaImagePanel);
		 JScrollPane responseSP = new JScrollPane(hcaImages);
		 hcResponsePanel.add(responseSP);
         JPanel hcButtonPanel = new JPanel();
         JButton hcSubmitButton = new JButton("Submit");
         
         hcSubmitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.out.println("Submitting hierarchical clustering request");
				HierarchicalClusteringRequest hcRequest = new HierarchicalClusteringRequest("234578907654", Integer.toString(hcCounter++));
				
				//load the request
				hcRequest.setArrayPlatform((ArrayPlatformType)hcArrayPlatformCombo.getSelectedItem());
				
				String clusterByStr = hcClusterByGroup.getSelection().getActionCommand();
				
				hcRequest.setClusterBy(ClusterByType.valueOf(clusterByStr));
				hcRequest.setArrayPlatform((ArrayPlatformType)hcArrayPlatformCombo.getSelectedItem());
				hcRequest.setDistanceMatrix((DistanceMatrixType)hcaDistanceMatrixCombo.getSelectedItem());
				hcRequest.setLinkageMethod((LinkageMethodType)hcaLinkageMethodCombo.getSelectedItem());
			    hcRequest.setVarianceFilterValue(Double.parseDouble(hcaVarianceFilterTF.getText()));
				
				//get reporter group			    
				String reporterIds = hcReporterIdsTF.getText();
				if ((reporterIds != null) && (reporterIds.trim().length() > 0)) {
				  ReporterGroup reporters = new ReporterGroup();
				  StringTokenizer t = new StringTokenizer(reporterIds.trim(), ",");
				  while (t.hasMoreTokens()) {
				    reporters.add(t.nextToken().trim());
				  }
				  hcRequest.setReporterGroup(reporters);
				}
				
				
				String sampleIds = hcSampleIdsTF.getText();
				if ((sampleIds != null) && (sampleIds.trim().length() > 0)) {
				  SampleGroup samples = new SampleGroup();
				  StringTokenizer t = new StringTokenizer(sampleIds.trim(), ",");
				  while (t.hasMoreTokens()) {
				    samples.add(t.nextToken().trim());
				  }
				  hcRequest.setSampleGroup(samples);
				}
				
				
				//send the request
				try {
					sendRequest(hcRequest);
				} catch (JMSException e1) {
					e1.printStackTrace(System.out);
				}
			}
        	 
         });
         
         hcButtonPanel.add(hcSubmitButton);
         hcRequestPanel.add(hcButtonPanel, BorderLayout.SOUTH);
         JPanel hcaRequestCenterPanel = new JPanel();
         hcaVarianceFilterTF.setText("0.9");
         //hcaFoldChangeFilterTF.setBorder(new TitledBorder("Fold Change Threshold"));
     	 hcReporterIdsTF.setBorder(new TitledBorder("Reporter Ids"));
     	 hcSampleIdsTF.setBorder(new TitledBorder("Sample Ids"));
     	 hcaDistanceMatrixCombo.addItem(DistanceMatrixType.Correlation);
     	 hcaDistanceMatrixCombo.addItem(DistanceMatrixType.Euclidean);
     	 hcaDistanceMatrixCombo.setBorder(new TitledBorder("Distance Matrix"));
     	 hcaRequestCenterPanel.setLayout(new BoxLayout(hcaRequestCenterPanel, BoxLayout.Y_AXIS ));
     	 //hcaRequestCenterPanel.add(hcaFoldChangeFilterTF);
     	 JPanel hcaReq1Panel = new JPanel();
     	 hcaReq1Panel.add(new JLabel("Reporter Variance Constraint:"));
     	 hcaReq1Panel.add(hcaVarianceFilterTF);
     	 hcaLinkageMethodCombo.addItem(LinkageMethodType.Average);
     	 hcaLinkageMethodCombo.addItem(LinkageMethodType.Single);
     	 hcaLinkageMethodCombo.addItem(LinkageMethodType.Complete);
     	 hcaLinkageMethodCombo.setBorder(new TitledBorder("Linkage Method"));
     	 hcaReq1Panel.add(hcaLinkageMethodCombo);
     	 //hcaReq1Panel.add(hcaReporterIdsTF);
     	
     	 hcaRequestCenterPanel.add(hcReporterIdsTF);
     	 hcaRequestCenterPanel.add(hcSampleIdsTF);
     	 hcaRequestCenterPanel.add(hcaReq1Panel);
     	 //hcaRequestCenterPanel.add(hcaDistanceMatrixCombo);
     	 hcRequestPanel.add(hcaRequestCenterPanel, BorderLayout.CENTER);
     	 
     	 
     	 JRadioButton hcaClusterByGenes = new JRadioButton("genes");
     	 hcaClusterByGenes.setActionCommand("Genes");
     	 JRadioButton hcaClusterBySamples = new JRadioButton("samples");
     	 hcaClusterBySamples.setActionCommand("Samples");
     	 
     	 
     	 hcClusterByGroup.add(hcaClusterByGenes);
     	 hcClusterByGroup.add(hcaClusterBySamples);
     	 
     	 hcClusterByGroup.setSelected(hcaClusterBySamples.getModel(), true);
     	 hcClusterByGroup.setSelected(hcaClusterByGenes.getModel(), false);
     	 
     	 JPanel clusterByPanel = new JPanel();
     	 
     	 hcArrayPlatformCombo.addItem(ArrayPlatformType.AFFY_OLIGO_PLATFORM);
    	 hcArrayPlatformCombo.addItem(ArrayPlatformType.CDNA_ARRAY_PLATFORM);
    	 hcArrayPlatformCombo.setBorder(new TitledBorder("Array Platform"));
    	 //clusterByPanel.add(hcaFoldChangeFilterTF);
     	 clusterByPanel.add(hcaDistanceMatrixCombo);
    	 clusterByPanel.add(hcArrayPlatformCombo);
     	 clusterByPanel.add(new JLabel("Cluster by"));
     	 clusterByPanel.add(hcaClusterByGenes);
     	 clusterByPanel.add(hcaClusterBySamples);
     	 
     	 hcaRequestCenterPanel.add(clusterByPanel);
     	 
	}
	  
	
	private void buildPCAGui(JTabbedPane tabbedPane) {
		  JSplitPane pcaSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		  tabbedPane.addTab("Principal Component Analysis", pcaSplitPane);
		     
          JPanel pcaRequestPanel = new JPanel(new BorderLayout());
          JPanel pcaResponsePanel = new JPanel();
          pcaResponsePanel.setLayout(new BoxLayout(pcaResponsePanel, BoxLayout.Y_AXIS));
          
          pcaSplitPane.add(pcaRequestPanel, JSplitPane.TOP);
          pcaSplitPane.add(pcaResponsePanel, JSplitPane.BOTTOM);
          
          
          //build the pcaRequstPanel
          JPanel pcaButtonPanel = new JPanel();
          JPanel pcaReqCenterPanel = new JPanel();
          JPanel pcaParamPanel = new JPanel();
          
          
          BoxLayout bl = new BoxLayout(pcaReqCenterPanel, BoxLayout.Y_AXIS);
          pcaReqCenterPanel.setLayout(bl);
            
          JComboBox pcaPlatform = new JComboBox();
          ArrayPlatformType[] platforms = ArrayPlatformType.values();
          for (int i=0; i < platforms.length; i++) {
            pcaPlatform.addItem(platforms[i]);
          }
          pcaVarianceFilterTF.setBorder(new TitledBorder("Variance Filter Value:"));
          pcaVarianceFilterTF.setText("0.9");
          pcaFoldChangeFilterTF.setBorder(new TitledBorder("Fold Change Filter Value:"));
          pcaFoldChangeFilterTF.setText("");
          pcaPlatform.setBorder(new TitledBorder("Platform"));
          pcaParamPanel.add(pcaPlatform);
          pcaParamPanel.add(pcaVarianceFilterTF);
          pcaParamPanel.add(pcaFoldChangeFilterTF);
          pcaReqCenterPanel.add(pcaParamPanel);
          
          pcaReporterIdsTF.setBorder(new TitledBorder("Reporter List:"));
          pcaReqCenterPanel.add(pcaReporterIdsTF);
          pcaSampleIdsTF.setBorder(new TitledBorder("Sample List:"));
          pcaReqCenterPanel.add(pcaSampleIdsTF);
          JButton pcaSubmitButton = new JButton("Submit");
          pcaButtonPanel.add(pcaSubmitButton);
          pcaRequestPanel.add(pcaButtonPanel, BorderLayout.SOUTH);
          pcaRequestPanel.add(pcaReqCenterPanel, BorderLayout.CENTER);
          
          pcaSubmitButton.addActionListener(new ActionListener() {
        	  public void actionPerformed(ActionEvent event) {
        	     System.out.println("Sending PCA request.");
        	     PrincipalComponentAnalysisRequest req = new PrincipalComponentAnalysisRequest(Integer.toString(1234),Integer.toString(pcaCounter++));
			     req.setRequestStartTime(System.currentTimeMillis());
			     if (pcaVarianceFilterTF.getText().trim().length() > 0) {
			       double varianceFilterValue = Double.parseDouble(pcaVarianceFilterTF.getText());
			       req.setVarianceFilterValue(varianceFilterValue);
			     }
			     else if (pcaFoldChangeFilterTF.getText().trim().length() > 0) {
			       double foldChangeFilterValue = Double.parseDouble(pcaFoldChangeFilterTF.getText()); 
			       req.setFoldChangeFilterValue(foldChangeFilterValue);
			     }
			     
			     //load the reporter group if reporters are specified
			     String reporterIds = pcaReporterIdsTF.getText();
			     if ((reporterIds!= null)&&(reporterIds.trim().length() > 0)) {
			       ReporterGroup reporterGroup = new ReporterGroup();
			       StringTokenizer t = new StringTokenizer(reporterIds, ",");
			       String reporterId;
			       while (t.hasMoreTokens()) {
			    	 reporterId = t.nextToken().trim();
			    	 reporterGroup.add(reporterId);
			       }
			       req.setReporterGroup(reporterGroup);
			     }
			    	 
			     //load the sample group if samples are specified.
			     //in the final application samples must always be specified
			     String sampleIds = pcaSampleIdsTF.getText();
			     if ((sampleIds!= null)&&(sampleIds.trim().length() > 0)) {
			       SampleGroup sampleGroup = new SampleGroup("");
			       StringTokenizer t = new StringTokenizer(sampleIds, ",");
			       String sampleId;
			       while (t.hasMoreTokens()) {
			    	 sampleId = t.nextToken().trim();
			    	 sampleGroup.add(sampleId);
			       }
			       req.setSampleGroup(sampleGroup);
			     }
			     
			     try {
					sendRequest(req);
			     }
				 catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				 }      
        	  }
          });
          
          //fill out the response part 
          JSplitPane pcaResponseSP = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
          JTable pcaResultTable = new JTable(pcaTableModel);
          JScrollPane pcaResultTableSP = new JScrollPane(pcaResultTable);
          pcaResponseSP.add(pcaResultTableSP, JSplitPane.TOP);
          
          pca3Dviz.addLegend("SOUTH");
          pca3Dviz.setEditable(true);
          pca3Dviz.setNotable(true);

          pcaImages = new JPanel();
          pcaImages.add(pca3Dviz);
          pcaImages.add(pcaImage1);
    	  pcaImages.add(pcaImage2);
    	  pcaImages.add(pcaImage3);
          BoxLayout bl2 = new BoxLayout(pcaImages, BoxLayout.Y_AXIS);
          pcaImages.setLayout(bl2);
          JScrollPane imageSP = new JScrollPane(pcaImages);
          pcaResponseSP.add(imageSP, JSplitPane.BOTTOM);
          pcaResponsePanel.add(pcaResponseSP);
	  }
	  
	  private void buildAndShowGui() {
		  frame = new JFrame("Submitter Client");
          //JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
          frame.addWindowListener(new WindowAdapter() { // just do we can close the window
              public void windowClosing(WindowEvent e) { System.exit(0); }
          });
          frame.setLayout(new BorderLayout());
          
           
          JTabbedPane tabbedPane = new JTabbedPane();
          frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
          
        
          //PCA
          buildPCAGui(tabbedPane);
         
          //HCA
          buildHCGui(tabbedPane);
          
          //Class Comparison
          buildCCGui(tabbedPane);
            
          
          frame.setPreferredSize(new Dimension(500,800));
          frame.pack();
          frame.setVisible(true); 
		  
	  }
	  
	  

	public static void main(String[] args) {
		  try {
			 
			  
			  org.apache.log4j.BasicConfigurator.configure();  

		    // Create the HelloPublisher, giving it the name of the
		    // TopicConnection Factory and the Topic destination to
		    // use in lookup.
		    AnalysisSubmitter submitter = new AnalysisSubmitter(
		      // Name of ConnectionFactory
		      "ConnectionFactory");
		    
		    submitter.buildAndShowGui();
		    
		    } catch(Exception ex) {

		    System.err.println(
		      "An exception occurred while testing AnalysisSubmitter: " + ex);
		    ex.printStackTrace();

		    }
	  }
	
	private class CCtableModel extends AbstractTableModel {
		  
		  private String[] defaultColumnNames = {"Reporter Id", "Mean Group1", "Mean Group2", "Mean Diff", "Fold Change", "P-Value" };
		  private String group1Name = "Group 1";
		  private String group2Name = "Group 2";
		  private List<ClassComparisonResultEntry> ccResultEntries = new ArrayList<ClassComparisonResultEntry>();
		  private ClassComparisonResult result;
		  private DecimalFormat fmt = new DecimalFormat("0.###E0");
		  
		  public CCtableModel() {
			
		  }
		  
		  public void setCCdata(ClassComparisonResult result) {
		     this.result = result;
		     this.ccResultEntries = result.getResultEntries();
		     this.fireTableDataChanged();
		     this.fireTableStructureChanged();
		  }
		  
		  public String getColumnName(int col) {
			  
			  if (result == null) {
				//no result set yet so just return   
				return defaultColumnNames[col];  
			  }
			  
			  switch(col) {
				  case 0: return "Reporter Id";
				  case 1: return "Mean " + result.getGroup1().getGroupName();
				  case 2:
					  if (result.getGroup2() != null) {
					    return "Mean " + result.getGroup2().getGroupName();
					  }
					  return "";
				  
				  case 3: return "Mean Diff";
				  case 4: return "Fold Change";
				  case 5: 
					  if (result.arePvaluesAdjusted()) {
					    return "Adjusted P-Value";
					  }
					  return "P-Value";
			  }
			  return "";
		  }
		  
		  
		  public int getRowCount() { 
			 if (ccResultEntries == null) return 0;  
			 
			 return ccResultEntries.size();
		  }
		  
		  public int getColumnCount() { return 6; }
		  
		  public Object getValueAt(int row, int col) {
			  
			    if (ccResultEntries.isEmpty()) return null;
			  
			    ClassComparisonResultEntry resultEntry = ccResultEntries.get(row);
		        if (col == 0) {
		          return resultEntry.getReporterId();
		        }
			    if (col == 1) {
		          return fmt.format(resultEntry.getMeanGrp1());
		        }
		        else if (col == 2) {
		          return fmt.format(resultEntry.getMeanGrp2());
		        }
		        else if (col == 3) {
		          return fmt.format(resultEntry.getMeanDiff());
		        }
		        else if (col == 4) {
		          return fmt.format(resultEntry.getFoldChange());
		        }
		        else if (col == 5) {
		          return fmt.format(resultEntry.getPvalue());
		        }
		        return null;
		  }
		  
		  public boolean isCellEditable(int row, int col)
		        { return false; }

		  public String getGroup1Name() {
			return group1Name;
		  }

		  public void setGroup1Name(String group1Name) {
			this.group1Name = group1Name;
		  }

		  public String getGroup2Name() {
			return group2Name;
		  }

		  public void setGroup2Name(String group2Name) {
			this.group2Name = group2Name;
		  }
		    
		   
		  
	  }
	
	  private class PCAtableModel extends AbstractTableModel {
		  
		  private String[] columnNames = {"SampleId", "PC1", "PC2", "PC3" }; 
		  private List<PCAresultEntry> pcaResults = new ArrayList<PCAresultEntry>();
		  
		  
		  public PCAtableModel() {
			
		  }
		  
		  public void setPCAdata(List<PCAresultEntry> pcaResults) {
		     this.pcaResults = pcaResults;
		     this.fireTableDataChanged();
		  }
		  
		  public String getColumnName(int col) {
		      return columnNames[col];
		  }
		  
		  public int getRowCount() { return pcaResults.size(); }
		  
		  public int getColumnCount() { return columnNames.length; }
		  
		  public Object getValueAt(int row, int col) {
			    PCAresultEntry resultEntry = pcaResults.get(row);
		        if (col == 0) {
		          return resultEntry.getSampleId();
		        }
		        else if (col == 1) {
		          return resultEntry.getPc1();
		        }
		        else if (col == 2) {
		          return resultEntry.getPc2();
		        }
		        else if (col == 3) {
		          return resultEntry.getPc3();
		        }
		        return null;
		  }
		  
		  public boolean isCellEditable(int row, int col)
		        { return false; }
		    
		   
		  
	  }
	  
	  public class ImagePanel extends JPanel {
	      private Image image;
		  
//	      public ImagePanel(Image image) {
//	        setImage(image);
//	      }
	      
	      public void paintComponent(Graphics g) {
	    	  super.paintComponent(g);
	    	  Graphics2D g2d = (Graphics2D) g;
	    	  g2d.drawImage(image,0,0, this);
	      }

		  public Image getImage() {
			return image;
		  }
		  
		  public void setImage(Image image, int width, int height) {
		    this.image = image;
		    Dimension dim = new Dimension(width, height);
		    this.setPreferredSize(dim);
		    this.setSize(dim);
		    this.setMinimumSize(dim);
		    this.setMaximumSize(dim);
		  }

		  public void setImage(Image image) {
			setImage(image, 450,450);
		  }
		  
	  }

	public void onException(JMSException jmsException) {
	  System.out.println("Caught JMS exception: " + jmsException.getMessage());
	  System.out.println("Stack trace:");
	  jmsException.printStackTrace(System.out);
	}

}
