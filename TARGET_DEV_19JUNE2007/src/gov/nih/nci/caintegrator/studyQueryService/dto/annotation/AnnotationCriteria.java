package gov.nih.nci.caintegrator.studyQueryService.dto.annotation;

import gov.nih.nci.caintegrator.enumeration.ArrayPlatformType;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.OperatorType;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.PanelCriteria;

import java.util.Collection;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/

public class AnnotationCriteria {

    private gov.nih.nci.caintegrator.studyQueryService.dto.annotation.CytobandCriteria cytobandCriteria;
    private String[] geneOntology;
    private String[] genePathways;
    private Collection<String> geneSymbols;
    private gov.nih.nci.caintegrator.studyQueryService.dto.germline.OperatorType operatorType;
    private gov.nih.nci.caintegrator.studyQueryService.dto.germline.PanelCriteria panelCriteria;
    private gov.nih.nci.caintegrator.studyQueryService.dto.annotation.PhysicalPositionCriteria physicalPositionCriteria;
    private Collection<String> snpIdentifiers;
    private ArrayPlatformType arrayPlatformType;
    private Collection<String> reporterIds;



    public AnnotationCriteria(){ }

    public gov.nih.nci.caintegrator.studyQueryService.dto.annotation.CytobandCriteria getCytobandCriteria() {
        return cytobandCriteria;
    }

    public void setCytobandCriteria(CytobandCriteria cytobandCriteria) {
        this.cytobandCriteria = cytobandCriteria;
    }

/*  NOT IMPLEMENTED (confirmed with customer)   
    private String[] geneLocations;

    public String[] getGeneLocations() {
        return geneLocations;
    }

    public void setGeneLocations(String[] geneLocations) {
        this.geneLocations = geneLocations;
    }
 */
    public String[] getGeneOntology() {
        return geneOntology;
    }

    public void setGeneOntology(String[] geneOntology) {
        this.geneOntology = geneOntology;
    }

    public String[] getGenePathways() {
        return genePathways;
    }

    public void setGenePathways(String[] genePathways) {
        this.genePathways = genePathways;
    }

    public Collection<String> getGeneSymbols() {
        return geneSymbols;
    }

    public void setGeneSymbols(Collection<String> geneSymbols) {
        this.geneSymbols = geneSymbols;
    }

    public OperatorType getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(OperatorType operatorType) {
        this.operatorType = operatorType;
    }

    public PanelCriteria getPanelCriteria() {
        return panelCriteria;
    }

    public void setPanelCriteria(PanelCriteria panelCriteria) {
        this.panelCriteria = panelCriteria;
    }

    public gov.nih.nci.caintegrator.studyQueryService.dto.annotation.PhysicalPositionCriteria getPhysicalPositionCriteria() {
        return physicalPositionCriteria;
    }

    public void setPhysicalPositionCriteria(PhysicalPositionCriteria physicalPositionCriteria) {
        this.physicalPositionCriteria = physicalPositionCriteria;
    }

    public Collection<String> getSnpIdentifiers() {
        return snpIdentifiers;
    }

    public void setSnpIdentifiers(Collection<String> snpIdentifiers) {
        this.snpIdentifiers = snpIdentifiers;
    }

    public ArrayPlatformType getArrayPlatformType() {
        return arrayPlatformType;
    }

    public void setArrayPlatformType(ArrayPlatformType arrayPlatformType) {
        this.arrayPlatformType = arrayPlatformType;
    }
    
	@Override
	public String toString()
	{
		String str = "SNP Annotation Criteria\n";
		
		if (panelCriteria != null)
			str = str + panelCriteria.toString();
		
		if (physicalPositionCriteria != null)
			str = str + physicalPositionCriteria.toString();
		
		if ((geneSymbols != null) && (geneSymbols.size() > 0))
		{
			str = str + "HUGO Gene Symbols:\n";
			for (String gene : geneSymbols)
			{
				str = str + gene + "\n";
			}
		}
		
		if ((snpIdentifiers != null) && (snpIdentifiers.size() > 0))
		{
			str = str + "SNP Identifiers:\n";
			for (String snp : snpIdentifiers)
			{
				str = str + snp + "\n";
			}
		}
		
		return str;
	}

    public Collection<String> getReporterIds() {
        return reporterIds;
    }

    public void setReporterIds(Collection<String> reporterIds) {
        this.reporterIds = reporterIds;
    }


}