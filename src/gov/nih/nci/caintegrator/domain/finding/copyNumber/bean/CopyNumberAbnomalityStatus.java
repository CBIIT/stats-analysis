/*L
 *  Copyright SAIC
 *
 *  Distributed under the OSI-approved BSD 3-Clause License.
 *  See http://ncip.github.com/stats-analysis/LICENSE.txt for details.
 */


package gov.nih.nci.caintegrator.domain.finding.copyNumber.bean;
import gov.nih.nci.caintegrator.domain.finding.copyNumber.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Indication of abnomality for copy number data
   */

public  enum CopyNumberAbnomalityStatus 


{
 	
	   
       /**
   * amplification
   */

     amplified
	   
       /**
   * deletion
   */

     , deleted
	   
       /**
   * no change
   */

     , noChange;
}