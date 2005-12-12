package gov.nih.nci.caintegrator.domain.finding.genomic.loh;
import gov.nih.nci.caintegrator.domain.GenomicAnalysis;
import gov.nih.nci.caintegrator.domain.ArrayBioAssayData;





/**
 * @version 1.0
 * @created 18-Nov-2005 01:56:50 PM
 */
public class LOHAnalysis extends GenomicAnalysis {

	private ArrayBioAssayData arrayBioAssayData;

	public LOHAnalysis(){

	}

	/**
	 * @return Returns the arrayBioAssayData.
	 */
	public ArrayBioAssayData getArrayBioAssayData() {
		return arrayBioAssayData;
	}

	/**
	 * @param arrayBioAssayData The arrayBioAssayData to set.
	 */
	public void setArrayBioAssayData(ArrayBioAssayData arrayBioAssayData) {
		this.arrayBioAssayData = arrayBioAssayData;
	}

}