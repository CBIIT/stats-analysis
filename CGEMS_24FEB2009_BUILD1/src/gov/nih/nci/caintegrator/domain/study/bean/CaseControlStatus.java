

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Phenotype status of the subject relative to the disease of interest. Possible values: CONTROL, 
   * CASE, CASE_EARLY, CASE_ADVANCED, UNKNOWN 
   * 
   */

public  enum CaseControlStatus 


{
 	
	   
       /**
   * StudyPaticipant's status  relative to the disease of interest is CASE
   */

     _case
	   
       /**
   * StudyPaticipant's status  relative to the disease of interest is CASE_ADVANCED
   */

     , case_advanced
	   
       /**
   * StudyPaticipant's status  relative to the disease of interest is CASE_EARLY
   */

     , case_early
	   
       /**
   * StudyPaticipant's status  relative to the disease of interest is CONTROL
   */

     , control
	   
       /**
   * StudyPaticipant's status  relative to the disease of interest is UNKNOWN
   */

     , unknown;
}