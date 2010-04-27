package gov.nih.nci.caintegrator.domain.finding.protein.ihc.bean;



import gov.nih.nci.caintegrator.domain.annotation.protein.bean.ProteinBiomarker;
import gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding;

import java.io.Serializable;

public class IHCFinding extends SpecimenBasedMolecularFinding implements
		Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1378755153599394619L;
	
	 /**
	 * IHCFinding is assoicated with ProteinBioMarker
	 */

	  private ProteinBiomarker proteinBiomarker;
	  
	  /**
	 * return proteinBiomarker 
	 * 
	 */

	  public ProteinBiomarker getProteinBiomarker(){
	      return proteinBiomarker;			
	  }	      
		               
		   

	  public void setProteinBiomarker(ProteinBiomarker proteinBiomarker){
	      this.proteinBiomarker = proteinBiomarker;
	  }	

		public boolean equals(Object obj){
					boolean eq = false;
					if(obj instanceof IHCFinding) {
						IHCFinding ihc =(IHCFinding)obj; 			 
						Long thisId = getId();		
						
							if(thisId != null && thisId.equals(ihc.getId())) {
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
