/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.system.proxy;

 
 /**
  * InterfaceProxy provides a method to query a server    
  * Proxy Interface
  * @author caBIO Team
  */
public interface InterfaceProxy {
    /**
     * Return the resultset of the query embedded in an object of gov.nih.nci.common.net.Response
     * @param Request - a gov.nih.nci.common.net.Request object passed from client 
     * @return an object of gov.nih.nci.common.net.Response that contains the query resultset
     */    
 	public gov.nih.nci.common.net.Response query(gov.nih.nci.common.net.Request request) throws Exception;
}
