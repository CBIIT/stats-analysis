package gov.nih.nci.caintegrator.domain;

import java.util.Collection;





/**
 * Represents the dataset from one hybridization
 * @version 1.0
 * @created 18-Nov-2005 01:56:32 PM
 */
public class ArrayBioAssayData extends ExperimentData {

	/**
	 * Represents the biosequence on the array: eg: Oligo, CDNA, 100KSNPArray or SpottedArray
	 */
	private String arrayType;
	/**
	 * array design identifier, given by the manufactures of the array: eg: U133plus2.0 by Affy manufactures
	 */
	private String arrayDesignName;
	/**
	 * Number of hybridization channels; eg: in a cDNA array, we have 2 channels - cy3 adn cy5
	 */
	private String noOfChannels;
	/**
	 * creator of the physical array
	 */
	private String manufacturer;
	public Collection<ArrayBioAssayDatum> arrayBioAssayDatum;

	public ArrayBioAssayData(){

	}

	/**
	 * @return Returns the arrayBioAssayDatum.
	 */
	public Collection<ArrayBioAssayDatum> getArrayBioAssayDatum() {
		return arrayBioAssayDatum;
	}

	/**
	 * @param arrayBioAssayDatum The arrayBioAssayDatum to set.
	 */
	public void setArrayBioAssayDatum(
			Collection<ArrayBioAssayDatum> arrayBioAssayDatum) {
		this.arrayBioAssayDatum = arrayBioAssayDatum;
	}

	/**
	 * @return Returns the arrayDesignName.
	 */
	public String getArrayDesignName() {
		return arrayDesignName;
	}

	/**
	 * @param arrayDesignName The arrayDesignName to set.
	 */
	public void setArrayDesignName(String arrayDesignName) {
		this.arrayDesignName = arrayDesignName;
	}

	/**
	 * @return Returns the arrayType.
	 */
	public String getArrayType() {
		return arrayType;
	}

	/**
	 * @param arrayType The arrayType to set.
	 */
	public void setArrayType(String arrayType) {
		this.arrayType = arrayType;
	}

	/**
	 * @return Returns the manufacturer.
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer The manufacturer to set.
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return Returns the noOfChannels.
	 */
	public String getNoOfChannels() {
		return noOfChannels;
	}

	/**
	 * @param noOfChannels The noOfChannels to set.
	 */
	public void setNoOfChannels(String noOfChannels) {
		this.noOfChannels = noOfChannels;
	}

}