package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.finding.Finding;
import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;

import java.util.Collection;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
 */
public class FindingsManager {
    public static Collection<? extends Finding> getFindings(FindingCriteriaDTO findingCritDTO, int fromIndex,
                                                            int toIndex)
    throws Exception {
        return findingCritDTO.getHandler().getFindings(findingCritDTO, fromIndex, toIndex);
    }
}
