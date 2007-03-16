package gov.nih.nci.caintegrator.studyQueryService.germline;

import gov.nih.nci.caintegrator.domain.study.bean.Study;
import gov.nih.nci.caintegrator.domain.study.bean.Population;
import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAnalysisGroup;

import java.util.Comparator;

/**
 * Created by IntelliJ IDEA.
 * User: Ram Bhattaru
 * Date: Feb 21, 2007
 * Time: 5:37:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class ObjectComparator {
    public static class StudyNameComparator implements Comparator {
        public int compare(Object a, Object b) {
            Study s1 = (Study)a;
            Study s2 = (Study)b;
            String studyName1 = s1.getName();
            String studyName2 = s2.getName();
            return studyName1.compareTo(studyName2);
        }
    }

    public static class PanelyNameComparator implements Comparator {
        public int compare(Object a, Object b) {
            SNPPanel s1 = (SNPPanel)a;
            SNPPanel s2 = (SNPPanel)b;
            String panelName1 = s1.getName();
            String panelName2 = s2.getName();
            return panelName1.compareTo(panelName2);
        }
    }

    public static class PopulationNameComparator implements Comparator {
        public int compare(Object a, Object b) {
            Population obj1 = (Population)a;
            Population obj2 = (Population)b;
            String name1 = obj1.getName();
            String name2 = obj2.getName();
            return name1.compareTo(name2);
        }
    }

     public static class SNPAnalysisNameComparator implements Comparator {
         public int compare(Object a, Object b) {
            SNPAssociationAnalysis s1 = (SNPAssociationAnalysis)a;
            SNPAssociationAnalysis s2 = (SNPAssociationAnalysis)b;
            String assocName1 = s1.getName();
            String assocName2 = s2.getName();
            return assocName1.compareTo(assocName2);
         }
    }

    public static class SNPAnalysisGroupNameComparator implements Comparator {
        public int compare(Object a, Object b) {
            SNPAnalysisGroup s1 = (SNPAnalysisGroup)a;
            SNPAnalysisGroup s2 = (SNPAnalysisGroup)b;
            String groupName1 = s1.getName();
            String groupName2 = s2.getName();
            return groupName1.compareTo(groupName2);
        }
    }
}
