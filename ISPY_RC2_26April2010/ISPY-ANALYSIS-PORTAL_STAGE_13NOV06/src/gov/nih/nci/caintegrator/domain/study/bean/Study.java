

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

public  class Study 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The free text field of the type of study being conducted. (CTEP)
   */

    private String description;
    /**
   * The free text field of the type of study being conducted. (CTEP)
   */

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
	   
    /**
   * The date when the study was completed
   */

    private java.util.Date endDate;
    /**
   * The date when the study was completed
   */

	public  java.util.Date getEndDate(){
        return endDate;
    }
    public void setEndDate( java.util.Date endDate){
        this.endDate = endDate;
    }
	
	   
    /**
   * Unique identifier for the instance of Study.
   */

    private java.lang.String id;
    /**
   * Unique identifier for the instance of Study.
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The textual  identifier for the study.
   */

    private java.lang.String name;
    /**
   * The textual  identifier for the study.
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	
	   
    /**
   * The unique identifier for the study assigned by the study sponsoring organization. 
   * 
   */

    private java.lang.String sponsorStudyIdentifier;
    /**
   * The unique identifier for the study assigned by the study sponsoring organization. 
   * 
   */

	public  java.lang.String getSponsorStudyIdentifier(){
        return sponsorStudyIdentifier;
    }
    public void setSponsorStudyIdentifier( java.lang.String sponsorStudyIdentifier){
        this.sponsorStudyIdentifier = sponsorStudyIdentifier;
    }
	
	   
    /**
   * The date when the study was initiated
   */

    private java.util.Date startDate;
    /**
   * The date when the study was initiated
   */

	public  java.util.Date getStartDate(){
        return startDate;
    }
    public void setStartDate( java.util.Date startDate){
        this.startDate = startDate;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Study) {
				Study c =(Study)obj; 			 
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

	
	   
	   
	   
	      
      /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant> studyParticipantCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant>();
      /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant> getStudyParticipantCollection(){
        return studyParticipantCollection;
    }

	      
	               
	   
    public void setStudyParticipantCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.StudyParticipant> studyParticipantCollection){
        this.studyParticipantCollection = studyParticipantCollection;
    }
	   
	   
	
	   
	   
	   
	      
			
			
			
			
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.study.bean.Study study;
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.study.bean.Study getStudy(){
        return study;			
    }

	      
	               
	   

    public void setStudy(gov.nih.nci.caintegrator.domain.study.bean.Study study){
        this.study = study;
    }	
	   
	   
	
	   
	   
	   
	      
      /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Population> populationCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Population>();
      /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Population> getPopulationCollection(){
        return populationCollection;
    }

	      
	               
	   
    public void setPopulationCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Population> populationCollection){
        this.populationCollection = populationCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A chemical or biological substance with specific characteristics used in a study for treatment 
   * or prevention of cancer or another disease as specified by the protocol. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Agent> agentCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Agent>();
      /**
   * A chemical or biological substance with specific characteristics used in a study for treatment 
   * or prevention of cancer or another disease as specified by the protocol. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Agent> getAgentCollection(){
        return agentCollection;
    }

	      
	               
	   
    public void setAgentCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Agent> agentCollection){
        this.agentCollection = agentCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding> genoTypeFindingCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding>();
      /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding> getGenoTypeFindingCollection(){
        return genoTypeFindingCollection;
    }

	      
	               
	   
    public void setGenoTypeFindingCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.germline.bean.GenotypeFinding> genoTypeFindingCollection){
        this.genoTypeFindingCollection = genoTypeFindingCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Study> associatedStudyCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Study>();
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Study> getAssociatedStudyCollection(){
        return associatedStudyCollection;
    }

	      
	               
	   
    public void setAssociatedStudyCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Study> associatedStudyCollection){
        this.associatedStudyCollection = associatedStudyCollection;
    }
	   
	   
	
	   
	   
	   
	      
      /**
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel> snpPanelCollection = new HashSet<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel>();
      /**
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel> getSnpPanelCollection(){
        return snpPanelCollection;
    }

	      
	               
	   
    public void setSnpPanelCollection(Set<gov.nih.nci.caintegrator.domain.annotation.snp.bean.SNPPanel> snpPanelCollection){
        this.snpPanelCollection = snpPanelCollection;
    }
	   
	   
	

			
}