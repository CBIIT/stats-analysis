

package gov.nih.nci.caintegrator.domain.analysis.snp.bean;
import gov.nih.nci.caintegrator.domain.analysis.snp.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Representation of the analysis groups such as "CEPH Population" or "Non-Tumor Samples" 
   * 
   */

public  class SNPAnalysisGroup 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * Description of the grouping of subjects for analytical purposes
   */

    private String description;
    /**
   * Description of the grouping of subjects for analytical purposes
   */

	public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
	
	   
    /**
   * Unique identifier for the instance of AnalysisGroup.
   */

    private java.lang.Long id;
    /**
   * Unique identifier for the instance of AnalysisGroup.
   */

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
	   
    /**
   * Count of StudyParticipants that are part of this group.
   */

    private java.lang.Integer memberCount;
    /**
   * Count of StudyParticipants that are part of this group.
   */

	public  java.lang.Integer getMemberCount(){
        return memberCount;
    }
    public void setMemberCount( java.lang.Integer memberCount){
        this.memberCount = memberCount;
    }
	
	   
    /**
   * A textual identifier for the analysis group
   */

    private String name;
    /**
   * A textual identifier for the analysis group
   */

	public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof SNPAnalysisGroup) {
				SNPAnalysisGroup c =(SNPAnalysisGroup)obj; 			 
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
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */

    private gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis snpAssociationAnalysis;
      /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */

    public gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis getSnpAssociationAnalysis(){
        return snpAssociationAnalysis;			
    }

	      
	               
	   

    public void setSnpAssociationAnalysis(gov.nih.nci.caintegrator.domain.analysis.snp.bean.SNPAssociationAnalysis snpAssociationAnalysis){
        this.snpAssociationAnalysis = snpAssociationAnalysis;
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


    public String toString() {
        return "SNPAnalysisGroup{" +
                "name='" + name + '\'' +
                ", memberCount=" + memberCount +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}