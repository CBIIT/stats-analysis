package gov.nih.nci.caintegrator.analysis.messaging;

import java.io.Serializable;

/**
 * A collection of PCAentries is passed back from the analysis module to the middle tier
 * This collection represents the results from a PCA analysis call to the analysis module.
 * 
 * @author Michael A. Harris
 *
 */
public class PCAresultEntry implements Serializable {

	private static final long serialVersionUID = -2386991282555858152L;
	
	private double pc1, pc2, pc3;
	private String sampleId;
	
	public PCAresultEntry(String sampleId, double pc1, double pc2, double pc3) {
		this.sampleId = sampleId;
		this.pc1 = pc1;
		this.pc2 = pc2;
		this.pc3 = pc3;
	}

	public String getSampleId() {
		return sampleId;
	}

	public double getPc1() {
		return pc1;
	}

	public double getPc2() {
		return pc2;
	}

	public double getPc3() {
		return pc3;
	}

	public String toCommaDelimitedString() {
	  return sampleId +"," + pc1 + "," + pc2 + "," + pc3;
	}
}
