package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.OnStudyRadiationTherapyDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates OnStudyRadiationTherapyCriteria.
 * It contains a collection of one or more
 * Onstudy Therapy Section's OnStudyRadiationTherapyDE.
 *
 * Dana Zhang Date: August 30, 2004 Version 1.0
 */

public class OnStudyRadiationTherapyCriteria extends Criteria implements Serializable,
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
	private OnStudyRadiationTherapyDE onStudyRadiationTherapyDE;
	
	/**
	 * Represents a collection of one or more 
	 * Onstudy Therapy OnStudyRadiationTherapyDE object.
	 */
	private Collection radiationSites;

	 /**
     * Default constructor
     *
     */
	public OnStudyRadiationTherapyCriteria() {
	}
	
	/**
	 * Sets the Onstudy therapy radiation object by adding it to the collection
	 * one OnStudyRadiationTherapyDE at a time
	 * 
	 */

	public void setOnStudyRadiationTherapyDE(OnStudyRadiationTherapyDE onStudyRadiationTherapyDE) {
		if (onStudyRadiationTherapyDE != null) {
			getRadiationMembers().add(onStudyRadiationTherapyDE);
			
		}
	}

	/**
	 * this is to deal with setting multiple onstudy therapy radiation  entries
	 */
   	public void setRadiations(Collection multiRadiations) {
   			if (multiRadiations != null) {
   				Iterator iter = multiRadiations.iterator();
   				while (iter.hasNext()) {
   					OnStudyRadiationTherapyDE onStudyRadiationTherapyDE = (OnStudyRadiationTherapyDE) iter.next();
   					getRadiationMembers().add(onStudyRadiationTherapyDE);
   				}
   			}
   	}

   	/**
   	 * private method to get a collection of onstudy therapy radiation objects
   	 */
   private Collection getRadiationMembers() {
		if (radiationSites == null) {
			radiationSites = new ArrayList();
		}
		return radiationSites;
	}

   /**
    * Returns a collection of onStudyRadiationTherapyDE objects.
    * 
    */
   public Collection getRadiations() {
   		return radiationSites;
	}
   
   /**
	 * Returns a single of onStudyRadiationTherapyDE object.
	 * 
	 */
	public OnStudyRadiationTherapyDE getOnStudyRadiationTherapyDE() {
		return onStudyRadiationTherapyDE;
	}
	
	/**
	 *  Used to validate onstudy Therapy radiation, returns true for now
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
		OnStudyRadiationTherapyCriteria myClone = null;
		myClone = (OnStudyRadiationTherapyCriteria) super.clone();
		if(this.onStudyRadiationTherapyDE!=null) {
			myClone.onStudyRadiationTherapyDE = (OnStudyRadiationTherapyDE) onStudyRadiationTherapyDE
					.clone();
		}
		return myClone;
	}

}
