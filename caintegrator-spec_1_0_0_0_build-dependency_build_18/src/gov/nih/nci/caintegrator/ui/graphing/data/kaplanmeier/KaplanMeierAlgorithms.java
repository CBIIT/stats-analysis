/*
 * Created on Oct 12, 2004
 */
package gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import org.apache.log4j.Logger;
import weka.core.Statistics;

/**
 * @author XiaoN
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

public class KaplanMeierAlgorithms {

	private ArrayList<KaplanMeierSampleInfo> allSamples;
	private ArrayList<KaplanMeierSampleInfo> upSamples;
	private ArrayList<KaplanMeierSampleInfo> intSamples;
	private ArrayList<KaplanMeierSampleInfo> downSamples;
	private double myUpperThreshold;
	private double myLowerThreshold;
	private static Logger logger = Logger.getLogger(KaplanMeierAlgorithms.class);
	
	public KaplanMeierAlgorithms(KaplanMeierSampleInfo[] samples, double upperThreshold, double lowerThreshold) {
		allSamples = new ArrayList<KaplanMeierSampleInfo>();
		upSamples = new ArrayList<KaplanMeierSampleInfo>();
		downSamples = new ArrayList<KaplanMeierSampleInfo>();
		intSamples = new ArrayList<KaplanMeierSampleInfo>();
		allSamples.addAll(Arrays.asList(samples));
		Collections.sort(allSamples, new KaplanMeierSampleComparator());
		this.myUpperThreshold = upperThreshold;
		this.myLowerThreshold = lowerThreshold;
		createSampleGroups();
	}
	
	private void createSampleGroups() {
		upSamples.clear();
		intSamples.clear();
		downSamples.clear();
		for (int i = 0; i < allSamples.size(); i++) {
			KaplanMeierSampleInfo s = (KaplanMeierSampleInfo) allSamples.get(i);
			double value = s.getValue();
			if (value >= myUpperThreshold) {
				upSamples.add(s);
			} else if (value <= myLowerThreshold) {
				downSamples.add(s);
			} else {
				intSamples.add(s);
			}
		}
	}
	/*
	public void resetThresholds(double upper, double lower) {
		this.upperThreshold = upper;
		this.lowerThreshold = lower;
		createSampleGroups();
	}
	*/
	
	//create drawing data points for any set of sample
	public KaplanMeierPlotPoint[] getDrawingPoints(ArrayList<KaplanMeierSampleInfo> samples) {
		float surv = 1;
		float prevSurvTime = 0;
		float curSurvTime = 0;
		int d = 0;
		int r = samples.size();
		int left = samples.size();
		ArrayList<KaplanMeierPlotPoint> points = new ArrayList<KaplanMeierPlotPoint>();
		logger.debug("Sorted input data: ");
		for (int i = 0; i < samples.size(); i++) {
			curSurvTime = ((KaplanMeierSampleInfo) samples.get(i)).getTime();
			logger.debug("Survival time: " + curSurvTime + "\tcensor:"
					+ ((KaplanMeierSampleInfo) samples.get(i)).getCensor());
			if (curSurvTime > prevSurvTime) {
				if (d>0) { 
					points.add(new KaplanMeierPlotPoint(new Float(prevSurvTime), new Float(surv), false));
					surv = surv * (r-d)/r; 
					points.add(new KaplanMeierPlotPoint(new Float(prevSurvTime), new Float(surv), false));
				} else {
					points.add(new KaplanMeierPlotPoint(new Float(prevSurvTime), new Float(surv), true));
				}
				prevSurvTime = curSurvTime;
				d = 0;
				r = left;
			}
			if (((KaplanMeierSampleInfo) samples.get(i)).getCensor() == 1) {
				d++;
			}
			left--;
		}
		if (d>0) { 
			points.add(new KaplanMeierPlotPoint(new Float(prevSurvTime), new Float(surv), false));
			surv = surv * (r-d)/r; 
			points.add(new KaplanMeierPlotPoint(new Float(prevSurvTime), new Float(surv), false));
		} else {
			points.add(new KaplanMeierPlotPoint(new Float(prevSurvTime), new Float(surv), true));
		}
		KaplanMeierPlotPoint[] kmDrawingPoints = (KaplanMeierPlotPoint[]) points
				.toArray(new KaplanMeierPlotPoint[points.size()]);
		return kmDrawingPoints;
	}
	
	//compute the p-value between two sample series
	public double getLogRankPValue(Collection<KaplanMeierSampleInfo> group1, Collection<KaplanMeierSampleInfo> group2) {
		//need to
		ArrayList<KaplanMeierSampleInfo> samples = new ArrayList<KaplanMeierSampleInfo>();
		samples.addAll(group1);
		samples.addAll(group2);
		Collections.sort(samples, new KaplanMeierSampleComparator());
		float u = 0;
		float v = 0;
		float a = 0;
		float b = 0;
		float c = (float) group1.size();
		float d = (float) group2.size();
		float t = 0;
		for (int i = 0; i < samples.size(); i++) {
			KaplanMeierSampleInfo event = (KaplanMeierSampleInfo) samples.get(i);
			if (event.getTime() > t) {
				if (a+b > 0) {
					u += a - (a + b) * (a + c) / (a + b + c + d);
					v += (a + b) 
							* (c + d)
							* (a + c)
							* (b + d)
							/ ((a + b + c + d - 1) * 
									(Math.pow((a + b + c + d), 2)));
				}
				a = 0;
				b = 0;
				t = event.getTime();
			}
			if (group1.contains(event)) {
				if (event.getCensor() == 1) {
					a += 1;
				}
				c-=1;
			} else {
				if (event.getCensor() == 1) {
					b+=1;
				}
				d-=1;
			}
		}
		
		if ( (a > 0 | b > 0) & (a+b+c+d-1>0) ) {
			u += a - (a + b) * (a + c) / (a + b + c + d);
			v += (a + b) 
					* (c + d)
					* (a + c)
					* (b + d)
					/ ((a + b + c + d - 1) * 
							(Math.pow((a + b + c + d), 2)));
		}
		
		if (v > 0) {
			return Statistics.chiSquaredProbability(Math.pow(u, 2.0) / v, 1.0);
		} else {
			return -100.0;
		}
	}
	//compute the p-value for a sample series against the rest
	public double getLogRankPValue(Collection<KaplanMeierSampleInfo> group1) {
		ArrayList<KaplanMeierSampleInfo> rest = (ArrayList)allSamples.clone();
		rest.removeAll(group1);
		return getLogRankPValue(group1, rest);
	}
	
	/**
	 * Test code for this class
	 * @param args
	 */
	public static void main(String[] args) {
		double upper = 3.0;
		double lower = 1.0 / 3.0;
		ArrayList<KaplanMeierSampleInfo> kms = new ArrayList<KaplanMeierSampleInfo>();
		//create fake data
		kms.add(new KaplanMeierSampleInfo(1, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(2, 1, 0.1));
		kms.add(new KaplanMeierSampleInfo(3, 1, 0.1));
		kms.add(new KaplanMeierSampleInfo(3, 1, 3.5));
		kms.add(new KaplanMeierSampleInfo(4, 0, 1.5));
		kms.add(new KaplanMeierSampleInfo(4, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(5, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(6, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(7, 1, 3.5));
		kms.add(new KaplanMeierSampleInfo(8, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(9, 1, 8.5));
		kms.add(new KaplanMeierSampleInfo(10, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(11, 0, 0.05));
		kms.add(new KaplanMeierSampleInfo(12, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(13, 0, 0.05));
		kms.add(new KaplanMeierSampleInfo(21, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(22, 0, 0.1));
		kms.add(new KaplanMeierSampleInfo(23, 1, 0.1));
		kms.add(new KaplanMeierSampleInfo(23, 0, 3.5));
		kms.add(new KaplanMeierSampleInfo(24, 1, 1.5));
		kms.add(new KaplanMeierSampleInfo(24, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(25, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(26, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(27, 1, 3.5));
		kms.add(new KaplanMeierSampleInfo(28, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(29, 1, 8.5));
		kms.add(new KaplanMeierSampleInfo(30, 0, 0.5));
		kms.add(new KaplanMeierSampleInfo(31, 1, 0.05));
		kms.add(new KaplanMeierSampleInfo(32, 1, 0.5));
		kms.add(new KaplanMeierSampleInfo(33, 0, 0.05));
		KaplanMeierSampleInfo[] samples = new KaplanMeierSampleInfo[kms.size()];
		for (int j = 0; j < kms.size(); j++) {
			samples[j] = (KaplanMeierSampleInfo) kms.get(j);
			System.out.println("data" + j + ":" + samples[j].getValue());
		}
		System.out.println("Array size = " + samples.length);
		KaplanMeierAlgorithms km = new KaplanMeierAlgorithms(samples, upper, lower);
		//testing output of plotting points
		KaplanMeierPlotPoint[] points = km.getDrawingPoints(km.getAllSamples());
		System.out.println("\nAll Sample Output points: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].getX() + "\t" + points[i].getY()
					+ "\t" + points[i].isChecked());
		}
		points = km.getDrawingPoints(km.getDownSamples());
		System.out.println("\nDown-regulated Sample Output points: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].getX() + "\t" + points[i].getY()
					+ "\t" + points[i].isChecked());
		}
		points = km.getDrawingPoints(km.getUpSamples());
		System.out.println("\nUp-regulated Sample Output points: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].getX() + "\t" + points[i].getY()
					+ "\t" + points[i].isChecked());
		}
		points = km.getDrawingPoints(km.getIntSamples());
		System.out.println("\nIntermediate Sample Output points: ");
		for (int i = 0; i < points.length; i++) {
			System.out.println(points[i].getX() + "\t" + points[i].getY()
					+ "\t" + points[i].isChecked());
		}
		//testing calculation of p-values
		System.out.println("***up vs down"
				+ km.getLogRankPValue(km.getUpSamples(), km.getDownSamples()));
		System.out.println("***up vs int"
				+ km.getLogRankPValue(km.getUpSamples(), km.getIntSamples()));
		System.out.println("***int vs down"
				+ km.getLogRankPValue(km.getIntSamples(), km.getDownSamples()));
		
		System.out.println("***down vs up"
				+ km.getLogRankPValue(km.getDownSamples(), km.getUpSamples()));
		System.out.println("***int vs up"
				+ km.getLogRankPValue(km.getIntSamples(), km.getUpSamples()));
		System.out.println("***down vs int"
				+ km.getLogRankPValue(km.getDownSamples(), km.getIntSamples()));
		
		System.out.println("up" + km.getLogRankPValue(km.getUpSamples()));
		System.out.println("int" + km.getLogRankPValue(km.getIntSamples()));
		System.out.println("down" + km.getLogRankPValue(km.getDownSamples()));
		System.out.println("Number of samples in UP" + km.getUpSamples().size());
		System.out.println("Number of samples in INT"
				+ km.getIntSamples().size());
		System.out.println("Number of samples in DOWN"
				+ km.getDownSamples().size());
		
		
		
	}
	/**
	 * @return Returns the downSamples.
	 */
	public ArrayList<KaplanMeierSampleInfo> getDownSamples() {
		return downSamples;
	}
	/**
	 * @return Returns the intSamples.
	 */
	public ArrayList<KaplanMeierSampleInfo> getIntSamples() {
		return intSamples;
	}
	/**
	 * @return Returns the upSamples.
	 */
	public ArrayList<KaplanMeierSampleInfo> getUpSamples() {
		return upSamples;
	}
	/**
	 * @return Returns the allSamples.
	 */
	public ArrayList<KaplanMeierSampleInfo> getAllSamples() {
		return allSamples;
	}
	/**
	 * Made an inner class
	 * 
	 * @author BauerD
	 */
	private class KaplanMeierSampleComparator implements Comparator{
		public int compare(Object o1, Object o2) throws ClassCastException {
			int val;
			float i1 = ((KaplanMeierSampleInfo) o1).getTime();
			float i2 = ((KaplanMeierSampleInfo) o2).getTime();
			if (i1 > i2) {
				val = 1;
			} else if (i1 == i2) {
				val = 0;
			} else {
				val = -1;
			}
			return val;
		}
	}
}
