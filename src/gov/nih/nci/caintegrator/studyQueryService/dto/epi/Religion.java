/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

public enum Religion implements IntegerValueEnum {
    NONE(1, "None"),
    CATHOLIC(2, "Catholic"),
    JEWISH(3,"Jewish"),
    MOSLEM(4,"Moslem"),
    PROTESTANT(5,"Protestant"),
    OTHER(6,"Other"),
    DONT_KNOW(7,"Don't know");

    private final int value;
    private final String name;

    Religion(int key, String name) {
        this.value = key;
    	this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public int getValue()	{
    	return value;
    }
    
}
