package gov.nih.nci.caintegrator.domain.finding.clinical.leukemia.bean;

import gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement;
import gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment;
import gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding;
import gov.nih.nci.caintegrator.domain.finding.clinical.breastCancer.bean.BreastCancerClinicalFinding;

public class LeukemiaClinicalFinding extends ClinicalFinding {
    /**  */
    private static final long serialVersionUID = -5187741527113149965L;

    private ClinicalAssessment stratum;
    private ClinicalAssessment congenitalAbnormality;
    private ClinicalAssessment centralNervousSystemDiseaseStatus;
    private ClinicalAssessment testicularDiseaseStatus;
    private ClinicalAssessment telStatus;
    private ClinicalAssessment trisomies4and10Status;
    private ClinicalAssessment mllStatus;
    private ClinicalAssessment e2aStatus;
    private ClinicalAssessment bcrStatus;
    private NumericMeasurement dnaIndex;
    private NumericMeasurement boneMarrowBlastPercentage;
    private ClinicalAssessment minimumResidualDisease;
    private ClinicalAssessment peripheralBloodWhiteBloodCount;
    private NumericMeasurement peripheralBloodBlastPercentage;
    private TextMeasurement karyotype;
    private gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant studyParticipant;
    

    /**
     * @return Returns the studyParticipant.
     */
    public gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant getStudyParticipant() {
        return studyParticipant;
    }

    /**
     * @param studyParticipant The studyParticipant to set.
     */
    public void setStudyParticipant(
            gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant studyParticipant) {
        this.studyParticipant = studyParticipant;
    }

    public ClinicalAssessment getBcrStatus() {
        return bcrStatus;
    }

    public void setBcrStatus(ClinicalAssessment bcrStatus) {
        this.bcrStatus = bcrStatus;
    }

    public NumericMeasurement getBoneMarrowBlastPercentage() {
        return boneMarrowBlastPercentage;
    }

    public void setBoneMarrowBlastPercentage(
            NumericMeasurement boneMarrowBlastPercentage) {
        this.boneMarrowBlastPercentage = boneMarrowBlastPercentage;
    }

    public ClinicalAssessment getCentralNervousSystemDiseaseStatus() {
        return centralNervousSystemDiseaseStatus;
    }

    public void setCentralNervousSystemDiseaseStatus(
            ClinicalAssessment centralNervousSystemDiseaseStatus) {
        this.centralNervousSystemDiseaseStatus = centralNervousSystemDiseaseStatus;
    }

    public ClinicalAssessment getCongenitalAbnormality() {
        return congenitalAbnormality;
    }

    public void setCongenitalAbnormality(
            ClinicalAssessment congenitalAbnormality) {
        this.congenitalAbnormality = congenitalAbnormality;
    }

    public NumericMeasurement getDnaIndex() {
        return dnaIndex;
    }

    public void setDnaIndex(NumericMeasurement dnaIndex) {
        this.dnaIndex = dnaIndex;
    }

    public ClinicalAssessment getE2aStatus() {
        return e2aStatus;
    }

    public void setE2aStatus(ClinicalAssessment status) {
        e2aStatus = status;
    }

    public TextMeasurement getKaryotype() {
        return karyotype;
    }

    public void setKaryotype(TextMeasurement karyotype) {
        this.karyotype = karyotype;
    }

    public ClinicalAssessment getMinimumResidualDisease() {
        return minimumResidualDisease;
    }

    public void setMinimumResidualDisease(
            ClinicalAssessment minimumResidualDisease) {
        this.minimumResidualDisease = minimumResidualDisease;
    }

    public ClinicalAssessment getMllStatus() {
        return mllStatus;
    }

    public void setMllStatus(ClinicalAssessment mllStatus) {
        this.mllStatus = mllStatus;
    }

    public NumericMeasurement getPeripheralBloodBlastPercentage() {
        return peripheralBloodBlastPercentage;
    }

    public void setPeripheralBloodBlastPercentage(
            NumericMeasurement peripheralBloodBlastPercentage) {
        this.peripheralBloodBlastPercentage = peripheralBloodBlastPercentage;
    }

    public ClinicalAssessment getPeripheralBloodWhiteBloodCount() {
        return peripheralBloodWhiteBloodCount;
    }

    public void setPeripheralBloodWhiteBloodCount(
            ClinicalAssessment peripheralBloodWhiteBloodCount) {
        this.peripheralBloodWhiteBloodCount = peripheralBloodWhiteBloodCount;
    }

    public ClinicalAssessment getStratum() {
        return stratum;
    }

    public void setStratum(ClinicalAssessment stratum) {
        this.stratum = stratum;
    }

    public ClinicalAssessment getTelStatus() {
        return telStatus;
    }

    public void setTelStatus(ClinicalAssessment telStatus) {
        this.telStatus = telStatus;
    }

    public ClinicalAssessment getTesticularDiseaseStatus() {
        return testicularDiseaseStatus;
    }

    public void setTesticularDiseaseStatus(
            ClinicalAssessment testicularDiseaseStatus) {
        this.testicularDiseaseStatus = testicularDiseaseStatus;
    }

    public ClinicalAssessment getTrisomies4and10Status() {
        return trisomies4and10Status;
    }

    public void setTrisomies4and10Status(
            ClinicalAssessment trisomies4and10Status) {
        this.trisomies4and10Status = trisomies4and10Status;
    }

    public boolean equals(Object obj) {
        boolean eq = false;
        if (obj instanceof BreastCancerClinicalFinding) {
            BreastCancerClinicalFinding c = (BreastCancerClinicalFinding) obj;
            Long thisId = getId();

            if (thisId != null && thisId.equals(c.getId())) {
                eq = true;
            }

        }
        return eq;
    }

    public int hashCode() {
        int h = 0;

        if (getId() != null) {
            h += getId().hashCode();
        }

        return h;
    }
}
