package gov.nih.nci.caintegrator.findings.strategys;

import gov.nih.nci.caintegrator.exceptions.FindingsAnalysisException;
import gov.nih.nci.caintegrator.exceptions.FindingsQueryException;
import gov.nih.nci.caintegrator.exceptions.FindingsValidationException;
import gov.nih.nci.caintegrator.ui.dto.QueryDTO;
/**
 * This interface defines the required methods for every type of
 * Finding that can be performed in caIntegrator.  
 * 
 * @author BauerD
 *
 */
public interface FindingStrategy {
	/**
	 * This is used to 
	 * @return
	 * @throws FindingsValidationException
	 */
	public boolean validate(QueryDTO query) throws FindingsValidationException;
	public boolean createQuery()throws FindingsQueryException;
	public boolean executeQuery() throws FindingsQueryException;
	public boolean analyzeResultSet() throws FindingsAnalysisException;
	public Object getResultSet();
}
