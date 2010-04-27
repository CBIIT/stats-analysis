package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:24:07 PM
 */
public enum MaritalStatus {
    MARRIED("Married","Married"),
    COHABITING("Cohabiting","Cohabiting"),
    SEPARATED("Separated","Separated"),
    WIDOWED("Widowed","Widowed"),
    DIVORCED("Divorced","Divorced"),
    SINGLE("Single","Single");

    private final String value;
    private final String name;

    MaritalStatus(String key, String name) {
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
