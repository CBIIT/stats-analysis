package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:24:53 PM

 */
public enum Religion {
    NONE("None", "None"),
    CATHOLIC("Catholic", "Catholic"),
    JEWISH("Jewish","Jewish"),
    MOSLEM("Moslem","Moslem"),
    PROTESTANT("Protestant","Protestant"),
    OTHER("Other","Other"),
    DONT_KNOW("Don't know","Don't know");

    private final String value;
    private final String name;

    Religion(String key, String name) {
        this.value = key;
    	this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getValue()	{
    	return value;
    }

}
