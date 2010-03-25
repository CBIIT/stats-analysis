package gov.nih.nci.caintegrator.studyQueryService.dto.study;

import java.util.Collection;
import java.util.ArrayList;

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
    private  Long studyId;



    /**
	 * @return Returns the studyId.
	 */
	public Long getStudyId() {
		return studyId;
	}

	/**
	 * @param studyId The studyId to set.
	 */
	public void setStudyId(Long studyId) {
		this.studyId = studyId;
	}

	public PopulationCriteria(Long studyId) {
        this.studyId = studyId;
        names = new ArrayList();
    }

    public void addNames(Collection<String> names) {
        this.names.addAll(names);
    }

    public PopulationCriteria(Collection<String> names) {
        this.names = names;
    }

    public Collection<String> getNames() {
        return names;
    }

    public void setNames(Collection<String> names) {
        this.names = names;
    }

	@Override
	public String toString()
	{
		String str = "Population Criteria\n";
		
		if ((names != null) && (names.size() > 0))
		{
			str = str + "Populations:\n";
			for (String name : names)
			{
				str = str + name + "\n";
			}
		}
		
		return str;
	}
}