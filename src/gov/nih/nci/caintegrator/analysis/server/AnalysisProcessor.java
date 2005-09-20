package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.RserveConnectionPool;

import gov.nih.nci.caintegrator.analysis.messaging.*;

import org.rosuda.JRclient.RFileInputStream;
import org.rosuda.JRclient.RSrvException;
import org.rosuda.JRclient.Rconnection;
import org.rosuda.JRclient.REXP;


import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.Queue;
import javax.jms.QueueSession;
import javax.jms.QueueSender;
import javax.jms.QueueReceiver;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.jms.DeliveryMode;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This class implements the analysis server module.
 * 
 * @author Michael A. Harris
 *
 */
public class AnalysisProcessor implements MessageListener {

//	public AnalysisProcessor() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
//	public static void main(String[] args) {
//	  
//		
//	}
	
	private RserveConnectionPool connectionPool;
	private static String JBossMQ_locationIp = "156.40.128.136:1099";  //my machine	
	private static int numRserveConnections = 1;
	private static String RserverIp = "156.40.134.31"; //cbiodev501
	private static String RdataFileName = "/h1/harrismic/Rembrandt/RdataFiles/dataAndFunctions.R";
	  /**
	   * Topic connection, hold on to this so you may close it.
	   */
	  QueueConnection queueConnection;
	  Queue requestQueue;
	  Queue resultQueue;

	  /**
	   * Topic session, hold on to this so you may close it.
	   * Also used to create messages.
	   */
	  //TopicSession topicSession;
	  QueueSession queueSession;

	  /**
	   * Subscriber
	   */
	  //TopicSubscriber topicSubscriber;
	  QueueReceiver requestReceiver;
	  QueueSender resultSender;

	  /**
	   * Destination to subscribe to
	   */
	  //Topic topic;
	  
	  /**
	   * Sets up all the JMS fixtures.
	   *
	   * Use close() when finished with object.
	   *
	   * @param factoryJNDI name of the topic connection factory to look up.
	   * @param topicJNDI name of the topic destination to look up
	   */
	  public AnalysisProcessor(String factoryJNDI)  
	    throws JMSException, NamingException
	  {
		  
	    //load properties from a properties file
		Properties analysisServerConfigProps = new Properties();
		  
		try {
			analysisServerConfigProps.load(new FileInputStream("analysisServer.properties"));
			JBossMQ_locationIp = analysisServerConfigProps.getProperty("jmsmq_location");
			RserverIp = analysisServerConfigProps.getProperty("rserve_location");
			numRserveConnections = Integer.parseInt(analysisServerConfigProps.getProperty("RserveConnectionPoolSize"));
			RdataFileName = analysisServerConfigProps.getProperty("RdefinitionFile");
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		} catch (IOException e) {
			e.printStackTrace(System.out);
		}
		  
	    Hashtable props = new Hashtable();
		props.put(Context.INITIAL_CONTEXT_FACTORY,
		    "org.jnp.interfaces.NamingContextFactory");
		props.put(Context.PROVIDER_URL, JBossMQ_locationIp);
		props.put("java.naming.rmi.security.manager", "yes");
		props.put(Context.URL_PKG_PREFIXES, "org.jboss.naming");

		//Get the initial context with given properties
		Context context = new InitialContext(props);    
		
	    requestQueue = (Queue) context.lookup("queue/AnalysisRequest");
	    resultQueue = (Queue) context.lookup("queue/AnalysisResponse");
	    QueueConnectionFactory qcf = 
	    	(QueueConnectionFactory)context.lookup(factoryJNDI);
	    
	    queueConnection = qcf.createQueueConnection();
	    
	    queueSession = queueConnection.createQueueSession(false,
	    		                   QueueSession.AUTO_ACKNOWLEDGE);
	   
	    requestReceiver = queueSession.createReceiver(requestQueue);
	    
		requestReceiver.setMessageListener(this);
		
		resultSender = queueSession.createSender(resultQueue);
		
		queueConnection.start();
		
	    System.out.println("AnalysisProcessor: successfully started queue connection");
    
	    
	    //initialize Rserver connection
	    connectionPool = new RserveConnectionPool(numRserveConnections, RserverIp, RdataFileName);

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
	      AnalysisRequest request = (AnalysisRequest) msg.getObject();
	      System.out.println("AnalysisProcessor got request: " + request);
	      
	      if (request instanceof ClassComparisonAnalysisRequest) {
	        processClassComparisonRequest((ClassComparisonAnalysisRequest)request);
	      }
	      else if (request instanceof HierarchicalClusteringAnalysisRequest) {
	        processHierarchicalClusteringRequest((HierarchicalClusteringAnalysisRequest)request);
	      }
	      else if (request instanceof PrincipalComponentAnalysisRequest) {
	    	processPrincipalComponentAnalysisRequest((PrincipalComponentAnalysisRequest) request);
	      }
	      
	      //sendResult(request);

	    } catch(JMSException ex) {

	      System.err.println("AnalysisProcessor exception: " + ex);
	      ex.printStackTrace();

	    }

	  }
	  
	  /**
	   * Process a class comparison analysis request.
	   * @param ccRequest
	   */
	  public void processClassComparisonRequest(ClassComparisonAnalysisRequest ccRequest) {
	    System.out.println("Processing class comparison request."); 
		//call Rserve with the correct commands for class comparison
	    
	    
	  }
	  
	  /**
	   * Process a hierarchicalClusteringAnalysisRequest.
	   * @param hcRequest
	   */
	  public void processHierarchicalClusteringRequest(HierarchicalClusteringAnalysisRequest hcRequest) {
	    System.out.println("Processing hierarchical clustering analysis request");
	    //call Rserve with the correct commands
		  
	  }
	  
	  /**
	   * Process a PrincipalComponentAnalysisRequest.
	   * @param pcaRequest
	   */
	  public void processPrincipalComponentAnalysisRequest(PrincipalComponentAnalysisRequest pcaRequest) {
		
		//call Rserve with the correct commands
		Rconnection c = (Rconnection) connectionPool.checkOut();    
		
		//submit the pca request and get back the object
		try {
			double varianceFilterValue = pcaRequest.getVarianceFilterValue();
			System.out.println("Processing principal component analysis request varianceFilterVal=" + varianceFilterValue);
			
			c.voidEval("pcaResult <- computePCA(dataMatrix," + varianceFilterValue + " )");
			double[] pca1 = c.eval("pcaMatrixX <- pcaResult$x[,1]").asDoubleArray();
			double[] pca2 = c.eval("pcaMatrixY <- pcaResult$x[,2]").asDoubleArray();
			double[] pca3 = c.eval("pcaMatrixZ <- pcaResult$x[,3]").asDoubleArray();
			REXP exp =  c.eval("pcaLabels <- dimnames(pcaResult$x)");
			//System.out.println("Got back xVals.len=" + xVals.length + " yVals.len=" + yVals.length + " zVals.len=" + zVals.length);
			Vector labels = (Vector) exp.asVector();
			Vector sampleIds = ((REXP)(labels.get(0))).asVector();
			Vector pcaLabels =  ((REXP)(labels.get(1))).asVector();
			
			
			//String patientId = null;
			//REXP tmp;
//			System.out.println("  PatientIds: ");
//			for (Iterator i=patientIds.iterator(); i.hasNext(); ) {
//			  tmp = (REXP) i.next();
//			  patientId = tmp.asString();
//			  System.out.print(patientId);
//			  if (i.hasNext()) System.out.print("\t");
//			  else System.out.println();
//			}	
					
			PCAresultEntry[] pcaArray = new PCAresultEntry[sampleIds.size()];
			String sampleId = null;
			int index = 0;
			for (Iterator i=sampleIds.iterator(); i.hasNext(); ) {
			  sampleId = ((REXP)i.next()).asString();
			  pcaArray[index] = new PCAresultEntry(sampleId, pca1[index], pca2[index], pca3[index]);
			  index++;
			}
			
			PrincipalComponentAnalysisResult result = new PrincipalComponentAnalysisResult(pcaRequest.getSessionId(), pcaRequest.getTaskId());
			result.setPCAarray(pcaArray);
			
			
			//generate the pca1 vs pca2 image
			c.voidEval("maxComp1<-max(abs(pcaResult$x[,1]))");
			c.voidEval("maxComp2<-max(abs(pcaResult$x[,2]))");
			c.voidEval("xrange<-c(-maxComp1,maxComp1)");
			c.voidEval("yrange<-c(-maxComp1,maxComp1)");
			String plot1Cmd =  "plot(pcaResult$x[,1],pcaResult$x[,2],xlim=xrange,ylim=yrange,main=\"Component1 Vs Component2\",xlab=\"PC1\",ylab=\"PC2\",pch=20)";
			byte[] img1Code = getImageCode(c, pcaRequest, plot1Cmd);
			result.setImage1Bytes(img1Code);
			
			//generate the pca1 vs pca3 image
			//  xrange<-c(-maxComp1,maxComp1)
			//  yrange<-c(-maxComp1,maxComp1)
			String plot2Cmd = "plot(pcaResult$x[,1],pcaResult$x[,3],xlim=xrange,ylim=yrange,main=\"Component1 Vs Component3\",xlab=\"PC1\",ylab=\"PC3\",pch=20)";
			byte[] img2Code = getImageCode(c, pcaRequest, plot2Cmd); 
			result.setImage2Bytes(img2Code); 
			
			
			//generate the pca2 vs pca3 image
			c.voidEval("xrange<-c(-maxComp2,maxComp2)");
			c.voidEval("yrange<-c(-maxComp2,maxComp2)");	
			String plot3Cmd =  "plot(pcaResult$x[,2],pcaResult$x[,3],xlim=xrange,ylim=yrange,main=\"Component2 Vs Component3\",xlab=\"PC2\",ylab=\"PC3\",pch=20)";
			byte[] img3Code = getImageCode(c, pcaRequest, plot3Cmd);
			result.setImage3Bytes(img3Code);
			
			sendResult(result);
			
		} catch (RSrvException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
		   connectionPool.checkIn(c);
		}
		
	
		
	  }
	  
	  public String getHostName() {
        String hostname = "";
	    try {
	        InetAddress addr = InetAddress.getLocalHost();
	    
	        // Get IP Address
	        byte[] ipAddr = addr.getAddress();
	    
	        // Get hostname
	        hostname = addr.getHostName();
	    } catch (UnknownHostException e) {
	    }
	    return hostname;
	 }
	  
	 /**
	  * Get the byte representation of the image created with the plot command.
	  * @param request
	  * @param plotCmd
	  * @return
	  */ 
	 public byte[] getImageCode(Rconnection c, AnalysisRequest request, String plotCmd) {
	  
	   byte[] imgCode = new byte[0];
      
	   try {	  	 
	      String fileName = "image_" + request.getSessionId() + "_" + request.getTaskId() + ".bmp";
	      REXP xp = null;
	
		  xp = c.eval("try(bitmap(\"" + fileName + "\"))");
		  
	      if (xp.asString()!=null) { // if there's a string then we have a problem, R sent an error
	        System.out.println("Can't pen bitmat graphics device:\n"+xp.asString());
	        // this is analogous to 'warnings', but for us it's sufficient to get just the 1st warning
	        REXP w=c.eval("if (exists(\"last.warning\") && length(last.warning)>0) names(last.warning)[1] else 0");
	        if (w.asString()!=null) System.out.println(w.asString());
	              return new byte[0];
	      }
	         
	               
	       // ok, so the device should be fine - let's plot
	       c.voidEval(plotCmd);
	       c.voidEval("dev.off()");
	          
		    // the file should be ready now, so let's read (ok this isn't pretty, but hey, this ain't no beauty contest *grin* =)
	          // we read in chunks of bufSize (64k by default) and store the resulting byte arrays in a vector
	          // ... just in case the file gets really big ...
	          // we don't know the size in advance, because it's just a stream.
	          // also we can't rewind it, so we have to store it piece-by-piece
		    RFileInputStream is=c.openFile(fileName);
	        Vector buffers=new Vector();
	        int bufSize=65536;
		    byte[] buf=new byte[bufSize];
	        int imgLength=0;
	        int n=0;
	        while (true) {
	              n=is.read(buf);
	              if (n==bufSize) {
	                  buffers.addElement(buf);
	                  buf=new byte[bufSize];
	              }
	              if (n>0) imgLength+=n;
	              if (n<bufSize) break;
	          }
	          if (imgLength<10) { // this shouldn't be the case actually, beause we did some error checking, but for those paranoid ...
	              System.out.println("Cannot load image, check R output, probably R didn't produce anything.");
	              return new byte[0];
	          }
	          System.out.println("The image file is "+imgLength+" bytes big.");
	          
	          // now let's join all the chunks into one, big array ...
	          imgCode=new byte[imgLength];
	          int imgPos=0;
	          for (Enumeration e = buffers.elements() ; e.hasMoreElements() ;) {
	              byte[] b = (byte[]) e.nextElement();
	              System.arraycopy(b,0,imgCode,imgPos,bufSize);
	              imgPos+=bufSize;
	          }
	          if (n>0) System.arraycopy(buf,0,imgCode,imgPos,n);
	          
	          // ... and close the file ... and remove it - we have what we need :)
	          
	          is.close();
			
		
			  //c.removeFile(fileName);
      }
      catch (IOException ex) {
        ex.printStackTrace(System.out);
      }
      catch (RSrvException ex2) {
    	ex2.printStackTrace(System.out);
      }
		
	  return imgCode;
	    
	}
	  
	 public void sendResult(AnalysisResult result)  {
             
		  try {
		    System.out.println("AnalysisProcessor sending result for sessionId=" + result.getSessionId() + " taskId=" + result.getTaskId());
		    //long createStartTime = System.currentTimeMillis();
			//ClassComparisonAnalysisResult ccResult = new ClassComparisonAnalysisResult(result.getSessionId(),result.getTaskId(), request.getNumDoubles());
			//ccResult.setProcessorHost(System.getProperty("hostname"));
			
		    // Create a message
		    
		    //long createElapsedTime = System.currentTimeMillis() - createStartTime;
		    //ccResult.setResultObjCreateTime(createElapsedTime);
		    ObjectMessage msg = queueSession.createObjectMessage(result); 
		    // Publish the message
		    resultSender.send(msg, DeliveryMode.NON_PERSISTENT, Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);
		  }
		  catch (JMSException ex) {
		     ex.printStackTrace(System.out);
		  }
	  }

	  /**
	   * Close session and connection.
	   */
	  public void close() throws JMSException {

	    queueSession.close();
	    queueConnection.close();

	  }

	  /**
	   * Run an example subscribing to topic testTopic.
	   * Only works up to and including JBoss 2.4.0
	   */
	  public static void main(String[] args) {

	    try {

	      // Create the AnalysisProcessor, giving it the name of the
	      // TopicConnection Factory and the Topic destination to use in
	      // lookup.
	      AnalysisProcessor processor = new AnalysisProcessor(
	        // Name of ConnectionFactory
	        "ConnectionFactory");
	      //PrincipalComponentAnalysisRequest pcaReq = new PrincipalComponentAnalysisRequest(1234, 123);
	      //processor.processPrincipalComponentAnalysisRequest(pcaReq);
	      
	      
	        
	    } catch(Exception ex) {

	      System.err.println(
	        "An exception occurred while testing AnalysisProcessor: " + ex);
	      ex.printStackTrace();

	    }

	  }

}
