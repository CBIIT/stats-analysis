/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

package gov.nih.nci.codegen.framework;

import java.util.Collection;

  

/**
 * Responsible for selecting a set of model elements for artifact
 * generation.
 * 
 * @author caBIO Team
 * @version 1.0
 */
public interface Filter {
    
    /**
     * Filters the given Collection of model elements. Since the items within
     * the Collection may be any Object, Filters in a filter-chain must be
     * ordered so that each Filter is expecting the types of Objects that are
     * returned by the previous Filter.
     * <P/>
     * The first Filter in a filter-chain will always be given a Collection
     * of size one and that item will be of type javax.jmi.reflect.RefPackage.
     * 
     * @param modelElements        the Collection of objects returned by the
     *                             previous Filter in the filter-chain.
     * @return                     a Collection of model elements.
     * @throws FilteringException  if there is an error during filtering.
     */
	Collection execute(Collection modelElements) throws FilteringException;
}
