package gov.nih.nci.caintegrator.ui.graphing.data.kaplanmeier;

/**
 * @author XiaoN
 */
public class KaplanMeierSampleInfo {

	String sampleID; 
	int time; 
	int censor; //(0/1)
	double value; //Expr/CN value
	
	public KaplanMeierSampleInfo(String sampleID,int t, int c, double v) {
		setTime(t); 
		setCensor(c); 
		setValue(v); 
		setSampleID(sampleID);
	}
	
	public KaplanMeierSampleInfo(int t, int c, double v) {
		setTime(t); 
		setCensor(c); 
		setValue(v); 
	}
	/**
	 * @return Returns the censor.
	 */
	public int getCensor() {
		return censor;
	}
	/**
	 * @param censor The censor to set.
	 */
	public void setCensor(int censor) {
		this.censor = censor;
	}


	/**
	 * @return Returns the time.
	 */
	public int getTime() {
		return time;
	}
	/**
	 * @param time The time to set.
	 */
	public void setTime(int time) {
		this.time = time;
	}
	/**
	 * @return Returns the value.
	 */
	public double getValue() {
		return value;
	}
	/**
	 * @param value The value to set.
	 */
	public void setValue(double value) {
		this.value = value;
	}

	/**
	 * @return Returns the sampleID.
	 */
	public String getSampleID() {
		return sampleID;
	}

	/**
	 * @param sampleID The sampleID to set.
	 */
	public void setSampleID(String sampleID) {
		this.sampleID = sampleID;
	}
}
