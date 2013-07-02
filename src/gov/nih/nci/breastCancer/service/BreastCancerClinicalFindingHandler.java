/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.breastCancer.service;


  
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
            Set<Long> theSPs = getStudyParticipantsForLDChange(theCriteria);
            
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
    private Set<Long> getStudyParticipantsForLDChange(BreastCancerClinicalFindingCriteria inCriteria)
    {
        logger.debug("Entering getStudyParticipantsForLDChange");
        
        Set<Long> theReturnSet = new HashSet<Long>();

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
            theReturnSet.add(-1L);
        }
        
        logger.debug("Exiting getStudyParticipantsForLDChange");
        
        return theReturnSet;
    }
}

/**
 * $Id: BreastCancerClinicalFindingHandler.java,v 1.6 2007-04-06 17:43:31 ashinohara Exp $
 * 
 * $Log: not supported by cvs2svn $
 * Revision 1.5  2006/10/03 20:31:06  zhangd
 * *** empty log message ***
 *
 * Revision 1.4  2006/08/17 18:05:09  georgeda
 * Removed unneeded import
 *
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
