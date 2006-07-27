  package gov.nih.nci.caintegrator.domain.cgems.study;

  import gov.nih.nci.caintegrator.domain.cgems.finding.SpecimenBasedMolecularFinding;

  import java.io.Serializable;
  import java.util.HashSet;
  import java.util.Set;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
  
/**
 * A part of a thing, or of several things, removed to demonstrate or to determine the character of the
 * whole, e.g. a substance, or portion of material obtained for use in testing, examination, or study;
 * particularly, a preparation of tissue or bodily fluid taken for observation, examination or diagnosis.
 * NOTE: Can be a sample of a collection or biopsy. (arc relationship)
 *
 */

public  class Specimen  implements Serializable {

  private static final long serialVersionUID = 1234567890L;

  /**
 * Specifies the routine of gathering and/or locating the sites for body samples, such as, urine, blood,
 * biopsies, etc. to be used in the conduct of a clinical trial
 *
 */
  private java.lang.String collectionMethod;
  public  java.lang.String getCollectionMethod(){
      return collectionMethod;
  }
  public void setCollectionMethod( java.lang.String collectionMethod){
      this.collectionMethod = collectionMethod;
  }

  private java.lang.String id;
  public  java.lang.String getId(){
      return id;
  }
  public void setId( java.lang.String id){
      this.id = id;
  }

  /**
 * type of biological sample obtained from the subject.
 */
  private java.lang.String materialType;
  public  java.lang.String getMaterialType(){
      return materialType;
  }
  public void setMaterialType( String materialType){
      this.materialType = materialType;
  }

  /**
 * A unique sample, I.D. number
 */
  private java.lang.String specimenIdentifier;
  public  java.lang.String getSpecimenIdentifier(){
      return specimenIdentifier;
  }
  public void setSpecimenIdentifier( String specimenIdentifier){
      this.specimenIdentifier = specimenIdentifier;
  }

  private Set <SpecimenBasedMolecularFinding> specimenBasedMolecularFindingCollection = new HashSet<SpecimenBasedMolecularFinding>();
  public Set<SpecimenBasedMolecularFinding> getSpecimenBasedMolecularFindingCollection(){
      return specimenBasedMolecularFindingCollection;
  }
  public void setSpecimenBasedMolecularFindingCollection(Set<SpecimenBasedMolecularFinding> specimenBasedMolecularFindingCollection){
      this.specimenBasedMolecularFindingCollection = specimenBasedMolecularFindingCollection;
  }

 /**
 * The treatment arm and other specifics regarding the participation of the Subject to a particular
 * Study.
 *
 */
  private StudyParticipant studyParticipant;
  public StudyParticipant getStudyParticipant(){
      return studyParticipant;
  }
  public void setStudyParticipant(StudyParticipant studyParticipant){
      this.studyParticipant = studyParticipant;
  }
  private TimeCourse timeCourse;
  public TimeCourse getTimeCourse(){
      return timeCourse;
  }
  public void setTimeCourse(TimeCourse timeCourse){
      this.timeCourse = timeCourse;
  }

 public boolean equals(Object obj){
      boolean eq = false;
      if(obj instanceof Specimen) {
          Specimen c =(Specimen)obj;
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


    public String toString() {
        return "Specimen{" +
                "collectionMethod='" + collectionMethod + '\'' +
                ", id='" + id + '\'' +
                ", materialType='" + materialType + '\'' +
                ", specimenIdentifier='" + specimenIdentifier + '\'' +
                '}';
    }
}