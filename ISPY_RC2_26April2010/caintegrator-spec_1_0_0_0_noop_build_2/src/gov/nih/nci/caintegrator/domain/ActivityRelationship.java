package gov.nih.nci.caintegrator.domain;





/**
 * The semantic link between two or more activities.
 * 
 * BRIDG: In the particular case where the activities are analysis tasks, this is a verb phrase that specifies the
 * semantic link between two AnalysisTasks. Examples:
 * (1) specification that a particular value in the response to one AnalysisTask dictates navigation to another
 * AnalysisTask (e.g., if analysis of the distribution of the data shows that it is not normally distributed, you would
 * navigate to the non-parametric version of the statistical test)
 * (2) the value of a response may be determined from the value of a set of other fields (e.g., the standard error of the
 * mean is derived from the mean, the standard deviation and the sample size).
 * (3) the behavior of a field for another AnalysisTask is determined by the value of a response (e.g., the choice of
 * prior distribution changes your Bayesian model).
 * @created 18-Nov-2005 01:56:30 PM
 */
public class ActivityRelationship {

	private Long id;
	/**
	 * describes the relationship
	 */
	private String type;

	public ActivityRelationship(){

	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

}