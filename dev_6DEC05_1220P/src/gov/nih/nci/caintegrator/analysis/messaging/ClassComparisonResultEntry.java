package gov.nih.nci.caintegrator.analysis.messaging;


/**
 * An array of ClassComparisonResultEntries is returned in a ClassComparisonAnalysisResult object
 * @author Michael A. Harris
 *
 */
public class ClassComparisonResultEntry implements java.io.Serializable {

	private static final long serialVersionUID = 1502121870957007356L;
	
	private String reporterId;
	private double meanGrp1;
	private double meanGrp2;
	private double meanDiff;
	private double foldChange;
	private double pvalue;
	
	public ClassComparisonResultEntry() {
		super();
	}

	public double getFoldChange() {
		return foldChange;
	}

	public void setFoldChange(double foldChange) {
		this.foldChange = foldChange;
	}

	public double getMeanDiff() {
		return meanDiff;
	}

	public void setMeanDiff(double meanDiff) {
		this.meanDiff = meanDiff;
	}

	public double getMeanGrp1() {
		return meanGrp1;
	}

	public void setMeanGrp1(double meanGrp1) {
		this.meanGrp1 = meanGrp1;
	}

	public double getMeanGrp2() {
		return meanGrp2;
	}

	public void setMeanGrp2(double meanGrp2) {
		this.meanGrp2 = meanGrp2;
	}

	public double getPvalue() {
		return pvalue;
	}

	public void setPvalue(double pvalue) {
		this.pvalue = pvalue;
	}

	public String getReporterId() {
		return reporterId;
	}

	public void setReporterId(String reporterId) {
		this.reporterId = reporterId;
	}

}
