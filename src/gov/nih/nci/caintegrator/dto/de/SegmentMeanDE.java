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
* caIntegrator License
* 
* Copyright 2001-2005 Science Applications International Corporation ("SAIC"). 
* The software subject to this notice and license includes both human readable source code form and machine readable, 
* binary, object code form ("the caIntegrator Software"). The caIntegrator Software was developed in conjunction with 
* the National Cancer Institute ("NCI") by NCI employees and employees of SAIC. 
* To the extent government employees are authors, any rights in such works shall be subject to Title 17 of the United States
* Code, section 105. 
* This caIntegrator Software License (the "License") is between NCI and You. "You (or "Your") shall mean a person or an 
* entity, and all other entities that control, are controlled by, or are under common control with the entity. "Control" 
* for purposes of this definition means (i) the direct or indirect power to cause the direction or management of such entity,
*  whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) 
* beneficial ownership of such entity. 
* This License is granted provided that You agree to the conditions described below. NCI grants You a non-exclusive, 
* worldwide, perpetual, fully-paid-up, no-charge, irrevocable, transferable and royalty-free right and license in its rights 
* in the caIntegrator Software to (i) use, install, access, operate, execute, copy, modify, translate, market, publicly 
* display, publicly perform, and prepare derivative works of the caIntegrator Software; (ii) distribute and have distributed 
* to and by third parties the caIntegrator Software and any modifications and derivative works thereof; 
* and (iii) sublicense the foregoing rights set out in (i) and (ii) to third parties, including the right to license such 
* rights to further third parties. For sake of clarity, and not by way of limitation, NCI shall have no right of accounting
* or right of payment from You or Your sublicensees for the rights granted under this License. This License is granted at no
* charge to You. 
* 1. Your redistributions of the source code for the Software must retain the above copyright notice, this list of conditions
*    and the disclaimer and limitation of liability of Article 6, below. Your redistributions in object code form must reproduce 
*    the above copyright notice, this list of conditions and the disclaimer of Article 6 in the documentation and/or other materials
*    provided with the distribution, if any. 
* 2. Your end-user documentation included with the redistribution, if any, must include the following acknowledgment: "This 
*    product includes software developed by SAIC and the National Cancer Institute." If You do not include such end-user 
*    documentation, You shall include this acknowledgment in the Software itself, wherever such third-party acknowledgments 
*    normally appear.
* 3. You may not use the names "The National Cancer Institute", "NCI" "Science Applications International Corporation" and 
*    "SAIC" to endorse or promote products derived from this Software. This License does not authorize You to use any 
*    trademarks, service marks, trade names, logos or product names of either NCI or SAIC, except as required to comply with
*    the terms of this License. 
* 4. For sake of clarity, and not by way of limitation, You may incorporate this Software into Your proprietary programs and 
*    into any third party proprietary programs. However, if You incorporate the Software into third party proprietary 
*    programs, You agree that You are solely responsible for obtaining any permission from such third parties required to 
*    incorporate the Software into such third party proprietary programs and for informing Your sublicensees, including 
*    without limitation Your end-users, of their obligation to secure any required permissions from such third parties 
*    before incorporating the Software into such third party proprietary software programs. In the event that You fail 
*    to obtain such permissions, You agree to indemnify NCI for any claims against NCI by such third parties, except to 
*    the extent prohibited by law, resulting from Your failure to obtain such permissions. 
* 5. For sake of clarity, and not by way of limitation, You may add Your own copyright statement to Your modifications and 
*    to the derivative works, and You may provide additional or different license terms and conditions in Your sublicenses 
*    of modifications of the Software, or any derivative works of the Software as a whole, provided Your use, reproduction, 
*    and distribution of the Work otherwise complies with the conditions stated in this License.
* 6. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, 
*    THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. 
*    IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE, SAIC, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, 
*    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
*    GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
*    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
*    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
*/

abstract public class SegmentMeanDE extends DomainElement implements
		Serializable, Cloneable {

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

	/**
	 * Amplification
	 */
	public static final String AMPLIFICATION = "Amplification";

	/**
	 * Deletion
	 */
	public static final String DELETION = "Deletion";

	/**
	 * UnchangedSegMeanUpperLimit
	 */
	public final static String UNCHANGED_SEGMENTMEAN_UPPER_LIMIT = "UnchangedSegMeanUpperLimit";

	/**
	 * UnchangedSegMeanDownLimit
	 */
	public final static String UNCHANGED_SEGMENTMEAN_DOWN_LIMIT = "UnchangedSegMeanDownLimit";


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
			super(UNCHANGED_SEGMENTMEAN_UPPER_LIMIT, 0f);
		}

		public UnChangedSegmentMeanUpperLimit(Float unChangedSegMeanUpperValue) {
			super(UNCHANGED_SEGMENTMEAN_UPPER_LIMIT, unChangedSegMeanUpperValue);
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
			super(UNCHANGED_SEGMENTMEAN_DOWN_LIMIT, 0f);
		}
		
		public UnChangedSegmentMeanDownLimit(Float unChangedCopyNoDownValue) {
			super(UNCHANGED_SEGMENTMEAN_DOWN_LIMIT, unChangedCopyNoDownValue);
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
	 * Sets the CGHType for this <code>CopyNumberDE</code> object
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
