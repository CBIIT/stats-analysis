/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.de;

import gov.nih.nci.caintegrator.util.MathUtil;

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

abstract public class CopyNumberDE extends DomainElement implements
		Serializable, Cloneable, SNPableDE {

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
	 * type of CGH
	 */
	private String CGHType;

	/**
	 * private parent constructor utilized in the two nested/childe classes
	 * This default constructor needed by Castor XML
	 */
	private CopyNumberDE() {
		super("");
	}

	/**
	 * private parent constructor utilized in the two nested/childe classes
	 */
	private CopyNumberDE(String CGHType, Float value) {
			super(value);
			this.CGHType = CGHType;
	}

	/**
	 * nested child class: Amplification
	 */
	public final static class Amplification extends CopyNumberDE {
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
	public final static class Deletion extends CopyNumberDE {
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
	 * nested child class: UnChangedCopyNumberUpperLimit
	 */
	public final static class UnChangedCopyNumberUpperLimit extends
			CopyNumberDE {
		/**
		 * 
		 */
		private static final long serialVersionUID = 9221358191460841483L;

		public UnChangedCopyNumberUpperLimit() {
			super(UNCHANGED_UPPER_LIMIT, 0f);
		}

		public UnChangedCopyNumberUpperLimit(Float unChangedCopyNoUpperValue) {
			super(UNCHANGED_UPPER_LIMIT, unChangedCopyNoUpperValue);
		}

		public Object clone() {
			UnChangedCopyNumberUpperLimit myClone = (UnChangedCopyNumberUpperLimit) super
					.clone();
			return myClone;
		}

	}

	/**
	 * nested child class: UnChangedCopyNumberDownLimit
	 */
	public final static class UnChangedCopyNumberDownLimit extends CopyNumberDE {
		private static final long serialVersionUID = 9221358191460841483L;
		public UnChangedCopyNumberDownLimit() {
			super(UNCHANGED_DOWN_LIMIT, 0f);
		}
		
		public UnChangedCopyNumberDownLimit(Float unChangedCopyNoDownValue) {
			super(UNCHANGED_DOWN_LIMIT, unChangedCopyNoDownValue);
		}

		public Object clone() {
			UnChangedCopyNumberDownLimit myClone = (UnChangedCopyNumberDownLimit) super
					.clone();
			return myClone;
		}

	}

	/**
	 * nested child class: Unchange--make sure that we don't need this later
	 */
	/*
	 * public final static class Unchange extends CopyNumberDE { public
	 * Unchange(Float unchangeNumber) { super(UNCHANGE, unchangeNumber); }
	 *  }
	 */

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.SNPableDE#getCGHType()
	 */
	public String getCGHType() {
		return CGHType;
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.SNPableDE#setValue(java.lang.Object)
	 */
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof Float))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((Float) obj);
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.SNPableDE#getValueObject()
	 */
	public Float getValueObject() {
		return (Float) getValue();
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.SNPableDE#setValueObject(java.lang.Float)
	 */
	public void setValueObject(Float copyNumber) {
		if (copyNumber != null) {
			this.value = copyNumber;
		}
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.SNPableDE#GetCGHType(java.lang.String)
	 */
	public void GetCGHType(String CGHType) {
		if (CGHType != null) {
			value = CGHType;
		}
	}
	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.SNPableDE#clone()
	 */
	public Object clone() {
		SNPableDE myClone = (SNPableDE) super.clone();
		return myClone;
	}

}
