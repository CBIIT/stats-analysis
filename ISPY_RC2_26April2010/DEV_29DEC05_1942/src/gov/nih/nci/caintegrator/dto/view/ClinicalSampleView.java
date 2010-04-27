package gov.nih.nci.caintegrator.dto.view;

import java.io.Serializable;

import gov.nih.nci.caintegrator.dto.de.DomainElementClass;

/**
 * @author BhattarR
 */
public class ClinicalSampleView extends View implements Serializable{
    private DomainElementClass[] validDEs;

    ClinicalSampleView() {
        validDEs = new DomainElementClass[]
              { DomainElementClass.DISEASE_NAME,
        		//TODO: All List here
              };
    }

    public DomainElementClass[] getValidElements() {
        return validDEs;
    }
}
