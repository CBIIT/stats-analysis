package gov.nih.nci.caintegrator.domain.annotation.service;

import gov.nih.nci.caintegrator.domain.annotation.gene.bean.CytobandPosition;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneAlias;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneExprReporter;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.VariationReporter;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface AnnotationManager {

    public Map<String, GeneBiomarker> getGenesForReporters(
            AnnotationCriteria criteria);

    public Map<GeneBiomarker, Collection<GeneExprReporter>> getReportersForGenes(
            AnnotationCriteria criteria);
    
    public GeneBiomarker getGeneForSymbol(String geneId);
    
    public List<GeneAlias> getGeneAliasForSymbol(String symbol);
    
    public List<CytobandPosition> getCytobandPositions(String chromosome, String startCytoband, String endCytoband);
    
    public List<CytobandPosition> getCytobandPositions(String chromosome);
    
    public List<VariationReporter> getReportersForDbSnpId(String dbSnpId);
    
    public List<SNPAnnotation> getSnpAnnotationsForGene(String geneId, Long kbUpstream, Long kbDownstream);
    
}
