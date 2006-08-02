
package gov.nih.nci.caintegrator.domain.analysis.snp;

import gov.nih.nci.caintegrator.domain.study.StudyParticipant;

import java.util.Set;
import java.util.HashSet;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */

public  class SNPAnalysisGroup implements java.io.Serializable {

    private static final long serialVersionUID = 1234567890L;


    private Integer memberCount;

    public Integer getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(Integer memberCount) {
        this.memberCount = memberCount;
    }

   /**
   * Description of the grouping of subjects for analytical purposes
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
   * A textual identifier for the analysis group
   */
    private String name;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

   /**
   * A set of univeriate genetic analysie to detect association between phenotypic characteristics 
   * shared by groups of subjects and their genotypes at a series of SNP loci. 
   * 
   */
    private SNPAssociationAnalysis snpAssociationAnalysis;
    public SNPAssociationAnalysis getSnpAssociationAnalysis(){
        return snpAssociationAnalysis;
    }
    public void setSnpAssociationAnalysis(SNPAssociationAnalysis snpAssociationAnalysis){
        this.snpAssociationAnalysis = snpAssociationAnalysis;
    }

    /**
   * The treatment arm and other specifics regarding the participation of the Subject to a particular 
   * Study. 
   * 
   */
    private Set<StudyParticipant> studyParticipantCollection = new HashSet<StudyParticipant>();
    public Set <StudyParticipant> getStudyParticipantCollection(){
        return studyParticipantCollection;
    }
    public void setStudyParticipantCollection(Set<StudyParticipant> studyParticipantCollection){
        this.studyParticipantCollection = studyParticipantCollection;
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


    public String toString() {
        return "SNPAnalysisGroup{" +
                "description='" + description + "\n" +
                ", id=" + id + "\n" +
                ", name='" + name + "\n" +
                ", snpAssociationAnalysis=: "  + "\n" +
                ", studyParticipantCollection=: " +  
                '}';
    }
}