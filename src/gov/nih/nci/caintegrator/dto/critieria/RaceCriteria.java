package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.OnStudySurgeryTitleDE;
import gov.nih.nci.caintegrator.dto.de.RaceDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class encapsulates RaceCriteria.
 * It contains a collection of one or more
 * RaceDE.
 *
 * Dana Zhang 
 */

public class RaceCriteria extends Criteria implements Serializable,Cloneable {
	
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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	
	/**
	 * Represents a collection of one or more 
	 * RaceDE object, it allows multi-select for races on UI
	 */
	
	private Collection races;
	
	/**
	  * Default constructor
	  *
	  */
	
	public RaceCriteria(){}
	
	
  
	/**
	 * Sets the raceDE object by adding it to the collection
	 * one RaceDE at a time
	 * 
	 */
	
	public void setRace(RaceDE raceNameDE) {
		if (raceNameDE != null) {
			getRaceMembers().add(raceNameDE);
		}
	}
	
   /**
	 * this is to deal with setting multiple race  entries
	 */
	
	public void setRaces(Collection multiRaces) {
		if (multiRaces != null) {
			Iterator iter = multiRaces.iterator();
			while (iter.hasNext()) {
				RaceDE racede = (RaceDE) iter.next();
				getRaceMembers().add(racede);
			}
		}
	}

	/**
   	 * private method to get a collection of RaceDE objects
   	 */
    private Collection getRaceMembers(){
    	if (races == null) {
    		races = new ArrayList();
		}   
    	return races;    	
    }
    
    /**
	  * Returns a collection of RaceDE objects.
	  * 
	  */
    
    public Collection getRaces() {
		return races;
	}
    
    /**
	 *  Used to validate race, returns true for now
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
		
		RaceCriteria myClone = null;
		myClone = (RaceCriteria) super.clone();
		if(races!=null) {
			myClone.races = new ArrayList();
			for (Iterator i = races.iterator(); i.hasNext();) {
				myClone.races.add(((RaceDE) i.next()).clone());
			}
		}
		
		return myClone;
	}

}
