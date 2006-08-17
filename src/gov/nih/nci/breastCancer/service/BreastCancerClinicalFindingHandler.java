package gov.nih.nci.breastCancer.service;

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

import gov.nih.nci.breastCancer.dto.BreastCancerClinicalFindingCriteria;
import gov.nih.nci.breastCancer.dto.ClinicalFindingCriteria;
import gov.nih.nci.caintegrator.domain.finding.clinical.breastCancer.bean.BreastCancerClinicalFinding;
import gov.nih.nci.caintegrator.enumeration.Operator;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class BreastCancerClinicalFindingHandler extends ClinicalFindingHandler
{
    private static Logger logger = Logger.getLogger(BreastCancerClinicalFindingHandler.class);

    /**
     * Return the specific finding type
     */
    protected Class getFindingType()
    {
        return BreastCancerClinicalFinding.class;
    }

    /**
     * Return the string builder which has the constructed HQL
     */
    protected StringBuilder handleCriteria(ClinicalFindingCriteria inCriteria,
                                           HashMap<String, Object> inParams,
                                           Session inSession)
    {
        logger.debug("Entering handleCriteria");

        BreastCancerClinicalFindingCriteria theCriteria = (BreastCancerClinicalFindingCriteria) inCriteria;

        StringBuilder theHQL = new StringBuilder();

        // Start of the where clause
        theHQL.append("from BreastCancerClinicalFinding AS f LEFT JOIN FETCH f.studyParticipant ");

        String theANDString = " WHERE ";

        /////////////////////////////////////////////////////
        // Handle clinical stage parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getClinicalStageCollection() != null && theCriteria.getClinicalStageCollection().size() > 0)
        {
            System.out.println("Clinical stage: " + theCriteria.getClinicalStageCollection());
            theHQL.append(theANDString + " f.clinicalStage IN (:f_clinicalStage) ");
            inParams.put("f_clinicalStage", theCriteria.getClinicalStageCollection());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle clinical response parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getClinicalResponseCollection() != null && theCriteria.getClinicalResponseCollection().size() > 0)
        {
            System.out.println("Clinical response: " + theCriteria.getClinicalResponseCollection());
            theHQL.append(theANDString + " f.clinicalResponse IN (:f_clinicalResponse) ");
            inParams.put("f_clinicalResponse", theCriteria.getClinicalResponseCollection());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle longest diameter parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getLongestDiameter() != null)
        {
            if (theCriteria.getLongestDiameterOperator() == Operator.GE)
            {
                theHQL.append(theANDString + " f.longestDiameter >= :longestDiameter ");
            }
            else if (theCriteria.getLongestDiameterOperator() == Operator.LE)
            {
                theHQL.append(theANDString + " f.longestDiameter <= :longestDiameter ");
            }

            inParams.put("longestDiameter", theCriteria.getLongestDiameter());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle clinical node size parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getNodeSizeClinical() != null)
        {
            if (theCriteria.getNodeSizeClinicalOperator() == Operator.GE)
            {
                theHQL.append(theANDString + " f.nodeSizeClinical >= :nodeSizeClinical ");
            }
            else if (theCriteria.getNodeSizeClinicalOperator() == Operator.LE)
            {
                theHQL.append(theANDString + " f.nodeSizeClinical <= :nodeSizeClinical ");
            }
            inParams.put("nodeSizeClinical", theCriteria.getNodeSizeClinical());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle pathlogical tumor size parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getPathologicalTumorSize() != null)
        {
            if (theCriteria.getPathologicalTumorSizeOperator() == Operator.GE)
            {
                theHQL.append(theANDString + " f.pathologicalTumorSize >= :pathologicalTumorSize ");
            }
            else if (theCriteria.getPathologicalTumorSizeOperator() == Operator.LE)
            {
                theHQL.append(theANDString + " f.pathologicalTumorSize <= :pathologicalTumorSize ");
            }

            inParams.put("pathologicalTumorSize", theCriteria.getPathologicalTumorSize());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle nodal morphology parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getNodalMorphologyCollection() != null && theCriteria.getNodalMorphologyCollection().size() > 0)
        {
            theHQL.append(theANDString + " f.nodalMorphology IN (:f_nodalMorphology) ");
            inParams.put("f_nodalMorphology", theCriteria.getNodalMorphologyCollection());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle percent LD change parameter
        //
        // NOTE: This is timepoint based, plus the GUI 
        // specifies it as percentage "decrease", so we need
        // to map it differently as the database stores 
        // it as a delta.
        /////////////////////////////////////////////////////
        if (theCriteria.getPercentLDChange() != null)
        {
            Set<String> theSPs = getStudyParticipantsForLDChange(theCriteria);
            
            theHQL.append(theANDString + " f.studyParticipant IN (:f_studyParticipants) ");
            inParams.put("f_studyParticipants", theSPs);
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle estrogen receptor status parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getEstrogenReceptorStatusCollection() != null && theCriteria.getEstrogenReceptorStatusCollection().size() > 0)
        {
            theHQL.append(theANDString + " ( ");
            String theORClause = "";
            int count = 0;
            for (String theERStatus : theCriteria.getEstrogenReceptorStatusCollection())
            {
                theHQL.append(theORClause + " f.estrogenReceptorStatus LIKE :f_estrogenReceptorStatus" + count);
                inParams.put("f_estrogenReceptorStatus" + count++, "%" + theERStatus + "%");
                theORClause = " OR ";
            }
            theHQL.append(" ) ");
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle her2 community assessment parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getHer2AssessmentCollection() != null && theCriteria.getHer2AssessmentCollection().size() > 0)
        {

            theHQL.append(theANDString + " ( ");
            String theORClause = "";
            int count = 0;
            for (String theHER2Status : theCriteria.getHer2AssessmentCollection())
            {
                theHQL.append(theORClause + " f.her2Assessment LIKE :f_her2Assessment" + count);
                inParams.put("f_her2Assessment" + count++, "%" + theHER2Status + "%");
                theORClause = " OR ";
            }
            theHQL.append(" ) ");
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle progesterone receptor status parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getProgesteroneReceptorStatusCollection() != null && theCriteria.getProgesteroneReceptorStatusCollection().size() > 0)
        {
            theHQL.append(theANDString + " ( ");
            String theORClause = "";
            int count = 0;
            for (String thePRStatus : theCriteria.getProgesteroneReceptorStatusCollection())
            {
                theHQL.append(theORClause + " f.progesteroneReceptorStatus LIKE :f_progesteroneReceptorStatus" + count);
                inParams.put("f_progesteroneReceptorStatus" + count++, "%" + thePRStatus + "%");
                theORClause = " OR ";
            }
            theHQL.append(" ) ");
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle chemo parameter
        /////////////////////////////////////////////////////
        if (theCriteria.getChemoCollection() != null && theCriteria.getChemoCollection().size() > 0)
        {
            theHQL.append(theANDString + " f.chemo IN (:f_chemo) ");
            inParams.put("f_chemo", theCriteria.getChemoCollection());
            theANDString = " AND ";
        }


        logger.info("HQL: " + theHQL.toString());
        logger.debug("Exiting handleCriteria");

        return theHQL;
    }
    
    //////////////////////////////////////////////////////////////
    // Get a list of the study participant ID's for an LD and TimeCourse
    //////////////////////////////////////////////////////////////
    private Set<String> getStudyParticipantsForLDChange(BreastCancerClinicalFindingCriteria inCriteria)
    {
        logger.debug("Entering getStudyParticipantsForLDChange");
        
        Set<String> theReturnSet = new HashSet<String>();

        String theHQL = "from BreastCancerClinicalFinding AS f LEFT JOIN FETCH f.studyParticipant  ";
        
        // Only look @ records if they are associated w/ a SP who has a finding that matches
        if (inCriteria.getPercentLDChangeOperator() == Operator.GE)
        {
            theHQL += " WHERE f.percentLDChangeFromBaseline <= :f_percentLDChangeFromBaseline AND f.timeCourse.name = :f_timeCourse_name";
        }
        else if (inCriteria.getPercentLDChangeOperator() == Operator.LE)
        {
            theHQL += " WHERE f.percentLDChangeFromBaseline >= :f_percentLDChangeFromBaseline AND f.timeCourse.name = :f_timeCourse_name";         
        }
        
        HashMap<String, Object> theParams = new HashMap<String, Object>();
        theParams.put("f_percentLDChangeFromBaseline", -1.0 * inCriteria.getPercentLDChange());
        theParams.put("f_timeCourse_name", inCriteria.getPercentLDChangeTimeCourse());
        
        try
        {
            Session theSession = HibernateUtil.getSession();
            Query theQuery = theSession.createQuery(theHQL.toString());
            HQLHelper.setParamsOnQuery(theParams, theQuery);

            List theSPList = theQuery.list();

            for (Object theObject : theSPList)
            {
                BreastCancerClinicalFinding theSP = (BreastCancerClinicalFinding) theObject;
                theReturnSet.add(theSP.getStudyParticipant().getId());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("Error getting study participant IDs: ", e);
        }
        
        // Nothing matched.  Return a -1, thus matching nothing
        if (theReturnSet.size() == 0)
        {
            theReturnSet.add("-1");
        }
        
        logger.debug("Exiting getStudyParticipantsForLDChange");
        
        return theReturnSet;
    }
}

/**
 * $Id: BreastCancerClinicalFindingHandler.java,v 1.4 2006-08-17 18:05:09 georgeda Exp $
 * 
 * $Log: not supported by cvs2svn $
 * Revision 1.3  2006/08/15 19:48:18  georgeda
 * More cleanup
 *
 * Revision 1.2  2006/08/14 20:14:57  georgeda
 * Finished fleshing out mappings from DTO to DB and back
 *
 * Revision 1.1  2006/08/14 16:59:40  georgeda
 * Initial revision
 *
 */
