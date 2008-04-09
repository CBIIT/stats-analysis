package gov.nih.nci.caintegrator.studyQueryService.dto.epi;

/**
  * Author: Ram Bhattaru
  * Date:   Apr 06, 2007
  * Time:   5:08:50 PM
**/

public class RelativeMedicalCondition {

	private Boolean isAllive;
	public MedicalCondition medicalCondition;
	public Relative relative;

	public RelativeMedicalCondition(){

	}

    public Boolean getAllive() {
        return isAllive;
    }

    public void setAllive(Boolean allive) {
        isAllive = allive;
    }

    public MedicalCondition getMedicalCondition() {
        return medicalCondition;
    }

    public void setMedicalCondition(MedicalCondition medicalCondition) {
        this.medicalCondition = medicalCondition;
    }

    public Relative getRelative() {
        return relative;
    }

    public void setRelative(Relative relative) {
        this.relative = relative;
    }
}