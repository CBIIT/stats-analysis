package gov.nih.nci.caintegrator.enumeration;

/**
 * @author sahnih
 *
 */
public enum MultiGroupComparisonAdjustmentType {
	/** Lists all the possible MultiGroup Comparison Adjustment Types used in 
	 * Class Comparion
	 */
	NONE , 
	FWER { 
		public String toString() 
		{ 
			return "Family-Wise Error Rate(FWER): Bonferroni";
		} },
	FDR {public String toString() 
		{ 
			return "False Discovery Rate(FDR): Benjamini-Hochberg";
		} }

};
