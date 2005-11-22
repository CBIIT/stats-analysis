package gov.nih.nci.caintegrator.security;

import gov.nih.nci.caintegrator.dto.de.InstitutionDE;

import java.util.Collection;

/***
 * Class that will hold the "Credentials" required to fully use a caIntegrator
 * based application.  It will hold the Role of the user and the institutes that
 * the user is associated with.
 * 
 * The UserCredentials may have 1 of 3 roles.
 * 	
 *  UserRole.PUBLIC_USER is able to access only public data
 *  
 *  UserRole.INSTITUTE_USER is able to view PUBLIC_USER data and the data of the Institutes
 *  listed in the Set institutes.
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
	private Collection<InstitutionDE> institutes;
	private boolean authenticated = false;
	
	public enum UserRole{
		PUBLIC_USER, INSTITUTE_USER, SUPER_USER;
		public  String toString()
		{
			switch(this) {
			case PUBLIC_USER:
				return "PUBLIC_USER";
			case INSTITUTE_USER:
				return "INSTITUTE_USER";
			case SUPER_USER:
				return "SUPER_USER";
			default:
				//this should never happen
				return "UNDEFINED_USER_ROLE";
			}
		}	
	}

	/**
	 * The institutes whose data the user is allowed to see
	 * @return
	 */
	public Collection<InstitutionDE> getInstitutes() {
		return this.institutes;
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
	 * @param institutes
	 */
	protected UserCredentials(String userName, UserRole role, Collection<InstitutionDE> allowableData) {
		this.userName = userName;
		this.role = role;
		this.institutes = allowableData;
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