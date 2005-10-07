package gov.nih.nci.caintegrator.analysis.server;

import org.rosuda.JRclient.*;

public class RThread extends Thread {

	private String rServeIp;

	private String rDataFileName;

	private Rconnection rConnection;

	// public RThread() {
	// super();
	// // TODO Auto-generated constructor stub
	// }

	public RThread(Runnable target, String rServeIp, String rDataFileName) {
		super(target);
		this.rServeIp = rServeIp;
		this.rDataFileName = rDataFileName;
		initializeRconnection();
		System.out.println("RThread name=" + getName()
				+ " successfully initialized R connection.");
	}

	public void initializeRconnection() {
		// load the test matrix and function definitions
		try {
			rConnection = new Rconnection(rServeIp);

			String rCmd;
			// System.out.println("Server vesion: "+c.getServerVersion());
			long start, elapsedtime;
			if (rConnection.needLogin()) { // if server requires
											// authentication, send one
				System.out.println("authentication required.");
				rConnection.login("guest", "guest");
			}

			// System.out.println("\tInitializing the Rserver with data and
			// functions");

			start = System.currentTimeMillis();

			rCmd = "source(\"" + rDataFileName + "\")";
			rConnection.voidEval(rCmd);
			elapsedtime = System.currentTimeMillis() - start;
			System.out
					.println("\tDone initializing Rserver connection elapsedTime="
							+ elapsedtime);

		} catch (RSrvException rse) {
			System.out.println("Rserve exception: " + rse.getMessage());
		} catch (Exception e) {
			System.out
					.println("Something went wrong, but it's not the Rserve: "
							+ e.getMessage());
			e.printStackTrace();
		}
	}

	public Rconnection getRconnection() {
		return rConnection;
	}

	// public RThread(ThreadGroup group, Runnable target) {
	// super(group, target);
	// // TODO Auto-generated constructor stub
	// }

	// public RThread(String name) {
	// super(name);
	// // TODO Auto-generated constructor stub
	// }
	//
	// public RThread(ThreadGroup group, String name) {
	// super(group, name);
	// // TODO Auto-generated constructor stub
	// }
	//
	// public RThread(Runnable target, String name) {
	// super(target, name);
	// // TODO Auto-generated constructor stub
	// }
	//
	// public RThread(ThreadGroup group, Runnable target,
	// String name) {
	// super(group, target, name);
	// // TODO Auto-generated constructor stub
	// }

	// public RThread(ThreadGroup group, Runnable target,
	// String name, long stackSize) {
	// super(group, target, name, stackSize);
	// // TODO Auto-generated constructor stub
	// }

	public String getRDataFileName() {
		return rDataFileName;
	}

	// public void setRDataFileName(String dataFileName) {
	// rDataFileName = dataFileName;
	// }

	public String getRServeIp() {
		return rServeIp;
	}

	public void setRServeIp(String serveIp) {
		rServeIp = serveIp;
	}

	public void finalize() {
		rConnection.close();
		try {
			super.finalize();
		} catch (Throwable e) {
			e.printStackTrace(System.out);
		}
	}

	// public void setRdataFileName(String dataFileName) {
	// // TODO Auto-generated method stub
	//		
	// }

}
