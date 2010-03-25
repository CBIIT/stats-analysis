package gov.nih.nci.caintegrator.studyQueryService.dto.annotation;

/**
 * User: Ram Bhattaru
 * Date: Jul 6, 2006
 * Time: 4:13:49 PM
*/

public class PhysicalPositionCriteria {

	private String chromosome;
	private Long endPosition;
	private Long startPosition;

	public PhysicalPositionCriteria(){}

    public String getChromosome() {
        return chromosome;
    }

    public void setChromosome(String chromosome) {
        this.chromosome = chromosome;
    }

    public Long getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(Long endPosition) {
        this.endPosition = endPosition;
    }

    public Long getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(Long startPosition) {
        this.startPosition = startPosition;
    }

	@Override
	public String toString()
	{
		String str = "Physical Position Criteria\n";
		
		if (chromosome != null)
			str = str + "Chromosome: " + chromosome + "\n";
		if (startPosition != null)
			str = str + "start: " + startPosition + " (bp)\n";
		if (endPosition != null)
			str = str + "end: " + endPosition + " (bp)\n";
		
		return str;
	}

}