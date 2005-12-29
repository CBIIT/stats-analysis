/**
 * 
 */
package gov.nih.nci.caintegrator.dto.de;

import gov.nih.nci.caintegrator.enumeration.LinkageMethodType;


/**
 * @author sahnih
 *
 */
public class LinkageMethodTypeDE extends DomainElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param value
	 */
	public LinkageMethodTypeDE(LinkageMethodType linkageMethod) {
		super(linkageMethod);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.DomainElement#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof LinkageMethodType))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((LinkageMethodType) obj);
	}

	/**
	 * Returns the LinkageMethodType for this LinkageMethodTypeDE obect.
	 * 
	 * @return the LinkageMethodType for this <code>LinkageMethodTypeDE</code> object
	 */
	public LinkageMethodType getValueObject() {
		return (LinkageMethodType) getValue();
	}

	/**
	 * Sets the linkageMethod for this <code>LinkageMethodTypeDE</code> object
	 * 
	 * @param linkageMethod
	 *            the linkageMethod
	 */
	public void setValueObject(LinkageMethodType linkageMethod) {
		if (linkageMethod != null) {
			value = linkageMethod;
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
		LinkageMethodTypeDE myClone = (LinkageMethodTypeDE) super.clone();
		return myClone;
	}

}
