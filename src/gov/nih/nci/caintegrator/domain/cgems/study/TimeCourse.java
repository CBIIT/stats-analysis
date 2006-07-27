package gov.nih.nci.caintegrator.domain.cgems.study;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
public  class TimeCourse implements java.io.Serializable {

	private static final long serialVersionUID = 1234567890L;

    private java.lang.Long id;

	public  java.lang.Long getId(){
        return id;
    }
    public void setId( java.lang.Long id){
        this.id = id;
    }
	
    private java.lang.String name;

	public  java.lang.String getName(){
        return name;
    }
    public void setName( java.lang.String name){
        this.name = name;
    }

   /**
   * The result of examination of tissues under the microscope to assist diagnosis of tumors. For example,
   * after a biopsy is performed, a pathologist will perform a "histological" evaluation, which means
   * the tissue collected will be analyzed for any abnormalities.
   *
   */

    private Histology histology;
      /**
   * The result of examination of tissues under the microscope to assist diagnosis of tumors. For example, 
   * after a biopsy is performed, a pathologist will perform a "histological" evaluation, which means 
   * the tissue collected will be analyzed for any abnormalities. 
   * 
   */

    public Histology getHistology(){
        return histology;			
    }

    public void setHistology(Histology histology){
        this.histology = histology;
    }

  public boolean equals(Object obj){
        boolean eq = false;
        if(obj instanceof TimeCourse) {
            TimeCourse c =(TimeCourse)obj;
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
}