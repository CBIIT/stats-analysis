

package gov.nih.nci.caintegrator.domain.cgems.study;
import gov.nih.nci.caintegrator.domain.cgems.finding.variation.germline.GenotypeFinding;
import gov.nih.nci.caintegrator.domain.cgems.annotation.snp.SNPPanel;

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

public  class Study implements java.io.Serializable {

	private static final long serialVersionUID = 1234567890L;

    /**
   * The free text field of the type of study being conducted. (CTEP)
   */
    private String description;
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
	public  java.util.Date getEndDate(){
        return endDate;
    }
    public void setEndDate( java.util.Date endDate){
        this.endDate = endDate;
    }

    private String name;
	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	
    /**
   * The unique identifier for the study assigned by the study sponsoring organization. 
   * 
   */
    private java.lang.String sponsorStudyIdentifier;
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
	public  java.util.Date getStartDate(){
        return startDate;
    }
    public void setStartDate( java.util.Date startDate){
        this.startDate = startDate;
    }

    /**
   * DOCUMENT ME!
   */
   private java.lang.String id;
	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }

      /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */
    private Set <Population> populationCollection = new HashSet<Population>();

      public Set<Population> getPopulationCollection() {
          return populationCollection;
      }

      public void setPopulationCollection(Set<Population> populationCollection) {
          this.populationCollection = populationCollection;
      }

      public void addPop(Population p) {
          populationCollection.add(p);
      }

      /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular
   * Study.
   *
   */
    private Set <StudyParticipant> studyParticipantCollection = new HashSet<StudyParticipant>();
    public Set <StudyParticipant> getStudyParticipantCollection(){
        return studyParticipantCollection;
    }

    public void setStudyParticipantCollection(Set<StudyParticipant> studyParticipantCollection){
        this.studyParticipantCollection = studyParticipantCollection;
    }

   /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */
    private Study study;
    public Study getStudy(){
        return study;			
    }
    public void setStudy(Study study){
        this.study = study;
    }	

   /**
   * The result of performing a SNP assay resulting in two alleles measured from a diploid DNA sample for 
   * a given study. 
   * 
   */
    private Set <GenotypeFinding> genoTypeFindingCollection = new HashSet<GenotypeFinding>();
    public Set <GenotypeFinding> getGenoTypeFindingCollection(){
        return genoTypeFindingCollection;
    }
    public void setGenoTypeFindingCollection(Set<GenotypeFinding> genoTypeFindingCollection){
        this.genoTypeFindingCollection = genoTypeFindingCollection;
    }

   /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */
    private Set<Study> associatedStudyCollection = new HashSet<Study>();
    public Set <Study> getAssociatedStudyCollection(){
        return associatedStudyCollection;
    }
    public void setAssociatedStudyCollection(Set<Study> associatedStudyCollection){
        this.associatedStudyCollection = associatedStudyCollection;
    }

   /**
   * A set of SNP genotype assays, typically packaged and performed in a multiplex assay. 
   * 
   */
    private Set <SNPPanel> snpPanelCollection = new HashSet<SNPPanel>();
    public Set <SNPPanel> getSnpPanelCollection(){
        return snpPanelCollection;
    }

    public void setSnpPanelCollection(Set<SNPPanel> snpPanelCollection){
        this.snpPanelCollection = snpPanelCollection;
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
}