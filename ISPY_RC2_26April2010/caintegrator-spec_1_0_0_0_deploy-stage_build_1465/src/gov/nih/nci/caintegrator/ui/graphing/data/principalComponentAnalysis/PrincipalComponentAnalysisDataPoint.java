package gov.nih.nci.caintegrator.ui.graphing.data.principalComponentAnalysis;

import gov.nih.nci.caintegrator.enumeration.GenderType;

public class PrincipalComponentAnalysisDataPoint {

	public static enum PCAcomponent { PC1, PC2, PC3 };
	private String sampleId;
	private String diseaseName;
	private int diseaseGrade;
	private GenderType gender;
	private double survivalInMonths;
	private double pc1value;
	private double pc2value;
	private double pc3value;
	
	public PrincipalComponentAnalysisDataPoint(String sampleId) {
		this.sampleId = sampleId;
	}
	
	public PrincipalComponentAnalysisDataPoint(String sampleId, double pc1value, double pc2value, double pc3value) {
	  this.sampleId = sampleId;
	  this.pc1value = pc1value;
	  this.pc2value = pc2value;
	  this.pc3value = pc3value;
	}

	
	/**
	 * Return the value of the specified component. If an invalid component is
	 * specified, the function will return Double.NEGATIVE_INFINITY;
	 * @param component
	 * @return
	 */
	public double getComponentValue(PCAcomponent component) {
	  switch(component) {
	  case PC1: return getPc1value();
	  case PC2: return getPc2value();
	  case PC3: return getPc3value();
	  }
	  return Double.NEGATIVE_INFINITY;
	}
	
	public int getDiseaseGrade() {
		return diseaseGrade;
	}

	public void setDiseaseGrade(int diseaseGrade) {
		this.diseaseGrade = diseaseGrade;
	}

	public String getDiseaseName() {
		return diseaseName;
	}

	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}

	public GenderType getGender() {
		return gender;
	}

	public void setGender(GenderType gender) {
		this.gender = gender;
	}

	public String getSampleId() {
		return sampleId;
	}

	public double getSurvivalInMonths() {
		return survivalInMonths;
	}

	public void setSurvivalInMonths(double survivalInMonths) {
		this.survivalInMonths = survivalInMonths;
	}

	public double getPc1value() {
		return pc1value;
	}

	public void setPc1value(double pc1value) {
		this.pc1value = pc1value;
	}

	public double getPc2value() {
		return pc2value;
	}

	public void setPc2value(double pc2value) {
		this.pc2value = pc2value;
	}

	public double getPc3value() {
		return pc3value;
	}

	public void setPc3value(double pc3value) {
		this.pc3value = pc3value;
	}

}
