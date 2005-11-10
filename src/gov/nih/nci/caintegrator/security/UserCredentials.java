package gov.nih.nci.caintegrator.security;

import java.util.Set;
/***
 * Class that will hold the "Credentials" required to fully use a caIntegrator
 * based application.  It will hold the Role of the user and the groups that
 * the user is associated with.
 * 
 * The UserCredentials may have 1 of 3 roles.
 * 	
 *  UserRole.PUBLIC is able to access only public data
 *  
 *  UserRole.INSTITUTE is able to view PUBLIC data and the data of the Institutes
 *  listed in the Set groups.
 *  
 *  UserRole.SUPER_USER is able to view all data across all institutes as well
 *  as all public data
 * 
 * 
 * @author BauerD
 *
 */
public class UserCredentials {

	private String userName;
	private UserRole role;
	private Set groups;
	private boolean authenticated = false;
	
	public enum UserRole{PUBLIC,INSTITUTE,SUPER_USER}

	/**
	 * The groups whose data the user is allowed to see
	 * @return
	 */
	public Set getGroups() {
		return this.groups;
	}

	/**
	 * @return Returns the role.
	 */
	public UserRole getRole() {
		return role;
	}

	/**
	 * @return Returns the userName.
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * This constructor is protected so that once the Credentials have been
	 * set by the SecurityManager, they can not be modified.
	 * @param userName
	 * @param role
	 * @param groups
	 */
	protected UserCredentials(String userName, UserRole role, Set groups) {
		this.userName = userName;
		this.role = role;
		this.groups = groups;
		if(role!=null) {
			authenticated = true;
		}
	}
	
	/**
	 * Checks to see if these credential have been authenticated
	 * @return
	 */
	public boolean authenticated() {
		return authenticated;
	}
	
	private void setAuthenticated(boolean auth) {
		this.authenticated = auth;
	}
	

}