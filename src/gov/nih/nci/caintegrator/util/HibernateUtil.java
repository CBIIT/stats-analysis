package gov.nih.nci.caintegrator.util;

import java.io.File;
	import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * @author kumarvi,sahnih
 *
 * Modified from CSM's ApplicationSessionFactory to create a
 * DataBaseSessionFactory for caIntegrator based applications.
 */
public class HibernateUtil {
	private static final String DATA_SOURCE_CONTEXT_PROPERTIES = "DataSourceContext.properties";
	//private static final SessionFactory sessionFactory;	   
    private final static ThreadLocal threadSession = new ThreadLocal();
    private final static ThreadLocal threadTransaction = new ThreadLocal();
    private static Logger logger = Logger.getLogger(HibernateUtil.class);
	
	private static Hashtable dbSessionFactories;
	  
	/**
	 * This method will read a system wide configuration file
	 * called ApplicationSecurityConfig.xml and initilaize the
	 * session factories as per the application context names
	 */
	static{
		dbSessionFactories = new Hashtable();
		/**
		 * Read all the applicationContext entries in
		 * the file and iterate through them.
		 *   for(int i=0;i<numberOfEntries;i++){
		 *   build session factory here
		 *   appSessionFactories.put(applicationContextName,sf);
		 * }
		 */
		
		Document configDocument = getConfigDocument();
		Element dbConfig = configDocument.getRootElement();
		Element applicationList = dbConfig.getChild("application-list");
		List applications = applicationList.getChildren("application");
		 Iterator appIterator  = applications.iterator();
		 while(appIterator.hasNext()){
		 	Element application = (Element)appIterator.next();
		 	Element contextName = application.getChild("context-name");
		 	String contextNameValue = contextName.getText().trim();
		 	Element hibernateConfigFile = application.getChild("hibernate-config-file");
		 	String hibernateFileName = hibernateConfigFile.getText().trim();
		 	if(!isBlank(hibernateFileName))
		 	{
			 	SessionFactory sf = initSessionFactory(hibernateFileName);
			 	dbSessionFactories.put(contextNameValue,sf);
		 	}
		 }
	}
	
	public static SessionFactory getSessionFactory() {
		SessionFactory sf = null;
//		Load the the application properties and set them as system properties
		Properties appProperties = new Properties();
	/*	String appPropertiesFileName = DATA_SOURCE_CONTEXT_PROPERTIES ;
		   
	    try 
	    {

			InputStream in = Thread.currentThread ().getContextClassLoader ().getResourceAsStream(appPropertiesFileName);
			appProperties.load(in);
		} 
	    catch (FileNotFoundException e) 
		{
	    	logger.error(" Error loading Data Source Context"+e.toString()) ;
		} 
		catch (IOException e) 
		{
			logger.error(" Error loading Data Source Context"+e.toString()) ;
		}
	  */ 
	    String applicationContextName = "cgems" ;// appProperties.getProperty("gov.nih.nci.caIntegrator.appDataSourceContext") ;
	   
		   
		 sf = (SessionFactory)dbSessionFactories.get(applicationContextName);
		 if(sf==null){
		 	sf = getFromHotInitialization(applicationContextName);
		 }
		
		 if(sf==null){
	            throw new ExceptionInInitializerError("Could not initialize session factory");
		 }
		return sf;
	}
	
	private static Document getConfigDocument(){
		Document configDoc = null;
		try {
			String configFilePath = System.getProperty("gov.nih.nci.caintegrator.configFile");
            SAXBuilder builder = new SAXBuilder();
            configDoc = builder.build(new File(configFilePath));
            return configDoc;
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(NullPointerException e) {
            e.printStackTrace();
        } catch(Exception e) {
            e.printStackTrace();

        }
        return configDoc;
	}
	
	private static SessionFactory initSessionFactory(String fileName){
		SessionFactory sf = null;
		try{

			File f = new File(fileName);
			sf = new Configuration().configure(f).buildSessionFactory();
			
			 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return sf;
	}
	
	private static SessionFactory getFromHotInitialization(String applicationContextName){
		
		SessionFactory sf = null;
		Document configDocument = getConfigDocument();
		Element securityConfig = configDocument.getRootElement();
		Element applicationList = securityConfig.getChild("application-list");
		List applications = applicationList.getChildren("application");
		Iterator appIterator  = applications.iterator();
		while(appIterator.hasNext()){
		 	Element application = (Element)appIterator.next();
		 	Element contextName = application.getChild("context-name");
		 	String contextNameValue = contextName.getText().trim();
			if(contextNameValue.equalsIgnoreCase(applicationContextName)){
			 	Element hibernateConfigFile = application.getChild("hibernate-config-file");
			 	String hibernateFileName = hibernateConfigFile.getText().trim();
			 	if(!isBlank(hibernateFileName))
			 	{
				 	sf = initSessionFactory(hibernateFileName);
				 	dbSessionFactories.put(contextNameValue,sf);
			 	}
			 	break;
			 		 	
			}
		 }
		return sf;
	}
    public static Session getSession() {
        Session s = (Session) threadSession.get();
        try {
            if (s == null || !(s.isOpen())) {
                s = getSessionFactory().openSession();
                threadSession.set(s);
            }
        } catch(HibernateException he) {
            throw new ExceptionInInitializerError(he);
        } catch (Exception e) {
			e.printStackTrace();
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
	private static boolean isBlank(String str){
	     boolean test = false;
	     
	     if(str==null){
	        test= true;
	     }else{
	     	String str1 = str.trim();
	       if(str1.equals("")){
	         test = true;
	       }
	     }
	     return test;
	  }
}