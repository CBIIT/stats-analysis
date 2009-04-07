package gov.nih.nci.caintegrator.studyQueryService.dto.ihc;

import gov.nih.nci.caintegrator.dto.query.QueryDTO;
import gov.nih.nci.caintegrator.studyQueryService.ihc.LossOfExpressionIHCFindingHandler;

import java.util.Collection;

public class LossOfExpressionIHCFindingCriteria extends IHCFindingCriteria implements QueryDTO {
	
	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;


    public LossOfExpressionIHCFindingHandler getHandler() {		
		return new LossOfExpressionIHCFindingHandler();
	}
	
	private Collection <String> resultCodeCollection;	
	private Integer benignSum;
    private String benignSumOperator;
	private Integer invasiveSum;
    private String invasiveSumOperator;
    private String queryName;	
	
	
    public void setQueryName(String name) {
        this.queryName = name;        
    }
    public String getQueryName() {
        return queryName;
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
     * @return Returns the benignSumOperator.
     */
    public String getBenignSumOperator() {
        return benignSumOperator;
    }
    /**
     * @param benignSumOperator The benignSumOperator to set.
     */
    public void setBenignSumOperator(String benignSumOperator) {
        this.benignSumOperator = benignSumOperator;
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
     * @return Returns the invasiveSumOperator.
     */
    public String getInvasiveSumOperator() {
        return invasiveSumOperator;
    }
    /**
     * @param invasiveSumOperator The invasiveSumOperator to set.
     */
    public void setInvasiveSumOperator(String invasiveSumOperator) {
        this.invasiveSumOperator = invasiveSumOperator;
    }
    /**
     * @return Returns the resultCodeCollection.
     */
    public Collection<String> getResultCodeCollection() {
        return resultCodeCollection;
    }
    /**
     * @param resultCodeCollection The resultCodeCollection to set.
     */
    public void setResultCodeCollection(Collection<String> resultCodeCollection) {
        this.resultCodeCollection = resultCodeCollection;
    }
    
    
	
	
	

}
