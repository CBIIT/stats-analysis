package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.PriorSurgeryTitleDE;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


/**
 * This class encapsulates Prior Therapy SurgeryTitle Criteria. 
 * It contains a collection of one or more
 * Prior Therapy Section's PriorSurgeryTitleDE
 *
 * @author Dana Zhang
 */


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
	
	/**
	 * Represents a collection of one or more 
	 * Prior Therapy PriorSurgeryTitleDE object.
	 */
	private Collection titles;
	
	/**
	 * Default constructor
	 *
	 */

	public PriorSurgeryTitleCriteria() {
	}

	/**
	 * Sets the prior therapy PriorSurgeryTitleDE object by adding it to the collection
	 * one PriorSurgeryTitleDE at a time
	 * 
	 */
	public void setPriorSurgeryTitleDE(PriorSurgeryTitleDE priorSurgeryTitleDE) {
		if (priorSurgeryTitleDE != null) {
			getTitleMembers().add(priorSurgeryTitleDE);
			
		}
	}
	
	/**
	 * this is to deal with setting multiple prior therapy PriorSurgeryTitleDE  entries
	 */
	
	public void setTitles(Collection multiTitles) {
		if (multiTitles != null) {
			Iterator iter = multiTitles.iterator();
			while (iter.hasNext()) {
				PriorSurgeryTitleDE priorSurgeryTitleDE = (PriorSurgeryTitleDE) iter.next();
				getTitleMembers().add(priorSurgeryTitleDE);
			}
		}
    }
	
	/**
   	 * private method to get a colletion of  prior therapy PriorSurgeryTitleDE objects.
   	 */
	
	private Collection getTitleMembers() {
		if (titles == null) {
			titles = new ArrayList();
		}
		return titles;
	}

	/**
	   * Returns a collection of PriorSurgeryTitleDE objects.
	   * 
	   */
	public Collection getTitles() {
		return titles;
	}
	
	/**
	  * Returns a single PriorSurgeryTitleDE object.
	  * 
	  */
	public PriorSurgeryTitleDE getPriorSurgeryTitleDE() {
		return priorSurgeryTitleDE;
	}

	/**
	 * Used to validate PriorSurgeryTitle, returns true for now
	 */
	public boolean isValid() {
		// find out later to see if we need validate PriorSurgeryTitle
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

