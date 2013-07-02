/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.breastCancer.service;



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
            Set<Long> theParticipantIDs = getStudyParticipantsForAgents(inCriteria.getAgentNameCollection());
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
            theHQL.append(theANDString + "(");

            String theORClause = "";
            for (NumericMeasurement theValue : inCriteria.getAgeCollection())
            {
                theHQL.append(theORClause + " ( s.ageAtDiagnosis.minValue >= " + theValue.getMinValue().intValue());
                theHQL.append(" AND s.ageAtDiagnosis.maxValue <= " + theValue.getMaxValue().intValue() +  ") ");
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
    private Set<Long> getStudyParticipantsForAgents(Set<String> inAgentNames)
    {
        logger.debug("Entering getStudyParticipantsForAgents");
        
        Set<Long> theReturnSet = new HashSet<Long>();

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
            theReturnSet.add(-1L);
        }
        
        logger.debug("Exiting getStudyParticipantsForAgents");
        
        return theReturnSet;
    }
}

/**
 * $Id: StudyParticipantHandler.java,v 1.5 2007-04-06 17:43:31 ashinohara Exp $
 * 
 * $Log: not supported by cvs2svn $
 * Revision 1.4  2006/10/03 20:35:08  zhangd
 * *** empty log message ***
 *
 * Revision 1.3  2006/08/17 19:25:57  georgeda
 * Cleanup age handling
 *
 * Revision 1.2  2006/08/14 20:14:57  georgeda
 * Finished fleshing out mappings from DTO to DB and back
 *
 * Revision 1.1  2006/08/14 16:59:40  georgeda
 * Initial revision
 *
 */
