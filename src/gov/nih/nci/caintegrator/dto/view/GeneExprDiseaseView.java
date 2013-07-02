/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */

/*
 *  @author: SahniH
 *  Created on Nov 1, 2004
 *  @version $ Revision: 1.0 $
 * 
 */
package gov.nih.nci.caintegrator.dto.view;

import gov.nih.nci.caintegrator.dto.de.DomainElementClass;

/**
 * @author SahniH
 * Date: Nov 1, 2004
 * 
 */


/**
* 
* 
*/

public class GeneExprDiseaseView extends View {
    private DomainElementClass[] validDEs;

    GeneExprDiseaseView() {
        validDEs = new DomainElementClass[]
              { DomainElementClass.PROBESET,
                DomainElementClass.EXPRFOLDCHANGE,
                DomainElementClass.DISEASE_NAME,
              };
    }

    public DomainElementClass[] getValidElements() {
        return validDEs;
    }
}
