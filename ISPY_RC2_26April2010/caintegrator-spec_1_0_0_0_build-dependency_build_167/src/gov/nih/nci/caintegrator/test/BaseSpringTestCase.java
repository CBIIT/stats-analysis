package gov.nih.nci.caintegrator.test;

import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public abstract class BaseSpringTestCase extends TestCase {
    
    protected ApplicationContext ctx = new FileSystemXmlApplicationContext(getConfigFiles());
    protected FindingsManager manager;

    public BaseSpringTestCase() {
        manager = (FindingsManager)ctx.getBean("findingsManager");
        
    }

    public abstract String[] getConfigFiles();

}
