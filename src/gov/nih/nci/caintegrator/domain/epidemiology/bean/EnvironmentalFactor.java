/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.domain.epidemiology.bean;

public class EnvironmentalFactor {

    private Long id;
    private String exposureType;
    private EpidemiologicalFinding epidemiologicalFinding;
    
    public EpidemiologicalFinding getEpidemiologicalFinding() {
        return epidemiologicalFinding;
    }
    public void setEpidemiologicalFinding(
            EpidemiologicalFinding epidemiologicalFinding) {
        this.epidemiologicalFinding = epidemiologicalFinding;
    }
    public String getExposureType() {
        return exposureType;
    }
    public void setExposureType(String exposureType) {
        this.exposureType = exposureType;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
}
