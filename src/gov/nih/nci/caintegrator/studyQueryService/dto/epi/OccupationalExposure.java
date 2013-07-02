/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

import java.util.Date;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class OccupationalExposure {

    private Float yearsExposed;
    private ExposureLevel smokingExposure;

    public Float getYearsExposed() {
        return yearsExposed;
    }

    public void setYearsExposed(Float yearsExposed) {
        this.yearsExposed = yearsExposed;
    }

    public ExposureLevel getSmokingExposure() {
        return smokingExposure;
    }

    public void setSmokingExposure(ExposureLevel smokingExposure) {
        this.smokingExposure = smokingExposure;
    }
}