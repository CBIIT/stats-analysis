/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.SegmentMeanDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author J. Beasley
 */



/**
* 
* 
*/

public class SegmentMeanCriteria extends Criteria implements Serializable,
		Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6699829936759855656L;

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
	private Collection segmentMeanData;
	
	private String segmentMean;

	public SegmentMeanCriteria() {
	}

	// this is to deal with one segmentMeanDE object entry
	public void setSegmentMean(SegmentMeanDE segmentMeanDE) {
		if (segmentMeanDE != null) {
			getSegmentMeanData().add(segmentMeanDE);
		}
	}
	
	// this is to deal w/ a collection of segmentMeanDE
	public void setSegmentMeanData(Collection segmentMeanData) {
		for (Iterator iterator = segmentMeanData.iterator(); iterator
				.hasNext();) {
			Object obj = iterator.next();
			if (obj instanceof SegmentMeanDE) {
				getSegmentMeanData().add(obj);
			}
		}
	}

	public Collection getSegmentMeanData() {
		if (segmentMeanData == null) {
			segmentMeanData = new ArrayList();
		}
		return segmentMeanData;
	}

	public boolean isValid() {

		if (segmentMeanData != null && !segmentMeanData.isEmpty()) {
			Iterator iter = segmentMeanData.iterator();
			while (iter.hasNext()) {
				SegmentMeanDE segmentMeanDE = (SegmentMeanDE) iter.next();
				if (segmentMeanDE.getValueObject() != null) {
					Float segmentMeanVal = segmentMeanDE.getValueObject();
					if (!segmentMeanVal.isNaN() && segmentMeanVal.floatValue() > 0) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public String getSegmentMean() {
		return segmentMean;
	}

	public void setSegmentMean(String segmentMean) {
		this.segmentMean = segmentMean;
	}

	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public Object clone() {
		SegmentMeanCriteria myClone = null;
		myClone = (SegmentMeanCriteria) super.clone();
		if (segmentMeanData != null ) {
			myClone.segmentMeanData = new ArrayList();
			for (Iterator i = segmentMeanData.iterator(); i.hasNext();) {
				myClone.segmentMeanData.add(((SegmentMeanDE) i.next()).clone());
			}
		}
		return myClone;
	}

}
