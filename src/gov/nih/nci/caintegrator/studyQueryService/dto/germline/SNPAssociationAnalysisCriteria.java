package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

/**
 * A set of univeriate genetic analysie to detect association between phenotypic
 * characteristics shared by groups of subjects and their genotypes at a series of
 * SNP loci.

 /**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
 */

public class SNPAssociationAnalysisCriteria {

	/**
	 * Overview of the methods used to perform the SNP association analysis
	 */
	private String methods;
	/**
	 * A textual identifier for the SNP association analysis
	 */
	private String name;

	public SNPAssociationAnalysisCriteria(){ }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}                                   ;