package gov.nih.nci.caintegrator.domain;





/**
 * A unique macroscopic (gross) anatomic structure composed of various cells and tissues that performs a specific function
 * and is part of an anatomic system or a region of the body which is essential to the life or well-being of the whole.
 * @created 18-Nov-2005 01:56:52 PM
 */
public class Organ {

	private Long id;
	/**
	 * Defines a part of the body that performs a specific function. For example, the heart is an organ.
	 */
	private String name;

	public Organ(){

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
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

}