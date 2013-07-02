/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.SampleIDDE;
import gov.nih.nci.caintegrator.enumeration.SpecimenType;

import java.io.Serializable;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Ram, BauerD
 */


/**
* 
* 
*/

public class SampleCriteria extends Criteria implements Serializable, Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7482968366908296674L;
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
	private Set sampleIDs;
	private SpecimenType specimenType; 
	private String sampleFile;
	private String sampleGroup;
	private Boolean excludeResections = null;
	
	public String getSampleFile() {
		return sampleFile;
	}

	public void setSampleFile(String sampleFile) {
		this.sampleFile = sampleFile;
	}
	
	

	public String getSampleGroup() {
		return sampleGroup;
	}

	public void setSampleGroup(String sampleGroup) {
		this.sampleGroup = sampleGroup;
	}

	public Collection getSampleIDs() {
		return sampleIDs;
	}

	public void setSampleIDs(Collection sampleIDValues)
			throws InvalidParameterException {
		for (Iterator iterator = sampleIDValues.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			if (obj instanceof SampleIDDE) {
				
				getSampleIDDEsMember().add(obj);
			} else {
				throw new InvalidParameterException(
						"Collection must be of SampleIDDEs");
			}
		}
	}

	private Collection getSampleIDDEsMember() {
		if (sampleIDs == null)
			sampleIDs = new HashSet();
		return sampleIDs;
	}

	public void setSampleID(SampleIDDE sampleID) {
		if (sampleID != null) {
			getSampleIDDEsMember().add(sampleID);
		}
	}

	public SampleCriteria() {
	}

	public boolean isValid() {
		return true;
	}


	/**
	 * @return the specimenType
	 */
	public SpecimenType getSpecimenType() {
		return specimenType;
	}

	/**
	 * @param specimenType the specimenType to set
	 */
	public void setSpecimenType(SpecimenType specimenType) {
		this.specimenType = specimenType;
	}

	public String getSpecimenTypeValue() {
		if(specimenType != null){
			return specimenType.toString();
		}
		return null;
	}

	public void setSpecimenTypeValue(String specimenTypeValue) {
		for (SpecimenType sp : SpecimenType.values())
		{
			if ( sp.toString().equals(specimenTypeValue)) {
				this.specimenType = sp;
				break;
			}
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
		SampleCriteria myClone = null;
		myClone = (SampleCriteria) super.clone();
		if(sampleIDs!=null) {
			myClone.sampleIDs = new HashSet();
			for (Iterator i = sampleIDs.iterator(); i.hasNext();) {
				myClone.sampleIDs.add(((SampleIDDE) i.next()).clone());
			}
		}
		myClone.specimenType = specimenType;
		myClone.excludeResections = excludeResections;
		return myClone;
	}

	/**
	 * @return the excludeResections
	 */
	public Boolean getExcludeResections() {
		return excludeResections;
	}

	/**
	 * @param excludeResections the excludeResections to set
	 */
	public void setExcludeResections(Boolean excludeResections) {
		this.excludeResections = excludeResections;
	}


}
