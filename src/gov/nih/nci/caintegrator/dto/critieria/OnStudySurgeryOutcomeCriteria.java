package gov.nih.nci.caintegrator.dto.critieria;


import gov.nih.nci.caintegrator.dto.de.OnStudySurgeryOutcomeDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates OnStudySurgeryOutcomeCriteria.
 * It contains a collection of one or more
 * Onstudy Therapy Section's OnStudySurgeryOutcomeDE.
 *
 * Dana Zhang Date: August 30, 2004 Version 1.0
 */

public class OnStudySurgeryOutcomeCriteria extends Criteria implements Serializable,
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
	private OnStudySurgeryOutcomeDE onStudySurgeryOutcomeDE;	
	
	/**
	 * Represents a collection of one or more 
	 * Onstudy Therapy OnStudySurgeryOutcomeDE object.
	 */
	private Collection outcomes;


  /**
    * Default constructor
    *
    */
	public OnStudySurgeryOutcomeCriteria() {
	}
	
	/**
	 * Sets the Onstudy therapy surgeryOutcome object by adding it to the collection
	 * one OnStudySurgeryOutcomeDE at a time
	 * 
	 */
	public void setOnStudySurgeryOutcomeDE(OnStudySurgeryOutcomeDE onStudySurgeryOutcomeDE) {
		if (onStudySurgeryOutcomeDE != null) {
			getOutcomeMembers().add(onStudySurgeryOutcomeDE);
			
		}
	}
	/**
	 * this is to deal with setting multiple onstudy therapy surgeryOutcome  entries
	 */
	public void setOutcomes(Collection multiOutcomes) {
		if (multiOutcomes != null) {
			Iterator iter = multiOutcomes.iterator();
			while (iter.hasNext()) {
				OnStudySurgeryOutcomeDE onStudySurgeryOutcomeDE = (OnStudySurgeryOutcomeDE) iter.next();
				getOutcomeMembers().add(onStudySurgeryOutcomeDE);
			}
		}
    }
	
 	/**
   	 * private method to get a collection of onstudy therapy surgeryOutcome objects
   	 */
	private Collection getOutcomeMembers() {
		if (outcomes == null) {
			outcomes = new ArrayList();
		}
		return outcomes;
	}

	  /**
	    * Returns a collection of OnStudySurgeryOutcomeDE objects.
	    * 
	    */
	public Collection getOutcomes() {
		return outcomes;
	}
	
	  /**
	    * Returns a single of OnStudySurgeryOutcomeDE objects.
	    * 
	    */
	public OnStudySurgeryOutcomeDE getOnStudySurgeryOutcomeDE() {
		return onStudySurgeryOutcomeDE;
	}

	/**
	 *  Used to validate onstudy Therapy surgery outcome, returns true for now
	 */
	public boolean isValid() {
		// find out later to see if we need validate OnStudySurgeryOutcomeDE
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
		OnStudySurgeryOutcomeCriteria myClone = null;
		myClone = (OnStudySurgeryOutcomeCriteria) super.clone();
		if(this.onStudySurgeryOutcomeDE!=null) {
			myClone.onStudySurgeryOutcomeDE = (OnStudySurgeryOutcomeDE) onStudySurgeryOutcomeDE.clone();
		}
		return myClone;
	}
}
