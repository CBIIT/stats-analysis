/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.de;

import java.io.Serializable;

/**
 * This abstract class encapsulates the properties of an caintergator
 * CopyNumberDE object. It contains three child/nested classes:Amplification,
 * Deletion & Unchange
 * 
 * @author Dana Zhang, BauerD
 */


/**
* 
* 
*/

abstract public class SegmentMeanDE extends DomainElement implements
		Serializable, Cloneable, SNPableDE {

	/**
	 * IMPORTANT! This class requires a clone method! This requires that any new
	 * data field that is added to this class also be cloneable and be added to
	 * clone calls in the clone method.If you do not do this, you will not
	 * separate the references of at least one data field when we generate a
	 * copy of this object.This means that if the data field ever changes in one
	 * copy or the other it will affect both instances... this will be hell to
	 * track down if you aren't ultra familiar with the code base, so add those
	 * methods now! (Not necessary for primitives.)
	 */

	/**
	 * type of CGH
	 */
	private String CGHType;
	
	private String sampleType;


	/**
	 * private parent constructor utilized in the two nested/child classes
	 * This default constructor needed by Castor XML
	 */
	private SegmentMeanDE() {
		super("");
	}

	/**
	 * private parent constructor utilized in the two nested/child classes
	 */
	private SegmentMeanDE(String sampleType, String value) {
		super(value);
		this.sampleType = sampleType;
	}

	/**
	 * private parent constructor utilized in the two nested/child classes
	 */
	private SegmentMeanDE(String CGHType, Float value) {
		super(value);
		this.CGHType = CGHType;
	}

	/**
	 * nested child class: Amplification
	 */
	public final static class Amplification extends SegmentMeanDE {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9221358191460841483L;

		public Amplification() {
			super(AMPLIFICATION, 0f);
		}

		public Amplification(Float AmplificationNumber) {
			super(AMPLIFICATION, AmplificationNumber);
		}

		public Object clone() {
			Amplification myClone = (Amplification) super.clone();
			return myClone;
		}
	}

	/**
	 * nested child class: Deletion
	 */
	public final static class Deletion extends SegmentMeanDE {
		private static final long serialVersionUID = 9221358191460841483L;
		public Deletion() {
			super(DELETION, 0f);
		}
		
		public Deletion(Float deletionNumber) {
			super(DELETION, deletionNumber);
		}

		public Object clone() {
			Deletion myClone = (Deletion) super.clone();
			return myClone;
		}
	}

	/**
	 * nested child class: UnChangedSegmentMeanUpperLimit
	 */
	public final static class UnChangedSegmentMeanUpperLimit extends
			SegmentMeanDE {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9221358191460841483L;

		public UnChangedSegmentMeanUpperLimit() {
			super(UNCHANGED_UPPER_LIMIT, 0f);
		}

		public UnChangedSegmentMeanUpperLimit(Float unChangedSegMeanUpperValue) {
			super(UNCHANGED_UPPER_LIMIT, unChangedSegMeanUpperValue);
		}

		public Object clone() {
			UnChangedSegmentMeanUpperLimit myClone = (UnChangedSegmentMeanUpperLimit) super
					.clone();
			return myClone;
		}

	}

	/**
	 * nested child class: UnChangedCopyNumberDownLimit
	 */
	public final static class UnChangedSegmentMeanDownLimit extends SegmentMeanDE {
		private static final long serialVersionUID = 9221358191460841483L;
		public UnChangedSegmentMeanDownLimit() {
			super(UNCHANGED_DOWN_LIMIT, 0f);
		}
		
		public UnChangedSegmentMeanDownLimit(Float unChangedCopyNoDownValue) {
			super(UNCHANGED_DOWN_LIMIT, unChangedCopyNoDownValue);
		}

		public Object clone() {
			UnChangedSegmentMeanDownLimit myClone = (UnChangedSegmentMeanDownLimit) super
					.clone();
			return myClone;
		}

	}

	/**
	 * Returns the CGHTpye for this SegmentMeanDE object.
	 * 
	 * @return the CGHTpye for this <code>SegmentMeanDE</code> object
	 */
	public String getCGHType() {
		return CGHType;
	}

	/**
	 * Returns the sampleType for this SegmentMeanDE object.
	 * 
	 * @return the sampleType for this <code>SegmentMeanDE</code> object
	 */
	public String getSampleType() {
		return sampleType;
	}

	/**
	 * Sets the value for this <code>SegmentMeanDE</code> object
	 * 
	 * @param object
	 *            the value
	 */
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof Float))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((Float) obj);
	}

	/**
	 * Returns the CGHType for this SegmentMeanDE object.
	 * 
	 * @return the CGHType for this <code>SegmentMeanDE</code> object
	 */
	public Float getValueObject() {
		return (Float) getValue();
	}

	/**
	 * Sets the segmentMean for this <code>SegmentMeanDE</code> object
	 * 
	 * @param segmentMean
	 *            the segmentMean
	 */
	public void setValueObject(Float segmentMean) {
		if (segmentMean != null) {
			this.value = segmentMean;
		}
	}

	/**
	 * Sets the CGHType for this <code>SegmentMeanDE</code> object
	 * 
	 * @param CGHType
	 *            the CGHType
	 */
	public void GetCGHType(String CGHType) {
		if (CGHType != null) {
			value = CGHType;
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
		SegmentMeanDE myClone = (SegmentMeanDE) super.clone();
		return myClone;
	}

}
