package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.OnStudySurgeryTitleDE;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class OnStudySurgeryTitleCriteria extends Criteria implements Serializable,
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

	private OnStudySurgeryTitleDE onStudySurgeryTitleDE;	
	private Collection titles;

	public OnStudySurgeryTitleCriteria() {
	}
	           
	public void setOnStudySurgeryTitleDE(OnStudySurgeryTitleDE onStudySurgeryTitleDE) {
		if (onStudySurgeryTitleDE != null) {
			getTitleMembers().add(onStudySurgeryTitleDE);
			
		}
	}

	public void setTitles(Collection multiTitles) {
		if (multiTitles != null) {
			Iterator iter = multiTitles.iterator();
			while (iter.hasNext()) {
				OnStudySurgeryTitleDE onStudySurgeryTitleDE = (OnStudySurgeryTitleDE) iter.next();
				getTitleMembers().add(onStudySurgeryTitleDE);
			}
		}
    }
	
	private Collection getTitleMembers() {
		if (titles == null) {
			titles = new ArrayList();
		}
		return titles;
	}

	public Collection getTitles() {
		return titles;
	}
	public OnStudySurgeryTitleDE getOnStudySurgeryTitleDE() {
		return onStudySurgeryTitleDE;
	}

	public boolean isValid() {
		// find out later to see if we need validate SurgeryTypes
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
		OnStudySurgeryTitleCriteria myClone = null;
		myClone = (OnStudySurgeryTitleCriteria) super.clone();
		if(this.onStudySurgeryTitleDE!=null) {
			myClone.onStudySurgeryTitleDE = (OnStudySurgeryTitleDE) onStudySurgeryTitleDE.clone();
		}
		return myClone;
	}
}

