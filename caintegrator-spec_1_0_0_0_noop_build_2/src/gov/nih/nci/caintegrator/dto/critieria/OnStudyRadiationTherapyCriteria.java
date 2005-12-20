package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.OnStudyRadiationTherapyDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates RadiationTherapyDE criteria. It contains a collection
 * of RadiationTherapyDE.
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
	private Collection radiationSites;


	public OnStudyRadiationTherapyCriteria() {
	}

	public void setOnStudyRadiationTherapyDE(OnStudyRadiationTherapyDE onStudyRadiationTherapyDE) {
		if (onStudyRadiationTherapyDE != null) {
			getRadiationMembers().add(onStudyRadiationTherapyDE);
			
		}
	}

   	// this is to deal with multiple disease entries
   	public void setRadiations(Collection multiRadiations) {
   			if (multiRadiations != null) {
   				Iterator iter = multiRadiations.iterator();
   				while (iter.hasNext()) {
   					OnStudyRadiationTherapyDE onStudyRadiationTherapyDE = (OnStudyRadiationTherapyDE) iter.next();
   					getRadiationMembers().add(onStudyRadiationTherapyDE);
   				}
   			}
   	}

   private Collection getRadiationMembers() {
		if (radiationSites == null) {
			radiationSites = new ArrayList();
		}
		return radiationSites;
	}

   public Collection getRadiations() {
   		return radiationSites;
	}
	public OnStudyRadiationTherapyDE getOnStudyRadiationTherapyDE() {
		return onStudyRadiationTherapyDE;
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
		OnStudyRadiationTherapyCriteria myClone = null;
		myClone = (OnStudyRadiationTherapyCriteria) super.clone();
		if(this.onStudyRadiationTherapyDE!=null) {
			myClone.onStudyRadiationTherapyDE = (OnStudyRadiationTherapyDE) onStudyRadiationTherapyDE
					.clone();
		}
		return myClone;
	}

}
