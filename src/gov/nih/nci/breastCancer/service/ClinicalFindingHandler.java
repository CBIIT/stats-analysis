/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.breastCancer.service;



import gov.nih.nci.breastCancer.dto.ClinicalFindingCriteria;
import gov.nih.nci.breastCancer.dto.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.util.HibernateUtil;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;

public abstract class ClinicalFindingHandler
{
    private static Logger logger = Logger.getLogger(BreastCancerClinicalFindingHandler.class);

    protected abstract StringBuilder handleCriteria(ClinicalFindingCriteria inCriteria,
                                                    HashMap<String, Object> inParams,
                                                    Session inSession);

    protected abstract Class getFindingType();

    public Collection<? extends ClinicalFinding> getFindings(ClinicalFindingCriteria inCriteria)
    {
        logger.debug("Entering getFindings");

        Set<? extends ClinicalFinding> theResults = new HashSet<ClinicalFinding>();

        try
        {
            StudyParticipantCriteria theStudyParticipantsCriteria = inCriteria.getStudyParticipantCriteria();


            HashMap<String, Object> theParams = new HashMap<String, Object>();

            /////////////////////////////////////////////////////////////////////////////
            // prepare HQL required to for handling corresponding subtype type finding
            /////////////////////////////////////////////////////////////////////////////
            StringBuilder theHQL = handleCriteria(inCriteria, theParams, null);

            String theConnectorString = " WHERE ";

            // Already a where clause
            if (theHQL.lastIndexOf("WHERE") != -1)
            {
                theConnectorString = " AND ";
            }

            if (theStudyParticipantsCriteria != null)
            {
                theHQL.append(theConnectorString + " f.studyParticipant IN (");

                StudyParticipantHandler theStudyParticipantHandler = theStudyParticipantsCriteria.getHandler();
                StringBuilder theStudyHQL = theStudyParticipantHandler.handleCriteria(theStudyParticipantsCriteria, theParams);

                theHQL.append(theStudyHQL + ")");
                theConnectorString = " AND ";
            }

            // Baseline data is from timecourse T1, so default to it if we don't have one specified
            if (inCriteria.getTimeCourseCollection() == null || inCriteria.getTimeCourseCollection().size() == 0)
            {
                // Always add the baseline timecourse
                Set<String> theTimeCourseSet = new HashSet<String>();
                theTimeCourseSet.add("T1");
                inCriteria.setTimeCourseCollection(theTimeCourseSet);
            }

            theHQL.append(theConnectorString + " f.timeCourse.name IN ( :f_timeCourse_name ) ");
            theParams.put("f_timeCourse_name", inCriteria.getTimeCourseCollection());

            Session theSession = HibernateUtil.getSession();
            theSession.beginTransaction();


            Query theQuery = theSession.createQuery(theHQL.toString());
            HQLHelper.setParamsOnQuery(theParams, theQuery);

            logger.info("HQL*********: " + theHQL.toString());
            long theStartTime = System.currentTimeMillis();
            Collection objs = theQuery.list();
            long theElapsedTime = System.currentTimeMillis() - theStartTime;

            logger.info("Elapsed time: " + theElapsedTime);

            theResults.addAll(objs);
        }

        catch (Exception e)
        {
            logger.error("Error getting findings: ", e);
            e.printStackTrace();
        }

        logger.debug("Exiting getFindings");

        return theResults;
    }
}

/**
 * $Id: ClinicalFindingHandler.java,v 1.3 2006-10-03 20:31:31 zhangd Exp $
 * 
 * $Log: not supported by cvs2svn $
 * Revision 1.2  2006/08/17 19:25:40  georgeda
 * Added logging
 *
 * Revision 1.1  2006/08/14 16:59:40  georgeda
 * Initial revision
 *
 * 
 */
