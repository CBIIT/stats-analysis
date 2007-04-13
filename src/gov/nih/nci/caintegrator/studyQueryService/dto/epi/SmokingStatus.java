package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:25:28 PM

 */
public enum SmokingStatus {
    NEVER(0, "Never Smoker"),
    FORMER(1, "Former Smoker"),
    CURRENT(2, "Current Smoker"),
    NO_INFO(9, "No Information");

    private final int value;
    private final String name;

    SmokingStatus(int key, String name) {
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
