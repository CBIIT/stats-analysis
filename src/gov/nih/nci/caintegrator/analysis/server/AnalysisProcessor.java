package gov.nih.nci.caintegrator.analysis.server;

import gov.nih.nci.caintegrator.analysis.messaging.RserveConnectionPool;

import gov.nih.nci.caintegrator.analysis.messaging.*;
import gov.nih.nci.caintegrator.exceptions.AnalysisServerException;
import static gov.nih.nci.caintegrator.analysis.messaging.ClassComparisonRequest.*;
import static gov.nih.nci.caintegrator.analysis.messaging.HierarchicalClusteringRequest.*;

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

	// public AnalysisProcessor() {
	// super();
	// // TODO Auto-generated constructor stub
	// }
	//	
	// public static void main(String[] args) {
	//	  
	//		
	// }

	public static String version = "2.5";

	private boolean debugRcommands = false;

	private RserveConnectionPool connectionPool;

	private static String JBossMQ_locationIp = "156.40.128.136:1099"; // my
																		// machine

	private static int numRserveConnections = 1;

	private static String RserverIp = "156.40.134.31"; // cbiodev501

	private static String RdataFileName = "/h1/harrismic/Rembrandt/RdataFiles/dataAndFunctions.R";

	/**
	 * Topic connection, hold on to this so you may close it.
	 */
	QueueConnection queueConnection;

	Queue requestQueue;

	Queue resultQueue;

	/**
	 * Topic session, hold on to this so you may close it. Also used to create
	 * messages.
	 */
	// TopicSession topicSession;
	QueueSession queueSession;

	/**
	 * Subscriber
	 */
	// TopicSubscriber topicSubscriber;
	QueueReceiver requestReceiver;

	QueueSender resultSender;

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
	public AnalysisProcessor(String factoryJNDI) throws JMSException,
			NamingException {

		// load properties from a properties file
		Properties analysisServerConfigProps = new Properties();

		try {
			analysisServerConfigProps.load(new FileInputStream(
					"analysisServer.properties"));
			JBossMQ_locationIp = analysisServerConfigProps
					.getProperty("jmsmq_location");
			RserverIp = analysisServerConfigProps
					.getProperty("rserve_location");
			numRserveConnections = Integer.parseInt(analysisServerConfigProps
					.getProperty("RserveConnectionPoolSize"));
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

		queueConnection.start();

		// initialize Rserver connection
		connectionPool = new RserveConnectionPool(numRserveConnections,
				RserverIp, RdataFileName);

		System.out.println("AnalysisProcessor version=" + version
				+ " successfully initialized. Now listening for requests...");

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
	 * This method will take a SampleGroup and generate the R command for to
	 * create the sampleId list. The returned lists can then be used as input
	 * parameters to the statistical methods (for example ttest).
	 * 
	 * @param group
	 * @return
	 */
	private String getRgroupCmd(String rName, IdGroup group) {
		StringBuffer sb = new StringBuffer();
		sb.append(rName);
		sb.append(" <- c(");
		String id;
		for (Iterator i = group.iterator(); i.hasNext();) {
			id = (String) i.next();
			sb.append("\"").append(id).append("\"");
			if (i.hasNext()) {
				sb.append(",");
			} else {
				sb.append(")");
			}
		}
		return sb.toString();
	}

	/**
	 * Evaluate an R command with no return value
	 * 
	 * @param c
	 * @param command
	 */
	private void doRvoidEval(Rconnection c, String command) {
		if (debugRcommands) {
			System.out.println(command);
		}
		try {
			c.voidEval(command);
		} catch (RSrvException e) {
			e.printStackTrace(System.out);
		}
	}

	/**
	 * Execute an R command with a return value
	 * 
	 * @param c
	 * @param command
	 * @return
	 */
	private REXP doREval(Rconnection c, String command) {
		REXP returnVal = null;
		try {
			if (debugRcommands) {
				System.out.println(command);
			}
			returnVal = c.eval(command);
		} catch (RSrvException e) {
			e.printStackTrace(System.out);
		}
		return returnVal;
	}

	/**
	 * Process a class comparison analysis request.
	 * 
	 * @param ccRequest
	 */
	public void processClassComparisonRequest(ClassComparisonRequest ccRequest) {
		System.out.println("Processing class comparison request=" + ccRequest);

		Rconnection c = null;
		try {
			// call Rserve with the correct commands for class comparison
			c = (Rconnection) connectionPool.checkOut();

			if (c == null) {
				// should wait for connection and try again
				sendException(new AnalysisServerException(
						"processClassComparisonRequest could not get an Rconnection."));
				return;
			}

			int grp1Len = 0, grp2Len = 0;
			SampleGroup group1 = ccRequest.getGroup1();
			grp1Len = group1.size();
			SampleGroup group2 = ccRequest.getGroup2();
			String rCmd = null;
			rCmd = getRgroupCmd(group1.getGroupName(), group1);

			doRvoidEval(c, rCmd);

			if (group2 != null) {
				// two group comparison
				grp2Len = group2.size();
				rCmd = getRgroupCmd(group2.getGroupName(), group2);
				doRvoidEval(c, rCmd);

				// create the input data matrix using the sample groups
				rCmd = "ccInputMatrix <- getSubmatrix.twogrps(dataMatrix,"
						+ group1.getGroupName() + "," + group2.getGroupName()
						+ ")";
				doRvoidEval(c, rCmd);

				// check to make sure all identifiers matched in the R data file
				rCmd = "dim(ccInputMatrix)[2]";
				int numMatched = doREval(c, rCmd).asInt();
				if (numMatched != (grp1Len + grp2Len)) {
					AnalysisServerException ex = new AnalysisServerException(
							"Some sample ids did not match R data file for class comparison request.");
					ex.setFailedRequest(ccRequest);
					sendException(ex);
				}
			} else {
				// single group comparison
				grp2Len = 0;
				rCmd = "ccInputMatrix <- getSubmatrix.onegrp(dataMatrix,"
						+ group1.getGroupName() + ")";
				doRvoidEval(c, rCmd);
			}

			rCmd = "dim(ccInputMatrix)[2]";
			int numMatched = doREval(c, rCmd).asInt();
			if (numMatched != (grp1Len + grp2Len)) {
				AnalysisServerException ex = new AnalysisServerException(
						"Some sample ids did not match R data file for class comparison request.");
				ex.setFailedRequest(ccRequest);
				ex.setFailedRequest(ccRequest);
				throw ex;
			}

			if (ccRequest.getStatisticalMethod() == StatisticalMethodType.TTest) {
				// do the TTest computation
				rCmd = "ccResult <- myttest(ccInputMatrix, " + grp1Len + ","
						+ grp2Len + ")";
				doRvoidEval(c, rCmd);
			} else if (ccRequest.getStatisticalMethod() == StatisticalMethodType.Wilcox) {
				// do the Wilcox computation
				rCmd = "ccResult <- mywilcox(ccInputMatrix, " + grp1Len + ","
						+ grp2Len + ")";
				doRvoidEval(c, rCmd);
			}

			// Create the result to return
			ClassComparisonResult ccResult = new ClassComparisonResult(
					ccRequest.getSessionId(), ccRequest.getTaskId());

			// do filtering
			double foldChangeThreshold = ccRequest.getFoldChangeThreshold();
			double pValueThreshold = ccRequest.getPvalueThreshold();
			ComparisonAdjustmentMethod adjMethod = ccRequest
					.getComparisonAdjustmentMethod();
			if (adjMethod == ComparisonAdjustmentMethod.NONE) {
				// get differentially expressed reporters using
				// unadjusted Pvalue

				// shouldn't need to pass in ccInputMatrix
				rCmd = "ccResult  <- mydiferentiallygenes(ccResult,"
						+ foldChangeThreshold + "," + pValueThreshold + ")";
				doRvoidEval(c, rCmd);
				ccResult.setPvaluesAreAdjusted(false);
			} else if (adjMethod == ComparisonAdjustmentMethod.FDR) {
				// do adjustment
				rCmd = "adjust.result <- adjustP.Benjamini.Hochberg(ccResult)";
				doRvoidEval(c, rCmd);
				// get differentially expressed reporters using adjusted Pvalue
				rCmd = "ccResult  <- mydiferentiallygenes.adjustP(adjust.result,"
						+ foldChangeThreshold + "," + pValueThreshold + ")";
				doRvoidEval(c, rCmd);
				ccResult.setPvaluesAreAdjusted(true);
			} else if (adjMethod == ComparisonAdjustmentMethod.FWER) {
				// do adjustment
				rCmd = "adjust.result <- adjustP.Bonferroni(ccResult)";
				doRvoidEval(c, rCmd);
				// get differentially expresseed reporters using adjusted Pvalue
				rCmd = "ccResult  <- mydiferentiallygenes.adjustP(adjust.result,"
						+ foldChangeThreshold + "," + pValueThreshold + ")";
				doRvoidEval(c, rCmd);
				ccResult.setPvaluesAreAdjusted(true);
			}

			// get the results and send

			double[] meanGrp1 = doREval(c, "mean1 <- ccResult[,1]")
					.asDoubleArray();
			double[] meanGrp2 = doREval(c, "mean2 <- ccResult[,2]")
					.asDoubleArray();
			double[] meanDif = doREval(c, "meanDif <- ccResult[,3]")
					.asDoubleArray();
			double[] foldChange = doREval(c, "fc <- ccResult[,4]")
					.asDoubleArray();
			double[] pva = doREval(c, "pva <- ccResult[,5]").asDoubleArray();

			// get the labels
			Vector reporterIds = doREval(c,
					"ccLabels <- dimnames(ccResult)[[1]]").asVector();
			// Vector reporterIds = ((REXP)(labels.get(0))).asVector();
			// Vector columnLabels = ((REXP)(labels.get(1))).asVector();

			// load the result object
			// need to see if this works for single group comparison
			List<ClassComparisonResultEntry> resultEntries = new ArrayList<ClassComparisonResultEntry>(
					meanGrp1.length);
			ClassComparisonResultEntry resultEntry;

			for (int i = 0; i < meanGrp1.length; i++) {
				resultEntry = new ClassComparisonResultEntry();
				resultEntry.setReporterId(((REXP) reporterIds.get(i))
						.asString());
				resultEntry.setMeanGrp1(meanGrp1[i]);
				resultEntry.setMeanGrp2(meanGrp2[i]);
				resultEntry.setMeanDiff(meanDif[i]);
				resultEntry.setFoldChange(foldChange[i]);
				resultEntry.setPvalue(pva[i]);
				resultEntries.add(resultEntry);
			}

			ccResult.setResultEntries(resultEntries);

			ccResult.setGroup1(group1);
			if (group2 != null) {
				ccResult.setGroup2(group2);
			}

			ccResult.setProcessorHost(getHostName());
			sendResult(ccResult);
		} catch (AnalysisServerException ex) {
			sendException(ex);
		} finally {
			connectionPool.checkIn(c);
		}
	}

	private String getQuotedString(String inputStr) {
		return "\"" + inputStr + "\"";
	}

	/**
	 * Process a hierarchicalClusteringAnalysisRequest.
	 * 
	 * @param hcRequest
	 */
	public void processHierarchicalClusteringRequest(
			HierarchicalClusteringRequest hcRequest) {
		System.out
				.println("Processing hierarchical clustering analysis request="
						+ hcRequest);

		Rconnection c = (Rconnection) connectionPool.checkOut();

		if (c == null) {
			// should wait for connection and try again
			sendException(new AnalysisServerException(
					"processHierarchicalClusteringRequest could not get an Rconnection."));
			return;
		}

		// get the submatrix to operate on
		doRvoidEval(c, "hcInputMatrix <- dataMatrix");

		doRvoidEval(c, "hcInputMatrix <- GeneFilterWithVariance(hcInputMatrix,"
				+ hcRequest.getVarianceFilterValue() + ")");

		String rCmd = null;
		if (hcRequest.getSampleGroup() != null) {
			// sample group should never be null when passed from middle tier
			rCmd = getRgroupCmd("sampleIds", hcRequest.getSampleGroup());
			doRvoidEval(c, rCmd);
			rCmd = "hcInputMatrix <- getSubmatrix.onegrp(hcInputMatrix, sampleIds)";
			doRvoidEval(c, rCmd);
		}

		if (hcRequest.getReporterGroup() != null) {
			rCmd = getRgroupCmd("reporterIds", hcRequest.getReporterGroup());
			doRvoidEval(c, rCmd);
			rCmd = "hcInputMatrix <- getSubmatrix.rep(hcInputMatrix, reporterIds)";
			doRvoidEval(c, rCmd);
		}
		String plotCmd = null;
		// get the request parameters
		if (hcRequest.getClusterBy() == ClusterByType.Samples) {
			// cluster by samples
			rCmd = "mycluster <- mysamplecluster(hcInputMatrix,"
					+ getQuotedString(hcRequest.getDistanceMatrix().toString())
					+ ","
					+ getQuotedString(hcRequest.getLinkageMethod().toString())
					+ ")";
			doRvoidEval(c, rCmd);
			plotCmd = "plot(mycluster, labels=dimnames(hcInputMatrix)[[2]], xlab=\"\", ylab=\"\",cex=.5,sub=\"\", hang=-1)";
		} else if (hcRequest.getClusterBy() == ClusterByType.Genes) {
			// cluster by genes
			rCmd = "mycluster <- mygenecluster(hcInputMatrix,"
					+ getQuotedString(hcRequest.getDistanceMatrix().toString())
					+ ","
					+ getQuotedString(hcRequest.getLinkageMethod().toString())
					+ ")";
			doRvoidEval(c, rCmd);
			plotCmd = "plot(mycluster, labels=dimnames(hcInputMatrix)[[1]], xlab=\"\", ylab=\"\",cex=.5,sub=\"\", hang=-1)";
		}

		byte[] imgCode = getImageCode(c, hcRequest, plotCmd);

		HierarchicalClusteringResult result = new HierarchicalClusteringResult(
				hcRequest.getSessionId(), hcRequest.getTaskId());
		result.setImageCode(imgCode);
		sendResult(result);
		connectionPool.checkIn(c);

	}

	/**
	 * Process a PrincipalComponentAnalysisRequest.
	 * 
	 * @param pcaRequest
	 */
	public void processPrincipalComponentAnalysisRequest(
			PrincipalComponentAnalysisRequest pcaRequest) {

		// call Rserve with the correct commands
		Rconnection c = (Rconnection) connectionPool.checkOut();

		if (c == null) {
			// should wait for connection and try again
			sendException(new AnalysisServerException(
					"processPrincipalComponentAnalysisRequest could not get an Rconnection."));
			return;
		}

		// submit the pca request and get back the object

		double[] pca1, pca2, pca3;
		try {
			doRvoidEval(c, "pcaInputMatrix <- dataMatrix");

			if (pcaRequest.getSampleGroup() != null) {
				// sample group should never be null when passed from middle
				// tier
				String rCmd = getRgroupCmd("sampleIds", pcaRequest
						.getSampleGroup());
				doRvoidEval(c, rCmd);
				rCmd = "pcaInputMatrix <- getSubmatrix.onegrp(pcaInputMatrix, sampleIds)";
				doRvoidEval(c, rCmd);
			}

			if (pcaRequest.getReporterGroup() != null) {
				String rCmd = getRgroupCmd("reporterIds", pcaRequest
						.getReporterGroup());
				doRvoidEval(c, rCmd);
				rCmd = "pcaInputMatrix <- getSubmatrix.rep(pcaInputMatrix, reporterIds)";
				doRvoidEval(c, rCmd);
			}

			if (pcaRequest.doVarianceFiltering()) {
				double varianceFilterValue = pcaRequest
						.getVarianceFilterValue();
				System.out
						.println("Processing principal component analysis request varianceFilterVal="
								+ varianceFilterValue);
				doRvoidEval(c,
						"pcaResult <- computePCAwithVariance(pcaInputMatrix,"
								+ varianceFilterValue + " )");
			} else if (pcaRequest.doFoldChangeFiltering()) {
				double foldChangeFilterValue = pcaRequest
						.getFoldChangeFilterValue();
				System.out
						.println("Processing principal component analysis request foldChangeFilterVal="
								+ foldChangeFilterValue);
				doRvoidEval(c, "pcaResult <- computePCAwithFC(pcaInputMatrix,"
						+ foldChangeFilterValue + " )");
			}

			// check to make sure at least 3 components came back
			int numComponents = doREval(c, "length(pcaResult$x[1,])").asInt();
			if (numComponents < 3) {
				AnalysisServerException ex = new AnalysisServerException(
						"PCA result has less than 3 components.");
				ex.setFailedRequest(pcaRequest);
				throw ex;
			}

			pca1 = doREval(c, "pcaMatrixX <- pcaResult$x[,1]").asDoubleArray();
			pca2 = doREval(c, "pcaMatrixY <- pcaResult$x[,2]").asDoubleArray();
			pca3 = doREval(c, "pcaMatrixZ <- pcaResult$x[,3]").asDoubleArray();
			REXP exp = doREval(c, "pcaLabels <- dimnames(pcaResult$x)");
			// System.out.println("Got back xVals.len=" + xVals.length + "
			// yVals.len=" + yVals.length + " zVals.len=" + zVals.length);
			Vector labels = (Vector) exp.asVector();
			Vector sampleIds = ((REXP) (labels.get(0))).asVector();
			Vector pcaLabels = ((REXP) (labels.get(1))).asVector();

			List<PCAresultEntry> pcaResults = new ArrayList<PCAresultEntry>(
					sampleIds.size());
			// PCAresultEntry[] pcaArray = new PCAresultEntry[sampleIds.size()];
			String sampleId = null;
			int index = 0;
			for (Iterator i = sampleIds.iterator(); i.hasNext();) {
				sampleId = ((REXP) i.next()).asString();
				pcaResults.add(new PCAresultEntry(sampleId, pca1[index],
						pca2[index], pca3[index]));
				index++;
			}

			PrincipalComponentAnalysisResult result = new PrincipalComponentAnalysisResult(
					pcaRequest.getSessionId(), pcaRequest.getTaskId());
			result.setResultEntries(pcaResults);

			// generate the pca1 vs pca2 image
			doRvoidEval(c, "maxComp1<-max(abs(pcaResult$x[,1]))");
			doRvoidEval(c, "maxComp2<-max(abs(pcaResult$x[,2]))");
			doRvoidEval(c, "maxComp3<-max(abs(pcaResult$x[,3]))");
			doRvoidEval(c, "xrange<-c(-maxComp1,maxComp1)");
			doRvoidEval(c, "yrange<-c(-maxComp2,maxComp2)");
			String plot1Cmd = "plot(pcaResult$x[,1],pcaResult$x[,2],xlim=xrange,ylim=yrange,main=\"Component1 Vs Component2\",xlab=\"PC1\",ylab=\"PC2\",pch=20)";
			byte[] img1Code = getImageCode(c, pcaRequest, plot1Cmd);
			result.setImage1Bytes(img1Code);

			// generate the pca1 vs pca3 image
			doRvoidEval(c, "yrange<-c(-maxComp3,maxComp3)");
			String plot2Cmd = "plot(pcaResult$x[,1],pcaResult$x[,3],xlim=xrange,ylim=yrange,main=\"Component1 Vs Component3\",xlab=\"PC1\",ylab=\"PC3\",pch=20)";
			byte[] img2Code = getImageCode(c, pcaRequest, plot2Cmd);
			result.setImage2Bytes(img2Code);

			// generate the pca2 vs pca3 image
			doRvoidEval(c, "xrange<-c(-maxComp2,maxComp2)");
			doRvoidEval(c, "yrange<-c(-maxComp3,maxComp3)");
			String plot3Cmd = "plot(pcaResult$x[,2],pcaResult$x[,3],xlim=xrange,ylim=yrange,main=\"Component2 Vs Component3\",xlab=\"PC2\",ylab=\"PC3\",pch=20)";
			byte[] img3Code = getImageCode(c, pcaRequest, plot3Cmd);
			result.setImage3Bytes(img3Code);

			sendResult(result);
		} catch (AnalysisServerException ex) {
			sendException(ex);
		} finally {
			connectionPool.checkIn(c);
		}

	}

	private void sendException(AnalysisServerException analysisServerException) {
		try {
			System.out
					.println("AnalysisProcessor sending analysisServerException sessionId="
							+ analysisServerException.getFailedRequest()
									.getSessionId()
							+ " taskId="
							+ analysisServerException.getFailedRequest()
									.getTaskId());
			ObjectMessage msg = queueSession
					.createObjectMessage(analysisServerException);
			resultSender.send(msg, DeliveryMode.NON_PERSISTENT,
					Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE);
		} catch (JMSException ex) {
			ex.printStackTrace(System.out);
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
	 * 
	 * @param request
	 * @param plotCmd
	 * @return
	 */
	public byte[] getImageCode(Rconnection c, AnalysisRequest request,
			String plotCmd) {

		byte[] imgCode = new byte[0];

		try {
			String fileName = "image_" + request.getSessionId() + "_"
					+ request.getTaskId() + "_" + System.currentTimeMillis()
					+ ".bmp";
			REXP xp = null;

			// bitmap(file, type = "png256", height = 6, width = 6, res = 72,
			// pointsize, ...)

			xp = doREval(c, "try(bitmap(\"" + fileName
					+ "\", height = 3, width = 3, res = 250 ))");

			if (xp.asString() != null) { // if there's a string then we have
											// a problem, R sent an error
				System.out.println("Can't pen bitmat graphics device:\n"
						+ xp.asString());
				// this is analogous to 'warnings', but for us it's sufficient
				// to get just the 1st warning
				REXP w = doREval(
						c,
						"if (exists(\"last.warning\") && length(last.warning)>0) names(last.warning)[1] else 0");
				if (w.asString() != null)
					System.out.println(w.asString());
				return new byte[0];
			}

			// ok, so the device should be fine - let's plot
			doRvoidEval(c, plotCmd);
			doRvoidEval(c, "dev.off()");

			// the file should be ready now, so let's read (ok this isn't
			// pretty, but hey, this ain't no beauty contest *grin* =)
			// we read in chunks of bufSize (64k by default) and store the
			// resulting byte arrays in a vector
			// ... just in case the file gets really big ...
			// we don't know the size in advance, because it's just a stream.
			// also we can't rewind it, so we have to store it piece-by-piece
			RFileInputStream is = c.openFile(fileName);
			Vector buffers = new Vector();
			int bufSize = 65536;
			byte[] buf = new byte[bufSize];
			int imgLength = 0;
			int n = 0;
			while (true) {
				n = is.read(buf);
				if (n == bufSize) {
					buffers.addElement(buf);
					buf = new byte[bufSize];
				}
				if (n > 0)
					imgLength += n;
				if (n < bufSize)
					break;
			}
			if (imgLength < 10) { // this shouldn't be the case actually,
									// beause we did some error checking, but
									// for those paranoid ...
				System.out
						.println("Cannot load image, check R output, probably R didn't produce anything.");
				return new byte[0];
			}
			System.out
					.println("The image file is " + imgLength + " bytes big.");

			// now let's join all the chunks into one, big array ...
			imgCode = new byte[imgLength];
			int imgPos = 0;
			for (Enumeration e = buffers.elements(); e.hasMoreElements();) {
				byte[] b = (byte[]) e.nextElement();
				System.arraycopy(b, 0, imgCode, imgPos, bufSize);
				imgPos += bufSize;
			}
			if (n > 0)
				System.arraycopy(buf, 0, imgCode, imgPos, n);

			// ... and close the file ... and remove it - we have what we need
			// :)

			is.close();
			c.removeFile(fileName);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		} catch (RSrvException e) {
			e.printStackTrace(System.out);
		}

		return imgCode;

	}

	public void sendResult(AnalysisResult result) {

		try {
			System.out
					.println("AnalysisProcessor sending result for sessionId="
							+ result.getSessionId() + " taskId="
							+ result.getTaskId());
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
			AnalysisProcessor processor = new AnalysisProcessor(
			// Name of ConnectionFactory
					"ConnectionFactory");
		} catch (Exception ex) {

			System.err
					.println("An exception occurred while testing AnalysisProcessor: "
							+ ex);
			ex.printStackTrace();

		}

	}

}
