package gov.nih.nci.caintegrator.dto.de;

import gov.nih.nci.caintegrator.enumeration.Operator;
import gov.nih.nci.caintegrator.enumeration.StatisticalSignificanceType;

public class GeneVectorPercentileDE extends DomainElement {
	private Operator operator = Operator.GE;
	/**
	 * @param value
	 * @param operator
	 */
	public GeneVectorPercentileDE(Double value, Operator operator) {
		super(value);
		this.operator = operator;
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void setValue(Object obj) throws Exception {
		if (!(obj instanceof Double))
			throw new Exception(
					"Could not set the value.  Parameter is of invalid data type: "
							+ obj);
		setValueObject((Double) obj);
	}
	/**
	 * Sets the percentile for this <code>GeneVectorPercentileDE</code> object
	 * 
	 * @param percentile
	 *            the percentile
	 */
	public void setValueObject(Double percentile) {
		if (percentile != null) {
			value = percentile;
		}
	}
	/**
	 * Returns the percentile for this GeneVectorPercentileDE obect.
	 * 
	 * @return the percentile for this <code>GeneVectorPercentileDE</code> object
	 */
	public Double getValueObject() {
		return (Double) getValue();
	}
	public Operator getOperator() {
		return operator;
	}
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	/**
	 * Overrides the protected Object.clone() method exposing it as public.
	 * It performs a 2 tier copy, that is, it does a memcopy of the instance
	 * and then sets all the non-primitive data fields to clones of themselves.
	 * 
	 * @return -A minimum 2 deep copy of this object.
	 */
	public Object clone() {
		GeneVectorPercentileDE myGeneVectorPercentileDE = (GeneVectorPercentileDE) super.clone();
		return myGeneVectorPercentileDE;
	}

}
