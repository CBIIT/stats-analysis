/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public enum FoodItems {
	ONIONS("Onions"),
	POTATOES("Potatoes"),
	RAWPEPPERS("RawPeppers"),
	SALAD("Salad"),
	TOMATOES("Tomatoes");

    private String value;

    FoodItems(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}