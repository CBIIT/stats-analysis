package gov.nih.nci.caintegrator.util;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.*;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.*;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;
import gov.nih.nci.caintegrator.domain.finding.clinical.breastCancer.bean.BreastCancerClinicalFinding;
import gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.bean.*;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private final static ThreadLocal threadSession = new ThreadLocal();
    private final static ThreadLocal threadTransaction = new ThreadLocal();

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration c= new Configuration();
            sessionFactory = c.
                                addClass(GenotypeFinding.class).
                                addClass(SNPAssay.class).
                                addClass(SNPPanel.class).
                                addClass(SNPAnnotation.class).
                                addClass(SNPAnalysisGroup.class).
                                addClass(Histology.class).
                                addClass(Population.class).
                                addClass(SNPAssociationAnalysis.class).
                                addClass(SNPAssociationFinding.class).
                                addClass(SNPFrequencyFinding.class).
                                addClass(Specimen.class).
                                addClass(Study.class).
                                addClass(StudyParticipant.class).
                                addClass(TimeCourse.class).
                                addClass(Activity.class).
                                addClass(GeneBiomarker.class).
                                addClass(ClinicalFinding.class).
                                addClass(BreastCancerClinicalFinding.class).
                                addClass(Agent.class).
                                addClass(Procedure.class).
                                addClass(SubstanceAdministration.class).
                                configure().
                                buildSessionFactory();



        } catch (Throwable ex) {
            ex.printStackTrace();
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public static Session getSession() {
        Session s = (Session) threadSession.get();
        try {
            if (s == null || !(s.isOpen())) {
                s = sessionFactory.openSession();
                threadSession.set(s);
            }
        } catch(HibernateException he) {
            throw new ExceptionInInitializerError(he);
        }
        return s;
    }
    public static void closeSession() {
         try {
            Session s = (Session) threadSession.get();
             threadSession.set(null);
             if ((s != null) && (s.isOpen()) ) {
                s.close();

            }
        } catch(HibernateException he) {
            throw new ExceptionInInitializerError(he);
        }
    }
    public static void beginTransaction() {
        Transaction tx = (Transaction) threadTransaction.get();
        try {
            if (tx == null) {
                tx = getSession().beginTransaction();
                threadTransaction.set(tx);
            }
        } catch(HibernateException he) {
            throw new ExceptionInInitializerError(he);
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}