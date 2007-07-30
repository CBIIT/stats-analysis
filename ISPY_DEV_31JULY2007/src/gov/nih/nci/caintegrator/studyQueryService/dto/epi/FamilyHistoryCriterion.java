package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.Collection;

/**
 * User: Ram Bhattaru
 * Date: Apr 20, 2007
 * Time: 11:26:32 AM
 */
public class FamilyHistoryCriterion {

    public Integer familyLungCancer;
    public java.util.Collection<Relative>  smokingRelativeCollection;

    public FamilyHistoryCriterion(){}

    public Collection<Relative> getSmokingRelativeCollection() {
        return smokingRelativeCollection;
    }

    public void setSmokingRelativeCollection(Collection<Relative> smokingRelativeCollection) {
        this.smokingRelativeCollection = smokingRelativeCollection;
    }

    public Integer getFamilyLungCancer() {
        return familyLungCancer;
    }

    public void setFamilyLungCancer(Integer familyLungCancer) {
        this.familyLungCancer = familyLungCancer;
    }


}