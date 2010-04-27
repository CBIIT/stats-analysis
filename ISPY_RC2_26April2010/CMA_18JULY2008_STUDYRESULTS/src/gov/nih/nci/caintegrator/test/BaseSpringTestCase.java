package gov.nih.nci.caintegrator.test;

import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsManager;
import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.beans.BeansException;

public abstract class BaseSpringTestCase extends TestCase {

    public  ApplicationContext ctx = null;
    protected FindingsManager manager;

    public BaseSpringTestCase() {

        try {
            ctx = new FileSystemXmlApplicationContext(getConfigFiles());
        } catch (Throwable e) {
            e.printStackTrace();
        }


        manager = (FindingsManager)ctx.getBean("findingsManager");

    }

    public abstract String[] getConfigFiles();

}
