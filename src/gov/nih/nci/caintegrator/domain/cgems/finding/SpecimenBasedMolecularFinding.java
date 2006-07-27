

package gov.nih.nci.caintegrator.domain.cgems.finding;

import gov.nih.nci.caintegrator.domain.cgems.study.Specimen;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */

public  abstract class SpecimenBasedMolecularFinding implements java.io.Serializable {
    /**
   * A part of a thing, or of several things, removed to demonstrate or to determine the character of the 
   * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study; 
   * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis. 
   * NOTE: Can be a sample of a collection or biopsy. (arc relationship) 
   * 
   */
   private Specimen specimen;
   public Specimen getSpecimen(){
        return specimen;
    }
    public void setSpecimen(Specimen specimen){
        this.specimen = specimen;
    }

}