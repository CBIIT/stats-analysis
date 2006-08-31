package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyParticipantCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.util.HQLHelper;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.domain.study.bean.Specimen;

import java.util.List;

import java.util.HashMap;
import java.util.Collection;
import java.util.ArrayList;
import java.text.MessageFormat;

import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

/**
 * Author: Ram Bhattaru
 * Date:   Jul 13, 2006
 * Time:   5:08:50 PM
 */
public class StudyParticipantCriteriaHandler {
    /**
     * Thie method retrieves SpecimenIDs based on StudyParticipant Criteria passed in.
     * It converts Population Criteria,  StudyParticipant Attributes Criteria, and
     * Study Criteria into SpecimenID criteria.  It involves 4 steps.
     * 1.  It prepares HQL required for handling the StudyParticipant Attributes Criteria itself.
     * 2.  It then prepares HQL for Population Criteria
     * 3.  It then prepares HQL for Study Criteria
     * 4.  It executes all the appended HQL to retrieve Specimens.
     * @param spCrit StudyParticipantCriteria
     * @param session  Hibernate Session
     * @return SpecimenIDs
     */

    public static List<String> handle(StudyParticipantCriteria spCrit, Session session) {
        if (spCrit == null) return null; // indicating that this crit can be ignored in the calling method
        HashMap params = new HashMap();  // to hold HQL Parameters

        StringBuffer spHQL = new StringBuffer("SELECT sm.id FROM Specimen sm  " +
                                            " JOIN sm.studyParticipant sp {0} {1} {2} WHERE ");

        /* 1. Handle the StudyParticipant Attributes Criteria itself */
        boolean hqlAppended = handleStudyPartcioantAttributeCriteria(spCrit, spHQL, params);

        /* 2.  Handle StudyCriteira if specified */
        StringBuffer studyJoin = new StringBuffer("");
        StudyCriteria studyCrit = spCrit.getStudyCriteria();
        if (studyCrit != null) {
            studyJoin = handleStudyCriteria(studyCrit , spHQL, params);
        }

        /* 3.  Handle Population Criteria */
        StringBuffer populationJoin  = new StringBuffer("");
        PopulationCriteria popCrit = spCrit.getPopulationCriteria();
        if (popCrit != null) {
            populationJoin  = handlePopulationCriteria(popCrit, spHQL, params);
        }

        /* 4. Handle AnalysisGroupCriteria  */
        StringBuffer analysisGroupJoin = new StringBuffer("");
        AnalysisGroupCriteria groupCrit = spCrit.getAnalysisGroupCriteria();
        if (groupCrit != null) {
            analysisGroupJoin = handleAnalysisGroupCriteria(groupCrit, spHQL, params);

        }
        /* 5. now substitute the {0} & {1} parameter studyJoin & populationJoin */
        String tmp = spHQL.toString();
        spHQL = new StringBuffer(MessageFormat.format(tmp, new Object[] {
                                        studyJoin, populationJoin, analysisGroupJoin}));

        /* 6. Do some HouseKeeping tasks */
        String tmpHSQL = HQLHelper.removeTrailingToken(spHQL, "AND");
        String finalHSQL = HQLHelper.removeTrailingToken(new StringBuffer(tmpHSQL), "OR");

        /* 7.  Execute total HQL to retrive Specimens */
        // first check if every condition is empty,  If it is return no specimenIDs
        if (!hqlAppended  && studyJoin.length() < 1 && populationJoin.length() < 1
                && analysisGroupJoin.length() < 1 )
            return new ArrayList<String>();

        Query q = session.createQuery(finalHSQL);
        HQLHelper.setParamsOnQuery(params, q);
        List<String> specimenIDs = q.list();

        System.out.println("specimenIDs "+ specimenIDs.size()  +" retrievd from StudyParticipantCriteria: " +specimenIDs.toString());
        return specimenIDs;
    }

    /** This method parses StudyParticipantCriteria and retrieves Specimens based on
     *  this criteria.  It returns null if no criteria is mentioned within StudyParticipantCriteria
     * related to Specimen objects.
     *
     * @param spCrit
     * @param session
     * @return  List of Specimens
     */

    public static List<String> retrieveSpecimens(StudyParticipantCriteria spCrit, Session session) {
        if (spCrit == null) return null; // indicating that this crit can be ignored in the calling method
        HashMap params = new HashMap();  // to hold HQL Parameters

        StringBuffer spHQL = new StringBuffer("SELECT sm.id FROM Specimen sm  " +
                                               " JOIN sm.studyParticipant sp {0} {1} {2} WHERE ");


        /* 1. Handle the StudyParticipant Attributes Criteria itself */
        boolean hqlAppended = handleStudyPartcioantAttributeCriteria(spCrit, spHQL, params);

        /* 2.  Handle StudyCriteira if specified */
        StringBuffer studyJoin = new StringBuffer("");
        StudyCriteria studyCrit = spCrit.getStudyCriteria();
        if (studyCrit != null) {
            studyJoin = handleStudyCriteria(studyCrit , spHQL, params);
        }

        /* 3.  Handle Population Criteria */
        StringBuffer populationJoin  = new StringBuffer("");
        PopulationCriteria popCrit = spCrit.getPopulationCriteria();
        if (popCrit != null) {
            populationJoin  = handlePopulationCriteria(popCrit, spHQL, params);
        }

        /* 4. Handle AnalysisGroupCriteria  */
        StringBuffer analysisGroupJoin = new StringBuffer("");
        AnalysisGroupCriteria groupCrit = spCrit.getAnalysisGroupCriteria();
        if (groupCrit != null) {
            analysisGroupJoin = handleAnalysisGroupCriteria(groupCrit, spHQL, params);
        }
        /* 5. now substitute the {0} & {1} parameter studyJoin & populationJoin */
        String tmp = spHQL.toString();
        spHQL = new StringBuffer(MessageFormat.format(tmp, new Object[] {
                                        studyJoin, populationJoin, analysisGroupJoin}));

        /* 6. Do some HouseKeeping tasks */
        String tmpHSQL = HQLHelper.removeTrailingToken(spHQL, "AND");
        String finalHSQL = HQLHelper.removeTrailingToken(new StringBuffer(tmpHSQL), "OR");

        /* 7.  Execute total HQL to retrive Specimens.  First check if every condition is empty meaning no criteria mentioned hence as good as
        spCrit = null */
        if (!hqlAppended  && studyJoin.length() < 1 && populationJoin.length() < 1
                && analysisGroupJoin.length() < 1 )
            return null;

        Query q = session.createQuery(finalHSQL);
        HQLHelper.setParamsOnQuery(params, q);
        List<String> specimenIDs = q.list();
        System.out.println("specimens found: "+ specimenIDs.size()  + specimenIDs.toString());
        return specimenIDs;
    }


















    public static boolean handleStudyPartcioantAttributeCriteria(StudyParticipantCriteria crit, StringBuffer spHQL, HashMap params) {
        Collection<String> genderCodes = crit.getAdministrativeGenderCodeCollection();
        Integer ageAtDeath = crit.getAgeAtDeath();
        Integer ageAtDiagnosis = crit.getAgeAtDiagnosis();
        Integer ageAtEnrol = crit.getAgeAtEnrollment();
        Integer daysOffStudy = crit.getDaysOffStudy();
        Integer daysOnStudy = crit.getDaysOnStudy();
        Boolean offStudy = crit.getOffStudy();
        Boolean survivalStatus = crit.getSurvivalStatus();
        String caseControlStatus = crit.getCaseControlStatus();
        Collection<String> ethnicGroups = crit.getEthnicGroupCodeCollection();
        Collection<String> familyHistories = crit.getFamilyHistoryCollection();
        Collection<String> instNames = crit.getInstitutionNameCollection();
        Collection<String> raceCodes = crit.getRaceCodeCollection();
        Collection<String> studySubjectIdentifiers = crit.getStudySubjectIdentifierCollection();

        boolean hqlAppended = false;
        /* add StudyPartcipant attributes crit itself */
        if (genderCodes != null) {
            spHQL.append(" sp.administrativeGenderCode IN (:genderCodes) AND ");
            params.put("genderCodes", genderCodes);
            hqlAppended = true;
        }
        if (ageAtDeath != null) {
            spHQL.append(" sp.ageAtDeath = :ageAtDeath AND ");
            params.put("ageAtDeath", ageAtDeath );
            hqlAppended = true;
        }
        if (ageAtDiagnosis != null) {
            spHQL.append(" sp.ageAtDiagnosis = :ageAtDiagnosis AND ");
            params.put("ageAtDiagnosis", ageAtDiagnosis );
            hqlAppended = true;
        }

        if (ageAtEnrol != null) {
            spHQL.append(" sp.ageAtEnrollment = :ageAtEnrol AND ");
            params.put("ageAtEnrol", ageAtEnrol );
            hqlAppended = true;
        }

        if (daysOffStudy != null) {
            spHQL.append(" sp.daysOffStudy = :daysOffStudy AND ");
            params.put("daysOffStudy", daysOffStudy );
            hqlAppended = true;
        }

        if (daysOnStudy != null) {
            spHQL.append(" sp.daysOnStudy = :daysOnStudy AND ");
            params.put("daysOnStudy", daysOnStudy );
            hqlAppended = true;
        }

        if (ethnicGroups != null) {
            spHQL.append(" sp.ethnicGroupCode IN (:ethnicGroups) AND ");
            params.put("ethnicGroups", ethnicGroups );
            hqlAppended = true;
        }

        if (familyHistories != null) {
            spHQL.append(" sp.familyHistory IN (:familyHistories) AND ");
            params.put("familyHistories", familyHistories );
            hqlAppended = true;
        }

        if (instNames != null) {
            spHQL.append(" sp.institutionName IN (:instNames) AND ");
            params.put("instNames", instNames );
            hqlAppended = true;
        }
        if (offStudy != null) {
            spHQL.append(" sp.isOffStudy = :offStudy AND ");
            params.put("offStudy", offStudy );
            hqlAppended = true;
        }
        if (raceCodes != null) {
            spHQL.append(" sp.raceCode IN (:raceCodes) AND ");
            params.put("raceCodes", raceCodes );
            hqlAppended = true;
        }

        if (studySubjectIdentifiers != null) {
            spHQL.append(" sp.studySubjectIdentifier IN (:studySubjectIdentifiers) AND ");
            params.put("studySubjectIdentifiers", studySubjectIdentifiers );
            hqlAppended = true;
        }

        if (survivalStatus != null) {
            spHQL.append(" sp.survivalStatus = :survivalStatus AND ");
            params.put("survivalStatus", survivalStatus );
            hqlAppended = true;
        }

        if(caseControlStatus != null) {
            spHQL.append(" sp.caseControlStatus  = :caseControlStatus AND ");
            params.put("caseControlStatus", caseControlStatus );
            hqlAppended = true;
        }

        return hqlAppended;
    }

    public static StringBuffer handlePopulationCriteria(PopulationCriteria popCrit, StringBuffer spHQL, HashMap params) {

        StringBuffer populationJoin = new StringBuffer("");
        if (popCrit != null) {
            Collection<String> popNames = popCrit.getNames();
            if (popNames != null && popNames.size() > 0) {
                populationJoin.append(" JOIN sp.population ");
                spHQL.append("sp.population.name IN (:popNames) AND ");
                params.put("popNames", popNames);
            }
        }
        return populationJoin;
    }

    public static StringBuffer handleAnalysisGroupCriteria(AnalysisGroupCriteria groupCrit, StringBuffer spHQL, HashMap params) {
        StringBuffer groupJoin = new StringBuffer("");
        if (groupCrit != null) {
            String[] groupNames = groupCrit.getNames();
            ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < groupNames.length; names.add(groupNames[i++]));
            if (groupNames != null && groupNames.length > 0) {
                groupJoin.append(" JOIN sp.analysisGroupCollection ");
                spHQL.append("sp.analysisGroupCollection.name IN (:names) AND ");
                params.put("names", names);
            }
        }
        return groupJoin;
    }

    public static StringBuffer handleStudyCriteria(StudyCriteria studyCrit, StringBuffer studyHql, HashMap params) {

        StringBuffer studyJoin = new StringBuffer("");
        if (studyCrit != null)  {
            String studyName = studyCrit.getName();
            String sponsorStudyIdentifier = studyCrit.getSponsorStudyIdentifier();
            if (studyName != null) {
                studyJoin.append(" JOIN sp.study ");
                studyHql.append(" sp.study.name = :studyName AND ");
                params.put("studyName", studyName);
            }
            if (sponsorStudyIdentifier != null)  {
                if (studyJoin.length() < 1) studyJoin.append(" JOIN sp.study ");
                studyHql.append("sp.study.sponsorStudyIdentifier = :sponsorStudyIdentifier AND ");
                params.put("sponsorStudyIdentifier", sponsorStudyIdentifier);
            }
        }
        return studyJoin;
    }
}
