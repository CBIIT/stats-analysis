package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.List;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/


public class FamilyHistoryCriterion {

    public java.util.List smokingRelativeCollection;
    public java.util.List relativeMedicalConditionCollection;

    public FamilyHistoryCriterion(){

    }


    public List getRelativeMedicalConditionCollection() {
        return relativeMedicalConditionCollection;
    }

    public void setRelativeMedicalConditionCollection(List relativeMedicalConditionCollection) {
        this.relativeMedicalConditionCollection = relativeMedicalConditionCollection;
    }

    public List getSmokingRelativeCollection() {
        return smokingRelativeCollection;
    }

    public void setSmokingRelativeCollection(List smokingRelativeCollection) {
        this.smokingRelativeCollection = smokingRelativeCollection;
    }
}