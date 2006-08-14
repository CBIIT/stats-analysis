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

import gov.nih.nci.breastCancer.dto.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.domain.study.bean.SubstanceAdministration;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public class StudyParticipantHandler
{
    private static Logger logger = Logger.getLogger(BreastCancerClinicalFindingHandler.class);

    /**
     * Get the findings for a specific set of study participant criteria
     * 
     * @param inCriteria
     * 
     * @return Returns the set of study participants that match the criteria
     */
    public Collection<StudyParticipant> getFindings(StudyParticipantCriteria inCriteria)
    {
        logger.debug("Entering getFindings");

        Session theSession = null;
        Set<StudyParticipant> theResults = new HashSet<StudyParticipant>();

        try
        {
            theSession = HibernateUtil.getSession();
            HibernateUtil.beginTransaction();

            HashMap<String, Object> theParams = new HashMap<String, Object>();

            /////////////////////////////////////////////////////////////////////////////
            // prepare HQL required to for handling corresponding subtype type finding
            /////////////////////////////////////////////////////////////////////////////
            StringBuilder theHQL = handleCriteria(inCriteria, theParams);

            logger.info("HQL: " + theHQL.toString());

            Query q = theSession.createQuery(theHQL.toString());
            HQLHelper.setParamsOnQuery(theParams, q);
            Collection theObjects = q.list();

            theResults.addAll(theObjects);
        }

        catch (Exception e)
        {
            e.printStackTrace();
            logger.error("Error getting findings: ", e);
        }
        finally
        {
            // Close the session if necessart
            if (theSession != null)
            {
                theSession.close();
            }
        }

        logger.debug("Exiting getFindings");

        return theResults;
    }

    /**
     * Parse the StudyParticipant criteria and return a matching HQL string
     *  
     * @param inCriteria the criteria to parse
     * @param inParams the tag/value set for the named paramters in the HQL
     * @return the HQL string
     */
    public StringBuilder handleCriteria(StudyParticipantCriteria inCriteria,
                                        HashMap<String, Object> inParams)
    {
        logger.debug("Entering handleCriteria");

        StringBuilder theHQL = new StringBuilder();

        String theANDString = "";

        /////////////////////////////////////////////////////
        // Handle agent name
        /////////////////////////////////////////////////////
        if (inCriteria.getAgentNameCollection() != null)
        {
            // Get the list of study participants that have an activity w/ the associated agent
            Set<String> theParticipantIDs = getStudyParticipantsForAgents(inCriteria.getAgentNameCollection());
            theHQL.append("from StudyParticipant AS s WHERE s.id IN (:sps_for_agent) ");
            inParams.put("sps_for_agent", theParticipantIDs);
            theANDString = " AND ";
        }

        // No need to do the outer join
        else
        {
            theHQL.append("from StudyParticipant AS s WHERE ");
        }

        /////////////////////////////////////////////////////
        // Handle clinical stage parameter
        /////////////////////////////////////////////////////
        if (inCriteria.getHistologyGrade() != null)
        {
            theHQL.append(theANDString + " s.specimen.histology.stage = :specimen_histology_grade ");
            inParams.put("specimen_histology_grade", inCriteria.getHistologyGrade());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle clinical stage parameter
        /////////////////////////////////////////////////////
        if (inCriteria.getHistologyStage() != null)
        {
            theHQL.append(theANDString + " s.specimen.histology.stage = :specimen_histology_stage ");
            inParams.put("specimen_histology_stage", inCriteria.getHistologyStage());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle race code parameters
        /////////////////////////////////////////////////////
        if (inCriteria.getRaceCodeCollection() != null)
        {
            theHQL.append(theANDString + " s.raceCode IN ( :race_codes )");
            inParams.put("race_codes", inCriteria.getRaceCodeCollection());
            theANDString = " AND ";
        }


        /////////////////////////////////////////////////////
        // Search for specific study participants
        /////////////////////////////////////////////////////
        if (inCriteria.getStudyParticipantIDCollection() != null && inCriteria.getStudyParticipantIDCollection().size() > 0)
        {
            theHQL.append(theANDString + " s.id IN ( :study_participant_ids ) ");
            inParams.put("study_participant_ids", inCriteria.getStudyParticipantIDCollection());
            theANDString = " AND ";
        }

        /////////////////////////////////////////////////////
        // Handle the age values
        /////////////////////////////////////////////////////
        if (inCriteria.getAgeCollection() != null)
        {
            String theMaxParameterName = "AGE_AT_DIAGNOSIS_MAX";
            String theMinParameterName = "AGE_AT_DIAGNOSIS_MIN";

            theHQL.append(theANDString + "(");

            String theORClause = "";
            int count = 0;
            for (NumericMeasurement theValue : inCriteria.getAgeCollection())
            {

                String theParameterName = theMinParameterName + count;
                theHQL.append(theORClause + " ( s.ageAtDiagnosis.minValue >= :" + theParameterName);
                inParams.put(theParameterName, theValue.getMinValue());

                theParameterName = theMaxParameterName + count;
                theHQL.append(" AND s.ageAtDiagnosis.maxValue <= :" + theParameterName + ") ");
                inParams.put(theParameterName, theValue.getMaxValue());
                theORClause = " OR ";
            }

            theHQL.append(")");
            theANDString = " AND ";
        }

        logger.debug("Exiting handleCriteria");

        return theHQL;
    }

    //////////////////////////////////////////////////////////////
    // Get a list of the study participant ID's for an agent
    //////////////////////////////////////////////////////////////
    private Set<String> getStudyParticipantsForAgents(Set<String> inAgentNames)
    {
        logger.debug("Entering getStudyParticipantsForAgents");
        
        Set<String> theReturnSet = new HashSet<String>();

        try
        {
            Session theSession = HibernateUtil.getSession();

            String theHQL = "from SubstanceAdministration s WHERE s.agent.name IN (:s_agent_names)";

            HashMap<String, Object> theParams = new HashMap<String, Object>();

            Query theQuery = theSession.createQuery(theHQL.toString());

            theParams.put("s_agent_names", inAgentNames);
            HQLHelper.setParamsOnQuery(theParams, theQuery);

            List theSAList = theQuery.list();

            for (Object theObject : theSAList)
            {
                SubstanceAdministration theSA = (SubstanceAdministration) theObject;

                System.out.println("ID: " + theSA.getStudyParticipant().getId());
                theReturnSet.add(theSA.getStudyParticipant().getId());
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
        
        logger.debug("Exiting getStudyParticipantsForAgents");
        
        return theReturnSet;
    }
}

/**
 * $Id: StudyParticipantHandler.java,v 1.1 2006-08-14 16:59:40 georgeda Exp $
 * 
 * $Log: not supported by cvs2svn $
 */
