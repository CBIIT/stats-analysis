package gov.nih.nci.caintegrator.ui.dto;

import java.util.Map;

import gov.nih.nci.caintegrator.exceptions.QueryDTOValidateException;
import gov.nih.nci.caintegrator.query.Validatable;
/**
 * This ENUM type will contain and describe the UI's definition of
 * the query to be performed. The parameterMap will contain the 
 * parameterDTOs for the query.  This ENUM is smart enough to know
 * which validator to call for itself depending on it's value.
 * 
 * Later we can build in a customizable
 * 
 * @author BauerD
 *
 */
public enum QueryDTO implements Validatable{
	CLINICAL_QUERY(),
	GENE_EXPRESSION_QUERY(),
	COPY_NUMBER_QUERY();
	//Contains all the parameters for the query type
	private Map<String, ParameterDTO> parameterMap;
	private String queryID;
	
	public boolean validate() throws QueryDTOValidateException{
		/*
		 * I am thinking that a validator factory might be a good
		 * idea.  We could replace the switch statement here with
		 * a single call to the validator factory... in the
		 * factory we could even allow for property defintions to 
		 * allow us to change out the Validators as needed.
		 * 
		 * DB
		 */
		switch(this) {
		case CLINICAL_QUERY:
			//call ClinicalQueryValidator for the ParameterMap
			break;
		case GENE_EXPRESSION_QUERY:
			//call ClinicalQueryValidator for the ParameterMap
			break;
		case COPY_NUMBER_QUERY:
			//call CopyNumberQueryValidator for the ParameterMap
			break;
		default:
			throw new QueryDTOValidateException("Unknown QueryDTOType");
		}
		return true;
	}
	
	public void setParameterMap(Map<String, ParameterDTO> newMap) {
		this.parameterMap = newMap;
	}
	
	public Map<String,ParameterDTO> getParameterMap(){
		return this.parameterMap;
	}

	/**
	 * @return Returns the uniqueID.
	 */
	public String getQueryID() {
		return queryID;
	}

	/**
	 * @param uniqueID The uniqueID to set.
	 */
	public void setQueryID(String uniqueID) {
		this.queryID = uniqueID;
	}

}
