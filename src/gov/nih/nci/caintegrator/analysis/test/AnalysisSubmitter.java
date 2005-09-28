package gov.nih.nci.caintegrator.analysis.test;

import gov.nih.nci.caintegrator.analysis.messaging.*;
import gov.nih.nci.caintegrator.exceptions.AnalysisServerException;
import static gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonAnalysisRequest.*;

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
import javax.jms.Session;
import javax.jms.JMSException;
import javax.jms.DeliveryMode;

import org.apache.log4j.Logger;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.*;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.table.*;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.text.DecimalFormat;

/**
 * This class tests submitting a request to the analysis server 
 * via JMS
 * @author Michael A. Harris
 *
 */
public class AnalysisSubmitter implements MessageListener {

	private static Logger logger = Logger.getLogger(AnalysisSubmitter.class);
    private static String appLocationIp = "156.40.128.136:1099";
	private static Map requestMap = new HashMap();
	
	private PCAtableModel pcaTableModel = new PCAtableModel();
	private CCtableModel ccTableModel = new CCtableModel();
	//private ImagePanel pcaImagePanel = new ImagePanel();
	private JPanel pcaImages = new JPanel();
	private int pcaCounter = 1;
	private int ccCounter = 1;
	private QueueConnection queueConnection;

	private JTextField pcaVarianceFilterTF = new JTextField(12);
	private JTextField pcaFoldChangeFilterTF = new JTextField(12);
	private JTextField pcaReporterIdsTF = new JTextField(20);
	private JTextField pcaSampleIdsTF = new JTextField(20);
	private ImagePanel pcaImage1 = new ImagePanel();
	private ImagePanel pcaImage2 = new ImagePanel();
	private ImagePanel pcaImage3 = new ImagePanel();

	
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

	    // Create the session
	    queueSession = queueConnection.createQueueSession(
	      // No transaction
	      false,
	      // Auto ack
	      Session.AUTO_ACKNOWLEDGE);

	    // Look up the destination
	    requestQueue = (Queue)context.lookup("queue/AnalysisRequest");
	    resultQueue = (Queue)context.lookup("queue/AnalysisResponse");

	    // Create a publisher
	    requestSender = queueSession.createSender(requestQueue);
		resultReceiver = queueSession.createReceiver(resultQueue);
		resultReceiver.setMessageListener(this);
		queueConnection.start();
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
	  
	      if (result instanceof ClassComparisonAnalysisResult) {
	        processCCresult((ClassComparisonAnalysisResult)result); 
	      }
	      else if (result instanceof HierarchicalClusteringAnalysisResult) {
	    	processHCAresult((HierarchicalClusteringAnalysisResult) result);
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

	private void processPCAresult(PrincipalComponentAnalysisResult result) {
		  System.out.println("Proccessing PCA result=" + result);
		  pcaTableModel.setPCAdata(result.getResultEntries());
		  
		  //create the image from the PCA data
		  byte[] img1Bytes = result.getImage1Bytes();
		  byte[] img2Bytes = result.getImage2Bytes();
		  byte[] img3Bytes = result.getImage3Bytes();
		  
		  Image img1 = Toolkit.getDefaultToolkit().createImage(img1Bytes);
		  Image img2 = Toolkit.getDefaultToolkit().createImage(img2Bytes);
		  Image img3 = Toolkit.getDefaultToolkit().createImage(img3Bytes);
		  		  
		  pcaImage1.setImage(img1);
		  pcaImage2.setImage(img2);
		  pcaImage3.setImage(img3);
		 		    
		  pcaImages.repaint();
	  }
	  
	  private void processHCAresult(HierarchicalClusteringAnalysisResult result) {
		  System.out.println("Processing HCA result=" + result);
		  
	  }
	  
	  private void processCCresult(ClassComparisonAnalysisResult result) {
		 System.out.println("Processiong CC result=" + result);  
		 ccTableModel.setCCdata(result); 
	  }
	
	/**
	   * Publish the given String as a JMS message to the testTopic topic.
	   */
	  public void sendRequest(AnalysisRequest request) throws JMSException {
  
	    // Create a message
	    ObjectMessage msg = queueSession.createObjectMessage(request);
	

	    // Publish the message
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
			  ClassComparisonAnalysisRequest ccRequest = new ClassComparisonAnalysisRequest(Integer.toString(4567),Integer.toString(ccCounter++));
				
			  //fill out the request
			  ccRequest.setStatisticalMethod((StatisticalMethodType)ccStatisticalMethodCombo.getSelectedItem());
			  ccRequest.setComparisonAdjustmentMethod((ComparisonAdjustmentMethod)ccComparisonAdjCombo.getSelectedItem());
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
          ccStatisticalMethodCombo.addItem(ClassComparisonAnalysisRequest.StatisticalMethodType.TTest);
          ccStatisticalMethodCombo.addItem(ClassComparisonAnalysisRequest.StatisticalMethodType.Wilcox);
          ccStatisticalMethodCombo.setBorder(new TitledBorder("Statistical Method"));
          ccRequestCenterPanel.add(ccStatisticalMethodCombo);
          
          ccComparisonAdjCombo.addItem(ComparisonAdjustmentMethod.NONE);
          ccComparisonAdjCombo.addItem(ComparisonAdjustmentMethod.FDR);
          ccComparisonAdjCombo.addItem(ComparisonAdjustmentMethod.FWER);
          ccComparisonAdjCombo.setBorder(new TitledBorder("Multiple Comparison Adjustment"));
          ccRequestCenterPanel.add(ccComparisonAdjCombo);
          ccComparisonAdjCombo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			  ComparisonAdjustmentMethod adjMethod = (ComparisonAdjustmentMethod)ccComparisonAdjCombo.getSelectedItem();
			  TitledBorder border = (TitledBorder) ccPvalueFilterTF.getBorder();
			  if (adjMethod == ComparisonAdjustmentMethod.NONE) {
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
          
          ccArrayPlatformCombo.addItem(ArrayPlatformType.AFFYMETRICS);
          ccArrayPlatformCombo.addItem(ArrayPlatformType.CDNA);
          ccArrayPlatformCombo.setBorder(new TitledBorder("Array Platform"));
          ccRequestCenterPanel.add(ccArrayPlatformCombo);
          
          JSplitPane ccResponseSP = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
          JTable ccResultTable = new JTable(ccTableModel);
          JScrollPane ccResultTableSP = new JScrollPane(ccResultTable);
          ccResponseSP.add(ccResultTableSP, JSplitPane.TOP);
          ccResponsePanel.add(ccResponseSP);
		
	}

	private void buildHCAGui(JTabbedPane tabbedPane) {
		 JSplitPane hcaSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		 tabbedPane.addTab("Hierarchical Clustering", hcaSplitPane);
		 
		 JPanel hcaRequestPanel = new JPanel(new BorderLayout());
		 JPanel hcaResponsePanel = new JPanel();
		 
		 hcaSplitPane.add(hcaRequestPanel, JSplitPane.TOP);
		 hcaSplitPane.add(hcaResponsePanel, JSplitPane.BOTTOM);
		 
         JPanel hcaButtonPanel = new JPanel();
         JButton hcaSubmitButton = new JButton("Submit");
         hcaButtonPanel.add(hcaSubmitButton);
         hcaRequestPanel.add(hcaButtonPanel, BorderLayout.SOUTH);
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
          
          
          String[] platforms = {"Affy", "Cdna" };
          JComboBox pcaPlatform = new JComboBox(platforms);
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
        	     requestMap.put(new Integer(req.getTaskId()), req);
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
          
          pcaImages = new JPanel();
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
          buildHCAGui(tabbedPane);
          
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
		  private ClassComparisonAnalysisResult result;
		  private DecimalFormat fmt = new DecimalFormat("0.###E0");
		  
		  public CCtableModel() {
			
		  }
		  
		  public void setCCdata(ClassComparisonAnalysisResult result) {
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
		  
		  
		  public int getRowCount() { return ccResultEntries.size(); }
		  
		  public int getColumnCount() { return 6; }
		  
		  public Object getValueAt(int row, int col) {
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

		  public void setImage(Image image) {
			this.image = image;
			//this.prepareImage(image, 200, 200, this);
			Dimension dim = new Dimension(450, 450);
			System.out.println("Setting image size to dim=" + dim);
			this.setPreferredSize(dim);
			this.setSize(dim);
			this.setMinimumSize(dim);
			this.setMaximumSize(dim);
		  }
		  
	  }

}
