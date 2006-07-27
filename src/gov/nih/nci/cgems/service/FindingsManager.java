package gov.nih.nci.cgems.service;

import gov.nih.nci.cgems.dto.CGEMSFindingCriteriaDTO;
import gov.nih.nci.caintegrator.domain.cgems.finding.Finding;

import java.util.Collection;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
 */
public class FindingsManager {
    public static Collection<? extends Finding> getFindings(CGEMSFindingCriteriaDTO findingCritDTO, int fromIndex,
                                                            int toIndex)
    throws Exception {
        return findingCritDTO.getHandler().getFindings(findingCritDTO, fromIndex, toIndex);
    }
}
