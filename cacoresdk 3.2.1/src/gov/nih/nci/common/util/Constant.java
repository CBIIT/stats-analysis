/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.common.util;


/**
 * Constant assigns values to static fields 
 * @author caBIO Team 
 * @version 1.0
 */
public class Constant {
	
	public static final int ORM_DAO = 1;
	public static final int WEBSERVICE = 2;
	
	public static final String WILD_CARD_PATTERN="*";
	
	public static final char DOT='.';
	public static final char COMMA=',';
	public static final char SEMICOLON=';';	
	public static final char AMPERSAND='&';	
	public static final char AT='@';		
	public static final char LEFT_BRACKET='[';
	public static final char RIGHT_BRACKET=']';	
	public static final char EQUAL='=';
	public static final char FORWARD_SLASH='/';
	public static final char SPACE=' ';	
	public static final char QUESTION_MARK='?';
	public static final char GREATER_THAN='>';
	
	public static final String AMPERSAND_STR="&";
	public static final String FORWARD_SLASH_STR="/";
	public static final String COMMA_STR=",";
	public static final String BACK_SLASH="\\";	

	public static final String ORM_FILNAME_STARTS_WITH="orm"; 
	public static int ALIAS_ID = 1;
	public static String DELEGATE_NAME = "gov.nih.nci.system.delegator.BaseDelegate";
	public static String PACKAGE_NAME = "gov.nih.nci.cacore.domain";
	public static String serialVersionUID = "serialVersionUID";
    public static final String BIOCARTA_STRING = "BioCarta";   
    public static final String XLINK_URL = "http://www.w3.org/1999/xlink";
    
	public static final int BIDIRECTIONAL = 2;
	public static final int UNIDIRECTIONAL = 1;
	public static final int NO_ASSOCIATION = 0;
	public static final int MAX_RESULT_COUNT_PER_QUERY = 5000;
	public static final int RESULT_COUNT_PER_QUERY = 1000;
	
	public static final String REMOTE_SERVICE_FILE_NAME = "remoteService.xml";
	public static final String APPLICATION_SERVICE_FILE_NAME = "applicationService.xml";
	public static final String REMOTE_APPLICATION_SERVICE = "remoteService";
	public static final String APPLICATION_SERVICE = "applicationService";
	public static final String ORM1_DAO_FILE_NAME = "orm1Dao.xml";
	public static final String ORM1_DAO = "orm1";	
	
	public static final String CSM_SECURITY_LEVEL = ".CSM.Security.Level";
	public static final String CSM_SECURITY_SESSION_TIMEOUT = "CSM.Security.Session.Timeout";
	
	public static final String USER_NAME = "username";
	public static final String PASSWORD = "password";
}
