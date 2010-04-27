package gov.nih.nci.caintegrator.enumeration;

import java.io.Serializable;

public enum ArrayPlatformType implements Serializable{
AFFY_OLIGO_PLATFORM {
	public String toString()
	{ 
		return "Affymetrix Oligo Expression Arrays";
	}},
CDNA_ARRAY_PLATFORM {
	public String toString()
	{ 
		return "cDNA arrays";
	}},
ALL_PLATFROM {
	public String toString()
	{ 
		return "all";
	}},
ARRAY_CGH {
	public String toString()
	{ 
		return "ArrayCGH";
	}},
AFFY_100K_SNP_ARRAY {
		public String toString()
		{ 
			return "Affymetrix 100K SNP Arrays";
		}
	}
}