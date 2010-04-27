package gov.nih.nci.caintegrator.domain.finding.geneExpression.classComparison;
import java.util.Collection;

import gov.nih.nci.caintegrator.domain.ArrayBioAssayData;





/**
 * @version 1.0
 * @created 18-Nov-2005 01:56:39 PM
 */
public class ComparisonGroup {

	private String name;
	private Collection<ArrayBioAssayData> arrayBioAssayData;

	public ComparisonGroup(){

	}

	/**
	 * @return Returns the arrayBioAssayData.
	 */
	public Collection<ArrayBioAssayData> getArrayBioAssayData() {
		return arrayBioAssayData;
	}

	/**
	 * @param arrayBioAssayData The arrayBioAssayData to set.
	 */
	public void setArrayBioAssayData(Collection<ArrayBioAssayData> arrayBioAssayData) {
		this.arrayBioAssayData = arrayBioAssayData;
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}