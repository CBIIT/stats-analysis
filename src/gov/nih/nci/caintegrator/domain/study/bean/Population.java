

package gov.nih.nci.caintegrator.domain.study.bean;
import gov.nih.nci.caintegrator.domain.study.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Groups of subjects based on self-described ethnic groupings and phenotypic ascertainment scheme. 
   * 
   */

public  class Population 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Description of the study population.
   */

    private java.lang.String description;
    /**
   * Description of the study population.
   */

	public  java.lang.String getDescription(){
        return description;
    }
    public void setDescription( java.lang.String description){
        this.description = description;
    }
	
	   
    /**
   * Unique identifier for the instance of Population.
   */

    private java.lang.Long id;
    /**
   * Unique identifier for the instance of Population.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * Count of StudyParticipants that are part of this population.
   */

    private java.lang.Integer memberCount;
    /**
   * Count of StudyParticipants that are part of this population.
   */

	public  java.lang.Integer getMemberCount(){
        return memberCount;
    }
    public void setMemberCount( java.lang.Integer memberCount){
        this.memberCount = memberCount;
    }
	
	   
    /**
   * A textual identifier for the study population.
   */

    private java.lang.String name;
    /**
   * A textual identifier for the study population.
   */

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }
	
	   
    /**
   * The source attribution for information and biological samples for a study population 
   * 
   */

    private String source;
    /**
   * The source attribution for information and biological samples for a study population 
   * 
   */

	public String getSource(){
        return source;
    }
    public void setSource(String source){
        this.source = source;
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

	
	   
	   
	   
	      
      /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */

    private Set <gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding> snpFrequencyCollection = new HashSet<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding>();
      /**
   * A class describing counts and characteristics of alleles and genotypes for SNP polymorphisms observed 
   * in a CGEMS population. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding> getSnpFrequencyCollection(){
        return snpFrequencyCollection;
    }

	      
	               
	   
    public void setSnpFrequencyCollection(Set<gov.nih.nci.caintegrator.domain.finding.variation.snpFrequency.bean.SNPFrequencyFinding> snpFrequencyCollection){
        this.snpFrequencyCollection = snpFrequencyCollection;
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

    private Set <gov.nih.nci.caintegrator.domain.study.bean.Study> studyCollection = new HashSet<gov.nih.nci.caintegrator.domain.study.bean.Study>();
      /**
   * A type of research activity that tests how well new medical treatments or other interventions work 
   * in subjects. Such plans test new methods of screening, prevention, diagnosis or treatment of a disease. 
   * The specific plans are fully defined in the protocol and may be carried out in a clinic or other medical 
   * facility. 
   * 
   */

    public Set <gov.nih.nci.caintegrator.domain.study.bean.Study> getStudyCollection(){
        return studyCollection;
    }

	      
	               
	   
    public void setStudyCollection(Set<gov.nih.nci.caintegrator.domain.study.bean.Study> studyCollection){
        this.studyCollection = studyCollection;
    }


    public String toString() {
        return "Population{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", memberCount=" + memberCount +
                ", name='" + name + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}