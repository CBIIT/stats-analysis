package gov.nih.nci.caintegrator.studyQueryService.test.germline;

import gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPAnnotation;
import gov.nih.nci.caintegrator.studyQueryService.dto.annotation.AnnotationCriteria;
import gov.nih.nci.caintegrator.studyQueryService.dto.germline.PanelCriteria;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import gov.nih.nci.caintegrator.test.BaseSpringTestCase;

import java.util.ArrayList;
import java.util.Collection;

public class SnpAnnotationTest extends BaseSpringTestCase{

    @Override
    public String[] getConfigFiles() {
        // TODO Auto-generated method stub
        return new String[] {"classpath*:applicationContext-services.xml","test/applicationContext-junit.xml"};
    }
    
    public void testSnpAnnotation() throws Exception {
        AnnotationCriteria criteria = new AnnotationCriteria();
        PanelCriteria panel = new PanelCriteria();
        FindingsManager manager = (FindingsManager) ctx.getBean("findingsManager");
        Collection<String> genes = new ArrayList<String>();
        genes.add("EGFR");
        genes.add("VEGF");
        criteria.setGeneSymbols(genes);
        Collection<SNPAnnotation> annotations = manager.getSNPAnnotations(criteria);
        for(SNPAnnotation ann : annotations) {
            System.out.println(ann.getChromosomeName() + " : " + ann.getGeneLocation());
        }
    }

}
