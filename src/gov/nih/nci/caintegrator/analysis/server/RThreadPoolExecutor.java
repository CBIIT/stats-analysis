package gov.nih.nci.caintegrator.analysis.server;

import java.util.concurrent.*;
import org.rosuda.JRclient.Rconnection;

public class RThreadPoolExecutor extends ThreadPoolExecutor {

	private AnalysisResultSender sender;

	public RThreadPoolExecutor(int nThreads, String RserveIp, String RdataFile,
			AnalysisResultSender sender) {

		// create a new fixed thread pool
		super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(), new RThreadFactory(
						RserveIp, RdataFile));

		this.sender = sender;

		prestartAllCoreThreads();
	}

	protected void beforeExecute(RThread thread, AnalysisTaskR task) {
		System.out.println("Thread name=" + thread.getName()
				+ " executing task=" + task);
		task.setExecutingThreadName(thread.getName());
		task.setRconnection(thread.getRconnection());
		super.beforeExecute(thread, task);
	}

	protected void afterExecute(AnalysisTaskR task, Throwable throwable) {
		task.setExecutingThreadName("");
		task.cleanUp();
		sender.sendResult(task.getResult());
	}

}
