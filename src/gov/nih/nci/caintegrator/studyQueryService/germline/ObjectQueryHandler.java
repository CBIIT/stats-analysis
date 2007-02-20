package gov.nih.nci.caintegrator.studyQueryService.germline;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Transformer;
import org.apache.log4j.Logger;
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
    private  Set<Study> allStudyObjects = null;

    public ObjectQueryHandler() {
        
    }
    
    public  Collection<Study> getStudyObjects(StudyCriteria studyCrit) {
         return getStudyObjects(studyCrit, false);
    }

    public  Collection<Study> getStudyObjects(StudyCriteria studyCrit, boolean populatePanel) {
        if (studyCrit == null) return new ArrayList<Study>();
            Session session = getSessionFactory().getCurrentSession();


            HashMap params = new HashMap();
            String studyCritHQL = " FROM Study s WHERE {0} {1} ";
            StringBuffer sponsorJoin = new StringBuffer("");
            StringBuffer studyNameJoin = new StringBuffer("");
            String studyName = studyCrit.getName();
            String sponsorStudyIdentifier = studyCrit.getSponsorStudyIdentifier();

            if (studyName == null && sponsorStudyIdentifier == null) {
                if (allStudyObjects == null) {
                    allStudyObjects = new HashSet<Study>();
                    List<Study> studyObjs = executeStudyQuery(studyCritHQL, studyNameJoin, sponsorJoin, session, params);
                    allStudyObjects.addAll(studyObjs);
                    return allStudyObjects;
                }
                else {
                    return allStudyObjects;
                }
            }

            if ((studyName != null) && (studyName.length() > 0)) {
               studyNameJoin.append(" s.name = :studyName  AND ");
               params.put("studyName", studyName);
            }

            if ((sponsorStudyIdentifier != null) && (sponsorStudyIdentifier.length() > 0))  {
                 sponsorJoin .append(" s.sponsorStudyIdentifier = :sponsorStudyIdentifier ");
                 params.put("sponsorStudyIdentifier", sponsorStudyIdentifier);
            }

            List<Study> studyObjs = executeStudyQuery(studyCritHQL, studyNameJoin, sponsorJoin, session, params);

            // populate these study objects with SNPPanel objects based on parameer passes in
            if (populatePanel) {
                for (int i = 0; i < studyObjs.size(); i++) {
                    Study study = studyObjs.get(i);
                    // initialize SNPPanel associations
                    study.getSnpPanelCollection().size();

                }
            }

            return studyObjs;
    }

    public  Collection<SNPPanel> getPanelObjects(StudyCriteria studyCrit) {
        Collection snpPanels = new ArrayList<SNPPanel>();
        if (studyCrit == null) return snpPanels;
        Collection<Study> studyObjs = getStudyObjects(studyCrit, true);
        for (Iterator<Study> iterator = studyObjs.iterator(); iterator.hasNext();) {
            Study study = iterator.next();
            snpPanels.addAll(study.getSnpPanelCollection());
        }
        return snpPanels;
    }

     private  List<Study> executeStudyQuery(String studyCritHQL, StringBuffer studyNameJoin, StringBuffer sponsorJoin, Session session, HashMap params) {
        String hql = MessageFormat.format(studyCritHQL, new Object[] {
                            studyNameJoin, sponsorJoin});

        String tempHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
        String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "WHERE");
        Query studyQuery = session.createQuery(finalHQL);
        HQLHelper.setParamsOnQuery(params, studyQuery );
        List<Study> studyObjs = studyQuery.list();
        return studyObjs;
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
        try {
            Session session = getSessionFactory().getCurrentSession();
            Collection popNames = populationCrit.getNames();
            StringBuffer inClause = new StringBuffer("");
            HashMap params = new HashMap();
            if (popNames != null && popNames.size() > 0) {
                inClause.append(" AND p.name IN (:popNames)");
                params.put("popNames", popNames);
            }

            Query q = session.createQuery(" FROM Population p WHERE p.studyCollection.name=:name " + inClause.toString());
            params.put("name", populationCrit.getStudyName());
            HQLHelper.setParamsOnQuery(params, q);
            List<Population> popObjs = q.list();
            return popObjs;
        } catch (HibernateException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }

    public  Collection<SNPAnalysisGroup> getAnalysisGroups(AnalysisGroupCriteria analGrpCrit) {
        try {
            String studyName = analGrpCrit.getStudyName();
            assert(studyName != null);
            Session session = getSessionFactory().getCurrentSession();

            //Criteria crit = session.createCriteria(SNPAnalysisGroup.class);
            HashMap params = new HashMap();

            StringBuffer hql =new StringBuffer(" FROM SNPAnalysisGroup sg " +
                    " WHERE sg.snpAssociationAnalysis.study.name=:studyName AND {0} ");

                    // + " WHERE sa.study.name= :studyName AND {0} ");
            params.put("studyName", studyName);

            String nameJoin = new String(" ( 0 = 0 ) ");
            if (analGrpCrit != null) {
                String[] names = analGrpCrit.getNames();
                if (names != null && names.length > 0) {
                    Collection<String> l = new ArrayList<String>(names.length);
                    for (int i = 0; i < names.length; l.add(names[i++]));
                    nameJoin = new String(" sg.name IN (:names) ");
                    params.put("names", l);
                    //crit.add(Restrictions.in("name", names));
                }
            }

            String tempHQL = MessageFormat.format(hql.toString(), new Object[] {nameJoin});
            String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "AND");
            Query q = session.createQuery(finalHQL);
            HQLHelper.setParamsOnQuery(params, q);
            Collection<SNPAnalysisGroup> groups = q.list();
            return groups;
        } catch (HibernateException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
    }


    public  Collection<Integer> getAgeLowerLimitValues() {
        System.out.println("HOT DEPLOYMENT");
        if (ageLowerLimits == null) {
           ageLowerLimits = new HashSet<Integer>();
        try {
                Session session = getSessionFactory().getCurrentSession();


                String sql = " SELECT AGE_AT_ENROLL_MIN FROM ENROLL_AGE_LU ";

    /*
                 Criteria crit = session.createCriteria(StudyParticipant.class);
                 crit.setProjection(Projections.distinct(
                         Projections.property("ageAtEnrollment.minValue")));
                 Collection<Double> statusValues =  crit.list() ;
     */

                Query q = session.createSQLQuery(sql);
                Collection<BigDecimal> minValues = q.list();
                Collection<Integer> intValues = CollectionUtils.collect(minValues, new IntegerTransformer());
                ageLowerLimits.addAll(intValues);
            } catch (HibernateException e) {
                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
            }
       }
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
    public  Collection<Integer> getAgeUpperLimitValues() {
       if (ageUpperLimits == null) {
           ageUpperLimits  = new HashSet<Integer>();
        try {
                Session session = getSessionFactory().getCurrentSession();

                String sql = " SELECT AGE_AT_ENROLL_MAX FROM ENROLL_AGE_LU ";
    /*
                 Criteria crit = session.createCriteria(StudyParticipant.class);
                 crit.setProjection(Projections.distinct(
                             Projections.property("ageAtEnrollment.maxValue")));
                 Collection<Double> statusValues =  crit.list() ;
     */
                Query q = session.createSQLQuery(sql);
                Collection<BigDecimal> minValues = q.list();
                Collection<Integer> intValues = CollectionUtils.collect(minValues, new IntegerTransformer());
                ageUpperLimits.addAll(intValues);
            } catch (HibernateException e) {
                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
            }
       }
       return ageUpperLimits ;
   }

    public  Collection<String> getCaseControlStatus() {
       if (caseControlStatus == null) {
           caseControlStatus = new HashSet<String>();
        try {
                Session session = getSessionFactory().getCurrentSession();

                String sql = " SELECT DISTINCT CASE_CONTROL_STATUS FROM STUDY_PARTICIPANT ";
    /*
                 Criteria crit = session.createCriteria(StudyParticipant.class);
                 crit.setProjection(
                             Projections.property("caseControlStatus"));
                 Collection<String> statusValues =  crit.list() ;
     */
                Query q = session.createSQLQuery(sql);
                List<String> statusValues = q.list();
                caseControlStatus.addAll(statusValues);
            } catch (HibernateException e) {
                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
            }
       }
       return caseControlStatus;
   }


     public  Collection<String> getAllQCStatus() {
        if (qcStatusValues == null) {
            qcStatusValues = new HashSet<String>();
            try {
                Session session = getSessionFactory().getCurrentSession();


    /*
                 Criteria crit = session.createCriteria(GenotypeFinding.class);
                 crit.setProjection(
                             Projections.property("status"));
                 Collection<String> statusValues =  crit.list() ;
     */

                String sql = "SELECT GENETYPE_STATUS FROM GENOTYPE_STATUS_LU ";
                Query q = session.createSQLQuery(sql);
                Collection<String> values = q.list();
                qcStatusValues.addAll(values);
            } catch (HibernateException e) {
                logger.error(e);
            } catch (Exception e) {
                logger.error(e);
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
            String studyName = crit.getStudyName();

            StringBuffer studyJoin = new StringBuffer("");
            studyJoin.append(" s.study.name = :studyName AND ");
            params.put("studyName", studyName);

            StringBuffer analysisJoin = new StringBuffer("");
            if ((analysisName != null) && (analysisName.length() > 0)) {
               analysisJoin.append(" s.name = :analysisName  AND ");
               params.put("analysisName", analysisName);
            }

            StringBuffer methodsJoin = new StringBuffer("");
            if ((methods != null) && (methods.length() > 0))  {
                 methodsJoin.append(" s.methods = :methods ");
                 params.put("methods", methods);
            }


            String hql = MessageFormat.format(analysisCritHQL, new Object[] {
                                studyJoin, analysisJoin, methodsJoin});

            String tempHQL = HQLHelper.removeTrailingToken(new StringBuffer(hql), "AND");
            String finalHQL = HQLHelper.removeTrailingToken(new StringBuffer(tempHQL), "WHERE");
            Query analysisQuery = session.createQuery(finalHQL);
            HQLHelper.setParamsOnQuery(params, analysisQuery);
            List<SNPAssociationAnalysis> analysisObjs = analysisQuery.list();

            return analysisObjs;
        } catch (HibernateException e) {
            logger.error(e);
        } catch (Exception e) {
            logger.error(e);
        }
        return null;
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

            SQLQuery q = session.createSQLQuery("SELECT chromosome FROM CHR_START_END");
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
}
