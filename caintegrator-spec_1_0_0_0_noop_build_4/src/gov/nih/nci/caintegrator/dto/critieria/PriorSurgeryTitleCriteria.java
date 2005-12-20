package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.PriorSurgeryTitleDE;
import gov.nih.nci.caintegrator.dto.de.SurgeryOutcomeDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class PriorSurgeryTitleCriteria extends Criteria implements Serializable,
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

	private PriorSurgeryTitleDE priorSurgeryTitleDE;	
	private Collection titles;

	public PriorSurgeryTitleCriteria() {
	}

	public void setPriorSurgeryTitleDE(PriorSurgeryTitleDE priorSurgeryTitleDE) {
		if (priorSurgeryTitleDE != null) {
			getTitleMembers().add(priorSurgeryTitleDE);
			
		}
	}

	public void setTitles(Collection multiTitles) {
		if (multiTitles != null) {
			Iterator iter = multiTitles.iterator();
			while (iter.hasNext()) {
				PriorSurgeryTitleDE priorSurgeryTitleDE = (PriorSurgeryTitleDE) iter.next();
				getTitleMembers().add(priorSurgeryTitleDE);
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
	public PriorSurgeryTitleDE getPriorSurgeryTitleDE() {
		return priorSurgeryTitleDE;
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
		PriorSurgeryTitleCriteria myClone = null;
		myClone = (PriorSurgeryTitleCriteria) super.clone();
		if(this.priorSurgeryTitleDE!=null) {
			myClone.priorSurgeryTitleDE = (PriorSurgeryTitleDE) priorSurgeryTitleDE.clone();
		}
		return myClone;
	}
}

