package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.OnStudyChemoAgentDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates OnStudyChemoAgentCriteria. 
 * It contains a collection of one or more
 * Onstudy Therapy Section's OnStudyChemoAgentDE.
 *
 * Dana Zhang Date: August 30, 2004 Version 1.0
 */
public class OnStudyChemoAgentCriteria extends Criteria implements Serializable,
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
	private OnStudyChemoAgentDE onStudychemoAgentDE;
	
	/**
	 * Represents a collection of one or more 
	 * Onstudy Therapy OnStudyChemoAgentDE object.
	 */
	private Collection agents;

	
	 /**
     * Default constructor
     *
     */
	public OnStudyChemoAgentCriteria() {
	}



	/**
	 * Sets the Onstudy therapy chemoAgent object by adding it to the collection
	 * one OnStudyChemoAgentDE at a time
	 * 
	 */
	public void setOnStudyChemoAgentDE(OnStudyChemoAgentDE onStudychemoAgentDE) {
		if (onStudychemoAgentDE != null) {
			
			getAgentMembers().add(onStudychemoAgentDE);
		}
	}

	

	/**
	 * this is to deal with setting multiple onstudy therapy chemoAgent  entries
	 */
		
	public void setAgents(Collection multiAgents) {
			if (multiAgents != null) {
				Iterator iter = multiAgents.iterator();
				while (iter.hasNext()) {
					OnStudyChemoAgentDE onStudychemoAgentDE = (OnStudyChemoAgentDE) iter.next();
					getAgentMembers().add(onStudychemoAgentDE);
				}
			}
	}

	/**
   	 * private method to get a collection of onstudy therapy chemoAgent objects
   	 */
  private Collection getAgentMembers() {
		if (agents == null) {
			agents = new ArrayList();
		}
		return agents;
	}
  
  /**
   * Returns a collection of OnStudyChemoAgentDE objects.
   * 
   */

	public Collection getAgents() {
		return agents;
	}
	/**
	   * Returns a single of OnStudyChemoAgentDE object.
	   * 
	   */
	public OnStudyChemoAgentDE getOnStudyChemoAgentDE() {
			return onStudychemoAgentDE;
		}
	 
	/**
	 *  Used to validate onstudy Therapy chemoAgent, returns true for now
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
		OnStudyChemoAgentCriteria myClone = null;
		myClone = (OnStudyChemoAgentCriteria) super.clone();
		if(onStudychemoAgentDE!=null) {
			myClone.onStudychemoAgentDE = (OnStudyChemoAgentDE) onStudychemoAgentDE.clone();
		}
		return myClone;
	}
}
