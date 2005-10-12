package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.*;
import gov.nih.nci.caintegrator.exceptions.AnalysisServerException;

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
import java.util.*;

/**
 * This class implements the analysis server module.
 * 
 * @author Michael A. Harris
 * 
 * 
 * AnalysisServer should register handlers which are specifed from a
 * configuration file.
 */
public class AnalysisServer implements MessageListener, AnalysisResultSender {

	public static String version = "2.5";

	private boolean debugRcommands = false;

	
	private static String JBossMQ_locationIp = "156.40.128.136:1099"; // my machine
																		
	private static int numComputeThreads = 1;

	private static String RserverIp = "156.40.134.31"; // cbiodev501

	private static String RdataFileName = "/h1/harrismic/Rembrandt/RdataFiles/dataAndFunctions.R";

	private RThreadPoolExecutor executor;

	/**
	 * Topic connection, hold on to this so you may close it.
	 */
	private QueueConnection queueConnection;

	private Queue requestQueue;

	private Queue resultQueue;

	/**
	 * Topic session, hold on to this so you may close it. Also used to create
	 * messages.
	 */
	// TopicSession topicSession;
	private QueueSession queueSession;

	/**
	 * Subscriber
	 */
	// TopicSubscriber topicSubscriber;
	private QueueReceiver requestReceiver;

	private QueueSender resultSender;

	/**
	 * Destination to subscribe to
	 */
	// Topic topic;
	/**
	 * Sets up all the JMS fixtures.
	 * 
	 * Use close() when finished with object.
	 * 
	 * @param factoryJNDI
	 *            name of the topic connection factory to look up.
	 * @param topicJNDI
	 *            name of the topic destination to look up
	 */
	public AnalysisServer(String factoryJNDI, String serverPropertiesFileName) throws JMSException,
			NamingException {

		// load properties from a properties file
		Properties analysisServerConfigProps = new Properties();

		try {
			analysisServerConfigProps.load(new FileInputStream(
					serverPropertiesFileName));
			JBossMQ_locationIp = analysisServerConfigProps
					.getProperty("jmsmq_location");
			RserverIp = analysisServerConfigProps
					.getProperty("rserve_location");
			numComputeThreads = Integer.parseInt(analysisServerConfigProps
					.getProperty("num_compute_threads"));
			RdataFileName = analysisServerConfigProps
					.getProperty("RdefinitionFile");
			debugRcommands = Boolean.parseBoolean(analysisServerConfigProps
					.getProperty("debugRcommands"));
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

		// Get the initial context with given properties
		Context context = new InitialContext(props);

		requestQueue = (Queue) context.lookup("queue/AnalysisRequest");
		resultQueue = (Queue) context.lookup("queue/AnalysisResponse");
		QueueConnectionFactory qcf = (QueueConnectionFactory) context
				.lookup(factoryJNDI);

		queueConnection = qcf.createQueueConnection();

		queueSession = queueConnection.createQueueSession(false,
				QueueSession.AUTO_ACKNOWLEDGE);

		requestReceiver = queueSession.createReceiver(requestQueue);

		requestReceiver.setMessageListener(this);

		resultSender = queueSession.createSender(resultQueue);

		// initialize the compute threads
		
		executor = new RThreadPoolExecutor(numComputeThreads, RserverIp,
				RdataFileName, this);
		
		executor.setDebugRcommmands(debugRcommands);
		
		queueConnection.start();

		System.out.println("AnalysisServer version=" + version
				+ " successfully initialized. numComputeThreads=" + numComputeThreads + " RserverIp=" + RserverIp + " RdataFileName=" + RdataFileName);
		System.out.println("Now listening for requests...");

	}

	public AnalysisServer(String factoryJNDI) throws JMSException,
	NamingException {
	  this(factoryJNDI, "analysisServer.properties");
	}

	/**
	 * Implementation of the MessageListener interface, messages will be
	 * received through this method.
	 */
	public void onMessage(Message m) {

		// Unpack the message, be careful when casting to the correct
		// message type. onMessage should not throw any application
		// exceptions.
		try {

			// String msg = ((TextMessage)m).getText();
			ObjectMessage msg = (ObjectMessage) m;
			AnalysisRequest request = (AnalysisRequest) msg.getObject();
			System.out.println("AnalysisProcessor got request: " + request);

			if (request instanceof ClassComparisonRequest) {
				processClassComparisonRequest((ClassComparisonRequest) request);
			} else if (request instanceof HierarchicalClusteringRequest) {
				processHierarchicalClusteringRequest((HierarchicalClusteringRequest) request);
			} else if (request instanceof PrincipalComponentAnalysisRequest) {
				processPrincipalComponentAnalysisRequest((PrincipalComponentAnalysisRequest) request);
			}

			// sendResult(request);

		} catch (JMSException ex) {

			System.err.println("AnalysisProcessor exception: " + ex);
			ex.printStackTrace();

		}

	}

	
	/**
	 * Process a class comparison analysis request.
	 * 
	 * @param ccRequest
	 */
	public void processClassComparisonRequest(ClassComparisonRequest ccRequest) {
		executor.execute(new ClassComparisonTaskR(ccRequest, true));
	}

	/**
	 * Process a hierarchicalClusteringAnalysisRequest.
	 * 
	 * @param hcRequest
	 */
	public void processHierarchicalClusteringRequest(
			HierarchicalClusteringRequest hcRequest) {
		executor.execute(new HierarchicalClusteringTaskR(hcRequest, true));
	}

	/**
	 * Process a PrincipalComponentAnalysisRequest.
	 * 
	 * @param pcaRequest
	 */
	public void processPrincipalComponentAnalysisRequest(
			PrincipalComponentAnalysisRequest pcaRequest) {
		executor.execute(new PrincipalComponentAnalysisTaskR(pcaRequest, true));
	}

	public void sendException(AnalysisServerException analysisServerException) {
		try {
			System.out
					.println("AnalysisServer sending AnalysisServerException sessionId="
							+ analysisServerException.getFailedRequest()
									.getSessionId()
							+ " taskId="
							+ analysisServerException.getFailedRequest()
									.getTaskId() + " msg=" + analysisServerException.getMessage());
			ObjectMessage msg = queueSession
					.createObjectMessage(analysisServerException);
			resultSender.send(msg, DeliveryMode.NON_PERSISTENT,
					Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);
		} catch (JMSException ex) {
			ex.printStackTrace(System.out);
		}
	}

	

	public void sendResult(AnalysisResult result) {

		try {
//			System.out
//					.println("AnalysisServer sending result for sessionId="
//							+ result.getSessionId() + " taskId="
//							+ result.getTaskId());
			ObjectMessage msg = queueSession.createObjectMessage(result);
			resultSender.send(msg, DeliveryMode.NON_PERSISTENT,
					Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);
		} catch (JMSException ex) {
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
	 * Run an example subscribing to topic testTopic. Only works up to and
	 * including JBoss 2.4.0
	 */
	public static void main(String[] args) {

		try {
			if (args.length > 0) {
			  String serverPropsFile = args[0];
			  AnalysisServer server = new AnalysisServer("ConnectionFactory", serverPropsFile);
			}
			else {
			  AnalysisServer server = new AnalysisServer("ConnectionFactory");
			}
		} 
		catch (Exception ex) {

			System.err
					.println("An exception occurred while testing AnalysisProcessor: "
							+ ex);
			ex.printStackTrace();

		}

	}

}
