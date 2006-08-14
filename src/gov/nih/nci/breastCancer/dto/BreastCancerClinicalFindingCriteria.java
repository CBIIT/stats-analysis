package gov.nih.nci.breastCancer.dto;

/**
* caIntegrator License
* 
* Copyright 2001-2006 Science Applications International Corporation ("SAIC"). 
* The software subject to this notice and license includes both human readable source code form and machine readable, 
* binary, object code form ("the caIntegrator Software"). The caIntegrator Software was developed in conjunction with 
* the National Cancer Institute ("NCI") by NCI employees and employees of SAIC. 
* To the extent government employees are authors, any rights in such works shall be subject to Title 17 of the United States
* Code, section 105. 
* This caIntegrator Software License (the "License") is between NCI and You. "You (or "Your") shall mean a person or an 
* entity, and all other entities that control, are controlled by, or are under common control with the entity. "Control" 
* for purposes of this definition means (i) the direct or indirect power to cause the direction or management of such entity,
*  whether by contract or otherwise, or (ii) ownership of fifty percent (50%) or more of the outstanding shares, or (iii) 
* beneficial ownership of such entity. 
* This License is granted provided that You agree to the conditions described below. NCI grants You a non-exclusive, 
* worldwide, perpetual, fully-paid-up, no-charge, irrevocable, transferable and royalty-free right and license in its rights 
* in the caIntegrator Software to (i) use, install, access, operate, execute, copy, modify, translate, market, publicly 
* display, publicly perform, and prepare derivative works of the caIntegrator Software; (ii) distribute and have distributed 
* to and by third parties the caIntegrator Software and any modifications and derivative works thereof; 
* and (iii) sublicense the foregoing rights set out in (i) and (ii) to third parties, including the right to license such 
* rights to further third parties. For sake of clarity, and not by way of limitation, NCI shall have no right of accounting
* or right of payment from You or Your sublicensees for the rights granted under this License. This License is granted at no
* charge to You. 
* 1. Your redistributions of the source code for the Software must retain the above copyright notice, this list of conditions
*    and the disclaimer and limitation of liability of Article 6, below. Your redistributions in object code form must reproduce 
*    the above copyright notice, this list of conditions and the disclaimer of Article 6 in the documentation and/or other materials
*    provided with the distribution, if any. 
* 2. Your end-user documentation included with the redistribution, if any, must include the following acknowledgment: "This 
*    product includes software developed by SAIC and the National Cancer Institute." If You do not include such end-user 
*    documentation, You shall include this acknowledgment in the Software itself, wherever such third-party acknowledgments 
*    normally appear.
* 3. You may not use the names "The National Cancer Institute", "NCI" "Science Applications International Corporation" and 
*    "SAIC" to endorse or promote products derived from this Software. This License does not authorize You to use any 
*    trademarks, service marks, trade names, logos or product names of either NCI or SAIC, except as required to comply with
*    the terms of this License. 
* 4. For sake of clarity, and not by way of limitation, You may incorporate this Software into Your proprietary programs and 
*    into any third party proprietary programs. However, if You incorporate the Software into third party proprietary 
*    programs, You agree that You are solely responsible for obtaining any permission from such third parties required to 
*    incorporate the Software into such third party proprietary programs and for informing Your sublicensees, including 
*    without limitation Your end-users, of their obligation to secure any required permissions from such third parties 
*    before incorporating the Software into such third party proprietary software programs. In the event that You fail 
*    to obtain such permissions, You agree to indemnify NCI for any claims against NCI by such third parties, except to 
*    the extent prohibited by law, resulting from Your failure to obtain such permissions. 
* 5. For sake of clarity, and not by way of limitation, You may add Your own copyright statement to Your modifications and 
*    to the derivative works, and You may provide additional or different license terms and conditions in Your sublicenses 
*    of modifications of the Software, or any derivative works of the Software as a whole, provided Your use, reproduction, 
*    and distribution of the Work otherwise complies with the conditions stated in this License.
* 6. THIS SOFTWARE IS PROVIDED "AS IS," AND ANY EXPRESSED OR IMPLIED WARRANTIES, (INCLUDING, BUT NOT LIMITED TO, 
*    THE IMPLIED WARRANTIES OF MERCHANTABILITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE) ARE DISCLAIMED. 
*    IN NO EVENT SHALL THE NATIONAL CANCER INSTITUTE, SAIC, OR THEIR AFFILIATES BE LIABLE FOR ANY DIRECT, INDIRECT, 
*    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE 
*    GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
*    LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT 
*    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
* 
*/

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
    private Set<String> her2CommunityAssessmentCollection;
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
    public Set<String> getHer2CommunityAssessmentCollection()
    {
        return her2CommunityAssessmentCollection;
    }

    /**
     * @param her2CommunityAssessmentCollection The her2CommunityAssessmentCollection to set.
     */
    public void setHer2CommunityAssessmentCollection(Set<String> her2CommunityAssessmentCollection)
    {
        this.her2CommunityAssessmentCollection = her2CommunityAssessmentCollection;
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
 *  $Id: BreastCancerClinicalFindingCriteria.java,v 1.2 2006-08-14 20:14:57 georgeda Exp $
 * 
 *  $Log: not supported by cvs2svn $
 *  Revision 1.1  2006/08/14 16:59:40  georgeda
 *  Initial revision
 *
 */
