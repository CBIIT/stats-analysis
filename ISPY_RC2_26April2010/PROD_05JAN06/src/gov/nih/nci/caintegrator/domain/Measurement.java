package gov.nih.nci.caintegrator.domain;





/**
 * @version 1.0
 * @created 18-Nov-2005 01:56:52 PM
 */
public class Measurement {

	private Long id;
	/**
	 * A standard of basic quantity or increment by which something is divided, counted, or described, such as ml, kg, mm, m/s,
	 * °F, etc.
	 */
	private String unit;
	/**
	 * The actual numerical or textual quantity such as 10.0 or "Satisfactory".
	 */
	private String value;

	public Measurement(){

	}

	/**
	 * @return Returns the id.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id The id to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return Returns the unit.
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit The unit to set.
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}

}