package gov.nih.nci.caintegrator.util;

import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationFinding;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.GeneBiomarker;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAssay;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel;
import gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding;
import gov.nih.nci.caintegrator.domain.study.bean.Histology;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.study.bean.Specimen;
import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant;
import gov.nih.nci.caintegrator.domain.study.bean.TimeCourse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private final static ThreadLocal threadSession = new ThreadLocal();
    private final static ThreadLocal threadTransaction = new ThreadLocal();

    static {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration c= new Configuration();
            /*sessionFactory = c.
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

                                configure().
                                buildSessionFactory();
*/

                                c.addClass(GenotypeFinding.class);
                                c.addClass(SNPAssay.class);
                                c.addClass(SNPPanel.class);
                                c.addClass(SNPAnnotation.class);
                                c.addClass(SNPAnalysisGroup.class);
                                c.addClass(Histology.class);
                                c.addClass(Population.class);
                                c.addClass(SNPAssociationAnalysis.class);
                                c.addClass(SNPAssociationFinding.class);
                                c.addClass(SNPFrequencyFinding.class);
                                c.addClass(Specimen.class);
                                c.addClass(Study.class);
                                c.addClass(StudyParticipant.class);
                                c.addClass(TimeCourse.class);
                                c.addClass(GeneBiomarker.class);

           sessionFactory = c.configure().
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