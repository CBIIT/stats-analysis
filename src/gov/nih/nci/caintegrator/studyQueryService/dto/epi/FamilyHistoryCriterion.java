package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.Collection;

/**
 * User: Ram Bhattaru
 * Date: Apr 20, 2007
 * Time: 11:26:32 AM
 */
public class FamilyHistoryCriterion {

    public java.util.Collection<SmokingRelative>  smokingRelativeCollection;
    public java.util.Collection<LungCancerRelative> lungCancerRelativeCollection;

    public FamilyHistoryCriterion(){}

    public Collection<SmokingRelative> getSmokingRelativeCollection() {
        return smokingRelativeCollection;
    }

    public void setSmokingRelativeCollection(Collection<SmokingRelative> smokingRelativeCollection) {
        this.smokingRelativeCollection = smokingRelativeCollection;
    }

    public Collection<LungCancerRelative> getLungCancerRelativeCollection() {
        return lungCancerRelativeCollection;
    }

    public void setLungCancerRelativeCollection(Collection<LungCancerRelative> lungCancerRelativeCollection) {
        this.lungCancerRelativeCollection = lungCancerRelativeCollection;
    }
}