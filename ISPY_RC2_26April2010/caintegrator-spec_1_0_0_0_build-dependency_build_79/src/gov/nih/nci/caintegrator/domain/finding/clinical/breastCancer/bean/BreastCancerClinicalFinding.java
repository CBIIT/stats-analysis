

package gov.nih.nci.caintegrator.domain.finding.clinical.breastCancer.bean;
import gov.nih.nci.caintegrator.domain.finding.clinical.breastCancer.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Clinical measurements or assessments in ISPY clinical trial. 
   */

public  class BreastCancerClinicalFinding 
    extends gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalFinding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Neo-Adjuvant Chemotherapy Regimen 1=AC 2=EC 3=FEC 4=FAC 5=A 6=AC?Td 7=AC?Tp 8=A?Td 9=A?Tp 12=AC 
   * ?TdH 13=AC ? TpH 14=FEC?Tp 15=EC?Tp 16=AC? TpTd 17= A?Tp ? C 18=ACV?Tp 19=AC?Td?Xeloda 20=EC ?Tp? 
   * Carboplatin 21=FEC?Tp?Abraxane 22=AC?Td?Navelbine?Xeloda 23=AC?Tp?Vinorelbine?Tarcena 
   * A=Adria C=Cytoxan E=Epirubicin F=5-Fu Td=Docetaxel Tp=Paclitaxel H=Herceptin V=Vanconycin 
   * TpTd =Crossover from Tp to Td or Td to Tp 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment chemo;
    /**
   * Neo-Adjuvant Chemotherapy Regimen 1=AC 2=EC 3=FEC 4=FAC 5=A 6=AC?Td 7=AC?Tp 8=A?Td 9=A?Tp 12=AC 
   * ?TdH 13=AC ? TpH 14=FEC?Tp 15=EC?Tp 16=AC? TpTd 17= A?Tp ? C 18=ACV?Tp 19=AC?Td?Xeloda 20=EC ?Tp? 
   * Carboplatin 21=FEC?Tp?Abraxane 22=AC?Td?Navelbine?Xeloda 23=AC?Tp?Vinorelbine?Tarcena 
   * A=Adria C=Cytoxan E=Epirubicin F=5-Fu Td=Docetaxel Tp=Paclitaxel H=Herceptin V=Vanconycin 
   * TpTd =Crossover from Tp to Td or Td to Tp 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getChemo(){
        return chemo;
    }
    public void setChemo( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment chemo){
        this.chemo = chemo;
    }
	
	   
    /**
   * Clinical Response - (If missing from form used an algorithm to determine) RECIST criteria 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment clinicalResponse;
    /**
   * Clinical Response - (If missing from form used an algorithm to determine) RECIST criteria 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getClinicalResponse(){
        return clinicalResponse;
    }
    public void setClinicalResponse( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment clinicalResponse){
        this.clinicalResponse = clinicalResponse;
    }
	
	   
    /**
   * Clinical Staging at Baseline 1= Stage 0 2= Stage I 3= Stage IIA 4=Stage IIB 5= Stage IIIA 6= Stage IIIB 
   * 7=Stage IIIC 8= Stage IV 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment clinicalStage;
    /**
   * Clinical Staging at Baseline 1= Stage 0 2= Stage I 3= Stage IIA 4=Stage IIB 5= Stage IIIA 6= Stage IIIB 
   * 7=Stage IIIC 8= Stage IV 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getClinicalStage(){
        return clinicalStage;
    }
    public void setClinicalStage( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment clinicalStage){
        this.clinicalStage = clinicalStage;
    }
	
	   
    /**
   * DCIS only thing left following surgery 1=Yes
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment dcisOnly;
    /**
   * DCIS only thing left following surgery 1=Yes
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getDcisOnly(){
        return dcisOnly;
    }
    public void setDcisOnly( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment dcisOnly){
        this.dcisOnly = dcisOnly;
    }
	
	   
    /**
   * Estrogen Receptor Status – Total Score Total Score = ER_PS+ ER_IS Considered Allred Score; = 3 is 
   * positive 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment estrogenReceptorStatus;
    /**
   * Estrogen Receptor Status – Total Score Total Score = ER_PS+ ER_IS Considered Allred Score; = 3 is 
   * positive 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getEstrogenReceptorStatus(){
        return estrogenReceptorStatus;
    }
    public void setEstrogenReceptorStatus( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment estrogenReceptorStatus){
        this.estrogenReceptorStatus = estrogenReceptorStatus;
    }
	
	   
    /**
   * HER2 receptor status
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment her2Assessment;
    /**
   * HER2 receptor status
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getHer2Assessment(){
        return her2Assessment;
    }
    public void setHer2Assessment( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment her2Assessment){
        this.her2Assessment = her2Assessment;
    }
	
	   
    /**
   * Her2 Summary method as measured in the Community 1= IHC 2=FISH 3= Other 4=Unknown 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment her2AssessmentMethod;
    /**
   * Her2 Summary method as measured in the Community 1= IHC 2=FISH 3= Other 4=Unknown 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getHer2AssessmentMethod(){
        return her2AssessmentMethod;
    }
    public void setHer2AssessmentMethod( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment her2AssessmentMethod){
        this.her2AssessmentMethod = her2AssessmentMethod;
    }
	
	   
    /**
   * Herceptin received 1=Yes (Administered) 0= Not administered blank = Administration unknown 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment herceptinReceived;
    /**
   * Herceptin received 1=Yes (Administered) 0= Not administered blank = Administration unknown 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getHerceptinReceived(){
        return herceptinReceived;
    }
    public void setHerceptinReceived( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment herceptinReceived){
        this.herceptinReceived = herceptinReceived;
    }
	
	   
    /**
   * Combined Histologic Grade - On-study (According to SBR/Elston Classification) 1=Grade I (low) 
   * 2= Grade II (intermediate) 3= Grade III (high) 4= Indeterminate 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment histologicGradeOS;
    /**
   * Combined Histologic Grade - On-study (According to SBR/Elston Classification) 1=Grade I (low) 
   * 2= Grade II (intermediate) 3= Grade III (high) 4= Indeterminate 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getHistologicGradeOS(){
        return histologicGradeOS;
    }
    public void setHistologicGradeOS( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment histologicGradeOS){
        this.histologicGradeOS = histologicGradeOS;
    }
	
	   
    /**
   * Combined Histologic Grade -Post-Surgery (According to SBR/Elston Classification) 1=Grade I 
   * (low) 2= Grade II (intermediate) 3= Grade III (high) 4= Indeterminate 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment histologicGradePS;
    /**
   * Combined Histologic Grade -Post-Surgery (According to SBR/Elston Classification) 1=Grade I 
   * (low) 2= Grade II (intermediate) 3= Grade III (high) 4= Indeterminate 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getHistologicGradePS(){
        return histologicGradePS;
    }
    public void setHistologicGradePS( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment histologicGradePS){
        this.histologicGradePS = histologicGradePS;
    }
	
	   
    /**
   * Longest dimension for the index lesion from MRI in diameter at each time point
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement longestDiameter;
    /**
   * Longest dimension for the index lesion from MRI in diameter at each time point
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getLongestDiameter(){
        return longestDiameter;
    }
    public void setLongestDiameter( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement longestDiameter){
        this.longestDiameter = longestDiameter;
    }
	
	   
    /**
   * meno-pausal status
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment menoStatus;
    /**
   * meno-pausal status
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getMenoStatus(){
        return menoStatus;
    }
    public void setMenoStatus( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment menoStatus){
        this.menoStatus = menoStatus;
    }
	
	   
    /**
   * The form and structure of a node: 1. Single uni-centric mass with well-defined margin 2. Multi-lobulated 
   * mass with well-defined margin 3. Area enhancement with irregular margins - with nodularity 4. Area 
   * enhancement with irregular margins - without nodularity 5. Septal spread; streaming 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment nodalMorphology;
    /**
   * The form and structure of a node: 1. Single uni-centric mass with well-defined margin 2. Multi-lobulated 
   * mass with well-defined margin 3. Area enhancement with irregular margins - with nodularity 4. Area 
   * enhancement with irregular margins - without nodularity 5. Septal spread; streaming 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getNodalMorphology(){
        return nodalMorphology;
    }
    public void setNodalMorphology( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment nodalMorphology){
        this.nodalMorphology = nodalMorphology;
    }
	
	   
    /**
   * Size of Largest Palpable Node (cm) – Clinical Assessment at Baseline
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement nodeSizeClinical;
    /**
   * Size of Largest Palpable Node (cm) – Clinical Assessment at Baseline
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getNodeSizeClinical(){
        return nodeSizeClinical;
    }
    public void setNodeSizeClinical( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement nodeSizeClinical){
        this.nodeSizeClinical = nodeSizeClinical;
    }
	
	   
    /**
   * Total Number of Axillary + Sentinel (post) nodes Examined, post-chemotherapy
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement numNodesExamined;
    /**
   * Total Number of Axillary + Sentinel (post) nodes Examined, post-chemotherapy
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getNumNodesExamined(){
        return numNodesExamined;
    }
    public void setNumNodesExamined( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement numNodesExamined){
        this.numNodesExamined = numNodesExamined;
    }
	
	   
    /**
   * Total Number positive Axillary + Sentinel (post) Nodes, post-chemotherapy
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement numPosNodes;
    /**
   * Total Number positive Axillary + Sentinel (post) Nodes, post-chemotherapy
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getNumPosNodes(){
        return numPosNodes;
    }
    public void setNumPosNodes( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement numPosNodes){
        this.numPosNodes = numPosNodes;
    }
	
	   
    /**
   * Primary Tumor Pathological Tumor Size Microscopic, measured in cm
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement pathologicalTumorSize;
    /**
   * Primary Tumor Pathological Tumor Size Microscopic, measured in cm
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getPathologicalTumorSize(){
        return pathologicalTumorSize;
    }
    public void setPathologicalTumorSize( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement pathologicalTumorSize){
        this.pathologicalTumorSize = pathologicalTumorSize;
    }
	
	   
    /**
   * Pathology Assessment Staging 1= Stage 0 (DCIS only) 2= Stage I 3= Stage IIA 4=Stage IIB 5= Stage IIIA 
   * 6= Stage IIIB 7=Stage IIIC 8= Stage IV 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment pathologyStage;
    /**
   * Pathology Assessment Staging 1= Stage 0 (DCIS only) 2= Stage I 3= Stage IIA 4=Stage IIB 5= Stage IIIA 
   * 6= Stage IIIB 7=Stage IIIC 8= Stage IV 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getPathologyStage(){
        return pathologyStage;
    }
    public void setPathologyStage( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment pathologyStage){
        this.pathologyStage = pathologyStage;
    }
	
	   
    /**
   * Percent Change of Longest Diameter From the Baseline Timecourse
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement percentLDChangeFromBaseline;
    /**
   * Percent Change of Longest Diameter From the Baseline Timecourse
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getPercentLDChangeFromBaseline(){
        return percentLDChangeFromBaseline;
    }
    public void setPercentLDChangeFromBaseline( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement percentLDChangeFromBaseline){
        this.percentLDChangeFromBaseline = percentLDChangeFromBaseline;
    }
	
	   
    /**
   * Progesterone Receptor Status – Total Score Total Score = PgR_PgS+ PgR_IS Considered Allred Score; 
   * = 3 is positive 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment progesteroneReceptorStatus;
    /**
   * Progesterone Receptor Status – Total Score Total Score = PgR_PgS+ PgR_IS Considered Allred Score; 
   * = 3 is positive 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getProgesteroneReceptorStatus(){
        return progesteroneReceptorStatus;
    }
    public void setProgesteroneReceptorStatus( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment progesteroneReceptorStatus){
        this.progesteroneReceptorStatus = progesteroneReceptorStatus;
    }
	
	   
    /**
   * Result, such as 0=Negative
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment sentinalNodeResult;
    /**
   * Result, such as 0=Negative
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getSentinalNodeResult(){
        return sentinalNodeResult;
    }
    public void setSentinalNodeResult( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment sentinalNodeResult){
        this.sentinalNodeResult = sentinalNodeResult;
    }
	
	   
    /**
   * Was Sentinel node sampling performed pre-treatment?
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment sentinalNodeSampleCollection;
    /**
   * Was Sentinel node sampling performed pre-treatment?
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getSentinalNodeSampleCollection(){
        return sentinalNodeSampleCollection;
    }
    public void setSentinalNodeSampleCollection( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment sentinalNodeSampleCollection){
        this.sentinalNodeSampleCollection = sentinalNodeSampleCollection;
    }
	
	   
    /**
   * Disease Stage M (metastasis) Baseline
   */

    private gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement stageMe;
    /**
   * Disease Stage M (metastasis) Baseline
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement getStageMe(){
        return stageMe;
    }
    public void setStageMe( gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement stageMe){
        this.stageMe = stageMe;
    }
	
	   
    /**
   * Disease Stage N (metastasis) Baseline
   */

    private gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement stageNe;
    /**
   * Disease Stage N (metastasis) Baseline
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement getStageNe(){
        return stageNe;
    }
    public void setStageNe( gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement stageNe){
        this.stageNe = stageNe;
    }
	
	   
    /**
   * Disease Stage T (metastasis) Baseline
   */

    private gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement stageTe;
    /**
   * Disease Stage T (metastasis) Baseline
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement getStageTe(){
        return stageTe;
    }
    public void setStageTe( gov.nih.nci.caintegrator.domain.common.bean.TextMeasurement stageTe){
        this.stageTe = stageTe;
    }
	
	   
    /**
   * Tamoxifen received 1=Yes (Administered) 0= Not administered blank = Administration unknown 
   * 
   */

    private gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment tamoxifenReceived;
    /**
   * Tamoxifen received 1=Yes (Administered) 0= Not administered blank = Administration unknown 
   * 
   */

	public  gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment getTamoxifenReceived(){
        return tamoxifenReceived;
    }
    public void setTamoxifenReceived( gov.nih.nci.caintegrator.domain.finding.clinical.bean.ClinicalAssessment tamoxifenReceived){
        this.tamoxifenReceived = tamoxifenReceived;
    }
	
	   
    /**
   * Size of Primary Tumor  (cm) Clinical Assessment at Baseline
   */

    private gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement tumorSizeClinical;
    /**
   * Size of Primary Tumor  (cm) Clinical Assessment at Baseline
   */

	public  gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement getTumorSizeClinical(){
        return tumorSizeClinical;
    }
    public void setTumorSizeClinical( gov.nih.nci.caintegrator.domain.common.bean.NumericMeasurement tumorSizeClinical){
        this.tumorSizeClinical = tumorSizeClinical;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof BreastCancerClinicalFinding) {
				BreastCancerClinicalFinding c =(BreastCancerClinicalFinding)obj; 			 
				String thisId = getId();		
				
					if(thisId != null && thisId.equals(c.getId())) {
					   eq = true;
				    }		
				
			}
			return eq;
		}
		
		public int hashCode(){
			int h = 0;
			
			if(getId() != null) {
				h += getId().hashCode();
			}
			
			return h;
	}

			
}