package gov.nih.nci.cgems.dto;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/
/**
 * A set of SNP genotype assays, typically packaged and performed in a multiplex
 * assay.
 */

public class PanelCriteria {

	/**
	 * textual identifier for the panel
	 */
	private String name;

    /**
	 * vendor assigned version identifier for the panel
	 */
	private String version;


    public PanelCriteria(){ }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}