/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

/*
 *  @author: SahniH
 *  Created on Oct 12, 2004
 *  @version $ Revision: 1.0 $
 * 	
 */
package gov.nih.nci.caintegrator.dto.view;

import java.io.Serializable;


/**
 * @author SahniH
 * Date: Oct 12, 2004
 * 
 */


/**
* 
* 
*/

public abstract class GroupType implements Serializable{
    public abstract GroupType getGroupType();
    public final static DiseaseTypeGroup DISEASE_TYPE_GROUP = new DiseaseTypeGroup();
    public final static AgeGroup AGE_GROUP = new AgeGroup();
    public final static SurvivalRangeGroup SURVIVAL_RANGE_GROUP = new SurvivalRangeGroup();

    public static class DiseaseTypeGroup extends GroupType {
       public GroupType getGroupType() {
           return DISEASE_TYPE_GROUP;
       }
    }
    public static class AgeGroup extends GroupType {
	       public GroupType getGroupType() {
	           return AGE_GROUP;
	       }
	    }
    public static class SurvivalRangeGroup extends GroupType {
	       public GroupType getGroupType() {
	           return SURVIVAL_RANGE_GROUP;
	       }
	    }
}
