package gov.nih.nci.caintegrator.dto.critieria;


import gov.nih.nci.caintegrator.dto.de.SurgeryOutcomeDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates prior therapy SurgeryType criteria. 
 * It contains a collection of prior therapy SurgeryTypeDE.
 *
 * @author Dana Zhang
 */

public class SurgeryOutcomeCriteria extends Criteria implements Serializable,
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
	
	private SurgeryOutcomeDE surgeryOutcomeDE;	
	
	/**
	 * Represents a collection of one or more 
	 * Prior Therapy SurgeryOutcomeDE object.
	 */
	private Collection outcomes;

	/**
	 * Default constructor
	 *
	 */
	public SurgeryOutcomeCriteria() {
	}
	
	/**
	 * Sets the prior therapy SurgeryOutcomeDE object by adding it to the collection
	 * one prior therapy SurgeryOutcomeDE at a time
	 * 
	 */

	public void setSurgeryOutcomeDE(SurgeryOutcomeDE surgeryOutcomeDE) {
		if (surgeryOutcomeDE != null) {
			getOutcomeMembers().add(surgeryOutcomeDE);
			
		}
	}
	
	/**
	 * this is to deal with setting multiple prior therapy SurgeryOutcomeDE  entries
	 */
	public void setOutcomes(Collection multiOutcomes) {
		if (multiOutcomes != null) {
			Iterator iter = multiOutcomes.iterator();
			while (iter.hasNext()) {
				SurgeryOutcomeDE surgeryOutcomeDE = (SurgeryOutcomeDE) iter.next();
				getOutcomeMembers().add(surgeryOutcomeDE);
			}
		}
    }

	/**
   	 * private method to get a colletion of  prior therapy SurgeryOutcomeDE objects.
   	 */
	private Collection getOutcomeMembers() {
		if (outcomes == null) {
			outcomes = new ArrayList();
		}
		return outcomes;
	}

	/**
	  * Returns a collection of prior therapy SurgeryOutcomeDE objects.
	  * 
	  */
	public Collection getOutcomes() {
		return outcomes;
	}
	
	/**
	  * Returns a single prior therapy SurgeryOutcomeDE object.
	  * 
	  */
	public SurgeryOutcomeDE getSurgeryOutcomeDE() {
		return surgeryOutcomeDE;
	}

	/**
	 * Used to validate SurgeryOutcomeDE, returns true for now
	 */
	public boolean isValid() {
		// find out later to see if we need validate SurgeryOutcomeDE
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
		SurgeryOutcomeCriteria myClone = null;
		myClone = (SurgeryOutcomeCriteria) super.clone();
		if(this.surgeryOutcomeDE!=null) {
			myClone.surgeryOutcomeDE = (SurgeryOutcomeDE) surgeryOutcomeDE.clone();
		}
		return myClone;
	}
}
