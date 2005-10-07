package gov.nih.nci.caintegrator.analysis.server;

import java.util.concurrent.*;
import org.rosuda.JRclient.Rconnection;

public class RThreadPoolExecutor extends ThreadPoolExecutor {

	private AnalysisResultSender sender;
	private boolean debugRcommands = false;

	public RThreadPoolExecutor(int nThreads, String RserveIp, String RdataFile,
			AnalysisResultSender sender) {

		// create a new fixed thread pool
		super(nThreads, nThreads, Long.MAX_VALUE, TimeUnit.NANOSECONDS,
				new LinkedBlockingQueue<Runnable>(), new RThreadFactory(
						RserveIp, RdataFile));

		this.sender = sender;

		prestartAllCoreThreads();
	}

	protected void beforeExecute(Thread thread, Runnable task) {
		
		AnalysisTaskR rTask = (AnalysisTaskR) task;
		RThread rThread = (RThread) thread;
		
		rTask.setExecutingThreadName(rThread.getName());
		rTask.setRconnection(rThread.getRconnection());
		rTask.setDebugRcommands(debugRcommands);
		
		super.beforeExecute(thread, task);
		
//		System.out.println("Thread name=" + rThread.getName()
//				+ " executing task=" + rTask);
	}

	protected void afterExecute(Runnable task, Throwable throwable) {
		
		AnalysisTaskR rTask = (AnalysisTaskR) task;
		
		rTask.setExecutingThreadName("");
		rTask.cleanUp();
		sender.sendResult(rTask.getResult());
	}

	public void setDebugRcommmands(boolean debugRcommands) {
	  this.debugRcommands = debugRcommands;
		
	}

}
