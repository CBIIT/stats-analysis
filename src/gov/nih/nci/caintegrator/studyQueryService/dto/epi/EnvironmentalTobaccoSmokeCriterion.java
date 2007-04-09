package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.List;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class EnvironmentalTobaccoSmokeCriterion {

    public OccupationalExposure occupationalExposure;
    public java.util.List smokingExposureCollection;
    public java.util.List livingCompanionExposureCollection;

    public EnvironmentalTobaccoSmokeCriterion(){

    }

    public OccupationalExposure getOccupationalExposure() {
        return occupationalExposure;
    }

    public void setOccupationalExposure(OccupationalExposure occupationalExposure) {
        this.occupationalExposure = occupationalExposure;
    }

    public List getSmokingExposureCollection() {
        return smokingExposureCollection;
    }

    public void setSmokingExposureCollection(List smokingExposureCollection) {
        this.smokingExposureCollection = smokingExposureCollection;
    }

    public List getLivingCompanionExposureCollection() {
        return livingCompanionExposureCollection;
    }

    public void setLivingCompanionExposureCollection(List livingCompanionExposureCollection) {
        this.livingCompanionExposureCollection = livingCompanionExposureCollection;
    }
}