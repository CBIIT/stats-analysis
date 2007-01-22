package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

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
	//private String name;

	private Long snpPanelID;


    public PanelCriteria(){ }

/*
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
*/

    public Long getSnpPanelID() {
        return snpPanelID;
    }

    public void setSnpPanelID(Long snpPanelID) {
        this.snpPanelID = snpPanelID;
    }
}