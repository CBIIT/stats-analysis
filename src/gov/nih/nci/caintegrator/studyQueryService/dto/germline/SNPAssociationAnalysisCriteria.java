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

	private String methods;
	private String name;
    private String studyName;

    public SNPAssociationAnalysisCriteria(String studyName) {
        this.studyName = studyName;
    }

    public String getStudyName() {
        return studyName;
    }

    public void setStudyName(String studyName) {
        this.studyName = studyName;
    }

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