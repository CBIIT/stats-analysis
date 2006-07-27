package gov.nih.nci.cgems.dto;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/
/**
 * A type of research activity that tests how well new medical treatments or other
 * interventions work in subjects. Such plans test new methods of screening,
 * prevention, diagnosis or treatment of a disease. The specific plans are fully
 * defined in the protocol and may be carried out in a clinic or other medical
 * facility.
 */

public class StudyCriteria {

	private String name;
	/**
	 * The unique identifier for the study assigned by the study sponsoring
	 * organization.
	 */
	private String sponsorStudyIdentifier;

	public StudyCriteria(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSponsorStudyIdentifier() {
        return sponsorStudyIdentifier;
    }

    public void setSponsorStudyIdentifier(String sponsorStudyIdentifier) {
        this.sponsorStudyIdentifier = sponsorStudyIdentifier;
    }

}