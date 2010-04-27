package gov.nih.nci.caintegrator.studyQueryService.dto.clinical;

import gov.nih.nci.caintegrator.studyQueryService.dto.clinical.TNMValueCriterion;
import gov.nih.nci.caintegrator.studyQueryService.dto.clinical.StageCriterion;
import gov.nih.nci.caintegrator.studyQueryService.dto.clinical.HistologyCriterion;
import gov.nih.nci.caintegrator.studyQueryService.dto.clinical.CotanineLevelCriterion;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 13, 2007
  * Time:   3:08:50 PM
**/
public class ClinicalQueryDTO {

    public TNMValueCriterion tnmValueCriterion;
    public StageCriterion stageCriterion;
    public GradeCriterion gradeCriterion;
    public HistologyCriterion histologyCriterion;
    public CotanineLevelCriterion cotanineLevelCriterion;

    public ClinicalQueryDTO(){

    }

    public void finalize() throws Throwable {

    }

}