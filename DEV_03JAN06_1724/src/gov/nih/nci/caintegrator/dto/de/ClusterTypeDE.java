/**
 * 
 */
package gov.nih.nci.caintegrator.dto.de;

import gov.nih.nci.caintegrator.enumeration.ClusterByType;


/**
 * @author sahnih
 *
 */
public class ClusterTypeDE extends DomainElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param value
	 */
	public ClusterTypeDE(ClusterByType clusterByType) {
		super(clusterByType);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.DomainElement#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof ClusterByType))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((ClusterByType) obj);
	}

	/**
	 * Returns the ClusterByType for this ClusterTypeDE obect.
	 * 
	 * @return the ClusterByType for this <code>ClusterTypeDE</code> object
	 */
	public ClusterByType getValueObject() {
		return (ClusterByType) getValue();
	}

	/**
	 * Sets the clusterByType for this <code>ClusterTypeDE</code> object
	 * 
	 * @param clusterByType
	 *            the clusterByType
	 */
	public void setValueObject(ClusterByType clusterByType) {
		if (clusterByType != null) {
			value = clusterByType;
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
		ClusterTypeDE myClone = (ClusterTypeDE) super.clone();
		return myClone;
	}

}
