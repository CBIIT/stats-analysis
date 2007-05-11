package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Apr 13, 2007
 * Time: 5:26:32 PM
 */
public enum EducationLevel {
    NONE("None", "None"),
    ELEMENTARY("ES", "Elementary School"),
    LOWER_MIDDLE("Lower Middle", "Lower Middle"),
    TEACHER_TRAINING("Teacher Training HS", "Teacher Training High School"),
    TECHNICAL("Technical, Industrial, Commercial HS", "Technical, Industrial, Commercial H.School"),
    COLLEGE_PREP("College Prep. High Schools", "College Prep. High Schools (Classical, Science, Art)"),
    POST_HS("Post H.S.", "Post H.S. Academies or Junior Colleges"),
    DEGREE("Academies", "Degree"),
    POSTGRAD("Postgraduate", "Postgraduate"),
    OTHER("Other", "Other");

    private final String value;
    private final String name;


     EducationLevel(String key, String name) {
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
