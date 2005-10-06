package gov.nih.nci.caintegrator.analysis.server;

import java.util.concurrent.*;

public class RThreadPoolExecutor extends ThreadPoolExecutor {

	private AnalysisResultSender sender;
	
	public RThreadPoolExecutor(int nThreads, String RserveIp, String RdataFile, AnalysisResultSender sender) {
		
		
		//create a new fixed thread pool
		super(nThreads, nThreads, 0L, TimeUnit.MILLISECONDS, 
				 new LinkedBlockingQueue<Runnable>(), new RThreadFactory(RserveIp, RdataFile));
		
		this.sender = sender;
		
		prestartAllCoreThreads();
	}
	
	protected void beforeExecute(RThread thread, AnalysisTaskR task)  {
	
		task.setRconnection(thread.getRconnection());
		super.beforeExecute(thread, task);
	}
	
	protected void afterExecute(AnalysisTask task, Throwable throwable) {
	  sender.sendResult(task.getResult());
	}
	
	
	
}
