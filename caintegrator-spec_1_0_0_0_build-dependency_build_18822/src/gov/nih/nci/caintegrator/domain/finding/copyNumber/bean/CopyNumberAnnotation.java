

package gov.nih.nci.caintegrator.domain.finding.copyNumber.bean;
import gov.nih.nci.caintegrator.domain.finding.copyNumber.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**

   */

public  class CopyNumberAnnotation 


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String Marker;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getMarker(){
        return Marker;
    }
    public void setMarker( java.lang.String Marker){
        this.Marker = Marker;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String dbSNP;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getDbSNP(){
        return dbSNP;
    }
    public void setDbSNP( java.lang.String dbSNP){
        this.dbSNP = dbSNP;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.Integer Position;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.Integer getPosition(){
        return Position;
    }
    public void setPosition( java.lang.Integer Position){
        this.Position = Position;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String Chromosome;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getChromosome(){
        return Chromosome;
    }
    public void setChromosome( java.lang.String Chromosome){
        this.Chromosome = Chromosome;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private java.lang.String id;
    /**
   * DOCUMENT ME!
   */

	public  java.lang.String getId(){
        return id;
    }
    public void setId( java.lang.String id){
        this.id = id;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof CopyNumberAnnotation) {
				CopyNumberAnnotation c =(CopyNumberAnnotation)obj; 			 
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