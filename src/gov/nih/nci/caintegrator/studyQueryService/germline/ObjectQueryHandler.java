package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisMethod;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.AnalysisGroupCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.SNPAssociationAnalysisCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.PopulationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.study.StudyCriteria;
import gov.nih.nci.caintegrator.util.HQLHelper;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.*;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Author: Ram Bhattaru
 * Date:   Aug 16, 2006
 * Time:   7:39:39 AM
 */

public class ObjectQueryHandler {
    private static Logger logger = Logger.getLogger(ObjectQueryHandler.class);

    private SessionFactory sessionFactory;
    
    private  List<String> CHROMOSOME_LIST = null;
    private  Set<String> qcStatusValues = null;
    private  Set<String> caseControlStatus = null;
    private  Set<Integer> ageLowerLimits = null;
    private  Set<Integer> ageUpperLimits = null;
    private  TreeSet<Study> allStudyObjects = null;
    private  Set<String> analysisMethodTypes = null;

    public ObjectQueryHandler() { }

    public  Collection<Study> getStudyObjects(StudyCriteria studyCrit) {
         return getStudyObjects(studyCrit, false);
    }

    public  Collection<Study> getStudyObjects(StudyCriteria studyCrit, boolean populatePanel) {
        if (studyCrit == null) return new ArrayList<Study>();
            Session session = getSessionFactory().getCurrentSession();
            HashMap params = new HashMap();
            String studyCritHQL = " FROM Study s WHERE {0} {1} {2} {3}";
            StringBuffer sponsorJoin = new StringBuffer("");
            StringBuffer studyNameJoin = new StringBuffer("");
            StringBuffer idJoin = new StringBuffer("");
            StringBuffer versionJoin = new StringBuffer("");
            String studyName = studyCrit.getName();
            String sponsorStudyIdentifier = studyCrit.getSponsorStudyIdentifier();
            Long id = studyCrit.getId();
            String version = studyCrit.getVersion();
            if (studyName == null && sponsorStudyIdentifier == null  && id == null && version == null) {
                if (allStudyObjects == null) {
                    allStudyObjects = new TreeSet<Study>(
                            new ObjectComparator.StudyIdComparator());
                    Collection<Study> studyObjs = executeStudyQuery(studyCritHQL, studyNameJoin, sponsorJoin,  versionJoin, idJoin,session, params);
                    allStudyObjects.addAll(studyObjs);
                    return allStudyObjects;
                }
                else {
                    return allStudyObjects;
                }
            }
            if (id != null)  {
                idJoin .append(" s.id = :id AND");
                params.put("id", id);
            }
            if ((studyName != null) && (studyName.length() > 0)) {
               studyNameJoin.append(" s.name = :studyName  AND ");
               params.put("studyName", studyName);
            }

            if ((sponsorStudyIdentifier != null) && (sponsorStudyIdentifier.length() > 0))  {
                 sponsorJoin .append(" s.sponsorStudyIdentifier = :sponsorStudyIdentifier AND");
                 params.put("sponsorStudyIdentifier", sponsorStudyIdentifier);
            }

            if ((version != null) && (version.length() > 0))  {
                versionJoin .append(" s.version = :version ");
                params.put("version", version);
            }
            
            Collection<Study> studyObjs = executeStudyQuery(studyCritHQL, studyNameJoin, sponsorJoin, versionJoin, idJoin, session, params);

            // populate these study objects with SNPPanel objects based on parameer passes in
            if (populatePanel) {
                for (Iterator<Study> iterator = studyObjs.iterator(); iterator.hasNext();) {
                    Study study =  iterator.next();
                    study.getSnpPanelCollection().size();
                }
            }
            return studyObjs;
    }

    public  Collection<SNPPanel> getPanelObjects(StudyCriteria studyCrit) {
        Collection snpPanels = new TreeSet<SNPPanel>(
                        new ObjectComparator.PanelyNameComparator());
        if (studyCrit == null) return snpPanels;
        Collection<Study> studyObjs = getStudyObjects(studyCrit, true);
        for (Iterator<Study> iterator = studyObjs.iterator(); iterator.hasNext();) {
            Study study = iterator.next();
            snpPanels.addAll(study.getSnpPanelCollection());
        }
        return snpPanels;
    }

     private  Collection<Study> executeStudyQuery(String studyCritHQL, StringBuffer studyNameJoin, StringBuffer sponsorJoin, StringBuffer versionJoin,StringBuffer idJoin, Session session, HashMap params) {
        String hql = MessageFormat.format(studyCritHQL, new Object[] {idJoin, studyNameJoin, sponsorJoin, versionJoin,});
        String tempHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "WHERE");
        Query studyQuery = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, studyQuery );
        List results = studyQuery.list();
        SortedSet<Study> s = new TreeSet<Study>(new ObjectComparator.StudyIdComparator());
        s.addAll(results);
        return s;
    }

    /**
     * This method returns  Population objects based on criteria.  If criteria object is
     * passed in that does not have name criteria specified, this method will return <b>all</b>
     * Population Objects.  If name is specified in populationCrit, then this method returns
     * all population object that matches the names (or LIKE name)
     *
     * @param populationCrit
     * @return Collection of Population Objects
     */
    public  Collection<Population> getPopulationObjects(PopulationCriteria populationCrit) {
        if (populationCrit == null) return new ArrayList<Population>();
        Session session = getSessionFactory().getCurrentSession();
        Collection popNames = populationCrit.getNames();
        StringBuffer inClause = new StringBuffer("");
        HashMap params = new HashMap();
        if (popNames != null && popNames.size() > 0) {
            inClause.append(" AND p.name IN (:popNames)");
            params.put("popNames", popNames);
        }

        Query q = session.createQuery(" FROM Population p WHERE p.studyCollection.id = :id " + inClause.toString());
        params.put("id", populationCrit.getStudyId());
        HQLHelper.setParamsOnQuery(params, q);
        List<Population> results = q.list();
        Set<Population> popObjs = new TreeSet<Population>(
                                    new ObjectComparator.PopulationNameComparator());
        popObjs.addAll(results);
        return popObjs;
    }

    public  Collection<SNPAnalysisGroup> getAnalysisGroups(AnalysisGroupCriteria analGrpCrit) {
        Long studyId = analGrpCrit.getStudyId();
        assert(studyId != null);
        Session session = getSessionFactory().getCurrentSession();
        HashMap params = new HashMap();

        StringBuffer hql =new StringBuffer(" FROM SNPAnalysisGroup sg " +
                " WHERE sg.snpAssociationAnalysis.study.id=:studyId AND {0} ");
        params.put("studyId", studyId);

        String nameJoin = new String(" ( 0 = 0 ) ");
        if (analGrpCrit != null) {
            String[] names = analGrpCrit.getNames();
            if (names != null && names.length > 0) {
                Collection<String> l = new ArrayList<String>(names.length);
                for (int i = 0; i < names.length; l.add(names[i++]));
                nameJoin = new String(" sg.name IN (:names) ");
                params.put("names", l);
            }
        }

        String tempHQL = MessageFormat.format(hql.toString(), new Object[] {nameJoin});
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "AND");
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);
        Collection<SNPAnalysisGroup> results = q.list();
        Set<SNPAnalysisGroup> groups = new TreeSet<SNPAnalysisGroup>(
                                        new ObjectComparator.SNPAnalysisGroupNameComparator() );
        groups.addAll(results);
        return groups;
    }


    public  Collection<Integer> getAgeLowerLimitValues(StudyCriteria studyCrit) {
	 		if (studyCrit == null || studyCrit.getId() == null) return new ArrayList<Integer>();
	 		Long studyId = studyCrit.getId();
            ageLowerLimits = new HashSet<Integer>();
            Session session = getSessionFactory().getCurrentSession();
            HashMap params = new HashMap();
            String sql = " SELECT AGE_AT_ENROLL_MIN FROM ENROLL_AGE_LU WHERE STUDY_ID = :studyId ";
            params.put("studyId", studyId);
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar( "AGE_AT_ENROLL_MIN", Hibernate.INTEGER); 
            HQLHelper.setParamsOnQuery(params, q);
            Collection<BigDecimal> minValues = q.list();
            Collection<Integer> intValues = CollectionUtils.collect(minValues, new IntegerTransformer());
            ageLowerLimits.addAll(intValues);
       return ageLowerLimits;
   }
   public  class IntegerTransformer implements Transformer {
       public Object transform(Object object) {
           if (object instanceof BigDecimal) {
               BigDecimal bdObject = (BigDecimal) object;
               return new Integer(bdObject.intValue());
           } else {
               return object;
           }
       }
   }
    public  Collection<Integer> getAgeUpperLimitValues(StudyCriteria studyCrit) {
    	   if (studyCrit == null || studyCrit.getId() == null) return new ArrayList<Integer>();
 		   Long studyId = studyCrit.getId();
    	   ageUpperLimits  = new HashSet<Integer>();
           Session session = getSessionFactory().getCurrentSession();
           HashMap params = new HashMap();
           String sql = " SELECT AGE_AT_ENROLL_MAX FROM ENROLL_AGE_LU WHERE STUDY_ID = :studyId ";
           params.put("studyId", studyId);
           SQLQuery q = session.createSQLQuery(sql);
           q.addScalar( "AGE_AT_ENROLL_MAX", Hibernate.INTEGER);
           HQLHelper.setParamsOnQuery(params, q);
           Collection<BigDecimal> minValues = q.list();
           Collection<Integer> intValues = CollectionUtils.collect(minValues, new IntegerTransformer());
           ageUpperLimits.addAll(intValues);
       return ageUpperLimits ;
   }

    public  Collection<String> getCaseControlStatus(StudyCriteria studyCrit) {
    	 	if (studyCrit == null || studyCrit.getId() == null) return new ArrayList<String>();
           	Long studyId = studyCrit.getId();
            caseControlStatus = new HashSet<String>();
            Session session = getSessionFactory().getCurrentSession();
            HashMap params = new HashMap();
            String sql = " SELECT DISTINCT CASE_CONTROL_STATUS FROM STUDY_PARTICIPANT WHERE STUDY_ID= :studyId ";
            params.put("studyId", studyId);
            SQLQuery q = session.createSQLQuery(sql);
            q.addScalar( "CASE_CONTROL_STATUS", Hibernate.STRING);
            HQLHelper.setParamsOnQuery(params, q);
            List<String> statusValues = q.list();
            caseControlStatus.addAll(statusValues);
            return caseControlStatus;
   }


     public  Collection<String> getAllQCStatus() {
        if (qcStatusValues == null) {
            qcStatusValues = new HashSet<String>();
            try {
                Session session = getSessionFactory().getCurrentSession();
                String sql = "SELECT GENETYPE_STATUS FROM GENOTYPE_STATUS_LU ";
                SQLQuery q = session.createSQLQuery(sql);
                q.addScalar( "GENETYPE_STATUS", Hibernate.STRING);
                Collection<String> values = q.list();
                qcStatusValues.addAll(values);
            } catch (HibernateException e) {
                logger.error(e);
                throw new RuntimeException(e);
            } catch (Exception e) {
                logger.error(e);
                throw new RuntimeException(e);
            }
        }
        return qcStatusValues;
    }

    public  Collection<SNPAssociationAnalysis> getSNPAssociationAnalysisObjects(SNPAssociationAnalysisCriteria crit) {
        if(crit == null) return new ArrayList<SNPAssociationAnalysis>();

        try {
            Session session = getSessionFactory().getCurrentSession();

            HashMap params = new HashMap();
            String analysisCritHQL = " FROM SNPAssociationAnalysis s WHERE {0} {1} {2} ";
            String analysisName = crit.getName();
            String methods = crit.getMethods();
            Long studyId = crit.getStudyId();
            String analysisCode = crit.getAnalysisCode();
            
            StringBuffer studyJoin = new StringBuffer("");
            studyJoin.append(" s.study.id = :studyId AND ");
            params.put("studyId", studyId);

            StringBuffer analysisJoin = new StringBuffer("");
            if ((analysisName != null) && (analysisName.length() > 0)) {
               analysisJoin.append(" s.name = :analysisName  AND ");
               params.put("analysisName", analysisName);
            }
            
            StringBuffer analysisCodeJoin = new StringBuffer("");
            if ((analysisCode != null) && (analysisCode.length() > 0)) {
               analysisJoin.append(" s.analysisCode = :analysisCode  AND ");
               params.put("analysisCode", analysisCode);
            }
            
            StringBuffer methodsJoin = new StringBuffer("");
            if ((methods != null) && (methods.length() > 0))  {
                 methodsJoin.append(" s.methods = :methods ");
                 params.put("methods", methods);
            }


            String hql = MessageFormat.format(analysisCritHQL, new Object[] {
                                studyJoin, analysisJoin, analysisCodeJoin, methodsJoin});

            String tempHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
            String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "WHERE");
            Query analysisQuery = session.createQuery(finalHQL);
            HQLHelper.setParamsOnQuery(params, analysisQuery);
            List<SNPAssociationAnalysis> results = analysisQuery.list();
            Set<SNPAssociationAnalysis> analysisObjs = new TreeSet<SNPAssociationAnalysis>(
                                new ObjectComparator.SNPAnalysisNameComparator() );
            analysisObjs.addAll(results);
            return analysisObjs;
        } catch (HibernateException e) {
            logger.error(e);
            throw new RuntimeException(e);
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException(e);
        }
    }


    public  List<String> getChromosomes() {
        if (CHROMOSOME_LIST == null) {
            Session session = null;
            try {
                session = getSessionFactory().getCurrentSession();
            } catch (HibernateException e) {
                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
            }

          /* The below code is extremely slow.  Hence commented out.
            At the same time, we do not have a class that is mapped to
            CHR_START_END table.  So as a temp solution use direct SQL query
          */
          /*  Criteria crit = session.createCriteria(SNPAnnotation.class );
              crit.setProjection(Projections.property("chromosomeName"));
              List<String> values = crit.list();
           */

            SQLQuery q = session.createSQLQuery("SELECT CHROMOSOME FROM CHR_START_END");
            q.addScalar( "CHROMOSOME", Hibernate.STRING); 
            q.list();
            List<String> values = q.list();
            /* now sort them and place 'em in CHROMOSOME_LIST */
            CHROMOSOME_LIST = new ArrayList<String>();

            String[] sortedChrs = new String[22];
            SortedSet<String> sexChromosomes = new TreeSet<String>();
            for (int i = 0; i < values.size(); i++) {
                String chr = values.get(i);
                try {
                    int index = Integer.parseInt(chr) - 1;
                    sortedChrs[index] =  chr;
                } catch(NumberFormatException e) {
                    sexChromosomes.add(chr); // either X, Y, or MT
                }
             }

            for (int i = 0, j = 0; i < sortedChrs.length; i++) {
                String sortedChr = sortedChrs[i];
                CHROMOSOME_LIST.add(j++, sortedChr);
            }

            CHROMOSOME_LIST.addAll(sexChromosomes);
        }
        return CHROMOSOME_LIST;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    @SuppressWarnings("unchecked")
	public List<String> getAnalysisMethodTypes (StudyCriteria studyCrit){
    	if (studyCrit == null || studyCrit.getId() == null) return new ArrayList<String>();
       	Long studyId = studyCrit.getId();
       	analysisMethodTypes = new HashSet<String>();
        Session session = getSessionFactory().getCurrentSession();
        HashMap params = new HashMap();
        String sql = "SELECT ANALYSIS_METHOD_TYPE FROM SNP_ANALYSIS_LU WHERE STUDY_ID = :studyId ORDER BY DISPLAY_ORDER";
        params.put("studyId", studyId);
        SQLQuery q = session.createSQLQuery(sql);
        q.addScalar( "ANALYSIS_METHOD_TYPE", Hibernate.STRING); 
        HQLHelper.setParamsOnQuery(params, q);
        List<String> values = q.list();
        if(values != null){
        analysisMethodTypes.addAll(values);
        return new ArrayList<String>(analysisMethodTypes);
        }
        else
        	return Collections.EMPTY_LIST;
    }
    public List<SNPAnalysisMethod> getSNPAnalysisMethods (StudyCriteria studyCrit,String analysisMethodType){
    	Long studyId = studyCrit.getId();
        assert(studyId != null);
        Session session = getSessionFactory().getCurrentSession();
        HashMap params = new HashMap();
        StringBuffer sponsorJoin = new StringBuffer("");

        StringBuffer hql =new StringBuffer(" FROM SNPAnalysisMethod sm " +
                " WHERE sm.study.id=:studyId AND {0} ORDER BY sm.displayOrder");
        params.put("studyId", studyId);

        String nameJoin = new String(" ( 0 = 0 ) ");
        if (analysisMethodType != null  && analysisMethodType.length() > 0) {
                nameJoin = new String(" sm.methodType IN (:analysisMethodType) ");
                params.put("analysisMethodType", analysisMethodType);
            }

        String tempHQL = MessageFormat.format(hql.toString(), new Object[] {nameJoin});
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "AND");
        Query q = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, q);
        Collection<SNPAnalysisMethod> results = q.list();
        if(results != null){
        	return new ArrayList<SNPAnalysisMethod>(results);
	    }
	    else
	    	return Collections.EMPTY_LIST;
	    }
    
}
