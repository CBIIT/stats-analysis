package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:23:08 PM

 */
public enum Gender implements IntegerValueEnum {
    MALE(1, "Male"), 
    FEMALE(2, "Female");

    private final int value;
    private final String name;

    Gender(int key, String name) {
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
