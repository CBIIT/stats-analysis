/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

import java.io.IOException;

import javax.jmi.reflect.RefPackage;

/**
 * Classes that implement this interface are responsible for
 * providing a reference into the MOF model instance.
 * @author caBIO Team
 * @version 1.0
 */
public interface ModelAccess {

    /**
     * Reads the MOF model named by the given modelName
     * located in the XMI file at the given URI.
     * 
     * @param uri                   the location of the XMI file.
     * @param modelName				the name of the model within the XMI file.
     * @throws IOException          if there is an error opening the XMI file.
     * @throws ModelAccessException if there is an error parsing the XMI file.
     */
	void readModel(String uri, String modelName) throws IOException, ModelAccessException;

	/**
	 * Returns a javax.jmi.reflect.RefPackage that is the entry point into the model.
	 * 
	 * @return the outermost RefPackage object.
	 */
	RefPackage getOutermostExtent();
	
	/**
	 * Should be called before calling readModel.
	 * 
	 * @throws ModelAccessException
	 */
	void beginTransaction() throws ModelAccessException;
	
	/**
	 * Should be called before exiting.
	 * 
	 * @throws ModelAccessException
	 */
	void commitTransaction() throws ModelAccessException;
	
	/**
	 * Should be called after an exception is thrown and before exiting.
	 * 
	 * @throws ModelAccessException
	 */
	void rollback() throws ModelAccessException;
}
