package gov.nih.nci.caintegrator.studyQueryService.dto.germline;

import gov.nih.nci.caintegrator.studyQueryService.dto.FindingCriteriaDTO;
import gov.nih.nci.caintegrator.studyQueryService.germline.FindingsHandler;
import gov.nih.nci.caintegrator.studyQueryService.germline.SNPFrequencyFindingHandler;
import gov.nih.nci.caintegrator.util.ArithematicOperator;

/**
 * User: Ram Bhattaru
 * Date: Jul 3, 2006
 * Time: 5:21:49 PM
*/

/**
 * A class describing counts and characteristics of alleles and genotypes for  SNP
 * polymorphisms observed in a CGEMS population.
 */

public class SNPFrequencyFindingCriteriaDTO extends FindingCriteriaDTO {

	private Float hardyWeinbergPValue;
    ArithematicOperator hardyWeinbergPValueOperator;
    public ArithematicOperator getHardyWeinbergPValueOperator() {
        return hardyWeinbergPValueOperator;
    }
    public void setHardyWeinbergPValue(Float hardyWeinbergPValue, ArithematicOperator hardyWeinbergPValueOperator) {
        this.hardyWeinbergPValue = hardyWeinbergPValue;
        this.hardyWeinbergPValueOperator = hardyWeinbergPValueOperator;
     }


     public Double completionRate;
     ArithematicOperator completeRateOperator;
     public Double getCompletionRate() {
        return completionRate;
     }
     public ArithematicOperator getCompleteRateOperator() {
        return completeRateOperator;
     }
     public void setCompletionRate(Double completionRate,  ArithematicOperator completeRateOperator) {
        this.completionRate = completionRate;
        this.completeRateOperator = completeRateOperator;
     }

	 private Integer heterozygoteCount;
	 private Float minorAlleleFrequency;
     ArithematicOperator minorAlleleOperator;
     public void setMinorAlleleFrequency(Float minorAlleleFrequency,  ArithematicOperator minorAlleleOperator) {
        this.minorAlleleFrequency = minorAlleleFrequency;
        this.minorAlleleOperator = minorAlleleOperator;
     }
     public ArithematicOperator getMinorAlleleOperator() {
        return minorAlleleOperator;
     }

     private Integer missingAlleleCount;
	 private Integer missingGenotypeCount;
	 private String otherAllele;
	 private Integer otherAlleleCount;
	 private Integer otherHomogygoteCount;
	 private String referenceAllele;
	 private Integer referenceAlleleCount;
	 private Integer referenceHomogyzoteCount;
     private String populationName;
     private String studyName;
     private String sponsorStudyIdentifier;

     public SNPFrequencyFindingCriteriaDTO(){ }

     public String getPopulationName() {
        return populationName;
     }

     public void setPopulationName(String populationName) {
        this.populationName = populationName;
     }

     public String getStudyName() {
        return studyName;
     }

     public void setStudyName(String studyName) {
        this.studyName = studyName;
     }

     public String getSponsorStudyIdentifier() {
        return sponsorStudyIdentifier;
     }

     public void setSponsorStudyIdentifier(String sponsorStudyIdentifier) {
        this.sponsorStudyIdentifier = sponsorStudyIdentifier;
     }

     public Float getHardyWeinbergPValue() {
        return hardyWeinbergPValue;
     }

     public Integer getHeterozygoteCount() {
        return heterozygoteCount;
     }

     public void setHeterozygoteCount(Integer heterozygoteCount) {
        this.heterozygoteCount = heterozygoteCount;
     }

     public Float getMinorAlleleFrequency() {
        return minorAlleleFrequency;
     }

     public Integer getMissingAlleleCount() {
        return missingAlleleCount;
     }

     public void setMissingAlleleCount(Integer missingAlleleCount) {
        this.missingAlleleCount = missingAlleleCount;
     }

     public Integer getMissingGenotypeCount() {
        return missingGenotypeCount;
     }

     public void setMissingGenotypeCount(Integer missingGenotypeCount) {
        this.missingGenotypeCount = missingGenotypeCount;
     }

     public String getOtherAllele() {
        return otherAllele;
     }

     public void setOtherAllele(String otherAllele) {
        this.otherAllele = otherAllele;
     }

     public Integer getOtherAlleleCount() {
        return otherAlleleCount;
     }

     public void setOtherAlleleCount(Integer otherAlleleCount) {
        this.otherAlleleCount = otherAlleleCount;
     }

     public Integer getOtherHomogygoteCount() {
        return otherHomogygoteCount;
     }

     public void setOtherHomogygoteCount(Integer otherHomogygoteCount) {
        this.otherHomogygoteCount = otherHomogygoteCount;
     }

     public String getReferenceAllele() {
        return referenceAllele;
     }

     public void setReferenceAllele(String referenceAllele) {
        this.referenceAllele = referenceAllele;
     }

     public Integer getReferenceAlleleCount() {
        return referenceAlleleCount;
     }

     public void setReferenceAlleleCount(Integer referenceAlleleCount) {
        this.referenceAlleleCount = referenceAlleleCount;
     }

     public Integer getReferenceHomogyzoteCount() {
        return referenceHomogyzoteCount;
     }

     public void setReferenceHomogyzoteCount(Integer referenceHomogyzoteCount) {
        this.referenceHomogyzoteCount = referenceHomogyzoteCount;
     }

     public FindingsHandler getHandler() {
        return new SNPFrequencyFindingHandler();
     }
}