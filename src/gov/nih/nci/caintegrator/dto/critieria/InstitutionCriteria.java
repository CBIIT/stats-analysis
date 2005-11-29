package gov.nih.nci.caintegrator.dto.critieria;

import gov.nih.nci.caintegrator.dto.de.InstitutionDE;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class InstitutionCriteria  extends Criteria implements Serializable,Cloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	private Collection<InstitutionDE> institutes;

    public void setInstitutions(Collection<InstitutionDE> institutes) {
    	this.institutes = institutes;
	}

	public void setInsitution(InstitutionDE institution) {
		getInstitutions().add(institution);
	}

	public Collection<InstitutionDE> getInstitutions() {
		if (institutes == null)
			institutes = new ArrayList<InstitutionDE>();
		return institutes;
	}

	public InstitutionCriteria() {
	}

	public boolean isValid() {
		// TODO: see if we need any validation
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
		InstitutionCriteria myClone = null;
		myClone = (InstitutionCriteria) super.clone();
		if(this.institutes!=null) {
			myClone.institutes= new ArrayList();
			for (Iterator i = institutes.iterator(); i.hasNext();) {
				myClone.institutes.add((InstitutionDE)((InstitutionDE) i.next()).clone());
			}
		}
		return myClone;
	}
}
