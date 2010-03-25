

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * indication of tumor type
   */

public  enum InvasivePresentation 


{
 	
	   
       /**
   * benign
   */

     benign
	   
       /**
   * Ductal Carcinoma In Situ 
   */

     , dcis
	   
       /**
   * Marked by the tendency to spread
   */

     , invasive
	   
       /**
   * lobular carcinoma in situ
   */

     , lcis
	   
       /**
   * non-malignant breast epithelial cells
   */

     , mne
	   
       /**
   * non-malignant stroma
   */

     , mns;
}