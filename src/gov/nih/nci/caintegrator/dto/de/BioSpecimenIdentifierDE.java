/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

/*
 * Created on Sep 13, 2004
 *
 */
package gov.nih.nci.caintegrator.dto.de;

import java.io.Serializable;

/**
 * This class encapsulates the properties of an caintergator BioSpecimanDE
 * object.
 * 
 * @author SahniH, BauerD
 */


/**
* 
* 
*/

public class BioSpecimenIdentifierDE extends DomainElement implements
		Serializable, Cloneable , Comparable{
	private String sampleId;
	private String specimenName;
	/**
	 * IMPORTANT! This class requires a clone method! This requires that any new
	 * data field that is added to this class also be cloneable and be added to
	 * clone calls in the clone method.If you do not do this, you will not
	 * seperate the references of at least one data field when we generate a
	 * copy of this object.This means that if the data field ever changes in one
	 * copy or the other it will affect both instances... this will be hell to
	 * track down if you aren't ultra familiar with the code base, so add those
	 * methods now! (Not necesary for primitives.)
	 */

	/**
	 * Initializes a newly created <code>BioSpecimenIdentifierDE</code> object
	 * so that it represents an AlleleFrequencyDE.
	 */
	public BioSpecimenIdentifierDE(Long bioSpecimenID) {
		super(bioSpecimenID);
	}

	/**
	 * Sets the value for this <code>BioSpecimenIdentifierDE</code> object
	 * 
	 * @param object
	 *            the value
	 */
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof Long))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((Long) obj);
	}

	/**
	 * Returns the sampleID for this BioSpecimenIdentifierDE obect.
	 * 
	 * @return the sampleID for this <code>BioSpecimenIdentifierDE</code>
	 *         object
	 */
	public Long getValueObject() {
		return (Long) getValue();
	}

	/**
	 * Sets the sampleID for this <code>BioSpecimenIdentifierDE</code> object
	 * 
	 * @param sampleID
	 *            the sampleID
	 */
	public void setValueObject(Long bioSpecimenID) {
		if (bioSpecimenID != null) {
			value = bioSpecimenID;
		}
	}
	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public Object clone() {
		BioSpecimenIdentifierDE myClone = (BioSpecimenIdentifierDE) super
				.clone();
		return myClone;
	}

	/**
	 * @return Returns the sampleId.
	 */
	public String getSampleId() {
		return sampleId;
	}

	/**
	 * @param sampleId The sampleId to set.
	 */
	public void setSampleId(String sampleId) {
		this.sampleId = sampleId;
	}

	/**
	 * @return Returns the specimenName.
	 */
	public String getSpecimenName() {
		return specimenName;
	}

	/**
	 * @param specimenName The specimenName to set.
	 */
	public void setSpecimenName(String specimanName) {
		this.specimenName = specimanName;
	}
	/**
	 * The compareTo method is used to compare this object with another and determine
	 * is this is less, equal, or greater than that object.  This is used in sorting
	 * these objects.
	 * <P>
	 * @param o The object to compare this to
	 * @return int
	 */
	public int compareTo(Object o) {
		int returnValue = 0;
		BioSpecimenIdentifierDE other;
		// Must be another SNPAssociationFindingReport object
		if (!(o instanceof BioSpecimenIdentifierDE))
		      throw new ClassCastException("A BioSpecimenIdentifierDE object expected.");
		else
			other = (BioSpecimenIdentifierDE)o;
		
		if(this.getSpecimenName() != null && other.getSpecimenName()!= null){
			returnValue =  this.getSpecimenName().compareTo(other.getSpecimenName());
		}
		else if	(this.getSampleId() != null && other.getSampleId()!= null){
				returnValue =  this.getSampleId().compareTo(other.getSampleId());
		}
		else{
			returnValue =  this.getValueObject().compareTo(other.getValueObject());
		}
		return returnValue;
	}

}
