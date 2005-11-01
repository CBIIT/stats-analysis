package gov.nih.nci.caintegrator.enumeration;
/**
 * Comment this
 * @author SahniH
 *
 */
public enum FindingStatus {
	Error, Running, Completed;
	private String key;
	/**
	 * @return Returns the key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key The key to set.
	 */
	public void setKey(String key) {
		this.key = key;
	}
	 

}
