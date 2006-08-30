package gov.nih.nci.caintegrator.studyQueryService.dto.study;

import java.util.Collection;

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
	private Collection<String> names;

    public PopulationCriteria(Collection<String> names) {
        this.names = names;
    }

    public Collection<String> getNames() {
        return names;
    }

    public void setNames(Collection<String> names) {
        this.names = names;
    }
}