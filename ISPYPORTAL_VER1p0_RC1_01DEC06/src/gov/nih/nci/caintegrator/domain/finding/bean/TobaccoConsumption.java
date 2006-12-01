

package gov.nih.nci.caintegrator.domain.finding.bean;
import gov.nih.nci.caintegrator.domain.finding.bean.*;
import java.util.*;

/**
 * <!-- LICENSE_TEXT_START -->
 * <!-- LICENSE_TEXT_END -->
 */
 
  /**

   */

public  class TobaccoConsumption 
    extends gov.nih.nci.caintegrator.domain.finding.bean.EpidimeologicalFinding


	implements java.io.Serializable 
{

	private static final long serialVersionUID = 1234567890L;


 	
	   
    /**
   * DOCUMENT ME!
   */

    private char Smoking_Status;
    /**
   * DOCUMENT ME!
   */

	public char getSmoking_Status(){
        return Smoking_Status;
    }
    public void setSmoking_Status(char Smoking_Status){
        this.Smoking_Status = Smoking_Status;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private int YearsQuit;
    /**
   * DOCUMENT ME!
   */

	public int getYearsQuit(){
        return YearsQuit;
    }
    public void setYearsQuit(int YearsQuit){
        this.YearsQuit = YearsQuit;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private int PackYears;
    /**
   * DOCUMENT ME!
   */

	public int getPackYears(){
        return PackYears;
    }
    public void setPackYears(int PackYears){
        this.PackYears = PackYears;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private long nicotineLevel;
    /**
   * DOCUMENT ME!
   */

	public long getNicotineLevel(){
        return nicotineLevel;
    }
    public void setNicotineLevel(long nicotineLevel){
        this.nicotineLevel = nicotineLevel;
    }
	
	   
    /**
   * DOCUMENT ME!
   */

    private int cotinineLevel;
    /**
   * DOCUMENT ME!
   */

	public int getCotinineLevel(){
        return cotinineLevel;
    }
    public void setCotinineLevel(int cotinineLevel){
        this.cotinineLevel = cotinineLevel;
    }
	


		public boolean equals(Object obj){
			boolean eq = false;
			if(obj instanceof TobaccoConsumption) {
				TobaccoConsumption c =(TobaccoConsumption)obj; 			 
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