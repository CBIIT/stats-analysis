package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.Date;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class OccupationalExposure {

    private Date endDate;
    private Date startDate;
    public ExposureLevel exposureLevel;

    public OccupationalExposure(){

    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public ExposureLevel getExposureLevel() {
        return exposureLevel;
    }

    public void setExposureLevel(ExposureLevel exposureLevel) {
        this.exposureLevel = exposureLevel;
    }
}