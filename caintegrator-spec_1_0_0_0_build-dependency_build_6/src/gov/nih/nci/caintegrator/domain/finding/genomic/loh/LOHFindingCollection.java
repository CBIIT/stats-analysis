package gov.nih.nci.caintegrator.domain.finding.genomic.loh;
import gov.nih.nci.caintegrator.domain.GenomicFinding;
import gov.nih.nci.caintegrator.domain.ArrayBioAssayData;





/**
 * group of LOH findings that contains LOH values for all the reporters from one hybridization (in the case of SNP arrays,
 * it is from 2 hybridizations, XBA chip and HINDIII chip from teh 100K SNP platform)
 * @version 1.0
 * @created 18-Nov-2005 01:56:51 PM
 */
public class LOHFindingCollection extends GenomicFinding {

	private LOHFinding LOHFinding;
	private ArrayBioAssayData arrayBioAssayData;

	public LOHFindingCollection(){

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

	/**
	 * @return Returns the lOHFinding.
	 */
	public LOHFinding getLOHFinding() {
		return LOHFinding;
	}

	/**
	 * @param finding The lOHFinding to set.
	 */
	public void setLOHFinding(LOHFinding finding) {
		LOHFinding = finding;
	}

}