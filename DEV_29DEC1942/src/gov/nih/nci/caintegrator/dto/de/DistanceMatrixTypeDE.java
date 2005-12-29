/**
 * 
 */
package gov.nih.nci.caintegrator.dto.de;

import gov.nih.nci.caintegrator.enumeration.DistanceMatrixType;


/**
 * @author sahnih
 *
 */
public class DistanceMatrixTypeDE extends DomainElement {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @param value
	 */
	public DistanceMatrixTypeDE(DistanceMatrixType distanceMatrixType) {
		super(distanceMatrixType);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see gov.nih.nci.caintegrator.dto.de.DomainElement#setValue(java.lang.Object)
	 */
	@Override
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof DistanceMatrixType))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((DistanceMatrixType) obj);
	}

	/**
	 * Returns the DistanceMatrixType for this DistanceMatrixTypeDE obect.
	 * 
	 * @return the DistanceMatrixType for this <code>DistanceMatrixTypeDE</code> object
	 */
	public DistanceMatrixType getValueObject() {
		return (DistanceMatrixType) getValue();
	}

	/**
	 * Sets the distanceMatrixType for this <code>DistanceMatrixTypeDE</code> object
	 * 
	 * @param distanceMatrixType
	 *            the distanceMatrixType
	 */
	public void setValueObject(DistanceMatrixType distanceMatrixType) {
		if (distanceMatrixType != null) {
			value = distanceMatrixType;
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
		DistanceMatrixTypeDE myClone = (DistanceMatrixTypeDE) super.clone();
		return myClone;
	}

}
