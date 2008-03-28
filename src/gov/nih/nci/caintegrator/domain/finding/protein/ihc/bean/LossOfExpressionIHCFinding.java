package gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean;

import java.io.Serializable;

public class LossOfExpressionIHCFinding extends IHCFinding implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3689069021034505228L;
    
    private String benignPresentValue;
    private Integer benignSum;
    private Integer invasiveSum;
    private Integer invasiveBenignDiff;
    private String lossResult;
    private String comments;
    private String benignSumOperator;
    private String invasiveSumOperator;
    

    /**
     * @return Returns the benignPresentValue.
     */
    public String getBenignPresentValue() {
        return benignPresentValue;
    }
    /**
     * @param benignPresentValue The benignPresentValue to set.
     */
    public void setBenignPresentValue(String benignPresentValue) {
        this.benignPresentValue = benignPresentValue;
    }
    /**
     * @return Returns the benignSum.
     */
    public Integer getBenignSum() {
        return benignSum;
    }
    /**
     * @param benignSum The benignSum to set.
     */
    public void setBenignSum(Integer benignSum) {
        this.benignSum = benignSum;
    }
    /**
     * @return Returns the comments.
     */
    public String getComments() {
        return comments;
    }
    /**
     * @param comments The comments to set.
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    /**
     * @return Returns the invasiveBenignDiff.
     */
    public Integer getInvasiveBenignDiff() {
        return invasiveBenignDiff;
    }
    /**
     * @param invasiveBenignDiff The invasiveBenignDiff to set.
     */
    public void setInvasiveBenignDiff(Integer invasiveBenignDiff) {
        this.invasiveBenignDiff = invasiveBenignDiff;
    }
    /**
     * @return Returns the invasiveSum.
     */
    public Integer getInvasiveSum() {
        return invasiveSum;
    }
    /**
     * @param invasiveSum The invasiveSum to set.
     */
    public void setInvasiveSum(Integer invasiveSum) {
        this.invasiveSum = invasiveSum;
    }
    /**
     * @return Returns the lossResult.
     */
    public String getLossResult() {
        return lossResult;
    }
    /**
     * @param lossResult The lossResult to set.
     */
    public void setLossResult(String lossResult) {
        this.lossResult = lossResult;
    }
	public String getBenignSumOperator() {
		return benignSumOperator;
	}
	public void setBenignSumOperator(String benignSumOperator) {
		this.benignSumOperator = benignSumOperator;
	}
	public String getInvasiveSumOperator() {
		return invasiveSumOperator;
	}
	public void setInvasiveSumOperator(String invasiveSumOperator) {
		this.invasiveSumOperator = invasiveSumOperator;
	}
    
	
	

}
