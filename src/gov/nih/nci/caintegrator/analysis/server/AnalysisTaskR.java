package gov.nih.nci.caintegrator.analysis.server;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.*;


import org.rosuda.JRclient.REXP;
import org.rosuda.JRclient.RFileInputStream;
import org.rosuda.JRclient.RSrvException;
import org.rosuda.JRclient.Rconnection;

import gov.nih.nci.caintegrator.analysis.messaging.AnalysisRequest;
import gov.nih.nci.caintegrator.analysis.messaging.IdGroup;

public abstract class AnalysisTaskR extends AnalysisTask {

	private Rconnection rConnection = null;

	private boolean debugRcommands = false;

	public AnalysisTaskR(AnalysisRequest request) {
		super(request);
	}

	public AnalysisTaskR(AnalysisRequest request, boolean debugRcommands) {
		super(request);
		this.debugRcommands = debugRcommands;
	}

	/**
	 * The run method implemented in each of the subclasses will call
	 * getRconnection() to get a connection to the Rserve and perform the
	 * computation.
	 */
	public abstract void run();

	public void setRconnection(Rconnection connection) {
		this.rConnection = connection;
	}

	public Rconnection getRconnection() {
		return rConnection;
	}

	public boolean getDebugRcommands() {
		return debugRcommands;
	}

	public void setDebugRcommands(boolean debugRcommands) {
		this.debugRcommands = debugRcommands;
	}

	/**
	 * Evaluate an R command with no return value
	 * 
	 * @param c
	 * @param command
	 */
	protected void doRvoidEval(String command) {
		if (debugRcommands) {
			System.out.println(command);
		}
		try {
			rConnection.voidEval(command);
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
	protected REXP doREval(String command) {
		REXP returnVal = null;
		try {
			if (debugRcommands) {
				System.out.println(command);
			}
			returnVal = rConnection.eval(command);
		} catch (RSrvException e) {
			e.printStackTrace(System.out);
		}
		return returnVal;
	}

	public static String getQuotedString(String inputStr) {
		return "\"" + inputStr + "\"";
	}

	/**
	 * This method will take a SampleGroup and generate the R command for to
	 * create the sampleId list. The returned lists can then be used as input
	 * parameters to the statistical methods (for example ttest).
	 * 
	 * @param group
	 * @return
	 */
	public static String getRgroupCmd(String rName, IdGroup group) {
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
	
	public Image getImage(String plotCmd) {
		
		byte[] imgCode = getImageCode(plotCmd);
		
		Image img = Toolkit.getDefaultToolkit().createImage(imgCode);
		
		return img;
		
	}

	/**
	 * Get the byte representation of the image created with the plot command.
	 * May be able to change this to return a Java Image object.
	 * 
	 * @param request
	 * @param plotCmd
	 * @return
	 */
	public byte[] getImageCode(String plotCmd) {

		byte[] imgCode = new byte[0];

		try {
			String fileName = "image_" + getRequest().getSessionId() + "_"
					+ getRequest().getTaskId() + "_"
					+ System.currentTimeMillis() + ".bmp";
			REXP xp = null;

			// bitmap(file, type = "png256", height = 6, width = 6, res = 72,
			// pointsize, ...)

			xp = doREval("try(bitmap(\"" + fileName
					+ "\", height = 3, width = 3, res = 250 ))");

			if (xp.asString() != null) { // if there's a string then we have
											// a problem, R sent an error
				System.out.println("Can't pen bitmat graphics device:\n"
						+ xp.asString());
				// this is analogous to 'warnings', but for us it's sufficient
				// to get just the 1st warning
				REXP w = doREval("if (exists(\"last.warning\") && length(last.warning)>0) names(last.warning)[1] else 0");
				if (w.asString() != null)
					System.out.println(w.asString());
				return new byte[0];
			}

			// ok, so the device should be fine - let's plot
			doRvoidEval(plotCmd);
			doRvoidEval("dev.off()");

			
			RFileInputStream is = rConnection.openFile(fileName);
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
			rConnection.removeFile(fileName);
		} catch (IOException ex) {
			ex.printStackTrace(System.out);
		} catch (RSrvException e) {
			e.printStackTrace(System.out);
		}

		return imgCode;

	}
}
