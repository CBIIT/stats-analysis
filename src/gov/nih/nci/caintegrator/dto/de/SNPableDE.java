/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.caintegrator.dto.de;

public interface SNPableDE {

	/**
	 * Sample Type
	 */
	public static final String SAMPLE_TYPE = "SampleType";

	/**
	 * Amplification
	 */
	public static final String AMPLIFICATION = "Amplification";
	/**
	 * Deletion
	 */
	public static final String DELETION = "Deletion";
	/**
	 * UnchangedCopyNoUpperLimit
	 */
	public final static String UNCHANGED_UPPER_LIMIT = "UnchangedUpperLimit";
	/**
	 * UnchangedCopyNoDownLimit
	 */
	public final static String UNCHANGED_DOWN_LIMIT = "UnchangedDownLimit";

	/**
	 * Returns the CGHTpye for this CopyNumberDE obect.
	 * 
	 * @return the CGHTpye for this <code>CopyNumberDE</code> object
	 */
	public abstract String getCGHType();

	/**
	 * Sets the value for this <code>CopyNumberDE</code> object
	 * 
	 * @param object
	 *            the value
	 */
	public abstract void setValue(Object obj) throws Exception;

	/**
	 * Returns the CGHType for this CopyNumberDE obect.
	 * 
	 * @return the CGHType for this <code>CopyNumberDE</code> object
	 */
	public abstract Float getValueObject();

	/**
	 * Sets the copyNumber for this <code>CopyNumberDE</code> object
	 * 
	 * @param copyNumber
	 *            the copyNumber
	 */
	public abstract void setValueObject(Float copyNumber);

	/**
	 * Sets the CGHType for this <code>CopyNumberDE</code> object
	 * 
	 * @param CGHType
	 *            the CGHType
	 */
	public abstract void GetCGHType(String CGHType);

	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public abstract Object clone();

}