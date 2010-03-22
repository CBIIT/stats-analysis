

package gov.nih.nci.caintegrator.domain.annotation.gene.bean;
import gov.nih.nci.caintegrator.domain.annotation.gene.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**
   * Genomic Annotations associated with a  Design Element 
   */

public  class GeneReporterAnnotation 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * The numeric or letter designation of a chromosome. Autosomes are usually indicated by numbers and 
   * sex chromosomes by letters. 
   * 
   */

    private java.lang.String chromosome;
    /**
   * The numeric or letter designation of a chromosome. Autosomes are usually indicated by numbers and 
   * sex chromosomes by letters. 
   * 
   */

	public  java.lang.String getChromosome(){
        return chromosome;
    }
    public void setChromosome( java.lang.String chromosome){
        this.chromosome = chromosome;
    }
	
	   
    /**
   * Chromosome Band Identifier 
   */

    private java.lang.String cytoband;
    /**
   * Chromosome Band Identifier 
   */

	public  java.lang.String getCytoband(){
        return cytoband;
    }
    public void setCytoband( java.lang.String cytoband){
        this.cytoband = cytoband;
    }
	
	   
    /**
   * The specific ending physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

    private java.lang.Long endPhysicalLocation;
    /**
   * The specific ending physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

	public  java.lang.Long getEndPhysicalLocation(){
        return endPhysicalLocation;
    }
    public void setEndPhysicalLocation( java.lang.Long endPhysicalLocation){
        this.endPhysicalLocation = endPhysicalLocation;
    }
	
	   
    /**
   * unique identifier for instance for GeneReporterAnnotation
   */

    private java.lang.String id;
    /**
   * unique identifier for instance for GeneReporterAnnotation
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	
	   
    /**
   * The specific starting physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

    private java.lang.Long startPhysicalLocation;
    /**
   * The specific starting physical location of the reporter on a chromosome, measured in base pairs 
   * 
   */

	public  java.lang.Long getStartPhysicalLocation(){
        return startPhysicalLocation;
    }
    public void setStartPhysicalLocation( java.lang.Long startPhysicalLocation){
        this.startPhysicalLocation = startPhysicalLocation;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof GeneReporterAnnotation) {
				GeneReporterAnnotation c =(GeneReporterAnnotation)obj; 			 
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