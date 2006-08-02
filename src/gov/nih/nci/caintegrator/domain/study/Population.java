

package gov.nih.nci.caintegrator.domain.study;

import java.util.Set;
import java.util.HashSet;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

public  class Population implements java.io.Serializable {

	private static final long serialVersionUID = 1234567890L;

    private Integer memberCount;

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

   /**
   * Description of the study population
   */
    private String description;

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }

    /**
   * Unique identifier
   */
    private java.lang.Long id;
	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
    /**
   * A textual identifier for the study population
   */
    private String name;
	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	
    /**
   * The source attribution for information and biological samples for a study population 
   * 
   */
    private String source;
	public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source = source;
    }

   /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */
   private Set<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.SNPFrequencyFinding> snpFrequencyCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.SNPFrequencyFinding>();
   public Set <gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.SNPFrequencyFinding> getSnpFrequencyCollection(){
        return snpFrequencyCollection;
   }
   public void setSnpFrequencyCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.SNPFrequencyFinding> snpFrequencyCollection){
        this.snpFrequencyCollection = snpFrequencyCollection;
   }

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
    private Set <Study> studyCollection = new HashSet<Study>();
    public Set <Study> getStudyCollection(){
        return studyCollection;
    }
    public void setStudyCollection(Set<Study> studyCollection){
        this.studyCollection = studyCollection;
    }

    public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof Population) {
				Population c =(Population)obj; 			 
				Long thisId = getId();		
				
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


      public String toString() {
          return "Population{" +
                  "description='" + description + '\'' +
                  ", id=" + id +
                  ", name='" + name + '\'' +
                  ", source='" + source + "}";
                 
      }
  }