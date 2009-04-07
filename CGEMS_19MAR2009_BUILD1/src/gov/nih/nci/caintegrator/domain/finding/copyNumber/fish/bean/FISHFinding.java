package gov.nih.nci.caintegrator.domain.finding.copyNumber.fish.bean;




import gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding;

import java.io.Serializable;

public class FISHFinding extends  SpecimenBasedMolecularFinding implements
		Serializable {	
	
	// once modifying the specimencode, then we need to bring the bottom line back
	//public class FISHFinding extends SpecimenBasedMolecularFinding implements
	//Serializable {
	
	 /**
	   * Unique identifier  for the instance of SpecimenBasedMolecularFinding.
	   */

	    private java.lang.Long id;	    
	    
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1430480889468515405L;
	
	/**
	   * abnomalityStatus 
	   * 
	   */

	  private String abnomalityStatus;
	  
	  /**
	   * gene
	   */
	  private String gene;
	  
	  /**
	   * ratio
	   */
	  
	  private Double ratio;	               
		   

	 
	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAbnomalityStatus() {
		return abnomalityStatus;
	}

	public void setAbnomalityStatus(String abnomalityStatus) {
		this.abnomalityStatus = abnomalityStatus;
	}

	public String getGene() {
		return gene;
	}

	public void setGene(String gene) {
		this.gene = gene;
	}

	public java.lang.Long getId() {
		return id;
	}

	public void setId(java.lang.Long id) {
		this.id = id;
	}

	public Double getRatio() {
		return ratio;
	}

	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public boolean equals(Object obj){
			boolean eq = false;
					if(obj instanceof FISHFinding) {
						FISHFinding fish =(FISHFinding)obj; 			 
						Long thisId = getId();		
						
							if(thisId != null && thisId.equals(fish.getId())) {
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
