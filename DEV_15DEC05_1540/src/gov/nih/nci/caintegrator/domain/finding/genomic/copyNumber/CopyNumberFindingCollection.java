package gov.nih.nci.caintegrator.domain.finding.genomic.copyNumber;
import gov.nih.nci.caintegrator.domain.GenomicFinding;
import gov.nih.nci.caintegrator.domain.ArrayBioAssayData;





/**
 * group of copy number findings that contains copy number values for all the reporters from one hybridization (in the
 * case of SNP arrays, it is from 2 hybridizations, XBA chip and HINDIII chip from the 100K SNP platform)
 * @version 1.0
 * @created 18-Nov-2005 01:56:42 PM
 */
public class CopyNumberFindingCollection extends GenomicFinding {

	private CopyNumberFinding copyNumberFinding;
	private ArrayBioAssayData arrayBioAssayData;

	public CopyNumberFindingCollection(){

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
	 * @return Returns the copyNumberFinding.
	 */
	public CopyNumberFinding getCopyNumberFinding() {
		return copyNumberFinding;
	}

	/**
	 * @param copyNumberFinding The copyNumberFinding to set.
	 */
	public void setCopyNumberFinding(CopyNumberFinding copyNumberFinding) {
		this.copyNumberFinding = copyNumberFinding;
	}

}