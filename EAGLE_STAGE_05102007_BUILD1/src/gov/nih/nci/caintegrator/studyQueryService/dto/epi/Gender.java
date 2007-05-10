package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:23:08 PM

 */
public enum Gender {
    MALE("MALE", "Male"),
    FEMALE("FEMALE", "Female");

    private final String value;
    private final String name;

    Gender(String key, String name) {
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
