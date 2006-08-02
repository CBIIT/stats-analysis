package gov.nih.nci.caintegrator.studyQueryService.dto.study;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/
/**
 * Groups of subjects based on self-described ethnic groupings and phenotypic
 * ascertainment scheme.
 */

public class PopulationCriteria {

	/**
	 * A textual identifier for the study population
	 */
	private String name;

    public PopulationCriteria() {
    }

    public PopulationCriteria(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}