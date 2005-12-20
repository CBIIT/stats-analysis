package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.LanskyClinicalEvalDE;

import java.io.Serializable;

/**
 * This class encapsulates LanskyClinicalEvalDE criteria. It contains a collection of
 * LanskyClinicalEvalDE.
 * 
 * @author Dana Zhang, BauerD
 */

public class LanskyClinicalEvalCriteria extends Criteria implements Serializable,
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
	private LanskyClinicalEvalDE lanskyClinicalEvalDE;

	public LanskyClinicalEvalCriteria() {
	}

	public void setLanskyClinicalEvalDE(LanskyClinicalEvalDE lanskyClinicalEvalDE) {
		if (lanskyClinicalEvalDE != null) {
			this.lanskyClinicalEvalDE = lanskyClinicalEvalDE;
		}
	}

	public LanskyClinicalEvalDE getLanskyClinicalEvalDE() {
		return lanskyClinicalEvalDE;
	}

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
		LanskyClinicalEvalCriteria myClone = null;
		myClone = (LanskyClinicalEvalCriteria) super.clone();
		if(lanskyClinicalEvalDE!=null) {
			myClone.lanskyClinicalEvalDE = (LanskyClinicalEvalDE) lanskyClinicalEvalDE.clone();
		}
		return myClone;
	}
}
