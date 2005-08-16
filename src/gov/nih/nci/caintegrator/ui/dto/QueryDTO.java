package gov.nih.nci.caintegrator.ui.dto;

import java.util.Map;

import gov.nih.nci.caintegrator.exceptions.QueryDTOValidateException;
import gov.nih.nci.caintegrator.query.Validatable;

public enum QueryDTO implements Validatable{
	CLINICAL_QUERY(),
	GENE_EXPRESSION_QUERY(),
	COPY_NUMBER_QUERY();
	
	private Map<String, ParameterDTO> parameterMap;
	
	public boolean validate() throws QueryDTOValidateException{
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

}
