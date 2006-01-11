package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.KarnofskyClinicalEvalDE;

import java.io.Serializable;

/**
 * This class encapsulates KarnofskyClinicalEvalDE criteria. It contains a collection of
 * KarnofskyClinicalEvalDE object.
 * 
 * @author Dana Zhang, BauerD
 */

public class KarnofskyClinicalEvalCriteria extends Criteria implements Serializable,
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
	private KarnofskyClinicalEvalDE karnofskyClinicalEvalDE;
	
	/**
	 * Default constructor
	 *
	 */

	public KarnofskyClinicalEvalCriteria() {
	}
	
	/**
	 * Sets the KarnofskyClinicalEvalDE object
	 * 
	 */

	public void setKarnofskyClinicalEvalDE(KarnofskyClinicalEvalDE karnofskyClinicalEvalDE) {
		if (karnofskyClinicalEvalDE != null) {
			this.karnofskyClinicalEvalDE = karnofskyClinicalEvalDE;
		}
	}

	/**
	 * Gets the KarnofskyClinicalEvalDE object
	 * 
	 */
	public KarnofskyClinicalEvalDE getKarnofskyClinicalEvalDE() {
		return karnofskyClinicalEvalDE;
	}

	/**
	  *  Used to validate karnofskyClinicalEvalDE, returns true for now
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
		KarnofskyClinicalEvalCriteria myClone = null;
		myClone = (KarnofskyClinicalEvalCriteria) super.clone();
		if(karnofskyClinicalEvalDE!=null) {
			myClone.karnofskyClinicalEvalDE = (KarnofskyClinicalEvalDE) karnofskyClinicalEvalDE.clone();
		}
		return myClone;
	}
}
