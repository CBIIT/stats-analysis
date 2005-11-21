package gov.nih.nci.caintegrator.security;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import gov.nih.nci.caintegrator.security.UserCredentials.UserRole;
import gov.nih.nci.security.AuthenticationManager;
import gov.nih.nci.security.AuthorizationManager;
import gov.nih.nci.security.SecurityServiceProvider;
import gov.nih.nci.security.UserProvisioningManager;
import gov.nih.nci.security.authorization.domainobjects.ProtectionElement;
import gov.nih.nci.security.authorization.domainobjects.ProtectionElementPrivilegeContext;
import gov.nih.nci.security.authorization.domainobjects.User;
import gov.nih.nci.security.exceptions.CSException;
import gov.nih.nci.security.exceptions.CSObjectNotFoundException;

import javax.security.sasl.AuthenticationException;

import org.apache.log4j.Logger;
/**
 * This will eventually become an implementation class of the security manager
 * interface that will be bundled with caIntegrator.  For now it will reside in
 * caIntegator_spec as we work on getting everything in the security module
 * ironed out.
 * 
 * @author BauerD
 *
 */
public class SecurityManager {
	private static SecurityManager instance;
	private static Logger logger = Logger.getLogger(SecurityManager.class);
	private static AuthorizationManager authorizationManager;
	private static UserProvisioningManager userProvisioningManager;
	
	private SecurityManager(){}
		
	public static SecurityManager getInstance(){
		if( instance == null){
			instance = new SecurityManager();
		}
		return instance;
	}

	/***
	 * Will authenticate the user by the password they provide. Will either 
	 * create and return a populated UserCredentials object or will throw an
	 * AuthenticationException.
	 * 
	 * This implementation is currently using CSM via LDAP to authenticate.
	 * Authorization is done through the Rembrandt database where user roles
	 * are stored with associated Institutes.
	 * 
	 * @param userName
	 * @param password
	 * @return userCredentials can be null if any exceptions are thrown while
	 * trying to access the SecurityManager classes.
	 *  
	 * @throws AuthenticationException
	 */
	public UserCredentials authenticate(String userName, String password) throws AuthenticationException{
		UserCredentials credentials = null;
		boolean authenticated = localAuthenticate(userName,password);
		try {
			authorizationManager = getAuthorizationManager();
			userProvisioningManager = getUserProvisioningManager();
		}catch(Exception e) {
			logger.error(e);
			logger.debug(e);
			throw new AuthenticationException("Unable to obtain Required Security Managers");
		}
		if(authenticated) {
			HashMap<String, Integer> institutes = new HashMap<String, Integer>();
			User user = authorizationManager.getUser(userName);
			Set protectionElements;
			try {
				protectionElements = userProvisioningManager.getProtectionElementPrivilegeContextForUser(user.getUserId().toString());
			} catch (Exception e) {
				logger.error("No ProtectionElementPrivlegeContexts found for user:"+ userName);
				logger.error(e);
				throw new AuthenticationException("ProtectionElementPrivlegeContexts are null");
			}
			if(protectionElements!=null) {
				try {
				for(Iterator i = protectionElements.iterator();i.hasNext();) {
					ProtectionElementPrivilegeContext pepc = (ProtectionElementPrivilegeContext)i.next();
					ProtectionElement pe = pepc.getProtectionElement();
					Integer objectId = new Integer(pe.getObjectId());
					String description = pe.getProtectionElementName();
					institutes.put(description,objectId);
				}
				credentials = new UserCredentials(userName, UserRole.SUPER_USER, institutes);
				}catch(NullPointerException npe) {
					logger.error("Security Objects are null.") ;
					throw new AuthenticationException("SecurityObjects are null");
				}
			}
			
		}if(credentials==null){
			logger.error("authenticate is returning a Null Credentials Object");
		}
		return credentials;
	}
	
	/**
	 * Authenticates the username and password using the Common Security Module
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	private boolean localAuthenticate(String username, String password) throws AuthenticationException{
		 AuthenticationManager am = null;
		 
	        boolean loggedIn = false;
	        try {
	            /**
	    		 * TODO get application Ccontext from system properties
	    		 */
	            am = SecurityServiceProvider.getAuthenticationManager("rembrandt");
	            loggedIn = am.login(username, password);

	        } catch (CSException e) {
	        	/**the following  if clause will only be used until the 
		         * app is released as a backdoor for developers and non NIH
		         * folks. Once the app is moved, this clause should also be removed.
		         * -kevin rosso
		         */
		        if(username.equals("RBTuser") && password.equals("RBTpass")){
		            loggedIn = true;
		        }
		        if(loggedIn) {
		        	
		            logger.debug("loginSuccess");
		        } else {
		        	logger.debug("loginFail");
		            logger.error(e);
		            throw new AuthenticationException("User Name or Password is not correct");		            
		        }
	            
	        }
	        
	        return loggedIn;
	}
	private static AuthorizationManager getAuthorizationManager() throws CSException{
		if(authorizationManager==null) {
			authorizationManager = SecurityServiceProvider.getAuthorizationManager("rembrandt");
		}
		return authorizationManager;
	}
	
	private User getUser(String loginName){
		if(authorizationManager!=null) {
			return authorizationManager.getUser(loginName);
		}else {
			return null;
		}
	}
	private static UserProvisioningManager getUserProvisioningManager() throws CSException{
		if(userProvisioningManager==null) {
			userProvisioningManager = SecurityServiceProvider.getUserProvisioningManager("rembrandt");
		}
		return userProvisioningManager;
	}
	
	
	
}
