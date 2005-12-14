package gov.nih.nci.caintegrator.dto.de;

import java.io.Serializable;

/**
 * This  class encapsulates the properties of an caintergator 
 * InstitutionDE object.
 *  
 * @author Dana Zhang, BauerD
 */
public class InstitutionDE extends DomainElement implements Serializable, Cloneable{
   
     private String instituteName;
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
    * Initializes a newly created <code>InstitutionDE</code> object so that it represents an InstitutionDE.
    */
    public InstitutionDE(String institutionName, Long instituteID) {
       super(instituteID);
       this.instituteName = institutionName;
    }

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    /**
    * Sets the value for this <code>InstitutionDE</code> object
    * @param object the value    
	*/  	
    public void setValue(Object obj) throws Exception {
        if (! (obj instanceof Long) )
            throw new Exception ( "Could not set the value.  Parameter is of invalid data type: " + obj);
        setValueObject((Long)obj);
    }

  /**
    * Returns the institutionName for this InstitutionDE obect.
    * @return the institutionName for this <code>InstitutionDE</code> object
    */	
    public Long getValueObject() {
        return (Long) getValue();
    }

  /**
    * Sets the institutionName for this <code>InstitutionDE</code> object
    * @param instituteID the instituteID
	*/ 
    public void setValueObject(Long instituteID) {
	  if(instituteID != null){
        value = instituteID;
		}
    }
    /**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
    public Object clone() {
    	InstitutionDE myClone = (InstitutionDE) super.clone();
		return myClone;
	}
}
