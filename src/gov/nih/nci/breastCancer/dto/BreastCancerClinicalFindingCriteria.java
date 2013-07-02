/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.breastCancer.dto;


import gov.nih.nci.breastCancer.service.BreastCancerClinicalFindingHandler;
import gov.nih.nci.breastCancer.service.ClinicalFindingHandler;
import gov.nih.nci.caintegrator.enumeration.Operator;

import java.util.Set;

public class BreastCancerClinicalFindingCriteria extends ClinicalFindingCriteria
{
    private Set<String> clinicalStageCollection;
    private Set<String> clinicalResponseCollection;
    private Double longestDiameter;
    private Operator longestDiameterOperator;
    private Double nodeSizeClinical;
    private Operator nodeSizeClinicalOperator;
    private Set<String> nodalMorphologyCollection;
    private Double pathologicalTumorSize;
    private Operator pathologicalTumorSizeOperator;
    private Double percentLDChange;
    private Operator percentLDChangeOperator;
    private String percentLDChangeTimeCourse;
    private Set<String> estrogenReceptorStatusCollection;
    private Set<String> her2AssessmentCollection;
    private Set<String> progesteronReceptorStatusCollection;
    private Set<String> chemoCollection;
    
    /**
     * Get the specific handler for the BreastCancerClinicalFinding object
     * 
     * @return Returns the specific clinical finding handler
     */
    public ClinicalFindingHandler getHandler()
    {
        return new BreastCancerClinicalFindingHandler();
    }

    /**
     * @return Returns the clinicalResponseCollection.
     */
    public Set<String> getClinicalResponseCollection()
    {
        return clinicalResponseCollection;
    }

    /**
     * @param clinicalResponseCollection The clinicalResponseCollection to set.
     */
    public void setClinicalResponseCollection(Set<String> clinicalResponseCollection)
    {
        this.clinicalResponseCollection = clinicalResponseCollection;
    }

    /**
     * @return Returns the clinicalStageCollection.
     */
    public Set<String> getClinicalStageCollection()
    {
        return clinicalStageCollection;
    }

    /**
     * @param clinicalStageCollection The clinicalStageCollection to set.
     */
    public void setClinicalStageCollection(Set<String> clinicalStageCollection)
    {
        this.clinicalStageCollection = clinicalStageCollection;
    }

    /**
     * @return Returns the estrogenReceptorStatusCollection.
     */
    public Set<String> getEstrogenReceptorStatusCollection()
    {
        return estrogenReceptorStatusCollection;
    }

    /**
     * @param estrogenReceptorStatusCollection The estrogenReceptorStatusCollection to set.
     */
    public void setEstrogenReceptorStatusCollection(Set<String> estrogenReceptorStatusCollection)
    {
        this.estrogenReceptorStatusCollection = estrogenReceptorStatusCollection;
    }

    /**
     * @return Returns the her2CommunityAssessmentCollection.
     */
    public Set<String> getHer2AssessmentCollection()
    {
        return her2AssessmentCollection;
    }

    /**
     * @param her2AssessmentCollection The her2AssessmentCollection to set.
     */
    public void setHer2AssessmentCollection(Set<String> her2AssessmentCollection)
    {
        this.her2AssessmentCollection = her2AssessmentCollection;
    }

    /**
     * @return Returns the longestDiameter.
     */
    public Double getLongestDiameter()
    {
        return longestDiameter;
    }

    /**
     * @param longestDiameter The longestDiameter to set.
     */
    public void setLongestDiameter(Double longestDiameter)
    {
        this.longestDiameter = longestDiameter;
    }

    /**
     * @return Returns the longestDiameterOperator.
     */
    public Operator getLongestDiameterOperator()
    {
        return longestDiameterOperator;
    }

    /**
     * @param longestDiameterOperator The longestDiameterOperator to set.
     */
    public void setLongestDiameterOperator(Operator longestDiameterOperator)
    {
        this.longestDiameterOperator = longestDiameterOperator;
    }

    /**
     * @return Returns the nodalMorphologyCollection.
     */
    public Set<String> getNodalMorphologyCollection()
    {
        return nodalMorphologyCollection;
    }

    /**
     * @param nodalMorphologyCollection The nodalMorphologyCollection to set.
     */
    public void setNodalMorphologyCollection(Set<String> nodeMorphologyCollection)
    {
        this.nodalMorphologyCollection = nodeMorphologyCollection;
    }

    /**
     * @return Returns the nodeSizeClinical.
     */
    public Double getNodeSizeClinical()
    {
        return nodeSizeClinical;
    }

    /**
     * @param nodeSizeClinical The nodeSizeClinical to set.
     */
    public void setNodeSizeClinical(Double nodeSizeClinical)
    {
        this.nodeSizeClinical = nodeSizeClinical;
    }

    /**
     * @return Returns the nodeSizeClinicalOperator.
     */
    public Operator getNodeSizeClinicalOperator()
    {
        return nodeSizeClinicalOperator;
    }

    /**
     * @param nodeSizeClinicalOperator The nodeSizeClinicalOperator to set.
     */
    public void setNodeSizeClinicalOperator(Operator nodeSizeClinicalOperator)
    {
        this.nodeSizeClinicalOperator = nodeSizeClinicalOperator;
    }

    /**
     * @return Returns the pathologicalTumorSize.
     */
    public Double getPathologicalTumorSize()
    {
        return pathologicalTumorSize;
    }

    /**
     * @param pathologicalTumorSize The pathologicalTumorSize to set.
     */
    public void setPathologicalTumorSize(Double pathologicalTumorSize)
    {
        this.pathologicalTumorSize = pathologicalTumorSize;
    }

    /**
     * @return Returns the pathologicalTumorSizeOperator.
     */
    public Operator getPathologicalTumorSizeOperator()
    {
        return pathologicalTumorSizeOperator;
    }

    /**
     * @param pathologicalTumorSizeOperator The pathologicalTumorSizeOperator to set.
     */
    public void setPathologicalTumorSizeOperator(Operator pathologicalTumorSizeOperator)
    {
        this.pathologicalTumorSizeOperator = pathologicalTumorSizeOperator;
    }

    /**
     * @return Returns the percentLDChange.
     */
    public Double getPercentLDChange()
    {
        return percentLDChange;
    }

    /**
     * @param percentLDChange The percentLDChange to set.
     */
    public void setPercentLDChange(Double percentLDChange)
    {
        this.percentLDChange = percentLDChange;
    }

    /**
     * @return Returns the percentLDChangeOperator.
     */
    public Operator getPercentLDChangeOperator()
    {
        return percentLDChangeOperator;
    }

    /**
     * @param percentLDChangeOperator The percentLDChangeOperator to set.
     */
    public void setPercentLDChangeOperator(Operator percentLDChangeOperator)
    {
        this.percentLDChangeOperator = percentLDChangeOperator;
    }

    /**
     * @return Returns the progesteronReceptorStatusCollection.
     */
    public Set<String> getProgesteroneReceptorStatusCollection()
    {
        return progesteronReceptorStatusCollection;
    }

    /**
     * @param progesteronReceptorStatusCollection The progesteronReceptorStatusCollection to set.
     */
    public void setProgesteronReceptorStatusCollection(Set<String> progesteronReceptorStatusCollection)
    {
        this.progesteronReceptorStatusCollection = progesteronReceptorStatusCollection;
    }

    /**
     * @return Returns the chemoCollection.
     */
    public Set<String> getChemoCollection()
    {
        return chemoCollection;
    }

    /**
     * @param chemoCollection The chemoCollection to set.
     */
    public void setChemoCollection(Set<String> chemoCollection)
    {
        this.chemoCollection = chemoCollection;
    }

    /**
     * @return Returns the percentLDChangeTimeCourse.
     */
    public String getPercentLDChangeTimeCourse()
    {
        return percentLDChangeTimeCourse;
    }

    /**
     * @param percentLDChangeTimeCourse The percentLDChangeTimeCourse to set.
     */
    public void setPercentLDChangeTimeCourse(String percentLDChangeTimeCourse)
    {
        this.percentLDChangeTimeCourse = percentLDChangeTimeCourse;
    }
}

/**
 *  $Id: BreastCancerClinicalFindingCriteria.java,v 1.3 2006-08-15 19:48:08 georgeda Exp $
 * 
 *  $Log: not supported by cvs2svn $
 *  Revision 1.2  2006/08/14 20:14:57  georgeda
 *  Finished fleshing out mappings from DTO to DB and back
 *
 *  Revision 1.1  2006/08/14 16:59:40  georgeda
 *  Initial revision
 *
 */
