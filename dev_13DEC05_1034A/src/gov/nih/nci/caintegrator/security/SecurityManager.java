package gov.nih.nci.caintegrator.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

import gov.nih.nci.caintegrator.dto.de.InstitutionDE;
import gov.nih.nci.caintegrator.security.UserCredentials.UserRole;
import gov.nih.nci.security.AuthenticationManager;
import gov.nih.nci.security.AuthorizationManager;
import gov.nih.nci.security.SecurityServiceProvider;
import gov.nih.nci.security.UserProvisioningManager;
import gov.nih.nci.security.authorization.domainobjects.Group;
import gov.nih.nci.security.authorization.domainobjects.ProtectionElement;
import gov.nih.nci.security.authorization.domainobjects.ProtectionElementPrivilegeContext;
import gov.nih.nci.security.authorization.domainobjects.User;
import gov.nih.nci.security.exceptions.CSException;

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
			Collection<InstitutionDE> institutes = new ArrayList<InstitutionDE>();
			User user = authorizationManager.getUser(userName);
			/**
			 * Protection Elements are the data sets that each institute has submitted
			 * Each user is asigned first a username, then a group.  A group is assigned
			 * a protection group, and a protection group is assigned a set of protection
			 * elements.
			 * 
			 * For instance danielR is assigned to the SUPER_USER group.  The SUPER_USER
			 * group has a Protection Group called SUPER_USER_DATA.  SUPER_USER_DATA
			 * has all the applications Protection Elements assigned to it.  In other
			 * words username danielR is able to access all protection elements in
			 * the application, or rather, danielR is able to access all submitted
			 * data from all institutes.
			 * 
			 * IMPORTANT!
			 * For caIntegrator we refer to what the CSM calls a group as a Role.
			 * This may change later but I thought I would put that down here so 
			 * as to avoid confusion.  So, we will be grabbing the assigned group(s)
			 * for the user and then assigning them a "Role" in the application
			 * 
			 * DBauer
			 */
			Set protectionElements;
			Set<Group> groups;
			try {
				protectionElements = userProvisioningManager.getProtectionElementPrivilegeContextForUser(user.getUserId().toString());
				groups = userProvisioningManager.getGroups(user.getUserId().toString());	
			} catch (Exception e) {
				logger.error("No ProtectionElementPrivlegeContexts found for user:"+ userName);
				logger.error(e);
				throw new AuthenticationException("ProtectionElementPrivlegeContexts are null");
			}
			if(protectionElements!=null) {
				try {
					/*
					 * For all the protection elements allowed for reading
					 * create institution domain elements and store into the
					 * user credentials.
					 */
					for(Iterator i = protectionElements.iterator();i.hasNext();) {
						ProtectionElementPrivilegeContext pepc = (ProtectionElementPrivilegeContext)i.next();
						ProtectionElement pe = pepc.getProtectionElement();
						Long instituteId = new Long(pe.getObjectId());
						String name = pe.getProtectionElementName();
						institutes.add(new InstitutionDE(name,instituteId));
					}
					
					logger.debug("Username: "+userName+" has the following credentials:");
					logger.debug("--------------------------------------------------------");
					for(InstitutionDE institute:institutes) {
						logger.debug("Allowed to read:" +institute.getInstituteName());
					}
					logger.debug("--------------------------------------------------------");
					/*
					 * Create the UserRole for the application.  Right now
					 * this isn't really used for anything as the actual
					 * credentials contain the information that will be used to
					 * determine what the user is allowed to actually see.  But
					 * we will pass it along for now incase we want to make any
					 * snap judgments about the user after they are logged in
					 */
					UserRole role = getUserRole(groups);
					credentials = new UserCredentials(userName, role, institutes);
				}catch(NullPointerException npe) {
					logger.error("Security Objects are null.") ;
					throw new AuthenticationException("Some SecurityObjects are null");
				}
			}
			
		}if(credentials==null){
			logger.error("authentication is returning a Null Credentials Object");
		}
		return credentials;
	}
	/**
	 * This method creates a UserRole for the application based on the the group
	 * that the userId is assigned.  There are three possibilities:
	 * 	SUPER_USER - Allowed to see all data
	 * 	PUBLIC_USER -Only allowed to see public data
	 * 	INSTITUTE_USER - Only allowed to see public data and data that insititute
	 * 	has submitted
	 * 
	 * @param groups
	 * @return
	 */
	private UserRole getUserRole(Set<Group> groups) {
		UserRole role = null;
		for(Group group: groups) {
			String groupName = group.getGroupName();
			if(groupName.equals(UserRole.SUPER_USER.toString())) {
				role = UserRole.SUPER_USER;
			}else if(groupName.equals(UserRole.PUBLIC_USER.toString())) {
				role = UserRole.PUBLIC_USER;
			}else {
				role = UserRole.INSTITUTE_USER;
			}
		}
		logger.debug("User assigned the role of "+role);
		return role;
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
	            throw new AuthenticationException("User Name or Password is not correct");		            
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
