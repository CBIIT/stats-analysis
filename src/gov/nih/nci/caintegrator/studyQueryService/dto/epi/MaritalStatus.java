package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:24:07 PM
 */
public enum MaritalStatus {
    MARRIED(1,"Married"),
    COHABITING(2,"Cohabiting"),
    SEPARATED(3,"Separated"),
    WIDOWED(4,"Widowed"),
    DIVORCED(5,"Divorced"),
    SINGLE(6,"Single");

    private final int value;
    private final String name;

    MaritalStatus(int key, String name) {
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
