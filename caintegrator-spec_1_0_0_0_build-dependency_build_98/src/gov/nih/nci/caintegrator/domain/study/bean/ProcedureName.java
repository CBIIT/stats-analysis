

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Names assigned to health care procedures done for diagnostic, surveillance, treatment, palliation, 
   * or study-directed purposes. Values include: Bone Scan; Colonoscopy; CAT Scan; Biopsy; Flow Cytometry, 
   * Blood; Flow Cytometry, Bone Marrow; MRI; X-ray, Chest; Physical Examination, Positron Emission 
   * Tomography; MUGA Scan; Transrectal Ultrasound; Ultrasound; Flow cytometry. NOTE: Also maps to 
   * Test Name 2004448 and Procedure performed indicator 2006635. NOTE: Should consider adding "Lab 
   * Draw" as a possible type of Procedure. AnthraCyclline-1, AnthraCyclline-2, Taxane-1 
   * 
   */

public  enum ProcedureName 


{
 	
	   
       /**
   * A biopsy (in Greek: bios = life and opsy = look/appearance) is a medical test involving the removal 
   * of cells or tissues for examination. The tissue is often examined under a microscope and can also 
   * be analyzed chemically (for example, using PCR techniques). 
   * 
   */

     biopsy
	   
       /**
   * Blood
   */

     , blood
	   
       /**
   * Bone Marrow
   */

     , boneMarrow
	   
       /**
   * Bone Scan
   */

     , boneScan
	   
       /**
   * Computed tomography (CT), originally known as computed axial tomography (CAT or CAT scan) and body 
   * section roentgenography, is a medical imaging method employing tomography where digital geometry 
   * processing is used to generate a three-dimensional image of the internals of an object from a large 
   * series of two-dimensional X-ray images taken around a single axis of rotation. 
   * 
   */

     , cATScan
	   
       /**
   * the minimally invasive endoscopic examination of the large colon and the distal part of the small 
   * bowel with a fiber optic camera on a flexible tube passed through the anus. It may provide a visual 
   * diagnosis (e.g. ulceration, polyps) and grants the opportunity for biopsy of suspected lesions. 
   * 
   */

     , colonoscopy
	   
       /**
   * a technique for counting, examining and sorting microscopic particles suspended in a stream of 
   * fluid. It allows simultaneous multiparametric analysis of the physical and/or chemical characteristics 
   * of single cells flowing through an optical/electronic detection apparatus. 
   * 
   */

     , flowCytometry
	   
       /**
   * Magnetic resonance imaging (MRI), formerly referred to as magnetic resonance tomography (MRT) 
   * or nuclear magnetic resonance (NMR), is a method used to visualize the inside of living organisms 
   * as well as to detect the composition of geological structures. It is primarily used to demonstrate 
   * pathological or other physiological alterations of living tissues and is a commonly used form of 
   * medical imaging. 
   * 
   */

     , mRI
	   
       /**
   * A MUGA scan (Multiple Gated Acquisition Scan) is a nuclear medicine test to evaluate the function 
   * of the heart. It provides a movie-like image of the beating heart, and allows the doctor to determine 
   * the health of the heart’s major pumping chambers. 
   * 
   */

     , mUGAScan
	   
       /**
   * In medicine, the physical examination or clinical examination is the process by which the physician 
   * investigates the body of a patient for signs of disease. It generally follows the taking of the medical 
   * history — an account of the symptoms as experienced by the patient. Together with the medical history, 
   * the physical examination aids in determining the correct diagnosis and devising the treatment 
   * plan. This data then becomes part of the medical record. 
   * 
   */

     , physicalExamination
	   
       /**
   * Positron emission tomography (PET) is a nuclear medicine medical imaging technique which produces 
   * a three dimensional image or map of functional processes in the body. 
   * 
   */

     , positronEmissionTomography
	   
       /**
   * Transrectal ultrasound uses inaudible sound waves produced by a probe inserted into the rectum 
   * to create an image of organs in the pelvis. The most common indication for transrectal ultrasound 
   * is for the evaluation of the prostate gland in men with elevated prostate specific antigen or prostatic 
   * nodules on digital rectal exam. 
   * 
   */

     , transrectalUltrasound
	   
       /**
   * Ultrasound is sound with a frequency greater than the upper limit of human hearing, this limit being 
   * approximately 20 kilohertz (20,000 hertz). 
   * 
   */

     , ultrasound
	   
       /**
   * X-rays are a form of electromagnetic radiation with a wavelength in the range of 10 to 0.01 nanometres, 
   * corresponding to frequencies in the range 30 to 30 000 PHz (1015 hertz). 
   * 
   */

     , x_ray;
}