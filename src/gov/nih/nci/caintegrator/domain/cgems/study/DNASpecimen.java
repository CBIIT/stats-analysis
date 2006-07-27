

package gov.nih.nci.caintegrator.domain.cgems.study;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * A class containing information on the collection and processing of a DNA sample from one of the CGEMS 
   * subjects. 
   * 
   */

public  class DNASpecimen  extends Specimen implements java.io.Serializable {

	private static final long serialVersionUID = 1234567890L;

    /**
   * The method (if any) of amplifying DNA extracted from a biological source before being assayed for 
   * genotypes 
   * 
   */
    private String dnaAmplificationMethod;
	public String getDnaAmplificationMethod(){
        return dnaAmplificationMethod;
    }
    public void setDnaAmplificationMethod(String dnaAmplificationMethod){
        this.dnaAmplificationMethod = dnaAmplificationMethod;
    }

    /**
   * Chemical process or commercial product used to extract DNA from the source biological material 
   * 
   */
    private String dnaExtractionMethod;
	public String getDnaExtractionMethod(){
        return dnaExtractionMethod;
    }
    public void setDnaExtractionMethod(String dnaExtractionMethod){
        this.dnaExtractionMethod = dnaExtractionMethod;
    }

    /**
   * structural form of DNA comprising the sample. Possible values include GENOMIC, WGA (whole-genome 
   * amplified), MT (mitocondrial) 
   * 
   */
    private String dnaMaterialType;
	public String getDnaMaterialType(){
        return dnaMaterialType;
    }
    public void setDnaMaterialType(String dnaMaterialType){
        this.dnaMaterialType = dnaMaterialType;
    }

    public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof DNASpecimen) {
				DNASpecimen c =(DNASpecimen)obj; 			 
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
          String specimen = super.toString();
          return "Specimen: " + specimen + "\n" +
                  "DNASpecimen: {" +
                  ", dnaExtractionMethod='" + dnaExtractionMethod + '\'' +
                  ", dnaMaterialType='" + dnaMaterialType + '\'' +
                  " dnaAmplificationMethod='" + dnaAmplificationMethod + '\'' +
                  '}';
      }
  }