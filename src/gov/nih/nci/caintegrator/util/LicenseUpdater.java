package gov.nih.nci.caintegrator.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.*;


/**
 * @author caBIO Team
 * @version 1.0
 */




/**
* caIntegrator License
* 
* Copyright 2001-2005 Science Applications International Corporation ("SAIC"). 
* The software subject to this notice and license includes both human readable source code form and machine readable, 
* binary, object code form ("the caIntegrator Software"). The caIntegrator Software was developed in conjunction with 
* the National Cancer Institute ("NCI") by NCI employees and employees of SAIC. 
* To the extent government employees are authors, any rights in such works shall be subject to Title 17 of the United States
* Code, section 105. 
* This caIntegrator Software License (the "License") is between NCI and You. "You (or "Your") shall mean a person or an 
* entity, and all other entities that control, are controlled by, or are under common control with the entity. "Control" 
* for purposes of this definition means (i) the direct or indirect power to cause the direction or management of such entity,
*  whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) 
* beneficial ownership of such entity. 
* This License is granted provided that You agree to the conditions described below. NCI grants You a non-exclusive, 
* worldwide, perpetual, fully-paid-up, no-charge, irrevocable, transferable and royalty-free right and license in its rights 
* in the caIntegrator Software to (i) use, install, access, operate, execute, copy, modify, translate, market, publicly 
* display, publicly perform, and prepare derivative works of the caIntegrator Software; (ii) distribute and have distributed 
* to and by third parties the caIntegrator Software and any modifications and derivative works thereof; 
* and (iii) sublicense the foregoing rights set out in (i) and (ii) to third parties, including the right to license such 
* rights to further third parties. For sake of clarity, and not by way of limitation, NCI shall have no right of accounting
* or right of payment from You or Your sublicensees for the rights granted under this License. This License is granted at no
* charge to You. 
* 1. Your redistributions of the source code for the Software must retain the above copyright notice, this list of conditions
*    and the disclaimer and limitation of liability of Article 6, below. Your redistributions in object code form must reproduce 
*    the above copyright notice, this list of conditions and the disclaimer of Article 6 in the documentation and/or other materials
*    provided with the distribution, if any. 
* 2. Your end-user documentation included with the redistribution, if any, must include the following acknowledgment: "This 
*    product includes software developed by SAIC and the National Cancer Institute." If You do not include such end-user 
*    documentation, You shall include this acknowledgment in the Software itself, wherever such third-party acknowledgments 
*    normally appear.
* 3. You may not use the names "The National Cancer Institute", "NCI" "Science Applications International Corporation" and 
*    "SAIC" to endorse or promote products derived from this Software. This License does not authorize You to use any 
*    trademarks, service marks, trade names, logos or product names of either NCI or SAIC, except as required to comply with
*    the terms of this License. 
* 4. For sake of clarity, and not by way of limitation, You may incorporate this Software into Your proprietary programs and 
*    into any third party proprietary programs. However, if You incorporate the Software into third party proprietary 
*    programs, You agree that You are solely responsible for obtaining any permission from such third parties required to 
*    incorporate the Software into such third party proprietary programs and for informing Your sublicensees, including 
*    without limitation Your end-users, of their obligation to secure any required permissions from such third parties 
*    before incorporating the Software into such third party proprietary software programs. In the event that You fail 
*    to obtain such permissions, You agree to indemnify NCI for any claims against NCI by such third parties, except to 
*    the extent prohibited by law, resulting from Your failure to obtain such permissions. 
* 5. For sake of clarity, and not by way of limitation, You may add Your own copyright statement to Your modifications and 
*    to the derivative works, and You may provide additional or different license terms and conditions in Your sublicenses 
*    of modifications of the Software, or any derivative works of the Software as a whole, provided Your use, reproduction, 
*    and distribution of the Work otherwise complies with the conditions stated in this License.
* 6. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, 
*    THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. 
*    IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE, SAIC, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, 
*    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
*    GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
*    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
*    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
*/



/**
* caIntegrator License
* 
* Copyright 2001-2005 Science Applications International Corporation ("SAIC"). 
* The software subject to this notice and license includes both human readable source code form and machine readable, 
* binary, object code form ("the caIntegrator Software"). The caIntegrator Software was developed in conjunction with 
* the National Cancer Institute ("NCI") by NCI employees and employees of SAIC. 
* To the extent government employees are authors, any rights in such works shall be subject to Title 17 of the United States
* Code, section 105. 
* This caIntegrator Software License (the "License") is between NCI and You. "You (or "Your") shall mean a person or an 
* entity, and all other entities that control, are controlled by, or are under common control with the entity. "Control" 
* for purposes of this definition means (i) the direct or indirect power to cause the direction or management of such entity,
*  whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) 
* beneficial ownership of such entity. 
* This License is granted provided that You agree to the conditions described below. NCI grants You a non-exclusive, 
* worldwide, perpetual, fully-paid-up, no-charge, irrevocable, transferable and royalty-free right and license in its rights 
* in the caIntegrator Software to (i) use, install, access, operate, execute, copy, modify, translate, market, publicly 
* display, publicly perform, and prepare derivative works of the caIntegrator Software; (ii) distribute and have distributed 
* to and by third parties the caIntegrator Software and any modifications and derivative works thereof; 
* and (iii) sublicense the foregoing rights set out in (i) and (ii) to third parties, including the right to license such 
* rights to further third parties. For sake of clarity, and not by way of limitation, NCI shall have no right of accounting
* or right of payment from You or Your sublicensees for the rights granted under this License. This License is granted at no
* charge to You. 
* 1. Your redistributions of the source code for the Software must retain the above copyright notice, this list of conditions
*    and the disclaimer and limitation of liability of Article 6, below. Your redistributions in object code form must reproduce 
*    the above copyright notice, this list of conditions and the disclaimer of Article 6 in the documentation and/or other materials
*    provided with the distribution, if any. 
* 2. Your end-user documentation included with the redistribution, if any, must include the following acknowledgment: "This 
*    product includes software developed by SAIC and the National Cancer Institute." If You do not include such end-user 
*    documentation, You shall include this acknowledgment in the Software itself, wherever such third-party acknowledgments 
*    normally appear.
* 3. You may not use the names "The National Cancer Institute", "NCI" "Science Applications International Corporation" and 
*    "SAIC" to endorse or promote products derived from this Software. This License does not authorize You to use any 
*    trademarks, service marks, trade names, logos or product names of either NCI or SAIC, except as required to comply with
*    the terms of this License. 
* 4. For sake of clarity, and not by way of limitation, You may incorporate this Software into Your proprietary programs and 
*    into any third party proprietary programs. However, if You incorporate the Software into third party proprietary 
*    programs, You agree that You are solely responsible for obtaining any permission from such third parties required to 
*    incorporate the Software into such third party proprietary programs and for informing Your sublicensees, including 
*    without limitation Your end-users, of their obligation to secure any required permissions from such third parties 
*    before incorporating the Software into such third party proprietary software programs. In the event that You fail 
*    to obtain such permissions, You agree to indemnify NCI for any claims against NCI by such third parties, except to 
*    the extent prohibited by law, resulting from Your failure to obtain such permissions. 
* 5. For sake of clarity, and not by way of limitation, You may add Your own copyright statement to Your modifications and 
*    to the derivative works, and You may provide additional or different license terms and conditions in Your sublicenses 
*    of modifications of the Software, or any derivative works of the Software as a whole, provided Your use, reproduction, 
*    and distribution of the Work otherwise complies with the conditions stated in this License.
* 6. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, 
*    THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. 
*    IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE, SAIC, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, 
*    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
*    GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
*    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
*    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
*/

public class LicenseUpdater {

	private static Logger logger = Logger.getLogger(LicenseUpdater.class);

	private String _beginPattern;

	private String _endPattern;

	private String _outputDirName;

	private String _text;

	private String _logFileName;

	private Collection _files = new ArrayList();

	private FileWriter _log;

	/**
	 *
	 */
	public LicenseUpdater() {
		super();

	}

	public void setBeginPattern(String p_beginPattern) {
		_beginPattern = p_beginPattern;
	}

	public String getBeginPattern() {
		return _beginPattern;
	}

	public void setEndPattern(String p_endPattern) {
		_endPattern = p_endPattern;
	}

	public String getEndPattern() {
		return _endPattern;
	}

	public void setOutputDirName(String p_outputDirName) {
		_outputDirName = p_outputDirName;
	}

	public String getOutputDirName() {
		return _outputDirName;
	}

	public void setLogFileName(String p_logFileName) {
		_logFileName = p_logFileName;
	}

	public String getLogFileName() {
		return _logFileName;
	}

	public Collection getFiles() {
		return _files;
	}

	public void setText(String p_text) {
		_text = p_text;
	}

	public String getText() {
		return _text;
	}

	public void validate() throws IllegalStateException {
		if (_beginPattern == null) {
			logger.error("beginPattern not set");
			throw new IllegalStateException("beginPattern not set");
		}
		if (_endPattern == null) {
			logger.error("endPattern not set");
			throw new IllegalStateException("endPattern not set");
		}
		if (_text == null) {
			logger.error("text not set");
			throw new IllegalStateException("text not set");
		}
	}

	private void init() throws Exception {
		validate();
		if (_logFileName != null) {
			File f = new File(_logFileName);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			_log = new FileWriter(new File(_logFileName));
		}
	}

	public void run() throws Exception {
		init();
		log("Processing " + _files.size() + " files...");
		for (Iterator i = _files.iterator(); i.hasNext();) {
			File f = (File) i.next();
			//int beginLineNum = getLineNumber(f, getBeginPattern());
			int endLineNum = getLineNumber(f, getEndPattern());
			int beginLineNum = endLineNum-1;
			if (beginLineNum < 0) {
				log("No begin pattern: " + f.getAbsolutePath());
			} else if (endLineNum < 0) {
				log("No end pattern: " + f.getAbsolutePath());
			} else {
				File outFile = getOutFile(f, getOutputDirName());
				insertText(f, outFile, beginLineNum, endLineNum, getText());
			}
		}
		log("...done");
	}

	/**
	 * @param f
	 * @param outputDirName
	 * @return
	 */
	private File getOutFile(File f, String outputDirName) {
		File outFile = null;
		if (outputDirName == null) {
			outFile = f;
		} else {
			String currDir = (new File(".")).getAbsolutePath();
			String relDir = f.getParentFile().getAbsolutePath().substring(
					currDir.length() - 1);
			outFile = new File(outputDirName + "/" + relDir + "/" + f.getName());
			if (!outFile.getParentFile().exists()) {
				outFile.getParentFile().mkdirs();
			}
		}
		return outFile;
	}

	/**
	 * @param endPattern
	 * @return
	 */
	private int getLineNumber(File inFile, String pattern) {
		boolean found = false;
		int lineNum = 1;
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.indexOf(pattern) > -1) {
					found = true;
					break;
				}
				lineNum++;
			}
		} catch (Exception ex) {
			logger.error("Error reading file" + ex.getMessage());
			throw new RuntimeException("Error reading file", ex);
		}
		if (!found) {
			lineNum = -1;
		}
		return lineNum;
	}

	/**
	 * @param f
	 * @param beginPattern
	 * @param endPattern
	 * @param text
	 */
	private void insertText(File inFile, File outFile, int beginLineNum,
			int endLineNum, String text) {
		StringBuffer sb = new StringBuffer();
		StringBuffer upToInc = getUpToIncluding(inFile, beginLineNum);
		StringBuffer afterInc = getAfterIncluding(inFile, endLineNum);

		sb.append(upToInc);

		sb.append(text);
		if(!text.endsWith("\n")){
			sb.append("\n");
		}

		sb.append(afterInc);
		try {
			FileWriter out = new FileWriter(outFile);
			out.write(sb.toString());
			out.flush();
			out.close();
		} catch (Exception ex) {
			logger.error("Error writing " + ex.getMessage());
			throw new RuntimeException("Error writing", ex);
		}
	}

	/**
	 * @param inFile
	 * @param endLineNum
	 * @return
	 */
	private StringBuffer getAfterIncluding(File inFile, int endLineNum) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line = null;
			int lineNum = 1;
			while ((line = br.readLine()) != null) {
				if (lineNum >= endLineNum) {
					sb.append(line);
					sb.append("\n");
				}
				lineNum++;
			}
		} catch (Exception ex) {
			logger.error("Error reading file " + ex.getMessage());
			throw new RuntimeException("Error reading file", ex);
		}
		return sb;
	}

	/**
	 * @param inFile
	 * @param beginLineNum
	 * @return
	 */
	private StringBuffer getUpToIncluding(File inFile, int beginLineNum) {
		StringBuffer sb = new StringBuffer();
		try {
			BufferedReader br = new BufferedReader(new FileReader(inFile));
			String line = null;
			int lineNum = 1;
			while ((line = br.readLine()) != null && lineNum <= beginLineNum) {
				sb.append(line);
				sb.append("\n");
				lineNum++;
			}
		} catch (Exception ex) {
			logger.error("Error reading file "+ ex.getMessage());
			throw new RuntimeException("Error reading file", ex);
		}
		return sb;
	}

	private void log(String msg) {
		if (_log != null) {
			try {
				_log.write(msg + "\n");
				_log.flush();
			} catch (IOException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}

		} else {

		}
	}

	public void finalize() {
		if (_log != null) {
			try {
				_log.close();
			} catch (IOException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		try {
			LicenseUpdater lu = new LicenseUpdater();
			lu.setBeginPattern(args[0]);
			lu.setEndPattern(args[1]);
			lu.setOutputDirName(args[2]);
			lu.setText(args[3]);
			lu.setLogFileName(args[4]);
			lu.getFiles().add(new File(args[5]));
			lu.run();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}
}

