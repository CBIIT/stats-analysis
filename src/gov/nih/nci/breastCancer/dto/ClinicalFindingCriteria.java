/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.breastCancer.dto;



import gov.nih.nci.breastCancer.service.ClinicalFindingHandler;

import java.util.Set;

public abstract class ClinicalFindingCriteria
{
    private StudyParticipantCriteria studyParticipantCriteria;
    private Set<String> timeCourseCollection;

    public abstract ClinicalFindingHandler getHandler();

    /**
     * @return Returns the studyParticipantCriteria.
     */
    public StudyParticipantCriteria getStudyParticipantCriteria()
    {
        return studyParticipantCriteria;
    }

    /**
     * @param studyParticipantCriteria The studyParticipantCriteria to set.
     */
    public void setStudyParticipantCriteria(StudyParticipantCriteria studyParticipantCriteria)
    {
        this.studyParticipantCriteria = studyParticipantCriteria;
    }

    /**
     * @return Returns the timeCourseCollection.
     */
    public Set<String> getTimeCourseCollection()
    {
        return timeCourseCollection;
    }

    /**
     * @param timeCourseCollection The timeCourseCollection to set.
     */
    public void setTimeCourseCollection(Set<String> timeCourseCollection)
    {
        this.timeCourseCollection = timeCourseCollection;
    }
    
}

/**
 *  $Id: ClinicalFindingCriteria.java,v 1.1 2006-08-14 16:59:40 georgeda Exp $
 * 
 *  $Log: not supported by cvs2svn $
 */