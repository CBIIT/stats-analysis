/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.breastCancer.dto;



import gov.nih.nci.breastCancer.service.StudyParticipantHandler;
import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;

import java.util.Set;

public class StudyParticipantCriteria
{
    private String histologyStage;
    private String histologyGrade;
    private Set<String> agentNameCollection;
    private Set<String> studyParticipantIDCollection;
    private Set<NumericMeasurement> ageCollection;
    private Set<String> raceCodeCollection;

    public StudyParticipantHandler getHandler()
    {
        return new StudyParticipantHandler();
    }

    /**
     * @return Returns the histologyGrade.
     */
    public String getHistologyGrade()
    {
        return histologyGrade;
    }

    /**
     * @param histologyGrade The histologyGrade to set.
     */
    public void setHistologyGrade(String histologyGrade)
    {
        this.histologyGrade = histologyGrade;
    }

    /**
     * @return Returns the histologyStage.
     */
    public String getHistologyStage()
    {
        return histologyStage;
    }

    /**
     * @param histologyStage The histologyStage to set.
     */
    public void setHistologyStage(String histologyStage)
    {
        this.histologyStage = histologyStage;
    }

    /**
     * @return Returns the studyParticipantIDCollection.
     */
    public Set<String> getStudyParticipantIDCollection()
    {
        return studyParticipantIDCollection;
    }

    /**
     * @param studyParticipantIDCollection The studyParticipantIDCollection to set.
     */
    public void setStudyParticipantIDCollection(Set<String> studyParticipantIDCollection)
    {
        this.studyParticipantIDCollection = studyParticipantIDCollection;
    }

    /**
     * @return Returns the agentNames.
     */
    public Set<String> getAgentNameCollection()
    {
        return agentNameCollection;
    }

    /**
     * @param agentNames The agentNames to set.
     */
    public void setAgentNames(Set<String> agentNames)
    {
        this.agentNameCollection = agentNames;
    }

    /**
     * @return Returns the ageCollection.
     */
    public Set<NumericMeasurement> getAgeCollection()
    {
        return ageCollection;
    }

    /**
     * @param ageCollection The ageCollection to set.
     */
    public void setAgeCollection(Set<NumericMeasurement> ageCollection)
    {
        this.ageCollection = ageCollection;
    }

    /**
     * @return Returns the raceCodeCollection.
     */
    public Set<String> getRaceCodeCollection()
    {
        return raceCodeCollection;
    }

    /**
     * @param raceCodeCollection The raceCodeCollection to set.
     */
    public void setRaceCodeCollection(Set<String> raceCodeCollection)
    {
        this.raceCodeCollection = raceCodeCollection;
    }
}

/**
 * $Id: StudyParticipantCriteria.java,v 1.1 2006-08-14 16:59:40 georgeda Exp $
 * 
 * $Log: not supported by cvs2svn $
 */