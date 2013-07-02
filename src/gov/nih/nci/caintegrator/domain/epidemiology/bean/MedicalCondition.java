/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.domain.epidemiology.bean;

public class MedicalCondition {

    private Long id;
    private String conditionName;
    
    public String getConditionName() {
        return conditionName;
    }
    public void setConditionName(String conditionName) {
        this.conditionName = conditionName;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    
}
