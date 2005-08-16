package gov.nih.nci.caintegrator.findings;

import gov.nih.nci.caintegrator.ui.dto.QueryDTO;

/**
 * This interface will provide the method signatures of the
 * finding services available and pakaged in the caIntegrator
 * specification.
 * 
 * Whether this will be a proxy will be determined by the finding
 * strategies that it employs.
 * 
 * @author BauerD
 *
 */
public interface FindingsFactory {
	public Object createFinding1(QueryDTO parameterDTOs);
	public Object createFinding2(QueryDTO parameterDTOs);
}
