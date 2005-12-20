package gov.nih.nci.caintegrator.domain;





/**
 * A Design Element that represents some biological material (clone, oligo, etc.) on an array which will report on some
 * biosequence or biosequences; eg: Affymetrix probeset or cDNA clone
 * 
 * (Note: may not be equivalent to a MAGE-OM Reporter in all cases.)
 * @version 1.0
 * @created 18-Nov-2005 01:56:59 PM
 */
public class Reporter {

	private Long id;
	/**
	 * Identifier for the reporter: eg: Affymetrix probeset ID, Image clone ID
	 */
	private String name;
	/**
	 * the kind of reporter; eg: Affymetrix probeset, Unigene, IMAGEClone
	 */
	private String identifierType;

	public Reporter(){

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
	 * @return Returns the identifierType.
	 */
	public String getIdentifierType() {
		return identifierType;
	}

	/**
	 * @param identifierType The identifierType to set.
	 */
	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
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