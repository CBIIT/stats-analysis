package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.MRIClinicalEvalDE;

import java.io.Serializable;

/**
 * This class encapsulates MRIClinicalEvalDE criteria. It contains a collection of
 * MRIClinicalEvalDE.
 * 
 * @author Dana Zhang, BauerD
 */

public class MRIClinicalEvalCriteria extends Criteria implements Serializable,
		Cloneable {
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
	private MRIClinicalEvalDE mriClinicalEvalDE;
	
	/**
	 * Default constructor
	 *
	 */

	public MRIClinicalEvalCriteria() {
	}
   
	/**
	 * Sets the MRIClinicalEvalDE object
	 * 
	 */
	public void setMRIClinicalEvalDE(MRIClinicalEvalDE mriClinicalEvalDE) {
		if (mriClinicalEvalDE != null) {
			this.mriClinicalEvalDE = mriClinicalEvalDE;
		}
	}

	
	/**
	 * Gets the MRIClinicalEvalDE object
	 * 
	 */
	public MRIClinicalEvalDE getMRIClinicalEvalDE() {
		return mriClinicalEvalDE;
	}
	
	/**
	  *  Used to validate MRIClinicalEvalDE, returns true for now
	  */

	public boolean isValid() {
		return true;
	}
	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public Object clone() {
		MRIClinicalEvalCriteria myClone = null;
		myClone = (MRIClinicalEvalCriteria) super.clone();
		if(mriClinicalEvalDE!=null) {
			myClone.mriClinicalEvalDE = (MRIClinicalEvalDE) mriClinicalEvalDE.clone();
		}
		return myClone;
	}
}
