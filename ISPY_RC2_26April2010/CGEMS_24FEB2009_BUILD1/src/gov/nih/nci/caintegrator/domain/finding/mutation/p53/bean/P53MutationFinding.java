package gov.nih.nci.caintegrator.domain.finding.mutation.p53.bean;

import gov.nih.nci.caintegrator.domain.finding.bean.SpecimenBasedMolecularFinding;

import java.io.Serializable;

public class P53MutationFinding extends SpecimenBasedMolecularFinding implements Serializable {

	
	private static final long serialVersionUID = -5928581409456939265L;
	
	private java.lang.Long id;	 
	private String mutationStatus;
	private String mutationType;
	private String exonOrIntronLocation;
	private String baseChange;
	private String codonAminoacidChange;
	private String proteinStructuralDomain;
	


    public java.lang.Long getId() {
	    return id;
     }


    public void setId(java.lang.Long id) {
	    this.id = id;
     }

	
   	public String getMutationStatus() {
		return mutationStatus;
	}


	public void setMutationStatus(String mutationStatus) {
		this.mutationStatus = mutationStatus;
	}


	public String getMutationType() {
		return mutationType;
	}


	public void setMutationType(String mutationType) {
		this.mutationType = mutationType;
	}


	public String getExonOrIntronLocation() {
		return exonOrIntronLocation;
	}


	public void setExonOrIntronLocation(String exonOrIntronLocation) {
		this.exonOrIntronLocation = exonOrIntronLocation;
	}


	public String getBaseChange() {
		return baseChange;
	}


	public void setBaseChange(String baseChange) {
		this.baseChange = baseChange;
	}


	public String getCodonAminoacidChange() {
		return codonAminoacidChange;
	}


	public void setCodonAminoacidChange(String codonAminoacidChange) {
		this.codonAminoacidChange = codonAminoacidChange;
	}


	public String getProteinStructuralDomain() {
		return proteinStructuralDomain;
	}


	public void setProteinStructuralDomain(String proteinStructuralDomain) {
		this.proteinStructuralDomain = proteinStructuralDomain;
	}




	public boolean equals(Object obj){
		boolean eq = false;
		if(obj instanceof P53MutationFinding) {
			P53MutationFinding c =(P53MutationFinding)obj; 			 
			Long thisId = getId();		
			
				if(thisId != null && thisId.equals(c.getId())) {
				   eq = true;
			    }		
			
		}
		return eq;
	}
	
    public int hashCode() {
		int h = 0;

		if (getId() != null) {
			h += getId().hashCode();
		}

		return h;
	}
	

}
