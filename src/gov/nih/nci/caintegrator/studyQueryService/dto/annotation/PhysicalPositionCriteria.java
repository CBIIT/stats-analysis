package gov.nih.nci.caintegrator.studyQueryService.dto.annotation;

/**
 * User: Ram Bhattaru
 * Date: Jul 6, 2006
 * Time: 4:13:49 PM
*/

public class PhysicalPositionCriteria {

	private String chromosome;
	private Integer endPosition;
	private Integer startPosition;

	public PhysicalPositionCriteria(){}

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public Integer getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Integer endPosition) {
        this.endPosition = endPosition;
    }

    public Integer getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Integer startPosition) {
        this.startPosition = startPosition;
    }

}