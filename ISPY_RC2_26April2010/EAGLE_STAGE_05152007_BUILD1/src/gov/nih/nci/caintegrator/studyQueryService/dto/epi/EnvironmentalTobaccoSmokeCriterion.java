package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.Collection;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class EnvironmentalTobaccoSmokeCriterion {

    public java.util.Collection<OccupationalExposure> occupationalExposureCollection;
    public java.util.Collection<SmokingExposure> smokingExposureCollection;
    public java.util.Collection<LivingCompanionExposure> livingCompanionExposureCollection;

    public EnvironmentalTobaccoSmokeCriterion(){

    }

    public Collection<OccupationalExposure> getOccupationalExposureCollection() {
        return occupationalExposureCollection;
    }

    public void setOccupationalExposureCollection(Collection<OccupationalExposure> occupationalExposureCollection) {
        this.occupationalExposureCollection = occupationalExposureCollection;
    }

    public Collection<SmokingExposure> getSmokingExposureCollection() {
        return smokingExposureCollection;
    }

    public void setSmokingExposureCollection(Collection<SmokingExposure> smokingExposureCollection) {
        this.smokingExposureCollection = smokingExposureCollection;
    }

    public Collection<LivingCompanionExposure> getLivingCompanionExposureCollection() {
        return livingCompanionExposureCollection;
    }

    public void setLivingCompanionExposureCollection(Collection<LivingCompanionExposure> livingCompanionExposureCollection) {
        this.livingCompanionExposureCollection = livingCompanionExposureCollection;
    }
}